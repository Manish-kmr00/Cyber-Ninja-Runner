package com.safedk.android.internal;

import android.support.annotation.NonNull;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class g extends OutputStream implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8141a = "SafeDKOutputStream";
    private String b;
    private OutputStream c;
    private String d;
    private ByteArrayOutputStream e = new ByteArrayOutputStream();
    private c f = this;

    public g(String str, String str2, OutputStream outputStream) {
        this.b = str;
        this.d = str2;
        this.c = outputStream;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.c.write(i);
        if (i >= 0) {
            try {
                this.e.write(i);
            } catch (Throwable th) {
                try {
                    Logger.e(f8141a, th.getMessage());
                } catch (Throwable th2) {
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] b) throws IOException {
        this.c.write(b);
        a(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] b, int off, int len) throws IOException {
        this.c.write(b, off, len);
        a(b, off, len);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        String string = this.e.toString();
        Logger.d(f8141a, "closing output stream");
        this.f.a(this.b, this.d, string);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    private void a(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            try {
                this.e.write(bArr, i, i2);
            } catch (Throwable th) {
                try {
                    Logger.e(f8141a, th.getMessage());
                } catch (Throwable th2) {
                }
            }
        }
    }

    public void a(c cVar) {
        this.f = cVar;
    }

    @Override // com.safedk.android.internal.c
    public void a(String str, String str2, String str3) {
        Logger.d(f8141a, "onStreamClose " + this + " sdkPackageName: " + str);
        CreativeInfoManager.c(str, str2, str3);
    }
}
