package Report;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReportMainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("ticketResult.csv"));

		DayNightClass daynight = new DayNightClass();
		ReportTypeClass rpType = new ReportTypeClass();
		daynight.CountDayNightTicket(reader,rpType);
		

		//		String line;
		//		
		//		while((line = reader.readLine()) != null) {
		//			System.out.println(line);
		//		}

	}

}
