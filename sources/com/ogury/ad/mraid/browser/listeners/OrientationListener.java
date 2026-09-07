package com.ogury.ad.mraid.browser.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ogury.ad.internal.d5;
import com.ogury.ad.internal.k5;
import com.ogury.ad.internal.w4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class OrientationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7483a;
    public final k5 b;
    public int c;
    public final AnonymousClass1 d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.content.BroadcastReceiver, com.ogury.ad.mraid.browser.listeners.OrientationListener$1] */
    public OrientationListener(Context context, k5 multiWebViewCommandExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiWebViewCommandExecutor, "multiWebViewCommandExecutor");
        this.f7483a = context;
        this.b = multiWebViewCommandExecutor;
        this.c = context.getResources().getConfiguration().orientation;
        ?? r4 = new BroadcastReceiver() { // from class: com.ogury.ad.mraid.browser.listeners.OrientationListener.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual("android.intent.action.CONFIGURATION_CHANGED", intent.getAction())) {
                    int i = context2.getResources().getConfiguration().orientation;
                    OrientationListener orientationListener = OrientationListener.this;
                    if (orientationListener.c != i) {
                        orientationListener.c = i;
                        for (d5 webView : orientationListener.b.a()) {
                            w4 w4Var = webView.p;
                            w4Var.getClass();
                            Intrinsics.checkNotNullParameter(webView, "webView");
                            w4Var.d.a(webView.getMraidCommandExecutor());
                        }
                    }
                }
            }
        };
        this.d = r4;
        context.registerReceiver(r4, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }
}
