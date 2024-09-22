package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.request.AddUserBooksRequestDTO;
import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.dto.response.UserBooksResponseDTO;
import az.developia.springjava16.service.interfaces.AuthorityService;
import az.developia.springjava16.service.interfaces.UserBooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/userBooks")
@RequiredArgsConstructor
public class UserBookRestController {
    @Autowired
    private final UserBooksService service;

    @PostMapping()
    @PreAuthorize(value = "hasAuthority('ROLE_ADD_USER_BOOKS')")
    public GeneralResponse<String> updateBook(@RequestBody AddUserBooksRequestDTO req) {
     String username = SecurityContextHolder.getContext().getAuthentication().getName();
        GeneralResponse<String> gr = new GeneralResponse();
        gr.setData(service.addUserBooks(req.getEmail(),req.getBookId()));
        return gr;
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ROLE_DELETE_USER_BOOKS')")
    public GeneralResponse<String> updateBook(@PathVariable Long id) {
        GeneralResponse<String> gr = new GeneralResponse();
        gr.setData(service.deleteUserBooks(id));
        return gr;
    }
    @GetMapping()
    @PreAuthorize(value = "hasAuthority('ROLE_GET_USER_BOOKS')")
    public GeneralResponse<List<UserBooksResponseDTO>> updateBook(@RequestParam String email) {
        GeneralResponse<List<UserBooksResponseDTO>> gr = new GeneralResponse();
        gr.setData(service.getUserBooks(email));
        return gr;
    }

}
