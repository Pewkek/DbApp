package classes;

import java.util.Date;

public abstract class EduResource extends DbObject
{
	Date publicationDate;

	EduResource(int id, String name, Date publicationDate)
	{
		super(id, name);
		this.publicationDate = publicationDate;
	}

	public void setPublicationDate(Date publicationDate)
	{
		this.publicationDate = publicationDate;
	}

	public Date getPublicationDate()
	{
		return publicationDate;
	}

	public void addToClient(Client which) throws Exception
	{
		try
		{
			which.addItem(this);
		}
		catch(Exception e)
		{
			throw new Exception("Client already has this resource");
		}
	}
}