package me.ialext.poto.common.api.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.ialext.poto.common.api.model.SavableModel;
import me.ialext.poto.common.api.helper.StringHelper;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

/**
 * An implementation of {@link ObjectRepository} that
 * uses MongoDB.
 *
 * @param <O> The model type to be stored.
 */
public class MongoObjectRepository<O extends SavableModel> implements ObjectRepository<O> {

  private final MongoCollection<O> mongoCollection;

  @Inject
  public MongoObjectRepository(Class<O> modelClass,
                               MongoDatabase mongoDatabase) {
    this.mongoCollection = mongoDatabase.getCollection(StringHelper.pluralize(modelClass.getSimpleName().toLowerCase()), modelClass);
  }

  @Override
  public Optional<O> findOneSync(String id) {
    return Optional.ofNullable(mongoCollection.find(eq("_id", id)).first());
  }

  @Override
  public Set<O> findAllSync() {
    return mongoCollection.find().into(new HashSet<>());
  }

  @Override
  public Void deleteSync(String id) {
    mongoCollection.findOneAndDelete(eq("_id", id));

    return null;
  }

  @Override
  public Void replaceSync(String id, O o) {
    mongoCollection.replaceOne(eq("_id", id), o);

    return null;
  }

  @Override
  public Void saveSync(O o) {
    mongoCollection.insertOne(o);

    return null;
  }
}
