package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class Ad implements vd {
    public static final WeakHashMap f = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xd f3029a;
    public final L4 b;
    public final ConcurrentHashMap c;
    public final WeakReference d;
    public EnumC3501o9 e;

    public Ad(Activity activity, xd windowInsetListener, L4 l4) {
        Window window;
        Intrinsics.checkNotNullParameter(windowInsetListener, "windowInsetListener");
        this.f3029a = windowInsetListener;
        this.b = l4;
        this.c = new ConcurrentHashMap();
        WeakReference weakReference = new WeakReference(activity);
        this.d = weakReference;
        if (!C3435k3.f3355a.F()) {
            if (l4 != null) {
                ((M4) l4).a("WindowInsetsHandler", "WindowInsetsHandler is not supported for this version");
                return;
            }
            return;
        }
        Activity activity2 = (Activity) weakReference.get();
        View decorView = (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView();
        if (decorView != null) {
            if (l4 != null) {
                ((M4) l4).a("WindowInsetsHandler", "startListeningToInsets");
            }
            WeakHashMap weakHashMap = f;
            Object wdVar = weakHashMap.get(decorView);
            if (wdVar == null) {
                wdVar = new wd(decorView);
                weakHashMap.put(decorView, wdVar);
            }
            Intrinsics.checkNotNullParameter(this, "listener");
            ((wd) wdVar).f3468a.add(this);
            if (l4 != null) {
                ((M4) l4).a("WindowInsetsHandler_INSTANCE", this + " created - " + weakHashMap.size());
            }
        }
    }

    public final void a() {
        Window window;
        Activity activity = (Activity) this.d.get();
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView != null) {
            WeakHashMap weakHashMap = f;
            wd wdVar = (wd) weakHashMap.get(decorView);
            if (wdVar != null) {
                Intrinsics.checkNotNullParameter(this, "listener");
                wdVar.f3468a.remove(this);
                if (wdVar.f3468a.isEmpty()) {
                    wdVar.a();
                    weakHashMap.remove(decorView);
                }
            }
            L4 l4 = this.b;
            if (l4 != null) {
                ((M4) l4).a("WindowInsetsHandler_INSTANCE", this + " destroy - " + weakHashMap.size());
            }
        }
    }

    public final void a(yd insets, int i) {
        EnumC3501o9 orientation = AbstractC3515p9.a(AbstractC3565t3.g());
        zd zdVar = (zd) this.c.get(Integer.valueOf(i));
        if (zdVar == null) {
            zdVar = new zd();
            this.c.put(Integer.valueOf(i), zdVar);
        }
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        yd ydVar = (yd) zdVar.f3497a.get(orientation);
        if (ydVar != null && Intrinsics.areEqual(insets, ydVar)) {
            L4 l4 = this.b;
            if (l4 != null) {
                ((M4) l4).a("WindowInsetsHandler", "SafeArea - Same value, no need to update");
            }
        } else {
            L4 l5 = this.b;
            if (l5 != null) {
                ((M4) l5).a("WindowInsetsHandler", "safeArea - New value, updating to KV store");
            }
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            Intrinsics.checkNotNullParameter(insets, "insets");
            zdVar.f3497a.put(orientation, insets);
            ConcurrentHashMap concurrentHashMap = this.c;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(concurrentHashMap.size()));
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((zd) entry.getValue()).a());
            }
            AbstractC3565t3.a(linkedHashMap);
        }
        if (this.e != orientation) {
            this.e = orientation;
            xd xdVar = this.f3029a;
            Object obj = this.c.get(Integer.valueOf(i));
            Intrinsics.checkNotNull(obj);
            xdVar.a(orientation, (zd) obj);
        }
    }
}
