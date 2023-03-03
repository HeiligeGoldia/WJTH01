package model;

public class Sach {
	
	private int ma;
	private String ten;
	private String nsx;
	private float gia;
	
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNsx() {
		return nsx;
	}
	public void setNsx(String nsx) {
		this.nsx = nsx;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public Sach() {
		
	}
	public Sach(String ten, String nsx, float gia) {
		this.ten = ten;
		this.nsx = nsx;
		this.gia = gia;
	}
	public Sach(int ma, String ten, String nsx, float gia) {
		this.ma = ma;
		this.ten = ten;
		this.nsx = nsx;
		this.gia = gia;
	}
	
	@Override
	public String toString() {
		return "Sach [ma=" + ma + ", ten=" + ten + ", nsx=" + nsx + ", gia=" + gia + "]";
	}
	
}
