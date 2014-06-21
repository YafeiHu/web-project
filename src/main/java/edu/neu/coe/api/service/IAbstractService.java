package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.City;

	public interface IAbstractService<E, I extends Serializable> {
	    public void create(E e);
		public E find(I id);
		public void update(E e);
		public void delete(I id);
		public List<E> getAll();
}
