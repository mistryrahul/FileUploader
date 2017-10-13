import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;


public class Ace_to_csv_Converter 
{
   
	public static void main(String[] args)
	{
		
		double no_of_lines;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		String str1 = null;  
		
		try
		{   

//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EXPENCERATIO.ace"), "UTF-8");
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/DB_Upload/pmcap.ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/SchemeISINMaster.ace"), "UTF-8");
			ArrayList<String> mn_lst = new ArrayList<String>();
			
			
			while (it.hasNext()) // if the file has lines 
	 	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
//				String[] separated = matcher.group(1).split("\\|");
				
				
//				System.out.println(matcher.group(1));
				str1 = matcher.group(1).replace('|', ',');
				mn_lst.add(str1);
						
	 	    }
			
			
			PrintWriter writer = new PrintWriter("/home/rv/Desktop/pmcap.csv", "UTF-8");
			
			for(String ob:mn_lst)
			{
				
				writer.println(ob);
				
			}
			
			writer.close();
			
			System.out.println("<<<<--Report Complete----->>>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
