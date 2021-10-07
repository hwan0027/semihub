package movieTicketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class MovieTicketingJH implements Runnable {
	
	

	String[] option = { "예매", "취소", "예매조회", "금액" };
	String[] title = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "모가디슈", "위플래쉬", "극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들",
			"샹치와 텐링즈의 전설" };
	String[] kindsYongsan = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "샹치와 텐링즈의 전설", "모가디슈", "위플래쉬",
			"극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들" };
	String[] kindsApgujung = { "007 노 타임 투 다이", "보이스", "기적", "모가디슈", "위플래쉬" };
	String[] kindssongpa = { "007 노 타임 투 다이", "보이스", "기적", "샹치와 텐링즈의 전설" };
	String[] kindsYoungdungpo = { "007 노 타임 투 다이", "수색자", "보이스", "기적", "모가디슈" };
	String[] cinemaName = { "용산아이파크몰", "압구정", "송파", "영등포" };
	String[] cinema = { "Business", "PREMIUM", "GOLD CLASS", "4DX", "IMAX" };

	String[] age = { "일반", "청소년", "우대", "경로" };
	int cnt = 0;
	int cntNormal = 0;
	int cntYoung = 0;
	int cntold = 0;
	int cntPre = 0;
	int ageRepeat = 0;
	int priceSum = 0;
	String seatCheck = "Y";

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
		int optionCheck = scan.nextInt() - 1;

		switch (optionCheck) {
		case 0:
			System.out.println("예매하실 CGV의 위치를 선택해주세요");
			for (int i = 0; i < cinemaName.length; i++) {
				System.out.println((i + 1) + ". " + cinemaName[i]);
			}
			int cinemaNameCheck = scan.nextInt() - 1; // cgv 위치 체크
			System.out.println("-----------------------------");

			switch (cinemaNameCheck) {
			case 0: // 용산
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsYongsan.length; i++) {
					System.out.println((i + 1) + ". " + kindsYongsan[i]);
				}
				int yongsanTitleCheck = scan.nextInt() - 1; // 용산에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");

				switch (yongsanTitleCheck) {
				case 0: // 007
					System.out.println("예매하실 상영관을 선택해주세요");
					for (int i = 0; i < cinema.length; i++) {
						System.out.println((i + 1) + ". " + cinema[i]);
					}
					int yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "12관 13:20", "13관 12:40", "13관 15:50", "13관 19:00", "17관 10:30",
								"17관 13:50", "17관 17:00" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;

					case 1:// "PREMIUM"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanPre = { "17관 10:30", "17관 13:50", "17관 17:00", };
						for (int i = 0; i < YongsanPre.length; i++) {
							System.out.println((i + 1) + ". " + YongsanPre[i]);
						}
						int YongsanPreCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							pre.sysoutPre();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 번호를 입력해주세요");
							int yull = scan.nextInt();
							pre.setSeat(yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 25000;
								break;
							case 2:
								priceSum += 20000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanPre[YongsanPreCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;
					case 2:// "GOLD CLASS"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanGold = { "GOLD CLASS 9:15", "GOLD CLASS 12:25", "GOLD CLASS 15:35",
								"GOLD CLASS 18:50" };
						for (int i = 0; i < YongsanGold.length; i++) {
							System.out.println((i + 1) + ". " + YongsanGold[i]);
						}
						int YongsanGoldCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							gold.sysoutGoldClass();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열를 입력해주세요");
							int yull = scan.nextInt();
							gold.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 35000;
								break;
							case 2:
								priceSum += 30000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanGold[YongsanGoldCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;
					case 3:// "4DX"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanFourDX = { "4DX관 8:30", "4DX관 11:50", "4DX관 15:10", "4DX관 18:30" };
						for (int i = 0; i < YongsanFourDX.length; i++) {
							System.out.println((i + 1) + ". " + YongsanFourDX[i]);
						}
						int YongsanFourDXCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							four.sysoutFourDX();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열를 입력해주세요");
							int yull = scan.nextInt();
							four.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 20000;
								break;
							case 2:
								priceSum += 14000;
								break;
							case 3:
								priceSum += 13000;
								break;
							case 4:
								priceSum += 13000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanFourDX[YongsanFourDXCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");

						break;
					case 4:// "IMAX"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanIMAX = { "IMAX관 8:30", "IMAX관 11:50", "IMAX관 15:10", "IMAX관 18:30" };
						for (int i = 0; i < YongsanIMAX.length; i++) {
							System.out.println((i + 1) + ". " + YongsanIMAX[i]);
						}
						int YongsanIMAXCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							pre.sysoutPre();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 번호를 입력해주세요");
							int yull = scan.nextInt();
							pre.setSeat(yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 19000;
								break;
							case 2:
								priceSum += 15000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanIMAX[YongsanIMAXCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");

						break;
					}
					break;
				case 1: // 수색자
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "2관 15:15", "2관 19:35", "6관 11:35", "6관 16:25" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;

				case 2: // 보이스
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "1관 8:20", "1관 10:40", "1관 13:00", "1관 15:20", "1관 17:40", "6관 9:20",
								"6관 14:00" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;

				case 3: // 기적
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					System.out.println("2. " + cinema[1]); // Premium
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "13관 19:40", "7관 8:00", "5관 8:50", "5관 11:15", "5관 16:05",
								"5관 18:30" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindsYongsan[yongsanTitleCheck] + " 입니다");
							System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}

						break;
					case 1:// "PREMIUM"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanPre = { "17관 8:00" };
						for (int i = 0; i < YongsanPre.length; i++) {
							System.out.println((i + 1) + ". " + YongsanPre[i]);
						}
						int YongsanPreCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							pre.sysoutPre();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 번호를 입력해주세요");
							int yull = scan.nextInt();
							pre.setSeat(yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 25000;
								break;
							case 2:
								priceSum += 20000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanPre[YongsanPreCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 4: // 샹치
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "18관 10:15", "18관 16:55", "18관 19:35" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 5: // 모가디슈
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "1관 8:20", "1관 10:40", "1관 13:00", "1관 15:20", "1관 17:40", "6관 9:20",
								"6관 14:00" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 6: // 위플래쉬
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "1관 8:20", "1관 10:40", "1관 13:00", "1관 15:20", "1관 17:40", "6관 9:20",
								"6관 14:00" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 7: // 짱구
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					yongsanCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (yongsanCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] YongsanBusi = { "1관 8:20", "1관 10:40", "1관 13:00", "1관 15:20", "1관 17:40", "6관 9:20",
								"6관 14:00" };
						for (int i = 0; i < YongsanBusi.length; i++) {
							System.out.println((i + 1) + ". " + YongsanBusi[i]);
						}
						int YongsanBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYongsan[yongsanTitleCheck] + " 입니다");
						System.out.println(YongsanBusi[YongsanBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				}

				break;
			case 1: // 압구정
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsApgujung.length; i++) {
					System.out.println((i + 1) + ". " + kindsApgujung[i]);
				}
				int apgujungTitleCheck = scan.nextInt() - 1; // 압구정에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				switch (apgujungTitleCheck) {
				case 0: // 007
					System.out.println("예매하실 상영관을 선택해주세요");
					for (int i = 0; i < 2; i++) {
						System.out.println((i + 1) + ". " + cinema[i]);
					}
					int ApgujungCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (ApgujungCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] ApgujungBusi = { "1관B2층 12:40", "1관B2층 15:50", "1관B2층 19:00", "2관B2층 10:40",
								"2관B2층 13:50" };
						for (int i = 0; i < ApgujungBusi.length; i++) {
							System.out.println((i + 1) + ". " + ApgujungBusi[i]);
						}
						int ApgujungBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(ApgujungBusi[ApgujungBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;

					case 1:// "PREMIUM"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] ApgujungPre = { "1관B1층 12:40", "1관B1층 15:50", "1관B1층 19:00" };
						for (int i = 0; i < ApgujungPre.length; i++) {
							System.out.println((i + 1) + ". " + ApgujungPre[i]);
						}
						int ApgujungPreCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							pre.sysoutPre();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 번호를 입력해주세요");
							int yull = scan.nextInt();
							pre.setSeat(yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 25000;
								break;
							case 2:
								priceSum += 20000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(ApgujungPre[ApgujungPreCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;
					}
					break;
				case 1: // 보이스
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					ApgujungCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (ApgujungCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] ApgujungBusi = { "1관B2층 10:20" };
						for (int i = 0; i < ApgujungBusi.length; i++) {
							System.out.println((i + 1) + ". " + ApgujungBusi[i]);
						}
						int ApgujungBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(ApgujungBusi[ApgujungBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;

				case 2: // 기적
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					ApgujungCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (ApgujungCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] ApgujungBusi = { "3관4층 11:00", "3관4층 15:30" };
						for (int i = 0; i < ApgujungBusi.length; i++) {
							System.out.println((i + 1) + ". " + ApgujungBusi[i]);
						}
						int ApgujungBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(ApgujungBusi[ApgujungBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 3: // 모가디슈
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					ApgujungCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (ApgujungCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] apgujungBusi = { "3관 본관 4층 15:15" };
						for (int i = 0; i < apgujungBusi.length; i++) {
							System.out.println((i + 1) + ". " + apgujungBusi[i]);
						}
						int apgujungBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(apgujungBusi[apgujungBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 4: // 위플래쉬
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					ApgujungCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (ApgujungCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] apgujungBusi = { "ART1관 16:20", "ART3관 12:05" };
						for (int i = 0; i < apgujungBusi.length; i++) {
							System.out.println((i + 1) + ". " + apgujungBusi[i]);
						}
						int apgujungBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsApgujung[apgujungTitleCheck] + " 입니다");
						System.out.println(apgujungBusi[apgujungBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				}
			case 2: // 송파
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindssongpa.length; i++) {
					System.out.println((i + 1) + ". " + kindssongpa[i]);
				}
				int songpaTitleCheck = scan.nextInt() - 1; // 송파에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				switch (songpaTitleCheck) {
				case 0: // 007
					System.out.println("예매하실 상영관을 선택해주세요");
					for (int i = 0; i < cinema.length; i++) {
						System.out.println((i + 1) + ". " + cinema[i]);
					}
					int songpaCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (songpaCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] songpaBusi = { "4관 10:10", "4관 13:20", "4관 16:30", "6관 9:00", "6관 14:20", "6관 17:30",
								"8관 11:50", "8관 15:00", "8관 18:10" };
						for (int i = 0; i < songpaBusi.length; i++) {
							System.out.println((i + 1) + ". " + songpaBusi[i]);
						}
						int songpaBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindssongpa[songpaTitleCheck] + " 입니다");
						System.out.println(songpaBusi[songpaBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						
						break;

					case 1:// "PREMIUM"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						songpaCinemaCheck = scan.nextInt() - 1;
						break;
					case 2:// "GOLD CLASS"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						songpaCinemaCheck = scan.nextInt() - 1;
						break;
					case 3:// "4DX"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] songpaFourDX = { "4DX관 9:10", "4DX관 12:20", "4DX관 15:30", "4DX관 18:40" };
						for (int i = 0; i < songpaFourDX.length; i++) {
							System.out.println((i + 1) + ". " + songpaFourDX[i]);
						}
						int songpaFourDXCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							four.sysoutFourDX();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열를 입력해주세요");
							int yull = scan.nextInt();
							four.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 20000;
								break;
							case 2:
								priceSum += 14000;
								break;
							case 3:
								priceSum += 13000;
								break;
							case 4:
								priceSum += 13000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindssongpa[songpaTitleCheck] + " 입니다");
						System.out.println(songpaFourDX[songpaFourDXCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");

						break;
					case 4:// "IMAX"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						songpaCinemaCheck = scan.nextInt() - 1;
						break;
					}
					break;

				case 1: // 보이스
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					songpaCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (songpaCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] songpaBusi = { "1관 9:00", "1관 11:20", "1관 20:00"  };
						for (int i = 0; i < songpaBusi.length; i++) {
							System.out.println((i + 1) + ". " + songpaBusi[i]);
						}
						int songpaBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindssongpa[songpaTitleCheck] + " 입니다");
							System.out.println(songpaBusi[songpaBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}
					}
					break;

				case 2: // 기적
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					songpaCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (songpaCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] songpaBusi = { "2관 19:30" };
						for (int i = 0; i < songpaBusi.length; i++) {
							System.out.println((i + 1) + ". " + songpaBusi[i]);
						}
						int songpaBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindssongpa[songpaTitleCheck] + " 입니다");
						System.out.println(songpaBusi[songpaBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;
					}
					break;
				case 3: // 샹치
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					songpaCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (songpaCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] songpaBusi = { "2관 9:00", "2관 16:50" };
						for (int i = 0; i < songpaBusi.length; i++) {
							System.out.println((i + 1) + ". " + songpaBusi[i]);
						}
						int songpaBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindssongpa[songpaTitleCheck] + " 입니다");
							System.out.println(songpaBusi[songpaBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}
					}
					break;

				}

				break;
			case 3: // 영등포
				System.out.println("예매하실 영화를 선택해주세요");
				for (int i = 0; i < kindsYoungdungpo.length; i++) {
					System.out.println((i + 1) + ". " + kindsYoungdungpo[i]);
				}
				int youngdungpoTitleCheck = scan.nextInt() - 1; // 용산에서 예매할 영화 제목 체크
				System.out.println("-----------------------------");
				switch (youngdungpoTitleCheck) {
				case 0: // 007
					System.out.println("예매하실 상영관을 선택해주세요");
					for (int i = 0; i < cinema.length; i++) {
						System.out.println((i + 1) + ". " + cinema[i]);
					}
					int youngdungpoCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (youngdungpoCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoBusi = { "5관4층 8:25", "5관4층 11:35", "5관4층 14:45", "5관4층 17:55" };
						for (int i = 0; i < youngdungpoBusi.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoBusi[i]);
						}
						int youngdungpoBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
						System.out.println(youngdungpoBusi[youngdungpoBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						break;

					case 1:// "PREMIUM"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						youngdungpoCinemaCheck = scan.nextInt() - 1;
						break;
					case 2:// "GOLD CLASS"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						youngdungpoCinemaCheck = scan.nextInt() - 1;
						break;
					case 3:// "4DX"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoFourDX = { "4DX관4층 9:20", "4DX관4층 12:30", "4DX관4층 15:40", "4DX관4층 18:50" };
						for (int i = 0; i < youngdungpoFourDX.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoFourDX[i]);
						}
						int youngdungpoFourDXCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							four.sysoutFourDX();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열를 입력해주세요");
							int yull = scan.nextInt();
							four.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 20000;
								break;
							case 2:
								priceSum += 14000;
								break;
							case 3:
								priceSum += 13000;
								break;
							case 4:
								priceSum += 13000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
						System.out.println(youngdungpoFourDX[youngdungpoFourDXCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");

						break;
					case 4:// "IMAX"
						System.out.println("해당 영화관은 해당 상영관이 없습니다");
						System.out.println("다시 선택해주세요");
						for (int i = 0; i < cinema.length; i++) {
							System.out.println((i + 1) + ". " + cinema[i]);
						}
						youngdungpoCinemaCheck = scan.nextInt() - 1;
						break;
					}
					break;
				case 1: // 수색자
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					youngdungpoCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (youngdungpoCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoBusi = { "9관4층 13:45" };
						for (int i = 0; i < youngdungpoBusi.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoBusi[i]);
						}
						int youngdungpoBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
						System.out.println(youngdungpoBusi[youngdungpoBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;

				case 2: // 보이스
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					youngdungpoCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (youngdungpoCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoBusi = { "3관4층 8:45", "3관4층 11:00", "3관4층 13:15", "3관4층 15:30", "3관4층 17:45", "3관4층 20:00"};
						for (int i = 0; i < youngdungpoBusi.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoBusi[i]);
						}
						int youngdungpoBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
							System.out.println(youngdungpoBusi[youngdungpoBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}
					}
					break;

				case 3: // 기적
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					System.out.println("2. " + cinema[1]); // Premium
					youngdungpoCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (youngdungpoCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoBusi = { "7관4층 13:20", "8관4층 9:55", "8관4층 12:20", "8관4층 14:45", "8관4층 17:10",
								"5관 18:30" };
						for (int i = 0; i < youngdungpoBusi.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoBusi[i]);
						}
						int youngdungpoBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
							System.out.println(youngdungpoBusi[youngdungpoBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}

						break;
					case 1:// "PREMIUM"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoPre = { "17관 8:00" };
						for (int i = 0; i < youngdungpoPre.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoPre[i]);
						}
						int youngdungpoPreCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							pre.sysoutPre();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석의 번호를 입력해주세요");
							int yull = scan.nextInt();
							pre.setSeat(yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							System.out.println("이 상영관은 경로 및 우대 선택이 불가능합니다");
							for (int j = 0; j < 2; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 25000;
								break;
							case 2:
								priceSum += 20000;
								break;
							}
						}
						System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
						System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
								+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
						System.out.println(youngdungpoPre[youngdungpoPreCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
					}
					break;
				case 4: // 모가디슈
					System.out.println("예매하실 상영관을 선택해주세요");
					System.out.println("1. " + cinema[0]); // Business
					youngdungpoCinemaCheck = scan.nextInt() - 1;
					System.out.println("-----------------------------");
					switch (youngdungpoCinemaCheck) {
					case 0: // "Business"
						System.out.println("예매하실 시간을 선택해주세요");
						String[] youngdungpoBusi = { "1관 8:20", "1관 10:40", "1관 13:00", "1관 15:20", "1관 17:40", "6관 9:20",
								"6관 14:00" };
						for (int i = 0; i < youngdungpoBusi.length; i++) {
							System.out.println((i + 1) + ". " + youngdungpoBusi[i]);
						}
						int youngdungpoBusiCheck = scan.nextInt() - 1;
						System.out.println("-----------------------------");
						while (seatCheck.equals("Y")) {
							busi.sysoutBusi();
							System.out.println("-----------------------------");
							System.out.println("예매하실 좌석을 행을 입력해주세요");
							String hang = scan.next();
							System.out.println("예매하실 좌석의 열을 입력해주세요");
							int yull = scan.nextInt();
							busi.setSeat(hang, yull);
							cnt++;

							System.out.println("더 지정하시겠습니까? Y / N");
							seatCheck = scan.next();

							if (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
								while (!seatCheck.equals("Y") && !seatCheck.equals("N")) {
									System.out.println("잘못 입력하셨습니다");
									System.out.println("더 지정하시겠습니까? Y / N");
									seatCheck = scan.next();
								}
							}
						}
						System.out.println("-----------------------------");
						for (int i = 0; i < cnt; i++) {
							System.out.println("결제하실 항목을 선택해주세요");
							for (int j = 0; j < age.length; j++) {
								System.out.println((j + 1) + ". " + age[j]);
							}
							int ageCheck = scan.nextInt();
							switch (ageCheck) {
							case 1:
								priceSum += 13000;
								break;
							case 2:
								priceSum += 10000;
								break;
							case 3:
								priceSum += 6000;
								break;
							case 4:
								priceSum += 5000;
								break;
							}

							System.out.println("결제하실 금액은 " + priceSum + "원 입니다");
							System.out.println(cinemaName[cinemaNameCheck] + "영화관에 " + "예매하신 영화는 "
									+ kindsYoungdungpo[youngdungpoTitleCheck] + " 입니다");
							System.out.println(youngdungpoBusi[youngdungpoBusiCheck] + " 시간에 맞춰서 입장해주시길 바랍니다");
						}
					}
					break;
				}

				break;
			}
			break;
		case 1:

			break;

		case 2:

			break;

//			-------------------------3. 금액

		case 3:
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
