package Report;

import java.io.File;

public class ConstClass {
	final static File file = new File("ticketResult.csv");
	
	//권종별
	final static String DAY_TICKET = "주간권", NIGHT_TICKET = "야간권";
	//연령그룹별
	final static String ADULT = "대인", TEEN = "청소년", CHILD = "소인", OLD = "경로", BABY = "유아";
	
	
	
	//우대권별
	final static String NOT_DISCOUNT = "없음", DISABLE_DISCOUNT = "장애인", NATIONAL_MERIT_DISCOUNT = "국가유공자", MULTICHILD_DISCOUNT = "다자녀", PREGNANT_DISCOUNT = "임산부";
	

}
