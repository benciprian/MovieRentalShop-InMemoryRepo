package Repository;

import Domain.Movie;

public interface MovieRepository {

        /**
         * Find the entity with the given {@code id}.
         *
         * @param id must be not null.
         * @return a {@code Movie}  with the given id.
         * @throws IllegalArgumentException if the given id is null.
         */
        Movie findOne(Long id);

        /**
         * @return all entities.
         */
        Iterable<Movie> findAll();

        /**
         * Saves the given entity.
         *
         * @param entity must not be null.
         * @return a {@code Movie} - null if the entity was saved otherwise (e.g. id already exists) returns the entity.
         * @throws IllegalArgumentException if the given entity is null.
         */
        Movie save(Movie entity);

        /**
         * Removes the entity with the given id.
         *
         * @param id must not be null.
         * @return a {@code Movie} - null if there is no entity with the given id, otherwise the removed entity.
         * @throws IllegalArgumentException if the given id is null.
         */
        Movie delete(Long id);

        /**
         * Updates the given entity.
         *
         * @param entity must not be null.
         * @return a {@code Movie} - null if the entity was updated otherwise (e.g. id does not exist) returns the
         * entity.
         * @throws IllegalArgumentException if the given entity is null.
         */
        Movie update(Movie entity);
}
