package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3827q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8296a;
    private final AudioManager b;
    private C3823o c;

    public C3827q(Context context) {
        this.f8296a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.f8296a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC3825p interfaceC3825p) {
        this.c = new C3823o(new Handler(Looper.getMainLooper()), this.b, interfaceC3825p);
        this.f8296a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}
