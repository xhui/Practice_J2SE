package ex.designpattern.visitor;

import java.util.Collection;

public interface Visitor
{
	public void visitAll(Collection<Handler> c);

	public void visit(Handler h);
}
