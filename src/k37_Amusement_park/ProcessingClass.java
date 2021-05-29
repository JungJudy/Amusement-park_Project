package k37_Amusement_park;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	Calendar calendar;

	ProcessingClass() {
		calendar = Calendar.getInstance();
	}
	public void calAge(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		char customer_Generation = pgType.customerID_Number.charAt(7);
		//년 구하기

		if (customer_Generation == '1' || customer_Generation == '2') {
			pgType.customerYear = Integer.parseInt("19" + pgType.customerID_Number.substring(0, 2));
		} else if (customer_Generation == '3' || customer_Generation == '4'){
			pgType.customerYear = Integer.parseInt("20" + pgType.customerID_Number.substring(0, 2));
		}

		//날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		pgType.orderDate = sdf.format(calendar.getTime());
		//한국나이 구하기
		pgType.KoreanAge = calendar.get(calendar.YEAR) - pgType.customerYear + 1;

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
			pgType.ageGroupStr = "대인";
		} else if (pgType.Age >= ConstValueClass.MIN_TEEN && pgType.Age <= ConstValueClass.MAX_TEEN) {
			pgType.ageGroup = ConstValueClass.TEEN;
			pgType.ageGroupStr = "청소년";
		} else if (pgType.Age >= ConstValueClass.MIN_CHILD && pgType.Age <= ConstValueClass.MAX_CHILD) {
			pgType.ageGroup = ConstValueClass.CHILD;
			pgType.ageGroupStr = "소인";
		} else if (pgType.Age > ConstValueClass.ADULT) {
			pgType.ageGroup = ConstValueClass.OLD;
			pgType.ageGroupStr = "경로";
		} else if (pgType.Age < ConstValueClass.MIN_CHILD) {
			pgType.ageGroup = ConstValueClass.BABY;
			pgType.ageGroupStr = "유아(무료)";
		}

	}
	public void calPrice(PlaygroundTypeClass pgType) {
		if (pgType.ageGroup == ConstValueClass.ADULT) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[0];

			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[1];

			}

		} else if (pgType.ageGroup == ConstValueClass.TEEN) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[2];

			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[3];

			}
		} else if (pgType.ageGroup == ConstValueClass.CHILD) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[4];

			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[5];

			}
		} else if (pgType.ageGroup == ConstValueClass.OLD) {

			if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[6];

			} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
				pgType.ticketPrice = ConstValueClass.price[7];

			}
		} else if (pgType.ageGroup == ConstValueClass.BABY) {
			pgType.ticketPrice = ConstValueClass.price[8];

		} 

	}
	public void calDiscount(PlaygroundTypeClass pgType) {
		pgType.ticketPrice = (int) (pgType.ticketPrice * (1 - pgType.discountRate));

	}

	public void calPriceResult(PlaygroundTypeClass pgType, OutputClass output) {
		pgType.priceResult = pgType.ticketPrice * pgType.orderCount;
		output.printPriceResult(pgType);

	}
	public void TotalResult(PlaygroundTypeClass pgType, OutputClass output) {
		pgType.outputResult.add(pgType.orderDate);
		pgType.outputResult.add(pgType.ticktTypeStr);
		pgType.outputResult.add(pgType.ageGroupStr);
		pgType.outputResult.add(String.valueOf(pgType.orderCount));
		pgType.outputResult.add(String.valueOf(pgType.priceResult));
		pgType.outputResult.add(pgType.discountTypeStr);
		
	}
	
	
	public void finalTotalPriceResult(PlaygroundTypeClass pgType) {
		pgType.finalTotalPriceResult += pgType.priceResult;
		
	}

}
