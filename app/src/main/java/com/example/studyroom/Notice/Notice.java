package com.example.studyroom.Notice;

public class Notice {

/*
@Update UserFragment class 생성, frag_user 생성
@author kim
@since 2018. 6. 9. PM 12:26
*/

/*
@Update LoginActivity 수정, drawable btn_boarder, textview_underline 생성, strings u6nderline_register_textview 생성
@author 남대영
@since 2018-06-09 오후 12:35
*/


/*
@Update ReservationActivity 수정, RoomListAdapter 수정, activity_reservation.xml 수정, ReserveToModel 생성, ReserveHistoryModel 생성
        ReservaHistoryDetailAcitivity 생성, ReservationHistoryAdapter 생성
        Drawable 편의시설 이미지 생성,
        데이터모델 전체수정 (구조가 너무 복잡합니다 기업과 고객을 따로 생각하려니)

구조 -  메인 프래그, 예약 프래그, 내정보 프래그
     -  메인 프래그먼트 >> 메인 프래그먼트에서 룸 아이템 클릭 >> DetailActivity >> DetailActivity에서 예약하기 클릭 >> ReservationActivity >> 결제하기
     -  예약 프래그먼트 >> item 클릭 >> ReserveHistoryDetailActivity
        (어차피 스터디룸 예약자체를 한번에 여러군데 하는 사람은 없을 것 같기에 ReserveHistoryDetailActivity 에 보여줄 것들을
        그냥 item에 넣고 액티비티를 줄이는 것은 어떨지)




데이터 형식 (Collection > Document > Collection > Document > Field
    - 결제하기 >> Reservation > Arbitrary value > ToUser > Arbitrary value > Field
                                                > ToCompany > Arbitrary value > Field
                  User > userUid > companyUid > Field
                  Company > companyUid > userUid > Field

갑자기 내려가게돼서 어질러만 놓고 가네요ㅠ 죄송합니다

@auther 황준홍
@since 2018. 7. 18. PM 9:30
*/

}

