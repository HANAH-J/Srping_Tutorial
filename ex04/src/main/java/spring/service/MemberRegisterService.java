package spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
//	// Setter메서드를 통한 '주입'
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if (member != null) {
			throw new AlreadyExistingMemberException("이메일 중복");
		}
		
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}