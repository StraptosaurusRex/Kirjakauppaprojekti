package fi.hh.swd20.Kirjakauppaprojekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KirjaRepository extends CrudRepository<Kirja, Long> {

	List<Kirja> findBytekija(String tekija);
	
}


