package ex.designpattern.visitor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ex.designpattern.visitor.Handler;
import ex.designpattern.visitor.Visitor;

public class HandlerVisitor implements Visitor
{
	@Override
	public void visitAll(Collection<Handler> c)
	{
		for (Handler o : c)
		{
			o.accept(this);
		}
	}

	// Test Method
	public static void main(String[] args)
	{
		Visitor visitor = new HandlerVisitor();
		Handler h1 = new EnglishHandler();
		ChineseHandler h2 = new ChineseHandler();
		EnglishHandler h3 = new EnglishHandler();

		// visit all
		List<Handler> list = new ArrayList<Handler>();
		list.add(new EnglishHandler());
		list.add(new ChineseHandler());
		visitor.visitAll(list);

		// visit single
		visitor.visit(h1);
		visitor.visit(h2);
		visitor.visit(h3);
	}

	@Override
	public void visit(Handler h)
	{
		System.out.println("parent handler");
		h.handle();
	}

	public void visit(EnglishHandler h)
	{
		System.out.println("visting  EnglishHandler");
		h.handle();
	}

	public void visit(ChineseHandler h)
	{
		System.out.println("visting ChineseHandler");
		h.handle();
	}
}
