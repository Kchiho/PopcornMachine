package View;

import java.util.ArrayList;
import java.util.Scanner;
import Model.PopcornVO;

public class PopcornView {

	Scanner sc = new Scanner(System.in);
	public int action; // 사용자의 입력값으로 받을 변수생성

	public void startView() {
		// 메뉴 출력
		while (true) { // 유효성 검사!
			System.out.println("==★Popcorn Machine★==");
			System.out.println("1.   메        뉴"); // 1234입력시 관리자 모드
			System.out.println("2.   주  문  하 기");
			System.out.println("3.   프로그램  종료");
			System.out.println("======================");
			System.out.println();
			System.out.print("번호를 입력해주세요 : "); // 입력값 우측으로 받기

			try { // 예외처리
				action = sc.nextInt(); // 사용자의 입력값받기
				if ((1 <= action && action <= 3) || (action == 1234)) {
					break; // 1-3 메뉴를 정확히 눌렀을 시에 빠져나온다.
				} else {
					System.out.println("범위 외의 입력입니다!"); // 범위외의 입력값 입력시 출력될 멘트
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력하여 주세요!");
				sc.nextLine();
				continue; // 입력 오류시에 메뉴판 재출력 반복.
			}
		}
	}

	public void showAllMenu(ArrayList<PopcornVO> datas) {
		if (datas.size() == 0) { // 저장된 데이터가 없다면?
			System.out.println("정보가 존재하지 않습니다."); //멘트출력
		} else { //저장된 데이터가 있을 시, for 문으로 출력
			for (int i = 0; i < datas.size(); i++) {
				System.out.println(datas.get(i).getNum() + "번\t" + datas.get(i).getName() + "\t"
						+ datas.get(i).getPrice() + "원\t" + "남은수량 :" + datas.get(i).getCnt());
			}
		}
		System.out.println(); // 전체메뉴 출력 후 한칸 띄움.
	}

	public String inputString() {    // 문자열 입력장치
		System.out.print("입력 : ");
		String str = sc.next();    //사용자 입력값 str 변수
		return str;
	}

	public int inputInt() {    // 정수 입력장치.
		while(true) {
			try {
				System.out.print("입력 : ");
				int i = sc.nextInt();    // 사용자 입력값 i
				if (i < 0) {    // 정수가 아닌 수를 입력했을 시(유효성 검사)
					System.out.println("정수만 입력해 주세요.");
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("숫자만 입력하여 주세요!");
				sc.nextLine();
				continue; // 입력 오류시에 메뉴판 재출력 반복.
			}
		}
	}

	public void inputName() {
		System.out.println("상품명을 입력하여 주세요."); // 상품명을 입력하여 주세요
	}

	public void inputPrice() {
		System.out.println("금액을 입력하여 주세요."); // 금액을 입력하여 주세요
	}

	public void inputCnt() {
		System.out.println("재고를 입력하여 주세요."); // 재고를 입력하여 주세요
	}

	public void inputNum() {
		System.out.println("번호를 입력하여 주세요."); // 번호를 입력하여 주세요
	}

	public void press1() { // 1. 메뉴창 출력
		System.out.println("----Popcorn menu----");
	}

	public void press2() { // 2. 주문하기
		System.out.println("주문하기 메뉴 입니다.");
	}

	public void orderNum() {
		System.out.println("주문하실 메뉴 번호를 선택해 주세요. ");
	}

	public void suc() {
		System.out.println("성공! (●'◡'●)");
	}

	public void fail() {
		System.out.println("실패 (..  )");
	}

	public void endView() {
		System.out.println("이용해 주셔서 감사합니다.");
		System.out.println("프로그램이 종료 됩니다.");
		for (int i = 0; i < 5; i++) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 관리자모드
	public void adminStartView() {
		while (true) {
			System.out.println("==== Adimin Mode====");
			System.out.println("1.   팝콘 메뉴 추가");
			System.out.println("2.   팝콘 재고 수정");
			System.out.println("3.   팝콘 가격 수정");
			System.out.println("4.   팝콘 메뉴 삭제");
			System.out.println("5.   관리자모드 종료");
			System.out.println("====================");
			System.out.println();
			System.out.print("실행할 번호 입력해 주세요: "); // 입력값
			action = sc.nextInt();
			try {
				if (1 <= action && action <= 5) {
					break;
				} else {
					System.out.println("범위 외의 입력입니다!");
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력하여 주세요!");
				sc.nextLine();
				continue; // 입력 오류시에 메뉴판 재출력 반복.
			}
		}
	}

	// 메뉴 추가
	public void adminPress1() {
		System.out.println("팝콘 메뉴 추가를 진행합니다. ");
	}

	// 팝콘 재고 확인
	public void adminPress2() {
		System.out.println("팝콘 재고 추가 메뉴입니다. ");
	}

	// 팝콘 가격 수정
	public void adminPress3() {
		System.out.println("팝콘 가격 수정 메뉴입니다.");
	}

	// 메뉴 삭제
	public void adminPress4() {
		System.out.println("팝콘 삭제 메뉴입니다.");
	}

	public void adminAddMenu() {
		System.out.println("추가하실 팝콘의 이름, 가격, 재고를 순서대로 입력해 주세요.");
	}

	public void adminEditCnt() {
		System.out.println("재고를 추가할 팝콘의 번호와 추가되는 팝콘의 재고를 순서대로 입력해 주세요.");
	}

	public void adminEditPrice() {
		System.out.println("가격을 변경할 팝콘의 번호와 변경되는 가격을 순서대로 입력해 주세요.");
	}

	public void adminDeleteMenu() {
		System.out.println("삭제하실 팝콘의 번호를 입력해 주세요.");
	}

	public void adminNoExist() {
		System.out.println("해당 번호의 상품이 존재하지 않습니다.");
	}

	public void adminEndView() {
		System.out.println("관리자 모드를 종료합니다");
	}
}