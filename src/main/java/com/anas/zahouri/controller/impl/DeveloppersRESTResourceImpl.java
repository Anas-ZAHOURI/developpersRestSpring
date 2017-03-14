package com.anas.zahouri.controller.impl;

import java.util.List;

import com.anas.zahouri.controller.DeveloppersRESTResource;
import com.anas.zahouri.model.Developper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anas.zahouri.service.DevelopperService;
import org.springframework.stereotype.Service;


@Service
public class DeveloppersRESTResourceImpl implements DeveloppersRESTResource{

	public static final String VERSION = "0.01";
	public static final Logger logger = LoggerFactory.getLogger(DeveloppersRESTResourceImpl.class);

	@Autowired
	DevelopperService developperService; //Service which will do all data retrieval/manipulation work

	/**
	 * Retrieve All developpers
	 * @return
	 */
	@Override
	public List<Developper> listAllDeveloppers() {
		List<Developper> developpers = developperService.findAllDeveloppers();
		return developpers;
	}

	/**
	 * Retrieve Single Developper
	 * @param id
	 * @return
	 */
	@Override
	public Developper getDevelopper(long id) {
		logger.info("Fetching Developper with id {}", id);
		Developper developper = developperService.findById(id);
		return developper;
	}

	/**
	 * Create a Developper
	 * @param developper
	 * @return
	 */
	@Override
	public Developper createDevelopper(Developper developper) {
		logger.info("Creating Developper : {}", developper);

		if (developperService.isDevelopperExist(developper)) {
			logger.error("Unable to create developper with name {} already exist", developper.getName());
			throw new IllegalArgumentException("Unable to create Developper with id " + developper.getId() + " already exist");
		}
		developperService.saveDevelopper(developper);

		return developper;
	}

	/**
	 * Update a Developper
	 * @param developper
	 * @return
	 */
	@Override
	public Developper updateDevelopper(Developper developper) {
		long id = developper.getId();
		logger.info("Updating Developper with id {}", id);

		Developper currentDevelopper = developperService.findById(id);

		if (currentDevelopper == null) {
			logger.error("Unable to update developper with id {} not found.", id);
			throw new IllegalArgumentException("Unable to upate developper with id " + id + " not found.");
		}

		currentDevelopper.setName(developper.getName());
		currentDevelopper.setLastName(developper.getLastName());
		currentDevelopper.setSalary(developper.getSalary());

		developperService.updateDevelopper(currentDevelopper);
		return currentDevelopper;
	}

	/**
	 * Delete a Developper
	 * @param id
	 */
	@Override
	public void deleteDevelopper(long id) {
		logger.info("Fetching & Deleting Developper with id {}", id);

		Developper developper = developperService.findById(id);
		if (developper == null) {
			logger.error("Unable to delete developper with id {} not found.", id);
			throw new IllegalArgumentException("Unable to delete developper with id " + id + " not found.");
		}
		developperService.deleteDevelopperById(id);
	}

	/**
	 * Delete All developpers
	 */
	@Override
	public void deleteAllDeveloppers() {
		logger.info("Deleting All developpers");

		developperService.deleteAllDeveloppers();
	}

	@Override
	public String getVersion() {
		return DeveloppersRESTResourceImpl.VERSION;
	}

}