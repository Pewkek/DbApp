package classes;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.*;

public class CLI extends Storage
{
	public static void showHelp()
	{
		System.out.println("JanuszexDb");
		System.out.println("  1) Dodaj wpis");
		System.out.println("  2) Usuń wpis po ID");
		System.out.println("  3) Wyświetl zawartość bazy");
		System.out.println("  4) Wyszukaj po typie");
		System.out.println("  5) Wyszukaj po nazwie");
		System.out.println("  q) Wyjście");
	}
	
	public void option1() // Add item
	{
		System.out.println("Wybierz typ wpisu: ");
		System.out.println(" Client");
		System.out.println(" Author");
		System.out.println(" Publisher");
		System.out.println(" Book");
		System.out.println(" Magazine");
		System.out.println(" Course");

		Console con = System.console();
		String s;
		String[] good = {"Client", "Author", "Publisher", "Book", "Magazine", "Course"};
		while(true)
		{
			s = con.readLine("Wpisz typ wpisu: ");
			if(s.equals("q"))
			{
				optionLoop();
				return;
			}

			if(Arrays.asList(good).contains(s))
			{
				break;
			}
		}

		try
		{
			String[] requiresStorage = {"Book", "Magazine", "Course"};
			Class c = Class.forName("classes."+s);
			DbObject ret = null;
			if(!Arrays.asList(requiresStorage).contains(s))
			{
				Method m = c.getMethod("fromUserInput");
				ret = (DbObject) m.invoke(null);
			}
			else
			{
				Method m = c.getMethod("fromUserInput", Storage.class);
				ret = (DbObject) m.invoke(null, this);
			}
			addItem(ret);
		}
		catch(Exception e)
		{
			System.err.println("Błąd konwersji na klasę: "+e);
			option1();
		}
	}

	public void option2() // Remove item
	{
		Console con = System.console();
		String s = "";
		while(true)
		{
			s = con.readLine("Wpisz ID wpisu: ");
			if(s.equals("q"))
			{
				optionLoop();
				return;
			}
			try
			{
				int id = Integer.parseInt(s);
				removeItemById(id);
				break;
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Nie ma takiego wpisu");
			}
			catch(Exception e)
			{
				System.out.println("Napotkano błąd: "+e);
			}
		}
	}

	public void option3() // Show all
	{
		System.out.println("\n\n");
		for(int i=0; i<itemCount(); i++)
		{
			DbObject item = getItem(i);
			System.out.println(item.pretty(true));
			if(i < itemCount() - 1)
			{
				System.out.println("");
			}
		}
		System.out.println("\n\n");
	}

	public void option4() // Search by type
	{
		System.out.println("Wybierz typ wpisu do wyszukania: ");
		System.out.println(" Client");
		System.out.println(" Author");
		System.out.println(" Publisher");
		System.out.println(" Book");
		System.out.println(" Magazine");
		System.out.println(" Course");

		Console con = System.console();
		String s;
		String[] good = {"Client", "Author", "Publisher", "Book", "Magazine", "Course"};
		while(true)
		{
			s = con.readLine("Wpisz typ wpisu: ");
			if(s.equals("q"))
			{
				optionLoop();
				return;
			}

			if(Arrays.asList(good).contains(s))
			{
				break;
			}
		}

		try
		{
			Class c = Class.forName("classes."+s);

			System.out.println("\n\n");
			for(int i=0; i<itemCount(); i++)
			{
				DbObject item = getItem(i);
				Class childClass = item.getClass();
				if(c.equals(childClass))
				{
					System.out.println(item.pretty(true));
					if(i < itemCount() - 1)
					{
						System.out.println("");
					}
				}
			}
			System.out.println("\n\n");
		}
		catch(Exception e)
		{
			System.err.println("Błąd: "+e);
			option4();
		}
	}

	public void option5() // Search by name
	{
		Console con = System.console();
		String s;
		s = con.readLine("Podaj nazwę do wyszukania: ");
		
		for(int i=0; i<itemCount(); i++)
		{
			DbObject item = getItem(i);
			String name = item.getName();
			if(item instanceof classes.Person)
			{
				Person conv = (Person) item;
				name = conv.getName() + " " + conv.getSurname();
			}
			Pattern p = Pattern.compile(s);
			Matcher m = p.matcher(name);

			if(m.find())
			{
				System.out.println(item.pretty(true));
				if(i < itemCount() - 1)
				{
					System.out.println("");
				}
			}
		}
		System.out.println("\n\n");
	}

	public void optionLoop()
	{
		Console con = System.console();

		String s = con.readLine("Wybierz opcję [1-5, ?, q]: ");
		int option;
		while(true)
		{
			if(s.equals("q"))
			{
				System.exit(0);
			}
			else if(s.equals(" ") || s.equals("\n") || s.equals("?"))
			{
				showHelp();
			}
			else
			{
				try
				{
					option = Integer.parseInt(s);
					if(option <= 5 && option >= 1)
					{
						break;
					}
				}
				catch(NumberFormatException e) {}
			}
			s = con.readLine("Wybierz poprawną opcję [1-5, ?, q]: ");
		}
		try
		{
			Method m = CLI.class.getMethod("option"+option);
			Object result = m.invoke(this);
			optionLoop();
		}
		catch(Exception e)
		{
			System.err.println("Błąd przy wywoływaniu metody: "+e);
		}
	}
}
