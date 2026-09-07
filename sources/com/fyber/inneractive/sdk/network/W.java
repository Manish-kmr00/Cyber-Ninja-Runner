package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class W extends V {
    public W(com.fyber.inneractive.sdk.ui.b bVar, Context context, com.fyber.inneractive.sdk.cache.b bVar2) {
        super(bVar, context, bVar2);
    }

    @Override // com.fyber.inneractive.sdk.network.V, com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N {
        O o = new O();
        try {
            InputStream inputStream = c3136l.c;
            int iA = U.a(map);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new com.fyber.inneractive.sdk.util.W(inputStream, atomicInteger));
            if (atomicInteger.get() != iA) {
                bitmapDecodeStream = null;
            }
            if (bitmapDecodeStream != null) {
                String strA = com.fyber.inneractive.sdk.util.X.a(bitmapDecodeStream);
                o.f1911a = bitmapDecodeStream;
                o.b = strA;
            }
            return o;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            throw new N(e);
        }
    }
}
