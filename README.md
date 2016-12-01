# tessellate-transform4j

[tessellate-transform](https://github.com/zalando-incubator/tessellate/tree/master/packages/tessellate-transform) for Java.
&nbsp;
[![Build Status](https://travis-ci.org/zalando-incubator/tessellate-transform4j.svg?branch=master)](https://travis-ci.org/zalando-incubator/tessellate-transform4j)

### Usage

```java
import org.zalando.tessellate.transform4j.Tessellate;

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
