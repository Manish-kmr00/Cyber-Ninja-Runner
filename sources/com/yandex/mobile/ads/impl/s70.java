package com.yandex.mobile.ads.impl;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<r70> f10181a;

    public final boolean a() {
        Intrinsics.checkNotNullParameter(CreativeInfo.S, "type");
        Intrinsics.checkNotNullParameter("adfox", "value");
        List<r70> list = this.f10181a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (r70 r70Var : list) {
                if (Intrinsics.areEqual(r70Var.a(), CreativeInfo.S) && Intrinsics.areEqual(r70Var.b(), "adfox")) {
                    return true;
                }
            }
        }
        return false;
    }

    public /* synthetic */ s70(mb2 mb2Var) {
        this(mb2Var, mb2Var.a());
    }

    public s70(mb2 videoAdExtensions, List<r70> extensions) {
        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.f10181a = extensions;
    }
}
