package me.ialext.poto.common.api.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ialext.poto.common.api.model.SavableModel;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * An implementation of {@link ObjectRepository}
 * that uses JSON files.
 *
 * @param <O> The model type to be stored.
 */
public class JSONFileObjectRepository<O extends SavableModel> implements ObjectRepository<O> {

  @Inject private ObjectMapper objectMapper;

  private final Class<O> modelClass;
  private final File folder;

  public JSONFileObjectRepository(Class<O> modelClass,
                                  File folder) {
    this.modelClass = modelClass;
    this.folder = folder;
  }

  @Override
  public Optional<O> findOneSync(String id) {
    File file = new File(folder, id + ".json");

    if (!file.exists()) {
      return Optional.empty();
    }

    O o = null;
    try {
      o = objectMapper.readValue(file, modelClass);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return Optional.ofNullable(o);
  }

  @Override
  public Set<O> findAllSync() {
    Set<O> os = new HashSet<>();

    Arrays
        .stream(Objects.requireNonNull(folder.listFiles()))
        .filter(File::exists)
        .forEach(file -> {
          O o;
          try {
            o = objectMapper.readValue(file, modelClass);
            os.add(o);
          } catch (IOException e) {
            e.printStackTrace();
          }
        });

    return os;
  }

  @Override
  public Void deleteSync(String id) {
    File file = new File(folder, id + ".json");
    if (!file.exists()) {
      return null;
    }

    file.delete();

    return null;
  }

  @Override
  public Void replaceSync(String id, O o) {
    File file = new File(folder, id + ".json");

    if (!file.exists()) {
      return null;
    }

    try {
      objectMapper.writeValue(file, o);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Void saveSync(O o) {
    File file = new File(folder, o.getId() + ".json");

    try {
      objectMapper.writeValue(file, o);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
