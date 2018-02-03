package fi.hh.swd20.Kirjakauppaprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.hh.swd20.Kirjakauppaprojekti.domain.Kirja;
import fi.hh.swd20.Kirjakauppaprojekti.domain.KirjaRepository;

@Controller
public class KirjaController {
	
	@Autowired
	private KirjaRepository repository; 

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String returnIndex(){
		return "index";
	}
	
    @RequestMapping(value="/kirjalista")
    public String kirjatLista(Model model) {	
        model.addAttribute("kirjat", repository.findAll());
        return "kirjalista";
    }
	
    @RequestMapping(value = "/lisaa")
    public String lisaaKirja(Model model){
    	model.addAttribute("kirja", new Kirja());
        return "lisaakirja";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String tallenna(Kirja kirja){
        repository.save(kirja);
        return "redirect:/kirjalista";
    }    

    @RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
    public String deleteKirja(@PathVariable("id") Long kirjaId, Model model) {
    	repository.delete(kirjaId);
        return "redirect:/kirjalista";
    }    
    
}
