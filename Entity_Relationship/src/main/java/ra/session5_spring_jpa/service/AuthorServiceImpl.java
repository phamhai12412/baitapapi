package ra.session5_spring_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session5_spring_jpa.dto.requestDto.AuthorRequestDto;
import ra.session5_spring_jpa.dto.requestDto.ZipcodeRequestDto;
import ra.session5_spring_jpa.dto.responseDto.AuthorResponseDto;
import ra.session5_spring_jpa.model.Author;
import ra.session5_spring_jpa.model.Book;
import ra.session5_spring_jpa.model.Zipcode;
import ra.session5_spring_jpa.repository.AuthorRepository;
import ra.session5_spring_jpa.repository.ZipcodeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ZipcodeRepository zipcodeRepository;

    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());

        Optional<Zipcode> optionalZipcode = zipcodeRepository.findById(authorRequestDto.getZipcodeId());
        if (optionalZipcode.isPresent()) {
            author.setZipcode(optionalZipcode.get());
        } else {
          author.setZipcode(null);
        }

        author = authorRepository.save(author);
        return convertToDto(author);
    }


    @Override
    public AuthorResponseDto getAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            return convertToDto(author);
        }
        return null;
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(author -> convertToDto(author))
                .collect(Collectors.toList());

    }

    @Override
    public AuthorResponseDto deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorRepository.delete(author);
            return convertToDto(author);
        }
        return null;
    }

    @Override
    public AuthorResponseDto editAuthor(Long id, AuthorRequestDto authorRequestDto) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorRequestDto.getName());


            if (authorRequestDto.getZipcodeId() != null) {
                Optional<Zipcode> optionalZipcode = zipcodeRepository.findById(authorRequestDto.getZipcodeId());
                if (optionalZipcode.isPresent()) {
                    author.setZipcode(optionalZipcode.get());
                } else {
                    author.setZipcode(null);
                }
            }

            author = authorRepository.save(author);
            return convertToDto(author);
        }
        return null;
    }

    @Override
    public AuthorResponseDto addZipcode(Long authorId, Long zipcodeId) {

        Author author = authorRepository.findById(authorId).orElse(null);


        Zipcode zipcode = zipcodeRepository.findById(zipcodeId).orElse(null);

        if (author != null && zipcode != null) {

            author.setZipcode(zipcode);

            author = authorRepository.save(author);

            return convertToDto(author);
        }

       return null;
    }

    @Override
    public AuthorResponseDto removeZipcode(Long id) {

        Author author = authorRepository.findById(id).orElse(null);

        if (author != null) {

            author.setZipcode(null);


            author = authorRepository.save(author);

            return convertToDto(author);
        }

  return null;
    }

    private AuthorResponseDto convertToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setName(author.getName());


        List<String> bookNames = author.getBooks()
                .stream()
                .map(Book::getName)
                .collect(Collectors.toList());
        dto.setBookNames(bookNames);


        if (author.getZipcode() != null) {
            dto.setZipcodeName(author.getZipcode().getName());
        }

        return dto;
    }


}
