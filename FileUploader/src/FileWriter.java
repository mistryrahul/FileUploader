import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class FileWriter {

	public static void main(String[] args) 
	{
	   
		int c=0; // temp var in main loop 
    	double no_of_lines;
		String tmp_val;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		
		try
		{
			FileChannel src = null;
			FileChannel dest=null;
			String folder_path=null;
			File[] listOfFiles;
			File folder;
			
           //    /home/rv/Desktop/files_to_upload/new Updates_till_october_20/sept_data_prepared
		   //    /home/rv/Desktop/files_to_upload/new Updates_till_october_20/oct_data_prepared 	
			
			folder_path="/home/rv/Desktop/pmcap_dec_16";

			String folder_file_nm="pmcap";   // change file and folder name here
			
            
			
//			String folder_file_nm_1="pmcap";
					
//            folder_file_nm_1=folder_file_nm;
			
			folder = new File(folder_path+"/"+folder_file_nm);
			listOfFiles = folder.listFiles();
			
			System.out.println("File_Size-->>"+listOfFiles.length);
			
			System.out.println("<<<<<<--Started Coping----->>>>>>>");
					
			
			for( c=listOfFiles.length ;c>=1;c--)   // main loop( loop size vary table to table)
			{
			    System.out.println("File Running--->>"+c);
			    
				src = new FileInputStream(folder_path+"/"+folder_file_nm+"/"+folder_file_nm+" ("+c+").txt").getChannel(); 
				dest = new FileOutputStream("/home/rv/Desktop/"+folder_file_nm+".ace", true).getChannel();  //<---second argument for FileOutputStream
				dest.position( dest.size() );
				src.transferTo(0, src.size(), dest);
              
			}
			
			System.out.println("<<<<----Copying Complete---->>>");
			
			
			
		}
		catch (Exception e) 
		{
		   	e.printStackTrace();
		}
		
		
		
		

	}

}
