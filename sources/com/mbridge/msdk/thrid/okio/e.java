package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: BufferedSource.java */
/* JADX INFO: loaded from: classes11.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b) throws IOException;

    c a();

    f b(long j) throws IOException;

    String c() throws IOException;

    byte[] c(long j) throws IOException;

    String d(long j) throws IOException;

    int e() throws IOException;

    void e(long j) throws IOException;

    boolean f() throws IOException;

    short g() throws IOException;

    long i() throws IOException;

    InputStream j();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}
