package com.yandex.yatagan.common;

import com.yandex.yatagan.AutoBuilder;
import com.yandex.yatagan.Component;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: loadImplementation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a#\u0010\u0006\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"loadAutoBuilderImplementationByComponentClass", "Lcom/yandex/yatagan/AutoBuilder;", "T", "", "componentClass", "Ljava/lang/Class;", "loadImplementationByBuilderClass", "builderClass", "(Ljava/lang/Class;)Ljava/lang/Object;", "common"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "com/yandex/yatagan/common/Loader")
final /* synthetic */ class Loader__LoadImplementationKt {
    public static final <T> T loadImplementationByBuilderClass(Class<T> builderClass) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(builderClass, "builderClass");
        if (!builderClass.isAnnotationPresent(Component.Builder.class)) {
            throw new IllegalArgumentException((builderClass + " is not a builder for a Yatagan component").toString());
        }
        String name = builderClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "builderClass.name");
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(name, "$", (String) null, 2, (Object) null);
        if (Intrinsics.areEqual(strSubstringBeforeLast$default, builderClass.getName())) {
            throw new IllegalArgumentException(("No enclosing component class found for " + builderClass).toString());
        }
        Class<?> componentClass = builderClass.getClassLoader().loadClass(strSubstringBeforeLast$default);
        Intrinsics.checkNotNullExpressionValue(componentClass, "componentClass");
        T tCast = builderClass.cast(Loader.loadImplementationClass(componentClass).getDeclaredMethod("builder", new Class[0]).invoke(null, new Object[0]));
        Intrinsics.checkNotNullExpressionValue(tCast, "builderClass.cast(yataga…(\"builder\").invoke(null))");
        return tCast;
    }

    public static final <T> AutoBuilder<T> loadAutoBuilderImplementationByComponentClass(Class<T> componentClass) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        try {
            Object objInvoke = Loader.loadImplementationClass(componentClass).getDeclaredMethod("autoBuilder", new Class[0]).invoke(null, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type com.yandex.yatagan.AutoBuilder<T of com.yandex.yatagan.common.Loader__LoadImplementationKt.loadAutoBuilderImplementationByComponentClass>");
            return (AutoBuilder) objInvoke;
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException("Auto-builder can't be used for " + componentClass + ", because it declares an explicit builder. Please use `Yatagan.builder()` instead");
        }
    }
}
