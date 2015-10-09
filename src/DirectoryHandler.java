import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fengzipei on 15/10/9.
 */
public class DirectoryHandler {
    private File currentDirectory;

    public DirectoryHandler(){
        this.currentDirectory = new File(".");
    }

    public boolean copyFolder(String directoryName, String toPath) throws IOException{
        File fromDirectory = new File(directoryName);
        File toDirectory = new File(toPath);

        if(!fromDirectory.exists()){
            System.out.println("Source directory is not exists!");
            return false;
        }
        if(!toDirectory.exists()){
            System.out.println("Destination directory is not exists!");
            return false;
        }
        if(fromDirectory.isFile()){
            System.out.println("Source directory is not a valid path!");
            return false;
        }
        if(toDirectory.isFile()){
            System.out.println("Destination directory is not a valid path!");
            return false;
        }
        if(fromDirectory.isDirectory() && toDirectory.isDirectory()){
            makeDirectory(toPath + "/" + directoryName);
            File[] fileList = fromDirectory.listFiles();
            for(File file : fileList){
                if(file.isFile()){
                    //fileHandler requested
                }
            }
        }
    }

    public boolean makeDirectory(String directoryName) throws IOException{
        File newDirectory = new File(directoryName);
        if(!newDirectory.exists()) {
            if (newDirectory.mkdir()) {
                System.out.println("Create directory " + newDirectory.getAbsolutePath() + " successfully!");
                return true;
            }
            else {
                System.out.println("Failed to create directory!");
                return false;
            }
        }
        else{
            System.out.println("Failed to create directory! (The directory has already exists or No root authority)");
            return false;
        }
    }

    public void deleteDirectory(String directoryName) throws IOException{
        File directory = new File(directoryName);
        if(!directory.exists()){
            System.out.println("Directory doesn't exist!");
            return;
        }
        if(directory.isFile()){
            directory.delete();
        }
        else if(directory.isDirectory()){
            File[] fileList = directory.listFiles();
            for(File file : fileList) {
                deleteDirectory(file.getAbsolutePath());
            }
            directory.delete();
        }
        else{
            System.out.println("Failed to delete " + directoryName);
            return;
        }
    }

    public void enterDirectory(String directoryName){
        File diretory = new File(directoryName);
        if(diretory.isFile()){
            System.out.println(diretory.getAbsolutePath() + " is a file!");
            return;
        }
        if(diretory.isDirectory()){
            currentDirectory = new File(directoryName);
            System.setProperty("user.dir", currentDirectory.getAbsolutePath());
        }
    }

    public void listDirectory(){
        File[] fileList = currentDirectory.listFiles();
        System.out.println(currentDirectory.getName());
        for(File file : fileList){
            System.out.println("    " + file.getName());
        }
    }

    public void zip(String directoryName){
        //fileHandler requested
    }

    public static void main(String[] args) throws IOException {
        DirectoryHandler handler = new DirectoryHandler();
        //System.out.println(handler.makeDirectory("./directory/"));
        //handler.deleteDirectory("./directory");
        //handler.listDirectory();
        //handler.enterDirectory("./directory");
        //handler.listDirectory();
    }
}
