package kr.or.ddit.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BookRentHistoryVO {
	
	 private String rentCd; // 대출코드
	 private String bookCd; // 도서코드
	 private Date rsDate; // 대여날짜
	 private Date rfDate; // 반납날짜
	 private Date rfsDate; // 반납예정일
	 private String memId; // 아이디
	 private String bookNm; // 책제목
}
