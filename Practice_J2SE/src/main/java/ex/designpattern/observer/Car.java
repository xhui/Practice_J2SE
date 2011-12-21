package ex.designpattern.observer;

import java.util.Observable;

public class Car extends Observable
{
	private String	engine	= null;

	/**
	 * @return the engine
	 */
	public String getEngine()
	{
		return engine;
	}

	/**
	 * @param engine
	 *            the engine to set
	 */
	public void setEngine(String engine)
	{
		this.engine = engine;
		setChanged();
		notifyObservers(engine);
	}

	// test
	public static void main(String[] args)
	{
		Car car = new Car();
		car.addObserver(new EngineObserver());
		car.setEngine("test engine");
	}

}
