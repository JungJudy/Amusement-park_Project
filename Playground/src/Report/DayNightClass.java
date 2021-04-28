package Report;

import java.io.BufferedReader;
import java.io.IOException;

public class DayNightClass {

	public void CountDayNightTicket(BufferedReader reader, ReportTypeClass rpType) throws IOException {
	
		String line;
		
		while((line = reader.readLine()) != null) {
			if (line.contains("�ְ���") == true) {
				rpType.dayTicketCount++;
			} else if (line.contains("�߰���") == true) {
				rpType.nightTicketCount++;
			}
		}
		
	}

}
