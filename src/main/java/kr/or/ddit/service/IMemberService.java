package kr.or.ddit.service;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {


	public void insertMember(MemberVO memberVO);

	public MemberVO selectMember(String memId);

}
