package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class td extends nh1 {
    private static final boolean f;
    public static final /* synthetic */ int g = 0;
    private final ArrayList d;
    private final vp e;

    public static final class a implements d72 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f10288a;
        private final Method b;

        public a(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f10288a = trustManager;
            this.b = findByIssuerAndSignatureMethod;
        }

        @Override // com.yandex.mobile.ads.impl.d72
        public final X509Certificate a(X509Certificate cert) {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object objInvoke = this.b.invoke(this.f10288a, cert);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f10288a, aVar.f10288a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10288a.hashCode() * 31);
        }

        public final String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f10288a + ", findByIssuerAndSignatureMethod=" + this.b + ")";
        }
    }

    static {
        f = nh1.a.b() && Build.VERSION.SDK_INT < 30;
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
    public final d72 b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method declaredMethod = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            Intrinsics.checkNotNull(declaredMethod);
            return new a(trustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(trustManager);
        }
    }

    public td() {
        int i = f22.h;
        f22 f22VarA = f22.a.a("com.android.org.conscrypt");
        int i2 = xd.g;
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new e12[]{f22VarA, new u00(xd.a.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((e12) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
        this.e = vp.a.a();
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

    @Override // com.yandex.mobile.ads.impl.nh1
    public final Object b() {
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        return this.e.a();
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final void a(SSLSocket sslSocket, String str, List<im1> protocols) {
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
    public final void a(Socket socket, InetSocketAddress address, int i) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        try {
            socket.connect(address, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final boolean a(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // com.yandex.mobile.ads.impl.nh1
    public final void a(Object obj, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.e.a(obj)) {
            return;
        }
        nh1.a(5, message, (Throwable) null);
    }
}
