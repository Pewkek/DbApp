package classes;

import java.util.*;

public class EduResource extends DbObject
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
}