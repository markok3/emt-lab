package com.example.demo.models;

import lombok.Data;

@Data
public class BookDto {

        private String name;

        private Long author;

        private String category;

        private Integer quantity;

        public BookDto() {
        }

        public BookDto(String name, Long author, String category, Integer quantity) {
            this.name = name;
            this.author = author;
            this.category = category;
            this.quantity = quantity;
        }
}
