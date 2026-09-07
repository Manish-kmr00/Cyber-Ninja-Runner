package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c81 implements p41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p51 f8578a;

    @Override // com.yandex.mobile.ads.impl.p41
    public final void a(Context context, o41 nativeAdBlock, pj0 imageProvider, n41 nativeAdBinderFactory, o51 nativeAdFactoriesProvider, a51 nativeAdControllers, c51 nativeAdCreationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdBinderFactory, "nativeAdBinderFactory");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        List<c41> listE = nativeAdBlock.c().e();
        ArrayList arrayList = new ArrayList();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            c41 c41Var = (c41) it.next();
            Iterator it2 = it;
            ArrayList arrayList2 = arrayList;
            m61 m61VarA = this.f8578a.a(context, nativeAdBlock, imageProvider, nativeAdBinderFactory, nativeAdFactoriesProvider, nativeAdControllers, c41Var);
            if (m61VarA != null) {
                arrayList2.add(m61VarA);
            }
            arrayList = arrayList2;
            it = it2;
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3.isEmpty()) {
            nativeAdCreationListener.a(w7.x());
        } else {
            nativeAdCreationListener.a(arrayList3);
        }
    }

    public /* synthetic */ c81(uu1 uu1Var) {
        this(uu1Var, new p51(uu1Var));
    }

    public c81(uu1 sdkEnvironmentModule, p51 nativeAdFactory) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdFactory, "nativeAdFactory");
        this.f8578a = nativeAdFactory;
    }
}
