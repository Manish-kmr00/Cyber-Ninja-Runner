package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import java.io.IOException;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class lm implements jv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9537a;

    public lm(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9537a = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.jv
    public byte[][] a() {
        try {
            InputStream inputStreamOpenRawResource = this.f9537a.getResources().openRawResource(R.raw.monetization_ads_bundled_cert);
            try {
                Intrinsics.checkNotNull(inputStreamOpenRawResource);
                byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpenRawResource);
                CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                return new byte[][]{bytes};
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
