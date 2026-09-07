package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class so0 implements kg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zm0 f10229a;

    public so0(zm0 instreamAdViewsHolderManager) {
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        this.f10229a = instreamAdViewsHolderManager;
    }

    @Override // com.yandex.mobile.ads.impl.kg2
    public final View getView() {
        ym0 ym0VarA = this.f10229a.a();
        if (ym0VarA != null) {
            return ym0VarA.b();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.kg2
    public final List<pb2> a() {
        List<pb2> listA;
        ym0 ym0VarA = this.f10229a.a();
        return (ym0VarA == null || (listA = ym0VarA.a()) == null) ? CollectionsKt.emptyList() : listA;
    }
}
