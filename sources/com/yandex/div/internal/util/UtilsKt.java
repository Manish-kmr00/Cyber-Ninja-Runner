package com.yandex.div.internal.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadWriteProperty;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u001a/\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u0001H\u0003H\u0000¢\u0006\u0002\u0010\u0005\u001a?\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0007*\u0010\u0012\u0006\b\u0001\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\n\u001a\u0002H\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u000f0\u0012H\u0080\bø\u0001\u0000\u001a?\u0010\u0013\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0007*\u0010\u0012\u0006\b\u0001\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00070\u00142\u0006\u0010\n\u001a\u0002H\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"weak", "Lkotlin/properties/ReadWriteProperty;", "", "T", "obj", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "getOrThrow", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "", "key", "message", "", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "removeFirstIf", "", "", "predicate", "Lkotlin/Function1;", "removeOrThrow", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UtilsKt {
    public static final <T> boolean removeFirstIf(Collection<T> collection, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Object removeOrThrow$default(Map map, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        return removeOrThrow(map, obj, str);
    }

    public static final <K, V> V removeOrThrow(Map<? extends K, V> map, K k, String str) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        V v = (V) TypeIntrinsics.asMutableMap(map).remove(k);
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ Object getOrThrow$default(Map map, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        return getOrThrow(map, obj, str);
    }

    public static final <K, V> V getOrThrow(Map<? extends K, ? extends V> map, K k, String str) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        V v = map.get(k);
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException(str);
    }

    public static final <T> ReadWriteProperty<Object, T> weak(T t) {
        return new WeakRef(t);
    }

    public static /* synthetic */ ReadWriteProperty weak$default(Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return weak(obj);
    }
}
