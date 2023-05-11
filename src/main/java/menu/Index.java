package menu;
import java.util.*;
import operation.FolderOptions;
import menu.menuOptions;

public class Index implements Menu {

	  private String welcomeMsg = "Welcome to VirtualKey";
	    private String developer = "Developer: Jerioth Muhuluma";

	    private ArrayList<String> options = new ArrayList<>();


	    public Index() {
	        options.add("1. View Files");
	        options.add("2. Business Operations");
	        options.add("3. Quit");

	    }
	    
	    public void WelcomView()
	    {
	        System.out.println(welcomeMsg);
	        System.out.println(developer);
	        System.out.println("\n");

	        for (String s : options)  {
	            System.out.println(s);
	        }

	    }

	   /* @Override
	    public void View() {
	    	System.out.println("Main Menu");
	        for (String s : options)  {
	            System.out.println(s);
	        }

	    }*/
	    
	    public void GetInput(){
	        int selectedOption;
	        while ((selectedOption = this.getBusinessOptions()) != 3) {
	            this.BusinessOptions(selectedOption);
	        }
	    }

	    @Override
	    public void BusinessOptions(int option) {
	        switch(option) {

	            case 1: // View Files
	            	this.ViewFiles();
	                this.View();
	                break;
	            case 2: // View Submenu
	            	menuOptions.setSelectedMenu(menuOptions.FileOptions);
	            	menuOptions.getSelectedMenu().View();
	            	menuOptions.getSelectedMenu().GetInput();

	                break;
	                /*FileOptions screen = new FileOptions();
	                screen.View();
	                screen.GetUserInput();
	                break;
	                */
	            default:
	                System.out.println("Invalid Option");
	                break;

	        }

	    }

	    
	    @Override
	    public void View() {
	    	System.out.println("Main Menu");
	        for (String s : options)  {
	            System.out.println(s);
	        }

	    }


	    public void ViewFiles() {

	        

	        System.out.println("Files: ");
	    	FolderOptions.PrintFiles();

	    }
	    private int getBusinessOptions() {
	        Scanner in = new Scanner(System.in);

	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {

	        }
	        return returnOption;

	    }

		
}
