package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o1 {
    public static final a b = new a(0);
    private static volatile o1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f9769a;

    private o1() {
        this.f9769a = new LinkedHashMap();
        a("window_type_browser", new y0());
        a("window_type_activity_result", new s1());
    }

    public final synchronized m1 a(Activity activity, RelativeLayout rootLayout, v1 listener, e1 eventController, Intent intent, Window window, c1 c1Var) {
        n1 n1Var;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(window, "window");
        String stringExtra = intent.getStringExtra("window_type");
        if (stringExtra == null || (n1Var = (n1) this.f9769a.get(stringExtra)) == null) {
            return null;
        }
        return n1Var.a(activity, rootLayout, listener, eventController, intent, window, c1Var);
    }

    public final synchronized void a(String windowType, n1 creator) {
        Intrinsics.checkNotNullParameter(windowType, "windowType");
        Intrinsics.checkNotNullParameter(creator, "creator");
        if (!this.f9769a.containsKey(windowType)) {
            this.f9769a.put(windowType, creator);
        }
    }

    public /* synthetic */ o1(int i) {
        this();
    }

    public static final class a {
        @JvmStatic
        public final o1 a() {
            o1 o1Var = o1.c;
            if (o1Var == null) {
                synchronized (this) {
                    o1Var = o1.c;
                    if (o1Var == null) {
                        o1Var = new o1(0);
                        o1.c = o1Var;
                    }
                }
            }
            return o1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
