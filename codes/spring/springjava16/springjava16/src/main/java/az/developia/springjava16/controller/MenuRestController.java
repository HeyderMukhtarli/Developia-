package az.developia.springjava16.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.entity.MenuEntity;
import az.developia.springjava16.repository.MenuRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuRestController {

	private final MenuRepository repository;

	@GetMapping

	public List<MenuEntity> find(@RequestHeader(name = "Accept-language") Locale l) {
		String language = l.getLanguage();

		return repository.findAllByLang(language);
	}

}
