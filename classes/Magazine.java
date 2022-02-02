package classes;
import java.io.*;
import java.util.NoSuchElementException;

public class Magazine extends PaperResource
{
	Magazine(int id, String name, int pages, Publisher publisher, String publicationDate, String content)
	{
		super(id, name, pages, publisher, publicationDate, content);
	}

	public static DbObject fromUserInput(Storage s)
	{
		Console con = System.console();
		
		Magazine ret;
	
		String name = "N/A";

		String pagesStr = "N/A";
		int pages = -1;

		String publisherIdStr;
		int publisherId = -9999;
		Publisher publisher = null;

		String publicationDate = "N/A";
		String content = "N/A";
		
		name = con.readLine("Podaj nazwę: ");

		pagesStr = con.readLine("Podaj liczbę stron: ");		
		while(true) // Page number parsing
		{
			try
			{
				pages = Integer.parseInt(pagesStr);
				if(pages <= 0)
				{
					pagesStr = con.readLine("Liczba stron musi być większa od 0, podaj liczbę stron: ");
					continue;
				}
				break;
			}
			catch(NumberFormatException e)
			{
				pagesStr = con.readLine("Podaj liczbę (liczba całkowita) stron: ");
				continue;
			}
		}

		publisherIdStr = con.readLine("Podaj ID wydawcy: ");
		while(true) // Publisher parsing
		{
			try
			{
				publisherId = Integer.parseInt(publisherIdStr);
				DbObject obj = s.getById(publisherId);
				if(!(obj instanceof classes.Publisher))
				{
					publisherIdStr = con.readLine("Podaj poprawne ID wydawcy: ");
					continue;
				}
				publisher = (Publisher) obj;
				break;
			}
			catch(NumberFormatException e)
			{
				publisherIdStr = con.readLine("Podaj ID (liczba całkowita) wydawcy: ");
				continue;
			}
			catch(NoSuchElementException e)
			{
				publisherIdStr = con.readLine("Takie ID nie istnieje, podaj ID wydawcy: ");
				continue;
			}
		}

		publicationDate = con.readLine("Podaj datę publikacji: ");
		content = con.readLine("Wpisz treść: ");

		ret = new Magazine(-1, name, pages, publisher, publicationDate, content);

		System.out.println("\nUtworzono Magazine:\n"+ret.pretty());

		return ret;
	}

	public String objName()
	{
		return "Magazine";
	}

	public String pretty()
	{
		return String.format("Type: %s\nName: %s\nPublisher: %s\nPublication Date: %s\nPage count: %d", objName(), getName(), getPublisher(), getPublicationDate(), getPages());
	}
}