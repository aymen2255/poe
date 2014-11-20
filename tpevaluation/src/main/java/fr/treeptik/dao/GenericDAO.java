package fr.treeptik.dao;

import java.util.List;

public interface GenericDAO <T, PK> {
	void create(T obj);
	T update(T obj);
	void delete(T obj);
	T find(PK id);
	List<T> list();
}
