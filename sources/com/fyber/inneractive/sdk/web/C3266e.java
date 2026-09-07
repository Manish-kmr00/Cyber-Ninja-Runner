package com.fyber.inneractive.sdk.web;

import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.util.RunnableC3240d;
import com.fyber.inneractive.sdk.util.RunnableC3241e;
import com.fyber.inneractive.sdk.util.ThreadFactoryC3238b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3266e {
    public RunnableC3241e c;
    public RunnableC3240d d;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ AbstractC3270i l;
    public Handler b = null;
    public final Object e = new Object();
    public boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f2406a = Executors.newSingleThreadExecutor(new ThreadFactoryC3238b());

    public C3266e(j0 j0Var, String str, boolean z, String str2, String str3, String str4) {
        this.l = j0Var;
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = str3;
        this.k = str4;
    }

    public final Handler a() {
        if (this.b == null) {
            synchronized (this.e) {
                this.b = new Handler(Looper.getMainLooper());
            }
        }
        return this.b;
    }
}
