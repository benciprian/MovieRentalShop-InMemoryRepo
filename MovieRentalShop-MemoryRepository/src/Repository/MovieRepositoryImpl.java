package Repository;

import Domain.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieRepositoryImpl implements MovieRepository{
    private Map<Long, Movie> entities;
    public MovieRepositoryImpl() {
        this.entities = new HashMap<>();
    }

    @Override
    public Movie findOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        return entities.get(id);
    }

    @Override
    public Iterable<Movie> findAll() {
        Set<Movie> movies = entities.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
        return movies;
    }

    @Override
    public Movie save(Movie entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        return entities.putIfAbsent(entity.getId(), entity);
    }

    @Override
    public Movie delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        return entities.remove(id);

    }

    @Override
    public Movie update(Movie entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }

        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
            return entity;
        }

        return null; // Return null if the entity does not exist in the repository.
    }
}
