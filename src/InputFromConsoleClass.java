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
				System.out.println("주간권과 야간권만 선택 할 수 있습니다. 다시 입력해주세요.");
			}
		}

		if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
			pgType.ticktTypeStr = "주간권";
		} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
			pgType.ticktTypeStr = "야간권";
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
				System.out.println("주민등록번호를 확인하고 다시 입력해주세요.");
			}

		}
	}
	public void inputOrderCount(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.count = scanner.nextInt();
			if (pgType.count >= ConstValueClass.MIN_COUNT && pgType.count <= ConstValueClass.MAX_COUNT) {
				break;
			} else if (pgType.count < ConstValueClass.MIN_COUNT) {
				System.out.println("최소 구매 갯수는 1장입니다. 다시 입력해주세요");
			} else if (pgType.count < ConstValueClass.MAX_COUNT) {
				System.out.println("최대 구매 갯수는 10장입니다. 다시 입력해주세요.");
			}
		} 
		
	}
}
