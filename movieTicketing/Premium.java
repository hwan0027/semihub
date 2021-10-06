package movieTicketing;

public class Premium {
	String[] A = { "□", "□", "□", "□", " ", "□", "□", "□", "□", " ", "□", "□", "□", "□", "\n" };

	public void sysoutPre() {
		System.out.println("①②③④ ⑤⑥⑦⑧ ⑨⑩⑪⑫");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}

	public void setSeat(int b) {
		if (b <= 4) {
			A[b-1] = "■";
		} else if (b >= 5 && b <= 8) {
			A[b] = "■";
		} else if (b >= 9 && b <= 12) {
			A[b+1] = "■";
		} else {
			System.out.println("잘못 선택하셨습니다");
		}
	}

}
