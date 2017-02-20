import java.util.ArrayList;
import java.util.Scanner;

public class FacilityUse {
	private ArrayList<inspectionLog> inspectionLogs = new ArrayList<inspectionLog>();

	public Scanner scanner = new Scanner(System.in);
	
	public void scheduleInspection(){  //Schedules inspections into the facility system
		int month, day;
		System.out.println("Please select the MONTH, in number format (01 - 12), you wish to schedule this: ");
		month = scanner.nextInt();
		while (month <= 00 || month >= 13) {  // Checks to see if entered month exists
			System.out.println("Month does not exist. Please try again: ");
			month = scanner.nextInt();
		}
		System.out.println("Please select the DAY, in number format (01 - 31), you wish to schedule this: ");
		day = scanner.nextInt();
		while(day <= 00 || day >= 32){
			System.out.println("Said day date does not exist. Please try again: ");
			day = scanner.nextInt();
		}
		inspectionLog temp = new inspectionLog(month,day);
		inspectionLogs.add(temp);
	}

	public void listInspections() {  // List off all inspections in the system
		System.out.println("Current Scheduled Inspections: ");
		for (int i = 0; i < inspectionLogs.size(); i++ ){
			System.out.println((i+1) + ": " + inspectionLogs.get(i).getMonth() + "/"
					+ inspectionLogs.get(i).getDay());
		}
	}

}
