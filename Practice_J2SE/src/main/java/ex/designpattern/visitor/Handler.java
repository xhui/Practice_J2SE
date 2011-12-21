package ex.designpattern.visitor;

public interface Handler
{
	public void accept(Visitor visitor);

	public void handle();
}