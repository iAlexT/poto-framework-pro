package me.ialext.poto.helper;

public interface StringHelper {

  static String pluralize(String string) {
    return (!string.endsWith("s")) ? string + "s" : string;
  }
}
