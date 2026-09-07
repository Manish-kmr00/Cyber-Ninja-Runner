package com.fyber.inneractive.sdk.web;

import android.widget.Toast;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3282v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2424a;

    public RunnableC3282v(String str) {
        this.f2424a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(AbstractC3251o.f2370a, this.f2424a, 0).show();
    }
}
