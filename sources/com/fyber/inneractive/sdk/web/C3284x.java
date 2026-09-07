package com.fyber.inneractive.sdk.web;

import android.media.MediaScannerConnection;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3284x implements com.fyber.inneractive.sdk.network.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2426a;

    public C3284x(I i) {
        this.f2426a = i;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (exc != null || TextUtils.isEmpty(str)) {
            com.fyber.inneractive.sdk.util.r.b.post(new RunnableC3283w(this));
            return;
        }
        I i = this.f2426a;
        if (AbstractC3251o.a(i.b) != null) {
            A a2 = new A(str);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(AbstractC3251o.a(i.b).getApplicationContext(), a2);
            a2.b = mediaScannerConnection;
            mediaScannerConnection.connect();
        }
    }
}
