package com.yandex.yatagan.common;

import com.yandex.yatagan.AutoBuilder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"com/yandex/yatagan/common/Loader__LoadImplementationKt", "com/yandex/yatagan/common/Loader__UtilsKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class Loader {
    public static final <T> AutoBuilder<T> loadAutoBuilderImplementationByComponentClass(Class<T> cls) throws ClassNotFoundException {
        return Loader__LoadImplementationKt.loadAutoBuilderImplementationByComponentClass(cls);
    }

    public static final <T> T loadImplementationByBuilderClass(Class<T> cls) throws ClassNotFoundException {
        return (T) Loader__LoadImplementationKt.loadImplementationByBuilderClass(cls);
    }

    public static final Class<?> loadImplementationClass(Class<?> cls) {
        return Loader__UtilsKt.loadImplementationClass(cls);
    }
}
