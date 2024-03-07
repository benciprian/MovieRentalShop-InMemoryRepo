package Repository;

import Domain.Client;

public interface ClientRepository {

    /**
     * Find the entity with the given {@code id}.
     *
     * @param id must be not null.
     * @return a {@code Student}  with the given id.
     * @throws IllegalArgumentException if the given id is null.
     */
    Client findOne(Long id);

    /**
     * @return all entities.
     */
    Iterable<Client> findAll();

    /**
     * Saves the given entity.
     *
     * @param entity must not be null.
     * @return a {@code Student} - null if the entity was saved otherwise (e.g. id already exists) returns the entity.
     * @throws IllegalArgumentException if the given entity is null.
     */
    Client save(Client entity);

    /**
     * Removes the entity with the given id.
     *
     * @param id must not be null.
     * @return a {@code Student} - null if there is no entity with the given id, otherwise the removed entity.
     * @throws IllegalArgumentException if the given id is null.
     */
    Client delete(Long id);

    /**
     * Updates the given entity.
     *
     * @param entity must not be null.
     * @return a {@code Student} - null if the entity was updated otherwise (e.g. id does not exist) returns the
     * entity.
     * @throws IllegalArgumentException if the given entity is null.
     */
    Client update(Client entity);
}




