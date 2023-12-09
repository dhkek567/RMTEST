package kr.or.ddit.vo;

import java.util.Date;


import lombok.Data;

@Data
public class BookVO {

	private String bookCd; // 도서코드
	private String bookNm; // 책제목
	private String author; // 책저자
	private String rentAv; // 대출가능 여부
	private String bookPublisher; // 출판사
	private Date releaseDate; // 출판일
	private String bookDes; // 책설명
	private String bookType; // 분류
}
