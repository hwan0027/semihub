package git_semitest;

public class StudentTest {
	public static void main(String[] args) {
		//여기서 소스를 수정하면 git의 워크트리에 있는 파일이 수정되는 것임!!
		//워크트리      ->     인덱스    ->     로컬저장소     ->    원격저장소
		//       "add index"      "commit"           "push"
		
		Student st = new Student("주환", 24);
		System.out.println(st+"!!!!");
		
		Student st1 = new Student("하하", 40);
		System.out.println(st1+"!!!!");
		
		Student st2 = new Student("나영", 30);
		System.out.println(st2+"!!!!");
		
		Student st3 = new Student("동근", 27);
		System.out.println(st3+"!!!!");
	}
}
