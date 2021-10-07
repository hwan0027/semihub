package movieTicketing;

public class GoldClass {
//                  0    1    2    3    4    5    6    7    8    9   10
	String[] A = { "□", "□", " ", "□", "□", " ", "□", "□", " ", "□", "□", "\n" };
	String[] B = { " ", " ", " ", "□", "□", " ", "□", "□", " ", "□", "□", "\n" };
	String[] C = { " ", " ", " ", "□", "□", " ", "□", "□", " ", "□", "□", "\n" };
	String[] D = { " ", " ", " ", "□", "□", " ", "□", "□", " ", "□", "□", "\n" };

	public void setSeat(String a, int b) {
		switch (a) {
		case "A":
			if (b <= 2) {
				A[b - 1] = "■";
			} else if (b >= 3 && b <= 4) {
				A[b] = "■";
			} else if (b >= 5 && b <= 6) {
				A[b + 1] = "■";
			} else if (b >= 7 && b <= 8) {
				A[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}

			break;
		case "B":
			if (b <= 2) {
				B[b - 1] = "■";
			} else if (b >= 3 && b <= 4) {
				B[b] = "■";
			} else if (b >= 5 && b <= 6) {
				B[b + 1] = "■";
			} else if (b >= 7 && b <= 8) {
				B[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "C":
			if (b <= 2) {
				C[b - 1] = "■";
			} else if (b >= 3 && b <= 4) {
				C[b] = "■";
			} else if (b >= 5 && b <= 6) {
				C[b + 1] = "■";
			} else if (b >= 7 && b <= 8) {
				C[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "D":
			if (b <= 2) {
				D[b - 1] = "■";
			} else if (b >= 3 && b <= 4) {
				D[b] = "■";
			} else if (b >= 5 && b <= 6) {
				D[b + 1] = "■";
			} else if (b >= 7 && b <= 8) {
				D[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		}
	}

	public void sysoutGoldClass() {
		System.out.println("  ①② ③④ ⑤⑥ ⑦⑧");
		System.out.print("A ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.print("B ");
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i]);
		}
		System.out.print("C ");
		for (int i = 0; i < C.length; i++) {
			System.out.print(C[i]);
		}
		System.out.print("D ");
		for (int i = 0; i < D.length; i++) {
			System.out.print(D[i]);
		}
	}
}
