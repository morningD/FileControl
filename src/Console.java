import org.apache.commons. cli.BasicParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
//import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;


public class Console {
	 
	public static void main(String[] args) throws IOException {
		DirectoryHandler handler = new DirectoryHandler();
		while(true){
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			String[] command = line.split(" ");
			String dir1 = null, dir2 = null, mode = null, operation = null;
			try {
				Options FileOptions = new Options();

				FileOptions.addOption("h", false, "Print help for <FileCLI>");
				FileOptions.addOption("d", true,  "source directory");
				FileOptions.addOption("d2", true,  "aim directory");
				FileOptions.addOption("m", true,  "mode");
				FileOptions.addOption("o", true, "operation");

				BasicParser parser = new BasicParser();
				CommandLine cl = parser.parse(FileOptions, command);

				if( cl.hasOption('h') ) {
					HelpFormatter f = new HelpFormatter();
					f.printHelp("OptionsTip", FileOptions);
				}
				else{
					mode = cl.getOptionValue("m");
				}
			}
			catch(ParseException e) {
				e.printStackTrace();
			}


			if(command[0].equals("mkdir")){
				handler.makeDirectory(command[1]);
			}else if(command[0].equals("cd")){
				handler.enterDirectory(command[1]);
			}else if(command[0].equals("ls")){
				handler.listDirectory();
			}
		}
//		String command = "java -jar D:\\java\\workspace\\FileControl\\jar\\" + args[0] + ".jar";
//		Runtime runtime = Runtime.getRuntime();
//		try{
//			/*exec command*/
//			Process p = Runtime.getRuntime().exec(command);
//			/*print exec output*/
//			BufferedReader br = new BufferedReader(new InputStreamReader(p
//                    .getInputStream()));
//            String inline;
//            while ((inline = br.readLine()) != null) {
//                System.out.println(inline);     
//            }
//            br.close();
//		}catch(Exception e){
//			System.out.println("Error!");
//		}
//		
//		String[] arg = {"-d1", "C:\\" };
//		OptionHandler(arg);
	}
}