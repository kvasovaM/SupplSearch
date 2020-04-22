package app.domain.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Указывает, что  Аннотация может быть использована во время выполнения через Reflection
@Target({ElementType.TYPE}) //Указывает, что целью нашей Аннотации является метод
public @interface SQLinformationClass {
    String name();
}
