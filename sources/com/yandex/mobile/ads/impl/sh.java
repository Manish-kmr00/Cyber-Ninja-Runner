package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
final class sh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f10206a;
    private final a b;
    private b c;
    private oh d;
    private int f;
    private AudioFocusRequest h;
    private float g = 1.0f;
    private int e = 0;

    public interface b {
    }

    public final void d() {
        if (x82.a(this.d, (Object) null)) {
            return;
        }
        this.d = null;
        this.f = 0;
    }

    public sh(Context context, Handler handler, b bVar) {
        this.f10206a = (AudioManager) hg.a((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.c = bVar;
        this.b = new a(handler);
    }

    public final float b() {
        return this.g;
    }

    public final void c() {
        this.c = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e == 0) {
            return;
        }
        if (x82.f10629a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                this.f10206a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f10206a.abandonAudioFocus(this.b);
        }
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f10207a;

        public a(Handler handler) {
            this.f10207a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            oh ohVar;
            sh shVar = sh.this;
            if (i == -3 || i == -2) {
                if (i != -2 && ((ohVar = shVar.d) == null || ohVar.b != 1)) {
                    shVar.a(3);
                    return;
                }
                b bVar = shVar.c;
                if (bVar != null) {
                    ((o60.b) bVar).a(0);
                }
                shVar.a(2);
                return;
            }
            if (i == -1) {
                b bVar2 = shVar.c;
                if (bVar2 != null) {
                    ((o60.b) bVar2).a(-1);
                }
                shVar.a();
                return;
            }
            if (i != 1) {
                shVar.getClass();
                at0.d("AudioFocusManager", "Unknown focus change type: " + i);
                return;
            }
            shVar.a(1);
            b bVar3 = shVar.c;
            if (bVar3 != null) {
                ((o60.b) bVar3).a(1);
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            this.f10207a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.sh$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            ((o60.b) bVar).e();
        }
    }

    public final int a(boolean z, int i) {
        int iRequestAudioFocus;
        AudioFocusRequest.Builder builder;
        if (i == 1 || this.f != 1) {
            a();
            return z ? 1 : -1;
        }
        if (!z) {
            return -1;
        }
        if (this.e != 1) {
            if (x82.f10629a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    if (audioFocusRequest == null) {
                        builder = new AudioFocusRequest.Builder(this.f);
                    } else {
                        builder = new AudioFocusRequest.Builder(this.h);
                    }
                    oh ohVar = this.d;
                    boolean z2 = ohVar != null && ohVar.b == 1;
                    ohVar.getClass();
                    this.h = builder.setAudioAttributes(ohVar.a().f9816a).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(this.b).build();
                }
                iRequestAudioFocus = this.f10206a.requestAudioFocus(this.h);
            } else {
                AudioManager audioManager = this.f10206a;
                a aVar = this.b;
                oh ohVar2 = this.d;
                ohVar2.getClass();
                iRequestAudioFocus = audioManager.requestAudioFocus(aVar, x82.c(ohVar2.d), this.f);
            }
            if (iRequestAudioFocus == 1) {
                a(1);
            } else {
                a(0);
                return -1;
            }
        }
        return 1;
    }
}
