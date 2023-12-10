package io.shifttodev.jsfhibernate.dao;


import io.shifttodev.jsfhibernate.model.Livro;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements ILivroDAO{

    private Session session;

    @Override
    public boolean inserir(Livro livro) {
        session = ConnectionFactoryHBN.getInstance();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(livro);
            transaction.commit();
        } catch (HibernateException e){
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return true;
    }

    @Override
    public boolean deletar(String isbn) {
        session = ConnectionFactoryHBN.getInstance();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query =  session.createSQLQuery("DELETE FROM Livro livro WHERE livro.isbn = ?");
            query.setParameter(0, isbn);
            query.executeUpdate();
//            Livro livro = (Livro) query.uniqueResult();
//            session.delete(livro);
            transaction.commit();
        } catch (HibernateException e){
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public List<Livro> listar() {
        session = ConnectionFactoryHBN.getInstance();
        List<Livro> livros = session.createQuery("from io.shifttodev.jsfhibernate.model.Livro livro").list();
        return livros;
    }

    @Override
    public Livro buscarPorISBN(String isbn) {
        return null;
    }

    @Override
    public boolean atualizar(Livro livro) {
        session = ConnectionFactoryHBN.getInstance();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(livro);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return false;
    }
}
