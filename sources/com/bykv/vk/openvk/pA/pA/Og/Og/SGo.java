package com.bykv.vk.openvk.pA.pA.Og.Og;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
class SGo extends ProxySelector {
    private static final List<Proxy> pA = Collections.singletonList(Proxy.NO_PROXY);
    private final String KZx;
    private final ProxySelector Og = ProxySelector.getDefault();
    private final int ZZv;

    private SGo(String str, int i) {
        this.KZx = str;
        this.ZZv = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.KZx.equalsIgnoreCase(uri.getHost()) && this.ZZv == uri.getPort()) ? pA : this.Og.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.Og.connectFailed(uri, socketAddress, iOException);
    }

    static void pA(String str, int i) {
        ProxySelector.setDefault(new SGo(str, i));
    }
}
