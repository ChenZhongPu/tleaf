Although `Thymeleaf` can be used in `Spring` with zero-configuration, it requires some boilerplate codes for integration with bare Java EE (Servlet).

To this end, this simple util can help students focus on template engine itself while taking my course [java-ee-swufe](https://github.com/ChenZhongPu/java-ee-swufe).

## Usage
```java
TemplateEngine engine = ThymeleafAppUtil.getTemplateEngine(request.getServletContext());
```

## To do
More flexible configurations will also be provided.