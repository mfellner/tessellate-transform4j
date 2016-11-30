package de.zalando.tessellate.transform4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;
import java.io.Reader;

class Nashorn {
  static class NashornException extends Exception {
    private NashornException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  static Object executeFunction(String filePath, String functionName, Object... args) throws NashornException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    if (engine == null) {
      throw new RuntimeException("Nashorn engine not available.");
    }

    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    Reader reader = new InputStreamReader(loader.getResourceAsStream(filePath));

    try {
      engine.eval(reader);
    } catch (ScriptException e) {
      throw new NashornException(e.getMessage(), e);
    }

    Invocable invocable = (Invocable) engine;

    try {
      return invocable.invokeFunction(functionName, args);
    } catch (ScriptException e) {
      throw new NashornException(e.getMessage(), e);
    } catch (NoSuchMethodException e) {
      throw new NashornException("No such function: " + functionName, e);
    }
  }
}
