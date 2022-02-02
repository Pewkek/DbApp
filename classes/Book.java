package classes;

import java.io.*;
import java.util.NoSuchElementException;
public class Book extends PaperResource
{
	public static enum Kind
	{
		CourseBook("Course Book"),
		Novel("Novel");

		final String kind;

		Kind(String kind)
		{
			this.kind = kind;
		}

		@Override
		public String toString()
		{
			return this.kind;
		}
	}
	private Author author;
	private int releaseNumber;
	private Kind kind;

	public Book(int id, String name, Author author, int releaseNumber, Kind kind, int pages, Publisher publisher, String publicationDate, String content)
	{
		super(id, name, pages, publisher, publicationDate, content);
		this.author = author;
		this.releaseNumber = releaseNumber;
		this.kind = kind;
	}

	public static DbObject fromUserInput(Storage s)
	{
		Console con = System.console();
		
		Book ret;
	
		String name = "N/A";

		String authorIdStr = "N/A";
		int authorId = -9999;
		Author author = null;

		String releaseNumberStr = "N/A";
		int releaseNumber = -1;

		String kindStr;
		Kind kind;

		String pagesStr = "N/A";
		int pages = -1;

		String publisherIdStr;
		int publisherId = -9999;
		Publisher publisher = null;

		String publicationDate = "N/A";
		String content = "N/A";
		
		
		
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

		releaseNumberStr = con.readLine("Podaj numer wydania: ");		
		while(true) // Release no. parsing
		{
			try
			{
				releaseNumber = Integer.parseInt(releaseNumberStr);
				break;
			}
			catch(NumberFormatException e)
			{
				releaseNumberStr = con.readLine("Podaj numer (liczba całkowita) wydania: ");
				continue;
			}
		}

		kindStr = con.readLine("Podaj gatunek: ");
		while(true)
		{
			try
			{
				kind = Kind.valueOf(kindStr);
				break;
			}
			catch(IllegalArgumentException e)
			{
				kindStr = con.readLine("Nie ma takiego gatunku, podaj gatunek: ");
				continue;
			}
		}

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

		ret = new Book(-1, name, author, releaseNumber, kind, pages, publisher, publicationDate, content);

		System.out.println("\nUtworzono Book:\n"+ret.pretty());

		return ret;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public void setReleaseNumber(int releaseNumber)
	{
		this.releaseNumber = releaseNumber;
	}

	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
	
	public Author getAuthor()
	{
		return author;
	}

	public int getReleaseNumber()
	{
		return releaseNumber;
	}

	public Kind getKind()
	{
		return kind;
	}

	public String objName()
	{
		return "Book";
	}

	public String stringType()
	{
		return this.kind + " Book";
	}

	public String pretty()
	{
		return String.format("Type: %s\nKind: %s\nName: %s\nAuthor: %s\nPublisher: %s\nRelease number: %d\nPublication date: %s\nPage count: %s", objName(), getKind(), getName(), author, getPublisher(), releaseNumber, getPublicationDate(),getPages());
	}
}