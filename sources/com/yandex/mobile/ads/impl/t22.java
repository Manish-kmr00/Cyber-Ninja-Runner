package com.yandex.mobile.ads.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes9.dex */
final class t22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10262a;
    private final Handler b;
    private final a c;
    private final AudioManager d;
    private b e;
    private int f;
    private int g;
    private boolean h;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class b extends BroadcastReceiver {
        /* JADX INFO: Access modifiers changed from: private */
        public static void a(t22 t22Var) {
            int iB = t22.b(t22Var.d, t22Var.f);
            boolean zA = t22.a(t22Var.d, t22Var.f);
            if (t22Var.g == iB && t22Var.h == zA) {
                return;
            }
            t22Var.g = iB;
            t22Var.h = zA;
            ((o60.b) t22Var.c).a(zA, iB);
        }

        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            final t22 t22Var = t22.this;
            t22Var.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.t22$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    t22.b.a(t22Var);
                }
            });
        }
    }

    public t22(Context context, Handler handler, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f10262a = applicationContext;
        this.b = handler;
        this.c = aVar;
        AudioManager audioManager = (AudioManager) hg.a((AudioManager) applicationContext.getSystemService("audio"));
        this.d = audioManager;
        this.f = 3;
        this.g = b(audioManager, 3);
        this.h = a(audioManager, this.f);
        b bVar = new b();
        try {
            applicationContext.registerReceiver(bVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = bVar;
        } catch (RuntimeException e) {
            at0.b("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public final int a() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public final void c() {
        b bVar = this.e;
        if (bVar != null) {
            try {
                this.f10262a.unregisterReceiver(bVar);
            } catch (RuntimeException e) {
                at0.b("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            at0.b("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public final void a(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        int iB = b(this.d, i);
        boolean zA = a(this.d, this.f);
        if (this.g != iB || this.h != zA) {
            this.g = iB;
            this.h = zA;
            ((o60.b) this.c).a(zA, iB);
        }
        ((o60.b) this.c).d();
    }

    public final int b() {
        if (x82.f10629a >= 28) {
            return this.d.getStreamMinVolume(this.f);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AudioManager audioManager, int i) {
        if (x82.f10629a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return b(audioManager, i) == 0;
    }
}
