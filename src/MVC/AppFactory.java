package src.MVC;

public interface AppFactory {
	
	 Model makeModel();
	 View makeView(String type);
	 String[] getViews();
	 String[] getCommands();
	 String getTitle();
	 String getHelp();
	 String about();
}