package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.kg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4243kg {
    public C4243kg(Va va) {
    }

    public static Va a(Context context, IHandlerExecutor iHandlerExecutor) {
        Xf xf;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                xf = new Xf(InstallReferrerClient.newBuilder(context).build(), iHandlerExecutor);
            } catch (Throwable unused) {
                xf = null;
            }
        } else {
            xf = null;
        }
        return xf == null ? new C4218jg() : xf;
    }
}
