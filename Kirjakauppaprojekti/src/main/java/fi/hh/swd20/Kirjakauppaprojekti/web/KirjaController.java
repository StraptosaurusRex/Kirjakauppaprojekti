package fi.hh.swd20.Kirjakauppaprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.Kirjakauppaprojekti.domain.KategoriaRepository;
import fi.hh.swd20.Kirjakauppaprojekti.domain.Kirja;
import fi.hh.swd20.Kirjakauppaprojekti.domain.KirjaRepository;

@Controller
public class KirjaController {
	
	@Autowired
	private KirjaRepository repository; 
	
	@Autowired
	private KategoriaRepository katrepository;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String returnIndex(){
		return "index";
	}
	
    @RequestMapping(value="/kirjalista")
    public String kirjatLista(Model model) {	
        model.addAttribute("kirjat", repository.findAll());
        return "kirjalista";
    }
    
 // RESTful service to get all kirjat
    @RequestMapping(value="/kirjat", method = RequestMethod.GET)
    public @ResponseBody List<Kirja> kirjaListaRest() {	
        return (List<Kirja>) repository.findAll();
    }    

	// RESTful service to get kirja by id
    @RequestMapping(value="/kirja/{id}", method = RequestMethod.GET)
    public @ResponseBody Kirja findKirjaRest(@PathVariable("id") Long kirjaId) {	
    	return repository.findOne(kirjaId);
    }       
	
    @RequestMapping(value = "/lisaa")
    public String lisaaKirja(Model model){
    	model.addAttribute("kirja", new Kirja());
    	model.addAttribute("kategoriat", katrepository.findAll());
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
    
   @RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
    public String Muokkaa(@PathVariable("id") Long kirjaId, Model model){
	   	model.addAttribute("kirja", repository.findOne(kirjaId));
	   	model.addAttribute("kategoriat", katrepository.findAll());
        return "muokkaa";
    } 
    
   @RequestMapping(value = "/muokkaa/save/{id}", method = RequestMethod.POST)
   public String muutos(@PathVariable("id") Long kirjaId, Kirja kirja){
	   repository.delete(kirjaId);
       repository.save(kirja);
       return "redirect:/kirjalista";
   } 
   @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
}
