package com.five_corp.ad.internal.system;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1543a;

    static {
        e.class.toString();
    }

    public e(Context context) {
        this.f1543a = context;
    }

    public final boolean a() {
        try {
            return ((ConnectivityManager) this.f1543a.getSystemService("connectivity")).isActiveNetworkMetered();
        } catch (Throwable unused) {
            return false;
        }
    }
}
