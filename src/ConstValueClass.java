package Playground;

import java.io.File;

public class ConstValueClass {
	//���� Ÿ��
	final static int DAY_PRICE_TYPE = 1, NIGHT_PRICE_TYPE = 2;
	//���� ����
	final static int MIN_ADULT = 19, MAX_ADULT = 64, MIN_TEEN = 13, MAX_TEEN = 18, MIN_CHILD = 3, MAX_CHILD = 12;
	//���� �׷� Ÿ��
	final static int ADULT = 1, TEEN = 2, CHILD = 3, OLD = 4, BABY = 5;
	//��� Ÿ��
	final static int  NOT_DISCOUNT = 1, DISABLE_DISCOUNT_TYPE = 2, NATIONAL_MERIT_DISCOUNT_TYPE = 3, MULTICHILD_DISCOUNT_TYPE = 4, PREGNANT_DISCOUNT_TYPE = 5;
	//��� ������
	final static double NOT_DISCOUNT_RATE = 0, DISABLE_DISCOUNT_RATE = 0.4, NATIONAL_MERIT_DISCOUNT_RATE = 0.5, MULTICHILD_DISCOUNT_RATE = 0.2, PREGNANT_DISCOUNT_RATE = 0.15;
	//�ֹ� ���� �ּ� �ִ�
	final static int MIN_COUNT = 1, MAX_COUNT = 10;
	//����
	final static int[] price = {56000,46000,47000,40000,44000,37000,44000,37000,0};
	//�̾ �ֹ� or ����
	final static int ORDER_CONTINUE = 1, ORDER_EXIT = 2;
	//���α׷� �ֹ� or ����
	final static int PROGRAM_CONTINUE = 1, PROGRAM_EXIT = 2;
	//���� ���
	final static File file = new File("C:\\Users\\������\\Documents\\����\\�����α�����\\ticketResult.csv");
}
