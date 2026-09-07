package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4073dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafePackageManager f11519a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        Ri ri;
        Intent intentAddFlags = new Intent(context, (Class<?>) AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = f11519a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent intentPutExtras = intentAddFlags.putExtras(bundle);
        intentPutExtras.setData(intentPutExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", C4367pf.c).build());
        C4455t4 c4455t4I = C4455t4.i();
        synchronized (c4455t4I) {
            if (c4455t4I.o == null) {
                Ri ri2 = new Ri();
                c4455t4I.o = ri2;
                c4455t4I.h.a(ri2);
            }
            ri = c4455t4I.o;
        }
        ScreenInfo screenInfoA = ri.a(context);
        intentPutExtras.putExtra("screen_size", screenInfoA == null ? null : AbstractC4288mb.a(screenInfoA));
        return intentPutExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
