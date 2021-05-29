package Report;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;


public class ProcessingClass {

	public void CountDayNightTicket(ReportTypeClass rpType, OutputClass output) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("ticketResult.csv"));
		String readline;

		while((readline = reader.readLine()) != null) {
			String[] field = readline.split(",");
			if(field[1].equals(ReportConstClass.DAY_TICKET)) {
				if (field[2].equals(ReportConstClass.ADULT)) {
					rpType.dayAdultCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.TEEN)) {
					rpType.dayTeenCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.CHILD)) {
					rpType.dayChildCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.OLD)) {
					rpType.dayOldCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.BABY)) {
					rpType.daybabyCount += Integer.parseInt(field[3]);
				}

				rpType.dayTicketCount += Integer.parseInt(field[3]);;
				rpType.dayTicketTotalPrice += Integer.parseInt(field[4]);

			} else if (field[1].equals(ReportConstClass.NIGHT_TICKET)) {
				if (field[2].equals(ReportConstClass.ADULT)) {
					rpType.nightAdultCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.TEEN)) {
					rpType.nightTeenCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.CHILD)) {
					rpType.nightChildCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.OLD)) {
					rpType.nightOldCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ReportConstClass.BABY)) {
					rpType.nightbabyCount += Integer.parseInt(field[3]);
				}

				rpType.nightTicketCount += Integer.parseInt(field[3]);
				rpType.nightTicketTotalPrice += Integer.parseInt(field[4]);
			}
		}
		reader.close();
		output.PrintDayNight(rpType);

	}

	public void DiscountResult(ReportTypeClass rpType, OutputClass output) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("ticketResult.csv"));
		String readline;

		while((readline = reader.readLine()) != null) {
			String[] field = readline.split(",");
			if (field[5].equals(ReportConstClass.NOT_DISCOUNT)) {
				rpType.not_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ReportConstClass.DISABLE_DISCOUNT)) {
				rpType.disable_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ReportConstClass.NATIONAL_MERIT_DISCOUNT)) {
				rpType.national_merit_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ReportConstClass.MULTICHILD_DISCOUNT)) {
				rpType.multichild_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ReportConstClass.PREGNANT_DISCOUNT)) {
				rpType.pregnant_Discount_Count += Integer.parseInt(field[3]);
			} 

		}
		reader.close();
		output.PrintDiscount(rpType);

	}

	public void sortDate(ReportTypeClass rpType) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("ticketResult.csv"));
		String readline;

		while((readline = reader.readLine()) != null) {
			String[] field = readline.split(",");
			rpType.date_hash.add(field[0]);

		}
		reader.close();
		rpType.date_al.addAll(rpType.date_hash);
		Collections.sort(rpType.date_al);

	}

	public void dateResult(ReportTypeClass rpType, OutputClass output) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("ticketResult.csv"));
		String readline;
		int[] totalprice = new int[rpType.date_al.size()-1];

		while((readline = reader.readLine()) != null) {
			String[] field = readline.split(",");
			for (int i = 0; i < rpType.date_al.size()-1; i++) {
				if (rpType.date_al.get(i).equals(field[0])) {
					totalprice[i] += Integer.parseInt(field[4]);
				}
			}
		}
		
		reader.close();
		
		for (int i = 0; i < rpType.date_al.size()-1; i++) {
			rpType.dateTotalPrice_al.add(totalprice[i]);
		}
		
		output.dateResult(rpType);
	}

}
