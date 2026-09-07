package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class gu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jc f9036a;
    private final m50 b;
    private final g5 c;
    private final nu1 d;
    private final iu1 e;
    private final zp1 f;
    private final ku1 g;
    private final k22 h;
    private final Context i;

    public interface a {
        void a(cu1 cu1Var, ir irVar);

        void a(ki2 ki2Var, ir irVar);
    }

    public /* synthetic */ gu1(Context context, lp1 lp1Var, jc jcVar, m50 m50Var, g5 g5Var) {
        nu1 nu1Var = new nu1(context, lp1Var);
        int i = iu1.d;
        iu1 iu1VarA = iu1.a.a();
        int i2 = zp1.c;
        this(context, lp1Var, jcVar, m50Var, g5Var, nu1Var, iu1VarA, zp1.a.a(), new ku1(), new k22(lp1Var));
    }

    public gu1(Context context, lp1 reporter, jc advertisingConfiguration, m50 environmentController, g5 adLoadingPhasesManager, nu1 requestPolicy, iu1 sdkConfigurationProvider, zp1 requestManager, ku1 queryConfigurator, k22 startupRequestReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(sdkConfigurationProvider, "sdkConfigurationProvider");
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Intrinsics.checkNotNullParameter(queryConfigurator, "queryConfigurator");
        Intrinsics.checkNotNullParameter(startupRequestReporter, "startupRequestReporter");
        this.f9036a = advertisingConfiguration;
        this.b = environmentController;
        this.c = adLoadingPhasesManager;
        this.d = requestPolicy;
        this.e = sdkConfigurationProvider;
        this.f = requestManager;
        this.g = queryConfigurator;
        this.h = startupRequestReporter;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.i = applicationContext;
    }

    public final void a() {
        zp1 zp1Var = this.f;
        Context context = this.i;
        zp1Var.getClass();
        zp1.a(context, this);
    }

    public final void a(dx1 sensitiveModeChecker, dl0 initializationCallSource, hu1.a.b listener) {
        String str;
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(initializationCallSource, "initializationCallSource");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(this.i);
        if (cu1VarA != null && !this.d.a()) {
            listener.a(cu1VarA, ir.d);
            return;
        }
        ou1 ou1Var = new ou1(this.i, this.e, listener, this.c);
        this.h.a(initializationCallSource);
        l50 l50VarC = this.b.c();
        Context context = this.i;
        String strA = l50VarC.a();
        if (strA == null || strA.length() == 0) {
            str = null;
        } else {
            String strA2 = this.g.a(context, sensitiveModeChecker, this.f9036a, l50VarC);
            StringBuilder sb = new StringBuilder();
            sb.append(strA);
            if (!Intrinsics.areEqual(String.valueOf(StringsKt.last(sb)), RemoteSettings.FORWARD_SLASH_STRING)) {
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            sb.append("v1/startup");
            sb.append("?");
            sb.append(strA2);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            str = string;
        }
        if (str != null && str.length() != 0) {
            mu1 request = new mu1(this.i, str, this.d, l50VarC.d(), ou1Var, ou1Var);
            request.b(this);
            g5 g5Var = this.c;
            f5 f5Var = f5.n;
            ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
            zp1 zp1Var = this.f;
            Context context2 = this.i;
            synchronized (zp1Var) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(request, "request");
                dd1.a(context2).a(request);
            }
            return;
        }
        ou1Var.a((ki2) new r3(x3.j, null));
    }
}
