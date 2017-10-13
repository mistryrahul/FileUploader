import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Url_compare {

	public static void main(String[] args)
	{
	    
		double no_of_lines;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		String tmp_val=null;
		final Pattern pattern = Pattern.compile("<loc>(.+?)</loc>");
		Matcher matcher;
		int i=1;  // make this the last id after each operation
		int i_i=0;
		String str1 = null;  
		
		try
		{   
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/test.xml"), "UTF-8");
						
			
			
			while (it.hasNext()) // if the file has lines 
	 	    {
                   
				 tmp_val=it.nextLine();

					
					if(tmp_val.equals("<<eof>>"))
					{
						i=1;
						break;
						
					}
//				if(i==5)
//				{
//					System.out.println("-=-=-=BREAK-=-=-=");
//					break;
//					
//				}
				  
					matcher = pattern.matcher(tmp_val);
					matcher.find(); 	
									
//				String[] separated = matcher.group(1).split("\\|");
				
				
//				System.out.println(matcher.group(1));
//				str1 = matcher.group(1).replace('|', ',');
				str1 = matcher.group(1);
				
				System.out.println(str1);
				System.out.println(i);
				i++;
				
			
						
	 	    }
			System.out.println("-------COMPLETE--------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
