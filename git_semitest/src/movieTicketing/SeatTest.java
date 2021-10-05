package movieTicketing;

public class SeatTest {
	public static void main(String[] args) {
		Business busi = new Business();
		busi.sysoutBusi();
		System.out.println("---------------------------------");
		FourDX four = new FourDX();
		four.sysoutFourDX();
		System.out.println("---------------------------------");
		GoldClass gold = new GoldClass();
		gold.sysoutGoldClass();
		System.out.println("---------------------------------");
		Premium pri = new Premium();
		pri.sysoutPre();
		System.out.println("---------------------------------");
		IMAX imax = new IMAX();
		imax.sysoutImax();
	}
}
