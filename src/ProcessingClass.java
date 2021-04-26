package Playground;

import java.util.Calendar;

public class ProcessingClass {
	Calendar calendar;
	ProcessingClass() {
		calendar = Calendar.getInstance();
	}
	public void calAge(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		String customer_Generation = pgType.customerID_Number.substring(7, 8);
		//년 구하기

		if (customer_Generation.equals("1") || customer_Generation.equals("2")) {
			pgType.customerYear = Integer.parseInt("19" + pgType.customerID_Number.substring(0, 2));
		} else {
			pgType.customerYear = Integer.parseInt("20" + pgType.customerID_Number.substring(0, 2));
		}
		//한국나이 구하기
		pgType.KoreanAge = calendar.YEAR - pgType.customerYear + 1;

		//만나이 구하기
		pgType.customerMonth = Integer.parseInt(pgType.customerID_Number.substring(2, 4));
		pgType.customerDay = Integer.parseInt(pgType.customerID_Number.substring(4, 6));
		if (pgType.customerMonth <= calendar.MONTH && pgType.customerDay <= calendar.DATE) {
			pgType.Age = pgType.KoreanAge - 1;
		} else {
			pgType.Age = pgType.KoreanAge - 2;
		}

	}
	public void calAgeGroup(PlaygroundTypeClass pgType) {
		if (pgType.Age >= ConstValueClass.MIN_ADULT && pgType.Age <= ConstValueClass.MAX_ADULT) {
			pgType.ageGroup = ConstValueClass.ADULT;
		} else if (pgType.Age >= ConstValueClass.MIN_TEEN && pgType.Age <= ConstValueClass.MAX_TEEN) {
			pgType.ageGroup = ConstValueClass.TEEN;
		} else if (pgType.Age >= ConstValueClass.MIN_CHILD && pgType.Age <= ConstValueClass.MAX_CHILD) {
			pgType.ageGroup = ConstValueClass.CHILD;
		} else if (pgType.Age > ConstValueClass.ADULT) {
			pgType.ageGroup = ConstValueClass.OLD;
		} else if (pgType.Age < ConstValueClass.MIN_CHILD) {
			pgType.ageGroup = ConstValueClass.BABY;
		}

	}
	public void calPrice(PlaygroundTypeClass pgType) {
		if (pgType.ageGroup == ConstValueClass.ADULT) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.amount[0] += 1;
			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.amount[1] += 1;
			}

		} else if (pgType.ageGroup == ConstValueClass.TEEN) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.amount[2] += 1;
			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.amount[3] += 1;
			}
		} else if (pgType.ageGroup == ConstValueClass.CHILD) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.amount[4] += 1;
			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.amount[5] += 1;
			}
		} else if (pgType.ageGroup == ConstValueClass.OLD) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.amount[6] += 1;
			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.amount[7] += 1;
			}
		} else if (pgType.ageGroup == ConstValueClass.BABY) {
			pgType.amount[8] += 1;
		} 

	}
	public void calDiscount(PlaygroundTypeClass pgType) {
		
		
	}


}
