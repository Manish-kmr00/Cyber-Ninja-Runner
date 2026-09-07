package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes11.dex */
public final class lo2 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9550a;
    private final AudioManager b;
    private final un2 c;
    private final ho2 d;
    private float e;

    public lo2(Handler handler, Context context, un2 un2Var, ho2 ho2Var) {
        super(handler);
        this.f9550a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = un2Var;
        this.d = ho2Var;
    }

    private float c() {
        int streamVolume = this.b.getStreamVolume(3);
        int streamMaxVolume = this.b.getStreamMaxVolume(3);
        this.c.getClass();
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = streamVolume / streamMaxVolume;
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public final void a() {
        float fC = c();
        this.e = fC;
        ((to2) this.d).a(fC);
        this.f9550a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void b() {
        this.f9550a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float fC = c();
        if (fC != this.e) {
            this.e = fC;
            ((to2) this.d).a(fC);
        }
    }
}
