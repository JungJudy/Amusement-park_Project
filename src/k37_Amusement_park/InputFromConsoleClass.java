package k37_Amusement_park;

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
	public void selectTicekType(TypeClass pgType) {
		output.printTicketType();
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

	public void inputID_Number(TypeClass pgType) {
		output.printIDNumber();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
	
		while(true) {
			pgType.customerID_Number = scanner.next();
			
			//�ֹε�Ϲ�ȣ�� ���θ� �����ϸ鼭 ���Ա��� 14�ڸ������ϰ�
			if (pgType.customerID_Number.length() == 14 && pgType.customerID_Number.contains("-")) {
				//���غ��� �⵵�� ũ�� 1900��� ������ ���� (ex.22��~99��). �ֹι�ȣ ���ڸ��� ù��ȣ�� 1�̳� 2���� �Ѵ�.
				if(Integer.parseInt(sdf.format(calendar.getTime())) < Integer.parseInt(pgType.customerID_Number.substring(0, 2)) && Integer.parseInt(pgType.customerID_Number.substring(0, 2)) <= 99) {
					if (pgType.customerID_Number.charAt(7) == '1' || pgType.customerID_Number.charAt(7) == '2') {
						break;
					} else {
						System.out.println("�ֹε�Ϲ�ȣ�� Ȯ���ϰ� �ٽ� �Է����ּ���.");
						continue;
					}
					//�ֹι�ȣ �� ���ڸ��� 0���� ũ�ų� ����, ���ؿ� ���ų� ������ 2000���� (ex.00~21��)
				} else if (Integer.parseInt(pgType.customerID_Number.substring(0, 2)) >= 0 && Integer.parseInt(pgType.customerID_Number.substring(0, 2)) <= Integer.parseInt(sdf.format(calendar.getTime()))){
					if (pgType.customerID_Number.charAt(7) == '3' || pgType.customerID_Number.charAt(7) == '4') {
						break;
					} else {
						System.out.println("�ֹε�Ϲ�ȣ�� Ȯ���ϰ� �ٽ� �Է����ּ���.");
						continue;
					}
				}
				break;
			} else {
				System.out.println("�ֹε�Ϲ�ȣ�� Ȯ���ϰ� �ٽ� �Է����ּ���.");
			}
		}
		
	}
	public void inputOrderCount(TypeClass pgType) {
		output.printOrderCount();
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
	public void inputDiscountType(TypeClass pgType) {
		output.printDiscount();
		while(true) {
			pgType.discountType	= scanner.nextInt();
			if (pgType.discountType == ConstValueClass.NOT_DISCOUNT) {
				pgType.discountRate = ConstValueClass.NOT_DISCOUNT_RATE;
				pgType.discountTypeStr = "����";
				break;
			} else if (pgType.discountType == ConstValueClass.DISABLE_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.DISABLE_DISCOUNT_RATE;
				pgType.discountTypeStr = "�����";
				break;
			} else if (pgType.discountType == ConstValueClass.NATIONAL_MERIT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.NATIONAL_MERIT_DISCOUNT_RATE;
				pgType.discountTypeStr = "����������";
				break;
			} else if (pgType.discountType == ConstValueClass.MULTICHILD_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.MULTICHILD_DISCOUNT_RATE;
				pgType.discountTypeStr = "���ڳ�";
				break;
			} else if (pgType.discountType == ConstValueClass.PREGNANT_DISCOUNT_TYPE) {
				pgType.discountRate = ConstValueClass.PREGNANT_DISCOUNT_RATE;
				pgType.discountTypeStr = "�ӻ��";
				break;
			} else {
				System.out.println("�������� Ȯ���ϰ� �ٽ� �������ֽñ� �ٶ��ϴ�.");
			}
		}

	}
	public void orderContinue(TypeClass pgType) {
		output.printOrderContinue();
		while(true) {
			pgType.orderContinueType = scanner.nextInt();
			if (pgType.orderContinueType == ConstValueClass.ORDER_CONTINUE || pgType.orderContinueType == ConstValueClass.ORDER_EXIT) {
				break;
			} else {
				System.out.println("[1. Ƽ�Ϲ߱� 2.����]�ٽ� �������ּ���.");
			}
		}

	}
	public void programContinue(TypeClass pgType) {
		// TODO Auto-generated method stub
		output.printProgramContinue();
		while (true) {
			pgType.programConinueType = scanner.nextInt();
			if (pgType.programConinueType == ConstValueClass.PROGRAM_CONTINUE || pgType.programConinueType == ConstValueClass.PROGRAM_EXIT) {
				break;
			} else {
				System.out.println("[1:���ο� �ֹ�, 2:���α׷� ����]�ٽ� �������ּ���.");
			}
		}
	}
}
