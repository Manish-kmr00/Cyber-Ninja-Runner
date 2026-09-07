package com.ogury.ad;

import android.content.Context;
import android.util.Base64;
import com.ogury.ad.internal.d9;
import com.ogury.ad.internal.u3;
import com.ogury.ad.internal.u7;
import com.ogury.ad.internal.v8;
import com.ogury.ad.internal.w0;
import com.ogury.ad.internal.z7;
import com.ogury.core.OguryError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJS\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/ogury/ad/OguryBidTokenProvider;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/ogury/ad/OguryBidTokenListener;", "oguryBidTokenListener", "", "getBidToken", "(Landroid/content/Context;Lcom/ogury/ad/OguryBidTokenListener;)V", "", "campaignId", "creativeId", "dspCreativeId", "dspAwsRegion", "Lcom/ogury/ad/internal/u7;", "profigHandler", "Lcom/ogury/ad/internal/w0;", "bidderTokenBodyBuilder", "getBidderTokenInternal$sdk_ads_prodRelease", "(Landroid/content/Context;Lcom/ogury/ad/OguryBidTokenListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ogury/ad/internal/u7;Lcom/ogury/ad/internal/w0;)V", "getBidderTokenInternal", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class OguryBidTokenProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OguryBidTokenProvider f7249a = new OguryBidTokenProvider();

    private OguryBidTokenProvider() {
    }

    public static final z7 a(u7 u7Var) {
        f7249a.getClass();
        z7 z7VarB = u7Var.b();
        if (z7VarB.f7463a && !u7Var.a()) {
            return z7VarB;
        }
        u3.f7411a.getClass();
        return u7Var.a(true);
    }

    @JvmStatic
    public static final void getBidToken(Context context, OguryBidTokenListener oguryBidTokenListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oguryBidTokenListener, "oguryBidTokenListener");
        getBidderTokenInternal$sdk_ads_prodRelease$default(f7249a, context, oguryBidTokenListener, "", "", "", "", null, null, 192, null);
    }

    public static /* synthetic */ void getBidderTokenInternal$sdk_ads_prodRelease$default(OguryBidTokenProvider oguryBidTokenProvider, Context context, OguryBidTokenListener oguryBidTokenListener, String str, String str2, String str3, String str4, u7 u7Var, w0 w0Var, int i, Object obj) {
        oguryBidTokenProvider.getBidderTokenInternal$sdk_ads_prodRelease(context, oguryBidTokenListener, str, str2, str3, str4, (i & 64) != 0 ? u7.i.a(context) : u7Var, (i & 128) != 0 ? new w0(context) : w0Var);
    }

    public final void getBidderTokenInternal$sdk_ads_prodRelease(Context context, final OguryBidTokenListener oguryBidTokenListener, final String campaignId, final String creativeId, final String dspCreativeId, final String dspAwsRegion, final u7 profigHandler, final w0 bidderTokenBodyBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oguryBidTokenListener, "oguryBidTokenListener");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        Intrinsics.checkNotNullParameter(profigHandler, "profigHandler");
        Intrinsics.checkNotNullParameter(bidderTokenBodyBuilder, "bidderTokenBodyBuilder");
        Function0 callable = new Function0() { // from class: com.ogury.ad.OguryBidTokenProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OguryBidTokenProvider.a(profigHandler);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        v8 v8VarA = new v8(callable, 0).a(new Function1() { // from class: com.ogury.ad.OguryBidTokenProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OguryBidTokenProvider.a(oguryBidTokenListener, bidderTokenBodyBuilder, campaignId, creativeId, dspCreativeId, dspAwsRegion, (z7) obj);
            }
        });
        Function1<? super d9, Unit> consumer = new Function1() { // from class: com.ogury.ad.OguryBidTokenProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OguryBidTokenProvider.a(oguryBidTokenListener, (d9) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        v8VarA.c = consumer;
        v8VarA.b(new Function1() { // from class: com.ogury.ad.OguryBidTokenProvider$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OguryBidTokenProvider.a(oguryBidTokenListener, (String) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    public static final String a(OguryBidTokenListener oguryBidTokenListener, w0 w0Var, String str, String str2, String str3, String str4, z7 profigResponse) {
        OguryError oguryError;
        Intrinsics.checkNotNullParameter(profigResponse, "profigResponse");
        if (!profigResponse.a().b()) {
            String strA = profigResponse.a().a();
            int iHashCode = strA.hashCode();
            if (iHashCode != -1984720000) {
                if (iHashCode != -1879742975) {
                    if (iHashCode == 659206911 && strA.equals("COUNTRY_NOT_OPEN")) {
                        oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_COUNTRY_NOT_OPENED, "The bid token could not be generated because ads are disabled; the user’s country is not yet available for advertising.");
                    } else {
                        oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The bid token could not be generated because ads are disabled for an unspecified reason.");
                    }
                } else if (strA.equals("CONSENT_MISSING")) {
                    oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_CONSENT_MISSING, "The bid token could not be generated because ads are disabled; user consent is missing or has not been provided.");
                } else {
                    oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The bid token could not be generated because ads are disabled for an unspecified reason.");
                }
            } else if (!strA.equals("CONSENT_DENIED")) {
                oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The bid token could not be generated because ads are disabled for an unspecified reason.");
            } else {
                oguryError = new OguryError(OguryBidTokenErrorCode.AD_DISABLED_CONSENT_DENIED, "The bid token could not be generated because ads are disabled; the user has denied consent for advertising");
            }
            oguryBidTokenListener.onBidTokenGenerationFailed(oguryError);
            return null;
        }
        String string = w0Var.a(str, str2, str3, str4).a().toString();
        String str5 = "Bidder token generated: " + string;
        u3.f7411a.getClass();
        return string;
    }

    public static final Unit a(OguryBidTokenListener oguryBidTokenListener, d9 e) {
        Intrinsics.checkNotNullParameter(e, "e");
        u3 u3Var = u3.f7411a;
        e.getMessage();
        u3Var.getClass();
        oguryBidTokenListener.onBidTokenGenerationFailed(new OguryError(4100, "The bid token could not be generated because the SDK configuration is invalid."));
        return Unit.INSTANCE;
    }

    public static final Unit a(OguryBidTokenListener oguryBidTokenListener, String str) {
        if (str != null) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNull(strEncodeToString);
            oguryBidTokenListener.onBidTokenGenerated(strEncodeToString);
        }
        return Unit.INSTANCE;
    }
}
