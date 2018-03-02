package fi.hh.swd20.Kirjakauppaprojekti.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Kategoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaid;
	private String nimi;
	
	@OneToMany(mappedBy = "kategoria")
	private List<Kirja> kirjat;
	
	public Kategoria() {}
	
	public Kategoria(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getKategoriaid() {
		return kategoriaid;
	}

	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Kirja> getKirjat() {
		return kirjat;
	}

	public void setKirjat(List<Kirja> kirjat) {
		this.kirjat = kirjat;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", nimi=" + nimi + "]";
	}

}
