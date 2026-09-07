package com.smaato.sdk.core.util.collections;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes5.dex */
final class Iterators {
    static <T> ListIterator<T> cast(Iterator<T> it) {
        return (ListIterator) it;
    }
}
