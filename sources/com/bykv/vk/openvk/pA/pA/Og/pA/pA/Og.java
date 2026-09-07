package com.bykv.vk.openvk.pA.pA.Og.pA.pA;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.component.Og.pA.oX;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class Og implements KZx {
    private RandomAccessFile Bzk;
    private File KZx;
    private long ML;
    private final com.bykv.vk.openvk.pA.pA.pA.KZx.KZx SGo;
    private File ZZv;
    private volatile long pA = -2147483648L;
    private final Object Og = new Object();
    private volatile long JG = -1;
    private volatile boolean SD = false;
    private volatile boolean omh = false;

    public Og(Context context, com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        this.ML = 0L;
        this.Bzk = null;
        this.SGo = kZx;
        try {
            this.KZx = com.bykv.vk.openvk.pA.pA.Og.ML.Og.Og(kZx.Og(), kZx.Sn());
            this.ZZv = com.bykv.vk.openvk.pA.pA.Og.ML.Og.KZx(kZx.Og(), kZx.Sn());
            if (ZZv()) {
                this.Bzk = new RandomAccessFile(this.ZZv, "r");
            } else {
                this.Bzk = new RandomAccessFile(this.KZx, "rw");
            }
            if (ZZv()) {
                return;
            }
            this.ML = this.KZx.length();
            pA();
        } catch (Throwable unused) {
            new Object[]{"Error using file ", kZx.Wx(), " as disc cache"};
        }
    }

    private boolean ZZv() {
        return this.ZZv.exists();
    }

    public void pA() {
        BSW.pA pAVar;
        if (com.bykv.vk.openvk.pA.pA.pA.KZx.ZZv() != null) {
            pAVar = com.bykv.vk.openvk.pA.pA.pA.KZx.ZZv().Og();
        } else {
            pAVar = new BSW.pA("v_cache");
        }
        pAVar.pA(this.SGo.oX(), TimeUnit.MILLISECONDS).Og(this.SGo.aBv(), TimeUnit.MILLISECONDS).KZx(this.SGo.XT(), TimeUnit.MILLISECONDS);
        BSW bswPA = pAVar.pA();
        new Object[]{"RANGE, bytes=", Long.valueOf(this.ML), " file hash=", this.SGo.Sn()};
        bswPA.pA(new Wx.pA().pA("RANGE", "bytes=" + this.ML + "-").Og(this.SGo.Wx()).pA().pA("videoLoadWhenPlaying").pA(9).Og()).pA(new com.bytedance.sdk.component.Og.pA.KZx() { // from class: com.bykv.vk.openvk.pA.pA.Og.pA.pA.Og.1
            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, IOException iOException) {
                Og.this.omh = false;
                Og.this.pA = -1L;
            }

            /* JADX WARN: Code duplicated, block: B:85:0x01e9 A[Catch: all -> 0x0212, TryCatch #3 {all -> 0x0212, blocks: (B:83:0x01e4, B:85:0x01e9, B:87:0x01ee, B:88:0x01f1, B:90:0x01f9, B:92:0x020d), top: B:106:0x01e4 }] */
            /* JADX WARN: Code duplicated, block: B:87:0x01ee A[Catch: all -> 0x0212, TryCatch #3 {all -> 0x0212, blocks: (B:83:0x01e4, B:85:0x01e9, B:87:0x01ee, B:88:0x01f1, B:90:0x01f9, B:92:0x020d), top: B:106:0x01e4 }] */
            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, DX dx) throws IOException {
                oX oXVarJG;
                InputStream inputStream;
                long length;
                long j;
                boolean z;
                if (dx == null) {
                    Og.this.omh = false;
                    Og og2 = Og.this;
                    og2.pA = og2.JG;
                    return;
                }
                InputStream inputStreamKZx = null;
                try {
                    Og.this.omh = dx.ZZv();
                    if (Og.this.omh) {
                        oXVarJG = dx.JG();
                        try {
                            if (Og.this.omh && oXVarJG != null) {
                                Og.this.pA = oXVarJG.pA() + Og.this.ML;
                                inputStreamKZx = oXVarJG.KZx();
                            }
                            inputStream = inputStreamKZx;
                            if (inputStream == null) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                }
                                if (oXVarJG != null) {
                                    oXVarJG.close();
                                }
                                if (dx != null) {
                                    dx.close();
                                }
                                if (Og.this.omh && Og.this.KZx.length() == Og.this.pA) {
                                    Og.this.JG();
                                    return;
                                }
                                return;
                            }
                            try {
                                byte[] bArr = new byte[8192];
                                long j2 = Og.this.ML;
                                int i = 0;
                                long j3 = 0;
                                while (true) {
                                    int i2 = inputStream.read(bArr, i, 8192 - i);
                                    z = true;
                                    if (i2 == -1) {
                                        break;
                                    }
                                    i += i2;
                                    j3 += (long) i2;
                                    if (j3 % PlaybackStateCompat.ACTION_PLAY_FROM_URI != 0 && j3 != Og.this.pA - Og.this.ML) {
                                        z = false;
                                    }
                                    new Object[]{"Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i), " totalLength = ", Long.valueOf(Og.this.pA), " saveSize =", Long.valueOf(j3), " startSaved=", Long.valueOf(Og.this.ML), " fileHash=", Og.this.SGo.Sn(), " url=", Og.this.SGo.Wx()};
                                    if (z) {
                                        synchronized (Og.this.Og) {
                                            com.bykv.vk.openvk.pA.pA.Og.ML.Og.pA(Og.this.Bzk, bArr, Long.valueOf(j2).intValue(), i, Og.this.SGo.Sn());
                                        }
                                        j2 += (long) i;
                                        i = 0;
                                    }
                                }
                                Long lValueOf = Long.valueOf(Og.this.ML);
                                Long lValueOf2 = Long.valueOf(Og.this.pA);
                                Long lValueOf3 = Long.valueOf(j3);
                                if (j3 != Og.this.pA - Og.this.ML) {
                                    z = false;
                                }
                                new Object[]{"Write segment,Write over, startIndex =", lValueOf, " totalLength = ", lValueOf2, " saveSize = ", lValueOf3, " writeEndSegment =", Boolean.valueOf(z), " url=", Og.this.SGo.Wx()};
                                inputStreamKZx = inputStream;
                            } catch (Throwable unused2) {
                                try {
                                    Og.this.omh = false;
                                    Og og3 = Og.this;
                                    og3.pA = og3.JG;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused3) {
                                            return;
                                        }
                                    }
                                    if (oXVarJG != null) {
                                        oXVarJG.close();
                                    }
                                    if (dx != null) {
                                        dx.close();
                                    }
                                    if (Og.this.omh) {
                                        if (length == j) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    return;
                                } finally {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (oXVarJG != null) {
                                                oXVarJG.close();
                                            }
                                            if (dx != null) {
                                                dx.close();
                                            }
                                            if (Og.this.omh && Og.this.KZx.length() == Og.this.pA) {
                                                Og.this.JG();
                                            }
                                        } catch (Throwable unused4) {
                                        }
                                    } else {
                                        if (oXVarJG != null) {
                                            oXVarJG.close();
                                        }
                                        if (dx != null) {
                                            dx.close();
                                        }
                                        if (Og.this.omh) {
                                            Og.this.JG();
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused5) {
                            inputStream = null;
                        }
                    } else {
                        Og.this.omh = false;
                        Og og4 = Og.this;
                        og4.pA = og4.JG;
                        oXVarJG = null;
                    }
                    if (inputStreamKZx != null) {
                        try {
                            inputStreamKZx.close();
                        } catch (Throwable unused6) {
                            return;
                        }
                    }
                    if (oXVarJG != null) {
                        oXVarJG.close();
                    }
                    if (dx != null) {
                        dx.close();
                    }
                    if (Og.this.omh && Og.this.KZx.length() == Og.this.pA) {
                        Og.this.JG();
                    }
                } catch (Throwable unused7) {
                    oXVarJG = null;
                    inputStream = null;
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.pA.pA.KZx
    public int pA(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.pA) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.SD) {
                synchronized (this.Og) {
                    long jML = ML();
                    if (j < jML) {
                        new StringBuilder("read:  read ").append(j);
                        this.Bzk.seek(j);
                        i4 = this.Bzk.read(bArr, i, i2);
                    } else {
                        new Object[]{"read: wait at ", Long.valueOf(j), "  file size = ", Long.valueOf(jML)};
                        i3 += 33;
                        this.Og.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.pA.pA.KZx
    public void Og() {
        try {
            if (!this.SD) {
                this.Bzk.close();
            }
            File file = this.KZx;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.ZZv;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        this.SD = true;
    }

    private long ML() {
        if (ZZv()) {
            return this.ZZv.length();
        }
        return this.KZx.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() throws IOException {
        synchronized (this.Og) {
            if (ZZv()) {
                new Object[]{"complete: isCompleted ", this.SGo.Wx(), this.SGo.Sn()};
                return;
            }
            try {
                if (!this.KZx.renameTo(this.ZZv)) {
                    throw new IOException("Error renaming file " + this.KZx + " to " + this.ZZv + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.Bzk;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.Bzk = new RandomAccessFile(this.ZZv, "rw");
                new Object[]{"complete: rename ", this.SGo.Sn(), this.SGo.Wx()};
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.pA.pA.KZx
    public long KZx() throws IOException {
        if (ZZv()) {
            this.pA = this.ZZv.length();
        } else {
            synchronized (this.Og) {
                int i = 0;
                while (this.pA == -2147483648L) {
                    i += 15;
                    try {
                        this.Og.wait(5L);
                        if (i > 20000) {
                            return -1L;
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        new Object[]{"totalLength= ", Long.valueOf(this.pA)};
        return this.pA;
    }
}
