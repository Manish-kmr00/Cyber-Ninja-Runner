package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes9.dex */
class SD extends com.bykv.vk.openvk.pA.pA.Og.Og.pA {
    private final ZZv DX;
    private final KZx Sn;
    private final Socket Wx;
    private volatile boolean aBv;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.Og oX;

    public interface KZx {
        void Og(SD sd);

        void pA(SD sd);
    }

    SD(pA pAVar) {
        super(pAVar.pA, pAVar.Og);
        this.aBv = true;
        this.Wx = pAVar.KZx;
        this.Sn = pAVar.ZZv;
        this.DX = ZZv.KZx();
    }

    private Og omh() {
        try {
            this.Bzk = Bzk.pA(this.Wx.getInputStream());
            OutputStream outputStream = this.Wx.getOutputStream();
            com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pAVar = this.Bzk.KZx.pA == 1 ? ML.pA : ML.Og;
            if (pAVar == null) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.pA = pAVar;
            this.SD = this.Bzk.KZx.Og;
            this.omh = this.Bzk.KZx.KZx;
            this.SGo = new WV(this.Bzk.KZx.SD);
            this.JG = this.Bzk.Og;
            if (ML.KZx) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.Bzk.toString());
            }
            return new Og(outputStream, this.Bzk.KZx.ZZv);
        } catch (Bzk.ZZv e) {
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(this.Wx);
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            if (this.pA != null) {
                Boolean.valueOf(SD());
            }
            String str = this.SD;
            return null;
        } catch (IOException e2) {
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(this.Wx);
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            if (this.pA != null) {
                Boolean.valueOf(SD());
            }
            String str2 = this.SD;
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA;
        Og ogOmh = omh();
        if (ogOmh == null) {
            return;
        }
        KZx kZx = this.Sn;
        if (kZx != null) {
            kZx.pA(this);
        }
        this.pA.pA(this.omh);
        if (ML.omh != 0 && ((pAVarPA = this.Og.pA(this.omh, this.Bzk.KZx.pA)) == null || this.pA.KZx(this.omh).length() < pAVarPA.KZx)) {
            this.DX.pA(SD(), this.omh);
        }
        try {
            pA(ogOmh);
        } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.pA e) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
        } catch (Throwable th) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.pA.Og(this.omh);
        this.DX.pA(SD(), null);
        pA();
        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(this.Wx);
        KZx kZx2 = this.Sn;
        if (kZx2 != null) {
            kZx2.Og(this);
        }
    }

    private boolean pA(Og og) throws Throwable {
        while (this.SGo.pA()) {
            ML();
            WV.pA pAVarOg = this.SGo.Og();
            try {
                pA(og, pAVarOg);
                return true;
            } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx unused) {
                pAVarOg.pA();
                Boolean.valueOf(SD());
                String str = this.SD;
            } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og e) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
                return false;
            } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv e2) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return true;
            } catch (omh.pA e3) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                this.aBv = false;
                Boolean.valueOf(SD());
                String str2 = this.SD;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    pAVarOg.Og();
                }
                if (Og()) {
                    if (ML.KZx) {
                        if ("Canceled".equalsIgnoreCase(e4.getMessage())) {
                            Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                        }
                    }
                } else {
                    Boolean.valueOf(SD());
                    String str3 = this.SD;
                }
            } catch (Exception e5) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
            }
        }
        return false;
    }

    private void pA(Og og, WV.pA pAVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.Bzk.pA.pA)) {
            Og(og, pAVar);
        } else {
            KZx(og, pAVar);
        }
    }

    private void Og(Og og, WV.pA pAVar) throws com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv, IOException {
        byte[] bArrPA = pA(this.Og.pA(this.omh, this.Bzk.KZx.pA), og, pAVar);
        if (bArrPA == null) {
            return;
        }
        og.pA(bArrPA, 0, bArrPA.length);
    }

    private void KZx(Og og, WV.pA pAVar) throws Throwable {
        if (this.aBv) {
            File fileKZx = this.pA.KZx(this.omh);
            long length = fileKZx.length();
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA = this.Og.pA(this.omh, this.Bzk.KZx.pA);
            int iOg = og.Og();
            if (length > og.Og()) {
                if (ML.KZx) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - ((long) iOg)));
                }
                pA(pAVarPA, fileKZx, og, pAVar);
                return;
            }
        } else {
            og.Og();
        }
        ZZv(og, pAVar);
    }

    private byte[] pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVar, Og og, WV.pA pAVar2) throws IOException {
        if (pAVar != null) {
            if (ML.KZx) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVar, og.Og()).getBytes(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA);
        }
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVarPA = pA(pAVar2, 0, -1, "HEAD");
        if (pAVarPA == null) {
            return null;
        }
        try {
            String strPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA, false, false);
            if (strPA != null) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx(strPA + ", rawKey: " + this.SD + ", url: " + pAVar2);
            }
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA2 = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA, this.Og, this.omh, this.Bzk.KZx.pA);
            if (ML.KZx) {
                Log.w("TAG_PROXY_ProxyTask", "get header from network");
            }
            byte[] bytes = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2, og.Og()).getBytes(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA);
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA.ZZv());
            return bytes;
        } catch (Throwable th) {
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA.ZZv());
            throw th;
        }
    }

    private void pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVar, File file, Og og, WV.pA pAVar2) throws Throwable {
        final com.bytedance.sdk.component.omh.SD sd;
        com.bykv.vk.openvk.pA.pA.Og.Og.Og og2;
        if (!og.pA()) {
            byte[] bArrPA = pA(pAVar, og, pAVar2);
            ML();
            if (bArrPA == null) {
                return;
            } else {
                og.pA(bArrPA, 0, bArrPA.length);
            }
        }
        omh omhVar = null;
        if (pAVar == null && (pAVar = this.Og.pA(this.omh, this.Bzk.KZx.pA)) == null) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            pA(null, og, pAVar2);
            pAVar = this.Og.pA(this.omh, this.Bzk.KZx.pA);
            if (pAVar == null) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx("failed to get header, rawKey: " + this.SD + ", url: " + pAVar2);
            }
        }
        if (file.length() >= pAVar.KZx || !((og2 = this.oX) == null || og2.Og() || og2.ZZv())) {
            sd = null;
        } else {
            com.bykv.vk.openvk.pA.pA.Og.Og.Og ogPA = new com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA().pA(this.pA).pA(this.Og).pA(this.SD).Og(this.omh).pA(new WV(pAVar2.pA)).pA(this.JG).pA(this.Bzk).pA(new com.bykv.vk.openvk.pA.pA.Og.Og.Og.InterfaceC0156Og() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.SD.1
                @Override // com.bykv.vk.openvk.pA.pA.Og.Og.Og.InterfaceC0156Og
                public void pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og og3) {
                    SD.this.KZx.addAndGet(og3.KZx.get());
                    SD.this.ZZv.addAndGet(og3.ZZv.get());
                    synchronized (og3.Wx) {
                        og3.Wx.notifyAll();
                    }
                    if (og3.ZZv()) {
                        SD.this.DX.pA(SD.this.SD(), null);
                    }
                }
            }).pA();
            this.oX = ogPA;
            sd = new com.bytedance.sdk.component.omh.SD(ogPA, null, 10, 1);
            com.bytedance.sdk.component.omh.JG.Og(new com.bytedance.sdk.component.omh.omh("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.SD.2
                @Override // java.lang.Runnable
                public void run() {
                    sd.run();
                }
            });
            if (ML.KZx) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            omh omhVar2 = new omh(file, "r");
            try {
                omhVar2.pA(og.Og());
                int iMin = this.Bzk.KZx.ML > 0 ? Math.min(pAVar.KZx, this.Bzk.KZx.ML) : pAVar.KZx;
                while (og.Og() < iMin) {
                    ML();
                    int iPA = omhVar2.pA(bArr);
                    if (iPA <= 0) {
                        com.bykv.vk.openvk.pA.pA.Og.Og.Og og3 = this.oX;
                        if (og3 != null) {
                            com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og ogBzk = og3.Bzk();
                            if (ogBzk != null) {
                                throw ogBzk;
                            }
                            omh.pA pAVarOmh = og3.omh();
                            if (pAVarOmh != null) {
                                throw pAVarOmh;
                            }
                        }
                        if (og3 != null && !og3.Og() && !og3.ZZv()) {
                            ML();
                            synchronized (og3.Wx) {
                                try {
                                    og3.Wx.wait(1000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        if (ML.KZx) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx("illegal state download task has finished, rawKey: " + this.SD + ", url: " + pAVar2);
                    }
                    og.Og(bArr, 0, iPA);
                    ML();
                }
                if (ML.KZx) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + og.Og() + ", " + iMin);
                }
                KZx();
                omhVar2.pA();
                if (sd != null) {
                    try {
                        sd.get();
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                omhVar = omhVar2;
                if (omhVar != null) {
                    omhVar.pA();
                }
                if (sd != null) {
                    try {
                        sd.get();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void ZZv(Og og, WV.pA pAVar) throws Throwable {
        omh omhVar;
        Bzk();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iOg = og.Og();
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVarPA = pA(pAVar, iOg, this.Bzk.KZx.ML, "GET");
        if (pAVarPA == null) {
            return;
        }
        omh omhVar2 = null;
        int i = 0;
        try {
            String strPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA, false, true);
            if (strPA != null) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx(strPA + ", rawKey: " + this.SD + ", url: " + pAVar);
            }
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA2 = this.Og.pA(this.omh, JG());
            int iPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA);
            if (pAVarPA2 != null && pAVarPA2.KZx != iPA) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + pAVarPA2.KZx + ", " + iPA + ", key: " + this.omh);
                }
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og("Content-Length not match, old length: " + pAVarPA2.KZx + ", new length: " + iPA + ", rawKey: " + this.SD + ", currentUrl: " + pAVar + ", previousInfo: " + pAVarPA2.ML);
            }
            if (!og.pA()) {
                String strPA2 = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA, iOg);
                ML();
                byte[] bytes = strPA2.getBytes(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA);
                og.pA(bytes, 0, bytes.length);
            }
            ML();
            File fileZZv = this.pA.ZZv(this.omh);
            if (this.aBv && fileZZv != null && fileZZv.length() >= og.Og()) {
                com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA, this.Og, this.omh, this.Bzk.KZx.pA);
                try {
                    omhVar = new omh(fileZZv, "rwd");
                    try {
                        omhVar.pA(og.Og());
                        if (ML.KZx) {
                            Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + fileZZv.length() + ", from: " + og.Og());
                        }
                    } catch (Throwable th) {
                        th = th;
                        omhVar2 = omhVar;
                    }
                } catch (omh.pA unused) {
                    omhVar = null;
                }
            } else {
                if (ML.KZx) {
                    Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileZZv.length() + ", from: " + og.Og());
                }
                omhVar = null;
            }
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA3 = this.Og.pA(this.omh, JG());
            int i2 = pAVarPA3 == null ? 0 : pAVarPA3.KZx;
            byte[] bArr = new byte[8192];
            InputStream inputStreamZZv = pAVarPA.ZZv();
            int i3 = 0;
            while (true) {
                try {
                    int i4 = inputStreamZZv.read(bArr);
                    if (i4 < 0) {
                        break;
                    }
                    ML();
                    if (i4 > 0) {
                        og.Og(bArr, 0, i4);
                        i3 += i4;
                        if (omhVar != null) {
                            try {
                                omhVar.pA(bArr, 0, i4);
                            } catch (Throwable th2) {
                                omhVar.pA();
                                try {
                                    if (ML.KZx) {
                                        Log.e("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th2));
                                    }
                                    omhVar = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                        pA(i2, og.Og());
                    }
                    ML();
                } catch (Throwable th4) {
                    th = th4;
                    omhVar2 = omhVar;
                }
                th = th4;
                omhVar2 = omhVar;
                i = i3;
                com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA.ZZv());
                if (omhVar2 != null) {
                    omhVar2.pA();
                }
                this.KZx.addAndGet(i);
                this.ZZv.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
                throw th;
            }
            if (ML.KZx) {
                Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
            }
            KZx();
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA.ZZv());
            if (omhVar != null) {
                omhVar.pA();
            }
            this.KZx.addAndGet(i3);
            this.ZZv.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA
    public void pA() {
        super.pA();
        Bzk();
    }

    private void Bzk() {
        com.bykv.vk.openvk.pA.pA.Og.Og.Og og = this.oX;
        this.oX = null;
        if (og != null) {
            og.pA();
        }
    }

    private static class Og {
        private boolean KZx;
        private int Og;
        private final OutputStream pA;

        Og(OutputStream outputStream, int i) {
            this.pA = outputStream;
            this.Og = i;
        }

        boolean pA() {
            return this.KZx;
        }

        void pA(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv {
            if (this.KZx) {
                return;
            }
            try {
                this.pA.write(bArr, i, i2);
                this.KZx = true;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv(e);
            }
        }

        void Og(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv {
            try {
                this.pA.write(bArr, i, i2);
                this.Og += i2;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.ZZv(e);
            }
        }

        int Og() {
            return this.Og;
        }
    }

    static final class pA {
        Socket KZx;
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx Og;
        KZx ZZv;
        com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pA;

        pA() {
        }

        pA pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx) {
            if (kZx == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.Og = kZx;
            return this;
        }

        pA pA(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.KZx = socket;
            return this;
        }

        pA pA(KZx kZx) {
            this.ZZv = kZx;
            return this;
        }

        SD pA() {
            if (this.Og == null || this.KZx == null) {
                throw new IllegalArgumentException();
            }
            return new SD(this);
        }
    }
}
