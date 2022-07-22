package ru.netology.films;

public class MovieRepository {
    private Movie[] movies = new Movie[0];


    public void saveMovie(Movie movie) {
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


    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length]; // при отсутствии объекта ничего не удаляется, тогда размер массива не должен уменьшаться на единицу
        if (movies.length <= 0) {   // условие, чтобы не было ошибки, если массив пустой
            return;
        }
        int copyToIndex = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }
        }
        movies = tmp;
        if (movies[movies.length - 1] == null) { // если объект был удален, последний элемент в массиве будет = null
            Movie[] tmp2 = new Movie[movies.length - 1];  // создала новый массив для удаления последнего элемента null
            for (int i = 0; i < (movies.length-1); i++) {
                tmp2[i] = movies[i];
            }
            movies = tmp2;
        }
    }


    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }


    public void removeAll() {
        movies = new Movie[0];
    }

}
