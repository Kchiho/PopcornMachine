package model;

import java.util.ArrayList;

public class PopcornDAO {
	private final int startPk = 1001;
	private int pk = startPk;
	// update 파트 조건을 pk시작값인 1001로 설정해놓았는데 이후 update때
	// pkStart? 를 추가해서 바꾸는게 직관적일듯함
	ArrayList<PopcornVO> datas;

	public PopcornDAO() {
		datas = new ArrayList<PopcornVO>();

		// 기본데이터
		PopcornVO vo1 = new PopcornVO();
		vo1.setNum(pk++);
		vo1.setName("팝콘");
		vo1.setPrice(2000);
		vo1.setCnt(10);
		datas.add(vo1);

		PopcornVO vo2 = new PopcornVO();
		vo2.setNum(pk++);
		vo2.setName("카라멜치즈팝콘");
		vo2.setPrice(2500);
		vo2.setCnt(2);
		datas.add(vo2);

		PopcornVO vo3 = new PopcornVO();
		vo3.setNum(pk++);
		vo3.setName("치즈팝콘");
		vo3.setPrice(2500);
		vo3.setCnt(4);
		datas.add(vo3);

		PopcornVO vo4 = new PopcornVO();
		vo4.setNum(pk++);
		vo4.setName("무지개팝콘");
		vo4.setPrice(3000);
		vo4.setCnt(5);
		datas.add(vo4);

	}	

	public boolean insert(PopcornVO vo) { //팝콘메뉴추가 
		if(vo.getName()==null || vo.getPrice()==0) {
			// 조건확인바람!
//			System.out.println("   로그: 메뉴추가실패(이름 또는 가격이 입력되지않았음");
			return false;
		}
		vo.setNum(pk++);
		datas.add(vo);
//		System.out.println("   로그: 메뉴추가성공");
		return true;
	}	

	public ArrayList<PopcornVO> selectAll(PopcornVO vo) { //전체메뉴-selectAll
//		System.out.println("	로그: 전체메뉴출력성공");
		return datas;
	}

	public PopcornVO selectOne(PopcornVO vo) { //전체메뉴-selectOne
		for(int i=0; i<datas.size(); i++) {
			if(vo.getNum()==datas.get(i).getNum()) {
//				System.out.println("	로그: "+datas.get(i)+" 반환성공");
				return datas.get(i);
			}
		}
//		System.out.println("	로그: 반환실패");
		return null;
	}

	public boolean update(PopcornVO vo) { //수정(업데이트) 
		// 가격수정
		if(vo.getPrice()!=0 && vo.getNum()>=startPk) {
			//가격을 입력받지 않았거나 pk가 1001보다 작은 경우가 아니라면
			for (int i=0; i<datas.size(); i++) { //전체비교 
				if(datas.get(i).getNum() == vo.getNum()) { //대치데이터찾기
					datas.get(i).setPrice(vo.getPrice()); //가격 덮어씌우기
//					System.out.println("	로그: 가격수정 성공");
					return true;
				}
			}
//			System.out.println("	로그: 가격수정 실패(가격없음)");
			return false;
		}
		// 재고수정
		if(vo.getCnt()!=0 && vo.getNum()>=startPk) {
			//재고가0이거나 pk가 1001보다 작은 경우가 아니라면
			for (int i=0; i<datas.size(); i++) { //전체비교
				if(datas.get(i).getNum() == vo.getNum()) { //대치데이터찾기
					datas.get(i).setCnt(datas.get(i).getCnt()+vo.getCnt());
					// 현재재고에 수정할 재고값을 더해서 덮어씌우기
//					System.out.println("	로그: 재고수정 성공");
					return true;
				}
			}
//			System.out.println("	로그: 재고수정 실패");
			return false;
		}
		// 구매
		if(vo.getNum()>=startPk) {
			//pk가 1001보다 크거나 같다면
			for (int i = 0; i < datas.size(); i++) {
				if(datas.get(i).getNum() == vo.getNum()) {
					if(datas.get(i).getCnt() != 0) {
						datas.get(i).setCnt(datas.get(i).getCnt()-1);
//						System.out.println("	로그: 구매성공");
						return true;
					}
				}
			}
//			System.out.println("	로그: 구매실패(대치데이터없음)");
			return false;
		}
//		System.out.println("	로그: 구매실패(pk입력범위벗어남)");
		return false;
	}

	public boolean delete(PopcornVO vo) { //메뉴삭제
		for(int i=0; i<datas.size(); i++) {
			if(datas.get(i).getNum() == vo.getNum()) {
				datas.remove(i);
//				System.out.println("	로그: 삭제성공");
				return true;
			}
		}
//		System.out.println("	로그: 삭제실패");
		return false;
	}
}