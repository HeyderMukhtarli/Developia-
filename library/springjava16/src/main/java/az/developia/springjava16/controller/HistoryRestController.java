package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.request.UserAddRequestDTO;
import az.developia.springjava16.dto.response.HistoryResponseDTO;
import az.developia.springjava16.dto.response.LoginResponseDTO;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.service.HistoryServiceImpl;
import az.developia.springjava16.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryRestController {
 private final HistoryServiceImpl historyService;
	@GetMapping
	private GeneralResponse<List<HistoryResponseDTO>> getHistory(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		GeneralResponse<List<HistoryResponseDTO>> gr=new GeneralResponse<>();
		gr.setData(historyService.getHistories(username));
		return gr;
	}

}
