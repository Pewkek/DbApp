package classes;

import java.util.Date;

public class Course extends EduResource
{
	private Author author;
	private float duration;

	Course(int id, String name, Author author, float duration, Date publicationDate)
	{
		super(id, name, publicationDate);
		this.author = author;
		this.duration = duration;
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
		return "Video Course";
	}

	public String pretty()
	{
		return String.format("Type: %s\nName: %s\nLength: %s\nAuthor: %s\nPublication date: %s\n", objName(), getName(), duration, author, getPublicationDate());
	}
}