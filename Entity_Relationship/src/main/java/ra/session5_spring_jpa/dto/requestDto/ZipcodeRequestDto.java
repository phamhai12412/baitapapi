package ra.session5_spring_jpa.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZipcodeRequestDto {
    private String name;
    private Long cityId;
}
