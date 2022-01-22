package classes;

public abstract class DbObject
{
	private int id;
	private String name;

	DbObject(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public abstract String pretty();
	public abstract String objName();
	public String className()
	{
		return "classes." + objName();
	}
}
