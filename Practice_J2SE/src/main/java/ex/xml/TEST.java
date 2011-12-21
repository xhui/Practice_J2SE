package ex.xml;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class TEST
{
	public static void main(String[] args)
	{
		checkXML();
	}

	private static void checkXML()
	{
		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try
		{
			Schema schema = sf.newSchema(new StreamSource(
					"E:\\Workspace\\RealTimeWrapper.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource("E:\\Workspace\\b.xml"));
		}
		catch (SAXException e)
		{
			e.printStackTrace();
			System.out.println("invalid\\n");
			return;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("invalid\\n");
			return;
		}
		System.out.println("It is valid\\n");
	}
}
