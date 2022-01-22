package classes;

import java.util.ArrayList;

public class Storage implements IStorage<DbObject>
{
	private ArrayList<DbObject> data;

	public void addItem(DbObject toAdd) throws Exception
	{
		storageAdd(toAdd, data);
	}

	public void removeItem(DbObject toRemove) throws Exception
	{
		storageRemove(toRemove, data);
	}

	public DbObject getItem(int idx) throws IndexOutOfBoundsException
	{
		return data.get(idx);
	}

	public DbObject getById(int idx) throws IndexOutOfBoundsException
	{
		return storageGetId(idx, data);
	}

	public int itemCount()
	{
		return data.size();
	}
}
