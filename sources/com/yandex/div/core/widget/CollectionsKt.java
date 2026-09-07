package com.yandex.div.core.widget;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\bø\u0001\u0000\u001a4\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0005H\u0080\bø\u0001\u0000\u001a.\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0005H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"iterate", "", "T", "", "action", "Lkotlin/Function1;", "update", "", "offset", "", SessionDescription.ATTR_LENGTH, "indices", "Lkotlin/ranges/IntRange;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CollectionsKt {
    public static /* synthetic */ void update$default(int[] iArr, IntRange indices, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            indices = RangesKt.until(0, iArr.length);
        }
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        Intrinsics.checkNotNullParameter(action, "action");
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            iArr[first] = ((Number) action.invoke(Integer.valueOf(iArr[first]))).intValue();
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    public static final void update(int[] iArr, IntRange indices, Function1<? super Integer, Integer> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        Intrinsics.checkNotNullParameter(action, "action");
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            iArr[first] = action.invoke(Integer.valueOf(iArr[first])).intValue();
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    public static final void update(int[] iArr, int i, int i2, Function1<? super Integer, Integer> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = i2 + i;
        while (i < i3) {
            iArr[i] = action.invoke(Integer.valueOf(iArr[i])).intValue();
            i++;
        }
    }

    public static final <T> void iterate(List<? extends T> list, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.invoke(list.get(i));
        }
    }
}
