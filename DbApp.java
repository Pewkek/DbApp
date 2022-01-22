import classes.*;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.*;
import java.lang.reflect.*;

class DbApp
{
	public static void main(String[] arg)
	{
		//Storage db = new Storage();
		Publisher p1 = new Publisher(0, "EduRoam", "Kocia 20, 20-005 Pcim Dolny");
		Author a1 = new Author(1, "Marcin", "Najman");
		Book b1 = new Book(2, "Testowa", a1, 1, Book.Kind.Novel, 100, p1, (Calendar) (new GregorianCalendar(1980, 0, 20)), "Lorem ipsum");	
		Storage db = new Storage();
		db.addItem(b1);
		Book xd = (Book) db.getItem(0);
		System.out.println(xd.pretty());
	}
}