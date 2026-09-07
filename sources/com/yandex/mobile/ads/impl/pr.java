package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class pr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<or> f9945a;
    private int b;
    private boolean c;
    private boolean d;

    public pr(List<or> connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.f9945a = connectionSpecs;
    }

    public final or a(SSLSocket sslSocket) throws IOException {
        boolean z;
        or orVar;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = this.b;
        int size = this.f9945a.size();
        while (true) {
            z = true;
            if (i >= size) {
                orVar = null;
                break;
            }
            orVar = this.f9945a.get(i);
            if (orVar.a(sslSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (orVar == null) {
            boolean z2 = this.d;
            List<or> list = this.f9945a;
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNull(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + z2 + ", modes=" + list + ", supported protocols=" + string);
        }
        int size2 = this.f9945a.size();
        for (int i2 = this.b; i2 < size2; i2++) {
            if (this.f9945a.get(i2).a(sslSocket)) {
                this.c = z;
                orVar.a(sslSocket, this.d);
                return orVar;
            }
        }
        z = false;
        this.c = z;
        orVar.a(sslSocket, this.d);
        return orVar;
    }

    public final boolean a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.d = true;
        return (!this.c || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true;
    }
}
