package ex.test.bean;

public class AddressBean
{
	private Address	address	= null;

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getName()
	{
		return address.getName() + "_suffix";
	}

	public void setName(String name)
	{
	}

	public String getCode()
	{
		return address.getCode();
	}

	public void setCode(String code)
	{
	}

	public boolean isIncluded()
	{
		return !address.isIncluded();
	}

	public void setIncluded(boolean included)
	{
	}

}
