package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Client extends Person implements IStorage<EduResource>
{
	ArrayList<EduResource> activeResources = new ArrayList<EduResource>();

	Client(int id, String name, String surname)
	{
		super(id, name, surname);
	}

	public static DbObject fromUserInput()
	{
		Console con = System.console();

		String name = "N/A";
		String surname = "N/A";

		name = con.readLine("Podaj imię: ");
		surname = con.readLine("Podaj nazwisko: ");
		Client ret = new Client(-1, name, surname);
		System.out.println("\nUtworzono Client:\n"+ret.pretty());

		return (DbObject) ret;
	}

	public void addItem(EduResource toAdd)
	{
		try
		{
			storageAdd(toAdd, activeResources);
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
			activeResources.remove(idx);
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
			storageRemoveId(idx, activeResources);
		}
		catch(NoSuchElementException e)
		{
			System.err.println(e);
		}
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