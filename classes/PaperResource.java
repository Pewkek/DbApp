package classes;

import java.util.Date;

public abstract class PaperResource extends EduResource
{
	private int pages;
	private Publisher publisher;
	private String content;
	
	PaperResource(int id, String name, int pages, Publisher publisher, Date publicationDate, String content)
	{
		super(id, name, publicationDate);
		this.publisher = publisher;
		this.content = content;
	}

	public Publisher getPublisher()
	{
		return publisher;
	}

	public int getPages()
	{
		return pages;
	}

	public String getContent()
	{
		return content;
	}

	public void setPublisher(Publisher publisher)
	{
		this.publisher = publisher;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Override
	public String toString()
	{
		return getName() + " ";
	}
}
