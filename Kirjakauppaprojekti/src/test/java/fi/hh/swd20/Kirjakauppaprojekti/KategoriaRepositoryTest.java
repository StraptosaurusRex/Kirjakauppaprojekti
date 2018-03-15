package fi.hh.swd20.Kirjakauppaprojekti;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.Kirjakauppaprojekti.domain.Kategoria;
import fi.hh.swd20.Kirjakauppaprojekti.domain.KategoriaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class KategoriaRepositoryTest {

	@Autowired
	private KategoriaRepository katrepository;
	
    //Testaa KatRepo
	@Test
	public void findByNimiPalauttaaKategorian() {		
		List<Kategoria> kategoriat = katrepository.findByNimi("Sci-Fi");
		assertThat(kategoriat).hasSize(1);		
	}
	
	@Test
	public void luoUusiKategoria() {
		Kategoria kategoria = new Kategoria("Modernismi");
		katrepository.save(kategoria);
		assertThat(kategoria.getKategoriaId()).isNotNull();
		List<Kategoria> kategoriat = katrepository.findByNimi("Modernismi");
		assertThat(kategoriat).hasSize(1);	
	}
	
	@Test
	public void poistaKategoria() {
		Kategoria kategoria = new Kategoria("Rajatieto");
		katrepository.save(kategoria);
		katrepository.delete(kategoria);
		List<Kategoria> kategoriat = katrepository.findByNimi("Rajatieto");
		assertThat(kategoriat).hasSize(0);		
	}
}
