package com.ogury.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ogury.ad.common.OguryMediation;
import com.ogury.ad.internal.d;
import com.ogury.ad.internal.d5;
import com.ogury.ad.internal.g0;
import com.ogury.ad.internal.j0;
import com.ogury.ad.internal.j4;
import com.ogury.ad.internal.j7;
import com.ogury.ad.internal.l0;
import com.ogury.ad.internal.n0;
import com.ogury.ad.internal.o;
import com.ogury.ad.internal.p0;
import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.u0;
import com.ogury.ad.internal.w8;
import com.ogury.ad.internal.x;
import com.ogury.ad.internal.z5;
import com.ogury.core.internal.IntegrationLogger;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u001eJ\u0017\u0010'\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b*\u0010\u001eJ\r\u0010+\u001a\u00020\u0019¢\u0006\u0004\b+\u0010\u001bJ\r\u0010,\u001a\u00020\u0013¢\u0006\u0004\b,\u0010-J+\u00103\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/ogury/ad/OguryBannerAdView;", "Landroid/widget/FrameLayout;", "Lcom/ogury/ad/internal/u0;", "Lcom/ogury/ad/internal/t5;", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/ogury/ad/OguryBannerAdSize;", ContentDisposition.Parameters.Size, "Lcom/ogury/ad/common/OguryMediation;", "oguryMediation", "Landroid/util/AttributeSet;", "attributes", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/ogury/ad/OguryBannerAdSize;Lcom/ogury/ad/common/OguryMediation;Landroid/util/AttributeSet;I)V", "adSize", "", "setAdSize", "(Lcom/ogury/ad/OguryBannerAdSize;)V", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "", "isLoaded", "()Z", "campaignId", "setCampaignId", "(Ljava/lang/String;)V", "creativeId", "setCreativeId", "dspCreativeId", "setDspCreativeId", "dspAwsRegion", "setDspAwsRegion", "Lcom/ogury/ad/OguryBannerAdViewListener;", "bannerAdListener", "setListener", "(Lcom/ogury/ad/OguryBannerAdViewListener;)V", "adMarkup", "load", "isBannerExpanded", "destroy", "()V", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class OguryBannerAdView extends FrameLayout implements u0, t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f7248a;
    public OguryBannerAdSize b;
    public final d c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OguryBannerAdView(Context context, String adUnitId, OguryBannerAdSize size) {
        this(context, adUnitId, size, null, null, 0, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(size, "size");
    }

    private final ViewGroup getContainer() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static /* synthetic */ void load$default(OguryBannerAdView oguryBannerAdView, String str, int i, Object obj) throws JSONException {
        if ((i & 1) != 0) {
            str = null;
        }
        oguryBannerAdView.load(str);
    }

    private final void setAdSize(OguryBannerAdSize adSize) {
        IntegrationLogger.d("[Ads] Banner Ad View - setAdSize() called with adSize: " + adSize.name());
        this.b = adSize;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        this.f7248a.a();
    }

    public final void destroy() {
        ViewGroup container = getContainer();
        if (container != null) {
            container.removeView(this);
        }
        removeAllViews();
        n0 n0Var = this.f7248a;
        g0 g0Var = n0Var.g;
        if (g0Var != null) {
            g0Var.b();
        }
        x xVar = n0Var.h;
        if (xVar != null) {
            xVar.b();
        }
        n0Var.g = null;
        n0Var.h = null;
        p0 p0Var = n0Var.e;
        p0Var.b = null;
        p0Var.f7380a = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.presage", this, me);
        return super.dispatchTouchEvent(me);
    }

    public final boolean isBannerExpanded() {
        j4 j4Var;
        d5 d5Var;
        g0 g0Var = this.f7248a.g;
        return (g0Var == null || (j4Var = g0Var.f) == null || (d5Var = j4Var.q) == null || !d5Var.l) ? false : true;
    }

    public final boolean isLoaded() {
        x xVar = this.f7248a.h;
        return xVar != null && xVar.o;
    }

    public final void load() throws JSONException {
        load$default(this, null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7248a.a();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getChildCount() > 0) {
            this.f7248a.a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setCampaignId(String campaignId) {
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        this.c.b = campaignId;
    }

    public final void setCreativeId(String creativeId) {
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.c.c = creativeId;
    }

    public final void setDspAwsRegion(String dspAwsRegion) {
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        this.c.e = dspAwsRegion;
    }

    public final void setDspCreativeId(String dspCreativeId) {
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        this.c.d = dspCreativeId;
    }

    public final void setListener(OguryBannerAdViewListener bannerAdListener) {
        IntegrationLogger.d("[Ads] Banner Ad View - setListener() called");
        n0 n0Var = this.f7248a;
        Intrinsics.checkNotNullParameter(this, "ad");
        z5 z5Var = bannerAdListener != null ? new z5(this, bannerAdListener) : null;
        n0Var.getClass();
        IntegrationLogger.d("[Ads][Banner View] Registering to ad listener");
        if (z5Var == null) {
            IntegrationLogger.d("[Ads][Banner View] Ad listener is null");
        }
        p0 p0Var = n0Var.e;
        p0Var.f7380a = z5Var;
        p0Var.b = new l0(n0Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OguryBannerAdView(Context context, String adUnitId, OguryBannerAdSize size, OguryMediation oguryMediation) {
        this(context, adUnitId, size, oguryMediation, null, 0, 48, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(size, "size");
    }

    public final void load(String adMarkup) throws JSONException {
        o oVar;
        IntegrationLogger.d("[Ads] Banner Ad View - load() called");
        OguryBannerAdSize oguryBannerAdSize = this.b;
        if (oguryBannerAdSize == null) {
            oVar = null;
        } else {
            int i = j0.f7325a[oguryBannerAdSize.ordinal()];
            if (i == 1) {
                oVar = o.MEDIUM_RECTANGLE;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                oVar = o.SMALL_BANNER;
            }
        }
        OguryBannerAdSize oguryBannerAdSize2 = this.b;
        this.f7248a.a(this.c, oVar, oguryBannerAdSize2 == null ? new w8(0, 0) : new w8(j7.a(oguryBannerAdSize2.getWidth()), j7.a(oguryBannerAdSize2.getHeight())), adMarkup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OguryBannerAdView(Context context, String adUnitId, OguryBannerAdSize size, OguryMediation oguryMediation, AttributeSet attributeSet) {
        this(context, adUnitId, size, oguryMediation, attributeSet, 0, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(size, "size");
    }

    public /* synthetic */ OguryBannerAdView(Context context, String str, OguryBannerAdSize oguryBannerAdSize, OguryMediation oguryMediation, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, oguryBannerAdSize, (i2 & 8) != 0 ? null : oguryMediation, (i2 & 16) != 0 ? null : attributeSet, (i2 & 32) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OguryBannerAdView(Context context, String adUnitId, OguryBannerAdSize size, OguryMediation oguryMediation, AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(size, "size");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f7248a = new n0(applicationContext, this, oguryMediation);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.BannerLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.BannerLayout_adUnit);
        this.c = new d(string != null ? string : adUnitId);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.BannerLayout_bannerAdSize, -1);
        OguryBannerAdSize oguryBannerAdSize = OguryBannerAdSize.SMALL_BANNER_320x50;
        if (i2 == oguryBannerAdSize.getHeight()) {
            setAdSize(oguryBannerAdSize);
        } else {
            OguryBannerAdSize oguryBannerAdSize2 = OguryBannerAdSize.MREC_300x250;
            if (i2 == oguryBannerAdSize2.getHeight()) {
                setAdSize(oguryBannerAdSize2);
            } else {
                setAdSize(size);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
