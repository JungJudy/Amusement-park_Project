package Playground;

public class OutputClass {
	
	public void printTicketType() {
		System.out.println("권종을 선택해주세요");
		System.out.println("1.주간권\n2.야간권");
	}

	public void printIDNumber() {
		// TODO Auto-generated method stub
		System.out.println("주민등록번호를 입력해주세요 (ex.210426-1234567)");
	}

	public void printOrderCount() {
		// TODO Auto-generated method stub
		System.out.println("몇장을 구매하시겠습니까? (최대 10장)");
	}

	public void printDiscount() {
		// TODO Auto-generated method stub
		System.out.println("우대사항을 선택해주세요");
		System.out.println("1.없음 (나이 우대는 자동처리)");
		System.out.println("2.장애인");
		System.out.println("3.국가유공자");
		System.out.println("4.다자녀");
		System.out.println("5.임산부");
	}

	public void printPriceResult(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		System.out.printf("가격은 %d 원 입니다.\n감사합니다.\n", pgType.priceResult);
	}

	public void printOrderContinue() {
		// TODO Auto-generated method stub
		System.out.println("계속 발권하시겠습니까?");
		System.out.println("1.티켓 발권");
		System.out.println("2.종료");
	}
}
