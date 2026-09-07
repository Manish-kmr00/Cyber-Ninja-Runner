package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3094y implements OnSuccessListener {
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        try {
            if (appSetIdInfo.getScope() == 2) {
                IAConfigManager.O.r = appSetIdInfo.getId();
            }
        } catch (Throwable th) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            IAlog.f("%sFailed to resolve AppSetId: %s", IAlog.a(IAConfigManager.class), th.getMessage());
            AbstractC3149z.a("Failed to resolve AppSetId", th.getMessage(), null, null);
        }
    }
}
