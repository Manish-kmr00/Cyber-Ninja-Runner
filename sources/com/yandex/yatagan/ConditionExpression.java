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

/* JADX INFO: compiled from: ConditionExpression.kt */
/* JADX INFO: loaded from: classes11.dex */
@Target({ElementType.ANNOTATION_TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\fB4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\"\u0006\u0012\u0002\b\u00030\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001b\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\nR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/yatagan/ConditionExpression;", "", "value", "", "imports", "", "Lkotlin/reflect/KClass;", "importAs", "Lcom/yandex/yatagan/ConditionExpression$ImportAs;", "()[Lcom/yandex/yatagan/ConditionExpression$ImportAs;", "()[Ljava/lang/Class;", "()Ljava/lang/String;", "ImportAs", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ConditionsApi
@Documented
public @interface ConditionExpression {

    /* JADX INFO: compiled from: ConditionExpression.kt */
    @Target({})
    @kotlin.annotation.Target(allowedTargets = {})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MustBeDocumented
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yandex/yatagan/ConditionExpression$ImportAs;", "", "value", "Lkotlin/reflect/KClass;", "alias", "", "()Ljava/lang/String;", "()Ljava/lang/Class;", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ConditionsApi
    @Documented
    public @interface ImportAs {
        String alias();

        Class<?> value();
    }

    ImportAs[] importAs() default {};

    Class<?>[] imports();

    String value();
}
