package com.pgl.ssdk;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes11.dex */
public abstract class p {
    public static o a(RandomAccessFile randomAccessFile, long j, long j2) {
        return a(randomAccessFile.getChannel(), j, j2);
    }

    public static o a(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new l(fileChannel, j, j2);
    }
}
