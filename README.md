# tessellate-transform4j

[tessellate-transform](https://github.com/zalando-incubator/tessellate/tree/master/packages/tessellate-transform) for Java.

### Usage

```java
import de.zalando.tessellate.transform4j.Tessellate;

String json = "{ ... }";

Options options = new Options()
    .withRoot("test.Wrapper")
    .withTypePrefix("test.")
    .withJsonMap(new JSONMap()
        .withTypeKeys(singletonList("class"))
        .withChildrenKeys(asList(
            "children",
            "contents"
        ))
        .withIgnoreKeys(singletonList(
            "ignore"
        ))
        .withTypeMapEntry("h1", "Heading"));

String result = Tessellate.transform(json, options);
```
