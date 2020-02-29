import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Client class that uses that sets the inputs and uses the shift validating class*/
public class Client {
	
	private String shiftStart = "";
	private String shiftEnd = "";
	ShiftValidator shiftValidator = new ShiftValidator();
	
	/*Method for setting the beginning and ending of the work shift.*/
	public void getStartAndEnd() {
		System.out.print("Give starting time of the shift in a dd.MM.yyyy HH:mm format: ");
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		try {
			shiftStart = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.print("Give ending time of the shift in a dd.MM.yyyy HH:mm format: ");
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			shiftEnd = br2.readLine();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		/*shiftvalidator returns String that includes the information about validity of the shift.*/
		String returnString = shiftValidator.validateShift(shiftStart, shiftEnd);
		System.out.println(returnString);
				
	}
}
	