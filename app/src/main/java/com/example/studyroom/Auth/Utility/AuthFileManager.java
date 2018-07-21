package com.example.studyroom.Auth.Utility;

import android.Manifest;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 남대영 on 2018-07-09.
 */

public class AuthFileManager {

    /**
    *
    * @usage 회원가입시 Map에 회원정보들을 넣어놓고 save() 함수를 호출합니다.
    *
    * */

    private static AuthFileManager instance;
    private Context context;
    private boolean isWrited; /* 입력된 데이터가 있는지 */
    private Map<String, String> data = new HashMap<>();

    private AuthFileManager() {}

    public static AuthFileManager getFileMnager() {
        if(instance == null) instance = new AuthFileManager();
        return instance;
    }

    /**
     *  스플래쉬 화면에서 initialize 합니다.
     *  */
    public void initialize(Context context) throws IOException {
        this.context = context;
        String data = readFile();
        this.isWrited = data != null && !data.equals("");

        if(isWrited) {
            this.data = new AuthSerialize(data).deserialize();
        }
    }

    /**
     * 저장된 데이터들을 읽어옵니다.
     * */
    private String readFile() throws IOException {
        if(!context.getFilesDir().exists())
            context.getFilesDir().mkdir();

        File file = new File(context.getFilesDir(), "auth.yml");
        if(!file.exists())
            file.createNewFile();

        StringBuilder builder = new StringBuilder();
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String data;
        if((data = reader.readLine()) != null) {
            builder.append(data);
        }

        reader.close();
        return builder.toString();
    }

    /**
     * 데이터들을 저장합니다.
     * */
    public void save() {
        String serial = new AuthSerialize(data).serialize();

        FileOutputStream fos = null;
        File file = new File(context.getFilesDir(), "auth.yml");
        try {
            fos = new FileOutputStream(file);
            fos.write(serial.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) { return this.data.get(key); }
    public void input(String key, String value) { this.data.put(key, value); }
    public boolean isWrited() { return this.isWrited; }

}
