package Playground;

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
	public void TotalResult(PlaygroundTypeClass pgType) {
		String result = cutStr(pgType.ticktTypeStr + "," ,12) + cutStr(pgType.ageGroupStr + ",", 14) + cutStr((pgType.orderCount + ","),10) + cutStr(pgType.discountTypeStr + ",",30);
		pgType.outputResult.add(result);

	}
	
	public static String cutStr(String K37_inputStr, int maxByte) {
		K37_inputStr = K37_inputStr + "                ";  
		byte[] K37_inputByte = K37_inputStr.getBytes(); //String 문자열을 getByte를 통해 inputByte라는 배열에 담는다.
		StringBuffer buf = new StringBuffer(K37_inputStr); //스트링버퍼를 객체선언을 해주고 상품이름을 받는다
		int K37_cutByte = 0; //컷바이트를 0으로 초기값 설정

		/*for반복문을 이용, 글자수의 -1만큼 반복한다. 
		 *한글자씩 쪼개서 한글인지 아닌지를 검사한다.
		 */
		for (int K37_i = 0; K37_i < K37_inputStr.length() -1; K37_i++) { 

			//한글자씩 자른 글자가 한글이고
			if (includeKr(K37_inputStr.substring(K37_i, K37_i + 1))) {  

				//cutByte에 +1 을 해준게 자르는 수인 maxByte와 같으면
				if (K37_cutByte + 1 == maxByte) { 
					buf.insert(K37_i, "  "); //마지막 글자 뒤에 공백을 넣어준다
					K37_inputStr = buf.toString(); //공백을 넣어준 Stringbuffer를 해당 String에 넣어준다
					K37_inputByte = K37_inputStr.getBytes(); //inputByte배열에 해당 String을 getByte를 해서 넣어준다.
					//cutByte에 1을 더해준다. 마지막 글자가 한글일 때, 그 전에서 자르고 공백을 하나 넣어준다.
					K37_cutByte += 1; 
					break; //cutByte에 1 더한 수가 자르는 수와 같으면 멈춘다

					//컷바이트와 자르는 바이트와 같으면
				} else if (K37_cutByte == maxByte) { 
					K37_inputStr = buf.toString(); //컷바이트와 자르는 바이트가 딱 맞기때문에 그대로 받아온다
					K37_inputByte = K37_inputStr.getBytes(); //InputStr을 바이트로 받아서 inpuByte에 넣는다.
					break; //멈춘다
				}
				K37_cutByte += 2; //한글이 포함되어 있으면 2바이트 누적으로 더해준다. 한글은 2바이트기 때문.

				//한글자씩 자른 글자가 한글이 아니면 
			} else { 
				//cutByte에 +1 해준게 자르는 수보다 크면
				if (K37_cutByte + 1 > maxByte) { 
					buf.insert(K37_i, ""); //Stringbuffer 마지막에 아무것도 안 넣는다.
					K37_inputStr = buf.toString(); //inputStr에 스트링버퍼로 받은걸 넣어준다.
					K37_inputByte = K37_inputStr.getBytes(); //inputByte에 inputStr을 getByte한걸 넣어준다.
					break; //멈춘다.
				}
				K37_cutByte += 1; //cutByte에 1씩 누적으로 더해준다
			} 

		}
		return new String (K37_inputByte, 0, K37_cutByte); //inputByte를 0에서 cutByte까지 자른걸 올려준다.
	}

	public static boolean includeKr(String K37_input) { //한글이 포함되었는지 확인하는 메소드
		//for 반복문을 이용, 해당 문자열의 글자수만틈 반복.
		for (int k = 0; k < K37_input.length(); k++) {
			//문자의 각 글자의 타입이 한글이면
			if (Character.getType(K37_input.charAt(k)) == Character.OTHER_LETTER) {
				return true; //true를 리턴
			}
		}
		return false; //아니면 false를 리턴
	}

}
