package Model;

public class PopcornVO {
	private int num; // pk (1001부터 시작)
	private String name; // 팝콘 이름
	private int price; // 팝콘 가겨
	private int cnt; // 팝콘 재고
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "PopcornVO [num=" + num + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
	}

}
