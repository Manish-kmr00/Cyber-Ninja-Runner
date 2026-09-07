package com.inmobi.media;

import com.safedk.android.internal.partials.InMobiNetworkBridge;
import java.io.BufferedOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3461m {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0 f3371a;

    public C3461m(X0 mResultListener) {
        Intrinsics.checkNotNullParameter(mResultListener, "mResultListener");
        this.f3371a = mResultListener;
    }

    public static void a(File file, HttpURLConnection httpURLConnection, BufferedOutputStream bufferedOutputStream) {
        try {
            if (file.exists()) {
                file.delete();
                Intrinsics.checkNotNullExpressionValue("m", "TAG");
            }
            InMobiNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            W8.a(bufferedOutputStream);
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
