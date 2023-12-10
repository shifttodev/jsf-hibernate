package io.shifttodev.jsfhibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "livro")
@SuppressWarnings("serial")
public class Livro {
    @Id
    private Integer id;
    @NonNull
    @Column
    private String isbn;
    @NonNull
    @Column
    private String titulo;
    @NonNull
    @Column
    private String autor;
    @NonNull
    @Column
    private Integer ano;

    @Override
    public String toString(){
        return String.format(
                "%03d %13s %-30s %-30s %d",
                this.id, this.isbn, this.titulo, this.autor, this.ano
        );
    }

    public String action(){
        boolean success = true;

        FacesContext context = FacesContext.getCurrentInstance();

        if (isbn != null){
            for (int i = 0; i < isbn.length(); i++){
                char c = isbn.charAt(i);
                if (Character.isLetter(c)){
                    String msg = "Digite somente caracteres númericos!";
                    FacesMessage message = new FacesMessage(msg);
                    context.addMessage("form", message);
                    success = false;
                    break;
                }
            }
        } else {
            success = false;
        }

        return (success ? "success" : "fail");
    }
}
