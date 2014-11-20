package fr.treeptik.leboncoinweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.treeptik.leboncoinweb.exception.ServiceException;
import fr.treeptik.leboncoinweb.pojo.Annonce;
import fr.treeptik.leboncoinweb.service.AnnonceService;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

	@Autowired
	private AnnonceService annonceService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Annonce> listAnnonce() throws ServiceException {
		List<Annonce> annonces = annonceService.findAll();
		return annonces;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Annonce findOne(@PathVariable("id") Integer id)
			throws ServiceException {
		return annonceService.getAnnonceById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public  @ResponseBody void create(@RequestBody Annonce annonce)
			throws ServiceException {
		
		annonceService.save(annonce);
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void update(@PathVariable("id") Integer id, Annonce annonce)
			throws ServiceException {
		annonce.setId(id);
		annonceService.save(annonce);
	}
}
