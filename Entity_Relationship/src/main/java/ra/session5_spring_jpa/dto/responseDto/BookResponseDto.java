package ra.session5_spring_jpa.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String name;
    private List<String> authorNames;
    private String categoryName;
}
