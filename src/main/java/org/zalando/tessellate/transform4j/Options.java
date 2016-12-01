package org.zalando.tessellate.transform4j;

/**
 * Tessellate transform options argument.
 */
public class Options {
  public String root;
  public String typePrefix;
  public JSONMap jsonMap;

  public Options() {
  }

  public Options(String root, String typePrefix, JSONMap jsonMap) {
    this.root = root;
    this.typePrefix = typePrefix;
    this.jsonMap = jsonMap;
  }

  /**
   * Set the optional name of the wrapping root element.
   *
   * @param root Name of the the root element type.
   * @return The Options.
   */
  public Options withRoot(String root) {
    this.root = root;
    return this;
  }

  /**
   * Set the optional type prefix.
   *
   * @param typePrefix Name of the prefix for each type.
   * @return The Options.
   */
  public Options withTypePrefix(String typePrefix) {
    this.typePrefix = typePrefix;
    return this;
  }

  /**
   * Set the optional JSON map.
   *
   * @param jsonMap Map of JSON properties to Tessellate JSON properties.
   * @return The Options.
   */
  public Options withJsonMap(JSONMap jsonMap) {
    this.jsonMap = jsonMap;
    return this;
  }
}
