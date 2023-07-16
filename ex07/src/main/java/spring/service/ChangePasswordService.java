package spring.service;

import org.springframework.transaction.annotation.Transactional;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class ChangePasswordService {
	private MemberDao memberDao; // = new MemberDao();
	
//	// 생성자를 통한 의존 주입
//	public ChangePasswordService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	// Setter메서드를 통한 의존 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPassword, newPassword);
		
		memberDao.update(member);
	}
}