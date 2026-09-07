package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class I6 extends BroadcastReceiver implements InterfaceC3624x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3095a;
    public final /* synthetic */ M6 b;

    public I6(M6 m6, String jsCallbackNamespace) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        this.b = m6;
        this.f3095a = jsCallbackNamespace;
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void a() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        contextD.unregisterReceiver(this);
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void b() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        AbstractC3420j2.a(contextD, this, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", intent.getAction())) {
            int intExtra = intent.getIntExtra("state", 0);
            L4 l4 = this.b.b;
            if (l4 != null) {
                ((M4) l4).a("MraidMediaProcessor", "Headphone plugged state changed: " + intExtra);
            }
            M6 m6 = this.b;
            String str = this.f3095a;
            boolean z = 1 == intExtra;
            L4 l5 = m6.b;
            if (l5 != null) {
                ((M4) l5).c("MraidMediaProcessor", "fireHeadphonePluggedEvent");
            }
            Ba ba = m6.f3135a;
            if (ba != null) {
                ba.a(str, "fireHeadphonePluggedEvent(" + z + ");");
            }
        }
    }
}
