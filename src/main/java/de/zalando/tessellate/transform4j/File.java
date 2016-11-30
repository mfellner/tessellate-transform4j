package de.zalando.tessellate.transform4j;

/**
 * Tessellate transform file argument.
 */
public class File {
  public final String content;
  public final String extname;

  File(String content, String extname) {
    this.content = content;
    this.extname = extname;
  }
}
