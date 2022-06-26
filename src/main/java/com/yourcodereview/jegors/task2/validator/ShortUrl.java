package com.yourcodereview.jegors.task2.validator;

import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Target({METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
@Length(min = 1, max = 6)
@Pattern(regexp = "^\\p{Alnum}{1,6}$")
public @interface ShortUrl {
    String message() default "{short-url.error}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
