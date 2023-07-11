package spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
	// 서비스 클래스도 스프링이 알아서 만들도록 할 겁니다.
	
	private MemberDao memberDao; // = new MemberDao();
	
	// 생성자 => 생성자를 통한 외부로부터 인스턴스를 '주입' 받는다.
	@Autowired	// 적절한 빈을 스프링이 알아서 찾아서 주입해 준다.
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