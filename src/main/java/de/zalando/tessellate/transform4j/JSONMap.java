package de.zalando.tessellate.transform4j;

import java.util.*;

/**
 * Map of JSON properties to Tessellate JSON properties.
 */
public class JSONMap {
  public final List<String> typeKeys;
  public final List<String> childrenKeys;
  public final List<String> literalKeys;
  public final List<String> ignoreKeys;
  public final Map<String, String> typeMap;

  public JSONMap() {
    this.typeKeys = new ArrayList<>();
    this.childrenKeys = new ArrayList<>();
    this.literalKeys = new ArrayList<>();
    this.ignoreKeys = new ArrayList<>();
    this.typeMap = new HashMap<>();
  }

  /**
   * Set the type keys.
   *
   * @param typeKeys JSON properties to use as types.
   * @return The JSONMap.
   */
  public JSONMap withTypeKeys(Collection<String> typeKeys) {
    this.typeKeys.addAll(typeKeys);
    return this;
  }

  /**
   * Set the children keys.
   *
   * @param childrenKeys JSON properties to use as children.
   * @return The JSONMap.
   */
  public JSONMap withChildrenKeys(Collection<String> childrenKeys) {
    this.childrenKeys.addAll(childrenKeys);
    return this;
  }

  /**
   * Set the literal keys.
   *
   * @param literalKeys JSON properties to use as literals.
   * @return The JSONMap.
   */
  public JSONMap withLiteralKeys(Collection<String> literalKeys) {
    this.literalKeys.addAll(literalKeys);
    return this;
  }

  /**
   * Set the ignore keys.
   *
   * @param ignoreKeys JSON properties to ignore.
   * @return The JSONMap.
   */
  public JSONMap withIgnoreKeys(Collection<String> ignoreKeys) {
    this.ignoreKeys.addAll(ignoreKeys);
    return this;
  }

  /**
   * Add a type map entry.
   *
   * @param key   Source JSON property name.
   * @param value Target JSON property name.
   * @return The JSONMap.
   */
  public JSONMap withTypeMapEntry(String key, String value) {
    this.typeMap.put(key, value);
    return this;
  }

  /**
   * Add all type map entries.
   *
   * @param entries Type map entries to add.
   * @return The JSONMap.
   */
  public JSONMap withTypeMapEntries(Map<String, String> entries) {
    this.typeMap.putAll(entries);
    return this;
  }
}
