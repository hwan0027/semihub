package movieMember;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Movie {

	Scanner sc = new Scanner(System.in);
	MovieDAO dao = new MovieDAO();
	MovieException ne = new MovieException();



	//회원가입

	public void insert() throws AuthenException {
		String pw2=null;
		boolean id=true;
		boolean pw=true;
		boolean name=true;
		boolean gender=true;
		boolean tel=true;
		System.out.println("                 회원가입");
		System.out.println("-------------------------------------");

		try {
			MovieDTO dto = new MovieDTO();
			do{
				try{
					System.out.println("아이디는 5~15자 내외로 입력해 주세요");
					System.out.println("아이디는 영문과 숫자를 혼용해서 만들어 주세요");
					System.out.print("아이디: ");
					dto.setId(sc.next());
					ne.idFormat(dto.getId());
					id=false;
				}catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while(id);
			do{
				try{
					System.out.println("비밀번호는 6~15자 내외로 입력해 주세요");
					System.out.println("비밀번호는 영문과 숫자만 혼용해서 만들어 주세요");
					
					System.out.print("비밀번호:");
					dto.setPw(sc.next());

					System.out.println("비밀번호 확인을 위해 한 번 더 입력해 주세요");
					System.out.print("비밀번호 확인:");
					pw2 = sc.next();
					ne.pwCheck(dto.getPw(), pw2);

					pw=false;
				}catch (AuthenException e) {
					System.out.println(e.toString());
				}

			} while(pw);
			do{
				try{
					System.out.println("이름을 한글로만 입력 해주세요");
					System.out.print("이름:");
					dto.setName(sc.next());
					ne.nameCheck(dto.getName());
					name=false;
				}catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while(name);
			do{
				try{
					System.out.println("성별을 입력 해 주세요");
					System.out.print("성별[여/남]:");
					dto.setGender(sc.next());
					ne.genCheck(dto.getGender());
					gender=false;
				}catch (AuthenException e) {
					System.out.println(e.toString());
				}

			} while(gender);
			System.out.println("생일을 입력 해주세요 [xxxx-xx-xx] 형식으로 부탁드립니다.");
			System.out.print("생일:");
			dto.setBirth(sc.next());
			
			System.out.println("이메일을 입력 해주세요 xxxx@xxxx형식으로 부탁드립니다");
			System.out.print("이메일:");
			dto.setEmail(sc.next());
			do{
				try{
					System.out.println("전화번호를 입력 해주세요 [xxx-xxxx-xxxx]형식으로 부탁드립니다");
					System.out.print("전화번호:");
					dto.setTel(sc.next());
					ne.phoneCheck(dto.getTel());
					tel=false;
				}catch (AuthenException e) {
					System.out.println(e.toString());
				}

			} while(tel);
			int result = dao.insertData(dto);
			if(result!=0){
				System.out.println();
				System.out.println("****성공적으로 가입이 되었습니다!****");
				System.out.println();

				System.out.println("-----------[회원가입 확인]-----------");
				System.out.println(dto.toString());	
			}else
				System.out.println("회원가입에 실패했습니다");		

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	//수정
	public void update() {
		try {
			MovieDTO dto = new MovieDTO();
			System.out.print("수정 할 아이디:");
			dto.setId(sc.next());

			System.out.print("비밀번호:");
			dto.setPw(sc.next());

			System.out.print("이메일[xxxxx@daum.net]:");
			dto.setEmail(sc.next());

			System.out.print("전화번호[xxx-xxxx-xxxx]:");
			dto.setTel(sc.next());		

			int result = dao.updateData(dto);

			if(result!=0)
				System.out.println("회원정보가 수정되었습니다");
			else
				System.out.println("회원정보수정에 실패했습니다");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//탈퇴
	public void delete() {
		try {
			String id, pw;

			System.out.print("탈퇴 할 아이디:");
			id = sc.next();

			System.out.print("비밀번호 확인:");
			pw = sc.next();

			int result = dao.deleteDate(id,pw);

			if(result!=0)
				System.out.println("성공적으로 탈퇴하였습니다.\n다음에 다시 가입해주세요! ;)");
			else
				System.out.println("탈퇴에 실패했습니다.\n영원히 회원으로 남아주세요:)");
		} catch (Exception e) {
			System.out.println(e.toString());
		}



	}

	//회원 전체출력
	public void selectAll() {
		List<MovieDTO> lists = dao.getList();
		Iterator<MovieDTO> it = lists.iterator();

		int i=1;
		while(it.hasNext()){
			MovieDTO dto = it.next();
			System.out.println("[회원 "+i+"]");
			System.out.println(dto.toString());
			i++;
		}
	}


	//아이디검색
	public void searchId() {
		System.out.print("검색 할 아이디:");
		List<MovieDTO> lists = dao.getList(sc.next());
		Iterator<MovieDTO> it = lists.iterator();

		if(!it.hasNext()){
			System.out.println("검색한 아이디는 존재하지 않습니다.");
		}
		while(it.hasNext()){
			MovieDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
}
