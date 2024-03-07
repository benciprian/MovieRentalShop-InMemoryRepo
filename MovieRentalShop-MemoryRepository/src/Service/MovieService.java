package Service;

import Domain.Movie;
import Repository.MovieRepository;

import java.util.HashSet;
import java.util.Set;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovieRental(Movie movie) {
        movieRepository.save(movie);
    }

    public Set<Movie> getAllMovies() {
        Set<Movie> movies = new HashSet<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
    public Movie removeMovie(Long id) {
        return movieRepository.delete(id);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findOne(id);
    }
    public Movie updateMovie(Movie entity) {
        return movieRepository.update(entity);
    }


}
