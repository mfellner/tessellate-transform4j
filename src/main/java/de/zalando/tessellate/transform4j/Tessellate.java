package de.zalando.tessellate.transform4j;

/**
 * Main tessellate-transform4j class.
 */
public class Tessellate {
  private static final String SCRIPT_FILE = "index.js";
  private static final String JS_FUNCTION = "transform";
  private static final String FILE_EXTENSION = ".json";

  public static class TransformException extends Exception {
    private TransformException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * Transform JSON to Tessellate JSON.
   *
   * @param json    Input JSON string to transform.
   * @param options {@link Options} for the transformation.
   * @return Transformed JSON string.
   * @throws TransformException If an error occurs during JavaScript execution.
   */
  public static String transform(String json, Options options) throws TransformException {
    return transform(json, options, 0);
  }

  /**
   * Transform JSON to Tessellate JSON.
   *
   * @param json    Input JSON string to transform.
   * @param options {@link Options} for the transformation.
   * @param space   Number of spaces to use for formatting the result.
   * @return Transformed and formatted JSON string.
   * @throws TransformException If an error occurs during JavaScript execution.
   */
  public static String transform(String json, Options options, int space) throws TransformException {
    try {
      File file = new File(json, FILE_EXTENSION);
      return (String) Nashorn.executeFunction(SCRIPT_FILE, JS_FUNCTION, file, options, space);
    } catch (Nashorn.NashornException e) {
      throw new TransformException(e.getMessage(), e.getCause());
    }
  }
}
