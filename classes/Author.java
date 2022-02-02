package classes;
import java.io.*;

public class Author extends Person
{
	public Author(int id, String name, String surname)
	{
		super(id, name, surname);
	}

	public static DbObject fromUserInput()
	{
		Console con = System.console();

		String name = "N/A";
		String surname = "N/A";

		name = con.readLine("Podaj imię: ");
		surname = con.readLine("Podaj nazwisko: ");
		Author ret = new Author(-1, name, surname);
		System.out.println("\nUtworzono Author:\n"+ret.pretty());

		return (DbObject) ret;
	}

	public String objName()
	{
		return "Author";
	}
}