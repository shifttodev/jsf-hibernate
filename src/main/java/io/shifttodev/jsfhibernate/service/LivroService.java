package io.shifttodev.jsfhibernate.service;


import io.shifttodev.jsfhibernate.dao.ILivroDAO;
import io.shifttodev.jsfhibernate.dao.LivroDAO;
import io.shifttodev.jsfhibernate.model.Livro;

import java.util.List;

public class LivroService {
    ILivroDAO dao = null;

    public LivroService(){}

    public boolean inserir(Livro livro){
        try{
            dao = new LivroDAO();
            return dao.inserir(livro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarTodos(){
        List<Livro> livros;

        try{
            dao = new LivroDAO();
            livros = dao.listar();

        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return livros;
    }

    public boolean deletar(String isbn) {
        try{
            dao = new LivroDAO();
            return dao.deletar(isbn);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorISBN(String isbn){
        Livro livro = null;
        try{
            dao = new LivroDAO();
            livro = dao.buscarPorISBN(isbn);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return livro;
    }

    public boolean atualizar(Livro livro){
        try{
            dao = new LivroDAO();
            return dao.atualizar(livro);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
