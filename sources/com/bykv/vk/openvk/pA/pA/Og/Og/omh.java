package com.bykv.vk.openvk.pA.pA.Og.Og;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
class omh {
    private final RandomAccessFile pA;

    omh(File file, String str) throws pA {
        try {
            this.pA = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new pA(e);
        }
    }

    void pA(long j) throws pA {
        try {
            this.pA.seek(j);
        } catch (IOException e) {
            throw new pA(e);
        }
    }

    void pA(byte[] bArr, int i, int i2) throws pA {
        try {
            this.pA.write(bArr, i, i2);
        } catch (IOException e) {
            throw new pA(e);
        }
    }

    int pA(byte[] bArr) throws pA {
        try {
            return this.pA.read(bArr);
        } catch (IOException e) {
            throw new pA(e);
        }
    }

    void pA() {
        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(this.pA);
    }

    static class pA extends Exception {
        pA(Throwable th) {
            super(th);
        }
    }
}
