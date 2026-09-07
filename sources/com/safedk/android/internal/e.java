package com.safedk.android.internal;

import android.support.annotation.NonNull;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class e extends FileOutputStream implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8139a = "SafeDKFileOutputStream";
    private g b;

    public e(String str, String str2, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(str2);
        this.b = new g(str, str2, fileOutputStream);
        this.b.a(this);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.b.write(i);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(@NonNull byte[] b) throws IOException {
        this.b.write(b);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(@NonNull byte[] b, int off, int len) throws IOException {
        this.b.write(b, off, len);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // com.safedk.android.internal.c
    public void a(String str, String str2, String str3) {
        Logger.d(f8139a, "onStreamClose " + this + " sdkPackageName: " + str + ", url: " + str2);
        CreativeInfoManager.b(str, str2, str3);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }
}
