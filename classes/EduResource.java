package classes;

public abstract class EduResource extends DbObject
{
	String publicationDate;

	EduResource(int id, String name, String publicationDate)
	{
		super(id, name);
		this.publicationDate = publicationDate;
	}

	public void setPublicationDate(String publicationDate)
	{
		this.publicationDate = publicationDate;
	}

	public String getPublicationDate()
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