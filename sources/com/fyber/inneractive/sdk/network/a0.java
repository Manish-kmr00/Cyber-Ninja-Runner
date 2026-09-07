package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.ignite.IgniteResponseOuterClass$IgniteResponse;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.C3242f;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 extends U {
    public final byte[] p;
    public final AtomicInteger q;

    public a0(com.fyber.inneractive.sdk.ignite.b bVar, byte[] bArr, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(bVar, G.c.a(), rVar);
        this.q = new AtomicInteger();
        this.p = bArr;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N {
        try {
            O o = new O();
            InputStream inputStream = c3136l.c;
            if (inputStream != null) {
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
                String str = new String(byteArray, "UTF-8");
                IgniteResponseOuterClass$IgniteResponse from = IgniteResponseOuterClass$IgniteResponse.parseFrom(str.getBytes());
                o.b = str;
                o.f1911a = from;
            }
            return o;
        } catch (Exception e) {
            IAlog.a("failed parse ignite network request", e, new Object[0]);
            throw new N(e);
        } catch (Throwable th) {
            IAlog.a("failed parse ignite network request", th, new Object[0]);
            throw new N("failed to parse ignite network request");
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final byte[] d() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return ((int) Math.pow(2.0d, this.q.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String l() {
        return "application/x-protobuf; messageType=IgniteRequest";
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return "https://init-mp.fyber.com/init";
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return this.q.getAndIncrement() < 4;
    }
}
