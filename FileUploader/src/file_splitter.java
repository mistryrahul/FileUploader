import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class file_splitter {

	public static void main(String[] args) {
		
double no_of_lines,no_of_splits=10,line_in_each_split=0;
		
		try {
			
	 	LineNumberReader lnr = new LineNumberReader(new FileReader(new File("/home/rv/Desktop/mf_portfolio_new/mf_portfolio_historical_data.ace")));
     	lnr.skip(Long.MAX_VALUE);
     	int cnt=0;
     	no_of_lines = (lnr.getLineNumber() + 1); //Add 1 because line index starts at 0
     	line_in_each_split =  Math.ceil(no_of_lines / no_of_splits ); // Average split file line length
        //System.out.println("Line NUmber-->"+lnr.getLineNumber() + 1);  
	    
     	
     													// Source File path
     	LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/mf_portfolio_new/mf_portfolio_historical_data.ace"), "UTF-8");
     	try {
     		   		
		     	for(int s_p=1;s_p<=no_of_splits;s_p++) // Number Of Splits 
		     	{	
		     		int split_starter=0;
		     		File f1=null;
		     		
		     		for(int s1=1;s1<=line_in_each_split;s1++) // Number of Lines in Each Split
		     		{
		     			if (it.hasNext()) // if the bas file has lines 
		         	    {
		     		            
		     				if (split_starter==0)
		     				{
		     				   //create file with name and add the line to the file in case of 1st record
		     					              // destination file path and name with extension
		     					f1= new File("/home/rv/Desktop/portfolio_file_parts/port_folio_part_"+s_p+".ace");
		     					FileUtils.writeStringToFile(f1, it.nextLine()+"\n", true);
		     				}
		     				else
		     				{  // add the line to the already created file
		     					FileUtils.writeStringToFile(f1, it.nextLine()+"\n", true);	
		     				}
		     				
		     				
		         	    	     	        
		         	    }
		     			split_starter++;
		     		}
		     		
		     	}   
     	   }
	       catch(Exception e)
	       {
	     		 System.out.println("Runtime Error---");
	     		 e.printStackTrace();
	       }
	      finally {
	     	    LineIterator.closeQuietly(it);
	     	}
     	
           System.out.println("-------------File Split Complete--------------");
	 	   	
		} catch (IOException e) {
		     System.out.println("Error"+e.getMessage());
			 e.printStackTrace();
		}	
		
		
	}

}
