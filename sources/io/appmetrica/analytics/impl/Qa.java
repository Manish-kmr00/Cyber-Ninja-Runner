package io.appmetrica.analytics.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class Qa {
    public static String a(File file) {
        byte[] bArrArray;
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        if (file == null || !file.exists()) {
            bArrArray = null;
        } else {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    fileLockLock = channel.lock(0L, Long.MAX_VALUE, true);
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) file.length());
                        channel.read(byteBufferAllocate);
                        byteBufferAllocate.flip();
                        bArrArray = byteBufferAllocate.array();
                        file.getAbsolutePath();
                        a(fileLockLock);
                        In.a((Closeable) randomAccessFile);
                    } catch (IOException | SecurityException unused) {
                        file.getAbsolutePath();
                        a(fileLockLock);
                        In.a((Closeable) randomAccessFile);
                        bArrArray = null;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Fj fj = AbstractC4097ej.f11536a;
                            fj.getClass();
                            fj.a(new C4122fj("error_during_file_reading", th));
                            file.getAbsolutePath();
                            a(fileLockLock);
                            In.a((Closeable) randomAccessFile);
                            bArrArray = null;
                        } catch (Throwable th3) {
                            file.getAbsolutePath();
                            a(fileLockLock);
                            In.a((Closeable) randomAccessFile);
                            throw th3;
                        }
                    }
                } catch (IOException | SecurityException unused2) {
                    fileLockLock = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileLockLock = null;
                }
            } catch (IOException | SecurityException unused3) {
                randomAccessFile = null;
                fileLockLock = null;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                fileLockLock = null;
            }
        }
        if (bArrArray == null) {
            return null;
        }
        try {
            return new String(bArrArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str = new String(bArrArray);
            Fj fj2 = AbstractC4097ej.f11536a;
            fj2.getClass();
            fj2.a(new C4122fj("read_share_file_with_unsupported_encoding", e));
            return str;
        }
    }

    public static void a(FileLock fileLock) {
        if (fileLock == null || !fileLock.isValid()) {
            return;
        }
        try {
            fileLock.release();
        } catch (IOException unused) {
        }
    }

    public static void a(String str, FileOutputStream fileOutputStream) {
        FileLock fileLockLock = null;
        try {
            FileChannel channel = fileOutputStream.getChannel();
            fileLockLock = channel.lock();
            byte[] bytes = str.getBytes("UTF-8");
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length);
            byteBufferAllocate.put(bytes);
            byteBufferAllocate.flip();
            channel.write(byteBufferAllocate);
            channel.force(true);
        } catch (IOException unused) {
        } finally {
            a(fileLockLock);
            In.a((Closeable) fileOutputStream);
        }
    }
}
