package me.ialext.poto.cache.data;

import me.ialext.poto.cache.model.SavableModel;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Represents a persistent object repository,
 * such as a database, file, and so on.
 *
 * @param <O> The model type to be persistently stored.
 */
public interface ObjectRepository<O extends SavableModel> {

  /**
   * @see #findOneSync(String).
   */
  default CompletableFuture<Optional<O>> findOne(String id) {
    return supplyAsync(() -> findOneSync(id));
  }

  /**
   * Searches for an {@link O} stored
   * in this {@link ObjectRepository}.
   *
   * @param id The {@link O}'s id.
   * @return An optional {@link O}, result
   * of the search.
   */
  Optional<O> findOneSync(String id);

  /**
   * @see #findAllSync().
   */
  default CompletableFuture<Set<O>> findAll() {
    return supplyAsync(this::findAllSync);
  }

  /**
   * Searches for all the {@link O}s
   * stored in this {@link ObjectRepository}.
   *
   * @return A set of {@link O}s, taken from
   * this {@link ObjectRepository}.
   */
  Set<O> findAllSync();

  /**
   * @see #deleteSync(String).
   */
  default CompletableFuture<Void> delete(String id) {
    return supplyAsync(() -> deleteSync(id));
  }

  /**
   * Deletes an {@link O} stored in
   * this {@link ObjectRepository}.
   *
   * @param id The {@link O}'s id.
   * @return Null.
   */
  Void deleteSync(String id);

  /**
   * @see #saveOrReplaceSync(SavableModel).
   */
  default CompletableFuture<Void> saveOrReplace(O o) {
    return supplyAsync(() -> saveOrReplaceSync(o));
  }

  /**
   * Tries to get an {@link O} from
   * this {@link ObjectRepository}, via
   * {@link #findOne(String)}, and checks if
   * it is present. If it is, saves it, else,
   * replaces it.
   *
   * @param o The {@link O} to be stored/replaced.
   * @return Null.
   */
  default Void saveOrReplaceSync(O o) {
    if (findOneSync(o.getId()).isPresent()) {
      replaceSync(o.getId(), o);
    } else {
      saveSync(o);
    }

    return null;
  }

  /**
   * @see #replaceSync(String, SavableModel).
   */
  default CompletableFuture<Void> replace(String id, O o) {
    return supplyAsync(() -> replaceSync(id, o));
  }

  /**
   * Replaces an {@link O} stored in this
   * {@link ObjectRepository}.
   *
   * @param id The {@link O}'s id.
   * @param o The new {@link O}.
   * @return Null.
   */
  Void replaceSync(String id, O o);

  /**
   * @see #saveSync(SavableModel).
   */
  default CompletableFuture<Void> save(O o) {
    return supplyAsync(() -> saveSync(o));
  }

  /**
   * Stores an {@link O} into
   * this {@link ObjectRepository}.
   *
   * @param o The {@link O} to be stored.
   * @return Null.
   */
  Void saveSync(O o);

}
