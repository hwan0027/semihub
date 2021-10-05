package movieTicketing;

public class GoldClass {
	String[] A = {"□","□"," ","□","□"," ","□","□"," ","□","□","\n"};
	String[] B = {" "," "," ","□","□"," ","□","□"," ","□","□","\n"};
	String[] C = {" "," "," ","□","□"," ","□","□"," ","□","□","\n"};
	String[] D = {" "," "," ","□","□"," ","□","□"," ","□","□","\n"};
	
	public void sysoutGoldClass() {
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		for(int i = 0; i < B.length; i++) {
			System.out.print(B[i]);
		}
		for(int i = 0; i < C.length; i++) {
			System.out.print(C[i]);
		}
		for(int i = 0; i < D.length; i++) {
			System.out.print(D[i]);
		}
	}
}
