package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.tc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3574tc extends AbstractC3520q0 {
    public static final C3560sc h = new C3560sc();
    private static final String i = "tc";
    public static final String j = "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ";
    public static final String k = "Ad show is already called. Please wait for the the ad to be shown.";
    public static final String l = "preload() and load() cannot be called on the same instance, please use a different instance.";
    public static final String m = "Please make an ad request first in order to start loading the ad.";
    public static final String n = "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f3437a;
    private Boolean b;
    private PublisherCallbacks c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private AdMetaInfo e;
    private L4 f;
    private WatermarkData g;

    public static /* synthetic */ void r() {
    }

    public final void a(byte b) {
        this.f3437a = b;
    }

    public final void b(PublisherCallbacks publisherCallbacks) {
        this.c = publisherCallbacks;
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void c(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdLoadSucceeded " + this);
        }
        this.e = info;
        C0 c0J = j();
        if (c0J != null) {
            c0J.b((byte) 1);
        }
    }

    public final void d(AdMetaInfo adMetaInfo) {
        this.e = adMetaInfo;
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void e() {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdWillShow " + this);
        }
        byte b = this.f3437a;
        if (b == 4 || b == 5) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.b(this.f$0);
            }
        });
        L4 l5 = this.f;
        if (l5 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).d(TAG2, "AdManager state - WILL_DISPLAY");
        }
        this.f3437a = (byte) 4;
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void h() {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onUserLeftApplication " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.c(this.f$0);
            }
        });
    }

    public abstract C0 j();

    public final JSONObject k() {
        JSONObject bidInfo;
        AdMetaInfo adMetaInfo = this.e;
        return (adMetaInfo == null || (bidInfo = adMetaInfo.getBidInfo()) == null) ? new JSONObject() : bidInfo;
    }

    public final PublisherCallbacks l() {
        return this.c;
    }

    public final String m() {
        String creativeID;
        AdMetaInfo adMetaInfo = this.e;
        return (adMetaInfo == null || (creativeID = adMetaInfo.getCreativeID()) == null) ? "" : creativeID;
    }

    public final AdMetaInfo n() {
        return this.e;
    }

    public final byte o() {
        return v() ? (byte) 2 : (byte) 1;
    }

    public final L4 p() {
        return this.f;
    }

    public final byte q() {
        return this.f3437a;
    }

    public final Handler s() {
        return this.d;
    }

    public final WatermarkData t() {
        return this.g;
    }

    public final Boolean u() {
        return this.b;
    }

    public final boolean v() {
        PublisherCallbacks publisherCallbacks = this.c;
        return publisherCallbacks != null && publisherCallbacks.getType() == 1;
    }

    public void w() {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "submitAdLoadCalled " + this);
        }
        C0 c0J = j();
        if (c0J != null) {
            c0J.t0();
        }
    }

    public final void a(Boolean bool) {
        this.b = bool;
    }

    public final void b(WatermarkData watermarkData) {
        this.g = watermarkData;
    }

    public final void a(L4 l4) {
        this.f = l4;
    }

    public final void b(final C0 c0, final InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onLoadFailure " + this);
        }
        L4 l5 = this.f;
        if (l5 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).d(TAG2, "AdManager state - LOAD_FAILED");
        }
        this.f3437a = (byte) 3;
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(c0, this, status);
            }
        });
    }

    public static final void a(C0 c0, AbstractC3574tc this$0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        if (c0 != null) {
            c0.b((byte) 1);
        }
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdLoadFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdLoadFailed(status);
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            ((M4) l5).a();
        }
    }

    public static final void c(AbstractC3574tc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onUserLeftApplication");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onUserLeftApplication();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void b(AdMetaInfo info) {
        C0 c0J;
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdFetchSuccess " + this);
        }
        L4 l5 = this.f;
        if (l5 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).d(TAG2, "AdManager state - FETCHED");
        }
        this.f3437a = (byte) 7;
        if (!v() || (c0J = j()) == null) {
            return;
        }
        c0J.b((byte) 2);
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdFetchFailed " + this);
        }
        this.f3437a = (byte) 3;
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, status);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdFetchFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdFetchFailed(status);
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            ((M4) l5).a();
        }
    }

    public static final void b(AbstractC3574tc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdWillShow");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdWillDisplay();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdDisplayed " + this);
        }
        if (this.f3437a != 5) {
            this.e = info;
            this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC3574tc.a(this.f$0, info);
                }
            });
            L4 l5 = this.f;
            if (l5 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).d(TAG2, "AdManager state - DISPLAYED");
            }
            this.f3437a = (byte) 5;
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void b(final Map<Object, ? extends Object> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdRewardActionCompleted " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.b(this.f$0, rewards);
            }
        });
    }

    public static final void b(AbstractC3574tc this$0, Map rewards) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rewards, "$rewards");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onRewardsUnlocked");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRewardsUnlocked(rewards);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void b(final InMobiAdRequestStatus reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onRequestCreationFailed " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.b(this.f$0, reason);
            }
        });
    }

    public static final void b(AbstractC3574tc this$0, InMobiAdRequestStatus reason) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onRequestPayloadCreationFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRequestPayloadCreationFailed(reason);
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            ((M4) l5).a();
        }
    }

    public static final void a(AbstractC3574tc this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdDisplayed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdDisplayed(info);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void b() {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdDismissed " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0);
            }
        });
        L4 l5 = this.f;
        if (l5 != null) {
            ((M4) l5).a();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(C0 c0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdLoadFailed " + this);
        }
        b(c0, status);
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdInteraction " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, params);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, Map params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdClicked");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdClicked(params);
        }
    }

    public final void a(PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "getSignals " + this);
        }
        if (j() != null) {
            C0 c0J = j();
            if (c0J != null) {
                c0J.y0();
            }
            this.c = callbacks;
            C0 c0J2 = j();
            if (c0J2 != null) {
                c0J2.P();
            }
        }
    }

    public void a(byte[] bArr, PublisherCallbacks callbacks) {
        C0 c0J;
        C0 c0J2;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "load " + this);
        }
        if (Intrinsics.areEqual(this.b, Boolean.TRUE)) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            L4 l5 = this.f;
            if (l5 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "Cannot call load(byte[]) API after load() API is called");
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            C0 c0J3 = j();
            if (c0J3 != null) {
                c0J3.a((short) 2140);
                return;
            }
            return;
        }
        this.b = Boolean.FALSE;
        this.f3437a = (byte) 1;
        L4 l6 = this.f;
        if (l6 != null && (c0J2 = j()) != null) {
            c0J2.a(l6);
        }
        if (j() == null || (c0J = j()) == null || !c0J.e((byte) 1)) {
            return;
        }
        L4 l7 = this.f;
        if (l7 != null) {
            String TAG3 = i;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((M4) l7).a(TAG3, "load starting. Started INTERNAL_LOAD_TIMER");
        }
        this.c = callbacks;
        C0 c0J4 = j();
        if (c0J4 != null) {
            c0J4.a(bArr);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final byte[] request) {
        Intrinsics.checkNotNullParameter(request, "request");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onRequestCreated " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, request);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, byte[] request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onRequestPayloadCreated");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRequestPayloadCreated(request);
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            ((M4) l5).a();
        }
    }

    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        L4 l4 = this.f;
        if (l4 != null) {
            String str = i;
            ((M4) l4).c(str, O5.a(str, "TAG", "setWatermark - ").append(watermarkData.getWatermarkBase64EncodedString()).toString());
        }
        this.g = watermarkData;
    }

    public final boolean a(String tag, String placementString, PublisherCallbacks publisherCallbacks) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(placementString, "placementString");
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c(tag, "canProceedToLoad " + this);
        }
        PublisherCallbacks publisherCallbacks2 = this.c;
        if (publisherCallbacks2 != null && publisherCallbacks != null && publisherCallbacks2.getType() != publisherCallbacks.getType()) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, l);
            L4 l5 = this.f;
            if (l5 != null) {
                ((M4) l5).b(tag, l);
            }
            C0 c0J = j();
            if (c0J != null) {
                c0J.a((short) 2005);
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            return false;
        }
        byte b = this.f3437a;
        if (b == 8) {
            AbstractC3498o6.a((byte) 1, tag, n + placementString);
            L4 l6 = this.f;
            if (l6 != null) {
                ((M4) l6).b(tag, S.a(n, placementString));
            }
            C0 c0J2 = j();
            if (c0J2 == null) {
                return false;
            }
            c0J2.a((short) 2002);
            return false;
        }
        if (b == 1) {
            AbstractC3498o6.a((byte) 1, tag, n + placementString);
            L4 l7 = this.f;
            if (l7 != null) {
                ((M4) l7).b(tag, S.a(n, placementString));
            }
            C0 c0J3 = j();
            if (c0J3 == null) {
                return false;
            }
            c0J3.a((short) 2001);
            return false;
        }
        if (b != 5) {
            return true;
        }
        AbstractC3498o6.a((byte) 1, tag, j + placementString);
        L4 l8 = this.f;
        if (l8 != null) {
            ((M4) l8).b(tag, S.a(j, placementString));
        }
        b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
        C0 c0J4 = j();
        if (c0J4 == null) {
            return false;
        }
        c0J4.b((short) 2003);
        return false;
    }

    public final boolean a(String tag, String placementString) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(placementString, "placementString");
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "canRender " + this);
        }
        byte b = this.f3437a;
        if (b == 1) {
            AbstractC3498o6.a((byte) 1, tag, n + placementString);
            L4 l5 = this.f;
            if (l5 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).b(TAG2, "adload in progress");
            }
            C0 c0J = j();
            if (c0J == null) {
                return false;
            }
            c0J.b((short) 2129);
            return false;
        }
        if (b == 8) {
            AbstractC3498o6.a((byte) 1, tag, n + placementString);
            L4 l6 = this.f;
            if (l6 != null) {
                String TAG3 = i;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l6).b(TAG3, "ad loading into view is in progress");
            }
            C0 c0J2 = j();
            if (c0J2 == null) {
                return false;
            }
            c0J2.b((short) 2164);
            return false;
        }
        if (b == 5) {
            AbstractC3498o6.a((byte) 1, tag, j + placementString);
            L4 l7 = this.f;
            if (l7 != null) {
                String TAG4 = i;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                ((M4) l7).b(TAG4, "ad active before renderAd");
            }
            C0 c0J3 = j();
            if (c0J3 != null) {
                c0J3.b((short) 2130);
            }
            C0 c0J4 = j();
            if (c0J4 != null) {
                c0J4.m0();
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
            return false;
        }
        if (b == 7) {
            return true;
        }
        L4 l8 = this.f;
        if (l8 != null) {
            String TAG5 = i;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            ((M4) l8).b(TAG5, "ad in illegal state");
        }
        C0 c0J5 = j();
        if (c0J5 != null) {
            c0J5.b((short) 2165);
        }
        C0 c0J6 = j();
        if (c0J6 != null) {
            c0J6.m0();
        }
        b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        throw new IllegalStateException(m);
    }

    public static final void a(AbstractC3574tc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onAdDismissed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdDismissed();
            return;
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).b(TAG2, "callback is null");
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final Yb yb) {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onAdImpression " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, yb);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, Yb yb) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.c == null) {
            L4 l4 = this$0.f;
            if (l4 != null) {
                String TAG = i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).b(TAG, "callback is null");
            }
            if (yb != null) {
                yb.c();
                return;
            }
            return;
        }
        L4 l5 = this$0.f;
        if (l5 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "callback - onAdImpression");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdImpression(yb);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final EnumC3479n1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, audioStatusInternal);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, EnumC3479n1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audioStatusInternal, "$audioStatusInternal");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String str = i;
            ((M4) l4).a(str, O5.a(str, "TAG", "callback - onAudioStatusChanged - ").append(audioStatusInternal.f3378a).toString());
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAudioStatusChanged(audioStatusInternal);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        this.d.post(new Runnable() { // from class: com.inmobi.media.tc$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3574tc.a(this.f$0, log);
            }
        });
    }

    public static final void a(AbstractC3574tc this$0, String log) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(log, "$log");
        L4 l4 = this$0.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "callback - onImraidLog");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onImraidLog(log);
        }
    }

    public void a(short s) {
        L4 l4 = this.f;
        if (l4 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "submitAdLoadDroppedAtSDK " + this);
        }
        C0 c0J = j();
        if (c0J != null) {
            c0J.a(s);
        }
    }
}
