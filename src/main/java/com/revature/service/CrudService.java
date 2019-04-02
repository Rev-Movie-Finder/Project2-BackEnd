package com.revature.service;

import java.util.List;

public interface CrudService<T> {
	
	public List<T> getAll();
	public T getById(int id);
	public T create(T obj);
	public T update(T obj);
	public int deleteById(int id);

}
