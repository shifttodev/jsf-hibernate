package io.shifttodev.jsfhibernate.dao;


import io.shifttodev.jsfhibernate.model.Livro;

import java.util.List;

public interface ILivroDAO {

    public boolean inserir(Livro livro);
    public boolean deletar(String isbn);

    public List<Livro> listar();

    public Livro buscarPorISBN(String isbn);

    public boolean atualizar(Livro livro);
}
