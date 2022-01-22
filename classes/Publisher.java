package classes;

public class Publisher extends DbObject
{
	private String address;
	public Publisher(int id, String name, String address)
	{
		super(id, name);
		this.address = address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAddress()
	{
		return address;
	}

	public String objName()
	{
		return "Publisher";
	}

	@Override
	public String toString()
	{
		return getName();
	}

	public String pretty()
	{
		return String.format("Type: %s\nName: %s\nAddress: %s", objName(), getName(), address);
	}
}
