package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface AllDao<E extends BaseEntity> {
    void create(E e);
    void update(E e);
    void delete(String id);
    E findById(String id);
    List<E> findAll();
    void link(String ownerId, String petId);
    void unlink(String ownerId, String petId);
}
