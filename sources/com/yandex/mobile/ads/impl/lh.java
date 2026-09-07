package com.yandex.mobile.ads.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class lh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f9515a;
    private final File b;

    public final FileInputStream c() throws FileNotFoundException {
        if (this.b.exists()) {
            this.f9515a.delete();
            this.b.renameTo(this.f9515a);
        }
        return new FileInputStream(this.f9515a);
    }

    public lh(File file) {
        this.f9515a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public final boolean b() {
        return this.f9515a.exists() || this.b.exists();
    }

    public final void a() {
        this.f9515a.delete();
        this.b.delete();
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.close();
        this.b.delete();
    }

    public final OutputStream d() throws IOException {
        if (this.f9515a.exists()) {
            if (!this.b.exists()) {
                if (!this.f9515a.renameTo(this.b)) {
                    at0.d("AtomicFile", "Couldn't rename file " + this.f9515a + " to backup file " + this.b);
                }
            } else {
                this.f9515a.delete();
            }
        }
        try {
            return new a(this.f9515a);
        } catch (FileNotFoundException e) {
            File parentFile = this.f9515a.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new a(this.f9515a);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Couldn't create " + this.f9515a, e2);
                }
            }
            throw new IOException("Couldn't create " + this.f9515a, e);
        }
    }

    private static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileOutputStream f9516a;
        private boolean b = false;

        public a(File file) throws FileNotFoundException {
            this.f9516a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f9516a.flush();
            try {
                this.f9516a.getFD().sync();
            } catch (IOException e) {
                at0.b("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.f9516a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() throws IOException {
            this.f9516a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            this.f9516a.write(i);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            this.f9516a.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            this.f9516a.write(bArr, i, i2);
        }
    }
}
