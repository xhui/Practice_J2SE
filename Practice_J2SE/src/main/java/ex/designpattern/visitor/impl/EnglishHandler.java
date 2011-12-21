package ex.designpattern.visitor.impl;

import ex.designpattern.visitor.Handler;
import ex.designpattern.visitor.Visitor;

public class EnglishHandler implements Handler
{
	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public void handle()
	{

	}

}
