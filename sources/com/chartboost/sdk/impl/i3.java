package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\nJ%\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\rJ\u001d\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/chartboost/sdk/impl/i3;", "", "Ljava/io/InputStream;", "input", "", "a", "(Ljava/io/InputStream;)[B", "Ljava/io/OutputStream;", "output", "", "(Ljava/io/InputStream;Ljava/io/OutputStream;)I", "bufferSize", "", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/io/InputStream;Ljava/io/OutputStream;)J", "buffer", "(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J", "[B", "EMPTY_BYTE_ARRAY", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f1040a = new i3();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public final int a(InputStream input, OutputStream output) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        long jB = b(input, output);
        if (jB > 2147483647L) {
            return -1;
        }
        return (int) jB;
    }

    public final long b(InputStream input, OutputStream output) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        return a(input, output, 8192);
    }

    public final long a(InputStream input, OutputStream output, int bufferSize) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        return a(input, output, new byte[bufferSize]);
    }

    public final long a(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        long j = 0;
        while (true) {
            int i = input.read(buffer);
            if (i == -1) {
                return j;
            }
            output.write(buffer, 0, i);
            j += (long) i;
        }
    }

    public final byte[] a(InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f1040a.a(input, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "output.toByteArray()");
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }
}
