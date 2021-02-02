package com.ubb.pcis2083.soa.common.dao;

import java.util.List;

public interface Dao<ID, E> {
    List<E> getAll();

    ID save(E entity);

    void delete(E entity);

    void update(E entity);

    E findById(ID id);

    void deleteById(ID id);
}
