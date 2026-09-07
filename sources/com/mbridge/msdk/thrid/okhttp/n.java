package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: EventListener.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n {
    public static final n NONE = new a();

    /* JADX INFO: compiled from: EventListener.java */
    static class a extends n {
        a() {
        }
    }

    /* JADX INFO: compiled from: EventListener.java */
    static class b implements c {
        b() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.n.c
        public n a(d dVar) {
            return n.this;
        }
    }

    /* JADX INFO: compiled from: EventListener.java */
    public interface c {
        n a(d dVar);
    }

    static c factory(n nVar) {
        return nVar.new b();
    }

    public void callEnd(d dVar) {
    }

    public void callFailed(d dVar, IOException iOException) {
    }

    public void callStart(d dVar) {
    }

    public void connectEnd(d dVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable u uVar) {
    }

    public void connectFailed(d dVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable u uVar, IOException iOException) {
    }

    public void connectStart(d dVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(d dVar, g gVar) {
    }

    public void connectionReleased(d dVar, g gVar) {
    }

    public void dnsEnd(d dVar, String str, List<InetAddress> list) {
    }

    public void dnsStart(d dVar, String str) {
    }

    public void requestBodyEnd(d dVar, long j) {
    }

    public void requestBodyStart(d dVar) {
    }

    public void requestHeadersEnd(d dVar, w wVar) {
    }

    public void requestHeadersStart(d dVar) {
    }

    public void responseBodyEnd(d dVar, long j) {
    }

    public void responseBodyStart(d dVar) {
    }

    public void responseHeadersEnd(d dVar, y yVar) {
    }

    public void responseHeadersStart(d dVar) {
    }

    public void secureConnectEnd(d dVar, @Nullable o oVar) {
    }

    public void secureConnectStart(d dVar) {
    }
}
