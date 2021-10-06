package movieTicketing;

public class Business {
//                  0    1    2    3    4    5    6    7    8    9   10   11   12   13
	String[] A = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] B = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] C = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] D = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] E = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };

	public void setSeat(String a, int b) {
		switch (a) {
		case "A":
			if (b <= 2) {
				A[b - 1] = "■";
			} else if (b >= 3 && b <= 10) {
				A[b] = "■";
			} else if (b >= 11 && b <= 13) {
				A[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}

			break;
		case "B":
			if (b <= 2) {
				B[b - 1] = "■";
			} else if (b >= 3 && b <= 10) {
				B[b] = "■";
			} else if (b >= 11 && b <= 13) {
				B[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "C":
			if (b <= 2) {
				C[b - 1] = "■";
			} else if (b >= 3 && b <= 10) {
				C[b] = "■";
			} else if (b >= 11 && b <= 13) {
				C[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "D":
			if (b <= 2) {
				D[b - 1] = "■";
			} else if (b >= 3 && b <= 10) {
				D[b] = "■";
			} else if (b >= 11 && b <= 13) {
				D[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "E":
			if (b <= 2) {
				E[b - 1] = "■";
			} else if (b >= 3 && b <= 10) {
				E[b] = "■";
			} else if (b >= 11 && b <= 13) {
				E[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		}
	}

	public void sysoutBusi() {
		System.out.println("  ①② ③④⑤⑥⑦⑧⑨⑩ ⑪⑫");
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
		System.out.print("E ");
		for (int i = 0; i < E.length; i++) {
			System.out.print(E[i]);
		}
	}

}
