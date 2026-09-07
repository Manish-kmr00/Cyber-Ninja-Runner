package com.ogury.core.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GppConsentConstants.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ogury/core/internal/GppConsentConstants;", "", "<init>", "()V", "GPP_CONSENT_KEY", "", "GPP_CONSENT_SID_KEY", "IABTCF_CONSENT_KEY", "CONSENT_KEYS", "", "getCONSENT_KEYS", "()Ljava/util/List;", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GppConsentConstants {
    public static final String GPP_CONSENT_KEY = "IABGPP_HDR_GppString";
    public static final String GPP_CONSENT_SID_KEY = "IABGPP_GppSID";
    public static final String IABTCF_CONSENT_KEY = "IABTCF_TCString";
    public static final GppConsentConstants INSTANCE = new GppConsentConstants();
    private static final List<String> CONSENT_KEYS = CollectionsKt.listOf((Object[]) new String[]{"IABGPP_HDR_GppString", "IABGPP_GppSID", "IABTCF_TCString"});

    private GppConsentConstants() {
    }

    public final List<String> getCONSENT_KEYS() {
        return CONSENT_KEYS;
    }
}
