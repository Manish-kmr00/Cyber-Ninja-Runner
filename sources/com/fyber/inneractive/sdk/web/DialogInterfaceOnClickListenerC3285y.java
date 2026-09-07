package com.fyber.inneractive.sdk.web;

import android.content.DialogInterface;
import android.os.Environment;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import java.io.File;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class DialogInterfaceOnClickListenerC3285y implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2427a;
    public final /* synthetic */ I b;

    public DialogInterfaceOnClickListenerC3285y(I i, String str) {
        this.b = i;
        this.f2427a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        I i2 = this.b;
        String str = this.f2427a;
        i2.getClass();
        new File(Environment.getExternalStorageDirectory(), "Pictures").mkdirs();
        com.fyber.inneractive.sdk.flow.x xVar = i2.s;
        IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.b0(new C3284x(i2), str, xVar != null ? xVar.c : null));
    }
}
