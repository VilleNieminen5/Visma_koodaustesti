import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ShiftValidator {
	public void validateShift(String shiftStart, String shiftEnd) {
		
	SimpleDateFormat minuteFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Date startDate = null;
	Date endDate = null;
	Date parsedStart = null;
	Date parsedEnd = null;
	
	try {
		parsedStart = minuteFormat.parse(shiftStart);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		parsedEnd = minuteFormat.parse(shiftEnd);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	long duration  = parsedEnd.getTime() - parsedStart.getTime();
	
	if (duration < 0) {
		System.out.println("Unvalid work shift. Shift's duration can't be negative");
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
	if (startDate != endDate) {
		System.out.println("Invalid work shift. Shift has to start and end during the same day.");
	}
	
	else if (diffHours > 16 || diffHours > 24) {
		System.out.println("Invalid work shift. Shift's duration must be between 0 and 16 hours.");
	}
	
	String hours = "hour";
	String minutes = "minutes";
	if (diffMinutes > 1) {
		minutes = "minutes";
	}
	
	if (diffHours > 1) {
		hours = "hours";
	}
	
	else if (diffHours <= 0) {
		hours = "hours";
		System.out.println("The duration of the shift is "+diffMinutes+" "+minutes);
	}
	
	System.out.println("The duration of the shift is "+diffHours+" "+hours+" and "+diffMinutes+" "+minutes);	
	}
}
