package com.json.sdk.controller;

import android.app.Activity;
import android.media.AudioManager;
import com.json.hg;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;

/* JADX INFO: loaded from: classes11.dex */
class t {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f4351a;

        a(AudioManager audioManager) {
            this.f4351a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a(this.f4351a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f4352a;

        b(AudioManager audioManager) {
            this.f4352a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.d(this.f4352a);
        }
    }

    t() {
    }

    public static void a(Activity activity) {
        hg.f3748a.b(new a((AudioManager) activity.getSystemService("audio")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AudioManager audioManager) {
        try {
            audioManager.abandonAudioFocus(null);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public static void b(Activity activity) {
        hg.f3748a.b(new b((AudioManager) activity.getSystemService("audio")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(AudioManager audioManager) {
        try {
            audioManager.requestAudioFocus(null, 3, 2);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
