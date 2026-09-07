package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class J6 extends BroadcastReceiver implements InterfaceC3624x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3105a;
    public final /* synthetic */ M6 b;

    public J6(M6 m6, String jsCallbackNamespace) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        this.b = m6;
        this.f3105a = jsCallbackNamespace;
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
        AbstractC3420j2.a(contextD, this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.media.RINGER_MODE_CHANGED", intent.getAction())) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
            L4 l4 = this.b.b;
            if (l4 != null) {
                ((M4) l4).a("MraidMediaProcessor", "Ringer mode action changed: " + intExtra);
            }
            M6 m6 = this.b;
            String str = this.f3105a;
            boolean z = 2 != intExtra;
            L4 l5 = m6.b;
            if (l5 != null) {
                ((M4) l5).c("MraidMediaProcessor", "fireDeviceMuteChangeEvent");
            }
            Ba ba = m6.f3135a;
            if (ba != null) {
                ba.a(str, "fireDeviceMuteChangeEvent(" + z + ");");
            }
        }
    }
}
