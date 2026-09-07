package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import io.ktor.http.auth.AuthScheme;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class jq0 implements bi {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9344a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f9344a = iArr;
        }
    }

    public jq0(n30 defaultDns) {
        Intrinsics.checkNotNullParameter(defaultDns, "defaultDns");
    }

    @Override // com.yandex.mobile.ads.impl.bi
    public final op1 a(os1 os1Var, oq1 response) throws IOException {
        Proxy proxyB;
        n30 n30VarC;
        InetAddress address;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        InetAddress address2;
        ab abVarA;
        Intrinsics.checkNotNullParameter(response, "response");
        List<fo> listC = response.c();
        op1 op1VarO = response.o();
        di0 di0VarG = op1VarO.g();
        boolean z = response.d() == 407;
        if (os1Var == null || (proxyB = os1Var.b()) == null) {
            proxyB = Proxy.NO_PROXY;
        }
        for (fo foVar : listC) {
            if (StringsKt.equals(AuthScheme.Basic, foVar.c(), true)) {
                if (os1Var == null || (abVarA = os1Var.a()) == null || (n30VarC = abVarA.c()) == null) {
                    n30VarC = n30.f9694a;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxyB.address();
                    Intrinsics.checkNotNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    Intrinsics.checkNotNull(proxyB);
                    Proxy.Type type = proxyB.type();
                    if (type != null && a.f9344a[type.ordinal()] == 1) {
                        address2 = (InetAddress) CollectionsKt.first((List) n30VarC.a(di0VarG.g()));
                    } else {
                        SocketAddress socketAddressAddress2 = proxyB.address();
                        Intrinsics.checkNotNull(socketAddressAddress2, "null cannot be cast to non-null type java.net.InetSocketAddress");
                        address2 = ((InetSocketAddress) socketAddressAddress2).getAddress();
                        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                    }
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, address2, inetSocketAddress.getPort(), di0VarG.k(), foVar.b(), foVar.c(), di0VarG.m(), Authenticator.RequestorType.PROXY);
                } else {
                    String strG = di0VarG.g();
                    Intrinsics.checkNotNull(proxyB);
                    Proxy.Type type2 = proxyB.type();
                    if (type2 != null && a.f9344a[type2.ordinal()] == 1) {
                        address = (InetAddress) CollectionsKt.first((List) n30VarC.a(di0VarG.g()));
                    } else {
                        SocketAddress socketAddressAddress3 = proxyB.address();
                        Intrinsics.checkNotNull(socketAddressAddress3, "null cannot be cast to non-null type java.net.InetSocketAddress");
                        address = ((InetSocketAddress) socketAddressAddress3).getAddress();
                        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    }
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strG, address, di0VarG.i(), di0VarG.k(), foVar.b(), foVar.c(), di0VarG.m(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? HttpHeaders.PROXY_AUTHORIZATION : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "getUserName(...)");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "getPassword(...)");
                    return new op1.a(op1VarO).b(str, bv.a(userName, new String(password), foVar.a())).a();
                }
            }
        }
        return null;
    }
}
