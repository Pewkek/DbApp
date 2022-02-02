package classes;
import java.io.*;

public class Publisher extends DbObject
{
	private String address;
	public Publisher(int id, String name, String address)
	{
		super(id, name);
		this.address = address;
	}

	public static DbObject fromUserInput()
	{
		Console con = System.console();

		String name = "N/A";
		String address = "N/A";

		name = con.readLine("Podaj nazwę: ");
		address = con.readLine("Podaj adres: ");
		Publisher ret = new Publisher(-1, name, address);
		System.out.println("\nUtworzono Publisher"+":\n"+ret.pretty());

		return (DbObject) ret;
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
