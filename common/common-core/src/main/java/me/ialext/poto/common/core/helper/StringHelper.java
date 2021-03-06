package me.ialext.poto.common.api.helper;

public interface StringHelper {

  static String pluralize(String string) {
    return (!string.endsWith("s")) ? string + "s" : string;
  }
}
