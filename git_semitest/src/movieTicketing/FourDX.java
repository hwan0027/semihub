package movieTicketing;

public class FourDX {
//                  0    1    2    3    4    5    6    7    8    9   10   11   12   13
	String[] A = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] B = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] C = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] D = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] E = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] F = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] G = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] H = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };
	String[] I = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };

	public void setSeat(String a, int b) {
		switch (a) {
		case "A":
			if (b <= 4) {
				A[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				A[b] = "■";
			} else if (b >= 9 && b <= 12) {
				A[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}

			break;
		case "B":
			if (b <= 4) {
				B[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				B[b] = "■";
			} else if (b >= 9 && b <= 12) {
				B[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "C":
			if (b <= 4) {
				C[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				C[b] = "■";
			} else if (b >= 9 && b <= 12) {
				C[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "D":
			if (b <= 4) {
				D[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				D[b] = "■";
			} else if (b >= 9 && b <= 12) {
				D[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "E":
			if (b <= 4) {
				E[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				E[b] = "■";
			} else if (b >= 9 && b <= 12) {
				E[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "F":
			if (b <= 4) {
				F[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				F[b] = "■";
			} else if (b >= 9 && b <= 12) {
				F[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "G":
			if (b <= 4) {
				G[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				G[b] = "■";
			} else if (b >= 9 && b <= 12) {
				G[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "H":
			if (b <= 4) {
				H[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				H[b] = "■";
			} else if (b >= 9 && b <= 12) {
				H[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		case "I":
			if (b <= 4) {
				I[b - 1] = "■";
			} else if (b >= 5 && b <= 8) {
				I[b] = "■";
			} else if (b >= 9 && b <= 12) {
				I[b + 1] = "■";
			} else {
				System.out.println("잘못 선택하셨습니다");
			}
			break;
		}
	}

	public void sysoutFourDX() {
		System.out.println("  ①②③④ ⑤⑥⑦⑧ ⑨⑩⑪⑫");
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
		System.out.print("I ");
		for (int i = 0; i < I.length; i++) {
			System.out.print(I[i]);
		}
	}
}
