package com.bytedance.sdk.openadsdk.core.Wx.Og;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.Wx.Sn;
import com.bytedance.sdk.openadsdk.Wx.Wx;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class KZx extends com.bytedance.sdk.openadsdk.core.Wx.pA.pA {
    private int Bf;
    private boolean CIG;
    private WeakReference<pA> FQ;
    private int Gx;
    private SD HSv;
    private Og JBA;
    private WeakReference<com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv> SzT;
    private final boolean Vgu;
    private int YkC;
    private final com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA agB;
    private boolean dC;
    private final Runnable dmv;
    private final BF.pA fJy;
    private int fN;
    private final boolean gbA;
    private long lT;
    private final String qmB;
    private long rB;
    private final boolean xy;

    public interface pA {
        void JG();

        void pA(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KZx(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public void SD(boolean z) {
        this.CIG = z;
    }

    public void pA(final JG.pA pAVar) {
        if (!this.DX || this.SD == null) {
            return;
        }
        this.SD.pA(new JG.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.2
            @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA
            public void pA(View view, int i) {
                JG.pA pAVar2 = pAVar;
                if (pAVar2 != null) {
                    pAVar2.pA(view, i);
                }
            }
        });
    }

    public void pA(PAGNativeAd pAGNativeAd) {
        if (!this.DX || this.SD == null) {
            return;
        }
        this.SD.pA(pAGNativeAd);
    }

    public void pA(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.Gx = i;
        this.Bf = i2;
    }

    public void pA(Og og) {
        this.JBA = og;
    }

    private void pA(Context context) {
        ViewGroup wx;
        if (this.DX) {
            wx = new Sn(context);
        } else {
            wx = new Wx(context);
        }
        ViewGroup viewGroup = wx;
        if (this.DX) {
            this.SD = new ML(context, viewGroup, true, 17, this.omh, this, BF());
        } else {
            this.SD = new ZZv(context, viewGroup, true, 17, this.omh, this, false);
        }
        this.SD.pA(this);
    }

    public KZx(Context context, ViewGroup viewGroup, yFO yfo, String str, boolean z, boolean z2, boolean z3, SD sd) {
        super(context, yfo, viewGroup);
        this.lT = 0L;
        this.rB = 0L;
        this.CIG = true;
        this.Gx = 0;
        this.Bf = 0;
        this.agB = new com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1
            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void KZx(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 5);
                            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(KZx.this.omh, 5);
                            if (KZx.this.roi != null) {
                                KZx.this.roi.pA(9);
                            }
                        } catch (Exception unused) {
                        }
                        KZx.this.qmB();
                    }
                });
                if (KZx.this.omh.dGZ() == null || KZx.this.omh.dGZ().pA() == null) {
                    return;
                }
                KZx.this.omh.dGZ().pA().ZZv(KZx.this.Bzk);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, long j) {
                KZx.this.WQf = false;
                KZx.this.KZx.removeCallbacks(KZx.this.dmv);
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KZx.this.SD != null) {
                            KZx.this.SD.Og();
                        }
                        if (!KZx.this.DX || KZx.this.FQ == null || KZx.this.FQ.get() == null) {
                            return;
                        }
                        ((pA) KZx.this.FQ.get()).JG();
                    }
                });
                KZx.this.lT();
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 0);
                if (KZx.this.roi != null) {
                    KZx.this.roi.KZx();
                }
                KZx kZx = KZx.this;
                kZx.pA(kZx.HSv);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
                KZx.this.KZx.removeCallbacks(KZx.this.dmv);
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KZx.this.SzT != null && KZx.this.SzT.get() != null) {
                            KZx.this.SzT.get();
                        }
                        if (KZx.this.SD != null) {
                            KZx.this.SD.Og();
                        }
                    }
                });
                if (KZx.this.xy) {
                    return;
                }
                KZx kZx = KZx.this;
                kZx.pA(kZx.HSv);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, final com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar2) {
                WV.pA(KZx.this.pA, "onError: " + pAVar2.pA() + ", " + pAVar2.Og() + ", " + pAVar2.KZx());
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int iPA = pAVar2.pA();
                        int iOg = pAVar2.Og();
                        if (!KZx.this.du() || iOg == -1004) {
                            if (KZx.this.KZx(iPA, iOg)) {
                                WV.pA(KZx.this.pA, "Play video error，show result page、、、、、、、");
                                KZx.this.SD.pA2(KZx.this.omh, (WeakReference<Context>) null, false);
                                KZx.this.KZx(true);
                                KZx.this.ZZv();
                            }
                            if (KZx.this.SD != null) {
                                KZx.this.SD.Og();
                            }
                            if (KZx.this.eG != null) {
                                KZx.this.eG.Og(KZx.this.rB, com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(KZx.this.Bzk, KZx.this.Mc));
                            }
                            if (KZx.this.SzT == null || KZx.this.SzT.get() == null || KZx.this.du()) {
                                return;
                            }
                            ((com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv) KZx.this.SzT.get()).pA(iPA, iOg);
                        }
                    }
                });
                KZx.this.pA(pAVar2);
                com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = KZx.this.omh.dGZ();
                if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                    pAVarDGZ.pA().pA(com.bytedance.sdk.openadsdk.core.WV.pA.pA.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 6);
                com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(KZx.this.omh);
                if (KZx.this.roi != null) {
                    KZx.this.roi.pA(14);
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, boolean z4) {
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KZx.this.SD != null) {
                            KZx.this.SD.Og();
                        }
                    }
                });
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2) {
                com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.Vgu();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2, int i3) {
                KZx.this.WQf = true;
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KZx.this.SD != null) {
                            KZx.this.SD.aBv();
                            KZx.this.KZx.postDelayed(KZx.this.dmv, RtspMediaSource.DEFAULT_TIMEOUT_MS);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 2);
                if (KZx.this.roi != null) {
                    KZx.this.roi.pA(4);
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
                KZx.this.WQf = false;
                KZx.this.KZx.removeCallbacks(KZx.this.dmv);
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.SD.Og();
                    }
                });
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 0);
                if (KZx.this.roi != null) {
                    KZx.this.roi.pA(5);
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, final long j, final long j2) {
                if (Math.abs(j - KZx.this.Bzk) < 50) {
                    return;
                }
                KZx kZx = KZx.this;
                kZx.pA(kZx.HSv);
                KZx.this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.pA(j, j2);
                        KZx.this.Og(j, j2);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void ZZv(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
                com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = KZx.this.omh.dGZ();
                if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                    pAVarDGZ.pA().Og(KZx.this.Bzk);
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(KZx.this.omh, 3);
                if (KZx.this.roi != null) {
                    KZx.this.roi.pA(0);
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
            public void ML(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
                com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = KZx.this.omh.dGZ();
                if (pAVarDGZ != null && pAVarDGZ.pA() != null) {
                    pAVarDGZ.pA().KZx(KZx.this.Bzk);
                }
                if (KZx.this.roi != null) {
                    KZx.this.roi.pA(1);
                }
            }
        };
        this.fN = 0;
        this.dmv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.4
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.SD != null) {
                    KZx.this.SD.pA2(KZx.this.omh, (WeakReference<Context>) null, false);
                    KZx.this.SD.Og();
                    KZx.this.KZx(true);
                    WV.pA(KZx.this.pA, "Show result page after error.......showAdCard");
                }
            }
        };
        this.fJy = new BF.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.6
            @Override // com.bytedance.sdk.component.utils.BF.pA
            public void pA(Context context2, Intent intent, boolean z4, final int i) {
                xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.ML(i);
                    }
                });
            }
        };
        this.dC = false;
        this.YkC = DX.KZx(context);
        pA(z);
        this.qmB = str;
        try {
            this.Gx = viewGroup.getWidth();
            this.Bf = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        pA(context);
        this.xy = true;
        this.gbA = z2;
        this.Vgu = z3;
        if (sd != null) {
            this.HSv = sd;
        }
    }

    public com.bytedance.sdk.openadsdk.core.WV.JG pA(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.omh.rjD()) {
            return null;
        }
        if (this.roi == null) {
            this.roi = com.bytedance.sdk.openadsdk.core.WV.JG.pA();
        }
        this.roi.pA(view, this.omh.dGZ().Sn());
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    this.roi.pA((View) pair.first, pair.second == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) pair.second);
                }
            }
        }
        return this.roi;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.pA.pA, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv zZv) {
        this.SzT = new WeakReference<>(zZv);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (this.JG != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(kZx.Wx())) {
            WV.pA(this.pA, "[video] play video stop , because no video info");
            return false;
        }
        KZx(false);
        kZx.Wx();
        Og(kZx);
        Mc();
        if (this.roi != null) {
            this.roi.pA(false, 0.0f);
        }
        if (!WQf.Og(this.qmB) || this.Bzk <= 0) {
            this.Bzk = kZx.SD();
        }
        if (kZx.SD() <= 0) {
            this.Sd = false;
            this.vZF.set(false);
        } else {
            this.Bzk = kZx.SD();
            this.SGo = Math.max(this.SGo, this.Bzk);
        }
        if (this.SD != null) {
            this.SD.pA();
            if (this.fN == 0) {
                this.SD.SD();
            }
            this.SD.KZx(kZx.ML(), kZx.JG());
            this.SD.KZx(this.TV);
            this.SD.pA(kZx.ML(), kZx.JG());
        }
        if (this.JG == null) {
            this.JG = new com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx();
            this.JG.pA(this.agB);
        }
        yFO();
        this.rB = 0L;
        try {
            KZx(kZx);
            return true;
        } catch (Exception e) {
            pA(new com.bykv.vk.openvk.pA.pA.pA.KZx.pA(-10, 0, e.getMessage()));
            WV.pA(this.pA, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e)));
            return false;
        }
    }

    private void KZx(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        kZx.KZx(0);
        this.JG.pA(kZx);
        this.lT = System.currentTimeMillis();
        this.SD.KZx(8);
        this.SD.KZx(0);
        pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.3
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.JG == null) {
                    return;
                }
                KZx.this.lT = System.currentTimeMillis();
                KZx.this.SD.ZZv(0);
                KZx.this.JG.pA(true, KZx.this.Bzk, KZx.this.oX);
            }
        });
        if (this.DX) {
            XT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qmB() {
        this.fN++;
        if (this.SD == null) {
            return;
        }
        this.SD.Og();
        if (this.eG != null) {
            this.eG.pA(this.rB, com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(this.Bzk, this.Mc));
        }
        this.rB = System.currentTimeMillis() - this.lT;
        if (this.CIG) {
            this.SD.pA2(this.omh, (WeakReference<Context>) null, true);
        }
        if (!this.Sd) {
            this.Sd = true;
            Og(this.Mc, this.Mc);
            long j = this.Mc;
            this.Bzk = j;
            this.SGo = j;
            Og(this.HSv);
        }
        if (!this.DX && this.yFO) {
            ML(this.SD, null);
        }
        this.Sn = true;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og() {
        if (this.SD != null) {
            this.SD.pA();
        }
        if (this.SD != null) {
            this.SD.XT();
        }
        gbA();
    }

    public void omh(boolean z) {
        if (this.SD != null) {
            this.SD.pA();
        }
        if (this.SD != null && z) {
            this.SD.XT();
        }
        gbA();
    }

    private void gbA() {
        new Object[]{"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.Wx)};
        if (this.JG != null) {
            if (this.JG.SD()) {
                if (this.Wx) {
                    Sd();
                } else {
                    Og(this.IG);
                }
                new Object[]{"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.Wx)};
            } else {
                this.JG.pA(false, this.Bzk, this.oX);
            }
        }
        if (this.vZF.get()) {
            eG();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx() {
        pA(true, 3);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(boolean z, int i) {
        if (!this.Sd && this.vZF.get()) {
            if (z) {
                com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA pAVar = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA();
                pAVar.pA(ML());
                pAVar.KZx(omh());
                pAVar.Og(JG());
                pAVar.KZx(i);
                pAVar.ZZv(SD());
                com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.SD, pAVar, this.HSv);
                this.Sd = false;
            } else {
                roi();
            }
        }
        ZZv();
        if (this.roi != null) {
            this.roi.ZZv();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ZZv() {
        if (this.JG != null) {
            this.JG.WV();
            this.JG = null;
        }
        if (this.CIG) {
            if (!"embeded_ad".equals(this.qmB)) {
                this.SD.pA2(this.omh, (WeakReference<Context>) null, true);
            } else {
                this.SD.vZF();
            }
            this.KZx.removeCallbacksAndMessages(null);
            this.WV.clear();
            if (this.DX) {
                rB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vgu() {
        int i;
        int i2;
        try {
            if (CIG() != null && this.JG != null && this.TV != null) {
                int iZZv = this.JG.ZZv();
                int iML = this.JG.ML();
                final int width = this.TV.getWidth();
                final int height = this.TV.getHeight();
                if (width > 0 && height > 0 && iML > 0 && iZZv > 0) {
                    if (iZZv == iML) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (iZZv > iML) {
                        i2 = (int) ((((double) width) * 1.0d) / ((double) ((iZZv * 1.0f) / iML)));
                        i = width;
                    } else {
                        i = (int) ((((double) height) * 1.0d) / ((double) ((iML * 1.0f) / iZZv)));
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    if (i <= width && i > 0) {
                        width = i;
                    }
                    this.KZx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (KZx.this.CIG() instanceof TextureView) {
                                    ((TextureView) KZx.this.CIG()).setLayoutParams(layoutParams);
                                    String unused = KZx.this.pA;
                                } else if (KZx.this.CIG() instanceof SurfaceView) {
                                    ((SurfaceView) KZx.this.CIG()).setLayoutParams(layoutParams);
                                    String unused2 = KZx.this.pA;
                                }
                            } catch (Throwable unused3) {
                                String unused4 = KZx.this.pA;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            new StringBuilder("[step-1] >>>>> mContextRef=").append(this.BSW).append(",getIRenderView() =").append(CIG());
            com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx = this.JG;
            com.bytedance.sdk.openadsdk.core.Wx.ZZv.KZx kZx2 = this.JG;
        } catch (Throwable th) {
            new StringBuilder("[step-11] >>>>> changeVideoSize error !!!!! ：").append(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.pA.pA.pA.JG.Og CIG() {
        if (this.BSW.getResources().getConfiguration().orientation != 1 || this.SD == null) {
            return null;
        }
        return this.SD.Wx();
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
            omh(false);
            if (this.SD != null) {
                this.SD.Og(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(long j, long j2) {
        this.omh.KZx(j);
        this.Bzk = j;
        this.Mc = j2;
        this.SD.pA(j, j2);
        this.SD.pA(com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j, j2));
        try {
            if (this.eG != null) {
                this.eG.pA(j, j2);
            }
        } catch (Throwable th) {
            WV.pA(this.pA, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = this.omh.dGZ();
        if (pAVarDGZ == null || pAVarDGZ.pA() == null) {
            return;
        }
        pAVarDGZ.pA().pA(j, j2, this.roi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.pA.pA
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og, View view, boolean z) {
        JG(!this.yFO);
        if (this.BSW instanceof Activity) {
            if (this.SD != null) {
                this.SD.Og(this.TV);
                this.SD.KZx(false);
            }
            pA(1);
            com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.Og og2 = this.du != null ? this.du.get() : null;
            if (og2 != null) {
                og2.pA(this.yFO);
            }
        }
    }

    private boolean Og(int i, int i2) {
        if (i2 == 0) {
            pA();
            this.aBv = true;
            if (this.SD != null) {
                this.SD.pA2(this.omh, (WeakReference<Context>) null, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            if (this.SD != null) {
                this.SD.pA();
            }
            pA();
            this.aBv = true;
            this.XT = false;
            if (this.SD != null) {
                return this.SD.pA(i, this.omh.Bf(), this.Vgu);
            }
        } else if (i2 == 4) {
            this.aBv = false;
            if (this.SD != null) {
                this.SD.DX();
            }
        }
        return true;
    }

    private void ZZv(int i) {
        if (this.YkC == i) {
            return;
        }
        this.YkC = i;
        if (i != 4 && i != 0) {
            this.XT = false;
        }
        if (!this.XT && !DX() && this.gbA) {
            Og(2, i);
        }
        WeakReference<pA> weakReference = this.FQ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.FQ.get().pA(this.YkC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML(int i) {
        ZZv(i);
        if (i == 4) {
            this.aBv = false;
        }
    }

    public void KZx(int i) {
        ZZv(i);
        if (i == 4) {
            this.aBv = false;
            Og();
        }
    }

    public void XT() {
        if (this.dC || !this.TX) {
            return;
        }
        Context applicationContext = aBv.pA().getApplicationContext();
        this.dC = true;
        BF.pA(this.fJy, applicationContext);
    }

    public void rB() {
        if (this.dC && this.TX) {
            this.dC = false;
            BF.pA(this.fJy);
        }
    }

    public void pA(pA pAVar) {
        this.FQ = new WeakReference<>(pAVar);
    }

    public void xy() {
        if (this.roi != null) {
            this.roi.pA(13);
        }
    }
}
