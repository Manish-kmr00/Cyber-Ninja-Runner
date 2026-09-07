package com.inmobi.ads;

import android.content.Context;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.C3623x5;
import com.inmobi.media.C3637y5;
import com.inmobi.media.E9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements PreloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3623x5 f3022a;
    public final /* synthetic */ InMobiInterstitial b;

    public f(InMobiInterstitial inMobiInterstitial) {
        this.b = inMobiInterstitial;
        this.f3022a = new C3623x5(inMobiInterstitial);
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void load() {
        try {
            this.b.getMAdManager$media_release().D();
        } catch (IllegalStateException e) {
            String strAccess$getTAG$cp = InMobiInterstitial.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$cp, "access$getTAG$cp(...)");
            AbstractC3498o6.a((byte) 1, strAccess$getTAG$cp, e.getMessage());
            this.b.getMPubListener$media_release().a(this.b, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void preload() {
        this.b.b = true;
        this.b.d.e = "Preload";
        C3637y5 mAdManager$media_release = this.b.getMAdManager$media_release();
        E9 e9 = this.b.d;
        Context context = this.b.f3015a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        C3637y5.a(mAdManager$media_release, e9, context, false, null, 12, null);
        this.b.getMAdManager$media_release().c(this.f3022a);
    }
}
