package com.bykv.vk.openvk.pA.pA.Og.pA.Og;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.component.Og.pA.oX;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    private File ML;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.KZx Og;
    private File ZZv;
    private Context pA;
    private volatile boolean KZx = false;
    private final List<com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA> JG = new ArrayList();
    private volatile boolean SD = false;

    public Og(Context context, com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        this.ZZv = null;
        this.ML = null;
        this.pA = context;
        this.Og = kZx;
        this.ZZv = com.bykv.vk.openvk.pA.pA.Og.ML.Og.Og(kZx.Og(), kZx.Sn());
        this.ML = com.bykv.vk.openvk.pA.pA.Og.ML.Og.KZx(kZx.Og(), kZx.Sn());
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA) {
        if (this.SD) {
            synchronized (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA.class) {
                this.JG.add(interfaceC0159pA);
            }
            return;
        }
        this.JG.add(interfaceC0159pA);
        if (Og()) {
            this.Og.SD(1);
            pA(this.Og, 200);
            KZx.pA(this.Og);
        } else {
            this.SD = true;
            this.Og.SD(0);
            KZx();
        }
    }

    private boolean Og() {
        if (this.ML.exists()) {
            return true;
        }
        if (!this.Og.SGo()) {
            if (this.ZZv.length() >= this.Og.KZx()) {
                return true;
            }
            if (this.Og.pA() > 0 && this.ZZv.length() >= this.Og.pA()) {
                return true;
            }
        }
        return false;
    }

    private void KZx() {
        BSW.pA pAVar;
        if (com.bykv.vk.openvk.pA.pA.pA.KZx.ZZv() != null) {
            pAVar = com.bykv.vk.openvk.pA.pA.pA.KZx.ZZv().Og();
        } else {
            pAVar = new BSW.pA("v_preload");
        }
        pAVar.pA(this.Og.oX(), TimeUnit.MILLISECONDS).Og(this.Og.aBv(), TimeUnit.MILLISECONDS).KZx(this.Og.XT(), TimeUnit.MILLISECONDS);
        BSW bswPA = pAVar.pA();
        Wx.pA pAVar2 = new Wx.pA();
        final long length = this.ZZv.length();
        int iKZx = this.Og.KZx();
        boolean zSGo = this.Og.SGo();
        int iPA = this.Og.pA();
        if (iPA > 0) {
            if (iPA >= this.Og.Bzk()) {
                zSGo = true;
            } else {
                iKZx = iPA;
            }
        }
        pAVar2.pA("videoPreload").pA(6);
        if (zSGo) {
            pAVar2.pA("RANGE", "bytes=" + length + "-").Og(this.Og.Wx()).pA().Og();
        } else {
            pAVar2.pA("RANGE", "bytes=" + length + "-" + iKZx).Og(this.Og.Wx()).pA().Og();
        }
        bswPA.pA(pAVar2.Og()).pA(new com.bytedance.sdk.component.Og.pA.KZx() { // from class: com.bykv.vk.openvk.pA.pA.Og.pA.Og.Og.1
            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, IOException iOException) {
                Og og2 = Og.this;
                og2.pA(og2.Og, 601, iOException.getMessage());
                KZx.pA(Og.this.Og);
            }

            /* JADX WARN: Code duplicated, block: B:71:0x0176 A[Catch: all -> 0x018d, TryCatch #6 {all -> 0x018d, blocks: (B:69:0x0169, B:71:0x0176, B:72:0x017a), top: B:88:0x0169 }] */
            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, DX dx) throws IOException {
                int iKZx2;
                InputStream inputStreamKZx;
                RandomAccessFile randomAccessFile;
                oX oXVarJG;
                long jPA;
                long j = length;
                Closeable closeable = null;
                try {
                    if (dx != null) {
                        boolean zZZv = dx.ZZv();
                        try {
                            if (!zZZv) {
                                try {
                                    Og og2 = Og.this;
                                    og2.pA(og2.Og, dx.KZx(), dx.ML());
                                    Og.this.pA((Closeable) null);
                                    Og.this.pA((Closeable) null);
                                } catch (Throwable th) {
                                    th = th;
                                    inputStreamKZx = null;
                                    randomAccessFile = null;
                                    iKZx2 = 601;
                                    Og.this.ZZv();
                                    Og og3 = Og.this;
                                    com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx = og3.Og;
                                    if (dx != null) {
                                        iKZx2 = dx.KZx();
                                    }
                                    og3.pA(kZx, iKZx2, th.getMessage());
                                    Og.this.pA(randomAccessFile);
                                    Og.this.pA(inputStreamKZx);
                                }
                                Og.this.pA(closeable);
                            }
                            oX oXVarJG2 = dx.JG();
                            try {
                                oXVarJG = dx.JG();
                                if (!zZZv || oXVarJG == null) {
                                    inputStreamKZx = null;
                                    jPA = 0;
                                } else {
                                    try {
                                        jPA = length + oXVarJG.pA();
                                        inputStreamKZx = oXVarJG.KZx();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStreamKZx = null;
                                        randomAccessFile = null;
                                        closeable = oXVarJG;
                                        iKZx2 = 601;
                                        Og.this.ZZv();
                                        Og og4 = Og.this;
                                        com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2 = og4.Og;
                                        if (dx != null) {
                                            iKZx2 = dx.KZx();
                                        }
                                        og4.pA(kZx2, iKZx2, th.getMessage());
                                        Og.this.pA(randomAccessFile);
                                        Og.this.pA(inputStreamKZx);
                                        Og.this.pA(closeable);
                                    }
                                }
                                if (inputStreamKZx == null) {
                                    try {
                                        Og og5 = Og.this;
                                        og5.pA(og5.Og, dx.KZx(), dx.ML());
                                    } catch (Throwable th3) {
                                        th = th3;
                                        randomAccessFile = null;
                                        closeable = oXVarJG;
                                        iKZx2 = 601;
                                        Og.this.ZZv();
                                        Og og6 = Og.this;
                                        com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx3 = og6.Og;
                                        if (dx != null) {
                                            iKZx2 = dx.KZx();
                                        }
                                        og6.pA(kZx3, iKZx2, th.getMessage());
                                        Og.this.pA(randomAccessFile);
                                        Og.this.pA(inputStreamKZx);
                                        Og.this.pA(closeable);
                                    }
                                } else {
                                    try {
                                        randomAccessFile = new RandomAccessFile(Og.this.ZZv, "rw");
                                        try {
                                            byte[] bArr = new byte[8192];
                                            int i = 0;
                                            long j2 = 0;
                                            while (true) {
                                                int i2 = inputStreamKZx.read(bArr, i, 8192 - i);
                                                if (i2 == -1) {
                                                    if (Og.this.Og.SGo() && jPA == Og.this.ZZv.length()) {
                                                        Og.this.ML();
                                                    }
                                                    Og og7 = Og.this;
                                                    og7.pA(og7.Og, dx.KZx());
                                                    closeable = randomAccessFile;
                                                } else if (Og.this.KZx) {
                                                    Og og8 = Og.this;
                                                    og8.Og(og8.Og, dx.KZx());
                                                    Og.this.pA(randomAccessFile);
                                                    break;
                                                } else {
                                                    i += i2;
                                                    j2 += (long) i2;
                                                    if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == jPA - length) {
                                                        com.bykv.vk.openvk.pA.pA.Og.ML.Og.pA(randomAccessFile, bArr, Long.valueOf(j).intValue(), i, Og.this.Og.Sn());
                                                        j += (long) i;
                                                        i = 0;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            closeable = oXVarJG;
                                            iKZx2 = 601;
                                            Og.this.ZZv();
                                            Og og9 = Og.this;
                                            com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx4 = og9.Og;
                                            if (dx != null) {
                                                iKZx2 = dx.KZx();
                                            }
                                            og9.pA(kZx4, iKZx2, th.getMessage());
                                            Og.this.pA(randomAccessFile);
                                            Og.this.pA(inputStreamKZx);
                                            Og.this.pA(closeable);
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        closeable = oXVarJG;
                                        iKZx2 = 601;
                                        randomAccessFile = null;
                                        Og.this.ZZv();
                                        Og og10 = Og.this;
                                        com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx5 = og10.Og;
                                        if (dx != null) {
                                            iKZx2 = dx.KZx();
                                        }
                                        og10.pA(kZx5, iKZx2, th.getMessage());
                                        Og.this.pA(randomAccessFile);
                                        Og.this.pA(inputStreamKZx);
                                        Og.this.pA(closeable);
                                    }
                                }
                                Og.this.pA(inputStreamKZx);
                                Og.this.pA(oXVarJG);
                            } catch (Throwable th6) {
                                th = th6;
                                closeable = oXVarJG2;
                                iKZx2 = 601;
                                inputStreamKZx = null;
                                randomAccessFile = null;
                                Og.this.ZZv();
                                Og og11 = Og.this;
                                com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx6 = og11.Og;
                                if (dx != null) {
                                    iKZx2 = dx.KZx();
                                }
                                og11.pA(kZx6, iKZx2, th.getMessage());
                                Og.this.pA(randomAccessFile);
                                Og.this.pA(inputStreamKZx);
                                Og.this.pA(closeable);
                            }
                            Og.this.ZZv();
                            Og og12 = Og.this;
                            com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx7 = og12.Og;
                            if (dx != null) {
                                iKZx2 = dx.KZx();
                            }
                            og12.pA(kZx7, iKZx2, th.getMessage());
                            Og.this.pA(randomAccessFile);
                            Og.this.pA(inputStreamKZx);
                            Og.this.pA(closeable);
                        } finally {
                            Og.this.pA(randomAccessFile);
                            Og.this.pA(inputStreamKZx);
                            Og.this.pA(closeable);
                            Og.this.pA(dx);
                            new Object[]{"Pre finally ", Og.this.Og.Wx(), " Preload size=", Integer.valueOf(Og.this.Og.KZx())};
                            KZx.pA(Og.this.Og);
                        }
                        iKZx2 = 601;
                    } else {
                        Og og13 = Og.this;
                        iKZx2 = 601;
                        try {
                            og13.pA(og13.Og, 601, "Network link failed.");
                            closeable = null;
                            oXVarJG = null;
                            inputStreamKZx = null;
                        } catch (Throwable th7) {
                            th = th7;
                            closeable = null;
                            inputStreamKZx = null;
                            randomAccessFile = null;
                            Og.this.ZZv();
                            Og og14 = Og.this;
                            com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx8 = og14.Og;
                            if (dx != null) {
                                iKZx2 = dx.KZx();
                            }
                            og14.pA(kZx8, iKZx2, th.getMessage());
                            Og.this.pA(randomAccessFile);
                            Og.this.pA(inputStreamKZx);
                            Og.this.pA(closeable);
                        }
                    }
                    Og.this.pA(closeable);
                    Og.this.pA(inputStreamKZx);
                    Og.this.pA(oXVarJG);
                } catch (Throwable th8) {
                    th = th8;
                    iKZx2 = 601;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public com.bykv.vk.openvk.pA.pA.pA.KZx.KZx pA() {
        return this.Og;
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
        synchronized (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA.class) {
            for (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA : this.JG) {
                if (interfaceC0159pA != null) {
                    interfaceC0159pA.pA(kZx, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
        synchronized (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA.class) {
            for (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA : this.JG) {
                if (interfaceC0159pA != null) {
                    interfaceC0159pA.pA(kZx, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
        synchronized (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA.class) {
            for (com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA : this.JG) {
                if (interfaceC0159pA != null) {
                    interfaceC0159pA.Og(kZx, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        try {
            this.ML.delete();
            this.ZZv.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        try {
            if (this.ZZv.renameTo(this.ML)) {
            } else {
                throw new IOException("Error renaming file " + this.ZZv + " to " + this.ML + " for completion!");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
