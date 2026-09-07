package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.publisher.privacy.MolocoPrivacy;

/* JADX INFO: loaded from: classes12.dex */
public final class t implements u {
    @Override // com.moloco.sdk.internal.services.bidtoken.u
    public MolocoPrivacy.PrivacySettings getPrivacy() {
        return MolocoPrivacy.INSTANCE.getPrivacySettings();
    }
}
