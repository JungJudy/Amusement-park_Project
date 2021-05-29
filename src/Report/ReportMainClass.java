package Report;


import java.io.IOException;
/*
 * 210429
 * @kopo37 (정현정)
 * 매출 분석 프로그램 메인클래스
 */
public class ReportMainClass {
	
	public static void main(String[] args) throws IOException {

		ProcessingClass pc = new ProcessingClass();
		ReportTypeClass rpType = new ReportTypeClass();
		OutputClass output = new OutputClass();
		
		pc.CountDayNightTicket(rpType,output);
		pc.sortDate(rpType);
		pc.dateResult(rpType,output);
		pc.DiscountResult(rpType,output);
	}

}
