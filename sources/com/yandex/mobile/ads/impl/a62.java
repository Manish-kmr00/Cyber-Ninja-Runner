package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a62 extends jg0 implements nk0.a, n0 {
    private final va e;
    private final mk0 f;
    private final a31 g;
    private final nk0 h;
    private final l0 i;
    private final mo1 j;

    protected abstract boolean a(int i);

    protected abstract boolean k();

    protected abstract boolean l();

    public /* synthetic */ a62(Context context, va vaVar, o8 o8Var, o3 o3Var) {
        this(context, vaVar, o8Var, o3Var, new mk0(), new s4(new kg0(o8Var)), new qk0(context, o8Var, o3Var, o8Var.B()), new no1(), new pd1(), new ok0(), new nd1());
    }

    public static final boolean a(a62 a62Var) {
        return !a62Var.e.b();
    }

    @Override // com.yandex.mobile.ads.impl.ch1.b
    public final void a(zg1 phoneState) {
        Intrinsics.checkNotNullParameter(phoneState, "phoneState");
        String str = "onPhoneStateChanged(), phoneState = " + phoneState + ", isAdVisible = " + this.e.b();
        op0.d(new Object[0]);
        this.g.a(phoneState, this.e.b());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected a62(Context context, va adVisibilityValidator, o8<String> adResponse, o3 adConfiguration, mk0 impressionEventsObservable, s4 adIdStorageManager, qk0 impressionReporter, no1 renderTrackingManagerFactory, pd1 noticeTrackingManagerProvider, ok0 impressionManagerCreator, nd1 noticeTrackerForceImpressionListenerFactory) {
        super(context, adResponse);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adVisibilityValidator, "adVisibilityValidator");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(renderTrackingManagerFactory, "renderTrackingManagerFactory");
        Intrinsics.checkNotNullParameter(noticeTrackingManagerProvider, "noticeTrackingManagerProvider");
        Intrinsics.checkNotNullParameter(impressionManagerCreator, "impressionManagerCreator");
        Intrinsics.checkNotNullParameter(noticeTrackerForceImpressionListenerFactory, "noticeTrackerForceImpressionListenerFactory");
        this.e = adVisibilityValidator;
        this.f = impressionEventsObservable;
        this.i = new l0(context, adConfiguration, adResponse, this, adResponse.z());
        a aVar = new a();
        impressionManagerCreator.getClass();
        this.h = ok0.a(context, this, impressionReporter, adIdStorageManager, impressionEventsObservable);
        a31 a31VarA = noticeTrackingManagerProvider.a(context, adConfiguration, impressionReporter, aVar, oa.a(this), s9.b);
        this.g = a31VarA;
        a31VarA.a(impressionEventsObservable);
        noticeTrackerForceImpressionListenerFactory.getClass();
        impressionEventsObservable.a(nd1.a(a31VarA));
        renderTrackingManagerFactory.getClass();
        this.j = no1.a(context, adResponse, adConfiguration, adIdStorageManager, adVisibilityValidator, impressionEventsObservable);
    }

    public final mk0 j() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.jg0, com.yandex.mobile.ads.impl.yj
    public final void b() {
        String str = "cleanOut(), clazz = " + this;
        op0.d(new Object[0]);
        super.b();
        this.g.a();
        this.j.c();
    }

    @Override // com.yandex.mobile.ads.impl.q3
    public void a(int i, Bundle bundle) {
        String str = "onReceiveResult(), resultCode = " + i;
        op0.d(new Object[0]);
        if (i == 14) {
            this.f.e();
            return;
        }
        if (i != 15) {
            switch (i) {
                case 6:
                    onLeftApplication();
                    this.i.g();
                    break;
                case 7:
                    onLeftApplication();
                    this.i.e();
                    break;
                case 8:
                    this.i.f();
                    break;
                case 9:
                    op0.d(new Object[0]);
                    this.i.a();
                    this.f.a();
                    break;
            }
            return;
        }
        this.f.b();
    }

    public final synchronized void m() {
        String str = "trackAdOnDisplayed(), clazz = " + this;
        op0.d(new Object[0]);
        this.g.b();
        this.j.b();
    }

    public final class a implements c62 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.c62
        public final f92 b(int i) {
            f92.a aVar;
            if (a62.this.f()) {
                aVar = f92.a.d;
            } else if (a62.a(a62.this)) {
                aVar = f92.a.m;
            } else if (!a62.this.l()) {
                aVar = f92.a.o;
            } else if (a62.this.a(i) && a62.this.k()) {
                aVar = f92.a.c;
            } else {
                aVar = f92.a.j;
            }
            return new f92(aVar);
        }

        @Override // com.yandex.mobile.ads.impl.c62
        public final f92 a(int i) {
            f92.a aVar;
            if (a62.a(a62.this)) {
                aVar = f92.a.m;
            } else if (!a62.this.l()) {
                aVar = f92.a.o;
            } else if (!a62.this.k()) {
                aVar = f92.a.j;
            } else {
                aVar = f92.a.c;
            }
            return new f92(aVar);
        }
    }

    public final void b(int i) {
        String str = "onVisibilityChanged(), visibility = " + i;
        op0.d(new Object[0]);
        int i2 = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(e());
        if (cu1VarA == null || !cu1VarA.j0()) {
            if (this.e.b()) {
                this.g.b();
            } else {
                this.g.a();
            }
        } else if (i == 0) {
            this.g.b();
        } else {
            this.g.a();
        }
        op0.d(getClass().toString(), Integer.valueOf(i));
    }

    public final void a(Map<String, String> map) {
        String str = "startHtmlAdTracking(), clazz = " + this;
        op0.d(new Object[0]);
        ArrayList arrayListA = oa.a(d(), map);
        this.h.a(arrayListA, d().B());
        this.g.a(d(), arrayListA);
        m();
    }
}
