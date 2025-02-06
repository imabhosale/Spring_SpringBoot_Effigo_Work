package com.abhi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abhi.dto.ManagerDTO;
import com.abhi.exception.ManagerNotFoundException;
import com.abhi.model.Manager;
import com.abhi.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ManagerDTO addManager(ManagerDTO managerDTO) {
		Manager manager = modelMapper.map(managerDTO, Manager.class);
		Manager savedManager = managerRepository.save(manager);
		return modelMapper.map(savedManager, ManagerDTO.class);
	}

	public ManagerDTO getManagerById(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		return manager.map(m -> modelMapper.map(m, ManagerDTO.class)).orElse(null);
	}


	public ManagerDTO getManagerWithEmployees(Long managerId) {
		Optional<Manager> managerOpt = managerRepository.findById(managerId);

		if (managerOpt.isPresent()) {
			Manager manager = managerOpt.get();

			ManagerDTO managerDTO = modelMapper.map(manager, ManagerDTO.class);

			return managerDTO;
		} else {
			
			String errorMessage = "Error: Manager with ID " + managerId + " not found.";
            System.err.println(errorMessage);
			throw new ManagerNotFoundException("Manager with ID " + managerId + " not found");
		}
	}

	public List<ManagerDTO> getAllManagers() {
		List<Manager> managers = managerRepository.findAll();
		return managers.stream().map(manager -> modelMapper.map(manager, ManagerDTO.class))
				.collect(Collectors.toList());
	}
}
