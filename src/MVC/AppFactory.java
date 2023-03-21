package src.MVC;

public interface AppFactory {
	
	 Model makeModel();
	 View makeView(Model model);
	 Command makeEditCommand(Model model, String type, Object source);
	 String[] getEditCommands();
	 String getTitle();
	 String getHelp();
	 String about();
}