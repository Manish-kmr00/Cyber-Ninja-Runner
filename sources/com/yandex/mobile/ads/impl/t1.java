package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.URLUtil;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final em f10254a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicLong f10255a = new AtomicLong(SystemClock.elapsedRealtime() - 2000);

        public static boolean a() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long andSet = jElapsedRealtime - f10255a.getAndSet(jElapsedRealtime);
            return !(0 <= andSet && andSet < 1001);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:27:0x009a  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a6  */
    public final void a(Context context, o3 adConfiguration, o8<?> adResponse, mp1 reporter, String url, t8 receiver, boolean z) {
        wo woVar;
        String value;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        if (context == null || !a.a()) {
            return;
        }
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        boolean zA = false;
        if (cu1VarA != null && (value = cu1VarA.o()) != null) {
            wo.c.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            wo[] woVarArrValues = wo.values();
            int length = woVarArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    woVar = null;
                    break;
                }
                woVar = woVarArrValues[i2];
                if (Intrinsics.areEqual(woVar.a(), value)) {
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            woVar = null;
            break;
        }
        if ((z && woVar == null) || wo.d == woVar) {
            o82.f9793a.getClass();
            if (o82.a.b(url)) {
                zA = this.f10254a.a(context, adResponse, receiver, adConfiguration, url);
            } else if (new q82(new p82()).a(context, url)) {
                receiver.a(7, null);
                zA = true;
            } else if (URLUtil.isNetworkUrl(url)) {
                zA = this.f10254a.a(context, adResponse, receiver, adConfiguration, url);
            }
        } else if (new q82(new p82()).a(context, url)) {
            receiver.a(7, null);
            zA = true;
        } else if (URLUtil.isNetworkUrl(url)) {
            zA = this.f10254a.a(context, adResponse, receiver, adConfiguration, url);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("click_type", "default");
        linkedHashMap.put("click_handled", Boolean.valueOf(zA));
        hp1.b bVar = hp1.b.c;
        reporter.a(linkedHashMap);
        if (receiver != null) {
            receiver.a(9, null);
        }
    }

    public /* synthetic */ t1(uu1 uu1Var) {
        this(uu1Var, new em(uu1Var));
    }

    public t1(uu1 sdkEnvironmentModule, em browserAdActivityLauncher) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(browserAdActivityLauncher, "browserAdActivityLauncher");
        this.f10254a = browserAdActivityLauncher;
    }
}
