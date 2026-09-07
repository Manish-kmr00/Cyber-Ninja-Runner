package com.bykv.vk.openvk.pA.pA.Og.ZZv;

import android.graphics.SurfaceTexture;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.omh.Bzk;
import com.bytedance.sdk.component.utils.TV;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public class ZZv implements KZx.JG, KZx.InterfaceC0158KZx, KZx.ML, KZx.Og, KZx.SD, KZx.ZZv, KZx.pA, com.bykv.vk.openvk.pA.pA.pA.pA, TV.pA {
    private boolean Bzk;
    private SurfaceHolder Og;
    private boolean SGo;
    private ArrayList<Runnable> Sd;
    private boolean TV;
    private TV Wx;
    private int ZZv;
    private volatile boolean gbA;
    private SurfaceTexture pA;
    private boolean vZF;
    private static final SparseIntArray WQf = new SparseIntArray();
    private static boolean FQ = false;
    private int KZx = 0;
    private boolean ML = false;
    private volatile KZx JG = null;
    private final boolean SD = false;
    private boolean omh = false;
    private volatile int BSW = 201;
    private long WV = -1;
    private boolean Sn = false;
    private long DX = 0;
    private long oX = Long.MIN_VALUE;
    private long aBv = 0;
    private long XT = 0;
    private long yFO = 0;
    private int TX = 0;
    private String BF = "0";
    private final List<WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA>> du = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.pA.pA.pA.KZx.KZx eG = null;
    private boolean roi = false;
    private CountDownLatch Mc = new CountDownLatch(1);
    private volatile int IG = 200;
    private AtomicBoolean lT = new AtomicBoolean(false);
    private Surface rB = null;
    private final Runnable xy = new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.1
        @Override // java.lang.Runnable
        public void run() {
            if (ZZv.this.JG == null) {
                return;
            }
            long jABv = ZZv.this.aBv();
            if (jABv > 0 && ZZv.this.JG() && ZZv.this.oX != Long.MIN_VALUE) {
                try {
                    if (ZZv.this.oX == jABv) {
                        if (!ZZv.this.Sn && ZZv.this.aBv >= 400) {
                            ZZv.this.Og(701, 800);
                            ZZv.this.Sn = true;
                        }
                        ZZv.this.aBv += (long) ZZv.this.IG;
                    } else {
                        if (ZZv.this.Sn) {
                            ZZv.this.DX += ZZv.this.aBv;
                            ZZv.this.Og(702, 800);
                            new Object[]{"handleMsg:  bufferingDuration =", Long.valueOf(ZZv.this.DX), "  bufferCount =", Integer.valueOf(ZZv.this.KZx)};
                        }
                        ZZv.this.aBv = 0L;
                        ZZv.this.Sn = false;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (ZZv.this.oX() > 0) {
                if (ZZv.this.oX != jABv) {
                    if (com.bykv.vk.openvk.pA.pA.pA.KZx.ML()) {
                        new Object[]{"run: lastCur = ", Long.valueOf(ZZv.this.oX), "  curPosition = ", Long.valueOf(jABv)};
                    }
                    ZZv zZv = ZZv.this;
                    zZv.pA(jABv, zZv.oX());
                }
                ZZv.this.oX = jABv;
            }
            if (!ZZv.this.Og()) {
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.postDelayed(this, ZZv.this.IG);
                }
            } else {
                ZZv zZv2 = ZZv.this;
                zZv2.pA(zZv2.oX(), ZZv.this.oX());
            }
        }
    };
    private final pA qmB = new pA();
    private long Vgu = 0;
    private long CIG = 0;
    private boolean SzT = false;

    private boolean pA(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(long j, long j2) {
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA(this, j, j2);
            }
        }
    }

    public ZZv() {
        pA("SSMediaPlayerWrapper");
    }

    private void pA(String str) {
        this.TX = 0;
        this.Wx = com.bytedance.sdk.component.omh.pA.pA.pA().pA(this, Bzk.THREAD_NAME_PRE.concat(String.valueOf(str)));
        this.SzT = true;
        Sd();
    }

    private void vZF() {
        this.DX = 0L;
        this.KZx = 0;
        this.aBv = 0L;
        this.Sn = false;
        this.oX = Long.MIN_VALUE;
    }

    public void pA(final boolean z) {
        if (omh()) {
            return;
        }
        this.TV = z;
        if (this.JG != null) {
            this.JG.pA(z);
            return;
        }
        TV tv = this.Wx;
        if (tv != null) {
            tv.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.9
                @Override // java.lang.Runnable
                public void run() {
                    if (ZZv.this.JG != null) {
                        ZZv.this.JG.pA(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sd() {
        TV tv = this.Wx;
        if (tv != null) {
            tv.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ZZv.this.JG == null) {
                        try {
                            ZZv.this.JG = new Og();
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        if (ZZv.this.JG == null) {
                            return;
                        }
                        KZx unused = ZZv.this.JG;
                        ZZv.this.BF = "0";
                        ZZv.this.JG.pA((KZx.ML) ZZv.this);
                        ZZv.this.JG.pA((KZx.Og) ZZv.this);
                        ZZv.this.JG.pA((KZx.InterfaceC0158KZx) ZZv.this);
                        ZZv.this.JG.pA((KZx.pA) ZZv.this);
                        ZZv.this.JG.pA((KZx.JG) ZZv.this);
                        ZZv.this.JG.pA((KZx.ZZv) ZZv.this);
                        ZZv.this.JG.pA((KZx.SD) ZZv.this);
                        try {
                            ZZv.this.JG.KZx(false);
                        } catch (Throwable unused2) {
                        }
                        ZZv.this.omh = false;
                    }
                }
            });
        }
    }

    public void Bzk() {
        if (omh() || this.JG == null) {
            return;
        }
        this.lT.set(true);
        if (this.BSW != 206) {
            vZF();
            this.gbA = false;
            this.qmB.pA(true);
            Og(0L);
            TV tv = this.Wx;
            if (tv != null) {
                tv.removeCallbacks(this.xy);
                this.Wx.postDelayed(this.xy, this.IG);
            }
        }
        this.Mc.countDown();
    }

    public void pA(boolean z, long j, boolean z2) {
        if (omh()) {
            return;
        }
        Sd();
        this.roi = z2;
        this.lT.set(true);
        this.gbA = false;
        Og(z2);
        if (z) {
            this.WV = j;
            TX();
        } else {
            Og(j);
        }
        TV tv = this.Wx;
        if (tv != null) {
            tv.removeCallbacks(this.xy);
            this.Wx.postDelayed(this.xy, this.IG);
        }
        this.Mc.countDown();
    }

    private void Og(long j) {
        this.qmB.pA(j);
        if (this.TV) {
            Og(this.qmB);
        } else if (Og(this.eG)) {
            Og(this.qmB);
        } else {
            pA(this.qmB);
        }
    }

    private boolean Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        return kZx != null && kZx.ZZv();
    }

    public void SGo() {
        if (omh() || this.Wx == null) {
            return;
        }
        this.lT.set(true);
        this.Wx.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.11
            @Override // java.lang.Runnable
            public void run() {
                if (!ZZv.this.SD() || ZZv.this.JG == null) {
                    return;
                }
                try {
                    ZZv.this.JG.ML();
                    for (WeakReference weakReference : ZZv.this.du) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA) weakReference.get()).ML(ZZv.this);
                        }
                    }
                    ZZv.this.BSW = 206;
                } catch (Throwable th) {
                    new Object[]{"play: catch exception ", th.getMessage()};
                }
            }
        });
    }

    class pA implements Runnable {
        private boolean KZx;
        private long Og;

        pA() {
        }

        public void pA(boolean z) {
            this.KZx = z;
        }

        public void pA(long j) {
            this.Og = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ZZv.this.JG != null) {
                try {
                    if (!this.KZx) {
                        long jBzk = ZZv.this.JG.Bzk();
                        ZZv.this.WV = Math.max(this.Og, jBzk);
                    }
                    long unused = ZZv.this.WV;
                } catch (Throwable th) {
                    new StringBuilder("[video] MediaPlayerProxy#start  error: getCurrentPosition :").append(th);
                }
            }
            if (ZZv.this.Wx != null) {
                ZZv.this.Wx.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    public void BSW() {
        TV tv;
        if (omh() || (tv = this.Wx) == null) {
            return;
        }
        tv.removeMessages(100);
        this.gbA = true;
        if (!this.SzT) {
            if (this.vZF || Og(this.eG)) {
                TV tv2 = this.Wx;
                if (tv2 != null) {
                    tv2.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            pA(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.12
                @Override // java.lang.Runnable
                public void run() {
                    if (ZZv.this.Wx != null) {
                        ZZv.this.Wx.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.ML || Og(this.eG)) {
            TV tv3 = this.Wx;
            if (tv3 != null) {
                tv3.sendEmptyMessage(101);
                return;
            }
            return;
        }
        pA(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.13
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.sendEmptyMessage(101);
                }
            }
        });
    }

    public void WV() {
        if (omh()) {
            return;
        }
        this.SGo = true;
        IG();
        TV tv = this.Wx;
        if (tv != null) {
            try {
                tv.removeCallbacksAndMessages(null);
                if (this.JG != null) {
                    this.Wx.sendEmptyMessage(103);
                }
                WQf();
            } catch (Throwable unused) {
                WQf();
            }
        }
    }

    private void TX() {
        Og(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.14
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.sendEmptyMessage(104);
                }
            }
        });
    }

    public void pA(final long j) {
        if (omh()) {
            return;
        }
        if (this.BSW == 207 || this.BSW == 206 || this.BSW == 209) {
            Og(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ZZv.this.Wx != null) {
                        ZZv.this.Wx.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean pA() {
        return this.ML;
    }

    public void pA(final SurfaceTexture surfaceTexture) {
        if (omh()) {
            return;
        }
        this.pA = surfaceTexture;
        pA(true);
        Og(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.3
            @Override // java.lang.Runnable
            public void run() {
                ZZv.this.Sd();
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void pA(final SurfaceHolder surfaceHolder) {
        if (omh()) {
            return;
        }
        this.Og = surfaceHolder;
        pA(true);
        Og(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.4
            @Override // java.lang.Runnable
            public void run() {
                ZZv.this.Sd();
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void pA(final com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (omh()) {
            return;
        }
        this.eG = kZx;
        if (kZx != null) {
            this.SzT = this.SzT && !kZx.ZZv();
        }
        Og(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.5
            @Override // java.lang.Runnable
            public void run() {
                ZZv.this.Sd();
                if (ZZv.this.Wx != null) {
                    ZZv.this.Wx.obtainMessage(107, kZx).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean JG() {
        TV tv;
        return (this.BSW == 206 || ((tv = this.Wx) != null && tv.hasMessages(100))) && !this.gbA;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean KZx() {
        return Wx() || JG() || SD();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean SD() {
        TV tv;
        return ((this.BSW != 207 && !this.gbA) || (tv = this.Wx) == null || tv.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean omh() {
        return this.SGo;
    }

    public boolean Wx() {
        return this.BSW == 205;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public boolean Og() {
        return this.BSW == 209;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        int i = this.BSW;
        int i2 = message.what;
        if (this.JG != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.BSW == 205 || this.BSW == 207 || this.BSW == 209) {
                            this.JG.ML();
                            this.yFO = SystemClock.elapsedRealtime();
                            this.BSW = 206;
                            if (this.WV > 0) {
                                this.JG.pA(this.WV, this.ZZv);
                                this.WV = -1L;
                            }
                            if (this.eG != null) {
                                Og(this.roi);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.Sn) {
                            this.DX += this.aBv;
                        }
                        this.Sn = false;
                        this.aBv = 0L;
                        this.oX = Long.MIN_VALUE;
                        if (this.BSW == 206 || this.BSW == 207 || this.BSW == 209) {
                            this.JG.SD();
                            this.BSW = 207;
                            this.gbA = false;
                            for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().ZZv(this);
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.JG.WV();
                        this.BSW = 201;
                        return;
                    case 103:
                        try {
                            BF();
                            break;
                        } catch (Throwable unused) {
                        }
                        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference2 : this.du) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().KZx(this);
                            }
                        }
                        this.BSW = 203;
                        return;
                    case 104:
                        if (this.BSW == 202 || this.BSW == 208) {
                            this.JG.omh();
                            return;
                        }
                        break;
                    case 105:
                        if (this.BSW == 205 || this.BSW == 206 || this.BSW == 208 || this.BSW == 207 || this.BSW == 209) {
                            this.JG.JG();
                            this.BSW = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.BSW == 206 || this.BSW == 207 || this.BSW == 209) {
                            this.JG.pA(((Long) message.obj).longValue(), this.ZZv);
                            return;
                        }
                        break;
                    case 107:
                        vZF();
                        if (this.BSW == 201 || this.BSW == 203) {
                            com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx = (com.bykv.vk.openvk.pA.pA.pA.KZx.KZx) message.obj;
                            if (TextUtils.isEmpty(kZx.Og())) {
                                kZx.pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og());
                            }
                            File file = new File(kZx.Og(), kZx.Sn());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (com.bykv.vk.openvk.pA.pA.pA.KZx.KZx()) {
                                    Og(file.getAbsolutePath());
                                } else {
                                    this.JG.pA(file.getAbsolutePath());
                                }
                            } else {
                                kZx.Wx();
                                if (!FQ) {
                                    int i3 = kZx.Og;
                                }
                                this.JG.pA(kZx);
                                kZx.Wx();
                            }
                            this.BSW = 202;
                            return;
                        }
                        break;
                    case 108:
                    case 109:
                    default:
                        return;
                    case 110:
                        this.JG.pA((SurfaceHolder) message.obj);
                        this.JG.Og(true);
                        this.Mc.await(1L, TimeUnit.SECONDS);
                        Mc();
                        return;
                    case 111:
                        this.rB = new Surface((SurfaceTexture) message.obj);
                        this.JG.pA(this.rB);
                        this.JG.Og(true);
                        this.Mc.await(1L, TimeUnit.SECONDS);
                        Mc();
                        return;
                }
                this.BSW = 200;
                if (this.omh) {
                    return;
                }
                com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.KZx.pA(308, i2);
                pAVar.pA(i + StringUtils.COMMA + i2);
                for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference3 : this.du) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().pA(this, pAVar);
                    }
                }
                this.omh = true;
            } catch (Throwable unused2) {
            }
        }
    }

    private void Og(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.JG.pA(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void BF() {
        if (this.JG == null) {
            return;
        }
        try {
            this.JG.WV();
        } catch (Throwable unused) {
        }
        this.JG.pA((KZx.Og) null);
        this.JG.pA((KZx.SD) null);
        this.JG.pA((KZx.pA) null);
        this.JG.pA((KZx.ZZv) null);
        this.JG.pA((KZx.InterfaceC0158KZx) null);
        this.JG.pA((KZx.ML) null);
        this.JG.pA((KZx.JG) null);
        try {
            this.JG.BSW();
        } catch (Throwable unused2) {
        }
    }

    private void WQf() {
        TV tv = this.Wx;
        if (tv == null || tv.getLooper() == null) {
            return;
        }
        this.Wx.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.6
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.Wx == null || ZZv.this.Wx.getLooper() == null) {
                    return;
                }
                try {
                    com.bytedance.sdk.component.omh.pA.pA.pA().pA(ZZv.this.Wx);
                    ZZv.this.Wx = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.pA
    public void pA(KZx kZx, int i) {
        if (this.JG != kZx) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().Og(this, i);
            }
        }
    }

    private void TV() {
        SparseIntArray sparseIntArray = WQf;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.TX));
        if (numValueOf == null) {
            sparseIntArray.put(this.TX, 1);
        } else {
            sparseIntArray.put(this.TX, numValueOf.intValue() + 1);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.Og
    public void pA(KZx kZx) {
        this.BSW = 209;
        WQf.delete(this.TX);
        TV tv = this.Wx;
        if (tv != null) {
            tv.removeCallbacks(this.xy);
        }
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.InterfaceC0158KZx
    public boolean pA(KZx kZx, int i, int i2) {
        TV();
        this.BSW = 200;
        TV tv = this.Wx;
        if (tv != null) {
            tv.removeCallbacks(this.xy);
        }
        if (pA(i, i2)) {
            WQf();
        }
        if (!this.lT.get()) {
            return true;
        }
        this.lT.set(false);
        com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.KZx.pA(i, i2);
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA(this, pAVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.ZZv
    public boolean Og(KZx kZx, int i, int i2) {
        if (this.JG != kZx) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.KZx.pA(i, i2);
            for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().pA(this, pAVar);
                }
            }
        }
        Og(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i, int i2) {
        if (i == 701) {
            this.Vgu = SystemClock.elapsedRealtime();
            this.KZx++;
            for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().pA(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            new Object[]{"bufferCount = ", Integer.valueOf(this.KZx)};
            return;
        }
        if (i == 702) {
            if (this.Vgu > 0) {
                this.CIG += SystemClock.elapsedRealtime() - this.Vgu;
                this.Vgu = 0L;
            }
            for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference2 : this.du) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().pA((com.bykv.vk.openvk.pA.pA.pA.pA) this, Integer.MAX_VALUE);
                }
            }
            new Object[]{"bufferCount = ", Integer.valueOf(this.KZx), " mBufferTotalTime = ", Long.valueOf(this.CIG)};
            return;
        }
        if (this.SzT && i == 3) {
            Mc();
            du();
            Og(this.roi);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.ML
    public void Og(KZx kZx) {
        if (omh()) {
            return;
        }
        this.BSW = 205;
        try {
            com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2 = this.eG;
            if (kZx2 != null) {
                float fWV = kZx2.WV();
                if (fWV > 0.0f) {
                    com.bykv.vk.openvk.pA.pA.pA.Og og = new com.bykv.vk.openvk.pA.pA.pA.Og();
                    og.pA(fWV);
                    this.JG.pA(og);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.Wx != null) {
            if (this.gbA) {
                eG();
            } else {
                TV tv = this.Wx;
                tv.sendMessage(tv.obtainMessage(100, -1, -1));
            }
        }
        WQf.delete(this.TX);
        boolean z = this.SzT;
        boolean z2 = this.vZF;
        if (!z && !z2) {
            du();
            this.vZF = true;
        }
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().Og(this);
            }
        }
    }

    private void du() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.yFO;
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA(this, jElapsedRealtime);
            }
        }
        this.ML = true;
    }

    private void eG() {
        TV tv = this.Wx;
        if (tv != null) {
            tv.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ZZv.this.JG.SD();
                        ZZv.this.BSW = 207;
                        ZZv.this.gbA = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.JG
    public void KZx(KZx kZx) {
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA((com.bykv.vk.openvk.pA.pA.pA.pA) this, true);
            }
        }
    }

    private void pA(Runnable runnable) {
        try {
            if (this.Sd == null) {
                this.Sd = new ArrayList<>();
            }
            this.Sd.add(runnable);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void roi() {
        if (this.Bzk) {
            return;
        }
        this.Bzk = true;
        Iterator it = new ArrayList(this.Sd).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.Sd.clear();
        this.Bzk = false;
    }

    private void Mc() {
        ArrayList<Runnable> arrayList = this.Sd;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        roi();
    }

    private void IG() {
        ArrayList<Runnable> arrayList = this.Sd;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.Sd.clear();
    }

    private void Og(Runnable runnable) {
        if (runnable == null || omh()) {
            return;
        }
        if (!this.SGo) {
            runnable.run();
        } else {
            pA(runnable);
        }
    }

    public void Og(final boolean z) {
        TV tv;
        if (omh() || (tv = this.Wx) == null) {
            return;
        }
        tv.post(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.8
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.omh() || ZZv.this.JG == null) {
                    return;
                }
                try {
                    ZZv.this.roi = z;
                    ZZv.this.JG.ZZv(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public long Sn() {
        if (this.Sn) {
            long j = this.aBv;
            if (j > 0) {
                return this.DX + j;
            }
        }
        return this.DX;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public int ZZv() {
        if (this.JG == null || omh()) {
            return 0;
        }
        return this.JG.Wx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA
    public int ML() {
        if (this.JG == null || omh()) {
            return 0;
        }
        return this.JG.Sn();
    }

    public int DX() {
        return this.KZx;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx.SD
    public void pA(KZx kZx, int i, int i2, int i3, int i4) {
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pA((com.bykv.vk.openvk.pA.pA.pA.pA) this, i, i2);
            }
        }
    }

    public long oX() {
        long j = this.XT;
        if (j != 0) {
            return j;
        }
        if (this.BSW == 206 || this.BSW == 207) {
            try {
                this.XT = this.JG.SGo();
            } catch (Throwable unused) {
            }
        }
        return this.XT;
    }

    public long aBv() {
        if (omh()) {
            return 0L;
        }
        if (this.BSW == 206 || this.BSW == 207) {
            try {
                return this.JG.Bzk();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA interfaceC0161pA) {
        if (interfaceC0161pA == null) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA> weakReference : this.du) {
            if (weakReference != null && weakReference.get() == interfaceC0161pA) {
                return;
            }
        }
        this.du.add(new WeakReference<>(interfaceC0161pA));
    }

    public void pA(int i) {
        if (omh()) {
            return;
        }
        this.IG = i;
    }

    public SurfaceHolder XT() {
        return this.Og;
    }

    public SurfaceTexture yFO() {
        return this.pA;
    }

    public void Og(int i) {
        this.ZZv = i;
    }

    public static void KZx(boolean z) {
        FQ = z;
    }
}
