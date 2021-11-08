package service;

import lombok.SneakyThrows;
import model.BaseEntity;
import repository.CrudRepository;
import repository.RepositoryFactory;

import java.util.List;
import java.util.Optional;

public class CrudServiceImpl<T extends BaseEntity<ID>, ID> implements BaseService<T, ID> {

    CrudRepository crudRepository;

    @Override
    public void create(T t) {
        crudRepository.create(t);
    }

    @Override
    public T update(T t) {
        return (T) crudRepository.update(t);
    }

    @SneakyThrows
    public CrudServiceImpl(Class<T> modelClass){
        this.crudRepository = RepositoryFactory.of(modelClass);
    }

    @Override
    public List<T> findALL(){
        return crudRepository.findALL();
    }

    @Override
    public List<T> findByName(String name) {
        return crudRepository.findByName(name);
    }

    @Override
    public T save(T t) {
        return (T) crudRepository.save(t);
    }

    @Override
    public void deleteById(ID id){
        crudRepository.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return crudRepository.findById(id);
    }



}
