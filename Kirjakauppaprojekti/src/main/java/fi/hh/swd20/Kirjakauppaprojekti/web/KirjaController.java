package fi.hh.swd20.Kirjakauppaprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class KirjaController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String returnIndex(){
		return "index";
	}
	
}
