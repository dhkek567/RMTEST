<<<<<<< HEAD
package kr.or.ddit.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public void insertMember(MemberVO memberVO);
	public MemberVO selectMember(String memId);
	public void updateMemRec(MemberVO memberVO);
}
=======
package kr.or.ddit.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public void insertMember(MemberVO memberVO);
	public MemberVO selectMember(String memId);
	public void updateMemRec(MemberVO memberVO);
}
>>>>>>> branch 'master' of https://github.com/dhkek567/RMTEST.git
