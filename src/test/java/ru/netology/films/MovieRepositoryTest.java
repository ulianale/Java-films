package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieRepositoryTest {

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
    public void test1() {
        MovieRepository repo = new MovieRepository();

        repo.saveMovie(movie1);
        repo.removeAll();
        repo.saveMovie(movie2);
        repo.saveMovie(movie5);
        repo.removeById(movie1.getId());
        repo.saveMovie(movie7);
        repo.removeById(movie5.getId());
        repo.removeById(movie8.getId());

        Movie[] expected = {movie2, movie7};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {  // проверка на удаление элемента из пустого массива
        MovieRepository repo = new MovieRepository();

        repo.removeById(movie5.getId());

        Movie[] expected = {};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() { // проверка возвращения объекта по id
        MovieRepository repo = new MovieRepository();

        repo.saveMovie(movie1);
        repo.saveMovie(movie2);
        repo.saveMovie(movie5);
        repo.removeById(movie1.getId());
        repo.saveMovie(movie7);

        Assertions.assertEquals(movie5, repo.findById(movie5.getId()));
        Assertions.assertNull(repo.findById(movie1.getId()));
        Assertions.assertNull(repo.findById(movie8.getId()));
    }

}
