package com.ogury.ad;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ogury/ad/OguryBidTokenErrorCode;", "", "<init>", "()V", "SDK_NOT_STARTED", "", "SDK_NOT_PROPERLY_INITIALIZED", "INVALID_CONFIGURATION", "AD_DISABLED_COUNTRY_NOT_OPENED", "AD_DISABLED_CONSENT_DENIED", "AD_DISABLED_CONSENT_MISSING", "AD_DISABLED_UNSPECIFIED_REASON", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OguryBidTokenErrorCode {
    public static final int AD_DISABLED_CONSENT_DENIED = 4102;
    public static final int AD_DISABLED_CONSENT_MISSING = 4103;
    public static final int AD_DISABLED_COUNTRY_NOT_OPENED = 4101;
    public static final int AD_DISABLED_UNSPECIFIED_REASON = 4104;
    public static final OguryBidTokenErrorCode INSTANCE = new OguryBidTokenErrorCode();
    public static final int INVALID_CONFIGURATION = 4100;
    public static final int SDK_NOT_PROPERLY_INITIALIZED = 4001;
    public static final int SDK_NOT_STARTED = 4000;

    private OguryBidTokenErrorCode() {
    }
}
