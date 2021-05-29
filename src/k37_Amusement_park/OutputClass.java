package k37_Amusement_park;


public class OutputClass {

	public void printTicketType() {
		System.out.println("권종을 선택해주세요");
		System.out.println("1.주간권\n2.야간권");
	}

	public void printIDNumber() {
		// TODO Auto-generated method stub
		System.out.println("주민등록번호를 입력해주세요 (ex.210426-1234567)");
	}

	public void printOrderCount() {
		// TODO Auto-generated method stub
		System.out.println("몇장을 구매하시겠습니까? (최대 10장)");
	}

	public void printDiscount() {
		// TODO Auto-generated method stub
		System.out.println("우대사항을 선택해주세요");
		System.out.println("1.없음 (나이 우대는 자동처리)");
		System.out.println("2.장애인");
		System.out.println("3.국가유공자");
		System.out.println("4.다자녀");
		System.out.println("5.임산부");
	}

	public void printPriceResult(TypeClass pgType) {
		// TODO Auto-generated method stub
		System.out.printf("가격은 %d 원 입니다.\n감사합니다.\n\n", pgType.priceResult);
	}

	public void printOrderContinue() {
		// TODO Auto-generated method stub
		System.out.println("계속 발권하시겠습니까?");
		System.out.println("1.티켓 발권");
		System.out.println("2.종료");
	}

	public void printProgramContinue() {
		System.out.printf("계속 진행(1: 새로운 주문, 2:프로그램 종료) : ");

	}

	public void printTotalResult(TypeClass pgType) {
		// TODO Auto-generated method stub
		String discountstr = "";
		System.out.println("===============================에버랜드=================================");
		for (int i = 0; i < pgType.outputResult.size()/6; i++) {
			
			if(pgType.outputResult.get((i*6)+5).equals("없음")) {
				discountstr = "*우대적용 " + pgType.outputResult.get((i*6)+5);
			} else {
				discountstr = "*" + pgType.outputResult.get((i*6)+5) + " 우대적용";
			}
			System.out.printf("%s%sX   %s %s %s\n",cutStr(pgType.outputResult.get((i*6)+1),10),cutStr(pgType.outputResult.get((i*6)+2),10),
					cutStr(pgType.outputResult.get((i*6)+3),6),cutStr(pgType.outputResult.get((i*6)+4)+"원",20),cutStr(discountstr,30));
		}
		System.out.printf("\n입장료 총액은 %d원 입니다\n",pgType.finalTotalPriceResult);
		System.out.println("========================================================================");
	}
	
	
	
	//한글 자르는 메소드
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
