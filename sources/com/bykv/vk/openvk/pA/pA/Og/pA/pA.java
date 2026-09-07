package com.bykv.vk.openvk.pA.pA.Og.pA;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.Og.pA.pA.Og;
import com.bykv.vk.openvk.pA.pA.pA.KZx.KZx;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class pA extends MediaDataSource {
    public static final ConcurrentHashMap<String, pA> pA = new ConcurrentHashMap<>();
    private long KZx = -2147483648L;
    private final KZx ML;
    private final com.bykv.vk.openvk.pA.pA.Og.pA.pA.KZx Og;
    private final Context ZZv;

    public pA(Context context, KZx kZx) {
        this.ZZv = context;
        this.ML = kZx;
        this.Og = new Og(context, kZx);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int iPA = this.Og.pA(j, bArr, i, i2);
        new StringBuilder("readAt: position = ").append(j).append("  buffer.length =").append(bArr.length).append("  offset = ").append(i).append(" size =").append(iPA).append("  current = ").append(Thread.currentThread());
        return iPA;
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.KZx == -2147483648L) {
            if (this.ZZv == null || TextUtils.isEmpty(this.ML.Wx())) {
                return -1L;
            }
            this.KZx = this.Og.KZx();
        }
        return this.KZx;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        new Object[]{"close: ", this.ML.Wx()};
        com.bykv.vk.openvk.pA.pA.Og.pA.pA.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.Og();
        }
        pA.remove(this.ML.Sn());
    }

    public KZx pA() {
        return this.ML;
    }

    public static pA pA(Context context, KZx kZx) {
        pA pAVar = new pA(context, kZx);
        pA.put(kZx.Sn(), pAVar);
        return pAVar;
    }
}
