package operation;

import java.util.*;
import java.io.File;
import java.nio.file.*;

public class Folder {

	   public static final String name = "src/main/Folder";
        private ArrayList<File> files = new ArrayList<File>();
	    //private static Map<String, String> files = new HashMap<String, String>();
	    

	    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();

	    File Dfiles = path.toFile();

	    File[] FolderFiles = Dfiles.listFiles();

	    public String getName() {
	        return name;
	    }

	    public void print() {
	    	System.out.println("Existing Files: ");
	    	files.forEach(f -> System.out.println(f));
	    }

	    public ArrayList<File> fillFiles(){
	    	files.clear();
	    	for (int i = 0; i < FolderFiles.length; i++) {
	    		if (FolderFiles[i].isFile()) {
	    			files.add(FolderFiles[i]);
	    		}
	    	}
	    	return files;
	    }

	    public ArrayList<File> getFiles(){
	    	return this.files;
	    }
}
