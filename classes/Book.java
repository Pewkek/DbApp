package classes;

import java.util.Calendar;

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

	public Book(int id, String name, Author author, int releaseNumber, Kind kind, int pages, Publisher publisher, Calendar publicationDate, String content)
	{
		super(id, name, pages, publisher, publicationDate, content);
		this.author = author;
		this.releaseNumber = releaseNumber;
		this.kind = kind;
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
		return String.format("Type: %s\nKind: %s\nName: %s\nAuthor: %s\nPublisher: %s\nRelease number: %d\nPublication date: %s\nPage count: %s", objName(), getKind(), getName(), author, getPublisher(), releaseNumber, getPublicationString(),getPages());
	}
}