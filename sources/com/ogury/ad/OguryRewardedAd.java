package com.ogury.ad;

import android.content.Context;
import com.json.m5;
import com.ogury.ad.common.OguryMediation;
import com.ogury.ad.internal.d;
import com.ogury.ad.internal.g8;
import com.ogury.ad.internal.o;
import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.w2;
import com.ogury.ad.internal.x;
import com.ogury.ad.internal.y;
import com.ogury.ad.internal.z5;
import com.ogury.ad.interstitial.ui.b;
import com.ogury.core.internal.IntegrationLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\rJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/ogury/ad/OguryRewardedAd;", "Lcom/ogury/ad/internal/t5;", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/ogury/ad/common/OguryMediation;", "oguryMediation", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/ogury/ad/common/OguryMediation;)V", "campaignId", "", "setCampaignId", "(Ljava/lang/String;)V", "creativeId", "setCreativeId", "dspCreativeId", "setDspCreativeId", "dspAwsRegion", "setDspAwsRegion", "", "isLoaded", "()Z", "Lcom/ogury/ad/OguryRewardedAdListener;", "rewardedAdListener", "setListener", "(Lcom/ogury/ad/OguryRewardedAdListener;)V", "adMarkup", "load", m5.v, "()V", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class OguryRewardedAd implements t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2 f7252a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OguryRewardedAd(Context context, String adUnitId) {
        this(context, adUnitId, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    public static final Unit a(OguryRewardedAdListener oguryRewardedAdListener, OguryRewardedAd oguryRewardedAd, g8 rewardItem) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        if (oguryRewardedAdListener != null) {
            oguryRewardedAdListener.onAdRewarded(oguryRewardedAd, new OguryReward(rewardItem.f7308a, rewardItem.b));
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void load$default(OguryRewardedAd oguryRewardedAd, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        oguryRewardedAd.load(str);
    }

    private final void setCampaignId(String campaignId) {
        w2 w2Var = this.f7252a;
        w2Var.getClass();
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        w2Var.f7428a.b = campaignId;
    }

    private final void setCreativeId(String creativeId) {
        w2 w2Var = this.f7252a;
        w2Var.getClass();
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        w2Var.f7428a.c = creativeId;
    }

    private final void setDspAwsRegion(String dspAwsRegion) {
        w2 w2Var = this.f7252a;
        w2Var.getClass();
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        w2Var.f7428a.e = dspAwsRegion;
    }

    private final void setDspCreativeId(String dspCreativeId) {
        w2 w2Var = this.f7252a;
        w2Var.getClass();
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        w2Var.f7428a.d = dspCreativeId;
    }

    public final boolean isLoaded() {
        x xVar = this.f7252a.e;
        return xVar != null && xVar.o;
    }

    public final void load() {
        load$default(this, null, 1, null);
    }

    public final void setListener(final OguryRewardedAdListener rewardedAdListener) {
        IntegrationLogger.d("[Ads] Rewarded Ad - setListener() called");
        w2 w2Var = this.f7252a;
        Intrinsics.checkNotNullParameter(this, "ad");
        w2Var.a(rewardedAdListener != null ? new z5(this, rewardedAdListener) : null);
        this.f7252a.g = new Function1() { // from class: com.ogury.ad.OguryRewardedAd$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OguryRewardedAd.a(rewardedAdListener, this, (g8) obj);
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002a  */
    public final void show() {
        boolean z;
        IntegrationLogger.d("[Ads] Rewarded Ad - show() called");
        w2 w2Var = this.f7252a;
        b bVar = b.f7479a;
        w2Var.getClass();
        b showAction = b.f7479a;
        Intrinsics.checkNotNullParameter(showAction, "showAction");
        x xVar = w2Var.e;
        if (xVar != null && xVar.o) {
            xVar.a(showAction);
            return;
        }
        y yVar = w2Var.c;
        if (xVar != null) {
            z = xVar.o;
        }
        OguryMediation oguryMediation = w2Var.d;
        Context context = yVar.f7444a;
        yVar.d.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        x xVar2 = new x(context, string, oguryMediation, yVar.b, yVar.c, z);
        xVar2.t = w2Var.f;
        xVar2.v = w2Var.g;
        xVar2.a(showAction);
    }

    public /* synthetic */ OguryRewardedAd(Context context, String str, OguryMediation oguryMediation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : oguryMediation);
    }

    public final void load(String adMarkup) {
        IntegrationLogger.d("[Ads] Rewarded Ad - load() called");
        this.f7252a.a(adMarkup);
    }

    public OguryRewardedAd(Context context, String adUnitId, OguryMediation oguryMediation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f7252a = new w2(context, new d(adUnitId), o.REWARDED, oguryMediation);
    }
}
