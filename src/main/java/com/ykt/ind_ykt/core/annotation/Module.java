package com.ykt.ind_ykt.core.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD,ElementType.TYPE  })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Module {
    String value();
}
