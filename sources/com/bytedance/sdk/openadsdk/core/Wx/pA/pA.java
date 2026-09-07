package com.bytedance.sdk.openadsdk.core.Wx.pA;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.pA.pA.pA.JG.ZZv;
import com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.core.WV.JG;
import com.bytedance.sdk.openadsdk.core.Wx.Og.ML;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public abstract class pA implements KZx, TV.pA, com.bytedance.sdk.openadsdk.core.Wx.Og.pA {
    protected Og BF;
    protected final Context BSW;
    protected com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx JG;
    protected SurfaceTexture ML;
    protected long Mc;
    protected ML SD;
    protected boolean Sd;
    protected final ViewGroup TV;
    protected boolean WQf;
    protected SurfaceHolder ZZv;
    protected WeakReference<KZx.Og> du;
    protected KZx.pA eG;
    private long lT;
    protected boolean oX;
    protected final yFO omh;
    protected JG roi;
    protected String pA = "TTAD.VideoController";
    protected final int Og = 100;
    protected final TV KZx = new TV(Looper.getMainLooper(), this);
    protected long Bzk = 0;
    protected long SGo = 0;
    protected final List<Runnable> WV = new ArrayList();
    protected boolean Wx = false;
    protected boolean Sn = false;
    protected boolean DX = true;
    protected boolean aBv = false;
    protected boolean XT = false;
    protected boolean yFO = false;
    protected AtomicBoolean vZF = new AtomicBoolean(false);
    protected boolean TX = true;
    protected Runnable IG = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.pA.pA.1
        @Override // java.lang.Runnable
        public void run() {
            new Object[]{"resumeVideo: run ", Boolean.valueOf(pA.this.Wx)};
            pA.this.Sd();
        }
    };
    private long rB = 0;
    private boolean xy = true;
    private int qmB = 1;
    private final AtomicBoolean gbA = new AtomicBoolean(false);

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean aBv() {
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(KZx.ZZv zZv) {
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view, boolean z) {
    }

    public pA(Context context, yFO yfo, ViewGroup viewGroup) {
        this.omh = yfo;
        this.BSW = context;
        this.TV = viewGroup;
        this.pA += hashCode();
    }

    protected void yFO() {
        if (this.JG == null) {
            return;
        }
        if (XT()) {
            SurfaceTexture surfaceTexture = this.ML;
            if (surfaceTexture == null || surfaceTexture == this.JG.yFO()) {
                return;
            }
            this.JG.pA(this.ML);
            return;
        }
        SurfaceHolder surfaceHolder = this.ZZv;
        if (surfaceHolder == null || surfaceHolder == this.JG.XT()) {
            return;
        }
        this.JG.pA(this.ZZv);
    }

    private boolean XT() {
        ML ml = this.SD;
        if (ml != null) {
            return ml.Wx() instanceof ZZv;
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public long ML() {
        return this.Bzk;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(long j) {
        this.Bzk = j;
        this.SGo = Math.max(this.SGo, j);
    }

    protected void pA(Runnable runnable) {
        if (this.SD.TX() && this.Wx) {
            runnable.run();
        } else {
            Og(runnable);
        }
    }

    protected void Og(Runnable runnable) {
        this.WV.add(runnable);
    }

    protected void vZF() {
        if (this.WV.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.WV).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.WV.clear();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, SurfaceHolder surfaceHolder) {
        this.Wx = true;
        this.ZZv = surfaceHolder;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return;
        }
        kZx.pA(surfaceHolder);
        vZF();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public void Og(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, SurfaceHolder surfaceHolder) {
        this.Wx = false;
        this.ZZv = null;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA(false);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, SurfaceTexture surfaceTexture) {
        this.Wx = true;
        this.ML = surfaceTexture;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA(surfaceTexture);
            this.JG.pA(this.Wx);
        }
        vZF();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public void Og(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, SurfaceTexture surfaceTexture) {
        this.Wx = false;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA(false);
        }
        this.ML = null;
        vZF();
    }

    protected void Sd() {
        this.KZx.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.pA.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.JG != null) {
                    new Object[]{"resumeVideo: execResumePlay", Boolean.valueOf(pA.this.Wx)};
                    pA.this.JG.SGo();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public com.bykv.vk.openvk.pA.pA.pA.pA WV() {
        return this.JG;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    /* JADX INFO: renamed from: TX, reason: merged with bridge method [inline-methods] */
    public final ML Wx() {
        return this.SD;
    }

    public boolean BF() {
        return this.DX;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(boolean z) {
        this.DX = z;
        ML ml = this.SD;
        if (ml != null) {
            ml.ZZv(z);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og(long j) {
        this.rB = j;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean BSW() {
        return this.aBv;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx(long j) {
        this.Mc = j;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final long JG() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return 0L;
        }
        return kZx.Sn();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final int SD() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return 0;
        }
        return kZx.DX();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean Sn() {
        return this.oX;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void Og(final boolean z) {
        this.oX = z;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.Og(z);
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.SD, z);
        }
        if (this.roi != null) {
            if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
                this.roi.pA(z);
            } else {
                this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.pA.pA.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.roi.pA(z);
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final long omh() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return 0L;
        }
        return kZx.oX();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean DX() {
        return this.Sn;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void KZx(boolean z) {
        this.Sn = z;
    }

    protected void JG(boolean z) {
        this.yFO = z;
    }

    public boolean WQf() {
        return this.xy;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void ZZv(boolean z) {
        this.xy = z;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        Og og = (Og) kZx;
        this.BF = og;
        this.oX = og.omh();
        kZx.ZZv(String.valueOf(this.omh.Wf()));
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final boolean oX() {
        return this.WQf;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final int SGo() {
        return com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(this.SGo, this.Mc);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ML(boolean z) {
        this.TX = z;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void Og(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view) {
        Og(og, view, false, false);
    }

    public final void Og(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view, boolean z, boolean z2) {
        JG(!this.yFO);
        Context context = this.BSW;
        if (context != null && (context instanceof Activity)) {
            if (this.yFO) {
                pA(z ? 8 : 0);
                ML ml = this.SD;
                if (ml != null) {
                    ml.pA(this.TV);
                    this.SD.KZx(false);
                }
            } else {
                pA(1);
                ML ml2 = this.SD;
                if (ml2 != null) {
                    ml2.Og(this.TV);
                    this.SD.KZx(false);
                }
            }
            WeakReference<KZx.Og> weakReference = this.du;
            KZx.Og og2 = weakReference != null ? weakReference.get() : null;
            if (og2 != null) {
                og2.pA(this.yFO);
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void pA(KZx.Og og) {
        this.du = new WeakReference<>(og);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void ML(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view) {
        pA(og, view, false);
    }

    public final boolean TV() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        return kZx == null || kZx.Og();
    }

    public final boolean du() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        return kZx != null && kZx.JG();
    }

    public final void pA(int i) {
        Context context = this.BSW;
        if (context == null) {
            return;
        }
        boolean z = i == 0 || i == 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                activity.setRequestedOrientation(i);
            } catch (Throwable unused) {
            }
            if (!z) {
                activity.getWindow().setFlags(1024, 1024);
            } else {
                activity.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void KZx(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view) {
        ML ml = this.SD;
        if (ml != null) {
            ml.Bzk();
        }
        pA(true, 3);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view, boolean z, boolean z2) {
        if (this.DX) {
            pA();
        }
        if (z && !this.DX && !TV()) {
            this.SD.Og(!du(), false);
            this.SD.pA(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null && kZx.JG()) {
            this.SD.JG();
            this.SD.ML();
        } else {
            this.SD.JG();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void ZZv(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view) {
        if (this.yFO) {
            JG(false);
            ML ml = this.SD;
            if (ml != null) {
                ml.Og(this.TV);
            }
            pA(1);
            return;
        }
        pA(true, 3);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, int i, boolean z) {
        if (this.BSW == null) {
            return;
        }
        long j = this.Mc;
        long j2 = (long) (((((long) i) * j) * 1.0f) / 100.0f);
        if (j > 0) {
            this.lT = (int) j2;
        } else {
            this.lT = 0L;
        }
        ML ml = this.SD;
        if (ml != null) {
            ml.pA(this.lT);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, int i) {
        if (this.JG == null) {
            return;
        }
        pA(this.lT, KZx(i));
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public final void Og(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, int i) {
        ML ml = this.SD;
        if (ml != null) {
            ml.JG();
        }
    }

    private void pA(long j, boolean z) {
        if (this.JG == null) {
            return;
        }
        if (z) {
            rB();
        }
        this.JG.pA(j);
    }

    private boolean KZx(int i) {
        return this.SD.Og(i);
    }

    private void rB() {
        ML ml = this.SD;
        if (ml != null) {
            ml.ZZv(0);
            this.SD.pA(false, false);
            this.SD.KZx(false);
            this.SD.ML();
            this.SD.SD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pA(SD sd) {
        if (this.vZF.compareAndSet(false, true)) {
            JG jg = this.roi;
            if (jg != null) {
                jg.pA(omh(), Sn());
            }
            DX.pA pAVar = new DX.pA();
            pAVar.pA(WQf());
            pAVar.KZx(omh());
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(aBv.pA(), this.SD, pAVar, sd);
        }
    }

    protected final void eG() {
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh() / ((long) IG()));
        pAVar.Og(JG());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og(Wx(), pAVar);
    }

    protected final void roi() {
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh() / ((long) IG()));
        pAVar.Og(JG());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.SD, pAVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Og(SD sd) {
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh() / ((long) IG()));
        pAVar.Og(JG());
        pAVar.ZZv(SD());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og(this.SD, pAVar, sd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar) {
        DX.pA pAVar2 = new DX.pA();
        pAVar2.Og(JG());
        pAVar2.KZx(omh() / ((long) IG()));
        pAVar2.pA(ML());
        pAVar2.pA(pAVar);
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.KZx(Wx(), pAVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Mc() {
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.omh, this.SD, this.BF);
    }

    public int IG() {
        return this.qmB;
    }

    public void Og(int i) {
        this.qmB = i;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void pA(KZx.pA pAVar) {
        this.eG = pAVar;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Wx.pA.pA$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.widget.yFO.pA.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.widget.yFO.pA.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.sdk.openadsdk.core.widget.yFO.pA.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[com.bytedance.sdk.openadsdk.core.widget.yFO.pA.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.pA
    public final void pA(com.bytedance.sdk.openadsdk.core.widget.yFO.pA pAVar, String str) {
        int i = AnonymousClass4.pA[pAVar.ordinal()];
        if (i == 1) {
            pA();
            return;
        }
        if (i == 2) {
            KZx();
        } else {
            if (i != 3) {
                return;
            }
            Og();
            this.aBv = false;
            this.XT = true;
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final long Bzk() {
        return ML() + JG();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public final void pA() {
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.BSW();
        }
        if (this.Sd || !this.vZF.get()) {
            return;
        }
        roi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void lT() {
        com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(this.omh.lx(), true, this.omh), 5, this.omh.nCO());
    }

    public final void ZZv(long j) {
        this.Bzk = j;
        this.SGo = Math.max(this.SGo, j);
        ML ml = this.SD;
        if (ml != null) {
            ml.pA();
        }
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA(true, this.Bzk, this.oX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pA(long j, long j2) {
        if (!this.gbA.get() && com.bytedance.sdk.openadsdk.JG.pA.pA().KZx() && (j * 1.0d) / j2 > 0.3d) {
            this.gbA.set(true);
            if (this.omh != null) {
                com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoPercent30", this.omh);
            }
        }
    }
}
