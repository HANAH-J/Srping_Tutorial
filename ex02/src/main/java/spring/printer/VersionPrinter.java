package spring.printer;

public class VersionPrinter { // 빈을 주입받는 것이 아닌 기본 데이터를 주입받는 클래스
	
	private int majorVersion; 
	private int minorVersion;
	
	// 생성자를 통한 기본 데이터 주입
	public VersionPrinter(int majorVersion, int minorVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}

	// Setter 메서드를 통한 기본 데이터 주입
	public VersionPrinter() {}
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public void print() {
		System.out.printf("이 프로그램 버전은 %d.%d입니다.\n", majorVersion, minorVersion);
	}
}