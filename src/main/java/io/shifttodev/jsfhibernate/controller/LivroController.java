package io.shifttodev.jsfhibernate.controller;

import io.shifttodev.jsfhibernate.model.Livro;
import io.shifttodev.jsfhibernate.service.LivroService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LivroController {

    @Setter
    @Getter
    private Livro livro;
    private DataModel<Livro> model;

    public String novo(){
        this.livro = new Livro();
        return "novo";
    }

    public DataModel<Livro> getLivros(){

        LivroService service = new LivroService();
        model = new ListDataModel<>(service.listarTodos());
        return model;
    }

    public Livro getLivroFromEditOrDelete(){
        Livro livro = model.getRowData();
        return livro;
    }

    public String editar(){
        Livro livro = getLivroFromEditOrDelete();
        setLivro(livro);
        return "editar";
    }

    public String atualizar(){
        LivroService service = new LivroService();
        service.atualizar(this.livro);
        return "atualizado";
    }

    public String deletar(){
        LivroService service = new LivroService();
        Livro livro  =  getLivroFromEditOrDelete();
        service.deletar(livro.getIsbn());

        return "deletado";
    }

    public String inserir(){
        LivroService service = new LivroService();
        service.inserir(this.livro);

        return "inserido";
    }

    public void validarAno(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String isbn = (String) o.toString();
        Pattern pattern = Pattern.compile("20[01][0-9]");
        Matcher matcher = pattern.matcher(isbn);
        boolean match = matcher.matches();

        if (!match) {
            ((UIInput) uiComponent).setValid(false);
            FacesMessage message = new FacesMessage("Ano Inválido");
            facesContext.addMessage(uiComponent.getClientId(facesContext), message);
        }
    }

}
