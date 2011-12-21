package ex.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MainClass
{
	private static Random	RANDOM	= new Random();

	public static void main(String[] args)
	{
		String path = "E:/git/Practice_J2SE/Practice_J2SE/src/main/java/ex/main/test.txt";
		long startTime = System.currentTimeMillis();
		generate(path, 99999999);
		System.out.println(System.currentTimeMillis() - startTime);
	}

	// public static void sort

	public static void generate(String filePath, int totalCount)
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		try
		{
			fw = new FileWriter(new File(filePath));
			bw = new BufferedWriter(fw);
			for (int i = 0; i < totalCount; i++)
			{
				bw.write(String.valueOf(getRandomNumber()));
				bw.newLine();
			}
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (fw != null)
			{
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				finally
				{
					fw = null;
				}
			}
			if (bw != null)
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				finally
				{
					bw = null;
				}
			}
		}
	}

	private static long getRandomNumber()
	{
		return Math.abs(RANDOM.nextInt() % 99999999);
	}
}