package com.chartboost.sdk.impl;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public final class dd extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f999a;
    public final AudioManager b;
    public final ac c;
    public final sc d;
    public float e;

    public dd(Handler handler, Context context, ac acVar, sc scVar) {
        super(handler);
        this.f999a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = acVar;
        this.d = scVar;
    }

    public final float a() {
        return this.c.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    public final void b() {
        this.d.a(this.e);
    }

    public void c() {
        this.e = a();
        b();
        this.f999a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f999a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float fA = a();
        if (a(fA)) {
            this.e = fA;
            b();
        }
    }

    public final boolean a(float f) {
        return f != this.e;
    }
}
