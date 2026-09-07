package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u51 {
    private static final Object c = new Object();
    private static volatile u51 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10358a;
    private boolean b;

    public static final class a {
        @JvmStatic
        public static u51 a() {
            if (u51.d == null) {
                synchronized (u51.c) {
                    if (u51.d == null) {
                        u51.d = new u51();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            u51 u51Var = u51.d;
            if (u51Var != null) {
                return u51Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public final void b(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if ((view instanceof TextView) || (view instanceof fn1)) {
            a(view, motionEvent);
        }
    }

    /* synthetic */ u51() {
        this(new Handler(Looper.getMainLooper()));
    }

    private u51(Handler handler) {
        this.f10358a = handler;
    }

    private final void a(final View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (!this.b) {
                view.setAlpha(view.getAlpha() / 2);
                this.b = true;
            }
            this.f10358a.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.u51$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    u51.a(this.f$0, view);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(u51 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (this$0.b) {
            view.setAlpha(view.getAlpha() * 2);
            this$0.b = false;
        }
    }
}
