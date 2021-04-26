package Playground;

public class ConstValueClass {
	//권종 타입
	final static int DAY_PRICE_TYPE = 1, NIGHT_PRICE_TYPE = 2;
	//나이 범위
	final static int MIN_ADULT = 19, MAX_ADULT = 64, MIN_TEEN = 13, MAX_TEEN = 18, MIN_CHILD = 3, MAX_CHILD = 12;
	//나이 그룹 타입
	final static int ADULT = 1, TEEN = 2, CHILD = 3, OLD = 4, BABY = 5;
	//우대 타입
	final static int  DISABLE_DISCOUNT_TYPE = 2, NATIONAL_MERIT_DISCOUNT_TYPE = 3, MULTICHILD_DISCOUNT_TYPE = 4, PREGNANT_DISCOUNT_TYPE = 5;
	//우대 할인율
	final static double DISABLE_DISCOUNT_RATE = 0.4, NATIONAL_MERIT_DISCOUNT_RATE = 0.5, MULTICHILD_DISCOUNT_RATE = 0.2, PREGNANT_DISCOUNT_RATE = 0.15;
	//주문 갯수 최소 최대
	final static int MIN_COUNT = 1, MAX_COUNT = 10;
}
