package me.ialext.poto.cache;

import me.ialext.poto.cache.cache.Cache;
import me.ialext.poto.cache.data.ObjectRepository;
import me.ialext.poto.cache.model.SavableModel;

import javax.inject.Inject;
import java.util.*;

/**
 * An implementation of {@link Cache} that uses a
 * {@link Map} as repository.
 *
 * @param <O> The model type to be cached.
 */
public class LocalCache<O extends SavableModel> implements Cache<O> {

  private final Map<String, O> cache = new HashMap<>();
  private final ObjectRepository<O> objectRepository;

  @Inject
  public LocalCache(Class<O> modelClass,
                    ObjectRepository<O> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public Optional<O> findOne(String id) {
    return Optional.ofNullable(cache.get(id));
  }

  @Override
  public Optional<O> getOrFind(String id) {
    return findOne(id).isPresent() ? findOne(id) : objectRepository.findOneSync(id);
  }

  @Override
  public Set<O> getAll() {
    return new HashSet<>(cache.values());
  }

  @Override
  public void cache(O o) {
    cache.put(o.getId(), o);
  }

  @Override
  public void save(O o) {
    objectRepository.save(o);
  }

  @Override
  public void saveAll() {
    cache.values().forEach(objectRepository::save);
  }

  @Override
  public void delete(String id) {
    objectRepository.delete(id);
  }
}
