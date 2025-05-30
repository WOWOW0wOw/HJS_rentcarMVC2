package basic.rentcar.vo;

public class reservation {
	private int reserveSeq;
	private int num;
	private String userid;
	private int qty;
	private int dday;
	private String rday;
	private int usein;
	private int usewifi;
	private int usenavi;
	private int useseat;

	public reservation( int regNo, int num, String userId, int qty, int dday, String rday, int usein, int usewifi, int usenavi,
			int useseat) {
		this.reserveSeq = regNo;
		this.num = num;
		this.userid = userId;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}
	public reservation(int num, String userId, int qty, int dday, String rday, int usein, int usewifi, int usenavi,
			int useseat) {
		this.num = num;
		this.userid = userId;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}

	@Override
	public String toString() {
		return "Reservation [reserveSeq=" + reserveSeq + ", num=" + num + ", userid=" + userid + ", qty=" + qty
				+ ", dday=" + dday + ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi="
				+ usenavi + ", useseat=" + useseat + "]";
	}

	public int getReserve_seq() {
		return reserveSeq;
	}

	public void setReserve_seq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getUsein() {
		return usein;
	}

	public void setUsein(int usein) {
		this.usein = usein;
	}

	public int getUsewifi() {
		return usewifi;
	}

	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}

	public int getUsenavi() {
		return usenavi;
	}

	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}

	public int getUseseat() {
		return useseat;
	}

	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}

}