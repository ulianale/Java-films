package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    Movie movie1 = new Movie(1, "Бладшот");
    Movie movie2 = new Movie(2, "Вперед");
    Movie movie3 = new Movie(3, "Джентельмены");
    Movie movie4 = new Movie(4, "Человек-невидимка");
    Movie movie5 = new Movie(5, "Отель");
    Movie movie6 = new Movie(6, "Шестое чувство");
    Movie movie7 = new Movie(7, "Зеленая книга");
    Movie movie8 = new Movie(8, "Мирный воин");
    Movie movie9 = new Movie(9, "Человек-слон");
    Movie movie10 = new Movie(10, "13");
    Movie movie11 = new Movie(11, "Револьвер");


    @Test
    public void shouldFindAll() {
        MovieManager mov = new MovieManager();

        mov.addMovie(movie6);
        mov.addMovie(movie2);
        mov.addMovie(movie1);

        Movie[] expected = {movie6, movie2, movie1};
        Movie[] actual = mov.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast1() { // проверка лимита по умолчанию, когда фильмов в списке больше или равно лимиту
        MovieManager mov = new MovieManager();

        mov.addMovie(movie1);
        mov.addMovie(movie2);
        mov.addMovie(movie3);
        mov.addMovie(movie4);
        mov.addMovie(movie5);
        mov.addMovie(movie6);
        mov.addMovie(movie7);
        mov.addMovie(movie8);
        mov.addMovie(movie9);
        mov.addMovie(movie10);
        mov.addMovie(movie11);

        Movie[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = mov.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast2() { // проверка лимита по умолчанию, когда добавленных фильмов  меньше чем лимит
        MovieManager mov = new MovieManager();

        mov.addMovie(movie1);
        mov.addMovie(movie2);
        mov.addMovie(movie3);
        mov.addMovie(movie4);
        mov.addMovie(movie5);

        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = mov.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastNewLimit1() {
        MovieManager mov = new MovieManager(2);

        mov.addMovie(movie1);
        mov.addMovie(movie2);
        mov.addMovie(movie3);
        mov.addMovie(movie4);
        mov.addMovie(movie5);

        Movie[] expected = {movie5, movie4};
        Movie[] actual = mov.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
