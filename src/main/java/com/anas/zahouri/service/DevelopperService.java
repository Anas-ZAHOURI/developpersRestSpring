package com.anas.zahouri.service;


import com.anas.zahouri.model.Developper;

import java.util.List;

public interface DevelopperService {
	
	Developper findById(Long id);

	void saveDevelopper(Developper developper);

	void updateDevelopper(Developper developper);

	void deleteDevelopperById(Long id);

	void deleteAllDeveloppers();

	List<Developper> findAllDeveloppers();

	boolean isDevelopperExist(Developper developper);
}