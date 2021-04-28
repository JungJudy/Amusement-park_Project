package Report;


import java.io.IOException;

public class ReportMainClass {

	public static void main(String[] args) throws IOException {

		ProcessingClass pc = new ProcessingClass();
		ReportTypeClass rpType = new ReportTypeClass();
		OutputClass output = new OutputClass();
		
		pc.CountDayNightTicket(rpType,output);
		pc.DiscountResult(rpType,output);
		pc.sortDate(rpType);
		

	}

}
