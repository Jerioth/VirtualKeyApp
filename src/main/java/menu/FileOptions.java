package menu;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import operation.Folder;
import menu.menuOptions;

public class FileOptions implements Menu {
	private Folder fileFolders = new Folder();
    private ArrayList<String> options = new ArrayList<>();
	//private static Map<String, String> options = new HashMap<String, String>();
    private static Scanner scanner = new Scanner(System.in);
	
    public FileOptions() {

    	//this.dir = dir;

        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
    }
    
    @Override
	public void GetInput()
    {// TODO Auto-generated method stub
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.BusinessOptions(selectedOption);
        }
    }

    @Override
    public void View()
    {// TODO Auto-generated method stub
        System.out.println("\nChanged menu");

        for (String s : options)  {
            System.out.println(s);
        }

    }

    

    @Override
    public void BusinessOptions(int option)
    {// TODO Auto-generated method stub
        switch(option) {

            case 1: 
			
                this.AddFile();
                break;
            case 2: 
                this.SearchFile();
                break;
            case 3:
               this.DeleteFile();
                break;
            default:
                System.out.println("Invalid Option");
                break;

        }

    }

    //TODO: Add functionality to all 

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

       // System.out.println("Add File: " + fileName);

		try {
			Path path = FileSystems.getDefault().getPath(fileFolders.name + fileName).toAbsolutePath();
			File file = path.toFile();

		      if (file.createNewFile()) {
		    	  System.out.println("File " + file.getName() + " is Successfully Added");
		    	  fileFolders.getFiles().add(file);
		      } else {
		        System.out.println(file.getName() + " Already Exits.");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}



    public void DeleteFile() {
    	fileFolders.getFiles();

    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);


	     //TODO: Delete file
		Path path = FileSystems.getDefault().getPath("src/main/resources/"+fileName).toAbsolutePath();
		File file = path.toFile();
		  System.out.print("Enter file name to delete: ");
	        String fileNameToDelete = scanner.nextLine();
	        if (options.contains(fileNameToDelete)) {
	            options.remove(fileNameToDelete);
	            System.out.println("File deleted: " + fileNameToDelete);
	        } else {
	            System.out.println("File not found: " + fileNameToDelete);
	        }
    }

    public void SearchFile() {

    	 System.out.print("Enter file name to search: ");
         String fileNameToSearch = scanner.nextLine();
         if (options.contains(fileNameToSearch)) {
             System.out.println("File found: " + fileNameToSearch);
         } else {
             System.out.println("File not found: " + fileNameToSearch);
         }
    }

    private String getInputString(){

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }

    private int getOption(){
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }
	
}
