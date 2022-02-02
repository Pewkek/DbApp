package classes;

import java.util.ArrayList;

public class Storage implements IStorage<DbObject>
{
	private ArrayList<DbObject> data = new ArrayList<DbObject>();
	private int idCounter = 0;
	public void addItem(DbObject toAdd)
	{
		try
		{
			toAdd.setId(idCounter);
			storageAdd(toAdd, data);
			idCounter++;
		}
		catch(IllegalArgumentException e)
		{
			System.err.println("Error: Item already exists");
		}
	}

	public void removeItem(int idx)
	{
		data.remove(idx);
	}

	public void removeItemById(int idx)
	{
		storageRemoveId(idx, data);
	}

	public DbObject getItem(int idx)
	{
		return data.get(idx);
	}

	public DbObject getById(int idx)
	{
		return storageGetId(idx, data);
	}

	public int itemCount()
	{
		return data.size();
	}
}
