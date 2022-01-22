package classes;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Storage implements IStorage<DbObject>
{
	private ArrayList<DbObject> data = new ArrayList<DbObject>();
	public void addItem(DbObject toAdd)
	{
		try
		{
			storageAdd(toAdd, data);
		}
		catch(IllegalArgumentException e)
		{
			System.err.println("Error: Item already exists");
		}
	}

	public void removeItem(int idx)
	{
		try
		{
			data.remove(idx);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Error: Can't remove item: index out of bounds");
		}
	}

	public void removeItemById(int idx)
	{
		try
		{
			storageRemoveId(idx, data);
		}
		catch(NoSuchElementException e)
		{
			System.err.println(e);
		}
	}

	public DbObject getItem(int idx)
	{
		try
		{
			return data.get(idx);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.err.println("Error: Can't get item: index out of bounds");
			return null;
		}
	}

	public DbObject getById(int idx)
	{
		try
		{
			return storageGetId(idx, data);
		}
		catch(NoSuchElementException e)
		{
			System.err.println("Error: Item with such ID does not exist");
			return null;
		}
	}

	public int itemCount()
	{
		return data.size();
	}
}
