package ex.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class XmlPrac
{
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File(""));
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
	}
}
