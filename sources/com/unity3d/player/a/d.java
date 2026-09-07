package com.unity3d.player.a;

import android.content.Context;
import android.net.ConnectivityManager;
import com.unity3d.player.C;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends C {
    private int b;
    private final ConnectivityManager.NetworkCallback c;

    public d(Context context) {
        super(context);
        this.b = 0;
        c cVar = new c(this);
        this.c = cVar;
        if (this.f8207a == null) {
            return;
        }
        this.b = super.b();
        this.f8207a.registerDefaultNetworkCallback(cVar);
    }

    @Override // com.unity3d.player.C
    public final void a() {
        ConnectivityManager connectivityManager = this.f8207a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.c);
    }

    @Override // com.unity3d.player.C
    public final int b() {
        return this.b;
    }
}
