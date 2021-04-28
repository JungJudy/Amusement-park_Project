package Report;

public class OutputClass {

	public void PrintDayNight(ReportTypeClass rpType) {
		System.out.println("=========================권종 별 판매현황=========================");
		System.out.printf("주간권 총 %d매\n",rpType.dayTicketCount);
		System.out.printf("%s %d매, %s %d매, %s %d매, %s %d매, %s %d매\n",ConstClass.BABY,rpType.daybabyCount,ConstClass.CHILD,rpType.dayChildCount,
				ConstClass.TEEN,rpType.dayTeenCount,ConstClass.ADULT,rpType.dayAdultCount,ConstClass.OLD,rpType.dayOldCount);
		System.out.printf("주간권 매출 : %d원\n\n",rpType.dayTicketTotalPrice);
		
		System.out.printf("야간권 총 %d매\n",rpType.nightTicketCount);
		System.out.printf("%s %d매, %s %d매, %s %d매, %s %d매, %s %d매\n",ConstClass.BABY, rpType.nightbabyCount,  ConstClass.CHILD,rpType.nightChildCount,
				ConstClass.TEEN, rpType.nightTeenCount,  ConstClass.ADULT, rpType.nightAdultCount,  ConstClass.OLD, rpType.nightOldCount);
		System.out.printf("야간권 매출 : %d원\n\n",rpType.nightTicketTotalPrice);
		System.out.println("------------------------------------------------------------------\n\n");
	}

	public void PrintDiscount(ReportTypeClass rpType) {
		System.out.println("==============우대권 판매현황==============");
		System.out.printf("총 판매 티켓수 : %d매\n",rpType.dayTicketCount+rpType.nightTicketCount);
		System.out.printf("우대 없음 : %d매\n",rpType.not_Discount_Count);
		System.out.printf("장애인 : %d매\n",rpType.disable_Discount_Count);
		System.out.printf("국가유공자 : %d매\n",rpType.national_merit_Discount_Count);
		System.out.printf("다자녀 : %d매\n",rpType.multichild_Discount_Count);
		System.out.printf("임산부 : %d매\n",rpType.pregnant_Discount_Count);
		System.out.println("-------------------------------------------");
	}

}
