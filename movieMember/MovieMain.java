package movieMember;

import java.util.Scanner;

public class MovieMain {
	public static void main(String[] args)  throws AuthenException {
		
        Scanner sc = new Scanner(System.in);
		Movie ob = new Movie();
		int ch;
		while(true){
			{
				System.out.print("1.회원가입  2.회원 정보수정  3.회원탈퇴  4.회원전체출력  5.아이디검색  6.종료");
				System.out.print("\n-------------------------------------\n▶");
				ch = sc.nextInt();
			} while(ch<1 || ch>6);
			System.out.println();
			switch(ch){
			case 1:
				ob.insert();
				System.out.println(); break;

			case 2:
				ob.update();
				System.out.println(); break;

			case 3:
				ob.delete();
				System.out.println(); break;

			case 4:
				ob.selectAll();
				System.out.println(); break;

			case 5:
				ob.searchId();
				System.out.println(); break;

			case 6:
				DBConn.close();
				System.exit(0);
			}
		}

	}

}