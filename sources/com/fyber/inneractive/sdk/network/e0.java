package com.fyber.inneractive.sdk.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public final class e0 extends U {
    public final String p;

    public e0(com.fyber.inneractive.sdk.flow.endcard.u uVar, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(uVar, G.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) {
        O o = new O();
        d0 d0Var = new d0();
        try {
            InputStream inputStream = c3136l.c;
            if (inputStream != null) {
                int iA = U.a(map);
                AtomicInteger atomicInteger = new AtomicInteger(0);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new com.fyber.inneractive.sdk.util.W(inputStream, atomicInteger));
                if (atomicInteger.get() != iA) {
                    bitmapDecodeStream = null;
                }
                if (bitmapDecodeStream != null) {
                    int width = bitmapDecodeStream.getWidth();
                    int height = bitmapDecodeStream.getHeight();
                    int i2 = width * height;
                    int[] iArr = new int[i2];
                    bitmapDecodeStream.getPixels(iArr, 0, width, 0, 0, width, height);
                    int i3 = -1;
                    for (int i4 = 0; i4 < i2; i4++) {
                        int i5 = iArr[i4];
                        if (i4 == 0) {
                            i3 = i5;
                        } else if (i5 != i3) {
                            d0Var.f1919a = bitmapDecodeStream;
                            IAlog.a("SimpleImageLoader: Got a valid bitmap %s", this.p);
                        }
                    }
                    IAlog.a("SimpleImageLoader: Got an invalid bitmap", new Object[0]);
                    d0Var.b = "Got an invalid bitmap";
                } else {
                    IAlog.a("SimpleImageLoader: Got an invalid bitmap", new Object[0]);
                    d0Var.b = "Got an invalid bitmap";
                }
            }
        } catch (Exception e) {
            IAlog.c("SimpleImageLoader: Exception on load image %s %s", e.getMessage(), e.toString());
            d0Var.b = e.getMessage();
        } catch (OutOfMemoryError e2) {
            IAlog.c("SimpleImageLoader: OutOfMemoryError on load image %s", e2.getMessage());
            Bitmap bitmap = d0Var.f1919a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            d0Var.b = e2.getMessage();
        }
        o.f1911a = d0Var;
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
