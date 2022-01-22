package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface IStorage<T>
{
	default void storageAdd(T toAdd, ArrayList<T> storage) throws IllegalArgumentException
	{
		Iterator<DbObject> it = (Iterator<DbObject>) storage.iterator();
		DbObject toAddBase = (DbObject) toAdd;

		while(it.hasNext())
		{
			DbObject res = it.next();
			if(toAddBase.getId() == res.getId())
			{
				throw new IllegalArgumentException("Item already exists");
			}
		}

		storage.add(toAdd);
	}

	default void storageRemoveId(int idx, ArrayList<T> storage) throws NoSuchElementException
	{
		Iterator<DbObject> it = (Iterator<DbObject>) storage.iterator();

		while(it.hasNext())
		{
			DbObject res = it.next();
			if(res.getId() == idx)
			{
				it.remove();
				return;
			}
		}
		throw new NoSuchElementException("Item with such ID does not exist");
	}

	default T storageGetId(int idx, ArrayList<T> storage) throws NoSuchElementException
	{
		Iterator<T> it = storage.iterator();

		while(it.hasNext())
		{
			T res = it.next();
			DbObject resDbObj  = (DbObject) res;
			if(resDbObj.getId() == idx)
			{
				return res;
			}
		}
		throw new NoSuchElementException("Item does not exist");
	}

	public void addItem(T toAdd);
	public void removeItem(int idx) throws IndexOutOfBoundsException;
	public void removeItemById(int idx) throws NoSuchElementException;
	public T getItem(int idx) throws IndexOutOfBoundsException;
	public T getById(int idx) throws NoSuchElementException;
	public int itemCount();
}
