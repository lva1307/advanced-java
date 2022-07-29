package com.caveofprogramming.db;

import java.util.Optional;

public interface Dao <T>{
	void save (T t);
	Optional <T> findBy (int Id);
	void update (T t);
	void delete (T t);
	

}
