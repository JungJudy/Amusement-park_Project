package Report;

import java.io.BufferedReader;
import java.io.IOException;

public class DayNightClass {

	public void CountDayNightTicket(BufferedReader reader, ReportTypeClass rpType) throws IOException {
	
		String line;
		
		while((line = reader.readLine()) != null) {
			if (line.contains("주간권") == true) {
				rpType.dayTicketCount++;
			} else if (line.contains("야간권") == true) {
				rpType.nightTicketCount++;
			}
		}
		
	}

}
