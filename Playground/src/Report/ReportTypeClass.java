package Report;

import java.util.ArrayList;
import java.util.HashSet;

public class ReportTypeClass {
	
	//주간권 야간권 티켓 갯수
	int dayTicketCount, nightTicketCount;
	//주간권에서 나이그룹별 티켓 갯수
	int dayAdultCount, dayTeenCount, dayChildCount, dayOldCount, daybabyCount;
	int nightAdultCount, nightTeenCount, nightChildCount, nightOldCount, nightbabyCount;
	int dayTicketTotalPrice, nightTicketTotalPrice;
	
	HashSet<String> date_hash = new HashSet<>();
	ArrayList<String> date_al = new ArrayList<String>();
	int[] dateTotalPrice;
	int not_Discount_Count, disable_Discount_Count, national_merit_Discount_Count, multichild_Discount_Count, pregnant_Discount_Count;
}
