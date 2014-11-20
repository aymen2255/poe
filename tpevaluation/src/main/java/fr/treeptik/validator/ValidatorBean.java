package fr.treeptik.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidatorBean implements Validator{
	private static final String EMAIL_REGEXP =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
 
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException
    {
        String email = (String) val;
        Pattern mask = null;
        mask = Pattern.compile(EMAIL_REGEXP);
        Matcher matcher = mask.matcher(email);
 
        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Entrer une adresse mail valide");
            message.setSummary("Email non valide");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
 
 
    }
 
}
