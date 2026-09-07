package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cg2 {
    private static final List<String> c = CollectionsKt.listOf((Object[]) new String[]{"clickTracking", "impression"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final je2 f8603a;
    private final l82 b;

    public cg2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8603a = new je2(context);
        this.b = new l82(context);
    }

    public final void a(bg2 trackable, String eventName) {
        Intrinsics.checkNotNullParameter(trackable, "trackable");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        List<String> list = trackable.a().get(eventName);
        if (c.contains(eventName)) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.b.a((String) it.next()));
                }
                list = arrayList;
            } else {
                list = null;
            }
        }
        if (list != null) {
            this.f8603a.a(list, null);
        }
    }

    public final void a(bg2 trackable, String eventName, Map<String, String> macros) {
        Intrinsics.checkNotNullParameter(trackable, "trackable");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        List<String> list = trackable.a().get(eventName);
        if (list != null) {
            this.f8603a.a(list, macros);
        }
    }
}
