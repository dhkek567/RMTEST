package kr.or.ddit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	MemberMapper memMapper;


	@Override
	public void insertMember(MemberVO memberVO) {
		memMapper.insertMember(memberVO);
	}

	@Override
	public MemberVO selectMember(String memId) {
		return memMapper.selectMember(memId);
	}
	
	

}
