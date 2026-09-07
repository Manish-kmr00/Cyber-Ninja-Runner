package com.bytedance.sdk.component.ML.KZx;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ML.TX;
import com.bytedance.sdk.component.ML.WV;
import com.bytedance.sdk.component.ML.Wx;
import com.bytedance.sdk.component.ML.XT;
import com.bytedance.sdk.component.ML.aBv;
import com.bytedance.sdk.component.ML.yFO;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes7.dex */
public class JG {
    private aBv Bzk;
    private com.bytedance.sdk.component.ML.ZZv JG;
    private final Wx Og;
    private WV SD;
    private ExecutorService omh;
    private Map<String, List<KZx>> pA = new ConcurrentHashMap();
    private Map<String, XT> KZx = new HashMap();
    private Map<String, yFO> ZZv = new HashMap();
    private Map<String, com.bytedance.sdk.component.ML.KZx> ML = new HashMap();

    public JG(Context context, Wx wx) {
        this.Og = (Wx) omh.pA(wx);
        com.bytedance.sdk.component.ML.KZx.pA.pA.pA(context, wx.Bzk());
    }

    public Collection<XT> pA() {
        return this.KZx.values();
    }

    public Collection<yFO> Og() {
        return this.ZZv.values();
    }

    public Collection<com.bytedance.sdk.component.ML.KZx> KZx() {
        return this.ML.values();
    }

    public XT pA(com.bytedance.sdk.component.ML.Og og) {
        if (og == null) {
            og = com.bytedance.sdk.component.ML.KZx.pA.pA.SD();
        }
        String string = og.ML().toString();
        XT xt = this.KZx.get(string);
        if (xt != null) {
            return xt;
        }
        XT xtZZv = ZZv(og);
        this.KZx.put(string, xtZZv);
        return xtZZv;
    }

    private XT ZZv(com.bytedance.sdk.component.ML.Og og) {
        XT xtML = this.Og.ML();
        if (xtML != null) {
            return com.bytedance.sdk.component.ML.KZx.pA.Og.pA.pA(xtML);
        }
        return com.bytedance.sdk.component.ML.KZx.pA.Og.pA.pA(og.Og());
    }

    public yFO Og(com.bytedance.sdk.component.ML.Og og) {
        if (og == null) {
            og = com.bytedance.sdk.component.ML.KZx.pA.pA.SD();
        }
        String string = og.ML().toString();
        yFO yfo = this.ZZv.get(string);
        if (yfo != null) {
            return yfo;
        }
        yFO yfoML = ML(og);
        this.ZZv.put(string, yfoML);
        return yfoML;
    }

    private yFO ML(com.bytedance.sdk.component.ML.Og og) {
        yFO yfoJG = this.Og.JG();
        return yfoJG != null ? yfoJG : com.bytedance.sdk.component.ML.KZx.pA.Og.ML.pA(og.Og());
    }

    public com.bytedance.sdk.component.ML.KZx KZx(com.bytedance.sdk.component.ML.Og og) {
        if (og == null) {
            og = com.bytedance.sdk.component.ML.KZx.pA.pA.SD();
        }
        String string = og.ML().toString();
        com.bytedance.sdk.component.ML.KZx kZx = this.ML.get(string);
        if (kZx != null) {
            return kZx;
        }
        com.bytedance.sdk.component.ML.KZx kZxJG = JG(og);
        this.ML.put(string, kZxJG);
        return kZxJG;
    }

    public com.bytedance.sdk.component.ML.KZx pA(String str) {
        return KZx(com.bytedance.sdk.component.ML.KZx.pA.pA.pA(new File(str)));
    }

    private com.bytedance.sdk.component.ML.KZx JG(com.bytedance.sdk.component.ML.Og og) {
        com.bytedance.sdk.component.ML.KZx kZxSD = this.Og.SD();
        return kZxSD != null ? kZxSD : new com.bytedance.sdk.component.ML.KZx.pA.pA.Og(og.ML(), og.pA(), JG());
    }

    public com.bytedance.sdk.component.ML.ZZv ZZv() {
        if (this.JG == null) {
            this.JG = Bzk();
        }
        return this.JG;
    }

    private com.bytedance.sdk.component.ML.ZZv Bzk() {
        com.bytedance.sdk.component.ML.ZZv ZZv = this.Og.ZZv();
        return ZZv == null ? com.bytedance.sdk.component.ML.Og.Og.pA() : ZZv;
    }

    public WV ML() {
        if (this.SD == null) {
            this.SD = SGo();
        }
        return this.SD;
    }

    private WV SGo() {
        WV wvPA = this.Og.pA();
        return wvPA != null ? wvPA : com.bytedance.sdk.component.ML.pA.Og.pA();
    }

    public ExecutorService JG() {
        ExecutorService executorServicePA;
        TX txKZx = this.Og.KZx();
        if (txKZx != null && (executorServicePA = txKZx.pA()) != null) {
            return executorServicePA;
        }
        if (this.omh == null) {
            this.omh = BSW();
        }
        return this.omh;
    }

    private ExecutorService BSW() {
        ExecutorService executorServiceOg = this.Og.Og();
        return executorServiceOg != null ? executorServiceOg : com.bytedance.sdk.component.ML.pA.KZx.pA();
    }

    public Map<String, List<KZx>> SD() {
        return this.pA;
    }

    public com.bytedance.sdk.component.ML.KZx.Og.pA pA(KZx kZx) {
        ImageView.ScaleType scaleTypeZZv = kZx.ZZv();
        if (scaleTypeZZv == null) {
            scaleTypeZZv = com.bytedance.sdk.component.ML.KZx.Og.pA.pA;
        }
        ImageView.ScaleType scaleType = scaleTypeZZv;
        Bitmap.Config configBSW = kZx.BSW();
        if (configBSW == null) {
            configBSW = com.bytedance.sdk.component.ML.KZx.Og.pA.Og;
        }
        return new com.bytedance.sdk.component.ML.KZx.Og.pA(kZx.Og(), kZx.KZx(), scaleType, configBSW, kZx.SD(), kZx.omh());
    }

    public aBv omh() {
        if (this.Bzk == null) {
            this.Bzk = WV();
        }
        return this.Bzk;
    }

    private aBv WV() {
        aBv abvOmh = this.Og.omh();
        return abvOmh == null ? new SD() : abvOmh;
    }
}
