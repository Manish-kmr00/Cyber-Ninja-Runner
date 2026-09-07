package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.playon.bridge.AdUnit;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class D5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ba f3048a;
    public final int b;
    public C3529q9 c;
    public L4 d;

    public D5(int i, Ba mRenderView) {
        Intrinsics.checkNotNullParameter(mRenderView, "mRenderView");
        this.f3048a = mRenderView;
        this.b = i;
    }

    public static final void a(D5 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.e(str);
        } catch (Exception e) {
            this$0.f3048a.a(str2, "Unexpected error", "expand");
            AbstractC3498o6.a((byte) 1, "InMobi", "Failed to expand ad; SDK encountered an unexpected error");
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str3 = E5.f3056a;
                ((M4) l4).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling expand() request; ")));
            }
        }
    }

    public static final void b(D5 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        U5.a(this$0.f3048a.getLandingPageHandler(), "open", str, str2, null, false, 24);
    }

    public static final void c(D5 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.getLandingPageHandler().d("openEmbedded", str, str2, null);
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", "openEmbedded");
            AbstractC3498o6.a((byte) 1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str3 = E5.f3056a;
                ((M4) l4).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling openEmbedded() request from creative; ")));
            }
        }
    }

    public static final void d(D5 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        U5.a(this$0.f3048a.getLandingPageHandler(), "openWithoutTracker", str, str2, null, true, 8);
    }

    public static final void e(D5 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Ba ba = this$0.f3048a;
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            ba.b(str, str2.subSequence(i, length + 1).toString());
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", MraidJsMethods.PLAY_VIDEO);
            AbstractC3498o6.a((byte) 1, "InMobi", "Error playing video; SDK encountered an unexpected error");
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str3 = E5.f3056a;
                ((M4) l4).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling playVideo() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void asyncPing(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "asyncPing called: ", url));
        }
        if (!URLUtil.isValidUrl(url)) {
            this.f3048a.a(str, "Invalid url", "asyncPing");
            return;
        }
        try {
            S8 s8 = new S8(url, this.d);
            s8.x = false;
            s8.t = false;
            s8.u = false;
            s8.a(new C3363f1(new C3377g1(s8, new C5(this))));
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "asyncPing");
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                ((M4) l5).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered internal error in handling asyncPing() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void cancelSaveContent(String str, String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "cancelSaveContent called. mediaId:", mediaId));
        }
    }

    @JavascriptInterface
    public final void close(final String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "close called");
        }
        new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                D5.a(this.f$0, str);
            }
        });
    }

    @JavascriptInterface
    public final void closeAll(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "closeAll is called");
        }
        Ba ba = this.f3048a;
        L4 l5 = ba.i;
        if (l5 != null) {
            String str3 = Ba.O0;
            ((M4) l5).a(str3, AbstractC3474ma.a(ba, str3, "TAG", "closeAll "));
        }
        K k = ba.d0;
        if (k != null) {
            k.b();
        }
        Activity activity = (Activity) ba.l.get();
        if (activity != null) {
            activity.finish();
        }
    }

    @JavascriptInterface
    public final void closeCustomExpand(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "closeCustomExpand called.");
        }
        if (this.b != 1) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                ((M4) l5).b(str3, O5.a(str3, "access$getTAG$p(...)", "closeCustomExpand called in incorrect Ad type: ").append(this.b).toString());
                return;
            }
            return;
        }
        if (this.f3048a != null) {
            new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    D5.a(this.f$0);
                }
            });
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).b(str4, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void customExpand(String str, String str2, int i, float f, boolean z, boolean z2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->customExpand(Ljava/lang/String;Ljava/lang/String;IFZZ)V");
        safedk_D5_customExpand_ebeb3987e60eab7157f838e5b8c3f2ed(str, str2, i, f, z, z2);
        BrandSafetyUtils.onMraidExpand(com.safedk.android.utils.h.i, str, str2, this.f3048a, "imraid.customExpand");
    }

    @JavascriptInterface
    public final void disableBackButton(String str, boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "disableBackButton called");
        }
        Ba ba = this.f3048a;
        if (ba != null) {
            ba.setDisableBackButton(z);
            return;
        }
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).b(str3, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void disableCloseRegion(final String str, final boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "disableCloseRegion called");
        }
        if (this.f3048a != null) {
            new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    D5.a(this.f$0, z, str);
                }
            });
            return;
        }
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).b(str3, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void expand(String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->expand(Ljava/lang/String;Ljava/lang/String;)V");
        safedk_D5_expand_30520a66ede2421a9fb058f3c5039531(str, str2);
        BrandSafetyUtils.onMraidExpand(com.safedk.android.utils.h.i, str, str2, this.f3048a, "mraid.expand");
    }

    @JavascriptInterface
    public final void fireAdFailed(String str) {
        try {
            L4 l4 = this.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4).a(str2, "fireAdFailed called.");
            }
            Ba ba = this.f3048a;
            Ia ia = ba.T;
            if (ia != null) {
                Map mapA = ia.a();
                long j = ia.b;
                ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
                mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
                Ob ob = Ob.f3160a;
                Ob.b("FireAdFailed", mapA, Sb.SDK);
            }
            ba.getListener().g(ba);
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "fireAdFailed");
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                ((M4) l5).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling fireAdFailed() signal from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void fireAdReady(String str) {
        try {
            L4 l4 = this.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4).a(str2, "fireAdReady called.");
            }
            this.f3048a.i();
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "fireAdReady");
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                ((M4) l5).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling fireAdReady() signal from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void fireComplete(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "fireComplete is called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String str4 = Ba.O0;
            ((M4) l6).c(str4, AbstractC3474ma.a(ba, str4, "TAG", "completeFromInterActive "));
        }
        J2 j2 = ba.H0;
        if (j2 != null && !j2.g.get()) {
            j2.d.i = 1;
            Intrinsics.checkNotNull(j2.c);
        }
        L4 l7 = ba.i;
        if (l7 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l7).a(TAG, "completeFromInterActive");
        }
    }

    @JavascriptInterface
    public final void fireSkip(String str) {
        L4 l4;
        L4 l5 = this.d;
        if (l5 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l5).a(str2, "fireSkip is called");
        }
        if (this.f3048a == null && (l4 = this.d) != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).b(str3, "Found a null instance of render view!");
        }
        Ba ba = this.f3048a;
        L4 l6 = ba.i;
        if (l6 != null) {
            String str4 = Ba.O0;
            ((M4) l6).c(str4, AbstractC3474ma.a(ba, str4, "TAG", "skipFromInterActive "));
        }
        J2 j2 = ba.H0;
        if (j2 != null && !j2.g.get()) {
            j2.d.h = 1;
            Intrinsics.checkNotNull(j2.c);
        }
        L4 l7 = ba.i;
        if (l7 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l7).a(TAG, "skipFromInterActive");
        }
    }

    @JavascriptInterface
    public final String getAdContext(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getAdContext is called");
        }
        K adPodHandler = this.f3048a.getAdPodHandler();
        if (adPodHandler != null) {
            return ((C0) adPodHandler).K();
        }
        return null;
    }

    @JavascriptInterface
    public final void getBlob(String str, String str2) {
        L1 l1;
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "getBlob is called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).a(TAG, "getBlob");
        }
        if (str == null || str2 == null || (l1 = ba.W) == null) {
            return;
        }
        ((C0) l1).a(str, str2, ba, ba.getImpressionId());
    }

    @JavascriptInterface
    public final String getCurrentPosition(String str) {
        Ba ba;
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getCurrentPosition called");
        }
        Ba ba2 = this.f3048a;
        if (ba2 == null) {
            L4 l5 = this.d;
            if (l5 == null) {
                return "";
            }
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).b(str3, "Found a null instance of render view!");
            return "";
        }
        synchronized (ba2.getCurrentPositionMonitor()) {
            this.f3048a.B = true;
            new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    D5.b(this.f$0);
                }
            });
            while (true) {
                ba = this.f3048a;
                if (ba.B) {
                    try {
                        ba.getCurrentPositionMonitor().wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return ba.getCurrentPosition();
    }

    @JavascriptInterface
    public final int getCurrentRenderingIndex(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getCurrentRenderingIndex is called");
        }
        return this.f3048a.getCurrentRenderingPodAdIndex();
    }

    @JavascriptInterface
    public final String getDefaultPosition(String str) {
        Ba ba;
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getDefaultPosition called");
        }
        Ba ba2 = this.f3048a;
        if (ba2 == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
            }
            String string = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        synchronized (ba2.getDefaultPositionMonitor()) {
            this.f3048a.A = true;
            new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    D5.c(this.f$0);
                }
            });
            while (true) {
                ba = this.f3048a;
                if (ba.A) {
                    try {
                        ba.getDefaultPositionMonitor().wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return ba.getDefaultPosition();
    }

    @JavascriptInterface
    public final int getDeviceVolume(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getDeviceVolume called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
            }
            return -1;
        }
        try {
            M6 mediaProcessor = ba.getMediaProcessor();
            if (mediaProcessor != null) {
                return mediaProcessor.a();
            }
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "getDeviceVolume");
            L4 l6 = this.d;
            if (l6 != null) {
                String str4 = E5.f3056a;
                ((M4) l6).b(str4, ld.a(e, O5.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getDeviceVolume() request from creative; ")));
            }
        }
        return -1;
    }

    @JavascriptInterface
    public final String getExpandProperties(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getExpandedProperties called");
        }
        Ba ba = this.f3048a;
        if (ba != null) {
            T3 expandProperties = ba.getExpandProperties();
            Intrinsics.checkNotNull(expandProperties);
            return expandProperties.f3199a;
        }
        L4 l5 = this.d;
        if (l5 == null) {
            return "";
        }
        String str3 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
        ((M4) l5).b(str3, "Found a null instance of render view!");
        return "";
    }

    @JavascriptInterface
    public final int getMaxDeviceVolume(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getMaxDeviceVolume called");
        }
        try {
            return C3435k3.f3355a.m();
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "getMaxDeviceVolume");
            L4 l5 = this.d;
            if (l5 == null) {
                return 0;
            }
            String str3 = E5.f3056a;
            ((M4) l5).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getMaxDeviceVolume() request from creative; ")));
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b2 A[Catch: Exception -> 0x00cc, TRY_LEAVE, TryCatch #2 {Exception -> 0x00cc, blocks: (B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x0031, B:15:0x0036, B:16:0x0043, B:20:0x0068, B:21:0x007b, B:29:0x008d, B:30:0x008e, B:27:0x0088, B:31:0x008f, B:37:0x00ae, B:39:0x00b2, B:34:0x009c, B:36:0x00a0, B:22:0x007c, B:26:0x0082), top: B:51:0x0019, inners: #0, #3 }] */
    @JavascriptInterface
    public final String getMaxSize(String str) {
        L4 l4;
        int i;
        int i2;
        L4 l5 = this.d;
        if (l5 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l5).a(str2, "getMaxSize called");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Activity fullScreenActivity = this.f3048a.getFullScreenActivity();
            if (fullScreenActivity == null) {
                Context containerContext = this.f3048a.getContainerContext();
                if ((containerContext instanceof Activity ? (Activity) containerContext : null) == null) {
                    return getScreenSize(str);
                }
                Context containerContext2 = this.f3048a.getContainerContext();
                Intrinsics.checkNotNull(containerContext2, "null cannot be cast to non-null type android.app.Activity");
                fullScreenActivity = (Activity) containerContext2;
            }
            FrameLayout frameLayout = (FrameLayout) fullScreenActivity.findViewById(R.id.content);
            int iA = AbstractC3565t3.a(frameLayout.getWidth());
            int iA2 = AbstractC3565t3.a(frameLayout.getHeight());
            if (this.f3048a.getFullScreenActivity() == null || !(iA == 0 || iA2 == 0)) {
                try {
                    jSONObject.put("width", iA);
                    jSONObject.put("height", iA2);
                } catch (JSONException e) {
                    L4 l6 = this.d;
                    if (l6 != null) {
                        String str3 = E5.f3056a;
                        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                        ((M4) l6).a(str3, "Error while creating max size Json.", e);
                    }
                }
                l4 = this.d;
                if (l4 != null) {
                    String str4 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                    ((M4) l4).a(str4, "getMaxSize called:" + jSONObject);
                }
            } else {
                Intrinsics.checkNotNull(frameLayout);
                B5 b5 = new B5(frameLayout, this.d);
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(b5);
                Boolean bool = Boolean.FALSE;
                synchronized (bool) {
                    try {
                        bool.wait();
                    } catch (InterruptedException unused) {
                    }
                    i = b5.c;
                    i2 = b5.d;
                    Unit unit = Unit.INSTANCE;
                }
                iA2 = i2;
                iA = i;
                jSONObject.put("width", iA);
                jSONObject.put("height", iA2);
                l4 = this.d;
                if (l4 != null) {
                    String str5 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                    ((M4) l4).a(str5, "getMaxSize called:" + jSONObject);
                }
            }
        } catch (Exception e2) {
            this.f3048a.a(str, "Unexpected error", "getMaxSize");
            L4 l7 = this.d;
            if (l7 != null) {
                String str6 = E5.f3056a;
                ((M4) l7).b(str6, ld.a(e2, O5.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getMaxSize() request from creative; ")));
            }
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JavascriptInterface
    public final String getOrientation(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getOrientation called");
        }
        byte bG = AbstractC3565t3.g();
        if (bG == 1) {
            return "0";
        }
        if (bG == 3) {
            return "90";
        }
        if (bG == 2) {
            return "180";
        }
        return bG == 4 ? "270" : "-1";
    }

    @JavascriptInterface
    public final String getOrientationProperties(String str) {
        C3529q9 c3529q9 = this.c;
        String str2 = c3529q9 != null ? c3529q9.d : null;
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            ((M4) l4).a(str3, P5.a(str3, "access$getTAG$p(...)", "getOrientationProperties called: ", str2));
        }
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    @JavascriptInterface
    public final String getPlacementType(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getPlacementType called");
        }
        return 1 == this.b ? "interstitial" : POBCommonConstants.BANNER_PLACEMENT_TYPE;
    }

    @JavascriptInterface
    public final String getPlatform(String str) {
        L4 l4 = this.d;
        if (l4 == null) {
            return "android";
        }
        String str2 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((M4) l4).a(str2, "getPlatform. Platform:android");
        return "android";
    }

    @JavascriptInterface
    public final String getPlatformVersion(String str) {
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "getPlatformVersion. Version:", strValueOf));
        }
        return strValueOf;
    }

    @JavascriptInterface
    public final String getRenderableAdIndexes(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getRenderableAdIndexes is called");
        }
        JSONArray renderableAdIndexes = this.f3048a.getRenderableAdIndexes();
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).a(str3, "renderableAdIndexes called:" + renderableAdIndexes);
        }
        String string = renderableAdIndexes.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JavascriptInterface
    public final String getResizeProperties(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getResizeProperties called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
            }
            return "";
        }
        Ua resizeProperties = ba.getResizeProperties();
        if (resizeProperties == null) {
            return "";
        }
        JSONObject jSONObjectA = new A5().a(resizeProperties);
        String string = jSONObjectA != null ? jSONObjectA.toString() : null;
        return string == null ? "" : string;
    }

    @JavascriptInterface
    public final String getSafeArea(String str) {
        JSONObject safeArea = this.f3048a.getSafeArea();
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getSafeArea called:" + safeArea);
        }
        if (safeArea != null) {
            return safeArea.toString();
        }
        return null;
    }

    @JavascriptInterface
    public final String getScreenSize(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", AbstractC3565t3.h().f3441a);
            jSONObject.put("height", AbstractC3565t3.h().b);
            L4 l4 = this.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4).c(str2, "Message:Width x Height : " + AbstractC3565t3.h().f3441a + 'x' + AbstractC3565t3.h().b);
            }
        } catch (JSONException unused) {
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "getScreenSize");
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                ((M4) l5).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error while getting screen dimensions; ")));
            }
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            ((M4) l6).a(str4, P5.a(str4, "access$getTAG$p(...)", "getScreenSize called:", string));
        }
        return string;
    }

    @JavascriptInterface
    public final String getSdkVersion(String str) {
        L4 l4 = this.d;
        if (l4 == null) {
            return "10.8.2";
        }
        String str2 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((M4) l4).a(str2, "getSdkVersion called. Version:10.8.2");
        return "10.8.2";
    }

    @JavascriptInterface
    public final long getShowTimeStamp(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "getShowTimeStamp is called");
        }
        long showTimeStamp = this.f3048a.getShowTimeStamp();
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).a(str3, "getShowTimeStamp is " + showTimeStamp);
        }
        return showTimeStamp;
    }

    @JavascriptInterface
    public final String getState(String str) {
        String viewState = this.f3048a.getViewState();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = viewState.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).c(str2, P5.a(str2, "access$getTAG$p(...)", "getState called:", lowerCase));
        }
        return lowerCase;
    }

    @JavascriptInterface
    public final String getVersion(String str) {
        L4 l4 = this.d;
        if (l4 == null) {
            return "2.0";
        }
        String str2 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((M4) l4).a(str2, "getVersion called. Version:2.0");
        return "2.0";
    }

    @JavascriptInterface
    public final void impressionFired(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "impressionFired is called");
        }
        Ba ba = this.f3048a;
        L4 l5 = ba.i;
        if (l5 != null) {
            String str3 = Ba.O0;
            ((M4) l5).a(str3, AbstractC3474ma.a(ba, str3, "TAG", "onImpressionFired "));
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String str4 = Ba.O0;
            ((M4) l6).a(str4, AbstractC3474ma.a(ba, str4, "TAG", "recordContextualData "));
        }
        J2 j2 = ba.H0;
        if (j2 != null) {
            j2.a();
        }
        ba.getListener().a(ba.getTelemetryOnAdImpression());
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    public final void incentCompleted(String str, String str2) {
        L4 l4;
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            ((M4) l5).a(str3, P5.a(str3, "access$getTAG$p(...)", "incentCompleted called. IncentData:", str2));
        }
        if (str2 == null) {
            try {
                this.f3048a.getListener().b(new HashMap());
                return;
            } catch (Exception e) {
                this.f3048a.a(str, "Unexpected error", "incentCompleted");
                L4 l6 = this.d;
                if (l6 != null) {
                    String str4 = E5.f3056a;
                    ((M4) l6).b(str4, ld.a(e, O5.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    return;
                }
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str5 = next;
                Object obj = jSONObject.get(str5);
                Intrinsics.checkNotNull(obj);
                map.put(str5, obj);
            }
            try {
                try {
                    this.f3048a.getListener().b(map);
                } catch (Exception e2) {
                    this.f3048a.a(str, "Unexpected error", "incentCompleted");
                    l4 = this.d;
                    if (l4 != null) {
                        String str6 = E5.f3056a;
                        ((M4) l4).b(str6, ld.a(e2, O5.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    }
                }
            } catch (Exception e3) {
                this.f3048a.a(str, "Unexpected error", "incentCompleted");
                L4 l7 = this.d;
                if (l7 != null) {
                    String str7 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$p(...)");
                    ((M4) l7).b(str7, "SDK encountered unexpected error in handling onUserInteraction() signal from creative; " + e3.getMessage());
                    return;
                }
                return;
                this.f3048a.a(str, "Unexpected error", "incentCompleted");
                l4 = this.d;
                if (l4 != null) {
                    String str8 = E5.f3056a;
                    ((M4) l4).b(str8, ld.a(e2, O5.a(str8, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                }
            }
        } catch (JSONException unused) {
            this.f3048a.getListener().b(new HashMap());
        }
    }

    @JavascriptInterface
    public final boolean isBackButtonDisabled(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "isBackButtonDisabled called");
        }
        Ba ba = this.f3048a;
        if (ba != null) {
            return ba.G;
        }
        L4 l5 = this.d;
        if (l5 == null) {
            return false;
        }
        String str3 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
        ((M4) l5).b(str3, "Found a null instance of render view!");
        return false;
    }

    @JavascriptInterface
    public final String isDeviceMuted(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "isDeviceMuted called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 == null) {
                return "false";
            }
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).b(str3, "Found a null instance of render view!");
            return "false";
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).a(str4, "JavaScript called: isDeviceMuted()");
        }
        boolean z = false;
        try {
            M6 mediaProcessor = this.f3048a.getMediaProcessor();
            Intrinsics.checkNotNull(mediaProcessor);
            L4 l7 = mediaProcessor.b;
            if (l7 != null) {
                ((M4) l7).c("MraidMediaProcessor", "isVolumeMuted");
            }
            Context contextD = C3517pb.d();
            if (contextD != null) {
                Object systemService = contextD.getSystemService("audio");
                AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
                if (audioManager != null && 2 != audioManager.getRingerMode()) {
                    z = true;
                }
            }
        } catch (Exception e) {
            L4 l8 = this.d;
            if (l8 != null) {
                String str5 = E5.f3056a;
                ((M4) l8).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in checking if device is muted; ")));
            }
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public final String isHeadphonePlugged(String str) {
        boolean zB;
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "isHeadphonePlugged called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 == null) {
                return "false";
            }
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).b(str3, "Found a null instance of render view!");
            return "false";
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).a(str4, "JavaScript called: isHeadphonePlugged()");
        }
        try {
            M6 mediaProcessor = this.f3048a.getMediaProcessor();
            Intrinsics.checkNotNull(mediaProcessor);
            mediaProcessor.getClass();
            zB = M6.b();
        } catch (Exception e) {
            L4 l7 = this.d;
            if (l7 != null) {
                String str5 = E5.f3056a;
                ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in checking if headphones are plugged-in; ")));
            }
            zB = false;
        }
        return String.valueOf(zB);
    }

    @JavascriptInterface
    public final boolean isViewable(String str) {
        String str2 = E5.f3056a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        Ba ba = this.f3048a;
        if (ba != null) {
            return ba.E == Xc.VISIBLE;
        }
        L4 l4 = this.d;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).b(str2, "Found a null instance of render view!");
        }
        return false;
    }

    @JavascriptInterface
    public final void loadAd(String str, int i) {
        K k;
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "loadAd is called");
        }
        Ba ba = this.f3048a;
        L4 l5 = ba.i;
        if (l5 != null) {
            String str3 = Ba.O0;
            ((M4) l5).a(str3, AbstractC3474ma.a(ba, str3, "TAG", "loadPodAd "));
        }
        if (ba.E == Xc.VISIBLE && (k = ba.d0) != null) {
            k.a(i, ba);
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).b(TAG, "Cannot load index pod ad as the current ad is not viewable");
        }
        ba.a(false);
    }

    @JavascriptInterface
    public final void log(String str, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).c(str2, P5.a(str2, "access$getTAG$p(...)", "Log called. Message:", message));
        }
        Ba ba = this.f3048a;
        ba.getClass();
        C3516pa c3516pa = Ba.M0;
        c3516pa.getClass();
        if (!((Boolean) Ba.P0.getValue(c3516pa, C3516pa.f3399a[0])).booleanValue() || message == null) {
            return;
        }
        ba.getListener().a(message);
    }

    @JavascriptInterface
    public final void logTelemetryEvent(String str, String eventType, String str2) {
        if (eventType == null) {
            L4 l4 = this.d;
            if (l4 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l4).b(str3, "eventType is null");
                return;
            }
            return;
        }
        L4 l5 = this.d;
        if (l5 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l5).a(str4, "logTelemetryEvent is called: ".concat(eventType));
        }
        Ba ba = this.f3048a;
        ba.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Ia ia = ba.T;
        if (ia != null) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            if (ia.f.get()) {
                return;
            }
            if (ia.e.decrementAndGet() <= 0) {
                ia.f.set(true);
                Map mapA = ia.a();
                long j = ia.b;
                ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
                mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
                Ob ob = Ob.f3160a;
                Ob.b("TemplateEventDropped", mapA, Sb.SDK);
                return;
            }
            if (str2 != null) {
                try {
                    if (new JSONObject(str2).length() == 0) {
                        str2 = null;
                    }
                } catch (JSONException e) {
                    Log.e(Ob.b, "Error parsing JSON: " + e);
                }
            }
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("plType", String.valueOf(ia.f3098a.f3060a.m())), TuplesKt.to("markupType", ia.f3098a.b), TuplesKt.to("networkType", C3435k3.q()));
            if (str2 != null) {
                mapMutableMapOf.put("payload", str2);
            }
            if (ia.f3098a.c.length() > 0) {
                mapMutableMapOf.put("metadataBlob", ia.f3098a.c);
            }
            Ob.b(eventType, mapMutableMapOf, Sb.TEMPLATE);
        }
    }

    @JavascriptInterface
    public final void onAudioStateChanged(String str, int i) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "onAudioStateChanged is called: " + i);
        }
        EnumC3479n1.b.getClass();
        EnumC3479n1 enumC3479n1 = (EnumC3479n1) EnumC3479n1.c.get(i);
        if (enumC3479n1 == null) {
            enumC3479n1 = EnumC3479n1.d;
        }
        if (enumC3479n1 != EnumC3479n1.d) {
            this.f3048a.getListener().a(enumC3479n1);
        }
    }

    @JavascriptInterface
    public final void onOrientationChange(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, ">>> onOrientationChange() >>> This API is deprecated!");
        }
    }

    @JavascriptInterface
    public final void onUserAudioMuteInteraction(String str, boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "onAudioMuteInteraction is called: " + z);
        }
        this.f3048a.getListener().a(z);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    public final void onUserInteraction(String str, String str2) {
        L4 l4;
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).a(str3, "onUserInteraction called");
        }
        Ba ba = this.f3048a;
        if (ba != null && !ba.l()) {
            this.f3048a.a("onUserInteraction");
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            ((M4) l6).a(str4, P5.a(str4, "access$getTAG$p(...)", "onUserInteraction called. Params:", str2));
        }
        if (str2 == null) {
            try {
                this.f3048a.getListener().a(new HashMap());
                return;
            } catch (Exception e) {
                this.f3048a.a(str, "Unexpected error", "onUserInteraction");
                L4 l7 = this.d;
                if (l7 != null) {
                    String str5 = E5.f3056a;
                    ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    return;
                }
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str6 = next;
                Object obj = jSONObject.get(str6);
                Intrinsics.checkNotNull(obj);
                map.put(str6, obj);
            }
            try {
                try {
                    this.f3048a.getListener().a(map);
                } catch (Exception e2) {
                    this.f3048a.a(str, "Unexpected error", "onUserInteraction");
                    l4 = this.d;
                    if (l4 != null) {
                        String str7 = E5.f3056a;
                        ((M4) l4).b(str7, ld.a(e2, O5.a(str7, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    }
                }
            } catch (Exception e3) {
                this.f3048a.a(str, "Unexpected error", "onUserInteraction");
                L4 l8 = this.d;
                if (l8 != null) {
                    String str8 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str8, "access$getTAG$p(...)");
                    ((M4) l8).b(str8, "SDK encountered unexpected error in handling onUserInteraction() signal from creative; " + e3.getMessage());
                    return;
                }
                return;
                this.f3048a.a(str, "Unexpected error", "onUserInteraction");
                l4 = this.d;
                if (l4 != null) {
                    String str9 = E5.f3056a;
                    ((M4) l4).b(str9, ld.a(e2, O5.a(str9, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                }
            }
        } catch (JSONException unused) {
            this.f3048a.getListener().a(new HashMap());
        }
    }

    @JavascriptInterface
    public final void open(String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->open(Ljava/lang/String;Ljava/lang/String;)V");
        safedk_D5_open_0766d35e6c350ed5acacc5ec9b8b1188(str, str2);
        BrandSafetyUtils.onMraidOpen(com.safedk.android.utils.h.i, str, str2, this.f3048a, "mraid.open");
    }

    @JavascriptInterface
    public final void openEmbedded(String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->openEmbedded(Ljava/lang/String;Ljava/lang/String;)V");
        safedk_D5_openEmbedded_7cd9192205c3951eeb11b03f10fb5910(str, str2);
        BrandSafetyUtils.onMraidOpen(com.safedk.android.utils.h.i, str, str2, this.f3048a, "imraid.openEmbedded");
    }

    @JavascriptInterface
    public final void openExternal(String str, String str2, String str3) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->openExternal(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        safedk_D5_openExternal_13553e4801f7fc68a25c20c4f3906e42(str, str2, str3);
        BrandSafetyUtils.onMraidOpen(com.safedk.android.utils.h.i, str, str2, this.f3048a, "imraid.openExternal");
    }

    @JavascriptInterface
    public final void openWithoutTracker(String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/D5;->openWithoutTracker(Ljava/lang/String;Ljava/lang/String;)V");
        safedk_D5_openWithoutTracker_87000ee0ae174f649470d2c3a3a8dc23(str, str2);
        BrandSafetyUtils.onMraidOpen(com.safedk.android.utils.h.i, str, str2, this.f3048a, "imraid.openWithoutTracker");
    }

    @JavascriptInterface
    public final void ping(String str, String str2, boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "ping called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && URLUtil.isValidUrl(str2)) {
                L4 l6 = this.d;
                if (l6 != null) {
                    String str5 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                    ((M4) l6).a(str5, "JavaScript called ping() URL: >>> " + str2 + " <<<");
                }
                try {
                    C3364f2.f3308a.a(str2, z, this.d);
                    return;
                } catch (Exception e) {
                    this.f3048a.a(str, "Unexpected error", "ping");
                    AbstractC3498o6.a((byte) 1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                    L4 l7 = this.d;
                    if (l7 != null) {
                        String str6 = E5.f3056a;
                        ((M4) l7).b(str6, ld.a(e, O5.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling ping() request from creative; ")));
                        return;
                    }
                    return;
                }
            }
        }
        this.f3048a.a(str, "Invalid URL:" + str2, "ping");
    }

    @JavascriptInterface
    public final void pingInWebView(String str, String str2, boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "openInWebView called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && URLUtil.isValidUrl(str2)) {
                L4 l6 = this.d;
                if (l6 != null) {
                    String str5 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                    ((M4) l6).a(str5, "JavaScript called pingInWebView() URL: >>> " + str2 + " <<<");
                }
                try {
                    C3364f2.f3308a.b(str2, z, this.d);
                    return;
                } catch (Exception e) {
                    this.f3048a.a(str, "Unexpected error", "pingInWebView");
                    AbstractC3498o6.a((byte) 1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                    L4 l7 = this.d;
                    if (l7 != null) {
                        String str6 = E5.f3056a;
                        ((M4) l7).b(str6, ld.a(e, O5.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling pingInWebView() request from creative; ")));
                        return;
                    }
                    return;
                }
            }
        }
        this.f3048a.a(str, "Invalid URL:" + str2, "pingInWebView");
    }

    @JavascriptInterface
    public final void playVideo(final String str, final String str2) {
        if (this.f3048a == null) {
            L4 l4 = this.d;
            if (l4 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l4).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && StringsKt.startsWith$default(str2, "http", false, 2, (Object) null) && (StringsKt.endsWith$default(str2, com.safedk.android.utils.n.d, false, 2, (Object) null) || StringsKt.endsWith$default(str2, "avi", false, 2, (Object) null) || StringsKt.endsWith$default(str2, "m4v", false, 2, (Object) null))) {
                L4 l5 = this.d;
                if (l5 != null) {
                    String str4 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                    ((M4) l5).a(str4, "JavaScript called: playVideo (" + str2 + ')');
                }
                new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        D5.e(this.f$0, str, str2);
                    }
                });
                return;
            }
        }
        this.f3048a.a(str, "Null or empty or invalid media playback URL supplied", MraidJsMethods.PLAY_VIDEO);
    }

    @JavascriptInterface
    public final void registerBackButtonPressedEventListener(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "registerBackButtonPressedEventListener called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            L4 l6 = ba.i;
            if (l6 != null) {
                String TAG = Ba.O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l6).a(TAG, "registerBackButtonPressedEventListener " + ba);
            }
            ba.H = str;
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "registerBackButtonPressedEventListener");
            L4 l7 = this.d;
            if (l7 != null) {
                String str4 = E5.f3056a;
                ((M4) l7).b(str4, ld.a(e, O5.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerBackButtonPressedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void registerDeviceMuteEventListener(String jsCallbackNamespace) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "registerDeviceMuteEventListener called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l5).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                M6 mediaProcessor = ba.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    if (mediaProcessor.d == null) {
                        C3638y6 c3638y6 = new C3638y6(new J6(mediaProcessor, jsCallbackNamespace));
                        mediaProcessor.d = c3638y6;
                        c3638y6.b();
                    }
                }
            } catch (Exception e) {
                this.f3048a.a(jsCallbackNamespace, "Unexpected error", "registerDeviceMuteEventListener");
                L4 l6 = this.d;
                if (l6 != null) {
                    String str3 = E5.f3056a;
                    ((M4) l6).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerDeviceMuteEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void registerDeviceVolumeChangeEventListener(String jsCallbackNamespace) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "registerDeviceVolumeChangeEventListener called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l5).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                M6 mediaProcessor = ba.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    Context contextD = C3517pb.d();
                    if (contextD != null && mediaProcessor.e == null) {
                        C3638y6 c3638y6 = new C3638y6(new K6(mediaProcessor, jsCallbackNamespace, contextD, new Handler(Looper.getMainLooper())));
                        mediaProcessor.e = c3638y6;
                        c3638y6.b();
                    }
                }
            } catch (Exception e) {
                this.f3048a.a(jsCallbackNamespace, "Unexpected error", "registerDeviceVolumeChangeEventListener");
                L4 l6 = this.d;
                if (l6 != null) {
                    String str3 = E5.f3056a;
                    ((M4) l6).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerDeviceVolumeChangeEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void registerHeadphonePluggedEventListener(String jsCallbackNamespace) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "registerHeadphonePluggedEventListener called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l5).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                M6 mediaProcessor = ba.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    if (mediaProcessor.f == null) {
                        C3638y6 c3638y6 = new C3638y6(new I6(mediaProcessor, jsCallbackNamespace));
                        mediaProcessor.f = c3638y6;
                        c3638y6.b();
                    }
                }
            } catch (Exception e) {
                this.f3048a.a(jsCallbackNamespace, "Unexpected error", "registerHeadphonePluggedEventListener");
                L4 l6 = this.d;
                if (l6 != null) {
                    String str3 = E5.f3056a;
                    ((M4) l6).b(str3, ld.a(e, O5.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerHeadphonePluggedEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void resize(final String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "resize called");
        }
        if (this.b != 1) {
            if (this.f3048a != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        D5.b(this.f$0, str);
                    }
                });
                return;
            }
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
            }
        }
    }

    @JavascriptInterface
    public void safedk_D5_customExpand_ebeb3987e60eab7157f838e5b8c3f2ed(final String p0, final String p1, final int p2, final float p3, boolean p4, final boolean p5) {
        Z5 z5;
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "customExpand called");
        }
        if (this.b != 1) {
            L4 l5 = this.d;
            if (l5 != null) {
                String p6 = E5.f3056a;
                ((M4) l5).b(p6, O5.a(p6, "access$getTAG$p(...)", "customExpand called in incorrect Ad type: ").append(this.b).toString());
                return;
            }
            return;
        }
        if (p1 != null) {
            int length = p1.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) p1.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (p1.subSequence(i, length + 1).toString().length() != 0) {
                if (p2 < 0 || p2 >= EnumC3621x3.values().length) {
                    this.f3048a.a(p0, "Invalid inputType", "customExpand");
                    return;
                }
                if (p3 < 0.0f || p3 > 1.0f) {
                    this.f3048a.a(p0, "Invalid screenPercentage", "customExpand");
                    return;
                }
                C3297a6 c3297a6 = this.f3048a.getLandingPageHandler().f;
                if (c3297a6 != null) {
                    String strA = R5.a(p1);
                    U5 landingPageHandler = this.f3048a.getLandingPageHandler();
                    int i2 = landingPageHandler.h + 1;
                    landingPageHandler.h = i2;
                    z5 = new Z5(c3297a6, strA, i2, 8);
                } else {
                    z5 = null;
                }
                final Z5 z6 = z5;
                if (z6 != null) {
                    z6.g = "IN_CUSTOM";
                }
                U5 landingPageHandler2 = this.f3048a.getLandingPageHandler();
                N5 funnelState = N5.LPClickStart;
                Integer numValueOf = Integer.valueOf(AdUnit.ERROR_MEDIA_PLAYER_ERROR);
                landingPageHandler2.getClass();
                Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                R5.a(funnelState, z6, numValueOf, new T5(landingPageHandler2));
                new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        D5.a(this.f$0, z6, p1, p2, p0, p3, p5);
                    }
                });
                return;
            }
        }
        this.f3048a.a(p0, "Invalid " + p2, "customExpand");
    }

    @JavascriptInterface
    public void safedk_D5_expand_30520a66ede2421a9fb058f3c5039531(final String p0, final String p1) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "expand called");
        }
        if (this.b != 1) {
            Ba ba = this.f3048a;
            if (ba == null) {
                L4 l5 = this.d;
                if (l5 != null) {
                    String p2 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(p2, "access$getTAG$p(...)");
                    ((M4) l5).b(p2, "Found a null instance of render view!");
                    return;
                }
                return;
            }
            if (!ba.l()) {
                this.f3048a.a("expand");
                return;
            }
            L4 l6 = this.d;
            if (l6 != null) {
                String str2 = E5.f3056a;
                ((M4) l6).a(str2, P5.a(str2, "access$getTAG$p(...)", "expand called. Url:", p1));
            }
            Ba ba2 = this.f3048a;
            if (ba2.E != Xc.VISIBLE) {
                ba2.a(p0, "Creative is not visible. Ignoring request.", "expand");
                return;
            }
            if (p1 != null && p1.length() > 0 && !StringsKt.startsWith$default(p1, "http", false, 2, (Object) null)) {
                this.f3048a.a(p0, "Invalid URL", "expand");
                return;
            }
            if (URLUtil.isValidUrl(p1)) {
                this.f3048a.j();
            }
            new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    D5.a(this.f$0, p1, p0);
                }
            });
        }
    }

    @JavascriptInterface
    public void safedk_D5_openEmbedded_7cd9192205c3951eeb11b03f10fb5910(final String p0, final String p1) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "openEmbedded called");
        }
        if (!this.f3048a.l()) {
            this.f3048a.a("openEmbedded");
        } else {
            this.f3048a.j();
            Lb.a(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    D5.c(this.f$0, p0, p1);
                }
            });
        }
    }

    @JavascriptInterface
    public void safedk_D5_openExternal_13553e4801f7fc68a25c20c4f3906e42(String p0, String url, String p2) {
        Z5 z5;
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "open External");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String p1 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(p1, "access$getTAG$p(...)");
                ((M4) l5).b(p1, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (!ba.l()) {
            this.f3048a.a("openExternal");
            return;
        }
        this.f3048a.j();
        L4 l6 = this.d;
        if (l6 != null) {
            String str2 = E5.f3056a;
            ((M4) l6).a(str2, P5.a(str2, "access$getTAG$p(...)", "openExternal called with url: ", url));
        }
        C3297a6 c3297a6 = this.f3048a.getLandingPageHandler().f;
        if (c3297a6 != null) {
            String strA = R5.a(url);
            U5 landingPageHandler = this.f3048a.getLandingPageHandler();
            int i = landingPageHandler.h + 1;
            landingPageHandler.h = i;
            z5 = new Z5(c3297a6, strA, i, 8);
        } else {
            z5 = null;
        }
        if (z5 != null) {
            z5.g = "EX_NATIVE";
        }
        U5 landingPageHandler2 = this.f3048a.getLandingPageHandler();
        N5 funnelState = N5.LPClickStart;
        landingPageHandler2.getClass();
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        R5.a(funnelState, z5, (Integer) null, new T5(landingPageHandler2));
        U5 landingPageHandler3 = this.f3048a.getLandingPageHandler();
        landingPageHandler3.getClass();
        Intrinsics.checkNotNullParameter("openExternal", "api");
        if (url != null) {
            landingPageHandler3.e(p0, url, p2, z5);
            return;
        }
        if (p2 != null) {
            landingPageHandler3.e(p0, p2, null, z5);
            return;
        }
        N5 funnelState2 = N5.LPStartFailed;
        Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
        R5.a(funnelState2, z5, (Integer) 2, (Function2) new T5(landingPageHandler3));
        C3614wa c3614wa = landingPageHandler3.d;
        if (c3614wa != null) {
            Intrinsics.checkNotNullParameter("Empty url and fallback url", "message");
            c3614wa.f3467a.a(p0, "Empty url and fallback url", "openExternal");
        }
        L4 l7 = landingPageHandler3.g;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l7).b("U5", "Empty deeplink and fallback urls");
        }
    }

    @JavascriptInterface
    public void safedk_D5_openWithoutTracker_87000ee0ae174f649470d2c3a3a8dc23(final String p0, final String p1) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "openWithoutTracker called");
        }
        Ba ba = this.f3048a;
        if (ba != null) {
            if (ba.l()) {
                Lb.a(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        D5.d(this.f$0, p0, p1);
                    }
                });
                return;
            } else {
                this.f3048a.a("openWithoutTracker");
                return;
            }
        }
        L4 l5 = this.d;
        if (l5 != null) {
            String p2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(p2, "access$getTAG$p(...)");
            ((M4) l5).b(p2, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public void safedk_D5_open_0766d35e6c350ed5acacc5ec9b8b1188(final String p0, final String p1) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "open called");
        }
        if (!this.f3048a.l()) {
            this.f3048a.a("open");
        } else {
            this.f3048a.j();
            Lb.a(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    D5.b(this.f$0, p0, p1);
                }
            });
        }
    }

    @JavascriptInterface
    public final void saveBlob(String str, String str2) {
        L1 l1;
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "saveBlob is called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).a(TAG, "saveBlob");
        }
        if (str2 == null || (l1 = ba.W) == null) {
            return;
        }
        ((C0) l1).a(str2, ba.getImpressionId());
    }

    @JavascriptInterface
    public final void saveContent(String str, String str2, String str3) {
        if (str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0) {
            try {
                this.f3048a.b(str, str2, str3);
                return;
            } catch (Exception e) {
                this.f3048a.a(str, "Unexpected error", "saveContent");
                L4 l4 = this.d;
                if (l4 != null) {
                    String str4 = E5.f3056a;
                    ((M4) l4).b(str4, ld.a(e, O5.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling saveContent() request from creative; ")));
                    return;
                }
                return;
            }
        }
        L4 l5 = this.d;
        if (l5 != null) {
            String str5 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
            ((M4) l5).a(str5, "saveContent called with invalid parameters");
        }
        JSONObject jSONObject = new JSONObject();
        if (str3 == null) {
            str3 = "";
        }
        try {
            jSONObject.put("url", str3);
            jSONObject.put("reason", 8);
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strReplace$default = StringsKt.replace$default(string, "\"", "\\\"", false, 4, (Object) null);
        StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
        if (str2 == null) {
            str2 = "";
        }
        this.f3048a.a(str, sb.append(str2).append("\", 'failed', \"").append(strReplace$default).append("\");").toString());
    }

    @JavascriptInterface
    public final void setAdContext(String str, String podAdContext) {
        Intrinsics.checkNotNullParameter(podAdContext, "podAdContext");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "setAdContext is called ", podAdContext));
        }
        K adPodHandler = this.f3048a.getAdPodHandler();
        if (adPodHandler != null) {
            ((C0) adPodHandler).d(podAdContext);
        }
    }

    @JavascriptInterface
    public final void setCloseEndCardTracker(String str, String str2) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "setCloseEndCardTracker is called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            ba.setCloseEndCardTracker(str2);
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "getDownloadStatus");
            L4 l6 = this.d;
            if (l6 != null) {
                String str5 = E5.f3056a;
                ((M4) l6).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getDownloadStatus() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void setExpandProperties(String str, String json) {
        Intrinsics.checkNotNullParameter(json, "expandPropertiesString");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "setExpandProperties called. Params:", json));
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("Expanded", ba.getViewState())) {
            L4 l6 = this.d;
            if (l6 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l6).b(str4, "setExpandProperties can't be called on an already expanded ad.");
                return;
            }
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(json, "json");
            T3 t3 = new T3();
            t3.f3199a = json;
            try {
                JSONObject jSONObject = new JSONObject(json);
                if (jSONObject.has(MraidJsMethods.USE_CUSTOM_CLOSE)) {
                    t3.c = true;
                }
                t3.b = jSONObject.optBoolean(MraidJsMethods.USE_CUSTOM_CLOSE, false);
            } catch (JSONException unused) {
            }
            this.f3048a.setExpandProperties(t3);
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "setExpandProperties");
            L4 l7 = this.d;
            if (l7 != null) {
                String str5 = E5.f3056a;
                ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in setExpandProperties(); ")));
            }
        }
    }

    @JavascriptInterface
    public final void setOrientationProperties(String str, final String orientationPropertiesString) {
        Intrinsics.checkNotNullParameter(orientationPropertiesString, "orientationPropertiesString");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "setOrientationProperties called: ", orientationPropertiesString));
        }
        new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                D5.c(this.f$0, orientationPropertiesString);
            }
        });
    }

    @JavascriptInterface
    public final void setResizeProperties(String str, String json) {
        Ua ua;
        String strB;
        Intrinsics.checkNotNullParameter(json, "resizePropertiesString");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "setResizeProperties called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            ((M4) l6).a(str4, P5.a(str4, "access$getTAG$p(...)", "setResizeProperties called. Properties:", json));
        }
        Ua resizeProperties = this.f3048a.getResizeProperties();
        Ua.Companion.getClass();
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            ua = (Ua) new A5().a(new JSONObject(json), Ua.class);
            if (ua != null) {
                if (ua.b() == null) {
                    if (resizeProperties == null || (strB = resizeProperties.b()) == null) {
                        strB = "top-right";
                    }
                    ua.a(strB);
                }
                ua.a(resizeProperties != null ? resizeProperties.a() : true);
            } else {
                ua = null;
            }
        } catch (JSONException unused) {
        }
        if (ua == null) {
            this.f3048a.a(str, "setResizeProperties", "All mandatory fields are not present");
        }
        this.f3048a.setResizeProperties(ua);
    }

    @JavascriptInterface
    public final void showAd(String str, int i) {
        K k;
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "showAd is called");
        }
        Ba ba = this.f3048a;
        L4 l5 = ba.i;
        if (l5 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "showPodAdAtIndex " + ba + ' ' + i);
        }
        if (ba.E == Xc.VISIBLE && (k = ba.d0) != null) {
            k.a(i, ba, ba.getFullScreenActivity());
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String TAG2 = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l6).b(TAG2, "Cannot show index pod ad as the current ad is not viewable");
        }
        ba.b(false);
    }

    @JavascriptInterface
    public final void showAlert(String str, String alert) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "showAlert: ", alert));
        }
    }

    @JavascriptInterface
    public final void showEndCard(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "showEndCard is called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = ba.i;
        if (l6 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).a(TAG, "showEndCardFromInterActive");
        }
        r referenceContainer = ba.getReferenceContainer();
        if (referenceContainer instanceof C3313b7) {
            ((C3313b7) referenceContainer).o();
        }
    }

    @JavascriptInterface
    public final void storePicture(String str, String str2) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4).a(str3, "storePicture is deprecated and no-op. ");
        }
    }

    @JavascriptInterface
    public final void submitAdReport(String str, String adQualityUrl, String enableUserAdReportScreenshot, String templateInfo) {
        Intrinsics.checkNotNullParameter(adQualityUrl, "adQualityUrl");
        Intrinsics.checkNotNullParameter(enableUserAdReportScreenshot, "enableUserAdReportScreenshot");
        Intrinsics.checkNotNullParameter(templateInfo, "templateInfo");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "submitAdReport called");
        }
        this.f3048a.a(adQualityUrl, templateInfo, Intrinsics.areEqual(enableUserAdReportScreenshot, "1"));
    }

    @JavascriptInterface
    public final String supports(String str, String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$p(...)", "Checking support for: ", feature));
        }
        String strValueOf = String.valueOf(this.f3048a.f(feature));
        L4 l5 = this.d;
        if (l5 != null) {
            String str3 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l5).c(str3, "Message:" + feature + " support: " + strValueOf);
        }
        return strValueOf;
    }

    @JavascriptInterface
    public final long timeSinceShow(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "timeSinceShow is called");
        }
        Ba ba = this.f3048a;
        L4 l5 = ba.i;
        if (l5 != null) {
            String str3 = Ba.O0;
            ((M4) l5).c(str3, AbstractC3474ma.a(ba, str3, "TAG", "timeSincePodShow "));
        }
        K k = ba.d0;
        if (k != null) {
            return ((C0) k).A0();
        }
        return 0L;
    }

    @JavascriptInterface
    public final void unregisterBackButtonPressedEventListener(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "unregisterBackButtonPressedEventListener called");
        }
        Ba ba = this.f3048a;
        if (ba == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            L4 l6 = ba.i;
            if (l6 != null) {
                String TAG = Ba.O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l6).a(TAG, "unregisterBackButtonPressedEventListener " + ba);
            }
            ba.H = null;
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "unregisterBackButtonPressedEventListener");
            L4 l7 = this.d;
            if (l7 != null) {
                String str4 = E5.f3056a;
                ((M4) l7).b(str4, ld.a(e, O5.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterBackButtonPressedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterDeviceMuteEventListener(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "unregisterDeviceMuteEventListener called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).a(str4, "Unregister device mute event listener ...");
        }
        try {
            M6 mediaProcessor = this.f3048a.getMediaProcessor();
            if (mediaProcessor != null) {
                C3638y6 c3638y6 = mediaProcessor.d;
                if (c3638y6 != null) {
                    c3638y6.a();
                }
                mediaProcessor.d = null;
            }
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "unRegisterDeviceMuteEventListener");
            L4 l7 = this.d;
            if (l7 != null) {
                String str5 = E5.f3056a;
                ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterDeviceMuteEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterDeviceVolumeChangeEventListener(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "unregisterDeviceVolumeChangeEventListener called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).a(str4, "Unregister device volume change listener ...");
        }
        try {
            M6 mediaProcessor = this.f3048a.getMediaProcessor();
            if (mediaProcessor != null) {
                C3638y6 c3638y6 = mediaProcessor.e;
                if (c3638y6 != null) {
                    c3638y6.a();
                }
                mediaProcessor.e = null;
            }
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "unregisterDeviceVolumeChangeEventListener");
            L4 l7 = this.d;
            if (l7 != null) {
                String str5 = E5.f3056a;
                ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterDeviceVolumeChangeEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterHeadphonePluggedEventListener(String str) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "unregisterHeadphonePluggedEventListener called");
        }
        if (this.f3048a == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                String str3 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        L4 l6 = this.d;
        if (l6 != null) {
            String str4 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((M4) l6).a(str4, "Unregister headphone plugged event listener ...");
        }
        try {
            M6 mediaProcessor = this.f3048a.getMediaProcessor();
            if (mediaProcessor != null) {
                C3638y6 c3638y6 = mediaProcessor.f;
                if (c3638y6 != null) {
                    c3638y6.a();
                }
                mediaProcessor.f = null;
            }
        } catch (Exception e) {
            this.f3048a.a(str, "Unexpected error", "unregisterHeadphonePluggedEventListener");
            L4 l7 = this.d;
            if (l7 != null) {
                String str5 = E5.f3056a;
                ((M4) l7).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterHeadphonePluggedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void useCustomClose(final String str, final boolean z) {
        L4 l4 = this.d;
        if (l4 != null) {
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "useCustomClose called:" + z);
        }
        new Handler(this.f3048a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                D5.b(this.f$0, z, str);
            }
        });
    }

    @JavascriptInterface
    public final void zoom(String jsCallbackNamespace, final int i) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        L4 l4 = this.d;
        if (l4 != null) {
            String str = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "zoom is called " + jsCallbackNamespace + ' ' + i);
        }
        Lb.a(new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                D5.a(this.f$0, i);
            }
        });
    }

    public static final void b(D5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.o();
        } catch (Exception e) {
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str = E5.f3056a;
                ((M4) l4).b(str, ld.a(e, O5.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in getting/setting current position; ")));
            }
        }
    }

    public static final void c(D5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.p();
        } catch (Exception e) {
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str = E5.f3056a;
                ((M4) l4).b(str, ld.a(e, O5.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in getting/setting default position; ")));
            }
        }
    }

    public static final void b(D5 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.n();
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", "resize");
            String str2 = E5.f3056a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            AbstractC3498o6.a((byte) 1, str2, "Could not resize ad; SDK encountered an unexpected error");
            L4 l4 = this$0.d;
            if (l4 != null) {
                ((M4) l4).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "SDK encountered an unexpected error in handling resize() request; ")));
            }
        }
    }

    public static final void a(D5 this$0, Z5 z5, String str, int i, String str2, float f, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.f3048a.getEmbeddedBrowserJSCallbacks() == null) {
                L4 l4 = this$0.d;
                if (l4 != null) {
                    String str3 = E5.f3056a;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                    ((M4) l4).b(str3, "Found a null instance of EmbeddedBrowserJSCallback instance to customExpand");
                }
                U5 landingPageHandler = this$0.f3048a.getLandingPageHandler();
                N5 funnelState = N5.LPStartFailed;
                landingPageHandler.getClass();
                Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                R5.a(funnelState, z5, (Integer) 8002, (Function2) new T5(landingPageHandler));
                return;
            }
            L4 l5 = this$0.d;
            if (l5 != null) {
                String str4 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l5).a(str4, "Custom expand called. Url: " + str);
            }
            EnumC3621x3 enumC3621x3 = EnumC3621x3.values()[i];
            if (enumC3621x3 == EnumC3621x3.URL) {
                if (this$0.f3048a.getLandingPageHandler().a(str2, str, z5) == 3) {
                    InterfaceC3635y3 embeddedBrowserJSCallbacks = this$0.f3048a.getEmbeddedBrowserJSCallbacks();
                    if (embeddedBrowserJSCallbacks != null) {
                        ((C3566t4) embeddedBrowserJSCallbacks).a(str, enumC3621x3, f, z, this$0.f3048a.getViewTouchTimestamp(), z5);
                    }
                    U5 landingPageHandler2 = this$0.f3048a.getLandingPageHandler();
                    N5 funnelState2 = N5.LPStartSuccess;
                    landingPageHandler2.getClass();
                    Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
                    R5.a(funnelState2, z5, (Integer) null, new T5(landingPageHandler2));
                    C3614wa c3614wa = this$0.f3048a.getLandingPageHandler().d;
                    if (c3614wa != null) {
                        Ba.a(c3614wa.f3467a, "customExpand", str2, str);
                        return;
                    }
                    return;
                }
                InterfaceC3635y3 embeddedBrowserJSCallbacks2 = this$0.f3048a.getEmbeddedBrowserJSCallbacks();
                if (embeddedBrowserJSCallbacks2 != null) {
                    C3594v4.a(((C3566t4) embeddedBrowserJSCallbacks2).f3432a);
                    return;
                }
                return;
            }
            InterfaceC3635y3 embeddedBrowserJSCallbacks3 = this$0.f3048a.getEmbeddedBrowserJSCallbacks();
            if (embeddedBrowserJSCallbacks3 != null) {
                ((C3566t4) embeddedBrowserJSCallbacks3).a(str, enumC3621x3, f, z, this$0.f3048a.getViewTouchTimestamp(), z5);
            }
            U5 landingPageHandler3 = this$0.f3048a.getLandingPageHandler();
            N5 funnelState3 = N5.LPStartSuccess;
            landingPageHandler3.getClass();
            Intrinsics.checkNotNullParameter(funnelState3, "funnelState");
            R5.a(funnelState3, z5, (Integer) null, new T5(landingPageHandler3));
            C3614wa c3614wa2 = this$0.f3048a.getLandingPageHandler().d;
            if (c3614wa2 != null) {
                Ba.a(c3614wa2.f3467a, "customExpand", str2, str);
            }
        } catch (Exception e) {
            this$0.f3048a.a(str2, "Unexpected error", "customExpand");
            U5 landingPageHandler4 = this$0.f3048a.getLandingPageHandler();
            N5 funnelState4 = N5.LPStartFailed;
            landingPageHandler4.getClass();
            Intrinsics.checkNotNullParameter(funnelState4, "funnelState");
            R5.a(funnelState4, z5, (Integer) 9, (Function2) new T5(landingPageHandler4));
            AbstractC3498o6.a((byte) 1, "InMobi", "Failed to custom expand ad; SDK encountered an unexpected error");
            L4 l6 = this$0.d;
            if (l6 != null) {
                String str5 = E5.f3056a;
                ((M4) l6).b(str5, ld.a(e, O5.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling customExpand() request; ")));
            }
        }
    }

    public static final void c(D5 this$0, String json) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$orientationPropertiesString");
        C3529q9 op = this$0.f3048a.getOrientationProperties();
        if (op != null) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(op, "op");
            C3529q9 c3529q9 = new C3529q9();
            c3529q9.d = json;
            try {
                JSONObject jSONObject = new JSONObject(json);
                String strOptString = jSONObject.optString("forceOrientation", op.b);
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                Intrinsics.checkNotNullParameter(strOptString, "<set-?>");
                c3529q9.b = strOptString;
                c3529q9.f3409a = jSONObject.optBoolean("allowOrientationChange", op.f3409a);
                String strOptString2 = jSONObject.optString("direction", op.c);
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                Intrinsics.checkNotNullParameter(strOptString2, "<set-?>");
                c3529q9.c = strOptString2;
                if (!Intrinsics.areEqual(c3529q9.b, "portrait") && !Intrinsics.areEqual(c3529q9.b, "landscape")) {
                    Intrinsics.checkNotNullParameter("none", "<set-?>");
                    c3529q9.b = "none";
                }
                if (!Intrinsics.areEqual(c3529q9.c, "left") && !Intrinsics.areEqual(c3529q9.c, "right")) {
                    Intrinsics.checkNotNullParameter("right", "<set-?>");
                    c3529q9.c = "right";
                }
            } catch (JSONException unused) {
                c3529q9 = null;
            }
            this$0.c = c3529q9;
        }
        C3529q9 c3529q10 = this$0.c;
        if (c3529q10 != null) {
            Ba ba = this$0.f3048a;
            Intrinsics.checkNotNull(c3529q10);
            ba.setOrientationProperties(c3529q10);
        }
    }

    public static final void b(D5 this$0, boolean z, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.e(z);
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", MraidJsMethods.USE_CUSTOM_CLOSE);
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                ((M4) l4).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "SDK encountered internal error in handling useCustomClose() request from creative; ")));
            }
        }
    }

    public static final void a(D5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f3048a.getEmbeddedBrowserJSCallbacks() == null) {
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4).b(str, "Found a null instance of EmbeddedBrowserJSCallback instance to closeCustomExpand");
                return;
            }
            return;
        }
        InterfaceC3635y3 embeddedBrowserJSCallbacks = this$0.f3048a.getEmbeddedBrowserJSCallbacks();
        if (embeddedBrowserJSCallbacks != null) {
            C3594v4.a(((C3566t4) embeddedBrowserJSCallbacks).f3432a);
        }
    }

    public static final void a(D5 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            r referenceContainer = this$0.f3048a.getReferenceContainer();
            if (referenceContainer != null) {
                referenceContainer.a();
            }
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", "close");
            AbstractC3498o6.a((byte) 1, "InMobi", "Failed to close ad; SDK encountered an unexpected error");
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                ((M4) l4).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "SDK encountered an expected error in handling the close() request from creative; ")));
            }
        }
    }

    public static final void a(D5 this$0, boolean z, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3048a.d(z);
        } catch (Exception e) {
            this$0.f3048a.a(str, "Unexpected error", "disableCloseRegion");
            L4 l4 = this$0.d;
            if (l4 != null) {
                String str2 = E5.f3056a;
                ((M4) l4).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in handling disableCloseRegion() request from creative; ")));
            }
        }
    }

    public static final void a(D5 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f3048a.setInitialScale(i);
    }
}
