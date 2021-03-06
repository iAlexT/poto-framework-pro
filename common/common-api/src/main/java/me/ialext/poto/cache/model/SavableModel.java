package me.ialext.poto.cache.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface SavableModel {

  @JsonProperty("_id")
  String getId();

}
