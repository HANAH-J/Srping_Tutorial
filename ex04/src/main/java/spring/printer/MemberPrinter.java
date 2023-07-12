package spring.printer;

import spring.vo.Member;

public class MemberPrinter { // 회원정보를 출력하는 기능
	public void print(Member member) {
		System.out.printf(
				"회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDate());
	}
}