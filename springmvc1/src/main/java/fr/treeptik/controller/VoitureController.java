package fr.treeptik.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.model.Voiture;
import fr.treeptik.validator.VoitureValidator;

@Controller
@RequestMapping("/voiture")
public class VoitureController {
	@RequestMapping("/edit.do")
	public ModelAndView intiSaveForm() {
		System.out.println("hello");
		Voiture v = new Voiture(null, "eeee", "ddd");
		return new ModelAndView("edit.jsp", "voiture", v);
	}

	private List<Voiture> voitures = new ArrayList<Voiture>();
	

	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public ModelAndView save(@Valid Voiture voiture, BindingResult bindingResult) {

		VoitureValidator validator = new VoitureValidator();
		validator.validate(voiture, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("edit.jsp", "voiture", voiture);
		}
//		Voiture v1 = new Voiture(1, "aaa", "aaa");
//		voitures.add(v1);
		voitures.add(voiture);

		ModelAndView model = new ModelAndView("list.jsp");
		model.addObject("voitures", voitures);
		return model;
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {
Voiture v = new Voiture();
v.setId(id);
		voitures.remove(v);

		ModelAndView model = new ModelAndView("list.jsp");
		model.addObject("voitures", voitures);
		return model;
	}

}
