package service;

import model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<ID>,ID>{

    E save (E e);

    void deleteById(ID id);

    Optional<E> findById(ID id);

    Optional<E> findByUsername(String username);

    List<E> findALL();

    List<E> findByName(String name);

    void create (E e);

    E update (E e);


}
