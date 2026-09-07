package com.yandex.mobile.ads.impl;

import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g42 implements zs {
    @Override // com.yandex.mobile.ads.impl.zs
    public final boolean a(String host) {
        Socket socket;
        Intrinsics.checkNotNullParameter(host, "host");
        try {
            socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(host, 80), 5000);
                boolean zIsConnected = socket.isConnected();
                try {
                    socket.close();
                } catch (Throwable unused) {
                    op0.c(new Object[0]);
                }
                return zIsConnected;
            } catch (Throwable unused2) {
                try {
                    op0.c(new Object[0]);
                    if (socket != null) {
                        try {
                        } catch (Throwable unused3) {
                            op0.c(new Object[0]);
                        }
                    }
                    return false;
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable unused4) {
                            op0.c(new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable unused5) {
            socket = null;
        }
    }
}
