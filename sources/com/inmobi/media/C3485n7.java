package com.inmobi.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.n7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3485n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3382a;
    public final C3556s8 b;
    public boolean c;
    public final Object d;
    public final AudioAttributes e;
    public AudioFocusRequest f;
    public AudioManager.OnAudioFocusChangeListener g;

    public C3485n7(Context context, C3556s8 audioFocusListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(audioFocusListener, "audioFocusListener");
        this.f3382a = context;
        this.b = audioFocusListener;
        this.d = new Object();
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "build(...)");
        this.e = audioAttributesBuild;
    }

    public final void a() {
        synchronized (this.d) {
            Object systemService = this.f3382a.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    AudioFocusRequest audioFocusRequest = this.f;
                    if (audioFocusRequest != null) {
                        audioManager.abandonAudioFocusRequest(audioFocusRequest);
                    }
                } else {
                    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.g;
                    if (onAudioFocusChangeListener != null) {
                        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final AudioManager.OnAudioFocusChangeListener b() {
        return new AudioManager.OnAudioFocusChangeListener() { // from class: com.inmobi.media.n7$$ExternalSyntheticLambda0
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                C3485n7.a(this.f$0, i);
            }
        };
    }

    public final void c() {
        int iRequestAudioFocus;
        synchronized (this.d) {
            Object systemService = this.f3382a.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                if (this.g == null) {
                    this.g = b();
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    if (this.f == null) {
                        AudioFocusRequest.Builder audioAttributes = new AudioFocusRequest.Builder(2).setAudioAttributes(this.e);
                        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.g;
                        Intrinsics.checkNotNull(onAudioFocusChangeListener);
                        AudioFocusRequest audioFocusRequestBuild = audioAttributes.setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(Looper.getMainLooper())).build();
                        Intrinsics.checkNotNullExpressionValue(audioFocusRequestBuild, "build(...)");
                        this.f = audioFocusRequestBuild;
                    }
                    AudioFocusRequest audioFocusRequest = this.f;
                    Intrinsics.checkNotNull(audioFocusRequest);
                    iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequest);
                } else {
                    iRequestAudioFocus = audioManager.requestAudioFocus(this.g, 3, 2);
                }
            } else {
                iRequestAudioFocus = 0;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (iRequestAudioFocus == 1) {
            C3556s8 c3556s8 = this.b;
            c3556s8.i();
            C3456l8 c3456l8 = c3556s8.n;
            if (c3456l8 == null || c3456l8.d == null) {
                return;
            }
            c3456l8.j = false;
            c3456l8.i.removeView(c3456l8.g);
            c3456l8.i.removeView(c3456l8.f);
            c3456l8.a();
            return;
        }
        C3556s8 c3556s9 = this.b;
        c3556s9.h();
        C3456l8 c3456l9 = c3556s9.n;
        if (c3456l9 == null || c3456l9.d == null) {
            return;
        }
        c3456l9.j = true;
        c3456l9.i.removeView(c3456l9.f);
        c3456l9.i.removeView(c3456l9.g);
        c3456l9.b();
    }

    public static final void a(C3485n7 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == -2) {
            synchronized (this$0.d) {
                this$0.c = true;
                Unit unit = Unit.INSTANCE;
            }
            C3556s8 c3556s8 = this$0.b;
            c3556s8.h();
            C3456l8 c3456l8 = c3556s8.n;
            if (c3456l8 == null || c3456l8.d == null) {
                return;
            }
            c3456l8.j = true;
            c3456l8.i.removeView(c3456l8.f);
            c3456l8.i.removeView(c3456l8.g);
            c3456l8.b();
            return;
        }
        if (i == -1) {
            synchronized (this$0.d) {
                this$0.c = false;
                Unit unit2 = Unit.INSTANCE;
            }
            C3556s8 c3556s9 = this$0.b;
            c3556s9.h();
            C3456l8 c3456l9 = c3556s9.n;
            if (c3456l9 == null || c3456l9.d == null) {
                return;
            }
            c3456l9.j = true;
            c3456l9.i.removeView(c3456l9.f);
            c3456l9.i.removeView(c3456l9.g);
            c3456l9.b();
            return;
        }
        if (i != 1) {
            return;
        }
        synchronized (this$0.d) {
            if (this$0.c) {
                C3556s8 c3556s10 = this$0.b;
                if (c3556s10.isPlaying()) {
                    c3556s10.i();
                    C3456l8 c3456l10 = c3556s10.n;
                    if (c3456l10 != null && c3456l10.d != null) {
                        c3456l10.j = false;
                        c3456l10.i.removeView(c3456l10.g);
                        c3456l10.i.removeView(c3456l10.f);
                        c3456l10.a();
                    }
                }
            }
            this$0.c = false;
            Unit unit3 = Unit.INSTANCE;
        }
    }
}
