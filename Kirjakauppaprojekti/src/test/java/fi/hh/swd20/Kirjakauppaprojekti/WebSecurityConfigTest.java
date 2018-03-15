package fi.hh.swd20.Kirjakauppaprojekti;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.Kirjakauppaprojekti.web.UserDetailServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSecurityConfigTest {

	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(userDetailsService).isNotNull();
	}
}
