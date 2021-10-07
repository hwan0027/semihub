package movieTicketing;

public class IMAX {
//                  0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16
	String[] A = { " ", " ", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "\n" };
	String[] B = { " ", " ", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "\n" };
	String[] C = { " ", " ", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "\n" };
	String[] D = { " ", " ", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "\n" };
	String[] E = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] F = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] G = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };
	String[] H = { "□", "□", " ", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", " ", "□", "□", "\n" };

	public void setSeat(String a, int b) {
		switch (a) {
		case "A":
			if (b >= 3 && b <= 13 ) {
				A[b] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}

			break;
		case "B":
			if (b >= 3 && b <= 13 ) {
				B[b] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "C":
			if (b >= 3 && b <= 13 ) {
				C[b] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "D":
			if (b >= 3 && b <= 13 ) {
				D[b] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "E":
			if (b <= 2) {
				E[b - 1] = "■";
			} else if (b >= 3 && b <= 13) {
				E[b] = "■";
			} else if (b >= 14 && b <= 15) {
				E[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "F":
			if (b <= 2) {
				F[b - 1] = "■";
			} else if (b >= 3 && b <= 13) {
				F[b] = "■";
			} else if (b >= 14 && b <= 15) {
				F[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "G":
			if (b <= 2) {
				G[b - 1] = "■";
			} else if (b >= 3 && b <= 13) {
				G[b] = "■";
			} else if (b >= 14 && b <= 15) {
				G[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "H":
			if (b <= 2) {
				H[b - 1] = "■";
			} else if (b >= 3 && b <= 13) {
				H[b] = "■";
			} else if (b >= 14 && b <= 15) {
				H[b + 2] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		}
	}
	
	public void sysoutImax() {
		System.out.println("  ①② ③④⑤⑥⑦⑧⑨⑩⑪⑫⑬ ⑭⑮");
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
		System.out.print("F ");
		for (int i = 0; i < F.length; i++) {
			System.out.print(F[i]);
		}
		System.out.print("G ");
		for (int i = 0; i < G.length; i++) {
			System.out.print(G[i]);
		}
		System.out.print("H ");
		for (int i = 0; i < H.length; i++) {
			System.out.print(H[i]);
		}
	}
}
