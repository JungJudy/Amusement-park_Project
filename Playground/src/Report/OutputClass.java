package Report;

public class OutputClass {

	public void PrintDayNight(ReportTypeClass rpType) {
		System.out.println("=========================���� �� �Ǹ���Ȳ=========================");
		System.out.printf("�ְ��� �� %d��\n",rpType.dayTicketCount);
		System.out.printf("%s %d��, %s %d��, %s %d��, %s %d��, %s %d��\n",ConstClass.BABY,rpType.daybabyCount,ConstClass.CHILD,rpType.dayChildCount,
				ConstClass.TEEN,rpType.dayTeenCount,ConstClass.ADULT,rpType.dayAdultCount,ConstClass.OLD,rpType.dayOldCount);
		System.out.printf("�ְ��� ���� : %d��\n\n",rpType.dayTicketTotalPrice);
		
		System.out.printf("�߰��� �� %d��\n",rpType.nightTicketCount);
		System.out.printf("%s %d��, %s %d��, %s %d��, %s %d��, %s %d��\n",ConstClass.BABY, rpType.nightbabyCount,  ConstClass.CHILD,rpType.nightChildCount,
				ConstClass.TEEN, rpType.nightTeenCount,  ConstClass.ADULT, rpType.nightAdultCount,  ConstClass.OLD, rpType.nightOldCount);
		System.out.printf("�߰��� ���� : %d��\n\n",rpType.nightTicketTotalPrice);
		System.out.println("------------------------------------------------------------------\n\n");
	}

	public void PrintDiscount(ReportTypeClass rpType) {
		System.out.println("==============���� �Ǹ���Ȳ==============");
		System.out.printf("�� �Ǹ� Ƽ�ϼ� : %d��\n",rpType.dayTicketCount+rpType.nightTicketCount);
		System.out.printf("��� ���� : %d��\n",rpType.not_Discount_Count);
		System.out.printf("����� : %d��\n",rpType.disable_Discount_Count);
		System.out.printf("���������� : %d��\n",rpType.national_merit_Discount_Count);
		System.out.printf("���ڳ� : %d��\n",rpType.multichild_Discount_Count);
		System.out.printf("�ӻ�� : %d��\n",rpType.pregnant_Discount_Count);
		System.out.println("-------------------------------------------");
	}

}
