package spring.printer;

import java.util.Collection;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberListPrinter { // 모든 회원정보를 출력하는 기능
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	// 생성자를 통한 의존 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() { // 모든 회원정보를 출력하는 기능
		Collection<Member> members = memberDao.selectAll();
		
		for(Member member : members) {
			printer.print(member);
		}
	}
}