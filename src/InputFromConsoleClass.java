package Playground;

import java.util.Scanner;

public class InputFromConsoleClass {
	Scanner scanner;
	
	InputFromConsoleClass() {
		scanner = new Scanner(System.in);
	}
	public void selectTicekType(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.ticketType = scanner.nextInt();
			if (pgType.ticketType >= ConstValueClass.DAY_PRICE_TYPE && pgType.ticketType <= ConstValueClass.NIGHT_PRICE_TYPE) {
				break;
			} else {
				System.out.println("�ְ��ǰ� �߰��Ǹ� ���� �� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
		if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
			pgType.ticktTypeStr = "�ְ���";
		} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
			pgType.ticktTypeStr = "�߰���";
		}
	}
	
	public void inputID_Number(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		while(true) {
			pgType.customerID_Number = scanner.nextLine();
			if (pgType.customerID_Number.length() == 14 && pgType.customerID_Number.contains("-")) {
				if (pgType.customerID_Number.charAt(8) == 1 || pgType.customerID_Number.charAt(8) == 2 || 
						pgType.customerID_Number.charAt(8) == 3 || pgType.customerID_Number.charAt(8) == 4) {
					break;
				}
			} else {
				System.out.println("�ֹε�Ϲ�ȣ�� Ȯ���ϰ� �ٽ� �Է����ּ���.");
			}
			
		}
	}
}
