package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class lk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hk2 f9533a;
    private final ArrayList b;
    private wp1<List<eb2>> c;
    private int d;

    public lk2(Context context, o3 adConfiguration, fd2 reportParametersProvider, aa2 requestConfigurationParametersProvider, hk2 loader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.f9533a = loader;
        this.b = new ArrayList();
    }

    public final void a(Context context, List<eb2> wrapperAds, wp1<List<eb2>> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperAds, "wrapperAds");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (wrapperAds.isEmpty()) {
            listener.a(this.b);
            return;
        }
        this.c = listener;
        for (eb2 eb2Var : wrapperAds) {
            this.d++;
            this.f9533a.a(context, eb2Var, new a());
        }
    }

    private final class a implements wp1<List<? extends eb2>> {
        public a() {
        }

        private final void a() {
            wp1 wp1Var = lk2.this.c;
            if (lk2.this.d != 0 || wp1Var == null) {
                return;
            }
            wp1Var.a(lk2.this.b);
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(kb2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            lk2.this.d--;
            a();
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(List<? extends eb2> list) {
            List<? extends eb2> wrapperAds = list;
            Intrinsics.checkNotNullParameter(wrapperAds, "wrapperAds");
            lk2.this.d--;
            lk2.this.b.addAll(wrapperAds);
            a();
        }
    }
}
