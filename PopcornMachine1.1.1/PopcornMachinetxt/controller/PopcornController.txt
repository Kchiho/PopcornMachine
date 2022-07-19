package controller;

import model.PopcornDAO;
import model.PopcornVO;
import view.PopcornView;

public class PopcornController {
	private PopcornDAO model;
	private PopcornView view;
	public PopcornController() {
		model=new PopcornDAO();
		view=new PopcornView();
	}

	public void startApp() {
		while(true) {
			view.startView(); // 사용자모드 시작
			if(view.action == 1) { // 메뉴판
				view.press1(); // 1번메뉴 실행안내
				PopcornVO vo = new PopcornVO(); // 임시 객체를 만들어주고
				view.showAllMenu(model.selectAll(vo)); // 임시객체를 통해 전체메뉴 조회후 출력
			}
			else if(view.action == 2) { // 주문하기
				view.press2(); // 2번메뉴 실행안내
				PopcornVO vo = new PopcornVO(); // 임시객체 만들어주고
				view.showAllMenu(model.selectAll(vo)); // 임시 객체로 메뉴판 한번 보여주고
				view.orderNum(); // 주문할 번호 입력해달라는 안내 문구
				vo.setNum(view.inputInt()); // 입력받은 값을 임시객체 vo에 담아서
				if(model.update(vo)) { // 해당 vo로 업데이트 진행 (num값만 있음)
					view.suc(); // 완료시
				}else {
					view.fail(); // 실패시
				}
			}
			else if(view.action == 3) { // 프로그램 종료
				view.endView(); // 3번메뉴 / 종료안내
				break;
			}
			else if(view.action == 1234) { // 관리자모드
				while(true) { // 관리자모드는 종료시점까지 반복
					view.adminStartView(); // 관리자모드의 메뉴
					if(view.action == 1) { // 관리자 1번 메뉴추가파트
						view.adminPress1(); // 관리자 1번 메뉴임을 알려줌
						PopcornVO vo = new PopcornVO(); // 임시객체 만들어주고
						view.showAllMenu(model.selectAll(vo)); // 임시 객체로 메뉴판 한번 보여주고
						view.adminAddMenu(); // 메뉴이름, 가격, 재고 순으로 입력해달라는 안내문구
						view.inputName(); // 메뉴이름 입력 안내
						vo.setName(view.inputString()); // 임시객체.name에 입력받은 이름 대입
						view.inputPrice(); // 가격 입력 안내
						vo.setPrice(view.inputInt()); // 임시객체.price에 입력받은 가격 대입
						view.inputCnt(); // 재고 입력 안내
						vo.setCnt(view.inputInt()); // 임시객체.cnt에 입력받은 재고 대입
						if(model.insert(vo)) { // 해당 객체로 insert 진행
							view.suc(); // 성공시
						}else {
							view.fail(); // 실패시
						}
					}
					else if(view.action == 2) { // 관리자 2번 재고수정파트
						view.adminPress2(); // 관리자 2번 메뉴임을 알려줌
						PopcornVO vo = new PopcornVO(); // 임시객체 만들어주고
						view.showAllMenu(model.selectAll(vo)); // 임시 객체로 메뉴판 한번 보여주고
						view.adminEditCnt(); // 메뉴번호와 추가할 재고를 입력해달라는 안내문구
						view.inputNum(); // 메뉴번호 입력 안내
						vo.setNum(view.inputInt()); // 임시 객체.num 에 입력받은 번호 대입
						if(model.selectOne(vo)==null) { // 해당 num을 가진 객체가 datas에 없다면
							view.adminNoExist(); // 존재하지 않음을 알려주고
							continue; // 다음반복을 실행
						}
						view.inputCnt(); // 재고 입력 안내
						vo.setCnt(view.inputInt()); // 임시 객체.cnt 에 입력받은 재고 대입
						if(model.update(vo)) { // 해당 객체로 update진행
							view.suc(); // 성공시
						}else {
							view.fail(); // 실패시
						}
					}
					else if(view.action == 3) { // 관리자 3번 가격수정파트
						view.adminPress3(); // 관리자 3번 메뉴임을 알려줌
						PopcornVO vo = new PopcornVO(); // 임시객체 만들어주고
						view.showAllMenu(model.selectAll(vo)); // 임시 객체로 메뉴판 한번 보여주고
						view.adminEditPrice(); // 메뉴번호와 수정할 가격 입력해달라는 안내문구
						view.inputNum(); // 메뉴번호 입력 안내
						vo.setNum(view.inputInt()); // 임시객체.num 에 입력받은 번호 대입
						if(model.selectOne(vo)==null) { // 해당 num을 가진 객체가 datas에 없다면
							view.adminNoExist(); // 존재하지 않음을 알려주고
							continue; // 다음반복을 실행
						}
						view.inputPrice(); // 가격입력 안내
						vo.setPrice(view.inputInt()); // 임시객체.price에 입력받은 가격 대입
						if(model.update(vo)) { // 해당객체로 update 진행
							view.suc(); // 성공시
						}else {
							view.fail(); // 실패시
						}
					}
					else if(view.action == 4) { // 관리자 4번 메뉴삭제파트
						view.adminPress4(); // 관리자 4번 메뉴임을 알려줌
						PopcornVO vo = new PopcornVO(); // 임시객체 만들어주고
						view.showAllMenu(model.selectAll(vo)); // 임시 객체로 메뉴판 한번 보여주고
						view.adminDeleteMenu(); // 삭제할 메뉴의 번호를 입력해달라는 안내문구
						vo.setNum(view.inputInt()); // 임시객체.num에 입력받은 번호 대입
						if(model.delete(vo)) { // 해당객체로 delete 진행
							view.suc(); // 성공시
						}else {
							view.adminNoExist();
							view.fail(); // 실패시
						}
					}
					else if(view.action == 5) { // 관리자모드 종료
						view.adminEndView();
						break;
					}
				}
			}
		}               
	}      
}
