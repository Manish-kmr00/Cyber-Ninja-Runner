package com.pgl.ssdk.ces;

import android.content.Context;
import android.text.TextUtils;
import com.pgl.ssdk.k0;
import com.pgl.ssdk.l0;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7508a;
    private String b;
    private Map<String, Object> c;

    public c(Context context, String str, Map<String, Object> map) {
        this.f7508a = context;
        this.b = str;
        this.c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            byte[] bArr = (byte[]) a.meta(Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, this.f7508a, new Object[]{this.b, this.c});
            if (bArr == null || bArr.length <= 0 || TextUtils.isEmpty(l0.a())) {
                return;
            }
            new k0(this.f7508a, null).a(1, 2, bArr);
        } catch (Throwable unused) {
        }
    }
}
