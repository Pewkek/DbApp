import classes.*;

class DbApp
{
	public static void main(String[] arg)
	{
		CLI app = new CLI();

		CLI.showHelp();
		app.optionLoop();
	}
}