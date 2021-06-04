Although `Thymeleaf` can be used in `Spring` with zero-configuration, it requires some boilerplate codes for integration with bare Java EE (Servlet).

To this end, this simple util can help students focus on template engine itself while taking my course [java-ee-swufe](https://github.com/ChenZhongPu/java-ee-swufe).

## Usage

Firstly, add `Maven` dependency:

```xml
<dependency>
    <groupId>info.zhongpu</groupId>
    <artifactId>tleaf</artifactId>
    <version>0.1.2</version>
</dependency>
```
All template files (`.html`) must be put under `webapp/WEB-INF/templates`.

```java
WebContext wx = ...;
TemplateUtils.process("template_name", wx);
```

Alternatively, the template name can be also specified by an `annotation` when there is only one possible template for a given servlet.

```java
@Leaf("template_name")
public class YourServlet extends HttpServlet {}
```
And then you can use `TemplateUtils.process("template_name")`.

Example project can be found at [java-ee-swufe: thymeleaf](https://github.com/ChenZhongPu/java-ee-swufe/tree/master/06_more_jsp/thymeleaf).

## To do
More flexible configurations will also be provided.