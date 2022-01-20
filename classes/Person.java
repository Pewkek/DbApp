package classes;

public abstract class Person extends DbObject
{
	private String surname;

	Person(int id, String name, String surname)
	{
		super(id, name);
		this.surname = surname;
	}

}