package io.bidmachine.iab.vast.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.json.cc;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import com.safedk.android.internal.partials.BidMachineVideoBridge;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.mraid.MraidInterstitial;
import io.bidmachine.iab.mraid.MraidInterstitialListener;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.IabCloseWrapper;
import io.bidmachine.iab.utils.IabCountDownWrapper;
import io.bidmachine.iab.utils.IabCtaWrapper;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.IabElementWrapper;
import io.bidmachine.iab.utils.IabLoadingWrapper;
import io.bidmachine.iab.utils.IabMuteWrapper;
import io.bidmachine.iab.utils.IabProgressWrapper;
import io.bidmachine.iab.utils.IabRepeatWrapper;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastExtension;
import io.bidmachine.iab.vast.VastHelper;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastPlaybackListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastRequestManager;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.VastVideoLoadedListener;
import io.bidmachine.iab.vast.VastViewListener;
import io.bidmachine.iab.vast.VideoType;
import io.bidmachine.iab.vast.processor.VastAd;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.PostBannerTag;
import io.bidmachine.iab.vast.view.IabVideoTexture;
import io.bidmachine.iab.view.CloseableLayout;
import io.bidmachine.rendering.model.PrivacySheetParams;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class VastView extends RelativeLayout implements IabClickCallback {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final List O;
    private final List P;
    private final Runnable Q;
    private final Runnable R;
    private final a0 S;
    private final a0 T;
    private final LinkedList U;
    private int V;
    private float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12276a;
    private final a0 a0;
    IabVideoTexture b;
    private final TextureView.SurfaceTextureListener b0;
    FrameLayout c;
    private final MediaPlayer.OnCompletionListener c0;
    Surface d;
    private final MediaPlayer.OnErrorListener d0;
    FrameLayout e;
    private final MediaPlayer.OnPreparedListener e0;
    CloseableLayout f;
    private final MediaPlayer.OnVideoSizeChangedListener f0;
    IabCloseWrapper g;
    private VastHelper.OnScreenStateChangeListener g0;
    IabCountDownWrapper h;
    private final View.OnTouchListener h0;
    IabRepeatWrapper i;
    private final WebChromeClient i0;
    IabMuteWrapper j;
    private final WebViewClient j0;
    IabLoadingWrapper k;
    IabProgressWrapper l;
    IabCtaWrapper m;
    MediaPlayer n;
    View o;
    CompanionTag p;
    CompanionTag q;
    ImageView r;
    MraidInterstitial s;
    VastRequest t;
    b0 u;
    private VastViewListener v;
    private VastPlaybackListener w;
    private VastAdMeasurer x;
    private MraidAdMeasurer y;
    private y z;

    private static class PostBannerAdMeasurer implements MraidAdMeasurer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VastView f12277a;
        private final MraidAdMeasurer b;

        public PostBannerAdMeasurer(VastView vastView, MraidAdMeasurer mraidAdMeasurer) {
            this.f12277a = vastView;
            this.b = mraidAdMeasurer;
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdClicked() {
            this.b.onAdClicked();
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdShown() {
            this.b.onAdShown();
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onError(IabError iabError) {
            this.b.onError(iabError);
        }

        @Override // io.bidmachine.iab.measurer.MraidAdMeasurer
        public String prepareCreativeForMeasure(String html) {
            return this.b.prepareCreativeForMeasure(html);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void registerAdContainer(ViewGroup container) {
            this.b.registerAdContainer(this.f12277a);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdViewReady(WebView webView) {
            this.b.onAdViewReady(webView);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void registerAdView(WebView webView) {
            this.b.registerAdView(webView);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastView.this.isPlaybackStarted()) {
                VastView.this.d();
            }
        }
    }

    private interface a0 {
        void a(int i, int i2, float f);
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VastView.this.isPlaybackStarted() && VastView.this.n.isPlaying()) {
                    int duration = VastView.this.n.getDuration();
                    int currentPosition = VastView.this.n.getCurrentPosition();
                    if (currentPosition > 0) {
                        float f = (currentPosition * 100.0f) / duration;
                        VastView.this.S.a(duration, currentPosition, f);
                        VastView.this.T.a(duration, currentPosition, f);
                        VastView.this.a0.a(duration, currentPosition, f);
                        if (f > 105.0f) {
                            VastLog.e(VastView.this.f12276a, "Playback tracking: video hang detected", new Object[0]);
                            VastView.this.g();
                        }
                    }
                }
            } catch (Exception e) {
                VastLog.e(VastView.this.f12276a, "Playback tracking exception: %s", e.getMessage());
            }
            VastView.this.postDelayed(this, 16L);
        }
    }

    static class b0 implements Parcelable {
        public static final Parcelable.Creator<b0> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f12280a;
        float b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b0 createFromParcel(Parcel parcel) {
                return new b0(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b0[] newArray(int i) {
                return new b0[i];
            }
        }

        b0() {
            this.f12280a = null;
            this.b = 5.0f;
            this.c = 0;
            this.d = 0;
            this.e = true;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = true;
            this.n = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f12280a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        }

        b0(Parcel parcel) {
            this.f12280a = null;
            this.b = 5.0f;
            this.c = 0;
            this.d = 0;
            this.e = true;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = true;
            this.n = false;
            this.f12280a = parcel.readString();
            this.b = parcel.readFloat();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readByte() != 0;
            this.f = parcel.readByte() != 0;
            this.g = parcel.readByte() != 0;
            this.h = parcel.readByte() != 0;
            this.i = parcel.readByte() != 0;
            this.j = parcel.readByte() != 0;
            this.k = parcel.readByte() != 0;
            this.l = parcel.readByte() != 0;
            this.m = parcel.readByte() != 0;
            this.n = parcel.readByte() != 0;
        }
    }

    class c implements a0 {
        c() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.a0
        public void a(int i, int i2, float f) {
            IabCountDownWrapper iabCountDownWrapper;
            VastView vastView = VastView.this;
            b0 b0Var = vastView.u;
            if (b0Var.i || b0Var.b == 0.0f || !vastView.a(vastView.t)) {
                return;
            }
            VastView vastView2 = VastView.this;
            float f2 = vastView2.u.b * 1000.0f;
            float f3 = i2;
            float f4 = f2 - f3;
            int i3 = (int) ((f3 * 100.0f) / f2);
            VastLog.d(vastView2.f12276a, "Skip percent: %s", Integer.valueOf(i3));
            if (i3 < 100 && (iabCountDownWrapper = VastView.this.h) != null) {
                iabCountDownWrapper.changePercentage(i3, (int) Math.ceil(((double) f4) / 1000.0d));
            }
            if (f4 <= 0.0f) {
                VastView vastView3 = VastView.this;
                b0 b0Var2 = vastView3.u;
                b0Var2.b = 0.0f;
                b0Var2.i = true;
                vastView3.setCloseControlsVisible(true);
            }
        }
    }

    class d implements a0 {
        d() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.a0
        public void a(int i, int i2, float f) {
            VastView vastView = VastView.this;
            b0 b0Var = vastView.u;
            if (b0Var.h && b0Var.c == 3) {
                return;
            }
            if (vastView.t.getMaxDurationMillis() > 0 && i2 > VastView.this.t.getMaxDurationMillis() && VastView.this.t.getVideoType() == VideoType.Rewarded) {
                VastView vastView2 = VastView.this;
                vastView2.u.i = true;
                vastView2.setCloseControlsVisible(true);
            }
            VastView vastView3 = VastView.this;
            int i3 = vastView3.u.c;
            if (f > i3 * 25.0f) {
                if (i3 == 3) {
                    VastLog.d(vastView3.f12276a, "Video at third quartile: (%s)", Float.valueOf(f));
                    VastView.this.c(TrackingEvent.thirdQuartile);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoThirdQuartile();
                    }
                } else if (i3 == 0) {
                    VastLog.d(vastView3.f12276a, "Video at start: (%s)", Float.valueOf(f));
                    VastView.this.c(TrackingEvent.start);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoStarted(i, VastView.this.u.f ? 0.0f : 1.0f);
                    }
                } else if (i3 == 1) {
                    VastLog.d(vastView3.f12276a, "Video at first quartile: (%s)", Float.valueOf(f));
                    VastView.this.c(TrackingEvent.firstQuartile);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoFirstQuartile();
                    }
                } else if (i3 == 2) {
                    VastLog.d(vastView3.f12276a, "Video at midpoint: (%s)", Float.valueOf(f));
                    VastView.this.c(TrackingEvent.midpoint);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoMidpoint();
                    }
                }
                VastView.this.u.c++;
            }
        }
    }

    class e implements a0 {
        e() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.a0
        public void a(int i, int i2, float f) {
            if (VastView.this.U.size() == 2 && ((Integer) VastView.this.U.getFirst()).intValue() > ((Integer) VastView.this.U.getLast()).intValue()) {
                VastLog.e(VastView.this.f12276a, "Playing progressing error: seek", new Object[0]);
                VastView.this.U.removeFirst();
            }
            if (VastView.this.U.size() == 19) {
                int iIntValue = ((Integer) VastView.this.U.getFirst()).intValue();
                int iIntValue2 = ((Integer) VastView.this.U.getLast()).intValue();
                VastLog.d(VastView.this.f12276a, "Playing progressing position: last=%d, first=%d)", Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue));
                if (iIntValue2 > iIntValue) {
                    VastView.this.U.removeFirst();
                } else {
                    VastView.l(VastView.this);
                    if (VastView.this.V >= 3) {
                        VastView.this.c(IabError.internal("Playing progressing error: video hang detected"));
                        return;
                    }
                }
            }
            try {
                VastView.this.U.addLast(Integer.valueOf(i2));
                if (i == 0 || i2 <= 0) {
                    return;
                }
                VastView vastView = VastView.this;
                if (vastView.l != null) {
                    VastLog.d(vastView.f12276a, "Playing progressing percent: %s", Float.valueOf(f));
                    if (VastView.this.W < f) {
                        VastView.this.W = f;
                        int i3 = i / 1000;
                        VastView.this.l.changePercentage(f, Math.min(i3, (int) Math.ceil(i2 / 1000.0f)), i3);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    class f implements TextureView.SurfaceTextureListener {
        f() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            VastLog.d(VastView.this.f12276a, "onSurfaceTextureAvailable", new Object[0]);
            VastView.this.d = new Surface(surfaceTexture);
            VastView.this.G = true;
            if (VastView.this.H) {
                VastView.this.H = false;
                VastView.this.startPlayback("onSurfaceTextureAvailable");
            } else if (VastView.this.isPlaybackStarted()) {
                VastView vastView = VastView.this;
                BidMachineVideoBridge.MediaPlayerSetSurface(vastView.n, vastView.d);
                VastView.this.r();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            VastLog.d(VastView.this.f12276a, "onSurfaceTextureDestroyed", new Object[0]);
            VastView vastView = VastView.this;
            vastView.d = null;
            vastView.G = false;
            if (VastView.this.isPlaybackStarted()) {
                BidMachineVideoBridge.MediaPlayerSetSurface(VastView.this.n, null);
                VastView.this.l();
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            VastLog.d(VastView.this.f12276a, "onSurfaceTextureSizeChanged: %d/%d", Integer.valueOf(i), Integer.valueOf(i2));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class g implements MediaPlayer.OnCompletionListener {
        g() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/vast/activity/VastView$g;->onCompletion(Landroid/media/MediaPlayer;)V");
            CreativeInfoManager.onVideoCompleted("io.bidmachine", mediaPlayer, "media-player");
            safedk_VastView$g_onCompletion_01cc59331ce5996d04a2f05dddaadeb3(mediaPlayer);
        }

        public void safedk_VastView$g_onCompletion_01cc59331ce5996d04a2f05dddaadeb3(MediaPlayer p0) {
            VastLog.d(VastView.this.f12276a, "MediaPlayer - onCompletion", new Object[0]);
            VastView.this.g();
        }
    }

    class h implements MediaPlayer.OnErrorListener {
        h() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            VastView.this.c(IabError.internal(String.format("MediaPlayer - onError: what - %s, extra - %s", Integer.valueOf(i), Integer.valueOf(i2))));
            return true;
        }
    }

    class i implements MediaPlayer.OnPreparedListener {
        i() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VastLog.d(VastView.this.f12276a, "MediaPlayer - onPrepared", new Object[0]);
            VastView vastView = VastView.this;
            if (vastView.u.j) {
                return;
            }
            vastView.c(TrackingEvent.creativeView);
            VastView.this.c(TrackingEvent.fullscreen);
            VastView.this.y();
            VastView.this.setLoadingViewVisibility(false);
            VastView.this.J = true;
            if (!VastView.this.u.g) {
                BidMachineVideoBridge.MediaPlayerStart(mediaPlayer);
                VastView.this.u();
            }
            VastView.this.x();
            int i = VastView.this.u.d;
            if (i > 0) {
                mediaPlayer.seekTo(i);
                VastView.this.c(TrackingEvent.resume);
                if (VastView.this.w != null) {
                    VastView.this.w.onVideoResumed();
                }
            }
            VastView vastView2 = VastView.this;
            if (!vastView2.u.m) {
                vastView2.l();
            }
            VastView vastView3 = VastView.this;
            if (vastView3.u.k) {
                return;
            }
            vastView3.h();
            if (VastView.this.t.shouldPreloadCompanion()) {
                VastView.this.a(false);
            }
        }
    }

    class j implements MediaPlayer.OnVideoSizeChangedListener {
        j() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            VastLog.d(VastView.this.f12276a, "onVideoSizeChanged", new Object[0]);
            VastView.this.C = i;
            VastView.this.D = i2;
            VastView.this.d();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VastView.this.isPlaybackStarted() || VastView.this.u.j) {
                VastView.this.t();
            }
        }
    }

    class l implements VastHelper.OnScreenStateChangeListener {
        l() {
        }

        @Override // io.bidmachine.iab.vast.VastHelper.OnScreenStateChangeListener
        public void onScreenStateChange(boolean z) {
            VastView.this.z();
        }
    }

    class m implements View.OnTouchListener {
        m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0 && action != 1) {
                return false;
            }
            VastView.this.O.add(view);
            if (view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    class n extends WebChromeClient {
        n() {
        }

        private boolean a(JsResult jsResult) {
            jsResult.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            VastLog.d("JS alert", str2, new Object[0]);
            return a(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            VastLog.d("JS confirm", str2, new Object[0]);
            return a(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            VastLog.d("JS prompt", str2, new Object[0]);
            return a(jsPromptResult);
        }
    }

    class o extends WebViewClient {
        o() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded("io.bidmachine", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/vast/activity/VastView$o;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished("io.bidmachine", webView, str);
            safedk_VastView$o_onPageFinished_8b88616c66e8688e85c4496ac98b680b(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted("io.bidmachine", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError("io.bidmachine", view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            VastView.this.o();
            return true;
        }

        public void safedk_VastView$o_onPageFinished_8b88616c66e8688e85c4496ac98b680b(WebView p0, String p1) {
            p0.setBackgroundColor(0);
            p0.setLayerType(1, null);
        }

        public boolean safedk_VastView$o_shouldOverrideUrlLoading_1b7833ddfb23e9cb16e474800874442c(WebView p0, WebResourceRequest p1) {
            if (p1.hasGesture()) {
                VastView.this.O.add(p0);
            }
            return shouldOverrideUrlLoading(p0, p1.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders("io.bidmachine", view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/vast/activity/VastView$o;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
            boolean zSafedk_VastView$o_shouldOverrideUrlLoading_1b7833ddfb23e9cb16e474800874442c = safedk_VastView$o_shouldOverrideUrlLoading_1b7833ddfb23e9cb16e474800874442c(webView, webResourceRequest);
            BrandSafetyUtils.onShouldOverrideUrlLoading("io.bidmachine", webView, webResourceRequest, zSafedk_VastView$o_shouldOverrideUrlLoading_1b7833ddfb23e9cb16e474800874442c);
            return zSafedk_VastView$o_shouldOverrideUrlLoading_1b7833ddfb23e9cb16e474800874442c;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/vast/activity/VastView$o;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_VastView$o_shouldOverrideUrlLoading_e9face276cedcb7dd38c21abeb8dcc62 = safedk_VastView$o_shouldOverrideUrlLoading_e9face276cedcb7dd38c21abeb8dcc62(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading("io.bidmachine", webView, str, zSafedk_VastView$o_shouldOverrideUrlLoading_e9face276cedcb7dd38c21abeb8dcc62);
            return zSafedk_VastView$o_shouldOverrideUrlLoading_e9face276cedcb7dd38c21abeb8dcc62;
        }

        public boolean safedk_VastView$o_shouldOverrideUrlLoading_e9face276cedcb7dd38c21abeb8dcc62(WebView p0, String p1) {
            if (!VastView.this.O.contains(p0)) {
                return true;
            }
            VastLog.d(VastView.this.f12276a, "banner clicked", new Object[0]);
            VastView vastView = VastView.this;
            vastView.a(vastView.p, p1);
            return true;
        }
    }

    class p implements VastVideoLoadedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f12294a;
        final /* synthetic */ CacheControl b;

        p(boolean z, CacheControl cacheControl) {
            this.f12294a = z;
            this.b = cacheControl;
        }

        @Override // io.bidmachine.iab.vast.VastVideoLoadedListener
        public void onError(VastRequest vastRequest, IabError iabError) {
            VastView vastView = VastView.this;
            vastView.b(vastView.v, vastRequest, IabError.placeholder(String.format("Error loading video after showing with %s - %s", this.b, iabError)));
        }

        @Override // io.bidmachine.iab.vast.VastVideoLoadedListener
        public void onSuccess(VastRequest vastRequest, VastAd vastAd) {
            VastView.this.a(vastRequest, vastAd, this.f12294a);
        }
    }

    class q implements CloseableLayout.OnCloseClickListener {
        q() {
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCloseClick() {
            VastView vastView = VastView.this;
            vastView.b(vastView.v, VastView.this.t, IabError.placeholder("Close button clicked"));
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCountDownFinish() {
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastView.this.i();
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastRequest vastRequest = VastView.this.t;
            if (vastRequest != null && vastRequest.isR1()) {
                VastView vastView = VastView.this;
                if (!vastView.u.l && vastView.i()) {
                    return;
                }
            }
            if (VastView.this.I) {
                VastView.this.e();
            } else {
                VastView.this.handleBackPress();
            }
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastView.this.A();
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastView.this.q();
        }
    }

    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastView.this.i();
        }
    }

    class w extends y {
        final /* synthetic */ WeakReference f;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VastView.this.i();
                VastView.this.e();
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                VastView.this.c.setVisibility(8);
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VastView.this.i();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(Context context, Uri uri, String str, WeakReference weakReference) {
            super(context, uri, str);
            this.f = weakReference;
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.y
        void a(Bitmap bitmap) {
            View.OnClickListener cVar;
            ImageView imageView = (ImageView) this.f.get();
            if (imageView != null) {
                if (bitmap == null) {
                    cVar = new a();
                } else {
                    imageView.setImageBitmap(bitmap);
                    imageView.setAlpha(0.0f);
                    imageView.animate().alpha(1.0f).setDuration(100L).setListener(new b()).start();
                    cVar = new c();
                }
                imageView.setOnClickListener(cVar);
            }
        }
    }

    private final class x implements MraidInterstitialListener {
        private x() {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onCalendarEvent(MraidInterstitial mraidInterstitial, String str, IabClickCallback iabClickCallback) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onClose(MraidInterstitial mraidInterstitial) {
            VastView.this.f();
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onExpired(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onLoadFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onLoaded(MraidInterstitial mraidInterstitial) {
            VastView vastView = VastView.this;
            if (vastView.u.j) {
                vastView.setLoadingViewVisibility(false);
                mraidInterstitial.showInView(VastView.this, false);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onOpenPrivacySheet(MraidInterstitial mraidInterstitial, PrivacySheetParams privacySheetParams) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onOpenUrl(MraidInterstitial mraidInterstitial, String str, IabClickCallback iabClickCallback) {
            iabClickCallback.clickHandled();
            VastView vastView = VastView.this;
            vastView.a(vastView.q, str);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onPlayVideo(MraidInterstitial mraidInterstitial, String str) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onShowFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onShown(MraidInterstitial mraidInterstitial) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onStorePicture(MraidInterstitial mraidInterstitial, String str, IabClickCallback iabClickCallback) {
        }

        /* synthetic */ x(VastView vastView, k kVar) {
            this();
        }
    }

    private static abstract class y extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f12305a;
        private final Uri b;
        private final String c;
        private Bitmap d;
        private boolean e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y yVar = y.this;
                yVar.a(yVar.d);
            }
        }

        y(Context context, Uri uri, String str) {
            this.f12305a = new WeakReference(context);
            this.b = uri;
            this.c = str;
            if (str == null && (uri == null || TextUtils.isEmpty(uri.getPath()) || !new File(uri.getPath()).exists())) {
                a((Bitmap) null);
            } else {
                start();
            }
        }

        abstract void a(Bitmap bitmap);

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Context context = (Context) this.f12305a.get();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (context != null) {
                try {
                    Uri uri = this.b;
                    if (uri != null) {
                        mediaMetadataRetriever.setDataSource(context, uri);
                    } else {
                        String str = this.c;
                        if (str != null) {
                            mediaMetadataRetriever.setDataSource(str, new HashMap());
                        }
                    }
                    this.d = mediaMetadataRetriever.getFrameAtTime((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 2) * 1000, 2);
                } catch (Exception e) {
                    VastLog.e("MediaFrameRetriever", e.getMessage(), new Object[0]);
                }
            }
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e2) {
                VastLog.e("MediaFrameRetriever", e2.getMessage(), new Object[0]);
            }
            if (this.e) {
                return;
            }
            Utils.onUiThread(new a());
        }

        void a() {
            this.e = true;
        }
    }

    static class z extends View.BaseSavedState {
        public static final Parcelable.Creator<z> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b0 f12307a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public z createFromParcel(Parcel parcel) {
                return new z(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public z[] newArray(int i) {
                return new z[i];
            }
        }

        z(Parcel parcel) {
            super(parcel);
            this.f12307a = (b0) parcel.readParcelable(b0.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f12307a, 0);
        }

        z(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public VastView(Context context) {
        this(context, null);
    }

    private int getAvailableHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getAvailableWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    static /* synthetic */ int l(VastView vastView) {
        int i2 = vastView.V;
        vastView.V = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCloseControlsVisible(boolean visible) {
        this.L = visible;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingViewVisibility(boolean visible) {
        IabLoadingWrapper iabLoadingWrapper = this.k;
        if (iabLoadingWrapper == null) {
            return;
        }
        if (!visible) {
            iabLoadingWrapper.setVisibility(8);
        } else {
            iabLoadingWrapper.setVisibility(0);
            this.k.bringToFront();
        }
    }

    private void setMute(boolean isMuted) {
        this.u.f = isMuted;
        x();
        c(this.u.f ? TrackingEvent.mute : TrackingEvent.unmute);
    }

    private void setPlaceholderViewVisible(boolean visible) {
        CloseableLayout closeableLayout = this.f;
        VastRequest vastRequest = this.t;
        closeableLayout.setCloseVisibility(visible, vastRequest != null ? vastRequest.getPlaceholderTimeoutSec() : 3.0f);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        super.addView(child);
        this.e.bringToFront();
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleCanceled() {
        if (isCompanionShown()) {
            setLoadingViewVisibility(false);
        } else {
            r();
        }
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleError() {
        if (isPlaybackStarted()) {
            r();
        } else if (isCompanionShown()) {
            f();
        } else {
            s();
        }
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandled() {
        if (isCompanionShown()) {
            setLoadingViewVisibility(false);
        } else if (this.E) {
            r();
        } else {
            l();
        }
    }

    public void destroy() {
        MraidInterstitial mraidInterstitial = this.s;
        if (mraidInterstitial != null) {
            mraidInterstitial.destroy();
            this.s = null;
            this.q = null;
        }
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        y yVar = this.z;
        if (yVar != null) {
            yVar.a();
            this.z = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public boolean display(VastRequest vastRequest, Boolean isFullscreen) {
        return a(vastRequest, isFullscreen, false);
    }

    public VastViewListener getListener() {
        return this.v;
    }

    public void handleBackPress() {
        if (this.f.isVisible() && this.f.canBeClosed()) {
            b(this.v, this.t, IabError.placeholder("OnBackPress event fired"));
            return;
        }
        if (isSkipEnabled()) {
            if (!isCompanionShown()) {
                m();
                return;
            }
            VastRequest vastRequest = this.t;
            if (vastRequest == null || vastRequest.getVideoType() != VideoType.NonRewarded) {
                return;
            }
            if (this.q == null) {
                e();
                return;
            }
            MraidInterstitial mraidInterstitial = this.s;
            if (mraidInterstitial != null) {
                mraidInterstitial.dispatchClose();
            } else {
                f();
            }
        }
    }

    public boolean isCompanionShown() {
        return this.u.j;
    }

    public boolean isFinished() {
        VastRequest vastRequest = this.t;
        return vastRequest != null && ((vastRequest.getCompanionCloseTime() == 0.0f && this.u.h) || (this.t.getCompanionCloseTime() > 0.0f && this.u.j));
    }

    public boolean isFullscreen() {
        return this.u.e;
    }

    public boolean isLoaded() {
        VastRequest vastRequest = this.t;
        return (vastRequest == null || vastRequest.getVastAd() == null) ? false : true;
    }

    public boolean isPlaybackStarted() {
        return this.n != null && this.J;
    }

    public boolean isSkipEnabled() {
        b0 b0Var = this.u;
        return b0Var.i || b0Var.b == 0.0f;
    }

    public boolean isVideoFileLoaded() {
        VastRequest vastRequest = this.t;
        return vastRequest != null && vastRequest.checkFile();
    }

    public void mute() {
        setMute(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.E) {
            startPlayback("onAttachedToWindow");
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isLoaded()) {
            i(this.t.getVastAd().getAppodealExtension());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopPlayback();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof z)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        z zVar = (z) parcelable;
        super.onRestoreInstanceState(zVar.getSuperState());
        b0 b0Var = zVar.f12307a;
        if (b0Var != null) {
            this.u = b0Var;
        }
        VastRequest vastRequest = VastRequestManager.get(this.u.f12280a);
        if (vastRequest != null) {
            a(vastRequest, (Boolean) null, true);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        if (isPlaybackStarted()) {
            this.u.d = this.n.getCurrentPosition();
        }
        z zVar = new z(super.onSaveInstanceState());
        zVar.f12307a = this.u;
        return zVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        removeCallbacks(this.Q);
        post(this.Q);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        VastLog.d(this.f12276a, "onWindowFocusChanged: %s", Boolean.valueOf(hasWindowFocus));
        this.E = hasWindowFocus;
        z();
    }

    public void pause() {
        setCanAutoResume(false);
        l();
    }

    public void resume() {
        setCanAutoResume(true);
        r();
    }

    public void setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
        this.x = vastAdMeasurer;
    }

    public void setCanAutoResume(boolean canAutoResume) {
        this.M = canAutoResume;
        this.u.m = canAutoResume;
    }

    public void setCanIgnorePostBanner(boolean canIgnorePostBanner) {
        this.N = canIgnorePostBanner;
        this.u.n = canIgnorePostBanner;
    }

    public void setListener(VastViewListener listener) {
        this.v = listener;
    }

    public void setPlaybackListener(VastPlaybackListener playbackListener) {
        this.w = playbackListener;
    }

    public void setPostBannerAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
        this.y = mraidAdMeasurer != null ? new PostBannerAdMeasurer(this, mraidAdMeasurer) : null;
    }

    public void startPlayback(String who) {
        VastLog.d(this.f12276a, "startPlayback: %s", who);
        if (isLoaded()) {
            setPlaceholderViewVisible(false);
            if (this.u.j) {
                s();
                return;
            }
            if (!this.E) {
                this.F = true;
                return;
            }
            if (this.G) {
                stopPlayback();
                k();
                d();
                n();
                VastHelper.addScreenStateChangeListener(this, this.g0);
            } else {
                this.H = true;
            }
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public void stopPlayback() {
        this.u.g = false;
        if (this.n != null) {
            VastLog.d(this.f12276a, "stopPlayback", new Object[0]);
            try {
                if (this.n.isPlaying()) {
                    BidMachineVideoBridge.MediaPlayerStop(this.n);
                }
                BidMachineVideoBridge.MediaPlayerSetSurface(this.n, null);
                BidMachineVideoBridge.MediaPlayerRelease(this.n);
            } catch (Exception e2) {
                VastLog.e(this.f12276a, e2);
            }
            this.n = null;
            this.J = false;
            this.K = false;
            c();
            VastHelper.removeScreenStateChangeListener(this);
        }
    }

    public void unmute() {
        setMute(false);
    }

    public VastView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        setMute(!this.u.f);
    }

    private void g(VastExtension vastExtension) {
        if (vastExtension != null && !vastExtension.getProgressStyle().isVisible().booleanValue()) {
            IabProgressWrapper iabProgressWrapper = this.l;
            if (iabProgressWrapper != null) {
                iabProgressWrapper.detach();
                return;
            }
            return;
        }
        if (this.l == null) {
            IabProgressWrapper iabProgressWrapper2 = new IabProgressWrapper(null);
            this.l = iabProgressWrapper2;
            this.P.add(iabProgressWrapper2);
        }
        this.l.attach(getContext(), this.e, a(vastExtension, vastExtension != null ? vastExtension.getProgressStyle() : null));
        this.l.changePercentage(0.0f, 0, 0);
    }

    private void h(VastExtension vastExtension) {
        if (vastExtension == null || !vastExtension.getRepeatStyle().isVisible().booleanValue()) {
            IabRepeatWrapper iabRepeatWrapper = this.i;
            if (iabRepeatWrapper != null) {
                iabRepeatWrapper.detach();
                return;
            }
            return;
        }
        if (this.i == null) {
            IabRepeatWrapper iabRepeatWrapper2 = new IabRepeatWrapper(new u());
            this.i = iabRepeatWrapper2;
            this.P.add(iabRepeatWrapper2);
        }
        this.i.attach(getContext(), this.e, a(vastExtension, vastExtension.getRepeatStyle()));
    }

    private void i(VastExtension vastExtension) {
        IabElementStyle iabElementStyleCopyWith;
        IabElementStyle iabElementStyleCopyWith2 = Assets.DEF_VIDEO_STYLE;
        if (vastExtension != null) {
            iabElementStyleCopyWith2 = iabElementStyleCopyWith2.copyWith(vastExtension.getVideoStyle());
        }
        if (vastExtension == null || !vastExtension.isVideoClickable()) {
            this.c.setOnClickListener(null);
            this.c.setClickable(false);
        } else {
            this.c.setOnClickListener(new v());
        }
        this.c.setBackgroundColor(iabElementStyleCopyWith2.getFillColor().intValue());
        o();
        if (this.p == null || this.u.j) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            return;
        }
        this.o = a(getContext(), this.p);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.o.getLayoutParams());
        if (POBCommonConstants.BANNER_PLACEMENT_TYPE.equals(iabElementStyleCopyWith2.getStyle())) {
            iabElementStyleCopyWith = Assets.DEF_INLINE_BANNER_STYLE;
            if (getResources().getConfiguration().orientation == 2) {
                layoutParams2.addRule(15);
                layoutParams3.height = -1;
                layoutParams3.addRule(10);
                layoutParams3.addRule(12);
                if (iabElementStyleCopyWith2.getHorizontalPosition().intValue() == 3) {
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(0, this.o.getId());
                    layoutParams3.addRule(11);
                } else {
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(1, this.o.getId());
                    layoutParams3.addRule(9);
                }
            } else {
                layoutParams2.addRule(14);
                layoutParams3.width = -1;
                layoutParams3.addRule(9);
                layoutParams3.addRule(11);
                if (iabElementStyleCopyWith2.getVerticalPosition().intValue() == 48) {
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(2, this.o.getId());
                    layoutParams3.addRule(12);
                } else {
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(3, this.o.getId());
                    layoutParams3.addRule(10);
                }
            }
        } else {
            IabElementStyle iabElementStyle = Assets.DEF_BANNER_STYLE;
            layoutParams2.addRule(13);
            iabElementStyleCopyWith = iabElementStyle;
        }
        if (vastExtension != null) {
            iabElementStyleCopyWith = iabElementStyleCopyWith.copyWith(vastExtension.getCtaStyle());
        }
        iabElementStyleCopyWith.applyPadding(getContext(), this.o);
        iabElementStyleCopyWith.applyMargin(getContext(), layoutParams3);
        iabElementStyleCopyWith.applyRelativeAlignment(layoutParams3);
        this.o.setBackgroundColor(iabElementStyleCopyWith.getFillColor().intValue());
        iabElementStyleCopyWith2.applyPadding(getContext(), this.c);
        iabElementStyleCopyWith2.applyMargin(getContext(), layoutParams2);
        this.c.setLayoutParams(layoutParams2);
        addView(this.o, layoutParams3);
        a(TrackingEvent.creativeView);
    }

    private void j() {
        VastLog.d(this.f12276a, "finishVideoPlaying", new Object[0]);
        stopPlayback();
        VastRequest vastRequest = this.t;
        if (vastRequest == null || vastRequest.isAutoClose() || !(this.t.getVastAd().getAppodealExtension() == null || this.t.getVastAd().getAppodealExtension().getPostBannerTag().isVisible())) {
            e();
            return;
        }
        if (isSkipEnabled()) {
            c(TrackingEvent.close);
        }
        setLoadingViewVisibility(false);
        o();
        s();
    }

    private void k() {
        if (this.r != null) {
            p();
        } else {
            MraidInterstitial mraidInterstitial = this.s;
            if (mraidInterstitial != null) {
                mraidInterstitial.destroy();
                this.s = null;
                this.q = null;
            }
        }
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!isPlaybackStarted() || this.u.g) {
            return;
        }
        VastLog.d(this.f12276a, "pausePlayback", new Object[0]);
        b0 b0Var = this.u;
        b0Var.g = true;
        b0Var.d = this.n.getCurrentPosition();
        BidMachineVideoBridge.MediaPlayerPause(this.n);
        c();
        a();
        c(TrackingEvent.pause);
        VastPlaybackListener vastPlaybackListener = this.w;
        if (vastPlaybackListener != null) {
            vastPlaybackListener.onVideoPaused();
        }
    }

    private void m() {
        VastLog.e(this.f12276a, "performVideoCloseClick", new Object[0]);
        stopPlayback();
        if (this.K) {
            e();
            return;
        }
        if (!this.u.h) {
            c(TrackingEvent.skip);
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoSkipped();
            }
        }
        VastRequest vastRequest = this.t;
        if (vastRequest != null && vastRequest.getVideoType() == VideoType.Rewarded) {
            VastPlaybackListener vastPlaybackListener2 = this.w;
            if (vastPlaybackListener2 != null) {
                vastPlaybackListener2.onVideoCompleted();
            }
            VastViewListener vastViewListener = this.v;
            if (vastViewListener != null) {
                vastViewListener.onComplete(this, this.t);
            }
        }
        j();
    }

    private void n() {
        try {
            if (!isLoaded() || this.u.j) {
                return;
            }
            if (this.n == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.n = mediaPlayer;
                mediaPlayer.setLooping(false);
                this.n.setAudioStreamType(3);
                this.n.setOnCompletionListener(this.c0);
                this.n.setOnErrorListener(this.d0);
                this.n.setOnPreparedListener(this.e0);
                this.n.setOnVideoSizeChangedListener(this.f0);
            }
            BidMachineVideoBridge.MediaPlayerSetSurface(this.n, this.d);
            Uri fileUri = isVideoFileLoaded() ? this.t.getFileUri() : null;
            if (fileUri == null) {
                setLoadingViewVisibility(true);
                BidMachineVideoBridge.MediaPlayerSetDataSource(this.n, this.t.getVastAd().getPickedMediaFileTag().getText());
            } else {
                setLoadingViewVisibility(false);
                BidMachineVideoBridge.MediaPlayerSetDataSource(this.n, getContext(), fileUri);
            }
            this.n.prepareAsync();
        } catch (Exception e2) {
            VastLog.e(this.f12276a, e2);
            c(IabError.throwable("Exception during preparing MediaPlayer", e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View view = this.o;
        if (view != null) {
            Utils.removeFromParent(view);
            this.o = null;
        }
    }

    private void p() {
        if (this.r != null) {
            b();
            removeView(this.r);
            this.r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (isLoaded()) {
            b0 b0Var = this.u;
            b0Var.j = false;
            b0Var.d = 0;
            k();
            i(this.t.getVastAd().getAppodealExtension());
            startPlayback("restartPlayback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        b0 b0Var = this.u;
        if (!b0Var.m) {
            if (isPlaybackStarted()) {
                BidMachineVideoBridge.MediaPlayerStart(this.n);
                BidMachineVideoBridge.MediaPlayerPause(this.n);
                setLoadingViewVisibility(false);
                return;
            } else {
                if (this.u.j) {
                    return;
                }
                startPlayback("resumePlayback (canAutoResume: false)");
                return;
            }
        }
        if (b0Var.g && this.E) {
            VastLog.d(this.f12276a, "resumePlayback", new Object[0]);
            this.u.g = false;
            if (!isPlaybackStarted()) {
                if (this.u.j) {
                    return;
                }
                startPlayback("resumePlayback");
                return;
            }
            BidMachineVideoBridge.MediaPlayerStart(this.n);
            y();
            u();
            setLoadingViewVisibility(false);
            c(TrackingEvent.resume);
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoResumed();
            }
        }
    }

    private void s() {
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Iterator it = this.P.iterator();
        while (it.hasNext()) {
            ((IabElementWrapper) it.next()).toggleShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        v();
        c();
        this.R.run();
    }

    private void v() {
        this.U.clear();
        this.V = 0;
        this.W = 0.0f;
    }

    private void w() {
        boolean z2;
        boolean z3;
        if (this.L) {
            z2 = true;
            if (isSkipEnabled() || this.I) {
                z3 = false;
            } else {
                z3 = true;
                z2 = false;
            }
        } else {
            z3 = false;
            z2 = false;
        }
        IabCloseWrapper iabCloseWrapper = this.g;
        if (iabCloseWrapper != null) {
            iabCloseWrapper.setVisibility(z2 ? 0 : 8);
        }
        IabCountDownWrapper iabCountDownWrapper = this.h;
        if (iabCountDownWrapper != null) {
            iabCountDownWrapper.setVisibility(z3 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        IabMuteWrapper iabMuteWrapper;
        float f2;
        VastPlaybackListener vastPlaybackListener;
        if (!isPlaybackStarted() || (iabMuteWrapper = this.j) == null) {
            return;
        }
        iabMuteWrapper.setMuted(this.u.f);
        if (this.u.f) {
            f2 = 0.0f;
            this.n.setVolume(0.0f, 0.0f);
            vastPlaybackListener = this.w;
            if (vastPlaybackListener == null) {
                return;
            }
        } else {
            f2 = 1.0f;
            this.n.setVolume(1.0f, 1.0f);
            vastPlaybackListener = this.w;
            if (vastPlaybackListener == null) {
                return;
            }
        }
        vastPlaybackListener.onVideoVolumeChanged(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (isLoaded()) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!this.E || !VastHelper.isScreenOn(getContext())) {
            l();
            return;
        }
        if (this.F) {
            this.F = false;
            startPlayback("onWindowFocusChanged");
        } else if (this.u.j) {
            setLoadingViewVisibility(false);
        } else {
            r();
        }
    }

    public VastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f12276a = "VastView-" + Integer.toHexString(hashCode());
        this.u = new b0();
        this.A = 0;
        this.B = 0;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = true;
        this.N = false;
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new d();
        this.U = new LinkedList();
        this.V = 0;
        this.W = 0.0f;
        this.a0 = new e();
        f fVar = new f();
        this.b0 = fVar;
        this.c0 = new g();
        this.d0 = new h();
        this.e0 = new i();
        this.f0 = new j();
        this.g0 = new l();
        this.h0 = new m();
        this.i0 = new n();
        this.j0 = new o();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setOnClickListener(new k());
        IabVideoTexture iabVideoTexture = new IabVideoTexture(context);
        this.b = iabVideoTexture;
        iabVideoTexture.setSurfaceTextureListener(fVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        frameLayout.addView(this.b, new FrameLayout.LayoutParams(-1, -1, 17));
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.e = frameLayout2;
        frameLayout2.setBackgroundColor(0);
        addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        CloseableLayout closeableLayout = new CloseableLayout(getContext());
        this.f = closeableLayout;
        closeableLayout.setBackgroundColor(0);
        addView(this.f, new ViewGroup.LayoutParams(-1, -1));
    }

    private void d(VastExtension vastExtension) {
        if (vastExtension == null || vastExtension.getLoadingStyle().isVisible().booleanValue()) {
            if (this.k == null) {
                this.k = new IabLoadingWrapper(null);
            }
            this.k.attach(getContext(), this, a(vastExtension, vastExtension != null ? vastExtension.getLoadingStyle() : null));
        } else {
            IabLoadingWrapper iabLoadingWrapper = this.k;
            if (iabLoadingWrapper != null) {
                iabLoadingWrapper.detach();
            }
        }
    }

    private void e(VastExtension vastExtension) {
        if (vastExtension != null && !vastExtension.getMuteStyle().isVisible().booleanValue()) {
            IabMuteWrapper iabMuteWrapper = this.j;
            if (iabMuteWrapper != null) {
                iabMuteWrapper.detach();
                return;
            }
            return;
        }
        if (this.j == null) {
            IabMuteWrapper iabMuteWrapper2 = new IabMuteWrapper(new t());
            this.j = iabMuteWrapper2;
            this.P.add(iabMuteWrapper2);
        }
        this.j.attach(getContext(), this.e, a(vastExtension, vastExtension != null ? vastExtension.getMuteStyle() : null));
    }

    private void f(VastExtension vastExtension) {
        this.f.setCountDownStyle(a(vastExtension, vastExtension != null ? vastExtension.getCountDownStyle() : null));
        if (isFullscreen()) {
            this.f.setCloseStyle(a(vastExtension, vastExtension != null ? vastExtension.getCloseStyle() : null));
            this.f.setCloseClickListener(new q());
        }
        d(vastExtension);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        VastLog.d(this.f12276a, "handleComplete", new Object[0]);
        b0 b0Var = this.u;
        b0Var.i = true;
        if (!this.K && !b0Var.h) {
            b0Var.h = true;
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoCompleted();
            }
            VastViewListener vastViewListener = this.v;
            if (vastViewListener != null) {
                vastViewListener.onComplete(this, this.t);
            }
            VastRequest vastRequest = this.t;
            if (vastRequest != null && vastRequest.isR2() && !this.u.l) {
                i();
            }
            c(TrackingEvent.complete);
        }
        if (this.u.h) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        VastLog.d(this.f12276a, "handleImpressions", new Object[0]);
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            this.u.k = true;
            a(vastRequest.getVastAd().getImpressionUrlList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        VastLog.e(this.f12276a, "handleInfoClicked", new Object[0]);
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            return a(vastRequest.getVastAd().getClickTrackingUrlList(), this.t.getVastAd().getClickThroughUrl());
        }
        return false;
    }

    private void c() {
        removeCallbacks(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i2;
        int i3 = this.C;
        if (i3 == 0 || (i2 = this.D) == 0) {
            VastLog.d(this.f12276a, "configureVideoSurface - skip: videoWidth or videoHeight is 0", new Object[0]);
        } else {
            this.b.setVideoSize(i3, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        VastRequest vastRequest;
        VastLog.e(this.f12276a, "handleClose", new Object[0]);
        c(TrackingEvent.close);
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        VastRequest vastRequest;
        VastLog.e(this.f12276a, "handleCompanionClose", new Object[0]);
        b(TrackingEvent.close);
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    private void b() {
        y yVar = this.z;
        if (yVar != null) {
            yVar.a();
            this.z = null;
        }
    }

    private void c(VastExtension vastExtension) {
        if (vastExtension == null || !vastExtension.isVideoClickable()) {
            return;
        }
        this.P.clear();
    }

    private void b(VastExtension vastExtension) {
        if (vastExtension != null && !vastExtension.getCountDownStyle().isVisible().booleanValue()) {
            IabCountDownWrapper iabCountDownWrapper = this.h;
            if (iabCountDownWrapper != null) {
                iabCountDownWrapper.detach();
                return;
            }
            return;
        }
        if (this.h == null) {
            IabCountDownWrapper iabCountDownWrapper2 = new IabCountDownWrapper(null);
            this.h = iabCountDownWrapper2;
            this.P.add(iabCountDownWrapper2);
        }
        this.h.attach(getContext(), this.e, a(vastExtension, vastExtension != null ? vastExtension.getCountDownStyle() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IabError iabError) {
        VastLog.e(this.f12276a, "handlePlaybackError - %s", iabError);
        this.K = true;
        a(VastSpecError.SHOWING);
        a(this.v, this.t, iabError);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IabError iabError) {
        VastRequest vastRequest;
        VastLog.e(this.f12276a, "handleCompanionShowError - %s", iabError);
        a(VastSpecError.GENERAL_COMPANION);
        a(this.v, this.t, iabError);
        if (this.q != null) {
            k();
            b(true);
            return;
        }
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TrackingEvent trackingEvent) {
        VastLog.d(this.f12276a, "Track Event: %s", trackingEvent);
        VastRequest vastRequest = this.t;
        VastAd vastAd = vastRequest != null ? vastRequest.getVastAd() : null;
        if (vastAd != null) {
            a(vastAd.getTrackingEventListMap(), trackingEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VastViewListener vastViewListener, VastRequest vastRequest, IabError iabError) {
        a(vastViewListener, vastRequest, iabError);
        if (vastViewListener == null || vastRequest == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, false);
    }

    private void b(boolean z2) {
        VastViewListener vastViewListener;
        if (!isLoaded() || this.I) {
            return;
        }
        this.I = true;
        this.u.j = true;
        int i2 = getResources().getConfiguration().orientation;
        int i3 = this.B;
        if (i2 != i3 && (vastViewListener = this.v) != null) {
            vastViewListener.onOrientationRequested(this, this.t, i3);
        }
        IabProgressWrapper iabProgressWrapper = this.l;
        if (iabProgressWrapper != null) {
            iabProgressWrapper.detach();
        }
        IabMuteWrapper iabMuteWrapper = this.j;
        if (iabMuteWrapper != null) {
            iabMuteWrapper.detach();
        }
        IabRepeatWrapper iabRepeatWrapper = this.i;
        if (iabRepeatWrapper != null) {
            iabRepeatWrapper.detach();
        }
        a();
        if (this.u.n) {
            if (this.r == null) {
                this.r = a(getContext());
            }
            this.r.setImageBitmap(this.b.getBitmap());
            addView(this.r, new FrameLayout.LayoutParams(-1, -1));
            this.e.bringToFront();
            return;
        }
        a(z2);
        if (this.q == null) {
            setCloseControlsVisible(true);
            if (this.r != null) {
                this.z = new w(getContext(), this.t.getFileUri(), this.t.getVastAd().getPickedMediaFileTag().getText(), new WeakReference(this.r));
            }
            addView(this.r, new FrameLayout.LayoutParams(-1, -1));
        } else {
            setCloseControlsVisible(false);
            this.c.setVisibility(8);
            o();
            IabCtaWrapper iabCtaWrapper = this.m;
            if (iabCtaWrapper != null) {
                iabCtaWrapper.setVisibility(8);
            }
            MraidInterstitial mraidInterstitial = this.s;
            if (mraidInterstitial == null) {
                setLoadingViewVisibility(false);
                b(IabError.internal("CompanionInterstitial is null"));
            } else if (mraidInterstitial.isReady()) {
                setLoadingViewVisibility(false);
                this.s.showInView(this, false);
            } else {
                setLoadingViewVisibility(true);
            }
        }
        stopPlayback();
        this.e.bringToFront();
        b(TrackingEvent.creativeView);
    }

    private void b(TrackingEvent trackingEvent) {
        VastLog.d(this.f12276a, "Track Companion Event: %s", trackingEvent);
        CompanionTag companionTag = this.q;
        if (companionTag != null) {
            a(companionTag.getTrackingEventListMap(), trackingEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(VastRequest vastRequest) {
        return vastRequest.getVideoType() != VideoType.Rewarded || vastRequest.getMaxDurationMillis() <= 0;
    }

    private void a() {
        Iterator it = this.P.iterator();
        while (it.hasNext()) {
            ((IabElementWrapper) it.next()).cancelHide();
        }
    }

    private void a(VastExtension vastExtension) {
        if (vastExtension != null && !vastExtension.getCloseStyle().isVisible().booleanValue()) {
            IabCloseWrapper iabCloseWrapper = this.g;
            if (iabCloseWrapper != null) {
                iabCloseWrapper.detach();
                return;
            }
            return;
        }
        if (this.g == null) {
            IabCloseWrapper iabCloseWrapper2 = new IabCloseWrapper(new s());
            this.g = iabCloseWrapper2;
            this.P.add(iabCloseWrapper2);
        }
        this.g.attach(getContext(), this.e, a(vastExtension, vastExtension != null ? vastExtension.getCloseStyle() : null));
    }

    private void a(VastExtension vastExtension, boolean z2) {
        if (z2 || !(vastExtension == null || vastExtension.getCtaStyle().isVisible().booleanValue())) {
            IabCtaWrapper iabCtaWrapper = this.m;
            if (iabCtaWrapper != null) {
                iabCtaWrapper.detach();
                return;
            }
            return;
        }
        if (this.m == null) {
            IabCtaWrapper iabCtaWrapper2 = new IabCtaWrapper(new r());
            this.m = iabCtaWrapper2;
            this.P.add(iabCtaWrapper2);
        }
        this.m.attach(getContext(), this.e, a(vastExtension, vastExtension != null ? vastExtension.getCtaStyle() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, VastAd vastAd, boolean z2) {
        AppodealExtensionTag appodealExtension = vastAd.getAppodealExtension();
        this.A = vastRequest.getPreferredVideoOrientation();
        this.p = (appodealExtension == null || !appodealExtension.getCtaStyle().isVisible().booleanValue()) ? null : appodealExtension.getCompanionTag();
        if (this.p == null) {
            this.p = vastAd.getBanner(getContext());
        }
        i(appodealExtension);
        a(appodealExtension, this.o != null);
        a(appodealExtension);
        b(appodealExtension);
        e(appodealExtension);
        h(appodealExtension);
        g(appodealExtension);
        d(appodealExtension);
        c(appodealExtension);
        setLoadingViewVisibility(false);
        VastAdMeasurer vastAdMeasurer = this.x;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.registerAdContainer(this);
            this.x.registerAdView(this.b);
        }
        VastViewListener vastViewListener = this.v;
        if (vastViewListener != null) {
            vastViewListener.onOrientationRequested(this, vastRequest, this.u.j ? this.B : this.A);
        }
        if (!z2) {
            this.u.f12280a = vastRequest.getId();
            b0 b0Var = this.u;
            b0Var.m = this.M;
            b0Var.n = this.N;
            if (appodealExtension != null) {
                b0Var.f = appodealExtension.isMuted();
            }
            this.u.b = vastRequest.getFusedVideoCloseTimeSec();
            VastAdMeasurer vastAdMeasurer2 = this.x;
            if (vastAdMeasurer2 != null) {
                vastAdMeasurer2.onAdViewReady(this.b);
                this.x.onAdShown();
            }
            VastViewListener vastViewListener2 = this.v;
            if (vastViewListener2 != null) {
                vastViewListener2.onShown(this, vastRequest);
            }
        }
        setCloseControlsVisible(a(vastRequest));
        startPlayback("load (restoring: " + z2 + ")");
    }

    private View a(Context context, CompanionTag companionTag) {
        float width;
        float height;
        boolean zIsTablet = Utils.isTablet(context);
        if (companionTag.getWidth() > 0) {
            width = companionTag.getWidth();
        } else {
            width = zIsTablet ? 728.0f : 320.0f;
        }
        int iDpToPx = Utils.dpToPx(context, width);
        if (companionTag.getHeight() > 0) {
            height = companionTag.getHeight();
        } else {
            height = zIsTablet ? 90.0f : 50.0f;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDpToPx, Utils.dpToPx(context, height));
        WebView webView = new WebView(context);
        webView.setId(Utils.generateViewId());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setScrollBarStyle(33554432);
        webView.setFocusableInTouchMode(false);
        webView.setBackgroundColor(0);
        webView.setOnTouchListener(this.h0);
        webView.setWebViewClient(this.j0);
        webView.setWebChromeClient(this.i0);
        String html = companionTag.getHtml();
        if (html != null) {
            BidMachineNetworkBridge.webviewLoadDataWithBaseURL(webView, "", html, POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(Utils.generateViewId());
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        IabError iabErrorBadContent;
        if (isLoaded()) {
            k kVar = null;
            if (!z2) {
                CompanionTag companion = this.t.getVastAd().getCompanion(getAvailableWidth(), getAvailableHeight());
                if (this.q != companion) {
                    this.B = (companion == null || !this.t.shouldUseScreenSizeForCompanionOrientation()) ? this.A : Utils.orientationBySize(companion.getWidth(), companion.getHeight());
                    this.q = companion;
                    MraidInterstitial mraidInterstitial = this.s;
                    if (mraidInterstitial != null) {
                        mraidInterstitial.destroy();
                        this.s = null;
                    }
                }
            }
            if (this.q == null) {
                if (this.r == null) {
                    this.r = a(getContext());
                    return;
                }
                return;
            }
            if (this.s == null) {
                p();
                String htmlForMraid = this.q.getHtmlForMraid();
                if (htmlForMraid != null) {
                    AppodealExtensionTag appodealExtension = this.t.getVastAd().getAppodealExtension();
                    PostBannerTag postBannerTag = appodealExtension != null ? appodealExtension.getPostBannerTag() : null;
                    MraidInterstitial.Builder listener = MraidInterstitial.newBuilder().setBaseUrl(null).setCacheControl(CacheControl.FullLoad).setCloseTime(this.t.getCompanionCloseTime()).forceUseNativeCloseButton(this.t.isForceUseNativeCloseTime()).setIsTag(false).setAdMeasurer(this.y).setListener(new x(this, kVar));
                    if (postBannerTag != null) {
                        listener.setCloseStyle(postBannerTag.getCloseStyle());
                        listener.setCountDownStyle(postBannerTag.getCountDownStyle());
                        listener.setLoadingStyle(postBannerTag.getLoadingStyle());
                        listener.setProgressStyle(postBannerTag.getProgressStyle());
                        listener.setDurationSec(postBannerTag.getDurationSec());
                        listener.setProductLink(postBannerTag.getProductLink());
                        if (postBannerTag.isForceUseNativeClose()) {
                            listener.forceUseNativeCloseButton(true);
                        }
                        listener.setR1(postBannerTag.isR1());
                        listener.setR2(postBannerTag.isR2());
                    }
                    try {
                        MraidInterstitial mraidInterstitialBuild = listener.build(getContext());
                        this.s = mraidInterstitialBuild;
                        mraidInterstitialBuild.load(htmlForMraid);
                        return;
                    } catch (Throwable th) {
                        iabErrorBadContent = IabError.throwable("Exception during companion creation", th);
                    }
                } else {
                    iabErrorBadContent = IabError.badContent("Companion creative is null");
                }
                b(iabErrorBadContent);
            }
        }
    }

    private ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private void a(List list) {
        if (isLoaded()) {
            if (list == null || list.isEmpty()) {
                VastLog.d(this.f12276a, "\turl list is null", new Object[0]);
            } else {
                this.t.fireUrls(list, null);
            }
        }
    }

    private void a(Map map, TrackingEvent trackingEvent) {
        if (map == null || map.isEmpty()) {
            VastLog.d(this.f12276a, "Processing Event - fail: %s (tracking event map is null or empty)", trackingEvent);
        } else {
            a((List) map.get(trackingEvent));
        }
    }

    private boolean a(VastRequest vastRequest, Boolean bool, boolean z2) {
        stopPlayback();
        if (!z2) {
            this.u = new b0();
        }
        if (bool != null) {
            this.u.e = bool.booleanValue();
        }
        this.t = vastRequest;
        if (vastRequest == null) {
            e();
            VastLog.e(this.f12276a, "VastRequest is null. Stop playing...", new Object[0]);
            return false;
        }
        VastAd vastAd = vastRequest.getVastAd();
        if (vastAd == null) {
            e();
            VastLog.e(this.f12276a, "VastAd is null. Stop playing...", new Object[0]);
            return false;
        }
        CacheControl cacheControl = vastRequest.getCacheControl();
        if (cacheControl == CacheControl.PartialLoad && !isVideoFileLoaded()) {
            a(vastRequest, vastAd, cacheControl, z2);
            return true;
        }
        if (cacheControl != CacheControl.Stream || isVideoFileLoaded()) {
            a(vastRequest, vastAd, z2);
            return true;
        }
        a(vastRequest, vastAd, cacheControl, z2);
        vastRequest.performCache(getContext().getApplicationContext(), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError) {
        VastLog.e(this.f12276a, "handleCompanionExpired - %s", iabError);
        a(VastSpecError.GENERAL_COMPANION);
        if (this.q != null) {
            k();
            a(true);
        }
    }

    private void a(VastViewListener vastViewListener, VastRequest vastRequest, IabError iabError) {
        if (vastViewListener == null || vastRequest == null) {
            return;
        }
        vastViewListener.onShowFailed(this, vastRequest, iabError);
    }

    private IabElementStyle a(VastExtension vastExtension, IabElementStyle iabElementStyle) {
        if (vastExtension == null) {
            return null;
        }
        if (iabElementStyle == null) {
            IabElementStyle iabElementStyle2 = new IabElementStyle();
            iabElementStyle2.setStrokeColor(vastExtension.getAssetsColor());
            iabElementStyle2.setFillColor(vastExtension.getAssetsBackgroundColor());
            return iabElementStyle2;
        }
        if (!iabElementStyle.hasStrokeColor()) {
            iabElementStyle.setStrokeColor(vastExtension.getAssetsColor());
        }
        if (!iabElementStyle.hasFillColor()) {
            iabElementStyle.setFillColor(vastExtension.getAssetsBackgroundColor());
        }
        return iabElementStyle;
    }

    private void a(VastRequest vastRequest, VastAd vastAd, CacheControl cacheControl, boolean z2) {
        vastRequest.setVastVideoLoadedListener(new p(z2, cacheControl));
        f(vastAd.getAppodealExtension());
        setPlaceholderViewVisible(true);
        setLoadingViewVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(CompanionTag companionTag, String str) {
        VastRequest vastRequest = this.t;
        ArrayList arrayList = null;
        VastAd vastAd = vastRequest != null ? vastRequest.getVastAd() : null;
        ArrayList<String> wrapperCompanionClickTrackingUrlList = vastAd != null ? vastAd.getWrapperCompanionClickTrackingUrlList() : null;
        List<String> companionClickTrackingList = companionTag != null ? companionTag.getCompanionClickTrackingList() : null;
        if (wrapperCompanionClickTrackingUrlList != null || companionClickTrackingList != null) {
            arrayList = new ArrayList();
            if (companionClickTrackingList != null) {
                arrayList.addAll(companionClickTrackingList);
            }
            if (wrapperCompanionClickTrackingUrlList != null) {
                arrayList.addAll(wrapperCompanionClickTrackingUrlList);
            }
        }
        return a(arrayList, str);
    }

    private boolean a(List list, String str) {
        VastLog.d(this.f12276a, "processClickThroughEvent: %s", str);
        this.u.l = true;
        if (str == null) {
            return false;
        }
        a(list);
        VastAdMeasurer vastAdMeasurer = this.x;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.onAdClicked();
        }
        if (this.v != null && this.t != null) {
            l();
            setLoadingViewVisibility(true);
            this.v.onClick(this, this.t, this, str);
        }
        return true;
    }

    private void a(VastSpecError vastSpecError) {
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            vastRequest.sendVastSpecError(vastSpecError);
        }
    }

    private void a(TrackingEvent trackingEvent) {
        VastLog.d(this.f12276a, "Track Banner Event: %s", trackingEvent);
        CompanionTag companionTag = this.p;
        if (companionTag != null) {
            a(companionTag.getTrackingEventListMap(), trackingEvent);
        }
    }
}
