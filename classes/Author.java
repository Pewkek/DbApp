package classes;

public class Author extends Person
{
	public Author(int id, String name, String surname)
	{
		super(id, name, surname);
	}

	public String objName()
	{
		return "Author";
	}
}