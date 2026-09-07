package com.yandex.div.core.expression.local;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: ChildPathUnitCache.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\fR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/expression/local/ChildPathUnitCache;", "", "()V", Reporting.EventType.CACHE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "ensureGenerated", "", "index", "", "getValue", "getValue$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChildPathUnitCache {
    public static final ChildPathUnitCache INSTANCE = new ChildPathUnitCache();
    private static ArrayList<String> cache = new ArrayList<>();

    private ChildPathUnitCache() {
    }

    private final void ensureGenerated(int index) {
        if (cache.size() > index) {
            return;
        }
        cache.ensureCapacity(index + 1);
        int size = cache.size();
        if (size > index) {
            return;
        }
        while (true) {
            cache.add(size, "child#" + size);
            if (size == index) {
                return;
            } else {
                size++;
            }
        }
    }

    public final String getValue$div_release(int index) {
        ensureGenerated(index);
        String str = cache.get(index);
        Intrinsics.checkNotNullExpressionValue(str, "cache[index]");
        return str;
    }
}
