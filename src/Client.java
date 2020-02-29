import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {
	
	private String shiftStart = "";
	private String shiftEnd = "";
	ShiftValidator shiftValidator = new ShiftValidator();
	
	
	public void getStartandEnd() {
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
	
	shiftValidator.validateShift(shiftStart, shiftEnd);	
	}
}
	