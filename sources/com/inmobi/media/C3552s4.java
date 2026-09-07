package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.s4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3552s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap f3424a;
    public final WeakHashMap b;
    public final fd c;
    public final String d;
    public final Handler e;
    public final RunnableC3537r4 f;
    public final long g;
    public final InterfaceC3510p4 h;

    public C3552s4(AdConfig.ViewabilityConfig viewabilityConfig, fd visibilityTracker, InterfaceC3510p4 listener) {
        Intrinsics.checkNotNullParameter(viewabilityConfig, "viewabilityConfig");
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f3424a = weakHashMap;
        this.b = weakHashMap2;
        this.c = visibilityTracker;
        this.d = "s4";
        this.g = viewabilityConfig.getImpressionPollIntervalMillis();
        C3496o4 c3496o4 = new C3496o4(this);
        L4 l4 = visibilityTracker.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
        }
        visibilityTracker.j = c3496o4;
        this.e = handler;
        this.f = new RunnableC3537r4(this);
        this.h = listener;
    }

    public final void a(View view, Object token, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        C3524q4 c3524q4 = (C3524q4) this.f3424a.get(view);
        if (Intrinsics.areEqual(c3524q4 != null ? c3524q4.f3404a : null, token)) {
            return;
        }
        a(view);
        this.f3424a.put(view, new C3524q4(token, i, i2));
        this.c.a(view, token, i);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3424a.remove(view);
        this.b.remove(view);
        this.c.a(view);
    }
}
