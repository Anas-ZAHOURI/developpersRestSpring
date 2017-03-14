package com.anas.zahouri.service;

import java.util.List;

import com.anas.zahouri.model.Developper;
import com.anas.zahouri.repositories.DevelopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("DevelopperService")
@Transactional
public class DevelopperServiceImpl implements DevelopperService {

	@Autowired
	private DevelopperRepository DevelopperRepository;

	public Developper findById(Long id) {
		return DevelopperRepository.findById(id);
	}

	public void saveDevelopper(Developper developper) {
		DevelopperRepository.save(developper);
	}

	public void updateDevelopper(Developper developper){
		saveDevelopper(developper);
	}

	public void deleteDevelopperById(Long id){
		DevelopperRepository.delete(id);
	}

	public void deleteAllDeveloppers(){
		DevelopperRepository.deleteAll();
	}

	public List<Developper> findAllDeveloppers(){
		return DevelopperRepository.findAll();
	}

	public boolean isDevelopperExist(Developper developper) {
		return findById(developper.getId()) != null;
	}
}
