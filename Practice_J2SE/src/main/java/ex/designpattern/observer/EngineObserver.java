package ex.designpattern.observer;

import java.util.Observable;

public class EngineObserver implements java.util.Observer
{
	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println("adding ..." + arg);
	}

}
