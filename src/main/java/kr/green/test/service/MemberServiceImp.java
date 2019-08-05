package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}

}