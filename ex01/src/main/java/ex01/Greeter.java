package ex01;

public class Greeter {
	private String format;	// ~님 안녕하세요

	public void setFormat(String format) {
		this.format = format;
	}

	public String greet(String name) {
		return String.format(format, name);
	}
}