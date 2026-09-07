package com.yandex.div.core.util;

import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: SparseArrays.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/util/SparseArrayIterable;", "T", "", "array", "Landroidx/collection/SparseArrayCompat;", "(Landroidx/collection/SparseArrayCompat;)V", "iterator", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SparseArrayIterable<T> implements Iterable<T>, KMappedMarker {
    private final SparseArrayCompat<T> array;

    public SparseArrayIterable(SparseArrayCompat<T> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new SparseArrayIterator(this.array);
    }
}
