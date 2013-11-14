package ex.test.bean;

public class Address
{
	private String	name		= null;
	private String	code		= null;
	private boolean	included	= false;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public boolean isIncluded()
	{
		return included;
	}

	public void setIncluded(boolean included)
	{
		this.included = included;
	}
}
