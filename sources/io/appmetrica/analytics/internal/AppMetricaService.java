package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.A1;
import io.appmetrica.analytics.impl.B1;
import io.appmetrica.analytics.impl.BinderC4427s1;
import io.appmetrica.analytics.impl.C4047cj;
import io.appmetrica.analytics.impl.C4072dj;
import io.appmetrica.analytics.impl.C4402r1;
import io.appmetrica.analytics.impl.C4431s5;
import io.appmetrica.analytics.impl.C4486ua;
import io.appmetrica.analytics.impl.C4502v1;
import io.appmetrica.analytics.impl.C4552x1;
import io.appmetrica.analytics.impl.C4577y1;
import io.appmetrica.analytics.impl.C4602z1;
import io.appmetrica.analytics.impl.F1;
import io.appmetrica.analytics.impl.I1;
import io.appmetrica.analytics.impl.L1;
import io.appmetrica.analytics.impl.Pj;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class AppMetricaService extends Service {
    private static F1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C4402r1 f11885a = new C4402r1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        IBinder binderC4427s1 = (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) ? this.b : new BinderC4427s1();
        F1 f1 = c;
        f1.f11132a.execute(new C4602z1(f1, intent));
        return binderC4427s1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        F1 f1 = c;
        f1.f11132a.execute(new C4502v1(f1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C4486ua.a(getApplicationContext());
        PublicLogger.init(getApplicationContext());
        F1 f1 = c;
        if (f1 == null) {
            Context applicationContext = getApplicationContext();
            I1 i1 = new I1(applicationContext, this.f11885a, new C4431s5(applicationContext));
            Pj pj = C4486ua.E.v;
            L1 l1 = new L1(i1);
            LinkedHashMap linkedHashMap = pj.f11298a;
            Object arrayList = linkedHashMap.get(1);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(1, arrayList);
            }
            ((List) arrayList).add(l1);
            c = new F1(C4486ua.E.d.b(), i1);
        } else {
            f1.b.a(this.f11885a);
        }
        C4486ua c4486ua = C4486ua.E;
        C4072dj c4072dj = new C4072dj(c);
        synchronized (c4486ua) {
            c4486ua.f = new C4047cj(c4486ua.f11797a, c4072dj);
        }
        c.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        F1 f1 = c;
        f1.f11132a.execute(new A1(f1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        F1 f1 = c;
        f1.f11132a.execute(new C4552x1(f1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        F1 f1 = c;
        f1.f11132a.execute(new C4577y1(f1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        F1 f1 = c;
        f1.f11132a.execute(new B1(f1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
