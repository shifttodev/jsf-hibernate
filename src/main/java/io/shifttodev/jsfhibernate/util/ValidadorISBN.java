package io.shifttodev.jsfhibernate.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorISBN implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String isbn = (String) o;
        Pattern pattern = Pattern.compile("\\d{13}");
        Matcher matcher = pattern.matcher(isbn);
        boolean match = matcher.matches();

        if (!match) {
            FacesMessage message = new FacesMessage();
            message.setDetail("ISBN Inválido");
            message.setSummary("ISBN Inválido");

            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
