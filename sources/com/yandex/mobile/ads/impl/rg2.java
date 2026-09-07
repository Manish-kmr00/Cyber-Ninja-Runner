package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class rg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f10106a = LazyKt.lazy(a.b);
    public static final /* synthetic */ int b = 0;

    static final class a extends Lambda implements Function0<Handler> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    @JvmStatic
    public static final void a(final ViewGroup viewGroup, final boolean z) {
        ((Handler) f10106a.getValue()).post(new Runnable() { // from class: com.yandex.mobile.ads.impl.rg2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                rg2.b(viewGroup, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ViewGroup viewGroup, boolean z) {
        int childCount;
        if (viewGroup == null || viewGroup.getChildCount() <= 0 || (childCount = viewGroup.getChildCount() - (!z ? 1 : 0)) <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof uk) {
                arrayList.add(childAt);
            }
        }
        viewGroup.removeViews(0, childCount);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((uk) arrayList.get(i2)).d();
        }
        arrayList.clear();
    }
}
