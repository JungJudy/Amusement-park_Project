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
				} break;
			} else {
				System.out.println("�ֹε�Ϲ�ȣ�� Ȯ���ϰ� �ٽ� �Է����ּ���.");
			}

		}
	}
	public void inputOrderCount(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.orderCount = scanner.nextInt();
			if (pgType.orderCount >= ConstValueClass.MIN_COUNT && pgType.orderCount <= ConstValueClass.MAX_COUNT) {
				break;
			} else if (pgType.orderCount < ConstValueClass.MIN_COUNT) {
				System.out.println("�ּ� ���� ������ 1���Դϴ�. �ٽ� �Է����ּ���");
			} else if (pgType.orderCount > ConstValueClass.MAX_COUNT) {
				System.out.println("�ִ� ���� ������ 10���Դϴ�. �ٽ� �Է����ּ���.");
			}
		} 
		
	}
	public void inputDiscountType(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.discountType	= scanner.nextInt();
			if (pgType.discountType == ConstValueClass.NOT_DISCOUNT) {
				pgType.discountRate = ConstValueClass.NOT_DISCOUNT_RATE;
				pgType.discountTypeStr = "*������� ����";
				break;
			} else if (pgType.discountType == ConstValueClass.DISABLE_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.DISABLE_DISCOUNT_RATE;
				pgType.discountTypeStr = "*����� �������";
				break;
			} else if (pgType.discountType == ConstValueClass.NATIONAL_MERIT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.NATIONAL_MERIT_DISCOUNT_RATE;
				pgType.discountTypeStr = "*���������� �������";
				break;
			} else if (pgType.discountType == ConstValueClass.MULTICHILD_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.MULTICHILD_DISCOUNT_RATE;
				pgType.discountTypeStr = "*�ӻ�� �������";
				break;
			} else {
				System.out.println("�������� Ȯ���ϰ� �ٽ� �������ֽñ� �ٶ��ϴ�.");
			}
		}
		
	}
	public void orderContinue(PlaygroundTypeClass pgType) {
		
		
	}
}
