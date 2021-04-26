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
		//�� ���ϱ�

		if (customer_Generation == '1' || customer_Generation == '2') {
			pgType.customerYear = Integer.parseInt("19" + pgType.customerID_Number.substring(0, 2));
		} else if (customer_Generation == '3' || customer_Generation == '4'){
			pgType.customerYear = Integer.parseInt("20" + pgType.customerID_Number.substring(0, 2));
		}

		//��¥
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		pgType.orderDate = sdf.format(calendar.getTime());
		//�ѱ����� ���ϱ�
		pgType.KoreanAge = calendar.get(calendar.YEAR) - pgType.customerYear + 1;

		//������ ���ϱ�
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
			pgType.ageGroupStr = "����";
		} else if (pgType.Age >= ConstValueClass.MIN_TEEN && pgType.Age <= ConstValueClass.MAX_TEEN) {
			pgType.ageGroup = ConstValueClass.TEEN;
			pgType.ageGroupStr = "û�ҳ�";
		} else if (pgType.Age >= ConstValueClass.MIN_CHILD && pgType.Age <= ConstValueClass.MAX_CHILD) {
			pgType.ageGroup = ConstValueClass.CHILD;
			pgType.ageGroupStr = "����";
		} else if (pgType.Age > ConstValueClass.ADULT) {
			pgType.ageGroup = ConstValueClass.OLD;
			pgType.ageGroupStr = "���";
		} else if (pgType.Age < ConstValueClass.MIN_CHILD) {
			pgType.ageGroup = ConstValueClass.BABY;
			pgType.ageGroupStr = "����(����)";
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
		String result = pgType.orderDate + ",";
		result += pgType.ticktTypeStr + ",";
		result += pgType.ageGroupStr + ","; 
		result += pgType.orderCount + ",";
		result += pgType.priceResult + ",";
		result += pgType.discountTypeStr;
		pgType.outputResult.add(result);
		
	}
	
	public static String cutStr(String K37_inputStr, int maxByte) {
		K37_inputStr = K37_inputStr + "                ";  
		byte[] K37_inputByte = K37_inputStr.getBytes(); //String ���ڿ��� getByte�� ���� inputByte��� �迭�� ��´�.
		StringBuffer buf = new StringBuffer(K37_inputStr); //��Ʈ�����۸� ��ü������ ���ְ� ��ǰ�̸��� �޴´�
		int K37_cutByte = 0; //�ƹ���Ʈ�� 0���� �ʱⰪ ����

		/*for�ݺ����� �̿�, ���ڼ��� -1��ŭ �ݺ��Ѵ�. 
		 *�ѱ��ھ� �ɰ��� �ѱ����� �ƴ����� �˻��Ѵ�.
		 */
		for (int K37_i = 0; K37_i < K37_inputStr.length() -1; K37_i++) { 

			//�ѱ��ھ� �ڸ� ���ڰ� �ѱ��̰�
			if (includeKr(K37_inputStr.substring(K37_i, K37_i + 1))) {  

				//cutByte�� +1 �� ���ذ� �ڸ��� ���� maxByte�� ������
				if (K37_cutByte + 1 == maxByte) { 
					buf.insert(K37_i, "  "); //������ ���� �ڿ� ������ �־��ش�
					K37_inputStr = buf.toString(); //������ �־��� Stringbuffer�� �ش� String�� �־��ش�
					K37_inputByte = K37_inputStr.getBytes(); //inputByte�迭�� �ش� String�� getByte�� �ؼ� �־��ش�.
					//cutByte�� 1�� �����ش�. ������ ���ڰ� �ѱ��� ��, �� ������ �ڸ��� ������ �ϳ� �־��ش�.
					K37_cutByte += 1; 
					break; //cutByte�� 1 ���� ���� �ڸ��� ���� ������ �����

					//�ƹ���Ʈ�� �ڸ��� ����Ʈ�� ������
				} else if (K37_cutByte == maxByte) { 
					K37_inputStr = buf.toString(); //�ƹ���Ʈ�� �ڸ��� ����Ʈ�� �� �±⶧���� �״�� �޾ƿ´�
					K37_inputByte = K37_inputStr.getBytes(); //InputStr�� ����Ʈ�� �޾Ƽ� inpuByte�� �ִ´�.
					break; //�����
				}
				K37_cutByte += 2; //�ѱ��� ���ԵǾ� ������ 2����Ʈ �������� �����ش�. �ѱ��� 2����Ʈ�� ����.

				//�ѱ��ھ� �ڸ� ���ڰ� �ѱ��� �ƴϸ� 
			} else { 
				//cutByte�� +1 ���ذ� �ڸ��� ������ ũ��
				if (K37_cutByte + 1 > maxByte) { 
					buf.insert(K37_i, ""); //Stringbuffer �������� �ƹ��͵� �� �ִ´�.
					K37_inputStr = buf.toString(); //inputStr�� ��Ʈ�����۷� ������ �־��ش�.
					K37_inputByte = K37_inputStr.getBytes(); //inputByte�� inputStr�� getByte�Ѱ� �־��ش�.
					break; //�����.
				}
				K37_cutByte += 1; //cutByte�� 1�� �������� �����ش�
			} 

		}
		return new String (K37_inputByte, 0, K37_cutByte); //inputByte�� 0���� cutByte���� �ڸ��� �÷��ش�.
	}

	public static boolean includeKr(String K37_input) { //�ѱ��� ���ԵǾ����� Ȯ���ϴ� �޼ҵ�
		//for �ݺ����� �̿�, �ش� ���ڿ��� ���ڼ���ƴ �ݺ�.
		for (int k = 0; k < K37_input.length(); k++) {
			//������ �� ������ Ÿ���� �ѱ��̸�
			if (Character.getType(K37_input.charAt(k)) == Character.OTHER_LETTER) {
				return true; //true�� ����
			}
		}
		return false; //�ƴϸ� false�� ����
	}

}
