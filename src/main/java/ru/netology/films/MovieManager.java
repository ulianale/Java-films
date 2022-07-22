 package ru.netology.films;

 public class MovieManager {
    private MovieRepository repo;
    private int limit = 10;       // лимит по умолчанию

    public MovieManager(MovieRepository repo) {
        this.repo = repo;
    }


    public MovieManager(MovieRepository repo, int limit) {
        this.repo = repo;
        if (limit > 0) {              // если limit <=0, то лимит будет по умолчанию
            this.limit = limit;
        }
    }

    public void addMovie(Movie movie) {
        repo.saveMovie(movie);

    }

    public Movie[] findAll() {
        return repo.findAll();
    }

    public Movie[] findLast() {
        Movie[] all = repo.findAll();

        if (all.length < limit) { // это условие исключает ошибку, если количество добавленных фильмов меньше лимита
            limit = all.length;
        }
        Movie[] reversed = new Movie[limit];
        for (int i = 0; i < limit; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

}
