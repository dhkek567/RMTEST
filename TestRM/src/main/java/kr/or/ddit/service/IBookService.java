package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BookRentHistoryVO;
import kr.or.ddit.vo.BookVO;

public interface IBookService {

	public List<BookVO> selectBookList();

	public BookVO selectBook(String bookCd);

	public void insertBook(BookVO bookVO);

	public void updateBook(BookVO bookVO);

	public BookRentHistoryVO insertRent(BookRentHistoryVO bookRentHistoryVO);

	public void bookReturn(BookRentHistoryVO bookRentHistoryVO);

	public List<BookRentHistoryVO> bookRentHistory(String bookCd);

}
