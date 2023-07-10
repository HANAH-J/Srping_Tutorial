package spring.assembler;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler { // 객체 생성기
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao); // 의존 주입
		this.pwdSvc = new ChangePasswordService();
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberRegisterService getRegSvc() {
		return regSvc;
	}
	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
}