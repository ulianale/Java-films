package ru.netology.films;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit = 10; // лимит по умолчанию

    public MovieManager(int limit) {
        if (limit > 0) {              // если limit <=0, то лимит будет по умолчанию
            this.limit = limit;
        }
    }

    public MovieManager() {
    }

    public void addMovie(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
           tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {

        int newLimit;

        if (movies.length < limit) { // это условие исключает ошибку, если количество добавленных фильмов меньше лимита
            newLimit = movies.length;
        } else {
            newLimit = limit;
        }
        Movie[] reversed = new Movie[newLimit];
        for (int i = 0; i < newLimit; i++) {
            reversed[i] = movies[movies.length - 1 - i];
        }
        return reversed;
    }

}
