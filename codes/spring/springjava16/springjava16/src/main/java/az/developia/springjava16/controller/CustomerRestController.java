package az.developia.springjava16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.repository.CustomerRepository;
import az.developia.springjava16.response.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerRestController {

	private final CustomerRepository repository;

	@GetMapping(path = "/{id}")

	public CustomerResponseDTO findById(@PathVariable Long id) {
		CustomerResponseDTO resp = new CustomerResponseDTO();
		resp.setCustomer(repository.findById(id).get());
		return resp;

	}

}
