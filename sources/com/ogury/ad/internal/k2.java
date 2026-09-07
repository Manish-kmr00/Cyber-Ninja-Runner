package com.ogury.ad.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f7336a;
    public final List<String> b;

    public k2(ArrayList whitelist, ArrayList blacklist) {
        Intrinsics.checkNotNullParameter(whitelist, "whitelist");
        Intrinsics.checkNotNullParameter(blacklist, "blacklist");
        this.f7336a = whitelist;
        this.b = blacklist;
    }
}
