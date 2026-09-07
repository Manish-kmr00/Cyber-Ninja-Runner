package io.appmetrica.analytics.impl;

import android.content.Context;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class Q implements Ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11302a;
    public final ICommonExecutor b;
    public FutureTask i;
    public final G j;
    public final String c = "advertising identifiers collecting is forbidden by client configuration";
    public final String d = "advertising identifiers collecting is forbidden by startup";
    public final String e = "advertising identifiers collecting is forbidden by unknown reason";
    public final K f = new K(new C4343og("google"));
    public final K g = new K(new C4343og("huawei"));
    public final K h = new K(new C4343og("yandex"));
    public volatile AdvertisingIdsHolder k = new AdvertisingIdsHolder();
    public D l = new D(4, 4, 4);

    public Q(Context context, ICommonExecutor iCommonExecutor, Hl hl) {
        this.f11302a = context;
        this.b = iCommonExecutor;
        this.j = new G(hl);
    }

    public static final Void e(Q q) {
        q.k = new AdvertisingIdsHolder(q.a(q.l.f11095a, new N(q)), q.a(q.l.b, new O(q)), q.a(q.l.c, new P(q, new Pd())));
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter
    public final synchronized AdvertisingIdsHolder getIdentifiers(Context context) {
        return getIdentifiers();
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final synchronized void init() {
        if (this.i == null) {
            this.l = this.j.a();
            FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.Q$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Q.e(this.f$0);
                }
            });
            this.i = futureTask;
            this.b.execute(futureTask);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ha, io.appmetrica.analytics.impl.Ml
    public final synchronized void a(Hl hl) {
        this.j.a(hl);
        a((InterfaceC4544wi) new Pd(), false);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final synchronized void b(boolean z) {
        this.j.b.update(z);
        a((InterfaceC4544wi) new Pd(), false);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final synchronized AdvertisingIdsHolder getIdentifiers() {
        FutureTask futureTask = this.i;
        if (futureTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ToolBar.REFRESH);
            futureTask = null;
        }
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.k;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final synchronized AdvertisingIdsHolder a() {
        return a(new Pd());
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final synchronized AdvertisingIdsHolder a(InterfaceC4544wi interfaceC4544wi) {
        try {
            a(interfaceC4544wi, true).get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.k;
    }

    public final FutureTask a(final InterfaceC4544wi interfaceC4544wi, final boolean z) {
        final D dA = this.j.a();
        FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.Q$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Q.a(z, dA, this, interfaceC4544wi);
            }
        });
        this.i = futureTask;
        this.b.execute(futureTask);
        FutureTask futureTask2 = this.i;
        if (futureTask2 != null) {
            return futureTask2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ToolBar.REFRESH);
        return null;
    }

    public static final Void a(boolean z, D d, Q q, InterfaceC4544wi interfaceC4544wi) {
        if (!z && Intrinsics.areEqual(d, q.l)) {
            return null;
        }
        AdvertisingIdsHolder advertisingIdsHolder = q.k;
        AdTrackingInfoResult adTrackingInfoResultA = q.a(d.f11095a, new N(q));
        AdTrackingInfoResult google = advertisingIdsHolder.getGoogle();
        IdentifierStatus identifierStatus = adTrackingInfoResultA.mStatus;
        IdentifierStatus identifierStatus2 = IdentifierStatus.UNKNOWN;
        if (identifierStatus == identifierStatus2) {
            adTrackingInfoResultA = new AdTrackingInfoResult(google.mAdTrackingInfo, adTrackingInfoResultA.mStatus, adTrackingInfoResultA.mErrorExplanation);
        }
        AdTrackingInfoResult adTrackingInfoResultA2 = q.a(d.b, new O(q));
        AdTrackingInfoResult huawei = advertisingIdsHolder.getHuawei();
        if (adTrackingInfoResultA2.mStatus == identifierStatus2) {
            adTrackingInfoResultA2 = new AdTrackingInfoResult(huawei.mAdTrackingInfo, adTrackingInfoResultA2.mStatus, adTrackingInfoResultA2.mErrorExplanation);
        }
        AdTrackingInfoResult adTrackingInfoResultA3 = q.a(d.c, new P(q, interfaceC4544wi));
        AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
        if (adTrackingInfoResultA3.mStatus == identifierStatus2) {
            adTrackingInfoResultA3 = new AdTrackingInfoResult(yandex.mAdTrackingInfo, adTrackingInfoResultA3.mStatus, adTrackingInfoResultA3.mErrorExplanation);
        }
        q.k = new AdvertisingIdsHolder(adTrackingInfoResultA, adTrackingInfoResultA2, adTrackingInfoResultA3);
        return null;
    }

    public final AdTrackingInfoResult a(int i, Function0 function0) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return (AdTrackingInfoResult) function0.invoke();
        }
        if (i2 == 1) {
            return new AdTrackingInfoResult(null, IdentifierStatus.FORBIDDEN_BY_CLIENT_CONFIG, this.c);
        }
        if (i2 == 2) {
            return new AdTrackingInfoResult(null, IdentifierStatus.FEATURE_DISABLED, this.d);
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, this.e);
    }
}
