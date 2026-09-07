package com.yandex.mobile.ads.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
final class ph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9926a;
    private final a b;
    private boolean c;

    public interface b {
    }

    public final void a() {
        if (this.c) {
            this.f9926a.unregisterReceiver(this.b);
            this.c = false;
        }
    }

    public ph(Context context, Handler handler, b bVar) {
        this.f9926a = context.getApplicationContext();
        this.b = new a(handler, bVar);
    }

    private final class a extends BroadcastReceiver implements Runnable {
        private final b b;
        private final Handler c;

        public a(Handler handler, b bVar) {
            this.c = handler;
            this.b = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.c.post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ph.this.c) {
                ((o60.b) this.b).c();
            }
        }
    }
}
