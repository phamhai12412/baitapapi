package ra.session5_spring_jpa.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private String name;
    private List<Long> authorIds;
    private Long categoryId;
}
