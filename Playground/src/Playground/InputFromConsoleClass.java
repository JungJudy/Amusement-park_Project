package Playground;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
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
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
	
		while(true) {
			pgType.customerID_Number = scanner.next();
			
			//주민등록번호가 가로를 포함하면서 포함길이 14자리여야하고
			if (pgType.customerID_Number.length() == 14 && pgType.customerID_Number.contains("-")) {
				//올해보다 년도가 크면 1900년대 생으로 가정 (ex.22년~99년). 주민번호 뒷자리의 첫번호가 1이나 2여야 한다.
				if(Integer.parseInt(sdf.format(calendar.getTime())) < Integer.parseInt(pgType.customerID_Number.substring(0, 2)) && Integer.parseInt(pgType.customerID_Number.substring(0, 2)) <= 99) {
					if (pgType.customerID_Number.charAt(7) == '1' || pgType.customerID_Number.charAt(7) == '2') {
						break;
					} else {
						System.out.println("주민등록번호를 확인하고 다시 입력해주세요.");
						continue;
					}
					//주민번호 앞 두자리가 0보다 크거나 같고, 올해와 같거나 작으면 2000년대생 (ex.00~21년)
				} else if (Integer.parseInt(pgType.customerID_Number.substring(0, 2)) >= 0 && Integer.parseInt(pgType.customerID_Number.substring(0, 2)) <= Integer.parseInt(sdf.format(calendar.getTime()))){
					if (pgType.customerID_Number.charAt(7) == '3' || pgType.customerID_Number.charAt(7) == '4') {
						break;
					} else {
						System.out.println("주민등록번호를 확인하고 다시 입력해주세요.");
						continue;
					}
				}
				break;
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
				pgType.discountTypeStr = "없음";
				break;
			} else if (pgType.discountType == ConstValueClass.DISABLE_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.DISABLE_DISCOUNT_RATE;
				pgType.discountTypeStr = "장애인";
				break;
			} else if (pgType.discountType == ConstValueClass.NATIONAL_MERIT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.NATIONAL_MERIT_DISCOUNT_RATE;
				pgType.discountTypeStr = "국가유공자";
				break;
			} else if (pgType.discountType == ConstValueClass.MULTICHILD_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.MULTICHILD_DISCOUNT_RATE;
				pgType.discountTypeStr = "다자녀";
				break;
			} else if (pgType.discountType == ConstValueClass.PREGNANT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.PREGNANT_DISCOUNT_RATE;
				pgType.discountTypeStr = "임산부";
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
