package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BookRentHistoryVO;
import kr.or.ddit.vo.BookVO;

@Mapper
public interface BookMapper {

	public List<BookVO> selectBookList();

	public BookVO selectBook(String bookCd);

	public void insertBook(BookVO bookVO);

	public void updateBook(BookVO bookVO);

	public void insertRent(BookRentHistoryVO bookRentHistoryVO);

	public void updateBookRent(String bookCd);

	public BookRentHistoryVO selecOnetRentHis(String rencCd);

	public void bookReturn(String bookCd);

	public void updateRentHistory(String bookCd);

	public List<BookRentHistoryVO> bookRentHistory(String bookCd);

}
