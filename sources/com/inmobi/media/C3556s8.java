package com.inmobi.media;

import android.app.KeyguardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.InMobiVideoBridge;
import com.safedk.android.utils.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.s8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3556s8 extends TextureView implements MediaController.MediaPlayerControl {
    public static final String C = "s8";
    public final MediaPlayer.OnErrorListener A;
    public final TextureViewSurfaceTextureListenerC3541r8 B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f3427a;
    public Surface b;
    public O7 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public InterfaceC3500o8 i;
    public InterfaceC3486n8 j;
    public InterfaceC3472m8 k;
    public boolean l;
    public HandlerC3514p8 m;
    public C3456l8 n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public Handler s;
    public boolean t;
    public final C3485n7 u;
    public MediaPlayer.OnVideoSizeChangedListener v;
    public final C3528q8 w;
    public final MediaPlayer.OnCompletionListener x;
    public final MediaPlayer.OnInfoListener y;
    public final MediaPlayer.OnBufferingUpdateListener z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3556s8(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = Integer.MIN_VALUE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.u = new C3485n7(context2, this);
        requestLayout();
        invalidate();
        this.v = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                C3556s8.c(this.f$0, mediaPlayer, i, i2);
            }
        };
        this.w = new C3528q8(this);
        this.x = new MediaPlayer.OnCompletionListener() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/s8$$ExternalSyntheticLambda2;->onCompletion(Landroid/media/MediaPlayer;)V");
                CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.i, mediaPlayer, "media-player");
                safedk_s8$$ExternalSyntheticLambda2_onCompletion_87e3b8b3cd33be601b96d62111f90e4a(mediaPlayer);
            }

            public void safedk_s8$$ExternalSyntheticLambda2_onCompletion_87e3b8b3cd33be601b96d62111f90e4a(MediaPlayer p0) {
                C3556s8.a(this.f$0, p0);
            }
        };
        this.y = new MediaPlayer.OnInfoListener() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return C3556s8.b(this.f$0, mediaPlayer, i, i2);
            }
        };
        this.z = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                C3556s8.a(this.f$0, mediaPlayer, i);
            }
        };
        this.A = new MediaPlayer.OnErrorListener() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return C3556s8.a(this.f$0, mediaPlayer, i, i2);
            }
        };
        this.B = new TextureViewSurfaceTextureListenerC3541r8(this);
    }

    public static final void a(C3556s8 this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.d();
        } catch (Exception e) {
            String TAG = C;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static final void c(C3556s8 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this$0.f = videoHeight;
        if (this$0.e == 0 || videoHeight == 0) {
            return;
        }
        this$0.requestLayout();
    }

    private final void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    private final void setVideoURI(Uri uri) {
        this.f3427a = uri;
        e();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return this.p;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return this.q;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return this.r;
    }

    public final void d() {
        O7 o7 = this.c;
        if (o7 != null) {
            o7.f3156a = 5;
        }
        if (o7 != null) {
            o7.b = 5;
        }
        C3456l8 c3456l8 = this.n;
        if (c3456l8 != null) {
            c3456l8.c();
        }
        HandlerC3514p8 handlerC3514p8 = this.m;
        if (handlerC3514p8 != null) {
            handlerC3514p8.removeMessages(1);
        }
        Object tag = getTag();
        if (tag instanceof C3426j8) {
            C3426j8 c3426j8 = (C3426j8) tag;
            Object obj = c3426j8.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (!((Boolean) obj).booleanValue()) {
                c3426j8.t.put("didCompleteQ4", Boolean.TRUE);
                InterfaceC3500o8 interfaceC3500o8 = this.i;
                if (interfaceC3500o8 != null) {
                    ((H7) interfaceC3500o8).a((byte) 3);
                }
            }
            c3426j8.t.put("didSignalVideoCompleted", Boolean.TRUE);
            HashMap map = c3426j8.t;
            if (map != null) {
                Boolean bool = Boolean.FALSE;
                map.put("didCompleteQ1", bool);
                map.put("didCompleteQ2", bool);
                map.put("didCompleteQ3", bool);
                map.put("didPause", bool);
                map.put("didStartPlaying", bool);
                map.put("didQ4Fire", bool);
            }
            if (c3426j8.B) {
                start();
                return;
            }
            this.u.a();
            Object obj2 = c3426j8.t.get("isFullScreen");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj2).booleanValue()) {
                a(8, 0);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void e() {
        O7 o7;
        C3456l8 mediaController;
        byte bByteValue;
        O7 o7A;
        if (this.f3427a == null || this.b == null) {
            return;
        }
        if (this.c == null) {
            Object tag = getTag();
            C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 != null) {
                Object obj = c3426j8.t.get("placementType");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
                bByteValue = ((Byte) obj).byteValue();
            } else {
                bByteValue = 1;
            }
            if (1 == bByteValue) {
                o7A = new O7();
            } else {
                Object obj2 = O7.d;
                o7A = N7.a();
            }
            this.c = o7A;
            int i = this.d;
            if (i != 0) {
                o7A.setAudioSessionId(i);
            } else {
                this.d = o7A.getAudioSessionId();
            }
            try {
                O7 o8 = this.c;
                if (o8 != null) {
                    Context applicationContext = getContext().getApplicationContext();
                    Uri uri = this.f3427a;
                    Intrinsics.checkNotNull(uri);
                    o8.setDataSource(applicationContext, uri, (Map<String, String>) null);
                }
            } catch (IOException unused) {
                O7 o9 = this.c;
                if (o9 != null) {
                    o9.f3156a = -1;
                }
                if (o9 == null) {
                    return;
                }
                o9.b = -1;
                return;
            }
        }
        try {
            O7 o10 = this.c;
            if (o10 != null) {
                o10.setOnPreparedListener(this.w);
                o10.setOnVideoSizeChangedListener(this.v);
                o10.setOnCompletionListener(this.x);
                o10.setOnErrorListener(this.A);
                o10.setOnInfoListener(this.y);
                o10.setOnBufferingUpdateListener(this.z);
                InMobiVideoBridge.MediaPlayerSetSurface(o10, this.b);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                O7 o11 = this.c;
                if (o11 != null) {
                    o11.setAudioAttributes(this.u.e);
                }
            } else {
                O7 o12 = this.c;
                if (o12 != null) {
                    o12.setAudioStreamType(3);
                }
            }
            O7 o13 = this.c;
            if (o13 != null) {
                o13.prepareAsync();
            }
            this.o = 0;
            O7 o14 = this.c;
            if (o14 != null) {
                o14.f3156a = 1;
            }
            if (o14 != null && (mediaController = getMediaController()) != null) {
                mediaController.setMediaPlayer(this);
                mediaController.setEnabled(a());
                mediaController.d();
            }
            Object tag2 = getTag();
            if (tag2 instanceof C3426j8) {
                Object obj3 = ((C3426j8) tag2).t.get("shouldAutoPlay");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj3).booleanValue() && (o7 = this.c) != null) {
                    o7.b = 3;
                }
                Object obj4 = ((C3426j8) tag2).t.get("didCompleteQ4");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj4).booleanValue()) {
                    a(8, 0);
                    return;
                }
            }
            a(0, 0);
        } catch (Exception e) {
            O7 o15 = this.c;
            if (o15 != null) {
                o15.f3156a = -1;
            }
            if (o15 != null) {
                o15.b = -1;
            }
            this.A.onError(o15, 1, 0);
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void f() {
        Surface surface = this.b;
        if (surface != null) {
            surface.release();
        }
        this.b = null;
        g();
    }

    public final void g() {
        O7 o7;
        HandlerC3514p8 handlerC3514p8 = this.m;
        if (handlerC3514p8 != null) {
            handlerC3514p8.removeMessages(1);
        }
        C3485n7 c3485n7 = this.u;
        c3485n7.a();
        if (Build.VERSION.SDK_INT >= 26) {
            c3485n7.f = null;
        }
        c3485n7.g = null;
        Object tag = getTag();
        boolean z = tag instanceof C3426j8;
        if (z) {
            ((C3426j8) tag).t.put("seekPosition", Integer.valueOf(getCurrentPosition()));
        }
        O7 o8 = this.c;
        if (o8 != null) {
            o8.f3156a = 0;
        }
        if (o8 != null) {
            o8.b = 0;
        }
        if (o8 != null) {
            try {
                o8.reset();
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
        O7 o9 = this.c;
        if (o9 != null) {
            o9.setOnPreparedListener(null);
            o9.setOnVideoSizeChangedListener(null);
            o9.setOnCompletionListener(null);
            o9.setOnErrorListener(null);
            o9.setOnInfoListener(null);
            o9.setOnBufferingUpdateListener(null);
        }
        if (z) {
            Object obj = ((C3426j8) tag).t.get("placementType");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            if (((Byte) obj).byteValue() == 0 && (o7 = this.c) != null) {
                o7.a();
            }
        } else {
            O7 o10 = this.c;
            if (o10 != null) {
                o10.a();
            }
        }
        String TAG = C;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        this.c = null;
    }

    public final C3485n7 getAudioFocusManager$media_release() {
        return this.u;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.d == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.d = mediaPlayer.getAudioSessionId();
            InMobiVideoBridge.MediaPlayerRelease(mediaPlayer);
        }
        return this.d;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.c != null) {
            return this.o;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        O7 o7 = this.c;
        if (o7 == null || !a()) {
            return 0;
        }
        return o7.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        O7 o7 = this.c;
        if (o7 == null || !a()) {
            return -1;
        }
        return o7.getDuration();
    }

    public final int getLastVolume() {
        return this.h;
    }

    public final MediaPlayer.OnVideoSizeChangedListener getMSizeChangedListener() {
        return this.v;
    }

    public final C3456l8 getMediaController() {
        return this.n;
    }

    public final O7 getMediaPlayer() {
        return this.c;
    }

    public final boolean getPauseScheduled() {
        return this.t;
    }

    public final InterfaceC3486n8 getPlaybackEventListener() {
        return this.j;
    }

    public final InterfaceC3500o8 getQuartileCompletedListener() {
        return this.i;
    }

    public final int getState() {
        O7 o7 = this.c;
        if (o7 != null) {
            return o7.f3156a;
        }
        return 0;
    }

    public final int getVideoVolume() {
        if (isPlaying()) {
            return this.g;
        }
        return -1;
    }

    public final int getVolume() {
        if (a()) {
            return this.g;
        }
        return -1;
    }

    public final void h() {
        O7 o7 = this.c;
        if (o7 != null) {
            this.g = 0;
            if (o7 != null) {
                o7.setVolume(0.0f, 0.0f);
            }
            Object tag = getTag();
            if (tag instanceof C3426j8) {
                ((C3426j8) tag).t.put("currentMediaVolume", 0);
            }
        }
    }

    public final void i() {
        O7 o7 = this.c;
        if (o7 != null) {
            this.g = 1;
            if (o7 != null) {
                o7.setVolume(1.0f, 1.0f);
            }
            Object tag = getTag();
            if (tag instanceof C3426j8) {
                ((C3426j8) tag).t.put("currentMediaVolume", 15);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        O7 o7;
        return a() && (o7 = this.c) != null && o7.isPlaying();
    }

    public final void j() {
        O7 o7;
        if (a() && (o7 = this.c) != null && o7.isPlaying()) {
            O7 o8 = this.c;
            if (o8 != null) {
                InMobiVideoBridge.MediaPlayerPause(o8);
            }
            O7 o9 = this.c;
            if (o9 != null) {
                o9.seekTo(0);
            }
            this.u.a();
            Object tag = getTag();
            if (tag instanceof C3426j8) {
                C3426j8 c3426j8 = (C3426j8) tag;
                HashMap map = c3426j8.t;
                Boolean bool = Boolean.TRUE;
                map.put("didPause", bool);
                c3426j8.t.put("seekPosition", 0);
                c3426j8.t.put("didCompleteQ4", bool);
            }
            O7 o10 = this.c;
            if (o10 != null) {
                o10.f3156a = 4;
            }
            InterfaceC3486n8 interfaceC3486n8 = this.j;
            if (interfaceC3486n8 != null) {
                ((I7) interfaceC3486n8).a((byte) 4);
            }
        }
        O7 o11 = this.c;
        if (o11 == null) {
            return;
        }
        o11.b = 4;
    }

    public final void k() {
        if (this.c != null) {
            if (isPlaying()) {
                this.u.c();
            } else {
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r1 > r6) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.e     // Catch: java.lang.Exception -> L79
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)     // Catch: java.lang.Exception -> L79
            int r1 = r5.f     // Catch: java.lang.Exception -> L79
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)     // Catch: java.lang.Exception -> L79
            int r2 = r5.e     // Catch: java.lang.Exception -> L79
            if (r2 <= 0) goto L75
            int r2 = r5.f     // Catch: java.lang.Exception -> L79
            if (r2 <= 0) goto L75
            int r0 = android.view.View.MeasureSpec.getMode(r6)     // Catch: java.lang.Exception -> L79
            int r6 = android.view.View.MeasureSpec.getSize(r6)     // Catch: java.lang.Exception -> L79
            int r1 = android.view.View.MeasureSpec.getMode(r7)     // Catch: java.lang.Exception -> L79
            int r7 = android.view.View.MeasureSpec.getSize(r7)     // Catch: java.lang.Exception -> L79
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L3b
            if (r1 != r2) goto L3b
            int r0 = r5.e     // Catch: java.lang.Exception -> L79
            int r1 = r0 * r7
            int r2 = r5.f     // Catch: java.lang.Exception -> L79
            int r3 = r6 * r2
            if (r1 >= r3) goto L36
            int r3 = r3 / r0
            goto L73
        L36:
            if (r1 <= r3) goto L59
            int r0 = r1 / r2
            goto L5c
        L3b:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L4d
            int r0 = r5.f     // Catch: java.lang.Exception -> L79
            int r0 = r0 * r6
            int r2 = r5.e     // Catch: java.lang.Exception -> L79
            int r0 = r0 / r2
            if (r1 != r3) goto L4a
            if (r0 <= r7) goto L4a
            goto L59
        L4a:
            r1 = r0
        L4b:
            r0 = r6
            goto L75
        L4d:
            if (r1 != r2) goto L5e
            int r1 = r5.e     // Catch: java.lang.Exception -> L79
            int r1 = r1 * r7
            int r2 = r5.f     // Catch: java.lang.Exception -> L79
            int r1 = r1 / r2
            if (r0 != r3) goto L5b
            if (r1 <= r6) goto L5b
        L59:
            r1 = r7
            goto L4b
        L5b:
            r0 = r1
        L5c:
            r1 = r7
            goto L75
        L5e:
            int r2 = r5.e     // Catch: java.lang.Exception -> L79
            int r4 = r5.f     // Catch: java.lang.Exception -> L79
            if (r1 != r3) goto L6a
            if (r4 <= r7) goto L6a
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L6c
        L6a:
            r1 = r2
            r7 = r4
        L6c:
            if (r0 != r3) goto L5b
            if (r1 <= r6) goto L5b
            int r4 = r4 * r6
            int r3 = r4 / r2
        L73:
            r1 = r3
            goto L4b
        L75:
            r5.setMeasuredDimension(r0, r1)     // Catch: java.lang.Exception -> L79
            goto L80
        L79:
            java.lang.String r6 = com.inmobi.media.C3556s8.C
            java.lang.String r7 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3556s8.onMeasure(int, int):void");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        O7 o7;
        if (a() && (o7 = this.c) != null && o7.isPlaying()) {
            O7 o8 = this.c;
            if (o8 != null) {
                InMobiVideoBridge.MediaPlayerPause(o8);
            }
            O7 o9 = this.c;
            if (o9 != null) {
                o9.f3156a = 4;
            }
            this.u.a();
            Object tag = getTag();
            if (tag instanceof C3426j8) {
                C3426j8 c3426j8 = (C3426j8) tag;
                c3426j8.t.put("didPause", Boolean.TRUE);
                c3426j8.t.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            InterfaceC3486n8 interfaceC3486n8 = this.j;
            if (interfaceC3486n8 != null) {
                ((I7) interfaceC3486n8).a((byte) 2);
            }
        }
        O7 o10 = this.c;
        if (o10 != null) {
            o10.b = 4;
        }
        this.t = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
    }

    public final void setIsLockScreen(boolean z) {
        this.l = z;
    }

    public final void setLastVolume(int i) {
        this.h = i;
    }

    public final void setMSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Intrinsics.checkNotNullParameter(onVideoSizeChangedListener, "<set-?>");
        this.v = onVideoSizeChangedListener;
    }

    public final void setMediaController(C3456l8 c3456l8) {
        C3456l8 mediaController;
        if (c3456l8 != null) {
            this.n = c3456l8;
            if (this.c == null || (mediaController = getMediaController()) == null) {
                return;
            }
            mediaController.setMediaPlayer(this);
            mediaController.setEnabled(a());
            mediaController.d();
        }
    }

    public final void setMediaErrorListener(InterfaceC3472m8 interfaceC3472m8) {
        this.k = interfaceC3472m8;
    }

    public final void setPlaybackEventListener(InterfaceC3486n8 interfaceC3486n8) {
        this.j = interfaceC3486n8;
    }

    public final void setQuartileCompletedListener(InterfaceC3500o8 interfaceC3500o8) {
        this.i = interfaceC3500o8;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        boolean z;
        O7 o7;
        int iIntValue;
        HandlerC3514p8 handlerC3514p8;
        O7 o8;
        Object systemService = getContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        Object systemService2 = getContext().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.KeyguardManager");
        boolean zIsKeyguardLocked = ((KeyguardManager) systemService2).isKeyguardLocked();
        boolean zIsInteractive = ((PowerManager) systemService).isInteractive();
        boolean zA = a();
        Object tag = getTag();
        C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
        boolean z2 = false;
        if (c3426j8 != null) {
            Object obj = c3426j8.t.get("shouldAutoPlay");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        if (zA && !z) {
            a(8, 0);
        }
        if (zA && zIsInteractive && (o7 = this.c) != null && !o7.isPlaying() && z && (this.l || !zIsKeyguardLocked)) {
            if (c3426j8 != null) {
                Object obj2 = c3426j8.t.get("didCompleteQ4");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj2).booleanValue()) {
                    iIntValue = 0;
                } else {
                    Object obj3 = c3426j8.t.get("seekPosition");
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    iIntValue = ((Integer) obj3).intValue();
                }
            } else {
                iIntValue = 0;
            }
            if (c3426j8 != null ? c3426j8.c() : false) {
                this.u.c();
            } else {
                c();
            }
            if (a() && (o8 = this.c) != null) {
                o8.seekTo(iIntValue);
            }
            O7 o9 = this.c;
            if (o9 != null) {
                InMobiVideoBridge.MediaPlayerStart(o9);
            }
            O7 o10 = this.c;
            if (o10 != null) {
                o10.f3156a = 3;
            }
            a(8, 8);
            if (c3426j8 != null) {
                HashMap map = c3426j8.t;
                Boolean bool = Boolean.FALSE;
                map.put("didCompleteQ4", bool);
                Object obj4 = c3426j8.t.get("didPause");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj4).booleanValue()) {
                    InterfaceC3486n8 interfaceC3486n8 = this.j;
                    if (interfaceC3486n8 != null) {
                        ((I7) interfaceC3486n8).a((byte) 3);
                    }
                    c3426j8.t.put("didPause", bool);
                } else {
                    InterfaceC3486n8 interfaceC3486n9 = this.j;
                    if (interfaceC3486n9 != null) {
                        ((I7) interfaceC3486n9).a((byte) 1);
                    }
                }
                HandlerC3514p8 handlerC3514p9 = this.m;
                if (handlerC3514p9 != null && !handlerC3514p9.hasMessages(1)) {
                    z2 = true;
                }
                if (z2 && (handlerC3514p8 = this.m) != null) {
                    handlerC3514p8.sendEmptyMessage(1);
                }
            }
            C3456l8 c3456l8 = this.n;
            if (c3456l8 != null) {
                c3456l8.d();
            }
        }
        O7 o11 = this.c;
        if (o11 == null) {
            return;
        }
        o11.b = 3;
    }

    public static final boolean b(C3556s8 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (3 != i) {
            return true;
        }
        this$0.a(8, 8);
        return true;
    }

    public final void b() {
        try {
            if (this.f3427a != null) {
                C3517pb.a(new Runnable() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3556s8.a(this.f$0);
                    }
                });
            }
        } catch (Exception unused) {
            String TAG = C;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public final void c() {
        if (this.c != null) {
            this.u.a();
            h();
        }
    }

    public static final void a(C3556s8 this$0, MediaPlayer mediaPlayer, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o = i;
    }

    public static final boolean a(C3556s8 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String TAG = C;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        InterfaceC3472m8 interfaceC3472m8 = this$0.k;
        if (interfaceC3472m8 != null) {
            J7 j7 = (J7) interfaceC3472m8;
            C3313b7 c3313b7 = j7.f3106a.b;
            if (!c3313b7.t && (c3313b7 instanceof C3398h8)) {
                try {
                    ((C3398h8) c3313b7).a(j7.b, i);
                } catch (Exception e) {
                    L7 l7 = j7.f3106a;
                    L4 l4 = l7.f;
                    if (l4 != null) {
                        String str = l7.g;
                        ((M4) l4).b(str, ld.a(e, O5.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in handling the onVideoError event; ")));
                    }
                }
            }
        }
        O7 o7 = this$0.c;
        if (o7 != null) {
            o7.f3156a = -1;
        }
        if (o7 != null) {
            o7.b = -1;
        }
        C3456l8 c3456l8 = this$0.n;
        if (c3456l8 != null) {
            c3456l8.c();
        }
        this$0.b();
        return true;
    }

    public static final void b(C3556s8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pause();
    }

    public static final void a(C3556s8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String diskUrl = String.valueOf(this$0.f3427a);
        W0 w0A = AbstractC3415ib.a();
        w0A.getClass();
        Intrinsics.checkNotNullParameter(diskUrl, "diskUrl");
        ArrayList arrayListA = D1.a(w0A, "disk_uri=? ", new String[]{diskUrl}, null, null, "created_ts DESC ", 1, 12);
        C3417j c3417j = arrayListA.isEmpty() ? null : (C3417j) arrayListA.get(0);
        int iNextInt = new Random().nextInt() & Integer.MAX_VALUE;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (c3417j != null) {
            String url = c3417j.b;
            Intrinsics.checkNotNullParameter(url, "url");
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            if (url == null) {
                url = "";
            }
            AbstractC3415ib.a().a(new C3417j(iNextInt, url, null, 0, jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3, 0L));
        }
    }

    public final boolean a() {
        O7 o7 = this.c;
        if (o7 == null) {
            return true;
        }
        int i = o7.f3156a;
        return (i == -1 || i == 0 || i == 1) ? false : true;
    }

    public final void a(int i) {
        if (this.t || 4 == getState()) {
            return;
        }
        if (this.s == null) {
            this.s = new Handler(Looper.getMainLooper());
        }
        if (i > 0) {
            this.t = true;
            c();
            Handler handler = this.s;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3556s8.b(this.f$0);
                    }
                }, i * 1000);
                return;
            }
            return;
        }
        pause();
    }

    public final void a(int i, int i2) {
        if (this.c != null) {
            ViewParent parent = getParent();
            C3570t8 c3570t8 = parent instanceof C3570t8 ? (C3570t8) parent : null;
            ProgressBar progressBar = c3570t8 != null ? c3570t8.getProgressBar() : null;
            if (progressBar != null) {
                progressBar.setVisibility(i);
            }
            ViewParent parent2 = getParent();
            C3570t8 c3570t9 = parent2 instanceof C3570t8 ? (C3570t8) parent2 : null;
            ImageView posterImage = c3570t9 != null ? c3570t9.getPosterImage() : null;
            if (posterImage == null) {
                return;
            }
            posterImage.setVisibility(i2);
        }
    }
}
