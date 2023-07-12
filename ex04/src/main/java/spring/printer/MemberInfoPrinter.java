package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter { // 회원이 있다면 그 회원의 정보를 출력하는 기능
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.print(member);
	}
}