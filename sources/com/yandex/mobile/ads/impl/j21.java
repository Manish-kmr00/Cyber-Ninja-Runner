package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j21 implements n11, o11, ve1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f9281a = new ArrayList();
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();

    public final void a(n11 mobileAdsSchemeImpressionListener) {
        Intrinsics.checkNotNullParameter(mobileAdsSchemeImpressionListener, "mobileAdsSchemeImpressionListener");
        this.f9281a.add(mobileAdsSchemeImpressionListener);
    }

    public final void a(o11 mobileAdsSchemeRewardListener) {
        Intrinsics.checkNotNullParameter(mobileAdsSchemeRewardListener, "mobileAdsSchemeRewardListener");
        this.b.add(mobileAdsSchemeRewardListener);
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void e() {
        Iterator it = this.f9281a.iterator();
        while (it.hasNext()) {
            ((n11) it.next()).e();
        }
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void b() {
        Iterator it = this.f9281a.iterator();
        while (it.hasNext()) {
            ((n11) it.next()).b();
        }
    }

    public final void a(ve1 onCloseButtonListener) {
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        this.c.add(onCloseButtonListener);
    }

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void c() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((ve1) it.next()).c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.o11
    public final void a() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((o11) it.next()).a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void a(boolean z) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((ve1) it.next()).a(z);
        }
    }
}
