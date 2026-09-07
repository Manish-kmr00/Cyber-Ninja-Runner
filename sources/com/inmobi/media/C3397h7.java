package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.h7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3397h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3333a;
    public final L4 b;
    public final String c = "h7";
    public final WeakHashMap d = new WeakHashMap();
    public final WeakHashMap e = new WeakHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final C3355e7 g = new C3355e7();
    public final C3383g7 h = new C3383g7(this);
    public final C3369f7 i = new C3369f7();

    public C3397h7(byte b, L4 l4) {
        this.f3333a = b;
        this.b = l4;
    }

    public final void a(Context context, View view, C3313b7 token, AdConfig.ViewabilityConfig viewabilityConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(viewabilityConfig, "viewabilityConfig");
        C3552s4 c3552s4 = (C3552s4) this.d.get(context);
        if (c3552s4 == null) {
            c3552s4 = context instanceof Activity ? new C3552s4(viewabilityConfig, new C3323c3(this.i, (Activity) context, this.b), this.g) : new C3552s4(viewabilityConfig, new C3655z9(this.i, viewabilityConfig, (byte) 1, this.b), this.g);
            this.d.put(context, c3552s4);
        }
        byte b = this.f3333a;
        if (b == 0) {
            c3552s4.a(view, token, viewabilityConfig.getVideoImpressionMinPercentageViewed(), viewabilityConfig.getVideoImpressionMinTimeViewed());
        } else if (b == 1) {
            c3552s4.a(view, token, viewabilityConfig.getImpressionMinPercentageViewed(), viewabilityConfig.getImpressionMinTimeViewed());
        } else {
            c3552s4.a(view, token, viewabilityConfig.getImpressionMinPercentageViewed(), viewabilityConfig.getImpressionMinTimeViewed());
        }
    }

    public final void a(Context context, C3313b7 token) {
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        C3552s4 c3552s4 = (C3552s4) this.d.get(context);
        if (c3552s4 != null) {
            Intrinsics.checkNotNullParameter(token, "token");
            Iterator it = c3552s4.f3424a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (Intrinsics.areEqual(((C3524q4) entry.getValue()).f3404a, token)) {
                    view = (View) entry.getKey();
                    break;
                }
            }
            if (view != null) {
                Intrinsics.checkNotNullParameter(view, "view");
                c3552s4.f3424a.remove(view);
                c3552s4.b.remove(view);
                c3552s4.c.a(view);
            }
            if (c3552s4.f3424a.isEmpty()) {
                L4 l4 = this.b;
                if (l4 != null) {
                    String TAG = this.c;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "Impression tracker is free, removing it");
                }
                C3552s4 c3552s5 = (C3552s4) this.d.remove(context);
                if (c3552s5 != null) {
                    c3552s5.f3424a.clear();
                    c3552s5.b.clear();
                    c3552s5.c.a();
                    c3552s5.e.removeMessages(0);
                    c3552s5.c.b();
                }
                if (context instanceof Activity) {
                    this.d.isEmpty();
                }
            }
        }
    }

    public final void a(Context context, View view, C3313b7 token) {
        View view2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        fd fdVar = (fd) this.e.get(context);
        if (fdVar != null) {
            if (token != null) {
                Iterator it = fdVar.f3319a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        view2 = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (Intrinsics.areEqual(((cd) entry.getValue()).d, token)) {
                        view2 = (View) entry.getKey();
                        break;
                    }
                }
                if (view2 != null) {
                    fdVar.a(view2);
                }
            }
            if (fdVar.f3319a.isEmpty()) {
                L4 l4 = this.b;
                if (l4 != null) {
                    String TAG = this.c;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "Impression tracker is free, removing it");
                }
                fd fdVar2 = (fd) this.e.remove(context);
                if (fdVar2 != null) {
                    fdVar2.b();
                }
                if (context instanceof Activity) {
                    this.e.isEmpty();
                }
            }
        }
        this.f.remove(view);
    }

    public final void a(Context context, View view, C3313b7 token, Yc listener, AdConfig.ViewabilityConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(config, "config");
        fd c3655z9 = (fd) this.e.get(context);
        if (c3655z9 == null) {
            if (context instanceof Activity) {
                c3655z9 = new C3323c3(this.i, (Activity) context, this.b);
            } else {
                c3655z9 = new C3655z9(this.i, config, (byte) 1, this.b);
            }
            C3383g7 c3383g7 = this.h;
            L4 l4 = c3655z9.e;
            if (l4 != null) {
                ((M4) l4).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
            }
            c3655z9.j = c3383g7;
            this.e.put(context, c3655z9);
        }
        this.f.put(view, listener);
        byte b = this.f3333a;
        if (b == 0) {
            c3655z9.a(view, token, config.getVideoMinPercentagePlay());
        } else if (b == 1) {
            c3655z9.a(view, token, config.getDisplayMinPercentageAnimate());
        } else {
            c3655z9.a(view, token, config.getDisplayMinPercentageAnimate());
        }
    }
}
