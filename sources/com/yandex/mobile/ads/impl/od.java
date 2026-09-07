package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class od extends nh1 {
    private static final boolean e;
    private final ArrayList d;

    static {
        e = Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final Cdo a(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        qd qdVarA = qd.a.a(trustManager);
        if (qdVarA != null) {
            return qdVarA;
        }
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new vk(b(trustManager));
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final String b(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((e12) next).a(sslSocket));
        e12 e12Var = (e12) next;
        if (e12Var != null) {
            return e12Var.b(sslSocket);
        }
        return null;
    }

    public od() {
        pd pdVarA = pd.a.a();
        int i = xd.g;
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new e12[]{pdVarA, new u00(xd.a.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((e12) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final void a(SSLSocket sslSocket, String str, List<? extends im1> protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((e12) next).a(sslSocket));
        e12 e12Var = (e12) next;
        if (e12Var != null) {
            e12Var.a(sslSocket, str, protocols);
        }
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final boolean a(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
