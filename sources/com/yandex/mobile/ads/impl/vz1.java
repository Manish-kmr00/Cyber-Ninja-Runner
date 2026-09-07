package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class vz1 extends b71 {
    private final f81 e;
    private final iw1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz1(Context context, f81 nativeCompositeAd, qz1 assetsValidator, iw1 sdkSettings, o8 adResponse) {
        super(context, assetsValidator, adResponse);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeCompositeAd, "nativeCompositeAd");
        Intrinsics.checkNotNullParameter(assetsValidator, "assetsValidator");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.e = nativeCompositeAd;
        this.f = sdkSettings;
    }

    @Override // com.yandex.mobile.ads.impl.b71
    public final f92 a(Context context, f92.a status, boolean z, int i) {
        int iD;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        if (status == f92.a.c) {
            Intrinsics.checkNotNullParameter(context, "context");
            List<v81> listFilterIsInstance = CollectionsKt.filterIsInstance(this.e.e(), v81.class);
            if ((listFilterIsInstance instanceof Collection) && listFilterIsInstance.isEmpty()) {
                status = f92.a.g;
            } else {
                for (v81 v81Var : listFilterIsInstance) {
                    ja1 nativeAdValidator = v81Var.f();
                    bc1 nativeVisualBlock = v81Var.g();
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(nativeAdValidator, "nativeAdValidator");
                    Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
                    cu1 cu1VarA = this.f.a(context);
                    boolean z2 = cu1VarA == null || cu1VarA.h0();
                    Iterator<xx1> it = nativeVisualBlock.e().iterator();
                    do {
                        if (it.hasNext()) {
                            iD = z2 ? it.next().d() : i;
                        }
                    } while ((z ? nativeAdValidator.b(context, iD) : nativeAdValidator.a(context, iD)).b() == f92.a.c);
                }
                status = f92.a.g;
            }
        }
        return new f92(status);
    }

    @Override // com.yandex.mobile.ads.impl.b71
    public final Pair<f92.a, String> a(Context context, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.f.a(context);
        if (cu1VarA != null && !cu1VarA.h0()) {
            return new Pair<>(f92.a.c, null);
        }
        return super.a(context, i, z, z2);
    }
}
