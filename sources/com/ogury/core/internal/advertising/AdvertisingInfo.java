package com.ogury.core.internal.advertising;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvertisingInfo.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ogury/core/internal/advertising/AdvertisingInfo;", "", "id", "", "isAdTrackingEnabled", "", "<init>", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AdvertisingInfo {
    private final String id;
    private final boolean isAdTrackingEnabled;

    public AdvertisingInfo(String id, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.isAdTrackingEnabled = z;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: isAdTrackingEnabled, reason: from getter */
    public final boolean getIsAdTrackingEnabled() {
        return this.isAdTrackingEnabled;
    }
}
