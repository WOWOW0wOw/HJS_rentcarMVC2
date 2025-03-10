package basic.rentcar.vo;

public class rentcar {
	private int num;
	private String name;
	private int category;
	private int price;
	private int usepeople;
	private int total_Qty;
	private String company;
	private String img;
	private String info;

	public rentcar(int num, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		super();
		this.num = num;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_Qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}

	public int getTotalQty() {
		return total_Qty;
	}

	public void setTotalQty(int totalQty) {
		this.total_Qty = totalQty;
	}

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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUsepeople() {
		return usepeople;
	}

	public void setUsepeople(int usepeople) {
		this.usepeople = usepeople;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Rentcar [num=" + num + ", name=" + name + ", category=" + category + ", price=" + price + ", usepeople="
				+ usepeople + ", totalQty=" + total_Qty + ", company=" + company + ", img=" + img + ", info=" + info
				+ "]";
	}
}
