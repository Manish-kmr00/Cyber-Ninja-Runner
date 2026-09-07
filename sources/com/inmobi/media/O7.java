package com.inmobi.media;

import android.media.MediaPlayer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes6.dex */
public final class O7 extends MediaPlayer {
    public static final Object d = new Object();
    public static O7 e;
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3156a;
    public int b;
    public O7 c;

    public final void a() {
        if (3 == this.f3156a) {
            return;
        }
        synchronized (d) {
            int i = f;
            if (i < 5) {
                this.c = e;
                e = this;
                f = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
