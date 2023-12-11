package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.service.IBookService;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.BookRentHistoryVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AllController {

	@Autowired
	private IMemberService memService;
	@Autowired
	private IBookService bookService;

	
	/***
	 * 북리스트 가져오기 postman
	 * 
	 * @return bookList
	 */
	@GetMapping("/book")
	public List<BookVO> selectAllBookInfo() {
		log.info("selectAllBookInfo... 실핼 확인!");
		List<BookVO> bookList = bookService.selectBookList();

		return bookList;
	}
	/***
	 *  회원가입
	 * @param memberVO
	 * @return memberVO
	 */
	@PostMapping("/singUp")
	public MemberVO registerMember(@RequestBody MemberVO memberVO) {
		log.info("registerMember... 실핼 확인!");

		memService.insertMember(memberVO);

		return memService.selectMember(memberVO.getMemId());
	}
	
	/***
	 * 책 등록
	 * @param bookVO
	 * @return List<BookVO>
	 */
	@PostMapping("/registerBook")
	public List<BookVO> registerBook(@RequestBody BookVO bookVO) {
		log.info("registerBook... 실핼 확인!");
		log.info("bookVO:{}",bookVO);
		
		bookService.insertBook(bookVO);
		
		return bookService.selectBookList();
	}
	
	/***
	 * 책정보 수정
	 * @param bookVO
	 * @return bookVO
	 */
	@PutMapping("/updateBook")
	public BookVO updateBook(@RequestBody BookVO bookVO) {
		log.info("updateBook... 실핼 확인!");
		log.info("bookVO:{}",bookVO);
		
		bookService.updateBook(bookVO);
		
		return bookService.selectBook(bookVO.getBookCd());
	}
	
	/***
	 * 도서 대출
	 * @param bookRentHistoryVO
	 * @return bookRentVO
	 */
	@PostMapping("/insertRent")
	public BookRentHistoryVO insertRent(@RequestBody BookRentHistoryVO bookRentHistoryVO) {
		log.info("insertRent... 실핼 확인!");
		log.info("bookRentHistoryVO:{}",bookRentHistoryVO);
		
	 	BookRentHistoryVO bookRentVO = bookService.insertRent(bookRentHistoryVO);
		
		return bookRentVO;
	};
	/***
	 * 도서 반납
	 * @param bookRentHistoryVO
	 * @return List<BookVO>
	 */
	@PutMapping("/bookReturn")
	public List<BookVO> bookReturn(@RequestBody BookRentHistoryVO bookRentHistoryVO){
		log.info("bookReturn... 실핼 확인!");
		log.info("bookRentHistoryVO:{}",bookRentHistoryVO);
		bookService.bookReturn(bookRentHistoryVO);
		
		return bookService.selectBookList();
	}
	/***
	 * 도서 대출 내역 확인 
	 * @param bookCd
	 * @return
	 */
	@GetMapping("/bookRentHistory/{bookCd}")
	public List<BookRentHistoryVO> bookRentHistory(@PathVariable("bookCd") String bookCd){
		log.info("bookRentHistory... 실핼 확인!");
		log.info("bookCd:{}",bookCd);
		return bookService.bookRentHistory(bookCd);
	}
	
}
