package com.ogury.ad;

import com.ogury.ad.internal.e2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ogury/ad/OguryAdRequests;", "", "<init>", "()V", "AD_CONTENT_THRESHOLD_MA", "", "AD_CONTENT_THRESHOLD_T", "AD_CONTENT_THRESHOLD_PG", "AD_CONTENT_THRESHOLD_G", "AD_CONTENT_THRESHOLD_UNSPECIFIED", "setAdContentThreshold", "", "adConsentThreshold", "getAdContentThreshold", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OguryAdRequests {
    public static final String AD_CONTENT_THRESHOLD_G = "G";
    public static final String AD_CONTENT_THRESHOLD_MA = "MA";
    public static final String AD_CONTENT_THRESHOLD_PG = "PG";
    public static final String AD_CONTENT_THRESHOLD_T = "T";
    public static final String AD_CONTENT_THRESHOLD_UNSPECIFIED = "";
    public static final OguryAdRequests INSTANCE = new OguryAdRequests();

    private OguryAdRequests() {
    }

    @JvmStatic
    public static final String getAdContentThreshold() {
        e2 e2Var = e2.f7288a;
        return e2.b();
    }

    @JvmStatic
    public static final void setAdContentThreshold(String adConsentThreshold) {
        Intrinsics.checkNotNullParameter(adConsentThreshold, "adConsentThreshold");
        e2 e2Var = e2.f7288a;
        Intrinsics.checkNotNullParameter("AD_CONTENT_THRESHOLD", "key");
        if (adConsentThreshold != null) {
            e2.b.putString("AD_CONTENT_THRESHOLD", adConsentThreshold);
        } else {
            Intrinsics.checkNotNullParameter("AD_CONTENT_THRESHOLD", "configurationKey");
            e2.b.remove("AD_CONTENT_THRESHOLD");
        }
    }
}
