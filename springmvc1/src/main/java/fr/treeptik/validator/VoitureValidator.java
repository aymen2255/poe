package fr.treeptik.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.model.Voiture;

public class VoitureValidator implements Validator{

	@Override
	public boolean supports(Class<?> o) {
		
		return (o.getName().equals(Voiture.class.getName()))? true : false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Voiture v = (Voiture) obj;
		if(v.getMarque().equalsIgnoreCase(v.getModel())){
			errors.rejectValue("marque", "error.marqueEqualsModel");
			errors.rejectValue("model", "error.modelEqualsMarque");
		}
		
	}

}
