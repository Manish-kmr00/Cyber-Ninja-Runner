package com.bykv.vk.openvk.preload.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JsonAdapter.java */
/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    Class<?> a();

    boolean b() default true;
}
