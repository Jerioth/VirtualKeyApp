package operation;
import java.io.File;
import java.nio.file.*;
import operation.Folder;


public class FolderOptions {

    private static Folder fileFolder = new Folder();

    public static void PrintFiles() {

    	fileFolder.fillFiles();

        for (File file : FolderOptions.getFileFolder().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Folder getFileFolder() {
        return fileFolder;
    }

    public static void setFileFolder(Folder fileFolder) {
        FolderOptions.fileFolder = fileFolder;
    }


}

