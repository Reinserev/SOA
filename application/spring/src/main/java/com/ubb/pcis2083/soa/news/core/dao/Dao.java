package com.ubb.pcis2083.soa.news.core.dao;


import java.util.List;

public interface Dao<ID,E> {
    List<E> getAll();
    ID save(E entity);
    boolean delete(E entity);
    boolean update(E entity);
    E findById (ID id);
    boolean deleteById(ID id);
}
