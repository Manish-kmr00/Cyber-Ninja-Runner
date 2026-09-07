package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class rs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab f10136a;
    private final ps1 b;
    private final mn c;
    private final t50 d;
    private List<? extends Proxy> e;
    private int f;
    private List<? extends InetSocketAddress> g;
    private final ArrayList h;

    public static final class a {
        public static String a(InetSocketAddress inetSocketAddress) {
            Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                Intrinsics.checkNotNullExpressionValue(hostName, "getHostName(...)");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(hostAddress, "getHostAddress(...)");
            return hostAddress;
        }
    }

    public rs1(ab address, ps1 routeDatabase, sn1 call, t50 eventListener) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f10136a = address;
        this.b = routeDatabase;
        this.c = call;
        this.d = eventListener;
        this.e = CollectionsKt.emptyList();
        this.g = CollectionsKt.emptyList();
        this.h = new ArrayList();
        a(address.k(), address.f());
    }

    private final Proxy c() throws IOException {
        if (this.f >= this.e.size()) {
            throw new SocketException("No route to " + this.f10136a.k().g() + "; exhausted proxy configurations: " + this.e);
        }
        List<? extends Proxy> list = this.e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    public final boolean a() {
        return this.f < this.e.size() || !this.h.isEmpty();
    }

    public final b b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (this.f < this.e.size()) {
                Proxy proxyC = c();
                Iterator<? extends InetSocketAddress> it = this.g.iterator();
                while (it.hasNext()) {
                    os1 os1Var = new os1(this.f10136a, proxyC, it.next());
                    if (this.b.c(os1Var)) {
                        this.h.add(os1Var);
                    } else {
                        arrayList.add(os1Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                CollectionsKt.addAll(arrayList, this.h);
                this.h.clear();
            }
            return new b(arrayList);
        }
        throw new NoSuchElementException();
    }

    private final void a(Proxy proxy) throws IOException {
        String strG;
        int i;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                Intrinsics.checkNotNull(socketAddressAddress);
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strG = a.a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
        } else {
            strG = this.f10136a.k().g();
            i = this.f10136a.k().i();
        }
        if (1 <= i && i < 65536) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList.add(InetSocketAddress.createUnresolved(strG, i));
                return;
            }
            t50 t50Var = this.d;
            mn mnVar = this.c;
            t50Var.getClass();
            t50.a(mnVar, strG);
            List<InetAddress> listA = this.f10136a.c().a(strG);
            if (!listA.isEmpty()) {
                t50 t50Var2 = this.d;
                mn mnVar2 = this.c;
                t50Var2.getClass();
                t50.a(mnVar2, strG, listA);
                Iterator<InetAddress> it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new InetSocketAddress(it.next(), i));
                }
                return;
            }
            throw new UnknownHostException(this.f10136a.c() + " returned no addresses for " + strG);
        }
        throw new SocketException("No route to " + strG + ":" + i + "; port is out of range");
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<os1> f10137a;
        private int b;

        public b(ArrayList routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.f10137a = routes;
        }

        public final List<os1> a() {
            return this.f10137a;
        }

        public final boolean b() {
            return this.b < this.f10137a.size();
        }

        public final os1 c() {
            if (b()) {
                List<os1> list = this.f10137a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    private final void a(di0 url, Proxy proxy) {
        List<? extends Proxy> proxies;
        t50 t50Var = this.d;
        mn call = this.c;
        t50Var.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        if (proxy != null) {
            proxies = CollectionsKt.listOf(proxy);
        } else {
            URI uriL = url.l();
            if (uriL.getHost() == null) {
                proxies = y82.a(Proxy.NO_PROXY);
            } else {
                List<Proxy> listSelect = this.f10136a.h().select(uriL);
                if (listSelect != null && !listSelect.isEmpty()) {
                    Intrinsics.checkNotNull(listSelect);
                    proxies = y82.b(listSelect);
                } else {
                    proxies = y82.a(Proxy.NO_PROXY);
                }
            }
        }
        this.e = proxies;
        this.f = 0;
        t50 t50Var2 = this.d;
        mn call2 = this.c;
        t50Var2.getClass();
        Intrinsics.checkNotNullParameter(call2, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
    }
}
