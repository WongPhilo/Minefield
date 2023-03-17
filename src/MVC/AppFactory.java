package src.MVC;

public interface AppFactory {
	
	 Model makeModel();
	 View makeView(Model model);
	 Command makeEditCommand(Model model, String type);
	 String[] getEditCommands();
	 String getTitle();
	 String getHelp();
	 String about();
}