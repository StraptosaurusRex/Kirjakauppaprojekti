package fi.hh.swd20.Kirjakauppaprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.hh.swd20.Kirjakauppaprojekti.domain.Kirja;
import fi.hh.swd20.Kirjakauppaprojekti.domain.KirjaRepository;

@SpringBootApplication
public class KirjakauppaprojektiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaprojektiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kirjaDemo(KirjaRepository repository) {
		return (args) -> {
			log.info("tallenna pari kirjaa");
			repository.save(new Kirja("Hyperionin laulut", "John Keats", "1998", "23571047650193750917", "90"));
			repository.save(new Kirja("Kadotettu Paratiisi", "John Milton", "1600", "09346+13746+9714+36", "80"));	
			
			log.info("hae kaikki kirjat");
			for (Kirja kirja : repository.findAll()) {
				log.info(kirja.toString());
			}

		};
	}
	
	
	
	
	
	
}
