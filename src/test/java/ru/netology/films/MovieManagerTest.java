package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MovieManagerTest {

    MovieRepository repo = Mockito.mock(MovieRepository.class);

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
        MovieManager manager = new MovieManager(repo);
        Movie[] movies = {movie6, movie2, movie1};
        doReturn(movies).when(repo).findAll();

        Movie[] expected = {movie6, movie2, movie1};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast1() { // проверка лимита по умолчанию, когда фильмов в списке больше или равно лимиту

        MovieManager manager = new MovieManager(repo);
        Movie[] movies = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(movies).when(repo).findAll();

        Movie[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    @Test
    public void shouldFindLast2() { // проверка лимита по умолчанию, когда добавленных фильмов  меньше чем лимит//

        MovieManager manager = new MovieManager(repo);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);

        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastNewLimit1() {

        MovieManager manager = new MovieManager(repo, 2);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);

        Movie[] expected = {movie5, movie4};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

     **/

    @Test
    public void shouldFindLastNewLimit2() {

        MovieManager manager = new MovieManager(repo, -1);
        Movie[] movies = {movie1};
        doReturn(movies).when(repo).findAll();

        //manager.addMovie(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}

