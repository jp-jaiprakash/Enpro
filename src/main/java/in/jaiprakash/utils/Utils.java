/**
 * 
 */
package in.jaiprakash.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class Utils {

	public static Date getTodaysUTCdate(){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		return StringToDate(calendar.getTimeInMillis());
	}

	public static Date getAssignedUTCdate(String timeinMilli){
		
//		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		return StringToDate(Long.parseLong(timeinMilli));
	}
	/**
	 * @return
	 */
	private static Date StringToDate(long lDate) {
		// TODO Auto-generated method stub
		
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	String formattedDate = sdf.format(new Date(lDate));
	
	SimpleDateFormat utcsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date parsedDate = null;
	try{
		parsedDate = utcsdf.parse(formattedDate);
	}catch(Exception ex){
		
	}
		return parsedDate;
	}
	
	public static String getJobType(String jobDesc){
		if(jobDesc.toUpperCase().startsWith("STK")){
			return "Stock Job ";
		}else if(jobDesc.toUpperCase().startsWith("SJ")){
			return "Sub Job ";
		}else{
			return "Normal Job ";
		}
	}
}
