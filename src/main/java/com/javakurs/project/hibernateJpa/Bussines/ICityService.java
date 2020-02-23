package com.javakurs.project.hibernateJpa.Bussines;

import java.util.List;

import com.javakurs.project.hibernateJpa.Entities.City;

public interface ICityService {

	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete (City city);
	City getByID(int id);
}
