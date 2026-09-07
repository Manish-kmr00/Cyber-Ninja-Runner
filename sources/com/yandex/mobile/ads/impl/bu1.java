package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bu1 extends lm {
    private final Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu1(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.lm, com.yandex.mobile.ads.impl.jv
    public final byte[][] a() {
        try {
            InputStream inputStreamOpenRawResource = this.b.getResources().openRawResource(R.raw.monetization_ads_sdkinternalca);
            try {
                Intrinsics.checkNotNull(inputStreamOpenRawResource);
                byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpenRawResource);
                CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                return (byte[][]) ArraysKt.plus((Object[]) super.a(), (Object[]) new byte[][]{bytes});
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to create cert", e);
        }
    }
}
