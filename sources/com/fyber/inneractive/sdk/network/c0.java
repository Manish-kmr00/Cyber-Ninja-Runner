package com.fyber.inneractive.sdk.network;

import android.util.Base64;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.C3242f;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class c0 extends U {
    public final String p;

    public c0(E e, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(e, G.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public O a(C3136l c3136l, Map map, int i) {
        O o = new O();
        try {
            InputStream inputStream = c3136l.c;
            List list = map != null ? (List) map.get("Content-Type") : null;
            String str = list != null ? (String) list.get(0) : null;
            ByteBuffer byteBufferAllocateDirect = (ByteBuffer) C3242f.b.f2362a.poll();
            if (byteBufferAllocateDirect == null) {
                byteBufferAllocateDirect = ByteBuffer.allocateDirect(16384);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArrArray = (byteBufferAllocateDirect == null || !byteBufferAllocateDirect.hasArray()) ? new byte[8192] : byteBufferAllocateDirect.array();
            while (true) {
                int i2 = inputStream.read(bArrArray, 0, bArrArray.length);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArrArray, 0, i2);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AbstractC3256u.b(byteArrayOutputStream);
            C3242f.b.f2362a.offer(byteBufferAllocateDirect);
            String strEncodeToString = Base64.encodeToString(byteArray, 0);
            if (str == null) {
                str = "image/png";
            }
            o.f1911a = "data:" + str + ";base64, " + strEncodeToString;
        } catch (Exception unused) {
            IAlog.a("failed to fetch and encode the image.", new Object[0]);
        }
        return o;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return false;
    }
}
