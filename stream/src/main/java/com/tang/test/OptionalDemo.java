package com.tang.test;

import com.tang.entity.Author;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
    }
    public static Optional<Author> getAuthorOptional(){
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        return Optional.ofNullable(author);
    }
}
