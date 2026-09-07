package com.yandex.div.internal.util;

import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003\"\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\tH\u0007\u001a(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a4\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\rH\u0007\u001aH\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f*\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u00042\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00010\u0012H\u0087\bø\u0001\u0000\u001aD\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00010\u0012H\u0087\bø\u0001\u0000\u001a?\u0010\u0014\u001a\u0002H\t\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t*\u0010\u0012\u0006\b\u0001\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u0015\u001a\u0002H\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u0004H\u0007\u001a8\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000f*\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u00042\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0004\u0012\u0004\u0012\u00020\u001b0\u001dH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"allIsNullOrEmpty", "", FirebaseAnalytics.Param.ITEMS, "", "", "([Ljava/util/List;)Z", "arrayMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "", "source", "", "compareNullableWith", "T", "other", "comparator", "Lkotlin/Function2;", "compareWith", "getOrThrow", "key", "message", "", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "immutableCopy", "whenNotEmpty", "", "action", "Lkotlin/Function1;", "utils_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CollectionsKt {
    public static final <K, V> Map<K, V> arrayMap() {
        return new ArrayMap();
    }

    public static final <K, V> Map<K, V> arrayMap(int i) {
        return new ArrayMap(i);
    }

    public static final <K, V> Map<K, V> arrayMap(Map<K, ? extends V> source) {
        Intrinsics.checkNotNullParameter(source, "source");
        ArrayMap arrayMap = new ArrayMap(source.size());
        arrayMap.putAll(source);
        return arrayMap;
    }

    public static final <T> void whenNotEmpty(List<? extends T> list, Function1<? super List<? extends T>, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (list == null || list.isEmpty()) {
            return;
        }
        action.invoke(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> immutableCopy(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!TypeIntrinsics.isMutableList(list)) {
            return list;
        }
        List<T> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n        Collections.un…st(ArrayList(this))\n    }");
        return listUnmodifiableList;
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

    public static final <T> boolean compareWith(List<? extends T> list, List<? extends T> other, Function2<? super T, ? super T, Boolean> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() != other.size()) {
            return false;
        }
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            if (!comparator.invoke(t, other.get(i)).booleanValue()) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public static final boolean allIsNullOrEmpty(List<?>... items) {
        Intrinsics.checkNotNullParameter(items, "items");
        for (List<?> list : items) {
            if (list != null && !list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean compareNullableWith(List<? extends T> list, List<? extends T> list2, Function2<? super T, ? super T, Boolean> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        if (list.size() == list2.size()) {
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                if (comparator.invoke(t, list2.get(i)).booleanValue()) {
                    i = i2;
                }
            }
            return true;
        }
        return false;
    }
}
