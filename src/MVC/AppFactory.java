package src.MVC;

public interface AppFactory {
	
	 Model makeModel();
	 View makeView(String type);
	 Command makeEditCommands(String name);
	 String[] getEditCommands();
	 String getTitle();
	 String getHelp();
	 String about();
}