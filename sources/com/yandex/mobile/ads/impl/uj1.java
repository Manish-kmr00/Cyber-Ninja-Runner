package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class uj1 extends SSLSocketFactory {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f10392a;

    public uj1(SSLSocketFactory delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f10392a = delegate;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String arg0, int i) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Socket socketCreateSocket = this.f10392a.createSocket(arg0, i);
        String[] strArrA = a.a(this.f10392a);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket) socketCreateSocket).setEnabledCipherSuites(strArrA);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return a.a(this.f10392a);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return a.b(this.f10392a);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String arg0, int i, InetAddress arg2, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Intrinsics.checkNotNullParameter(arg2, "arg2");
        Socket socketCreateSocket = this.f10392a.createSocket(arg0, i, arg2, i2);
        String[] strArrA = a.a(this.f10392a);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket) socketCreateSocket).setEnabledCipherSuites(strArrA);
        return socketCreateSocket;
    }

    public static final class a {
        public static final String[] a(SSLSocketFactory sSLSocketFactory) {
            int i = uj1.b;
            String[] defaultCipherSuites = sSLSocketFactory.getDefaultCipherSuites();
            ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(defaultCipherSuites, defaultCipherSuites.length)));
            arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
            arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
            return (String[]) arrayList.toArray(new String[0]);
        }

        public static final String[] b(SSLSocketFactory sSLSocketFactory) {
            int i = uj1.b;
            String[] supportedCipherSuites = sSLSocketFactory.getSupportedCipherSuites();
            ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(supportedCipherSuites, supportedCipherSuites.length)));
            arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
            arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
            return (String[]) arrayList.toArray(new String[0]);
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress arg0, int i) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Socket socketCreateSocket = this.f10392a.createSocket(arg0, i);
        String[] strArrA = a.a(this.f10392a);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket) socketCreateSocket).setEnabledCipherSuites(strArrA);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress arg0, int i, InetAddress arg2, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Intrinsics.checkNotNullParameter(arg2, "arg2");
        Socket socketCreateSocket = this.f10392a.createSocket(arg0, i, arg2, i2);
        String[] strArrA = a.a(this.f10392a);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket) socketCreateSocket).setEnabledCipherSuites(strArrA);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket arg0, String arg1, int i, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Intrinsics.checkNotNullParameter(arg1, "arg1");
        Socket socketCreateSocket = this.f10392a.createSocket(arg0, arg1, i, z);
        String[] strArrA = a.a(this.f10392a);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket) socketCreateSocket).setEnabledCipherSuites(strArrA);
        return socketCreateSocket;
    }
}
