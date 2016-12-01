package org.zalando.tessellate.transform4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class NashornTest {
  @Test
  public void testExecuteFunction() throws Nashorn.NashornException {
    Object result = Nashorn.executeFunction("test.js", "test", "this is JavaScript");
    assertEquals("Hello, this is JavaScript!", result);
  }
}
