package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4217jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4118ff f11619a;

    public C4217jf(PreloadInfo preloadInfo, PublicLogger publicLogger, boolean z) {
        if (preloadInfo != null) {
            if (TextUtils.isEmpty(preloadInfo.getTrackingId())) {
                publicLogger.error("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.", new Object[0]);
            } else {
                this.f11619a = new C4118ff(preloadInfo.getTrackingId(), new JSONObject(preloadInfo.getAdditionalParams()), true, z, X7.c);
            }
        }
    }
}
