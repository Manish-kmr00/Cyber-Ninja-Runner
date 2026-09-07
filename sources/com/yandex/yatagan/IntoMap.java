package com.yandex.yatagan;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: compiled from: IntoMap.kt */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/yatagan/IntoMap;", "", "Key", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Documented
public @interface IntoMap {

    /* JADX INFO: compiled from: IntoMap.kt */
    @Target({ElementType.ANNOTATION_TYPE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MustBeDocumented
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/yandex/yatagan/IntoMap$Key;", "", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Documented
    public @interface Key {
    }
}
