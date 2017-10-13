import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Custome_FileConcatinate 
{
    public static void main(String...args)
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
			folder_path="/home/rv/Desktop/one_mion_data/oneminutedata/2017";
			String folder_file_nm="";   // change file and folder name here
			
            String month_arr[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
            String file_name_arr[]={"BANKNIFTY","BANKNIFTY_F1","INDIAVIX","NIFTY","NIFTY_F1"};
            String tmp="";
			for(int k=0;k<month_arr.length;k++)
			{
				tmp="NIFTY50_"+month_arr[k]+"2017"; 
				folder = new File(folder_path+"/"+month_arr[k]+"/"+tmp);	
				
				listOfFiles = folder.listFiles();
				System.out.println("<<<<<<--Started Coping----->>>>>>>");
						
				System.out.println("Month----->>>"+month_arr[k]);
				for( c=0 ;c<listOfFiles.length;c++)   // main loop( loop size vary table to table)
				{					
						if(listOfFiles[c].isFile())
						{
							System.out.println(listOfFiles[c].getName());
//						    System.out.println("File Running--->>"+c );
//						    
							src = new FileInputStream(folder_path+"/"+month_arr[k]+"/"+tmp+"/"+listOfFiles[c].getName()).getChannel(); 
							dest = new FileOutputStream("/home/rv/Desktop/Desti/2017/"+listOfFiles[c].getName(), true).getChannel();  //<---second argument for FileOutputStream
							dest.position( dest.size() );
							src.transferTo(0, src.size(), dest);
						}
	              
				}
			}
			
			System.out.println("<<<<----Copying Complete---->>>");
			
			
			
		}
		catch (Exception e) 
		{
		   	e.printStackTrace();
		}
    }
	
	
}
