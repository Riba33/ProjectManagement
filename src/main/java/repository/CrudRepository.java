package repository;

import model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E extends BaseEntity<ID>,ID> {

    List<E> saveAll(Iterable<E> itrb);

    E save (E e);

    List<E> findByName(String name);

    void create (E e);

    E update (E e);

    void deleteById(ID id);

    Optional<E> findById(ID id);

    List<E> findALL();

    void close();

}
