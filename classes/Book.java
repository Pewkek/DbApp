package classes;

public class Book
{
	public static enum BookType
	{
		CourseBook("Course Book"),
		Novel("Novel");

		final String type;

		BookType(String type)
		{
			this.type = type;
		}

		@Override
		public String toString()
		{
			return this.type;
		}
	}

	BookType type;
	Author author;
	int pages;
	int releaseNumber;
	String content;

	public void setType(BookType type)
	{
		this.type = type;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}
	
	public BookType getType()
	{
		return type;
	}
	
	public Author getAuthor()
	{
		return author;
	}
}