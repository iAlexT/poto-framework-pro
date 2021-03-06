package me.ialext.poto.cache.service;

/**
 * Ths interface should be implemented
 * by every class intended to start
 * or initialize something.
 */
public interface Service {

  /**
   * Setups the service.
   */
  void setup();

  /**
   * Shutdowns the serivce.
   * This isn't usually implemented, so,
   * this is a default empty method.
   */
  default void shutdown() {}

}
