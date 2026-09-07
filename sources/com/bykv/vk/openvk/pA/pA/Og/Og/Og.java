package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class Og extends com.bykv.vk.openvk.pA.pA.Og.Og.pA {
    private final int DX;
    final Object Sn;
    final Object Wx;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og XT;
    private volatile omh.pA aBv;
    private final InterfaceC0156Og oX;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.pA.pA.Og.Og.Og$Og, reason: collision with other inner class name */
    public interface InterfaceC0156Og {
        void pA(Og og);
    }

    Og(pA pAVar) {
        super(pAVar.ZZv, pAVar.ML);
        this.DX = pAVar.SD;
        this.oX = pAVar.Bzk;
        this.Wx = this;
        this.SD = pAVar.pA;
        this.omh = pAVar.Og;
        this.JG = pAVar.JG;
        this.SGo = pAVar.KZx;
        this.Bzk = pAVar.omh;
        this.Sn = pAVar.SGo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pA.pA(this.omh);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            SGo();
        } catch (Throwable unused) {
        }
        this.ZZv.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.pA.Og(this.omh);
        InterfaceC0156Og interfaceC0156Og = this.oX;
        if (interfaceC0156Og != null) {
            interfaceC0156Og.pA(this);
        }
    }

    omh.pA omh() {
        return this.aBv;
    }

    com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og Bzk() {
        return this.XT;
    }

    private boolean SGo() throws com.bykv.vk.openvk.pA.pA.Og.Og.KZx.pA {
        while (this.SGo.pA()) {
            ML();
            WV.pA pAVarOg = this.SGo.Og();
            try {
                pA(pAVarOg);
                return true;
            } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx unused) {
                pAVarOg.pA();
                Boolean.valueOf(SD());
                String str = this.SD;
            } catch (com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og e) {
                this.XT = e;
                return false;
            } catch (omh.pA e2) {
                this.aBv = e2;
                Boolean.valueOf(SD());
                String str2 = this.SD;
                return false;
            } catch (IOException e3) {
                if (e3 instanceof SocketTimeoutException) {
                    pAVarOg.Og();
                }
                if (!Og()) {
                    Boolean.valueOf(SD());
                    String str3 = this.SD;
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    private void pA(WV.pA pAVar) throws Throwable {
        File fileKZx = this.pA.KZx(this.omh);
        long length = fileKZx.length();
        int i = this.DX;
        if (i > 0 && length >= i) {
            if (ML.KZx) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.omh + ", cache file size: " + length + ", max: " + this.DX);
                return;
            }
            return;
        }
        int iJG = JG();
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA = this.Og.pA(this.omh, iJG);
        if (pAVarPA != null && length >= pAVarPA.KZx) {
            if (ML.KZx) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.omh);
                return;
            }
            return;
        }
        ML();
        int i2 = (int) length;
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVarPA2 = pA(pAVar, i2, this.DX, "GET");
        if (pAVarPA2 == null) {
            return;
        }
        boolean z = true;
        omh omhVar = null;
        try {
            ML();
            String strPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2, this.Bzk == null && ML.ML, true);
            if (strPA != null) {
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.KZx(strPA + ", rawKey: " + this.SD + ", url: " + pAVar);
            }
            int iPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2);
            if (pAVarPA != null && pAVarPA.KZx != iPA) {
                if (ML.KZx) {
                    Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + pAVarPA.KZx + ", " + iPA + ", key: " + this.omh);
                }
                throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.Og("Content-Length not match, old length: " + pAVarPA.KZx + ", new length: " + iPA + ", rawKey: " + this.SD + ", currentUrl: " + pAVar + ", previousInfo: " + pAVarPA.ML);
            }
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2, this.Og, this.omh, iJG);
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA3 = this.Og.pA(this.omh, iJG);
            int i3 = pAVarPA3 == null ? 0 : pAVarPA3.KZx;
            InputStream inputStreamZZv = pAVarPA2.ZZv();
            omh omhVar2 = new omh(fileKZx, ML.ZZv ? "rwd" : "rw");
            try {
                omhVar2.pA(length);
                if (ML.KZx) {
                    Log.i("TAG_PROXY_DownloadTask", "preload start from: ".concat(String.valueOf(length)));
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamZZv.read(bArr);
                    if (i4 >= 0) {
                        ML();
                        if (i4 > 0) {
                            omhVar2.pA(bArr, 0, i4);
                            i2 += i4;
                            if (this.Bzk != null) {
                                synchronized (this.Wx) {
                                    this.Wx.notifyAll();
                                }
                            }
                            this.KZx.addAndGet(i4);
                            pA(i3, i2);
                        }
                        int i5 = this.DX;
                        if (i5 > 0 && i2 >= i5) {
                            if (ML.KZx) {
                                Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i2 + ", max: " + this.DX);
                            }
                            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2.ZZv());
                            omhVar2.pA();
                            pA();
                            if (ML.KZx) {
                                Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                return;
                            }
                            return;
                        }
                        ML();
                    } else {
                        try {
                            KZx();
                            if (ML.KZx) {
                                Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
                            }
                            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2.ZZv());
                            omhVar2.pA();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            omhVar = omhVar2;
                            z = false;
                        }
                    }
                    com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(pAVarPA2.ZZv());
                    if (omhVar != null) {
                        omhVar.pA();
                    }
                    if (z) {
                        pA();
                        if (ML.KZx) {
                            Log.w("TAG_PROXY_DownloadTask", "cancel call");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                omhVar = omhVar2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static final class pA {
        InterfaceC0156Og Bzk;
        List<Bzk.Og> JG;
        WV KZx;
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx ML;
        String Og;
        int SD;
        Object SGo;
        com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA ZZv;
        Bzk omh;
        String pA;

        pA() {
        }

        pA pA(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.pA = str;
            return this;
        }

        pA Og(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.Og = str;
            return this;
        }

        pA pA(WV wv) {
            if (wv == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.KZx = wv;
            return this;
        }

        pA pA(com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pAVar) {
            if (pAVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.ZZv = pAVar;
            return this;
        }

        pA pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx) {
            if (kZx == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.ML = kZx;
            return this;
        }

        pA pA(List<Bzk.Og> list) {
            this.JG = list;
            return this;
        }

        pA pA(int i) {
            this.SD = i;
            return this;
        }

        pA pA(InterfaceC0156Og interfaceC0156Og) {
            this.Bzk = interfaceC0156Og;
            return this;
        }

        pA pA(Bzk bzk) {
            this.omh = bzk;
            return this;
        }

        pA pA(Object obj) {
            this.SGo = obj;
            return this;
        }

        Og pA() {
            if (this.ZZv == null || this.ML == null || TextUtils.isEmpty(this.pA) || TextUtils.isEmpty(this.Og) || this.KZx == null) {
                throw new IllegalArgumentException();
            }
            return new Og(this);
        }
    }
}
