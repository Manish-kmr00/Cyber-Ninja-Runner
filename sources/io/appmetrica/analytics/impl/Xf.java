package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* JADX INFO: loaded from: classes7.dex */
public final class Xf implements Va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstallReferrerClient f11418a;
    public final ICommonExecutor b;

    public Xf(Context context, ICommonExecutor iCommonExecutor) throws Throwable {
        this(InstallReferrerClient.newBuilder(context).build(), iCommonExecutor);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(InterfaceC4169hg interfaceC4169hg) throws Throwable {
        this.f11418a.startConnection(new Vf(this, interfaceC4169hg));
    }

    public Xf(InstallReferrerClient installReferrerClient, ICommonExecutor iCommonExecutor) {
        this.f11418a = installReferrerClient;
        this.b = iCommonExecutor;
    }
}
