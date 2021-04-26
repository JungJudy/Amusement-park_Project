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
		output.printTicketType();
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
		output.printIDNumber();
		while(true) {
			pgType.customerID_Number = scanner.next();
			if (pgType.customerID_Number.length() == 14 && pgType.customerID_Number.contains("-")) {
				if (pgType.customerID_Number.charAt(8) == 1 || pgType.customerID_Number.charAt(8) == 2 || 
						pgType.customerID_Number.charAt(8) == 3 || pgType.customerID_Number.charAt(8) == 4) {
					break;
				} break;
			} else {
				System.out.println("주민등록번호를 확인하고 다시 입력해주세요.");
			}

		}
	}
	public void inputOrderCount(PlaygroundTypeClass pgType) {
		output.printOrderCount();
		while(true) {
			pgType.orderCount = scanner.nextInt();
			if (pgType.orderCount >= ConstValueClass.MIN_COUNT && pgType.orderCount <= ConstValueClass.MAX_COUNT) {
				break;
			} else if (pgType.orderCount < ConstValueClass.MIN_COUNT) {
				System.out.println("최소 구매 갯수는 1장입니다. 다시 입력해주세요");
			} else if (pgType.orderCount > ConstValueClass.MAX_COUNT) {
				System.out.println("최대 구매 갯수는 10장입니다. 다시 입력해주세요.");
			}
		} 
		
	}
	public void inputDiscountType(PlaygroundTypeClass pgType) {
		output.printDiscount();
		while(true) {
			pgType.discountType	= scanner.nextInt();
			if (pgType.discountType == ConstValueClass.NOT_DISCOUNT) {
				pgType.discountRate = ConstValueClass.NOT_DISCOUNT_RATE;
				pgType.discountTypeStr = "*우대적용 없음";
				break;
			} else if (pgType.discountType == ConstValueClass.DISABLE_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.DISABLE_DISCOUNT_RATE;
				pgType.discountTypeStr = "*장애인 우대적용";
				break;
			} else if (pgType.discountType == ConstValueClass.NATIONAL_MERIT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.NATIONAL_MERIT_DISCOUNT_RATE;
				pgType.discountTypeStr = "*국가유공자 우대적용";
				break;
			} else if (pgType.discountType == ConstValueClass.MULTICHILD_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.MULTICHILD_DISCOUNT_RATE;
				pgType.discountTypeStr = "*다자녀 우대적용";
				break;
			} else if (pgType.discountType == ConstValueClass.PREGNANT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.PREGNANT_DISCOUNT_RATE;
				pgType.discountTypeStr = "*임산부 우대적용";
				break;
			} else {
				System.out.println("우대사항을 확인하고 다시 선택해주시기 바랍니다.");
			}
		}
		
	}
	public void orderContinue(PlaygroundTypeClass pgType) {
		output.printOrderContinue();
		while(true) {
			pgType.orderContinueType = scanner.nextInt();
			if (pgType.orderContinueType == ConstValueClass.ORDER_CONTINUE || pgType.orderContinueType == ConstValueClass.ORDER_EXIT) {
				break;
			} else {
				System.out.println("[1. 티켓발권 2.종료]다시 선택해주세요.");
			}
		}
		
	}
	public void programContinue(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		output.printProgramContinue();
		while (true) {
			pgType.programConinueType = scanner.nextInt();
			if (pgType.programConinueType == ConstValueClass.PROGRAM_CONTINUE || pgType.programConinueType == ConstValueClass.PROGRAM_EXIT) {
				break;
			} else {
				System.out.println("[1:새로운 주문, 2:프로그램 종료]다시 선택해주세요.");
			}
		}
	}
}
