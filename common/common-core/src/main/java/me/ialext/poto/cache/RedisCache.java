package me.ialext.poto.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ialext.poto.cache.cache.Cache;
import me.ialext.poto.cache.data.ObjectRepository;
import me.ialext.poto.cache.model.SavableModel;
import me.ialext.poto.helper.StringHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RedisCache<O extends SavableModel> implements Cache<O> {

  private final JedisPool jedisPool;
  private final ObjectRepository<O> objectRepository;
  private final ObjectMapper objectMapper;

  private final Class<O> modelClass;
  private final String identifier;

  @Inject
  public RedisCache(JedisPool jedisPool,
                    ObjectRepository<O> objectRepository,
                    ObjectMapper objectMapper,
                    Class<O> modelClass) {
    this.jedisPool = jedisPool;
    this.objectRepository = objectRepository;
    this.objectMapper = objectMapper;
    this.modelClass = modelClass;
    this.identifier = StringHelper.pluralize(modelClass.getSimpleName().toLowerCase());
  }

  @Override
  public Optional<O> findOne(String id) {
    try (Jedis jedis = jedisPool.getResource()) {
      String jsonO = jedis.get(identifier + ":" + id);
      if (jsonO == null || jsonO.equals("nil")) {
        return Optional.empty();
      }

      return Optional.of(objectMapper.readValue(jsonO, modelClass));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }

  @Override
  public Optional<O> getOrFind(String id) {
    return findOne(id).isPresent() ? findOne(id) : objectRepository.findOneSync(id);
  }

  @Override
  public Set<O> getAll() {
    try (Jedis jedis = jedisPool.getResource()) {
      Set<O> os = new HashSet<>();
      for (String jsonO : jedis.keys(identifier + ":*")) {
        os.add(objectMapper.readValue(jsonO, modelClass));
      }

      return os;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public void cache(O o) {
    try (Jedis jedis = jedisPool.getResource()) {
      jedis.set(o.getId(), objectMapper.writeValueAsString(o));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void save(String id) {
    findOne(id).ifPresent(objectRepository::save);
  }

  @Override
  public void saveAll() {
    try (Jedis jedis = jedisPool.getResource()) {
      Set<O> os = new HashSet<>();

      for (String jsonO : jedis.keys(identifier + ":*")) {
        os.add(objectMapper.readValue(jsonO, modelClass));
      }
      os.forEach(objectRepository::save);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(String id) {
    try (Jedis jedis = jedisPool.getResource()) {
      jedis.del(identifier + ":" + id);
    }
  }
}
