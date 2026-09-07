package com.fyber.inneractive.sdk.player.controller;

import android.view.TextureView;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1956a;

    public h(i iVar) {
        this.f1956a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.f1956a.f1957a;
        x xVar = qVar.d;
        if (xVar != null) {
            TextureView textureView = qVar.j;
            z zVar = xVar.f1969a;
            zVar.getClass();
            IAlog.a("%s onTextureViewDestroyed", IAlog.a(zVar));
        }
    }
}
