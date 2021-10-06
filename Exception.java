package customer;

import java.util.regex.Pattern;

public class Exception {
	 //아이디 확인
	public void idFormat(String str) {
		if(str.length()<5 || str.length()>15){
			System.out.println("5~15자 이내의 아이디만 가능합니다");
		}

		int cnt1=0;
		int cnt2=0;

		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
				cnt1++;
			else if(ch>='0' && ch<='9')
				cnt2++;
		}
		
		if(cnt1==0 || cnt2==0)
			System.out.println("아이디는 영문자와 숫자를 혼용해서 만들어주세요");	

	}
	
    //비밀번호 확인
    public void pwCheck(String pw1, String pw2) {

	   int cnt1=0;
	   int cnt2=0;

	   for(int i=0;i<pw1.length();i++){
		   char ch = pw1.charAt(i);
	   	   if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
			   cnt1++;
		   else if(ch>='0' && ch<='9')
			   cnt2++;
	   }

	   if(cnt1==0 || cnt2==0)
		   System.out.println("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");	

	   if(!pw1.equals(pw2))
		   System.out.println("비밀번호가 다릅니다");	
   }
	public void genCheck(String gender) {

		if(!gender.equals("남") && !gender.equals("여")){
			System.out.println("※성별이 모호하군요!\n성별은 여/남으로 적어주세요;)");

		}
	}
    //이름 확인
    public void nameCheck(String name) {
	    boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
	    if (!check)
	    	System.out.println("※이름은 한글로 입력해주세요");
    }
    
	// 전화번호 확인
	public void phoneCheck(String phone)  {
		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);
		if (!check)
			System.out.println("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
	}


 }
