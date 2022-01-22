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

	default void storageRemove(T toRemove, ArrayList<T> storage) throws NoSuchElementException
	{
		Iterator<DbObject> it = (Iterator<DbObject>) storage.iterator();
		DbObject toRemoveBase = (DbObject) toRemove;

		while(it.hasNext())
		{
			DbObject res = it.next();
			if(toRemoveBase.getId() == res.getId())
			{
				it.remove();
				return;
			}
		}
		throw new NoSuchElementException("Item does not exist");
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

	public void addItem(T toAdd) throws Exception;
	public void removeItem(T toRemove) throws Exception;
	public T getItem(int idx) throws IndexOutOfBoundsException;
	public T getById(int idx) throws NoSuchElementException;
	public int itemCount();
}
