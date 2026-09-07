package com.yandex.yatagan;

import com.yandex.yatagan.common.Loader;
import com.yandex.yatagan.internal.ThreadAssertions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Yatagan.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007J%\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/yandex/yatagan/Yatagan;", "", "()V", "autoBuilder", "Lcom/yandex/yatagan/AutoBuilder;", "T", "componentClass", "Ljava/lang/Class;", "builder", "builderClass", "(Ljava/lang/Class;)Ljava/lang/Object;", "create", "setThreadAsserter", "", "threadAsserter", "Lcom/yandex/yatagan/ThreadAsserter;", "compiled"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Yatagan {
    public static final Yatagan INSTANCE = new Yatagan();

    private Yatagan() {
    }

    @JvmStatic
    public static final void setThreadAsserter(ThreadAsserter threadAsserter) {
        ThreadAssertions.setAsserter(threadAsserter);
    }

    @JvmStatic
    public static final <T> T builder(Class<T> builderClass) {
        Intrinsics.checkNotNullParameter(builderClass, "builderClass");
        return (T) Loader.loadImplementationByBuilderClass(builderClass);
    }

    @JvmStatic
    public static final <T> AutoBuilder<T> autoBuilder(Class<T> componentClass) {
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        return Loader.loadAutoBuilderImplementationByComponentClass(componentClass);
    }

    @JvmStatic
    public static final <T> T create(Class<T> componentClass) {
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        return (T) autoBuilder(componentClass).create();
    }
}
