package app.domain.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Указывает, что наша Аннотация может использована во время выполнения через Reflection (нам как раз это нужно).
@Target(ElementType.FIELD) //Указывает, что целью нашей Аннотации является метод (не класс, не переменная, не поле, а им
public @interface SQLinformationVariable {
    String name();
    String SQLtype();
    String SQLparams() default "";
}
