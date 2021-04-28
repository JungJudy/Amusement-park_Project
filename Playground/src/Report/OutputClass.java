package Report;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	public void dateResult(ReportTypeClass rpType) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");

		System.out.println("============���ں� ���� ��Ȳ============");

		for (int i = 0; i < rpType.dateTotalPrice_al.size(); i++) {
			if (Integer.parseInt(rpType.date_al.get(i).substring(2, 4)) >= 0 && Integer.parseInt(rpType.date_al.get(i).substring(2, 4)) <= Integer.parseInt(sdf.format(calendar.getTime()))) {
				System.out.printf("%s�� %s�� %s��: �� ���� %10s\n","20" + rpType.date_al.get(i).substring(2, 4), rpType.date_al.get(i).substring(4, 6),rpType.date_al.get(i).substring(6, 8),rpType.dateTotalPrice_al.get(i)+"��");
			} else {
				System.out.printf("%s�� %s�� %s��: �� ���� %10s\n","19" + rpType.date_al.get(i).substring(2, 4), rpType.date_al.get(i).substring(4, 6),rpType.date_al.get(i).substring(6, 8),rpType.dateTotalPrice_al.get(i)+"��");
			}
		}
		System.out.println("----------------------------------------\n\n");

	}

	public void PrintDiscount(ReportTypeClass rpType) {
		System.out.println("============���� �Ǹ���Ȳ============");
		System.out.printf("%s%12d��\n",cutStr("�� �Ǹ� Ƽ�ϼ� : ",20),rpType.dayTicketCount+rpType.nightTicketCount);
		System.out.printf("%s%12d��\n",cutStr("��� ���� : ",20),rpType.not_Discount_Count);
		System.out.printf("%s%12d��\n",cutStr("����� : ",20),rpType.disable_Discount_Count);
		System.out.printf("%s%12d��\n",cutStr("���������� : ",20),rpType.national_merit_Discount_Count);
		System.out.printf("%s%12d��\n",cutStr("���ڳ� : ",20),rpType.multichild_Discount_Count);
		System.out.printf("%s%12d��\n",cutStr("�ӻ�� : ",20),rpType.pregnant_Discount_Count);
		System.out.println("---------------------------------------");
	}



	//�ѱ� �ڸ��� �޼ҵ�
	public static String cutStr(String K37_inputStr, int maxByte) {
		K37_inputStr = K37_inputStr + "                                      ";  
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
					buf.insert(K37_i, "         "); //������ ���� �ڿ� ������ �־��ش�
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

