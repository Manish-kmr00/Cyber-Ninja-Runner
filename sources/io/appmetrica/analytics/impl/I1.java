package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule;
import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class I1 implements InterfaceC4477u1, InterfaceC4252l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11185a;
    public final Context b;
    public volatile InterfaceC4452t1 c;
    public final C4430s4 d;
    public final P1 e;
    public Lg f;
    public final C4262la g;
    public final Id h;
    public final C4229k2 i;
    public final ICommonExecutor j;
    public final J1 k;
    public final G1 l;
    public final Vg m;
    public C4333o6 n;

    public I1(Context context, InterfaceC4452t1 interfaceC4452t1) {
        this(context, interfaceC4452t1, new C4431s5(context));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent, int i) {
        b(intent, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void b(Intent intent) {
        this.e.d(intent);
        if (intent != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String encodedAuthority = data == null ? null : data.getEncodedAuthority();
            if ("io.appmetrica.analytics.IAppMetricaService".equals(action) && data != null && data.getPath().equals("/client")) {
                int i = Integer.parseInt(data.getQueryParameter("pid"));
                this.d.a(i, encodedAuthority, data.getQueryParameter("psid"));
                this.i.a(i);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void c(Intent intent) {
        P1 p1 = this.e;
        if (intent == null) {
            p1.getClass();
            return;
        }
        p1.getClass();
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            p1.f11289a.a(action, Integer.valueOf(P1.a(intent)));
        }
        for (Map.Entry entry : p1.b.entrySet()) {
            O1 o1 = (O1) entry.getKey();
            if (((N1) entry.getValue()).a(intent)) {
                o1.a(intent);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void onConfigurationChanged(Configuration configuration) {
        C4486ua.E.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void onCreate() {
        if (this.f11185a) {
            C4486ua.E.u().a(this.b.getResources().getConfiguration());
        } else {
            this.g.b(this.b);
            C4486ua c4486ua = C4486ua.E;
            synchronized (c4486ua) {
                c4486ua.B.initAsync();
                c4486ua.u.a(c4486ua.f11797a);
                c4486ua.u.a(new Gn(c4486ua.B));
                NetworkServiceLocator.init();
                c4486ua.k().a(c4486ua.q);
                c4486ua.C();
            }
            Jj.f11212a.e();
            Jl jl = C4486ua.E.u;
            jl.b();
            Hl hlB = jl.b();
            C4023bk c4023bkO = C4486ua.E.o();
            c4023bkO.a(new Nj(new C4116fd(this.e)), hlB);
            jl.a(c4023bkO);
            ((C4049cl) C4486ua.E.y()).getClass();
            this.e.c(new H1(this));
            C4486ua.E.l().init();
            C4486ua.E.b().init();
            J1 j1 = this.k;
            Context context = this.b;
            C4430s4 c4430s4 = this.d;
            j1.getClass();
            this.f = new Lg(context, c4430s4, C4486ua.E.d.e(), new C4163ha());
            Context context2 = this.b;
            AbstractC4303n1.f11678a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            File crashesDirectory = FileUtils.getCrashesDirectory(this.b);
            if (crashesDirectory != null) {
                J1 j2 = this.k;
                G1 g1 = this.l;
                j2.getClass();
                this.n = new C4333o6(new FileObserverC4358p6(crashesDirectory, g1, new C4163ha()), crashesDirectory, new C4383q6());
                this.j.execute(new Hf(crashesDirectory, this.l, C4138ga.a(this.b)));
                C4333o6 c4333o6 = this.n;
                C4383q6 c4383q6 = c4333o6.c;
                File file = c4333o6.b;
                c4383q6.getClass();
                if (file != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    } else if (!file.isDirectory() && file.delete()) {
                        file.mkdir();
                    }
                }
                c4333o6.f11697a.startWatching();
            }
            Id id = this.h;
            Context context3 = this.b;
            Lg lg = this.f;
            id.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            Gd gd = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                id.f11195a.init(context3, new NativeCrashServiceConfig(absolutePath));
                Gd gd2 = new Gd(lg, new Hd(id));
                id.b = gd2;
                gd2.a(id.f11195a.getAllCrashes());
                NativeCrashServiceModule nativeCrashServiceModule = id.f11195a;
                Gd gd3 = id.b;
                if (gd3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(com.json.b4.h);
                } else {
                    gd = gd3;
                }
                nativeCrashServiceModule.setDefaultCrashHandler(gd);
            }
            new T5(CollectionsKt.listOf(new Qg())).run();
            this.f11185a = true;
        }
        C4486ua.E.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void onDestroy() {
        Kb kbK = C4486ua.E.k();
        synchronized (kbK) {
            Iterator it = kbK.c.iterator();
            while (it.hasNext()) {
                ((Vj) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void pauseUserSession(Bundle bundle) {
        C4367pf c4367pf;
        bundle.setClassLoader(C4367pf.class.getClassLoader());
        String str = C4367pf.c;
        try {
            c4367pf = (C4367pf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            c4367pf = null;
        }
        Integer asInteger = c4367pf != null ? c4367pf.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.i.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void reportData(int i, Bundle bundle) {
        this.m.getClass();
        List listEmptyList = (List) C4486ua.E.v.f11298a.get(Integer.valueOf(i));
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            ((Oj) it.next()).reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void resumeUserSession(Bundle bundle) {
        C4367pf c4367pf;
        bundle.setClassLoader(C4367pf.class.getClassLoader());
        String str = C4367pf.c;
        try {
            c4367pf = (C4367pf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            c4367pf = null;
        }
        Integer asInteger = c4367pf != null ? c4367pf.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.i.c(asInteger.intValue());
        }
    }

    public I1(Context context, InterfaceC4452t1 interfaceC4452t1, C4431s5 c4431s5) {
        this(context, interfaceC4452t1, new C4430s4(context, c4431s5), new P1(), C4262la.d, C4486ua.j().d(), C4486ua.j().w().e(), new J1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent, int i, int i2) {
        b(intent, i2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent) {
        P1 p1 = this.e;
        if (intent != null) {
            p1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                p1.f11289a.a(action, Integer.valueOf(P1.a(intent)));
            }
            for (Map.Entry entry : p1.b.entrySet()) {
                O1 o1 = (O1) entry.getKey();
                if (((N1) entry.getValue()).a(intent)) {
                    o1.a(intent);
                }
            }
            return;
        }
        p1.getClass();
    }

    public I1(Context context, InterfaceC4452t1 interfaceC4452t1, C4430s4 c4430s4, P1 p1, C4262la c4262la, C4229k2 c4229k2, IHandlerExecutor iHandlerExecutor, J1 j1) {
        this.f11185a = false;
        this.l = new G1(this);
        this.b = context;
        this.c = interfaceC4452t1;
        this.d = c4430s4;
        this.e = p1;
        this.g = c4262la;
        this.i = c4229k2;
        this.j = iHandlerExecutor;
        this.k = j1;
        this.h = C4486ua.j().q();
        this.m = new Vg();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C3984a6.b(bundle);
        Lg lg = this.f;
        C3984a6 c3984a6B = C3984a6.b(bundle);
        lg.getClass();
        if (c3984a6B.m()) {
            return;
        }
        lg.b.execute(new RunnableC4070dh(lg.f11245a, c3984a6B, bundle, lg.c));
    }

    public final void b(Intent intent, int i) {
        Bundle extras;
        C4007b4 c4007b4A;
        if (intent != null) {
            intent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
            if (intent.getData() != null && (c4007b4A = C4007b4.a(this.b, (extras = intent.getExtras()))) != null) {
                C3984a6 c3984a6B = C3984a6.b(extras);
                if (!(c3984a6B.l() | c3984a6B.m())) {
                    try {
                        Lg lg = this.f;
                        C4157h4 c4157h4A = C4157h4.a(c4007b4A);
                        G4 g4 = new G4(c4007b4A);
                        lg.c.a(c4157h4A, g4).a(c3984a6B, g4);
                        lg.c.a(c4157h4A.c.intValue(), c4157h4A.b, c4157h4A.d);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        ((C4402r1) this.c).f11742a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(InterfaceC4452t1 interfaceC4452t1) {
        this.c = interfaceC4452t1;
    }

    public final void a(File file) {
        Lg lg = this.f;
        lg.getClass();
        C4437sb c4437sb = new C4437sb();
        lg.b.execute(new Gf(file, c4437sb, c4437sb, new Hg(lg)));
    }
}
