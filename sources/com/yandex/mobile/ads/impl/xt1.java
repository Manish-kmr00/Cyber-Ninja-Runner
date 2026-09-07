package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f10677a;
    private final dx1 b;
    private final w22 c;

    public final String a(Context context, jc advertisingConfiguration, l50 environmentConfiguration, cl clVar, au1 au1Var) {
        String hostAddress;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        g5 g5Var = this.f10677a;
        f5 adLoadingPhaseType = f5.A;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        g5Var.a(adLoadingPhaseType, null);
        sq configuration = new sq(advertisingConfiguration, environmentConfiguration);
        lx1.f9575a.getClass();
        String strA = ((mx1) lx1.a.a(context)).a();
        String strA2 = zc.a().a();
        hx1.f9146a.getClass();
        String strA3 = hx1.a.a(context).a();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Intrinsics.checkNotNullExpressionValue(networkInterfaces, "getNetworkInterfaces(...)");
            Iterator it = CollectionsKt.iterator(networkInterfaces);
            while (true) {
                if (it.hasNext()) {
                    Enumeration<InetAddress> inetAddresses = ((NetworkInterface) it.next()).getInetAddresses();
                    Intrinsics.checkNotNullExpressionValue(inetAddresses, "getInetAddresses(...)");
                    Iterator it2 = CollectionsKt.iterator(inetAddresses);
                    while (true) {
                        if (it2.hasNext()) {
                            InetAddress inetAddress = (InetAddress) it2.next();
                            if (inetAddress instanceof Inet6Address) {
                                Inet6Address inet6Address = (Inet6Address) inetAddress;
                                Intrinsics.checkNotNullParameter(inet6Address, "<this>");
                                byte[] address = inet6Address.getAddress();
                                if (address != null && ((i = address[0] & 240) == 32 || i == 48)) {
                                    hostAddress = ((Inet6Address) inetAddress).getHostAddress();
                                }
                            }
                        }
                        hostAddress = null;
                    }
                } else {
                    hostAddress = null;
                }
                dx1 sensitiveModeChecker = this.b;
                nq1 resourceUtils = new nq1();
                cf1 optOutRepository = new cf1(context, ns0.a(context));
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(resourceUtils, "resourceUtils");
                Intrinsics.checkNotNullParameter(optOutRepository, "optOutRepository");
                String strA4 = this.c.a(context, new cb0(cb0.b.a(context, sensitiveModeChecker, configuration, resourceUtils, optOutRepository).a(clVar != null ? clVar.a() : null).a(context, clVar != null ? clVar.c() : null).h(strA).i(strA2).g(strA3).d(hostAddress).a(au1Var).a(clVar != null ? clVar.b() : null), 0).toString());
                g5Var.a(adLoadingPhaseType);
                return strA4;
            }
        } catch (Throwable unused) {
        }
    }

    public /* synthetic */ xt1(g5 g5Var) {
        this(g5Var, new dx1(), new w22());
    }

    public xt1(g5 adLoadingPhasesManager, dx1 sensitiveModeChecker, w22 stringEncryptor) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(stringEncryptor, "stringEncryptor");
        this.f10677a = adLoadingPhasesManager;
        this.b = sensitiveModeChecker;
        this.c = stringEncryptor;
    }
}
