package ex.main;

import java.math.BigDecimal;
import java.util.List;

public class MainClass
{

	public static Double round(Double doubleValue, int scale)
	{
		Double flag = null;
		String text = doubleValue.toString();
		BigDecimal bd = new BigDecimal(text).setScale(scale,
				BigDecimal.ROUND_HALF_UP);
		flag = bd.doubleValue();
		return flag;
	}

	// public static Double round(Double doubleValue, int scale) {
	// Double flag = null;
	// String text = doubleValue.toString();
	// BigDecimal bd = new BigDecimal(text).setScale(scale,
	// BigDecimal.ROUND_HALF_UP);
	// flag = bd.doubleValue();
	// return flag;
	// }

	public static void main(String[] args)
	{
//		System.out.println(new Calculate().sum(1, 2));
	}

	private static List<Integer> sort(List<Integer> list)
	{
		return list.subList(0, 3);
	}
}

class Ball
{
	String	name	= "";

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}

class Car
{
	Ball	b	= null;

	public Car(Ball ball)
	{
		b = ball;
	}

	public Ball getB()
	{
		return b;
	}

	public void setB(Ball b)
	{
		this.b = b;
	}
}