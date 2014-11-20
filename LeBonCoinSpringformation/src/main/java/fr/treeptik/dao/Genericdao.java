package fr.treeptik.dao;

import java.util.List;

public interface Genericdao<T, PK> {
	T create(T type);
	T findById(PK id);
	List<T> findAll(Class entityClass);
	T update(T type);
	void delete(T type);

}
