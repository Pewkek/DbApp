package classes;

import java.util.ArrayList;

public class Client extends Person implements IStorage<EduResource>
{
	ArrayList<EduResource> activeResources;

	Client(int id, String name, String surname)
	{
		super(id, name, surname);
	}

	public void addItem(EduResource toAdd) throws Exception
	{
		storageAdd(toAdd, activeResources);
	}

	public void removeItem(EduResource toRemove) throws Exception
	{
		storageRemove(toRemove, activeResources);
	}

	public EduResource getItem(int idx) throws IndexOutOfBoundsException
	{
		return activeResources.get(idx);
	}

	public EduResource getById(int idx)
	{
		return storageGetId(idx, activeResources);
	}

	public int itemCount()
	{
		return activeResources.size();
	}

	public String objName()
	{
		return "Client";
	}
}