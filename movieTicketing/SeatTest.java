package movieTicketing;

import java.util.Scanner;

public class SeatTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Business busi = new Business();
		busi.sysoutBusi();
		System.out.println("예매할 좌석의 열을 입력해주세요");
		String y = scan.next();
		System.out.println("예매할 좌석의 행을 입력해주세요");
		int h = scan.nextInt();
		busi.setSeat(y,h);
		busi.setSeat("B", 3);
		busi.sysoutBusi();
		System.out.println("---------------------------------");
		FourDX four = new FourDX();
		four.setSeat("I", 8);
		four.sysoutFourDX();
		System.out.println("---------------------------------");
		GoldClass gold = new GoldClass();
		gold.setSeat("B", 5);
		gold.sysoutGoldClass();
		System.out.println("---------------------------------");
		Premium pri = new Premium();
		pri.setSeat(9);
		pri.setSeat(1);
		pri.sysoutPre();
		System.out.println("---------------------------------");
		IMAX imax = new IMAX();
		imax.setSeat("G", 1);
		imax.setSeat("E", 14);
		imax.setSeat("B", 12);
		imax.sysoutImax();
	}
}
