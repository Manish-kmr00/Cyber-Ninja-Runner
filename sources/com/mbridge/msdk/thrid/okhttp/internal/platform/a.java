package com.mbridge.msdk.thrid.okhttp.internal.platform;

import android.net.ssl.SSLSockets;
import com.mbridge.msdk.thrid.okhttp.u;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: Android10Platform.java */
/* JADX INFO: loaded from: classes13.dex */
class a extends b {
    a(Class<?> cls) {
        super(cls, null, null, null, null);
    }

    private void c(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Nullable
    public static g h() {
        if (!g.f()) {
            return null;
        }
        try {
            if (b.i() >= 29) {
                return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.b, com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(SSLSocket sSLSocket, String str, List<u> list) throws IOException {
        try {
            c(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) g.a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.b, com.mbridge.msdk.thrid.okhttp.internal.platform.g
    @Nullable
    public String b(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }
}
