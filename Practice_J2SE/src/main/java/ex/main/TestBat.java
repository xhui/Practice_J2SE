package ex.main;

public class TestBat
{
	public static void main(String[] args)
	{
		new MyThread().start();
	}
}

class MyThread extends Thread
{

	@Override
	public void run()
	{
		int i = 0;
		while (i < 3)
		{
			try
			{
				System.out.println(i++);
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}