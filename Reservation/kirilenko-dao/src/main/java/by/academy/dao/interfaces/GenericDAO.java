package by.academy.dao.interfaces;

import java.util.List;

public interface GenericDAO<T> {
	T findById(int id);
	List<T> findAll();
	void insert(T object);
	void update(T object);
	void delete(int id);
	
}
