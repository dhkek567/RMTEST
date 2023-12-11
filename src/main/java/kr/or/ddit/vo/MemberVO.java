package kr.or.ddit.vo;


import lombok.Data;

@Data
public class MemberVO {
	
	 private String memId; // 아이디
	 private String memPw; // 비밀번호
	 private String memNm; // 이름
	 private String memHp; // 전화번호
	 private String memMail; // 이메일
	 private int memRac; // 대출가능 건수
}
