package movieTicketing;

import java.util.List;
import java.util.Scanner;

public class MovieTicketingJH implements Runnable {

	String[] option = { "예매", "취소", "예매조회", "영화조회", "금액" };
	String[] title = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "모가디슈", "위플래쉬", "극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들",
			"샹치와 텐링즈의 전설", "나의흑역사로맨티카", "운디네", "(월간오페라)아틸라" };
	String[] kindsYongsan = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "샹치와 텐링즈의 전설", "모가디슈", "위플래쉬",
			"극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들" };
	String[] kindsApgujung = { "007 노 타임 투 다이", "보이스", "기적", "모가디슈", "위플래쉬", "나의흑역사로맨티카", "운디네" };
	String[] kindsSongpa = { "007 노 타임 투 다이", "보이스", "기적", "샹치와 텐링즈의 전설", "(월간오페라)아틸라" };
	String[] kindsYoungdungpo = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "모가디슈", "(월간오페라)아틸라" };
	String[] cinemaName = { "용산아이파크몰", "압구정", "송파", "영등포" };
	String[] cinema = { "Business", "PREMIUM", "GOLD CLASS", "4DX", "IMAX" };
	Scanner scan = new Scanner(System.in);

	Business busi = new Business();
	FourDX four = new FourDX();
	GoldClass gold = new GoldClass();
	IMAX imax = new IMAX();
	Premium pre = new Premium();
	
	public void run() {

		System.out.println("-----------------------------");
		System.out.println("사용하실 기능의 번호를 입력해주세요");
		for (int i = 0; i < option.length; i++) {
			System.out.println((i + 1) + ". " + option[i]);
		}
		int optionCheck = scan.nextInt();
		
		switch (optionCheck) {
		case 1:
			System.out.println("예매하실 CGV의 위치를 선택해주세요");
			for (int i = 0; i < cinemaName.length; i++) {
				System.out.println((i + 1) + ". " + cinemaName[i]);
			}
			int cinemaNameCheck = scan.nextInt(); //cgv 위치 체크
			System.out.println("-----------------------------");
			
			switch (cinemaNameCheck) {
			case 1: // 용산
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsYongsan.length; i++) {
					System.out.println((i + 1) + ". " + kindsYongsan[i]);
				}
				int yongsanTitleCheck = scan.nextInt(); // 용산에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				
				switch (yongsanTitleCheck) {
				case 1: //007
					System.out.println("예매하실 상영관을 선택해주세요");
					for(int i = 0; i < cinema.length; i++) {
						System.out.println((i + 1) + ". "+cinema[i]);
					}
					int yongsanCinemaCheck = scan.nextInt();
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 1: 
						System.out.println("예매하실 시간을 선택해주세요");
						break;
					}
					break;
				case 2: //수색자
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. "+cinema[0]); //Business
					break;
				case 3: //보이스
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. "+cinema[0]);
					System.out.println("2. "+cinema[1]);
					break;
				case 4: //기적
					System.out.println("예매하실 상영관을 선택해주세요");
					
					break;
				case 5: //샹치
					System.out.println("예매하실 상영관을 선택해주세요");
					
					break;
				case 6: //모가디슈
					System.out.println("예매하실 상영관을 선택해주세요");
					
					break;
				case 7: //위플래쉬
					System.out.println("예매하실 상영관을 선택해주세요");
					
					break;
				case 8: //짱구
					System.out.println("예매하실 상영관을 선택해주세요");
					
					break;
					
				}
				break;
			case 2: // 압구정
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsApgujung.length; i++) {
					System.out.println((i + 1) + ". " + kindsApgujung[i]);
				}
				int apgujungTitleCheck = scan.nextInt(); // 압구정에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				
				break;
			case 3: // 송파
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsSongpa.length; i++) {
					System.out.println((i + 1) + ". " + kindsSongpa[i]);
				}
				int songpaTitleCheck = scan.nextInt(); // 송파에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				
				break;
			case 4: // 영등포
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsYoungdungpo.length; i++) {
					System.out.println((i + 1) + ". " + kindsYoungdungpo[i]);
				}
				int youngdungpoTitleCheck = scan.nextInt(); // 용산에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				
				break;
			}
			break;
		case 2:

			break;

		case 3:

			break;

//			-------------------------4. 영화조회

		case 4:
			System.out.println("조회하실 영화의 번호를 입력해주세요.");
			for (int i = 0; i < title.length; i++) {
				System.out.println((i + 1) + ". " + title[i]);
			}
			int infoCheck = scan.nextInt();
			switch (infoCheck) {
			case 1:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 캐리 후쿠나가 / 배우 : 다니엘 크레이그 ,  라미 말렉 ,  라샤나 린치 ,  레아 세이두");
				System.out.println("장르 : 액션 / 기본 : 12세 이상, 163분, 미국, 영국");
				System.out.println("개봉 : 2021.09.29");
				break;
			case 2:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 김민섭 / 배우 : 송창의 ,  송영규 ,  장해송 ,  도은비 ,  김지웅 ,  김영재");
				System.out.println("장르 : 스릴러 / 기본 : 15세 이상, 111분, 한국");
				System.out.println("개봉 : 2021.09.29");
				break;
			case 3:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 김선 ,  김곡 / 배우 : 변요한 ,  김무열 ,  김희원 ,  박명훈");
				System.out.println("장르 : 범죄, 액션 / 기본 : 15세 이상, 109분, 한국");
				System.out.println("개봉 : 2021.09.15");
				break;
			case 4:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 이장훈 / 배우 : 박정민 ,  이성민 ,  임윤아 ,  이수경");
				System.out.println("장르 : 드라마 / 기본 : 12세 이상, 117분, 한국");
				System.out.println("개봉 : 2021.09.15");
				break;
			case 5:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 류승완 / 배우 : 김윤석 ,  조인성 ,  허준호 ,  구교환 ,  김소진 ,  정만식");
				System.out.println("장르 : 액션, 드라마 / 기본 : 15세 이상, 121분, 한국");
				System.out.println("개봉 : 2021.07.28");
				break;
			case 6:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 데이미언 셔젤 / 배우 : 마일즈 텔러 ,  J.K. 시몬스");
				System.out.println("장르 : 드라마 / 기본 : 15세 이상, 106분, 미국");
				System.out.println("개봉 : 2021.09.29(재개봉)");
				break;
			case 7:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 쿄고쿠 타카히코 / 배우 : 박영남 ,  김환진 ,  강희선 ,  여민정 ,  정유미 ,  강새봄 ,  정혜옥 ,  시영준");
				System.out.println("장르 : 애니메이션 / 기본 : 전체, 103분, 일본");
				System.out.println("개봉 : 2021.09.15");
				break;
			case 8:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 데스틴 크리튼 / 배우 : 시무 리우 ,  양조위 ,  아콰피나 ,  장멍 ,  양자경 ,  로니 쳉 ,  진법랍 ,  플로리안 문테아누");
				System.out.println("장르 : 액션 / 기본 : 12세 이상, 132분, 미국, 오스트레일리아");
				System.out.println("개봉 : 2021.09.01");
				break;
			case 9:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 알리체 필리피 / 배우 : 루도비카 프란체스코니 ,  주세페 마조");
				System.out.println("장르 : 로맨스, 멜로, 코미디 / 기본 : 12세 이상, 91분, 이탈리아");
				System.out.println("개봉 : 2021.09.22");
				break;
			case 10:
				System.out.println(title[infoCheck - 1]);
				System.out.println("감독 : 크리스티안 펫졸드 / 배우 : 폴라 비어 ,  프란츠 로고스키");
				System.out.println("장르 : 드라마 / 기본 : 12세 이상, 090분, 독일, 프랑스");
				System.out.println("개봉 : 2020.12.24");
				break;
			case 11:
				System.out.println(title[infoCheck - 1]);
				System.out.println("장르 :  / 기본 : 전체, 151분, ");
				System.out.println("개봉 : 2021.10.01");
				break;
			}
			break;

//			-------------------------4. 금액

		case 5:
			System.out.println("조회하실 상영관의 번호를 선택해주세요");
			for (int i = 0; i < cinema.length; i++) {
				System.out.println((i + 1) + ". " + cinema[i]);
			}
			int priceCheck = scan.nextInt();
			switch (priceCheck) {
			case 1:
				System.out.println(cinema[priceCheck - 1] + "관 예매 금액");
				System.out.println("일반: 13,000원");
				System.out.println("청소년: 10,000");
				System.out.println("경로: 6,000원");
				System.out.println("우대: 5,000원");
				break;
			case 2:
				System.out.println(cinema[priceCheck - 1] + "관 예매 금액");
				System.out.println("일반: 25,000원");
				System.out.println("청소년: 20,000");
				System.out.println("경로 및 우대 선택이 불가능한 상영관입니다");
				break;
			case 3:
				System.out.println(cinema[priceCheck - 1] + "관 예매 금액");
				System.out.println("일반: 35,000원");
				System.out.println("청소년: 30,000");
				System.out.println("경로 및 우대 선택이 불가능한 상영관입니다");
				break;
			case 4:
				System.out.println(cinema[priceCheck - 1] + "관 예매 금액");
				System.out.println("일반: 20,000원");
				System.out.println("청소년: 14,000");
				System.out.println("경로: 13,000원");
				System.out.println("우대: 13,000원");
				break;
			case 5:
				System.out.println(cinema[priceCheck - 1] + "관 예매 금액");
				System.out.println("일반: 19,000원");
				System.out.println("청소년: 15,000");
				System.out.println("경로 및 우대 선택이 불가능한 상영관입니다");
				break;
			}
			break;
		}
	}
}
