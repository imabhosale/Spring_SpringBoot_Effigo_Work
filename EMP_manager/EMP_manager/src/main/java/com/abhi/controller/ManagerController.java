package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.dto.ManagerDTO;
import com.abhi.service.ManagerService;

@RestController

@RequestMapping("/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@PostMapping("/add")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ManagerDTO addManager(@RequestBody ManagerDTO managerDTO) {
		return managerService.addManager(managerDTO);
	}

	@GetMapping()
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public List<ManagerDTO> getAllManagers(Authentication authentication) {
		if (authentication != null) {
			System.out.println("Authenticated user: " + authentication.getName());
			System.out.println("Authorities: " + authentication.getAuthorities());
		}

		return managerService.getAllManagers();
	}

	@GetMapping("/{managerId}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ManagerDTO getManagerWithId(@PathVariable Long managerId) {
		return managerService.getManagerWithEmployees(managerId);
	}
}
