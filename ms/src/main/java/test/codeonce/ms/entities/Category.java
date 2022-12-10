package test.codeonce.ms.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Category implements java.io.Serializable {
  @Id
  private String id;
  private String name;

  @JsonIgnore
  @DBRef
  private List<Product> products;

  public Category(String id, String name) {
    this.id = id;
    this.name = name;
    products = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Cat{ id= " + id + "  name= " + name + "}";
  }

}