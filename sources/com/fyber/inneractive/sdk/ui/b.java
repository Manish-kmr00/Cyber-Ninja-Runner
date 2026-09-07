package com.fyber.inneractive.sdk.ui;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.network.E;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifierLocal f2334a;

    public b(FyberAdIdentifierLocal fyberAdIdentifierLocal) {
        this.f2334a = fyberAdIdentifierLocal;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        Bitmap bitmap = (Bitmap) obj;
        if (exc != null || bitmap == null) {
            return;
        }
        this.f2334a.r = bitmap;
    }
}
