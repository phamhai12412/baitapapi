package ra.session5_spring_jpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "category")
   private List<Book> books = new ArrayList<>();

}
