package ra.session5_spring_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session5_spring_jpa.dto.requestDto.AuthorRequestDto;
import ra.session5_spring_jpa.dto.responseDto.AuthorResponseDto;
import ra.session5_spring_jpa.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto responseDto = authorService.addAuthor(authorRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable Long id) {
        AuthorResponseDto responseDto = authorService.getAuthor(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        List<AuthorResponseDto> responseDtos = authorService.getAuthors();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable Long id) {
        AuthorResponseDto responseDto = authorService.deleteAuthor(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable Long id,
                                                        @RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto responseDto = authorService.editAuthor(id, authorRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
    private ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable Long zipcodeId,
                                                        @PathVariable Long authorId) {
        AuthorResponseDto responseDto = authorService.addZipcode(authorId, zipcodeId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/removeZipcode/{id}")
    private ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable Long id) {
        AuthorResponseDto responseDto = authorService.removeZipcode(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
