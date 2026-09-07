package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3321c1 implements X0 {
    @Override // com.inmobi.media.X0
    public final void a(T8 response, String locationOnDisk, C3417j asset) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(asset, "asset");
        C3335d1 c3335d1 = C3335d1.f3289a;
        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        AdConfig.AssetCacheConfig assetCacheConfig = C3335d1.c;
        if (assetCacheConfig != null) {
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
            C3335d1.f3289a.a(c3417j, (byte) -1);
        }
        try {
            C3335d1 c3335d2 = C3335d1.f3289a;
            if (C3335d1.j.get()) {
                return;
            }
            c3335d2.c();
        } catch (Exception e) {
            C3335d1 c3335d3 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    @Override // com.inmobi.media.X0
    public final void a(C3417j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C3335d1 c3335d1 = C3335d1.f3289a;
        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        String str = asset.b;
        C3335d1 c3335d2 = C3335d1.f3289a;
        C3335d1.k.remove(str);
        if (asset.d <= 0) {
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            c3335d2.a(asset, asset.l);
            W0 w0A = AbstractC3415ib.a();
            w0A.getClass();
            Intrinsics.checkNotNullParameter(asset, "asset");
            w0A.a("id = ?", new String[]{String.valueOf(asset.f3343a)});
        } else {
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            asset.e = System.currentTimeMillis();
            AbstractC3415ib.a().a(asset);
            boolean z = W8.f3228a;
            if (W8.a(false) != null) {
                c3335d2.a(asset, asset.l);
            }
        }
        try {
            if (C3335d1.j.get()) {
                return;
            }
            c3335d2.c();
        } catch (Exception e) {
            C3335d1 c3335d3 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
