import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ShiftValidator {
	public String validateShift(String shiftStart, String shiftEnd) {
		/*Parsing formats for day accuracy and minute accuracy*/
		SimpleDateFormat minuteFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date startDate = null;
		Date endDate = null;
		Date parsedStart = null;
		Date parsedEnd = null;
		
		/*First method pases the inputs to minute format for calculating \
		 and day format for comparing dates*/
		try {
			parsedStart = minuteFormat.parse(shiftStart);
			parsedEnd = minuteFormat.parse(shiftEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
/*Calculating the duration of the work shift with parsed moments of time*/
		long duration  = parsedEnd.getTime() - parsedStart.getTime();
		
		if (duration < 0) {
			String returnString = "Unvalid work shift. Shift's beginning has to be before its ending.";
			return returnString;
		}
		
		long diffDays = TimeUnit.MILLISECONDS.toDays(duration);
		long diffHours = TimeUnit.MILLISECONDS.toHours(duration)-(diffDays*24);
		long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(duration)-(diffHours*60);
	
		try {
			startDate = dateFormat.parse(shiftStart);
			endDate = dateFormat.parse(shiftEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (startDate.compareTo(endDate) != 0) {
			String returnString = "Invalid work shift. Shift has to start and end during the same day.";
			return returnString;
		}
		
		if (diffHours > 16 || diffDays > 0 ) {
			String returnString = "Invalid work shift. Shift's duration must be between 0 and 16 hours.";
			return returnString;
		}
		
		/* Formatting the string according the amount of minute(s) or hour(s)*/
		String hours = "hour";
		String minutes = "minutes";
		if (diffMinutes > 1) {
			minutes = "minutes";
		}
		
		
		if (diffHours > 1 || diffHours == 0) {
			hours = "hours";
		}
		
		String returnString = "The shift is valid and the duration of the shift is "+diffHours+" "+hours+" and "+diffMinutes+" "+minutes+".";
		return returnString;

		}
	}
