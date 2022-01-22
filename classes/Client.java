package classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Client extends Person
{
	ArrayList<EduResource> activeResources;

	Client(int id, String name, String surname)
	{
		super(id, name, surname);
	}

	public void addItem(EduResource toAdd) throws Exception
	{
		Iterator<EduResource> it = activeResources.iterator();

		while(it.hasNext())
		{
			EduResource res = it.next();
			if(res.getId() == toAdd.getId())
			{
				throw new Exception("Item already exists");
			}
		}

		activeResources.add(toAdd);
	}

	public void removeItem(EduResource toRemove) throws Exception
	{
		Iterator<EduResource> it = activeResources.iterator();

		while(it.hasNext())
		{
			EduResource res = it.next();
			if(res.getId() == toRemove.getId())
			{
				it.remove();
				return;
			}
		}
		throw new Exception("Item does not exist");
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