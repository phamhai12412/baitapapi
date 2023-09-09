package ra.session5_spring_jpa.service;

import ra.session5_spring_jpa.dto.requestDto.AuthorRequestDto;
import ra.session5_spring_jpa.dto.responseDto.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    AuthorResponseDto getAuthor(Long id);
    List<AuthorResponseDto> getAuthors();
    AuthorResponseDto deleteAuthor(Long id);
    AuthorResponseDto editAuthor(Long id, AuthorRequestDto authorRequestDto);
    AuthorResponseDto addZipcode(Long authorId, Long zipcodeId);
    AuthorResponseDto removeZipcode(Long id);
}
