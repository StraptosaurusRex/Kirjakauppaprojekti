package fi.hh.swd20.Kirjakauppaprojekti.domain;

public class Kirja {

	private String nimi;
	private String tekija;
	private String vuosi;
	private String isbn;
	private String hinta;
	
	public Kirja() {
		this.nimi = null;
		this.tekija = null;
		this.vuosi = null;
		this.isbn = null;
		this.hinta = null;
	}
	
	public Kirja(String nimi, String tekija, String vuosi, String isbn, String hinta) {
		this.nimi = nimi;
		this.tekija = tekija;
		this.vuosi = vuosi;
		this.isbn = isbn;
		this.hinta = hinta;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public String getVuosi() {
		return vuosi;
	}

	public void setVuosi(String vuosi) {
		this.vuosi = vuosi;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getHinta() {
		return hinta;
	}

	public void setHinta(String hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Kirja [nimi=" + nimi + ", tekija=" + tekija + ", vuosi=" + vuosi + ", isbn=" + isbn + ", hinta=" + hinta
				+ "]";
	}
	
}
