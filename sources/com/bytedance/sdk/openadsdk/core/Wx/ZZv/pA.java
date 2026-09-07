package com.bytedance.sdk.openadsdk.core.Wx.ZZv;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BF.Og.ML;
import com.bytedance.sdk.openadsdk.Wx.Sn;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.WV.JG;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.Wx.pA.pA {
    private boolean CIG;
    private final Runnable FQ;
    private InterfaceC0240pA Gx;
    private final int SzT;
    private long Vgu;
    private long gbA;
    protected long lT;
    private final SD qmB;
    protected boolean rB;
    final KZx.Og xy;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0240pA {
        void pA(int i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.pA.pA
    public boolean WQf() {
        return true;
    }

    protected void XT() {
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA$1, reason: invalid class name */
    class AnonymousClass1 implements KZx.Og {
        private boolean Og = true;

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
        }

        AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            String unused = pA.this.pA;
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.roi != null) {
                        try {
                            pA.this.roi.pA(9);
                        } catch (Exception unused2) {
                        }
                    }
                    pA.this.FQ();
                }
            });
            com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = pA.this.omh.dGZ();
            if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                long jML = pA.this.ML();
                pAVarDGZ.pA().ZZv(jML);
                pAVarDGZ.pA().ML(jML);
            }
            ML.pA(pA.this.omh, 5);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(pA.this.omh, 5);
            if (pA.this.Gx != null) {
                pA.this.Gx.pA(3);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, long j) {
            String unused = pA.this.pA;
            pA.this.WQf = false;
            pA.this.KZx.removeCallbacks(pA.this.FQ);
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.Og();
                    }
                }
            });
            if (!pA.this.vZF.get()) {
                pA.this.lT = j;
                pA pAVar2 = pA.this;
                pAVar2.pA(pAVar2.qmB);
                pA.this.lT();
            }
            if (pA.this.roi != null) {
                pA.this.roi.KZx();
            }
            ML.pA(pA.this.omh, 0);
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            String unused = pA.this.pA;
            pA.this.KZx.removeCallbacks(pA.this.FQ);
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.Og();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar2) {
            WV.pA(pA.this.pA, "onError: " + pAVar2.pA() + StringUtils.COMMA + pAVar2.Og() + StringUtils.COMMA + pAVar2.KZx());
            pA.this.KZx.removeCallbacks(pA.this.FQ);
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.Og();
                    }
                    if (pA.this.eG != null) {
                        pA.this.eG.Og(pA.this.Vgu, com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(pA.this.Bzk, pA.this.Mc));
                    }
                }
            });
            pA.this.pA(pAVar2);
            ML.pA(pA.this.omh, 6);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(pA.this.omh);
            if (pA.this.roi != null) {
                pA.this.roi.pA(14);
            }
            if (pA.this.Gx != null) {
                pA.this.Gx.pA(4);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, boolean z) {
            String unused = pA.this.pA;
            pA.this.KZx.removeCallbacks(pA.this.FQ);
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.Og();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void KZx(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            String unused = pA.this.pA;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2) {
            String unused = pA.this.pA;
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.JG == null) {
                        return;
                    }
                    try {
                        final float fZZv = pA.this.JG.ZZv();
                        final float fML = pA.this.JG.ML();
                        if (fZZv == 0.0f || fML == 0.0f) {
                            return;
                        }
                        pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (pA.this.Gx()) {
                                    if (!aBv.Og(pA.this.omh) && pA.this.BF.ML != 4) {
                                        if (!aBv.KZx(pA.this.omh)) {
                                            if (pA.this.omh.Mc() != 3) {
                                                if (pA.this.omh.Mc() == 0) {
                                                    pA.this.KZx(fZZv, fML);
                                                    return;
                                                } else {
                                                    pA.this.Og(fZZv, fML);
                                                    return;
                                                }
                                            }
                                            pA.this.pA(true, fZZv, fML);
                                            return;
                                        }
                                        pA.this.pA(true, fZZv, fML);
                                        return;
                                    }
                                    pA.this.pA(true, fZZv, fML);
                                    return;
                                }
                                pA.this.pA(fZZv, fML);
                            }
                        });
                    } catch (Throwable th) {
                        WV.pA(pA.this.pA, th.getMessage());
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2, int i3) {
            String unused = pA.this.pA;
            pA.this.WQf = true;
            pA.this.SzT();
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.aBv();
                    }
                }
            });
            ML.pA(pA.this.omh, 3);
            if (pA.this.roi != null) {
                pA.this.roi.pA(4);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
            String unused = pA.this.pA;
            pA.this.WQf = false;
            pA.this.KZx.removeCallbacks(pA.this.FQ);
            pA.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.SD != null) {
                        pA.this.SD.Og();
                    }
                }
            });
            ML.pA(pA.this.omh, 0);
            if (pA.this.roi != null) {
                pA.this.roi.pA(5);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, long j, long j2) {
            if (Math.abs(j - pA.this.Bzk) < 50) {
                return;
            }
            pA pAVar2 = pA.this;
            pAVar2.pA(pAVar2.qmB);
            pA.this.pA(j, j2);
            pA.this.Og(j, j2);
            com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = pA.this.omh.dGZ();
            if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                pAVarDGZ.pA().pA(j, j2, pA.this.roi);
            }
            if (!this.Og || j2 - j >= 500) {
                return;
            }
            this.Og = false;
            pA(pAVar);
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void ZZv(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = pA.this.omh.dGZ();
            if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                pAVarDGZ.pA().Og(pA.this.Bzk);
            }
            ML.pA(pA.this.omh, 3);
            if (pA.this.roi != null) {
                pA.this.roi.pA(0);
            }
            if (pA.this.Gx != null) {
                pA.this.Gx.pA(2);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void ML(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            ML.pA(pA.this.omh, 0);
            if (pA.this.roi != null) {
                pA.this.roi.pA(1);
            }
            if (pA.this.Gx != null) {
                pA.this.Gx.pA(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx.Og
        public void pA(int i, int i2) {
            pA pAVar = pA.this;
            pAVar.Og(pAVar.qmB);
            pA.this.BF.ZZv = pA.this.JG.vZF();
            pA.this.Mc();
            pA.this.vZF.set(false);
            pA pAVar2 = pA.this;
            pAVar2.pA(pAVar2.qmB);
        }
    }

    public void rB() {
        this.xy.pA((com.bykv.vk.openvk.pA.pA.pA.pA) null, 0, 0);
    }

    protected void pA(boolean z, float f, float f2) {
        try {
            new StringBuilder("landingPageChangeVideoSize start.......").append(this.omh.rB());
            if (!Bf() || z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (qmB() != null) {
                    if (qmB() instanceof TextureView) {
                        ((TextureView) qmB()).setLayoutParams(layoutParams);
                    } else if (qmB() instanceof SurfaceView) {
                        ((SurfaceView) qmB()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.TV.getLayoutParams();
                    if (this.TV.getHeight() > 0) {
                        float fMin = Math.min(this.TV.getWidth() / f, this.TV.getHeight() / f2);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (f * fMin);
                            layoutParams.height = (int) (f2 * fMin);
                            if (qmB() instanceof TextureView) {
                                ((TextureView) qmB()).setLayoutParams(layoutParams);
                            } else if (qmB() instanceof SurfaceView) {
                                ((SurfaceView) qmB()).setLayoutParams(layoutParams);
                            }
                            if (this.BF.ML == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.TV.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            WV.pA(this.pA, "changeSize error", th);
        }
    }

    public pA(Context context, ViewGroup viewGroup, yFO yfo, SD sd) {
        super(context, yfo, viewGroup);
        this.gbA = 0L;
        this.Vgu = 0L;
        this.CIG = false;
        this.lT = 0L;
        this.rB = false;
        this.xy = new AnonymousClass1();
        this.FQ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.3
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.eG != null) {
                    pA.this.XT();
                    pA.this.eG.pA();
                }
            }
        };
        this.qmB = sd;
        this.SzT = yfo.Wf();
        if (yfo.rjD() && yfo.dGZ() != null && this.TV != null) {
            if (this.roi == null) {
                this.roi = JG.pA();
            }
            this.roi.pA(this.TV, yfo.dGZ().Sn());
        }
        this.SD = new com.bytedance.sdk.openadsdk.core.Wx.Og.ML(context.getApplicationContext(), new Sn(context), true, 17, this.omh, this);
        this.SD.pA(this);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        int iYFO;
        View view;
        if (this.JG != null) {
            WV.pA(this.pA, "playVideoUrl: already invoked");
            return false;
        }
        kZx.Wx();
        if (TextUtils.isEmpty(kZx.Wx())) {
            WV.pA(this.pA, "No video info");
            return false;
        }
        Og(kZx);
        kZx.KZx(1);
        this.rB = !kZx.Wx().startsWith("http");
        if (this.roi != null) {
            if (this.BF.ML == 1) {
                iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().SGo(String.valueOf(this.SzT));
            } else {
                iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().yFO(String.valueOf(this.SzT));
            }
            if (this.TV != null && (view = (View) this.TV.getParent()) != null) {
                try {
                    View viewFindViewById = view.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.WV);
                    this.roi.pA(view.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Mx), FriendlyObstructionPurpose.OTHER);
                    this.roi.pA(viewFindViewById, FriendlyObstructionPurpose.OTHER);
                } catch (Throwable unused) {
                }
            }
            this.roi.pA(iYFO > 0, iYFO / 1000.0f);
        }
        Mc();
        if (kZx.SD() > 0) {
            this.Bzk = kZx.SD();
            this.SGo = Math.max(this.SGo, this.Bzk);
        }
        if (this.SD != null) {
            this.SD.pA();
            this.SD.SD();
            this.SD.KZx(kZx.ML(), kZx.JG());
            this.SD.KZx(this.TV);
        }
        this.JG = new KZx();
        this.JG.pA(this.xy);
        yFO();
        this.Vgu = 0L;
        CIG();
        return true;
    }

    private void CIG() {
        this.JG.KZx(IG());
        this.JG.pA(this.BF);
        this.gbA = System.currentTimeMillis();
        this.SD.KZx(8);
        this.SD.KZx(0);
        pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.JG == null) {
                    return;
                }
                pA.this.gbA = System.currentTimeMillis();
                pA.this.SD.ZZv(0);
                pA.this.JG.pA(true, pA.this.Bzk, pA.this.oX);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SzT() {
        int iFQ;
        int i = this.BF.ML;
        if (i == 2 || i == 1) {
            iFQ = com.bytedance.sdk.openadsdk.core.aBv.ZZv().FQ() * 1000;
        } else {
            iFQ = i == 4 ? com.bytedance.sdk.openadsdk.core.aBv.ZZv().Bzk(String.valueOf(this.SzT)) : 5000;
        }
        this.KZx.removeCallbacks(this.FQ);
        this.KZx.postDelayed(this.FQ, iFQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ() {
        if (this.SD == null) {
            return;
        }
        this.KZx.removeCallbacks(this.FQ);
        this.SD.Og();
        this.Vgu = System.currentTimeMillis() - this.gbA;
        if (!this.CIG) {
            this.CIG = true;
            Og(this.Mc, this.Mc);
            long j = this.Mc;
            this.Bzk = j;
            this.SGo = j;
            Og(this.qmB);
        }
        if (this.eG != null) {
            this.eG.pA(this.Vgu, com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(this.Bzk, this.Mc));
        }
        this.Sn = true;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og() {
        if (this.SD != null) {
            this.SD.pA();
            this.SD.DX();
            this.SD.XT();
        }
        new Object[]{"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.Wx)};
        if (this.JG != null) {
            if (this.JG.SD()) {
                if (this.Wx) {
                    if (Bzk.TX()) {
                        this.JG.Og(3);
                        this.JG.pA(false, this.JG.aBv(), this.oX);
                    } else {
                        Sd();
                    }
                } else {
                    Og(this.IG);
                }
                new Object[]{"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.Wx)};
            } else {
                this.JG.pA(false, this.Bzk, this.oX);
            }
        }
        if (this.CIG || !this.vZF.get()) {
            return;
        }
        eG();
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = this.omh.dGZ();
        if (pAVarDGZ == null || pAVarDGZ.pA() == null) {
            return;
        }
        pAVarDGZ.pA().KZx(ML());
    }

    public void xy() {
        if (this.CIG || !this.vZF.get()) {
            return;
        }
        eG();
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = this.omh.dGZ();
        if (pAVarDGZ == null || pAVarDGZ.pA() == null) {
            return;
        }
        pAVarDGZ.pA().KZx(ML());
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx() {
        if (this.JG == null) {
            return;
        }
        this.JG.WV();
        this.JG = null;
        if (this.SD != null) {
            this.SD.Bzk();
        }
        this.KZx.removeCallbacks(this.FQ);
        this.KZx.removeCallbacksAndMessages(null);
        if (this.roi != null) {
            this.roi.ZZv();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(boolean z, int i) {
        KZx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ZZv() {
        KZx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gx() {
        return this.omh.slz() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(float f, float f2) {
        try {
            if (qmB() != null && this.JG != null && this.TV != null) {
                float width = this.TV.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.TV.getHeight();
                if (f3 <= f2 / (1.0f * height)) {
                    width = f * (height / f2);
                } else {
                    height = f2 * (width / f);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (qmB() instanceof TextureView) {
                    ((TextureView) qmB()).setLayoutParams(layoutParams);
                } else if (qmB() instanceof SurfaceView) {
                    ((SurfaceView) qmB()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            WV.pA(this.pA, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean Bf() {
        return qmB() == null || this.JG == null || (!com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.omh.du()) ? this.omh.CIG() != null : this.omh.FQ() != null) || this.omh.IG() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(float f, float f2) {
        try {
            new StringBuilder("changeVideoSize start.......slot=").append(this.omh.rB());
            if (Bf()) {
                return;
            }
            int[] iArrOg = Vgu.Og(com.bytedance.sdk.openadsdk.core.aBv.pA());
            boolean z = false;
            boolean z2 = this.omh.rtW() == 1;
            float f3 = iArrOg[0];
            float f4 = iArrOg[1];
            if (z2) {
                if (f > f2) {
                    pA(f3, f4, f, f2, true);
                    return;
                }
            } else if (f < f2) {
                pA(f3, f4, f, f2, false);
                return;
            }
            float f5 = f / f2;
            float f6 = f3 / f4;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f = (9.0f * f4) / 16.0f;
                    z = true;
                    f2 = f4;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f2 = (9.0f * f3) / 16.0f;
                z = true;
                f = f3;
            }
            if (z) {
                f3 = f;
                f4 = f2;
            }
            int i = (int) f3;
            int i2 = (int) f4;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(13);
            if (qmB() != null) {
                if (qmB() instanceof TextureView) {
                    ((TextureView) qmB()).setLayoutParams(layoutParams);
                } else if (qmB() instanceof SurfaceView) {
                    ((SurfaceView) qmB()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.TV.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i2;
                    layoutParams2.width = i;
                    this.TV.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            WV.pA(this.pA, "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(float f, float f2) {
        try {
            if (qmB() != null && this.JG != null) {
                boolean z = this.omh.rtW() == 1;
                int[] iArrOg = Vgu.Og(com.bytedance.sdk.openadsdk.core.aBv.pA());
                pA(iArrOg[0], iArrOg[1], f, f2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void pA(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = this.omh.Bf().KZx();
                f4 = this.omh.Bf().Og();
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            if (qmB() != null) {
                if (qmB() instanceof TextureView) {
                    ((TextureView) qmB()).setLayoutParams(layoutParams);
                } else if (qmB() instanceof SurfaceView) {
                    ((SurfaceView) qmB()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.TV.getLayoutParams();
                if (!com.bytedance.sdk.component.adexpress.ZZv.Og.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()) || this.TV.getHeight() <= 0 || layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.TV.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.pA
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view) {
        if (this.JG == null) {
            return;
        }
        if (this.JG.JG()) {
            pA();
            this.SD.Og(true, false);
            this.SD.JG();
        } else {
            if (!this.JG.SD()) {
                if (this.SD != null) {
                    this.SD.KZx(this.TV);
                }
                ZZv(this.Bzk);
                if (this.SD != null) {
                    this.SD.Og(false, false);
                    return;
                }
                return;
            }
            Og();
            if (this.SD != null) {
                this.SD.Og(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(final long j, final long j2) {
        this.omh.KZx(j);
        this.Bzk = j;
        this.Mc = j2;
        final int iPA = com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j, j2);
        this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.4
            @Override // java.lang.Runnable
            public void run() {
                pA.this.SD.pA(j, j2);
                pA.this.SD.pA(iPA);
                try {
                    if (pA.this.eG != null) {
                        pA.this.eG.pA(j, j2);
                    }
                } catch (Throwable th) {
                    WV.pA(pA.this.pA, "onProgressUpdate error: ", th);
                }
            }
        });
    }

    public com.bykv.vk.openvk.pA.pA.pA.JG.Og qmB() {
        if (this.SD != null) {
            return this.SD.Wx();
        }
        return null;
    }

    public void gbA() {
        if (this.roi != null) {
            this.roi.pA(2);
        }
    }

    public void Vgu() {
        if (this.roi != null) {
            this.roi.pA(13);
        }
    }

    public void pA(InterfaceC0240pA interfaceC0240pA) {
        this.Gx = interfaceC0240pA;
    }
}
