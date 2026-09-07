package com.inmobi.ads;

import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3534r1;
import com.inmobi.media.B1;
import com.inmobi.media.C3633y1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements PreloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3633y1 f3021a;
    public final /* synthetic */ InMobiBanner b;

    public e(InMobiBanner inMobiBanner) {
        this.b = inMobiBanner;
        this.f3021a = new C3633y1(inMobiBanner);
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void load() {
        try {
            B1 mAdManager = this.b.getMAdManager();
            if (mAdManager != null) {
                mAdManager.G();
            }
        } catch (IllegalStateException e) {
            String strAccess$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$cp, "access$getTAG$cp(...)");
            AbstractC3498o6.a((byte) 1, strAccess$getTAG$cp, e.getMessage());
            AbstractC3534r1 mPubListener = this.b.getMPubListener();
            if (mPubListener != null) {
                mPubListener.a(this.b, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        }
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void preload() {
        this.b.setEnableAutoRefresh(false);
        this.b.a(this.f3021a, "Preload", false);
    }
}
