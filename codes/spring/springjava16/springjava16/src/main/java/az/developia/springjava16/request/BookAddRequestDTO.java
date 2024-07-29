package az.developia.springjava16.request;

import lombok.Data;

@Data
public class BookAddRequestDTO {

	private String name;

	private Double price;

	private Integer pageCount;

	private String author;
}
