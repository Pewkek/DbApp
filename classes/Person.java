package classes;

public abstract class Person extends DbObject
{
	private String surname;

	Person(int id, String name, String surname)
	{
		super(id, name);
		this.surname = surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getSurname()
	{
		return surname;
	}

	@Override
	public String toString()
	{
		return getName() + " " + this.getSurname();
	}

	public String pretty()
	{
		return String.format("Type: %s\nName: %s %s", objName(), getName(), getSurname());
	}
}