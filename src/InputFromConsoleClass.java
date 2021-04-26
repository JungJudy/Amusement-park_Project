package Playground;

import java.util.Scanner;

public class InputFromConsoleClass {
	Scanner scanner;
	OutputClass output;

	InputFromConsoleClass() {
		scanner = new Scanner(System.in);
		output = new OutputClass();
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
		while(true) {
			pgType.customerID_Number = scanner.next();
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
	public void inputOrderCount(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.count = scanner.nextInt();
			if (pgType.count >= ConstValueClass.MIN_COUNT && pgType.count <= ConstValueClass.MAX_COUNT) {
				break;
			} else if (pgType.count < ConstValueClass.MIN_COUNT) {
				System.out.println("�ּ� ���� ������ 1���Դϴ�. �ٽ� �Է����ּ���");
			} else if (pgType.count < ConstValueClass.MAX_COUNT) {
				System.out.println("�ִ� ���� ������ 10���Դϴ�. �ٽ� �Է����ּ���.");
			}
		} 
		
	}
}
