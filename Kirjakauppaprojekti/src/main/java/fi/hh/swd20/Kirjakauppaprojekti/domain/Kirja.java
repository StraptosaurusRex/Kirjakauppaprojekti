package fi.hh.swd20.Kirjakauppaprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Kirja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String teos;
	private String tekija;
	private String vuosi;
	private String isbn;
	private String hinta;
    @ManyToOne
    @JoinColumn(name = "kategoriaid")
    private Kategoria kategoria;
	
	public Kirja() {
		this.teos = null;
		this.tekija = null;
		this.vuosi = null;
		this.isbn = null;
		this.hinta = null;
	}
	
	public Kirja(String teos, String tekija, String vuosi, String isbn, String hinta) {
		super();
		this.teos = teos;
		this.tekija = tekija;
		this.vuosi = vuosi;
		this.isbn = isbn;
		this.hinta = hinta;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeos() {
		return teos;
	}

	public void setTeos(String teos) {
		this.teos = teos;
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
	

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	@Override
	public String toString() {
		return "Kirja [id=" + id + ", teos=" + teos + ", tekija=" + tekija + ", vuosi=" + vuosi + ", isbn=" + isbn
				+ ", hinta=" + hinta + ", kategoria=" + this.getKategoria() +"]";
	}

}
