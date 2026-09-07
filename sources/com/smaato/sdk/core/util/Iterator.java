package com.smaato.sdk.core.util;

import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public interface Iterator<E> {
    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        while (hasNext()) {
            consumer.accept(next());
        }
    }
}
