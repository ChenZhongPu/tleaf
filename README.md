Although `Thymeleaf` can be used in `Spring` with zero-configuration, it requires some boilerplate codes for integration with bare Java EE (Servlet).

To this end, this simple util can help students focus on template engine itself while taking my course [java-ee-swufe](https://github.com/ChenZhongPu/java-ee-swufe).

## Usage

Firstly, add `Maven` dependency:

```xml
<dependency>
    <groupId>info.zhongpu</groupId>
    <artifactId>tleaf</artifactId>
    <version>0.1.1</version>
</dependency>
```
All template files must be put under `webapp/WEB-INF/templates`.

```java
WebContext wx = ...
TemplateUtils.process("template_name", wx);
```

Example project can be found [java-ee-swufe: thymeleaf]().

## To do
More flexible configurations will also be provided.