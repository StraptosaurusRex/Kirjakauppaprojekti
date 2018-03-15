package fi.hh.swd20.Kirjakauppaprojekti;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.Kirjakauppaprojekti.domain.User;
import fi.hh.swd20.Kirjakauppaprojekti.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryTest {
	@Autowired
	private UserRepository userepository;
	
	//Testaa UserRepo
	
	String password = "salasana";
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String passwordHash = passwordEncoder.encode(password);
	
	@Test
    public void findByNameShouldReturnUser() {
        User user = userepository.findByUsername("admin");        
        assertThat(user.getId()).isNotNull();
        assertThat(user.getRole()).isEqualTo("ADMIN");
    }
    
    @Test
    public void createNewUser() {    	
    	User user = new User("Homppi", passwordHash, "USER", "homppi@lomppi");
    	userepository.save(user);
    	assertThat(user.getId()).isNotNull();
    	User testUser1 = userepository.findByUsername("Homppi");
    	assertThat(testUser1.getEmail()).isEqualTo("homppi@lomppi");
    }
    
    @Test
    public void deleteUser() {
    	User user = new User("Spyder", passwordHash, "USER", "spyder@web");
    	userepository.save(user);	    	
    	userepository.delete(user);	    	
    	User testUser2 = userepository.findByUsername("Spyder");	        
        assertThat(testUser2).isNull();
    }
}
