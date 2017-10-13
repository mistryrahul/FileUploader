import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileWriter_Custom {

	public static void main(String[] args) 
	{
	  
		int c=1; // temp var in main loop 
    	double no_of_lines;
		String tmp_val;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		
		try
		{
			FileChannel src = null;
			FileChannel dest=null;
			
//			String file_name_list[]={"ap_nav"};
			
			String file_name_list[]={"pmcap"};
			
//			String file_name_list[] = {"amc_aum","amc_keypersons","amc_mst","amc_paum","amfi_type","ap_nav","asset_allocation_av","avg_maturity","avg_scheme_aum","benchmarkindices_return",
//					"bm_indices_return","classwisereturn","companymaster_new","currentnav","currentnav_new","dailyfundmanager","divdetails","expenceratio",	"fmps_details"
//					,"fmp_yielddetails","fundmanager_mst","gsecmaster","index_mst","invst_eligibility","invst_eligibility_mst","mergedschemes","mf_abs_return","mf_ans_return"
//					,"mf_companymaster","mf_divdetails","mfholdings_new","mf_portfolio","mf_portfolio_new","mf_ratios","mf_ratios_bm","mf_return","mf_sip","mf_stp",
//					"mf_swp","navhist","navhistfull","navhist_hl","pmcap","portfolio_inout","quaterly_performance","quotedata","scheme_assetalloc","scheme_aum",
//					"scheme_details","scheme_details_full","scheme_details_new","scheme_details_rr","scheme_details_total","scheme_eq_details","scheme_index_part",
//					"schemeisinmaster","schemeisinmaster_new","schemeload","scheme_master","scheme_master_new","scheme_objective","scheme_paum","scheme_ratio_av",
//					"scheme_rgess","schemert_code","schemes_info_rr","scheme_sip_xirr","scheme_status","sect_allocation","sect_allocation_fin","yearly_performance"};
		
			
//			String file_name_list[] =  {"yearly_performance","sect_allocation_fin","sect_allocation","schemes_info_rr","schemert_code","schemeisinmaster_new","schemeisinmaster","scheme_status","scheme_sip_xirr","scheme_rgess","scheme_ratio_av","scheme_paum","scheme_objective","scheme_master_new","scheme_master","scheme_index_part","scheme_eq_details","scheme_details_total","scheme_details_rr","scheme_details_new","scheme_details_full","scheme_details","scheme_aum","scheme_assetalloc","quotedata","quaterly_performance","portfolio_inout","pmcap","navhistfull","navhist_hl","navhist","mfholdings_new","mf_swp","mf_stp","mf_sip","mf_return","mf_ratios_bm","mf_ratios","mf_portfolio_new","mf_portfolio","mf_divdetails","mf_companymaster","mf_ans_return","mf_abs_return","mergedschemes","invst_eligibility_mst","invst_eligibility","gsecmaster","fmps_details","fmp_yielddetails","expenceratio","divdetails","currentnav_new","currentnav","companymaster_new","classwisereturn","bm_indices_return","benchmarkindices_return","avg_scheme_aum","avg_maturity","avg_amc_aum","asset_allocation_av","ap_nav.csv","amfi_type","amc_paum","amc_keypersons","amc_aum"};
			
//			String folder_file_nm="bm_indices_return_tt";   // change file and folder name here
			
            
			
//			String folder_file_nm_1="pmcap";
					
//            folder_file_nm_1=folder_file_nm;
			
			
			System.out.println("<<<<<<--Started Coping----->>>>>>>");
			
	   for(String folder_file_nm : file_name_list)
	   {
		   System.out.println("File Name-->>"+folder_file_nm);
		   c=1;
		   while(true)   // main loop( loop size vary table to table)
			{		
				try
				{
					
					    
					    
						src = new FileInputStream("/home/rv/Desktop/"+folder_file_nm+"/"+folder_file_nm+" ("+c+").ace").getChannel(); 
						dest = new FileOutputStream("/home/rv/Desktop/"+folder_file_nm+".ace", true).getChannel();  //<---second argument for FileOutputStream
						dest.position( dest.size() );
						src.transferTo(0, src.size(), dest);
						
		              c++;
				}
				catch(FileNotFoundException e)
				{
//				   e.printStackTrace();	
					break;
					
				}
			}
		   System.out.println("File Count--->>"+c);
	   }
			
			
			
			
		}
		catch (Exception e) 
		{
		   	e.printStackTrace();
		}
		finally {
			System.out.println("<<<<----Copying Complete---->>>");
		}
		

	}

}
