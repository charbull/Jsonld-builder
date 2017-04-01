package ioinformarics.oss.jackson.module.jsonld.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Alexander De Leon
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Inherited
@Repeatable(JsonldLinks.class)
public @interface JsonldLink {
    String rel();
    String name();
   // String href();
}
