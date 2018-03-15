package fi.hh.swd20.Kirjakauppaprojekti;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.Kirjakauppaprojekti.domain.Kategoria;
import fi.hh.swd20.Kirjakauppaprojekti.domain.Kirja;
import fi.hh.swd20.Kirjakauppaprojekti.domain.KirjaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KirjaRepositoryTest {

	@Autowired
	private KirjaRepository repository;
	
	//Testaa KirjaRepo
	@Test
	public void findByTekijaPalauttaaTeoksen() {
        List<Kirja> kirjat = repository.findByTekija("John Keats");
        
        assertThat(kirjat).hasSize(1);
        assertThat(kirjat.get(0).getTeos()).isEqualTo("Hyperionin laulut");
    }
	
    @Test
    public void luoUusiKirja() {
    	Kirja kirja = new Kirja("Complexity Theory", "John Wolt", new Kategoria("Tietokirjallisuus"), "2002", "0917345017320571039475", "110");
    	repository.save(kirja);
    	assertThat(kirja.getId()).isNotNull();
    } 
    
    @Test
    public void poistaKirja() {
    	Kirja kirja = new Kirja ("Mind Children", "Hans Moravec", new Kategoria("Tietokirjallisuus"), "1988", "0917345017320571030475", "314");
    	repository.save(kirja);	    	
    	repository.delete(kirja);	    	
    	List<Kirja> kirjat = repository.findByTekija("Hans Moravec");	        
        assertThat(kirjat).hasSize(0);
    }
    
}
