package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4458t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11776a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public C4458t7(C4263lb c4263lb) {
        this.f11776a = c4263lb.b("dId");
        this.b = c4263lb.b("uId");
        this.c = c4263lb.b("analyticsSdkVersionName");
        this.d = c4263lb.b("kitBuildNumber");
        this.e = c4263lb.b("kitBuildType");
        this.f = c4263lb.b("appVer");
        this.g = c4263lb.optString("app_debuggable", "0");
        this.h = c4263lb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c4263lb.b("osVer");
        this.k = c4263lb.b(com.json.fe.q);
        this.l = c4263lb.b("root");
        this.m = c4263lb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int iOptInt = c4263lb.optInt("osApiLev", -1);
        this.j = iOptInt == -1 ? null : String.valueOf(iOptInt);
        int iOptInt2 = c4263lb.optInt("attribution_id", 0);
        this.n = iOptInt2 > 0 ? String.valueOf(iOptInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f11776a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C4458t7() {
        this.f11776a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }
}
