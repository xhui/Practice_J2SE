package ex.jmx;

public interface FooMBean {
	public String getFileName();

	public void setFileName(String fileName);

	public String getFilePath();

	public void setFilePath(String filePath);

	public void printFileName();

	public void printFilePath();
}
