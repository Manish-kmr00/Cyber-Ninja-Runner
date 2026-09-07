package com.inmobi.media;

import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Y0 implements X0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z0 f3241a;

    public Y0(Z0 z0) {
        this.f3241a = z0;
    }

    @Override // com.inmobi.media.X0
    public final void a(T8 response, String locationOnDisk, C3417j asset) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(asset, "asset");
        C3335d1 c3335d1 = (C3335d1) this.f3241a.f3250a.get();
        AdConfig.AssetCacheConfig assetCacheConfig = c3335d1 != null ? C3335d1.c : null;
        if (assetCacheConfig == null) {
            C3335d1 c3335d2 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            return;
        }
        C3335d1 c3335d3 = C3335d1.f3289a;
        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        C3403i c3403iA = new C3403i().a(asset.b, locationOnDisk, response, assetCacheConfig.getMaxRetries(), assetCacheConfig.getTimeToLive());
        int i = c3403iA.f3336a;
        String str = c3403iA.c;
        if (str == null) {
            str = "";
        }
        C3417j c3417j = new C3417j(i, str, c3403iA.d, c3403iA.b, c3403iA.e, c3403iA.f, c3403iA.g, c3403iA.h);
        AbstractC3415ib.a().a(c3417j);
        c3417j.j = asset.j;
        c3417j.k = asset.k;
        c3335d1.a(c3417j, (byte) -1);
        Z0 z0 = this.f3241a;
        z0.getClass();
        try {
            z0.sendEmptyMessage(3);
        } catch (Exception unused) {
            C3335d1 c3335d4 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        }
    }

    @Override // com.inmobi.media.X0
    public final void a(C3417j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C3335d1 c3335d1 = (C3335d1) this.f3241a.f3250a.get();
        if (c3335d1 != null) {
            C3335d1 c3335d2 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            C3335d1.k.remove(asset.b);
            int i = asset.d;
            if (i > 0) {
                asset.d = i - 1;
                asset.e = System.currentTimeMillis();
                AbstractC3415ib.a().a(asset);
                this.f3241a.a();
                return;
            }
            c3335d1.a(asset, asset.l);
            Z0 z0 = this.f3241a;
            z0.getClass();
            try {
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = asset;
                z0.sendMessage(messageObtain);
                return;
            } catch (Exception unused) {
                C3335d1 c3335d3 = C3335d1.f3289a;
                Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                return;
            }
        }
        C3335d1 c3335d4 = C3335d1.f3289a;
        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
    }
}
