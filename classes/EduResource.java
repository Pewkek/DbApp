package classes;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public abstract class EduResource extends DbObject
{
	Calendar publicationDate;

	EduResource(int id, String name, Calendar publicationDate)
	{
		super(id, name);
		this.publicationDate = publicationDate;
	}

	public void setPublicationDate(Calendar publicationDate)
	{
		this.publicationDate = publicationDate;
	}

	public Calendar getPublicationDate()
	{
		return publicationDate;
	}

	public String getPublicationString()
	{
		SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy");
		return fmt.format(publicationDate.getTime());
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