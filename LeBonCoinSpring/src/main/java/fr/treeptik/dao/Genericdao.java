package fr.treeptik.dao;

import java.util.List;

public interface Genericdao<T, PK> {
	public T create(T type);
	public T findById(PK id);
	public List<T> findAll();
	public T update(T type);
	public void delete(T type);

}
