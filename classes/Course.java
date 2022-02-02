package classes;
import java.io.*;
import java.util.NoSuchElementException;

public class Course extends EduResource
{
	private Author author;
	private float duration;

	Course(int id, String name, Author author, float duration, String publicationDate)
	{
		super(id, name, publicationDate);
		this.author = author;
		this.duration = duration;
	}

	public static DbObject fromUserInput(Storage s)
	{
		Console con = System.console();
		
		Course ret;
	
		String name = "N/A";

		String authorIdStr = "N/A";
		int authorId = -9999;
		Author author = null;

		String durationStr = "N/A";
		float duration = -1.0f;

		String publicationDate = "N/A";
		
		name = con.readLine("Podaj nazwę: ");
		authorIdStr = con.readLine("Podaj ID autora: ");

		while(true) // Author parsing
		{
			try
			{
				authorId = Integer.parseInt(authorIdStr);
				DbObject obj = s.getById(authorId);
				if(!(obj instanceof classes.Author))
				{
					authorIdStr = con.readLine("Podaj poprawne ID autora: ");
					continue;
				}
				author = (Author) obj;
				break;
			}
			catch(NumberFormatException e)
			{
				authorIdStr = con.readLine("Podaj ID (liczba całkowita) autora: ");
				continue;
			}
			catch(NoSuchElementException e)
			{
				authorIdStr = con.readLine("Takie ID nie istnieje, podaj ID autora: ");
				continue;
			}
		}

		durationStr = con.readLine("Podaj długość filmu: ");		
		while(true) // Page number parsing
		{
			try
			{
				duration = Float.parseFloat(durationStr);
				if(duration <= 0.0f)
				{
					durationStr = con.readLine("Długość musi być większa od 0, podaj długość filmu: ");
					continue;
				}
				break;
			}
			catch(NumberFormatException e)
			{
				durationStr = con.readLine("Podaj długość (liczba zmiennoprzecinkowa) filmu: ");
				continue;
			}
		}

		publicationDate = con.readLine("Podaj datę publikacji: ");

		ret = new Course(-1, name, author, duration, publicationDate);

		System.out.println("\nUtworzono Course:\n"+ret.pretty());

		return ret;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public void setDuration(float duration)
	{
		this.duration = duration;
	}

	public Author getAuthor()
	{
		return author;
	}

	public float getDuration()
	{
		return duration;
	}

	public String objName()
	{
		return "Course";
	}

	public String pretty()
	{
		return String.format("Type: %s\nName: %s\nLength: %s\nAuthor: %s\nPublication date: %s\n", objName(), getName(), duration, author, getPublicationDate());
	}
}