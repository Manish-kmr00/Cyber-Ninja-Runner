package com.inmobi.media;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.g4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3380g4 {
    public static final C3338d4 k = new C3338d4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3324a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final L4 f;
    public C3552s4 g;
    public C3422j4 h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final C3352e4 j = new C3352e4(this);

    public C3380g4(byte b, String str, int i, int i2, int i3, L4 l4) {
        this.f3324a = b;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = l4;
    }

    public final void a(View view) {
        C3552s4 c3552s4;
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("HtmlAdTracker", "stopTrackingForImpression");
        }
        if (Intrinsics.areEqual(this.b, "video") || Intrinsics.areEqual(this.b, "audio") || (c3552s4 = this.g) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        c3552s4.f3424a.remove(view);
        c3552s4.b.remove(view);
        c3552s4.c.a(view);
        if (c3552s4.f3424a.isEmpty()) {
            L4 l5 = this.f;
            if (l5 != null) {
                ((M4) l5).a("HtmlAdTracker", "Impression tracker is free, removing it");
            }
            C3552s4 c3552s5 = this.g;
            if (c3552s5 != null) {
                c3552s5.f3424a.clear();
                c3552s5.b.clear();
                c3552s5.c.a();
                c3552s5.e.removeMessages(0);
                c3552s5.c.b();
            }
            this.g = null;
        }
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("HtmlAdTracker", "stopTrackingForVisibility");
        }
        C3422j4 c3422j4 = this.h;
        if (c3422j4 != null) {
            c3422j4.a(view);
            if (c3422j4.f3319a.isEmpty()) {
                L4 l5 = this.f;
                if (l5 != null) {
                    ((M4) l5).a("HtmlAdTracker", "Visibility tracker is free, removing it");
                }
                C3422j4 c3422j5 = this.h;
                if (c3422j5 != null) {
                    c3422j5.b();
                }
                this.h = null;
            }
        }
        this.i.remove(view);
    }

    public final void b() {
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("HtmlAdTracker", "onActivityStopped");
        }
        C3552s4 c3552s4 = this.g;
        if (c3552s4 != null) {
            String TAG = c3552s4.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            c3552s4.c.a();
            c3552s4.e.removeCallbacksAndMessages(null);
            c3552s4.b.clear();
        }
        C3422j4 c3422j4 = this.h;
        if (c3422j4 != null) {
            c3422j4.e();
        }
    }

    public final void a() {
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("HtmlAdTracker", "onActivityStarted");
        }
        C3552s4 c3552s4 = this.g;
        if (c3552s4 != null) {
            String TAG = c3552s4.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            for (Map.Entry entry : c3552s4.f3424a.entrySet()) {
                View view = (View) entry.getKey();
                C3524q4 c3524q4 = (C3524q4) entry.getValue();
                c3552s4.c.a(view, c3524q4.f3404a, c3524q4.b);
            }
            if (!c3552s4.e.hasMessages(0)) {
                c3552s4.e.postDelayed(c3552s4.f, c3552s4.g);
            }
            c3552s4.c.f();
        }
        C3422j4 c3422j4 = this.h;
        if (c3422j4 != null) {
            c3422j4.f();
        }
    }
}
