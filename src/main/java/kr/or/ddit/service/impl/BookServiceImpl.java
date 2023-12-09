package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.BookMapper;
import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IBookService;
import kr.or.ddit.vo.BookRentHistoryVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	BookMapper bookMapper;
	@Autowired
	MemberMapper memMapper;
	
	@Override
	public List<BookVO> selectBookList() {
		List<BookVO> bookList = bookMapper.selectBookList();
		return bookList;
	}

	@Override
	public BookVO selectBook(String bookCd) {
		BookVO bookVO = bookMapper.selectBook(bookCd);
		return bookVO;
	}

	@Override
	public void insertBook(BookVO bookVO) {
		bookMapper.insertBook(bookVO);
	}

	@Override
	public void updateBook(BookVO bookVO) {
		bookMapper.updateBook(bookVO);
	}

	@Override
	public BookRentHistoryVO insertRent(BookRentHistoryVO bookRentHistoryVO) {
		// 도서 대출
		bookMapper.insertRent(bookRentHistoryVO);
		// 도서 대출 상태 업데이트
		bookMapper.updateBookRent(bookRentHistoryVO.getBookCd());
		// 회원 도서대출 가능 권수 업데이트 
		MemberVO memberVO = memMapper.selectMember(bookRentHistoryVO.getMemId());
		int rac = memberVO.getMemRac()-1;
		memberVO.setMemRac(rac);
		
		memMapper.updateMemRec(memberVO);
		log.info("bookRentCd:{}",bookRentHistoryVO.getRentCd());
		
		return bookMapper.selecOnetRentHis(bookRentHistoryVO.getRentCd());
	}

	@Override
	public void bookReturn(BookRentHistoryVO bookRentHistoryVO) {
		// 도서 반납(도서 대출 상태값 변경)
		bookMapper.bookReturn(bookRentHistoryVO.getBookCd());
		// 도서 반납일자 업데이트
		bookMapper.updateRentHistory(bookRentHistoryVO.getRentCd());
		// 회원 도서대출 가능 권수 업데이트
		MemberVO memberVO = memMapper.selectMember(bookRentHistoryVO.getMemId());
		int rac = memberVO.getMemRac()+1;
		memberVO.setMemRac(rac);
		
		memMapper.updateMemRec(memberVO);
		
	}

	@Override
	public List<BookRentHistoryVO> bookRentHistory(String bookCd) {
		return bookMapper.bookRentHistory(bookCd);
	}

}
