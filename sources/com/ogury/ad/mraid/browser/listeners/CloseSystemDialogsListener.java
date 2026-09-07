package com.ogury.ad.mraid.browser.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ogury.ad.internal.aa;
import com.ogury.ad.internal.d5;
import com.ogury.ad.internal.h5;
import com.ogury.ad.internal.k5;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class CloseSystemDialogsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7481a;
    public final k5 b;
    public final AnonymousClass1 c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.BroadcastReceiver, com.ogury.ad.mraid.browser.listeners.CloseSystemDialogsListener$1] */
    public CloseSystemDialogsListener(Context context, k5 multiWebViewCommandExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiWebViewCommandExecutor, "multiWebViewCommandExecutor");
        this.f7481a = context;
        this.b = multiWebViewCommandExecutor;
        ?? r4 = new BroadcastReceiver() { // from class: com.ogury.ad.mraid.browser.listeners.CloseSystemDialogsListener.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Collection<aa> collectionValues = CloseSystemDialogsListener.this.b.b.values();
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        if (((aa) it.next()).b) {
                            return;
                        }
                    }
                }
                Iterator it2 = CloseSystemDialogsListener.this.b.a().iterator();
                while (it2.hasNext()) {
                    h5.a((d5) it2.next(), "ogySdkMraidGateway.callEventListeners(\"ogyOnCloseSystem\", {})");
                }
            }
        };
        this.c = r4;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(r4, intentFilter);
    }
}
