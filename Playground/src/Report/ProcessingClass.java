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
			if(field[1].equals(ConstClass.DAY_TICKET)) {
				if (field[2].equals(ConstClass.ADULT)) {
					rpType.dayAdultCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.TEEN)) {
					rpType.dayTeenCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.CHILD)) {
					rpType.dayChildCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.OLD)) {
					rpType.dayOldCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.BABY)) {
					rpType.daybabyCount += Integer.parseInt(field[3]);
				}

				rpType.dayTicketCount += Integer.parseInt(field[3]);;
				rpType.dayTicketTotalPrice += Integer.parseInt(field[4]);

			} else if (field[1].equals(ConstClass.NIGHT_TICKET)) {
				if (field[2].equals(ConstClass.ADULT)) {
					rpType.nightAdultCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.TEEN)) {
					rpType.nightTeenCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.CHILD)) {
					rpType.nightChildCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.OLD)) {
					rpType.nightOldCount += Integer.parseInt(field[3]);
				} else if (field[2].equals(ConstClass.BABY)) {
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
			if (field[5].equals(ConstClass.NOT_DISCOUNT)) {
				rpType.not_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ConstClass.DISABLE_DISCOUNT)) {
				rpType.disable_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ConstClass.NATIONAL_MERIT_DISCOUNT)) {
				rpType.national_merit_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ConstClass.MULTICHILD_DISCOUNT)) {
				rpType.multichild_Discount_Count += Integer.parseInt(field[3]);
			} else if (field[5].equals(ConstClass.PREGNANT_DISCOUNT)) {
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
		rpType.date_al.addAll(rpType.date_hash);
		Collections.sort(rpType.date_al);
		
//		
//		int i = 0;
//		
//		while((readline = reader.readLine()) != null) {
//			String[] field = readline.split(",");
//			
//				if (rpType.date_al.get(i) == field[0]) {
//					rpType.dateTotalPrice[i] += Integer.parseInt(field[4]);
//					System.out.println(rpType.dateTotalPrice[i]);
//				
//			}
//				if (i == rpType.date_al.size()-1) break;
//			i++;
//		}
//		
		
	}

}
