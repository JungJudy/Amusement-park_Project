package Report;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	public void dateResult(ReportTypeClass rpType) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");

		System.out.println("============일자별 매출 현황============");

		for (int i = 0; i < rpType.dateTotalPrice_al.size(); i++) {
			if (Integer.parseInt(rpType.date_al.get(i).substring(2, 4)) >= 0 && Integer.parseInt(rpType.date_al.get(i).substring(2, 4)) <= Integer.parseInt(sdf.format(calendar.getTime()))) {
				System.out.printf("%s년 %s월 %s일: 총 매출 %10s\n","20" + rpType.date_al.get(i).substring(2, 4), rpType.date_al.get(i).substring(4, 6),rpType.date_al.get(i).substring(6, 8),rpType.dateTotalPrice_al.get(i)+"원");
			} else {
				System.out.printf("%s년 %s월 %s일: 총 매출 %10s\n","19" + rpType.date_al.get(i).substring(2, 4), rpType.date_al.get(i).substring(4, 6),rpType.date_al.get(i).substring(6, 8),rpType.dateTotalPrice_al.get(i)+"원");
			}
		}
		System.out.println("----------------------------------------\n\n");

	}

	public void PrintDiscount(ReportTypeClass rpType) {
		System.out.println("============우대권 판매현황============");
		System.out.printf("%s%12d매\n",cutStr("총 판매 티켓수 : ",20),rpType.dayTicketCount+rpType.nightTicketCount);
		System.out.printf("%s%12d매\n",cutStr("우대 없음 : ",20),rpType.not_Discount_Count);
		System.out.printf("%s%12d매\n",cutStr("장애인 : ",20),rpType.disable_Discount_Count);
		System.out.printf("%s%12d매\n",cutStr("국가유공자 : ",20),rpType.national_merit_Discount_Count);
		System.out.printf("%s%12d매\n",cutStr("다자녀 : ",20),rpType.multichild_Discount_Count);
		System.out.printf("%s%12d매\n",cutStr("임산부 : ",20),rpType.pregnant_Discount_Count);
		System.out.println("---------------------------------------");
	}



	//한글 자르는 메소드
	public static String cutStr(String K37_inputStr, int maxByte) {
		K37_inputStr = K37_inputStr + "                                      ";  
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
					buf.insert(K37_i, "         "); //마지막 글자 뒤에 공백을 넣어준다
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

