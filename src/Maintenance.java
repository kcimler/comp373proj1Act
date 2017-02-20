import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kciml on 2/19/2017.
 */
public class Maintenance {

    public ArrayList <unresolvedLog> unresolvedMaintRequests = new ArrayList<unresolvedLog>();
    public ArrayList <resolvedLog> resolvedMaintRequests = new ArrayList<resolvedLog>();
    public Scanner scanner = new Scanner(System.in);

    public void makeFacilityMaintRequest(){  // Logs a new outgoing maintenance request //
        String title, description;
        System.out.println("Please enter the title for the request: ");
        title = scanner.nextLine();
        System.out.println("Please enter the description for the request: ");
        description = scanner.nextLine();
        unresolvedLog temp = new unresolvedLog(title, description);
        unresolvedMaintRequests.add(temp);
    }

    public void scheduleMaintenance() {  // Switches an outgoing maintenance request to a resolved request with a set maintenance date //
        int month, day, index;
        double cost;
        listMaintRequests();
        System.out.println("Please type in the number of the maintenance request you would like to schedule: ");
        index = scanner.nextInt() - 1;
        while (index <= -1 || index >= unresolvedMaintRequests.size()){
            System.out.println("Maintenance request does not exist. Please try again: ");
            index = scanner.nextInt();
        }
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
        System.out.println("Please enter the estimated cost to complete said maintenance: ");
        cost = scanner.nextDouble();
        resolvedLog temp = new resolvedLog(unresolvedMaintRequests.get(index).getTitle(),
                unresolvedMaintRequests.get(index).getTitle(),
                month, day, cost); //Enters all gathered information into a new resolved Log entry.

        resolvedMaintRequests.add(temp);  // Adds the new resolved log into the system
        unresolvedMaintRequests.remove(index);  // Removes the old log from the system
    }

    public void calcMaintenanceCostForFacility(){
        double overall = 0;
        for (int i = 0; i < resolvedMaintRequests.size(); i++){
            overall = overall + resolvedMaintRequests.get(i).getCost();
            System.out.println(resolvedMaintRequests.get(i).getTitle() + ": $" + (String.format("%.2f",resolvedMaintRequests.get(i).getCost())));
        }
        System.out.println("Total Maintenance Cost: $" + (String.format("%.2f",overall)));
    }

    public void calcProblemRateForFacility(){

    }

    public void calcDownTimeForFacility(){

    }

    public void listMaintRequests(){  // Logs all of the titles of the current outgoing maintenance requests
        for (int i = 0; i < unresolvedMaintRequests.size(); i++){
            System.out.println((i+1) + ": " + unresolvedMaintRequests.get(i).getTitle());
        }
    }
    public void listMaintenance(){  // Logs all of the title of the resolved maintenance requests
        for (int i = 0; i < resolvedMaintRequests.size(); i++){
            System.out.println((i+1) + ": " + resolvedMaintRequests.get(i).getTitle() +
                    " (Completed on " + resolvedMaintRequests.get(i).getMonth() + "/" +
                    resolvedMaintRequests.get(i).getDay() + ")" );
        }
    }
    public void listFacilityProblems(){

    }
}
