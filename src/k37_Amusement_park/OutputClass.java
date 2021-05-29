package k37_Amusement_park;


public class OutputClass {

	public void printTicketType() {
		System.out.println("������ �������ּ���");
		System.out.println("1.�ְ���\n2.�߰���");
	}

	public void printIDNumber() {
		// TODO Auto-generated method stub
		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ��� (ex.210426-1234567)");
	}

	public void printOrderCount() {
		// TODO Auto-generated method stub
		System.out.println("������ �����Ͻðڽ��ϱ�? (�ִ� 10��)");
	}

	public void printDiscount() {
		// TODO Auto-generated method stub
		System.out.println("�������� �������ּ���");
		System.out.println("1.���� (���� ���� �ڵ�ó��)");
		System.out.println("2.�����");
		System.out.println("3.����������");
		System.out.println("4.���ڳ�");
		System.out.println("5.�ӻ��");
	}

	public void printPriceResult(TypeClass pgType) {
		// TODO Auto-generated method stub
		System.out.printf("������ %d �� �Դϴ�.\n�����մϴ�.\n\n", pgType.priceResult);
	}

	public void printOrderContinue() {
		// TODO Auto-generated method stub
		System.out.println("��� �߱��Ͻðڽ��ϱ�?");
		System.out.println("1.Ƽ�� �߱�");
		System.out.println("2.����");
	}

	public void printProgramContinue() {
		System.out.printf("��� ����(1: ���ο� �ֹ�, 2:���α׷� ����) : ");

	}

	public void printTotalResult(TypeClass pgType) {
		// TODO Auto-generated method stub
		String discountstr = "";
		System.out.println("===============================��������=================================");
		for (int i = 0; i < pgType.outputResult.size()/6; i++) {
			
			if(pgType.outputResult.get((i*6)+5).equals("����")) {
				discountstr = "*������� " + pgType.outputResult.get((i*6)+5);
			} else {
				discountstr = "*" + pgType.outputResult.get((i*6)+5) + " �������";
			}
			System.out.printf("%s%sX   %s %s %s\n",cutStr(pgType.outputResult.get((i*6)+1),10),cutStr(pgType.outputResult.get((i*6)+2),10),
					cutStr(pgType.outputResult.get((i*6)+3),6),cutStr(pgType.outputResult.get((i*6)+4)+"��",20),cutStr(discountstr,30));
		}
		System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�\n",pgType.finalTotalPriceResult);
		System.out.println("========================================================================");
	}
	
	
	
	//�ѱ� �ڸ��� �޼ҵ�
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
