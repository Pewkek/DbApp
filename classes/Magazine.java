package classes;

import java.util.Calendar;

public class Magazine extends PaperResource
{
	Magazine(int id, String name, int pages, Publisher publisher, Calendar publicationDate, String content)
	{
		super(id, name, pages, publisher, publicationDate, content);
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