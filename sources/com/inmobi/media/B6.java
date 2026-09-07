package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.VideoView;
import com.google.common.base.Ascii;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.InMobiVideoBridge;
import com.safedk.android.utils.Logger;
import io.ktor.util.date.GMTDateParser;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public final class B6 extends VideoView implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L4 f3033a;
    public C3652z6 b;
    public ViewGroup c;
    public A6 d;
    public boolean e;
    public final WeakReference f;
    public int g;
    public String h;
    public String i;
    public int j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B6(Activity activity, L4 l4) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3033a = l4;
        setZOrderOnTop(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 28) {
            setDrawingCacheEnabled(true);
        }
        this.g = 100;
        this.j = -1;
        this.k = 0;
        this.f = new WeakReference(activity);
        C3517pb.a(activity, this);
    }

    public static final void a(B6 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", ">>> onVideoSizeChanged");
        }
        if (this$0.b == null) {
            C3652z6 c3652z6 = new C3652z6(this$0.getContext());
            this$0.b = c3652z6;
            c3652z6.setAnchorView(this$0);
            this$0.setMediaController(this$0.b);
            this$0.requestLayout();
            this$0.requestFocus();
        }
    }

    private void safedk_videoview_B6_VideoViewPlay_1cd25093e0b187dede2869d94281a264() {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/inmobi/media/B6;->safedk_videoview_B6_VideoViewPlay_1cd25093e0b187dede2869d94281a264()V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewPlay: player " + this + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                CreativeInfoManager.a(com.safedk.android.utils.h.i, (Object) this);
                CreativeInfoManager.a(com.safedk.android.utils.h.i, BrandSafetyUtils.a(this), false, "video-view");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewPlay: " + e.getMessage());
            }
        }
        super.start();
    }

    public final void b() {
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", "Release the media render view");
        }
        InMobiVideoBridge.VideoViewStop(this);
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            ViewParent parent = viewGroup.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.c);
            }
            ViewParent parent2 = getParent();
            ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup3 != null) {
                viewGroup3.removeView(this);
            }
            setBackgroundColor(0);
            this.c = null;
        }
        setMediaController(null);
        this.b = null;
        A6 a6 = this.d;
        if (a6 != null) {
            Intrinsics.checkNotNullParameter(this, "mp");
            L4 l5 = ((L6) a6).f3124a.b;
            if (l5 != null) {
                ((M4) l5).a("MraidMediaProcessor", ">>> onPlayerCompleted");
            }
            ViewGroup viewContainer = getViewContainer();
            if (viewContainer != null) {
                ViewParent parent3 = viewContainer.getParent();
                ViewGroup viewGroup4 = parent3 instanceof ViewGroup ? (ViewGroup) parent3 : null;
                if (viewGroup4 != null) {
                    viewGroup4.removeView(viewContainer);
                }
            }
            setViewContainer(null);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final int getCurrentAudioVolume() {
        return this.g;
    }

    @Override // android.view.View
    public final String getId() {
        return this.h;
    }

    public final A6 getListener() {
        return this.d;
    }

    public final int getMCurrentPosition() {
        return this.k;
    }

    public final String getPlaybackUrl() {
        return this.i;
    }

    public final int getPreviousPosition() {
        return this.j;
    }

    public final ViewGroup getViewContainer() {
        return this.c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f.get() == null || !Intrinsics.areEqual(this.f.get(), activity)) {
            return;
        }
        this.e = false;
        start();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = (Activity) this.f.get();
        if (activity2 == null || !Intrinsics.areEqual(activity2, activity)) {
            return;
        }
        this.e = true;
        if (getCurrentPosition() != 0) {
            this.k = getCurrentPosition();
        }
        pause();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/B6;->onCompletion(Landroid/media/MediaPlayer;)V");
        CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.i, mediaPlayer, "media-player");
        safedk_B6_onCompletion_abc2319600b764933ef87e94f7454dc8(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mp, int i, int i2) {
        Intrinsics.checkNotNullParameter(mp, "mp");
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).b("MediaRenderView", ">>> onError (" + i + ", " + i2 + ')');
        }
        b();
        return false;
    }

    @Override // android.widget.VideoView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHolder().setSizeFromLayout();
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mp) {
        Intrinsics.checkNotNullParameter(mp, "mp");
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", ">>> onPrepared");
        }
        mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.inmobi.media.B6$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                B6.a(this.f$0, mediaPlayer, i, i2);
            }
        });
        int i = this.k;
        if (i < getDuration()) {
            this.k = i;
            seekTo(i);
        }
        A6 a6 = this.d;
        if (a6 != null) {
            Intrinsics.checkNotNullParameter(this, "mp");
            L4 l5 = ((L6) a6).f3124a.b;
            if (l5 != null) {
                ((M4) l5).a("MraidMediaProcessor", ">>> onPlayerPrepared");
            }
        }
        start();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        Context contextD;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onVisibilityChanged(view, i);
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", ">>> onVisibilityChanged (" + i + ')');
        }
        if (i != 0 || (contextD = C3517pb.d()) == null) {
            return;
        }
        setBackground(new BitmapDrawable(contextD.getResources(), (Bitmap) null));
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", ">>> onWindowVisibilityChanged (" + i + ')');
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", "Pause media playback");
        }
        super.pause();
    }

    public void safedk_B6_onCompletion_abc2319600b764933ef87e94f7454dc8(MediaPlayer mp) {
        Intrinsics.checkNotNullParameter(mp, "mp");
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", ">>> onCompletion");
        }
    }

    public final void setAudioMuted(boolean z) {
    }

    public final void setCurrentAudioVolume(int i) {
        this.g = i;
    }

    public final void setId(String str) {
        this.h = str;
    }

    public final void setListener(A6 a6) {
        this.d = a6;
    }

    public final void setMCurrentPosition(int i) {
        this.k = i;
    }

    public final void setPlaybackUrl(String str) {
        this.i = str;
    }

    public final void setPlayerPrepared(boolean z) {
    }

    public final void setPreviousPosition(int i) {
        this.j = i;
    }

    public final void setViewContainer(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (this.e) {
            return;
        }
        L4 l4 = this.f3033a;
        if (l4 != null) {
            ((M4) l4).a("MediaRenderView", "Start media playback");
        }
        safedk_videoview_B6_VideoViewPlay_1cd25093e0b187dede2869d94281a264();
    }

    public final void setPlaybackData(String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        byte[] bytes = url.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            if (((byte) (b & (-128))) > 0) {
                StringBuilder sbAppend = sb.append("%");
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
                sbAppend.append(new String(new char[]{cArr[(b >> 4) & 15], cArr[(byte) (b & Ascii.SI)]}));
            } else {
                sb.append((char) b);
            }
        }
        try {
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes2 = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            str = new String(bytes2, Charsets.ISO_8859_1);
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        this.i = str;
        this.h = "anonymous";
    }

    public final void a() {
        InMobiVideoBridge.VideoViewSetVideoPath(this, this.i);
        setOnCompletionListener(this);
        setOnPreparedListener(this);
        setOnErrorListener(this);
        if (this.b == null) {
            C3652z6 c3652z6 = new C3652z6(getContext());
            this.b = c3652z6;
            c3652z6.setAnchorView(this);
            setMediaController(this.b);
        }
    }
}
