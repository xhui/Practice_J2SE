package ex.jmx;

public class Foo implements FooMBean {
	private String fileName;
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void printFileName() {
		System.out.println(fileName);
	}

	public void printFilePath() {
		System.out.println(filePath);
	}
}
