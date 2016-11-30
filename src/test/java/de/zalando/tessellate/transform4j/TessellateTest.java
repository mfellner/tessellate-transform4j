package de.zalando.tessellate.transform4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TessellateTest {

  private static Options getOptions() {
    JSONMap jsonMap = new JSONMap()
        .withTypeKeys(singletonList("class"))
        .withChildrenKeys(asList(
            "children",
            "contents"
        ))
        .withIgnoreKeys(singletonList(
            "ignore"
        ))
        .withTypeMapEntry("h1", "Heading");

    return new Options()
        .withRoot("test.Wrapper")
        .withTypePrefix("test.")
        .withJsonMap(jsonMap);
  }

  public static String read(InputStream input) throws IOException {
    try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
      return buffer.lines().collect(Collectors.joining("\n"));
    }
  }

  public static String read(String filePath) throws IOException {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    return read(loader.getResourceAsStream(filePath));
  }

  @Test
  public void testTransform() throws Exception {
    String json = read("fixtures/simple.json");
    String expected = read("fixtures/simple.expected.json");
    String result = Tessellate.transform(json, getOptions(), 2);
    assertEquals(expected, result);
  }
}
