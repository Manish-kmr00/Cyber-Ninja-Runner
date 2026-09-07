package com.bytedance.sdk.openadsdk.core.Og;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.SGo;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Og extends KZx {
    private static int qmB = Integer.MIN_VALUE;
    protected SGo BSW;
    protected WeakReference<View> Bzk;
    protected boolean DX;
    protected final yFO JG;
    private boolean KZx;
    public Sn ML;
    private WeakReference<Activity> Og;
    protected final String SD;
    protected WeakReference<View> SGo;
    protected com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx Sn;
    protected pA WV;
    protected PAGNativeAd Wx;
    protected PangleAd XT;
    protected Context ZZv;
    protected Map<String, Object> aBv;
    protected com.bytedance.sdk.openadsdk.XT.pA.pA.JG oX;
    protected final int omh;
    private String pA;
    protected int vZF;
    protected com.bytedance.sdk.openadsdk.core.omh.Og yFO;

    public interface pA {
        void pA(View view, int i);
    }

    public boolean pA(SGo sGo, Map<String, Object> map) {
        return false;
    }

    public void pA(com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg) {
        this.oX = jg;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.omh.Og og) {
        this.yFO = og;
    }

    public void pA(PAGNativeAd pAGNativeAd) {
        this.Wx = pAGNativeAd;
    }

    public void pA(PangleAd pangleAd) {
        this.XT = pangleAd;
    }

    public void ML(boolean z) {
        this.DX = z;
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx) {
        this.Sn = kZx;
    }

    public Og(Context context, yFO yfo, String str, int i) {
        this.DX = false;
        this.vZF = 0;
        this.KZx = false;
        this.ZZv = context;
        this.JG = yfo;
        this.SD = str;
        this.omh = i;
    }

    public Og(Context context, yFO yfo, String str, int i, boolean z) {
        this(context, yfo, str, i);
        this.KZx = z;
    }

    public void pA(pA pAVar) {
        this.WV = pAVar;
    }

    public void pA(Activity activity) {
        if (activity == null) {
            return;
        }
        this.Og = new WeakReference<>(activity);
    }

    public void pA(View view) {
        if (view == null) {
            return;
        }
        this.Bzk = new WeakReference<>(view);
    }

    public void Og(View view) {
        if (view == null) {
            return;
        }
        this.SGo = new WeakReference<>(view);
    }

    public View ZZv() {
        WeakReference<Activity> weakReference = this.Og;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.Og.get().findViewById(R.id.content);
    }

    public View ML() {
        WeakReference<Activity> weakReference = this.Og;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View viewFindViewById = this.Og.get().findViewById(520093713);
        return viewFindViewById == null ? this.Og.get().findViewById(520093713) : viewFindViewById;
    }

    public void pA(Map<String, Object> map) {
        Map<String, Object> map2 = this.aBv;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.aBv);
        }
        this.aBv = map;
    }

    public void pA(int i) {
        this.Mc = i;
    }

    public void Og(int i) {
        this.roi = i;
    }

    public void KZx(int i) {
        this.eG = i;
    }

    public void ZZv(int i) {
        this.vZF = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.KZx
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        int i;
        boolean z2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        yFO yfo;
        if (this.ZZv == null) {
            this.ZZv = aBv.pA();
        }
        if ((this.KZx || !pA(view, 1, f, f2, f3, f4, sparseArray, z)) && this.ZZv != null) {
            Sn sn = this.ML;
            if (sn != null) {
                i = sn.WV;
                jSONObject = this.ML.Wx;
                jSONObject2 = this.ML.aBv;
                z2 = this.ML.XT;
            } else {
                i = -1;
                z2 = false;
                jSONObject = null;
                jSONObject2 = null;
            }
            long j = this.TV;
            long j2 = this.du;
            WeakReference<View> weakReference = this.Bzk;
            View view2 = weakReference == null ? null : weakReference.get();
            WeakReference<View> weakReference2 = this.SGo;
            SGo sGoPA = pA(f, f2, f3, f4, sparseArray, j, j2, view2, weakReference2 == null ? null : weakReference2.get(), JG(), Vgu.ML(this.ZZv), Vgu.SD(this.ZZv), Vgu.JG(this.ZZv), i, jSONObject, jSONObject2);
            this.BSW = sGoPA;
            if (pA(sGoPA, this.aBv)) {
                return;
            }
            if (this.Sn != null) {
                if (this.aBv == null) {
                    this.aBv = new HashMap();
                }
                this.aBv.put("duration", Long.valueOf(this.Sn.ML()));
            }
            if (this.KZx || z2) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, true, this.aBv, z ? 1 : 2);
                return;
            }
            pA pAVar = this.WV;
            if (pAVar != null) {
                pAVar.pA(view, -1);
            }
            if (pA(view, z)) {
                boolean zOg = WQf.Og(this.JG);
                String strPA = zOg ? this.SD : gbA.pA(this.omh);
                if (view != null) {
                    try {
                        Boolean bool = (Boolean) view.getTag(520093762);
                        if (bool.booleanValue()) {
                            rB.pA(true);
                        }
                    } catch (Exception unused) {
                    }
                }
                Activity activityPA = view != null ? com.bytedance.sdk.component.utils.Og.pA(view) : null;
                boolean zPA = rB.pA(activityPA == null ? this.ZZv : activityPA, this.JG, this.omh, this.Wx, this.XT, strPA, this.oX, zOg, 0);
                rB.pA(false);
                if (zPA || (yfo = this.JG) == null || yfo.Itl() == null || this.JG.Itl().KZx() != 2) {
                    yFO yfo2 = this.JG;
                    if (yfo2 != null && !zPA && TextUtils.isEmpty(yfo2.dC()) && com.bytedance.sdk.openadsdk.ZZv.Og.pA(this.SD)) {
                        com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.ZZv, this.JG, this.SD).ZZv();
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, zPA, this.aBv, z ? 1 : 2);
                }
            }
        }
    }

    public boolean pA(View view, boolean z) {
        return pA(view, this.JG, z);
    }

    public static boolean pA(View view, yFO yfo, boolean z) {
        if (view != null && yfo != null) {
            try {
                String strValueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.pA.vZF));
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.pA.vZF) != null && !TextUtils.isEmpty(strValueOf)) {
                    if ("click".equals(strValueOf)) {
                        return z;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (KZx(view)) {
                return yfo.vZF() != 1 || z;
            }
            if (yfo.yFO() == 1 && !z) {
                return false;
            }
        }
        return true;
    }

    protected SGo pA(float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
        return new SGo.pA().JG(f).ML(f2).ZZv(f3).KZx(f4).Og(j).pA(j2).Og(Vgu.pA(view)).pA(Vgu.pA(view2)).KZx(Vgu.KZx(view)).ZZv(Vgu.KZx(view2)).ZZv(this.eG).ML(this.roi).JG(this.Mc).pA(sparseArray).Og(Bzk.Og().pA() ? 1 : 2).pA(str).pA(f5).KZx(i).Og(f6).pA(i2).pA(jSONObject).Og(jSONObject2).pA();
    }

    protected boolean pA(View view, int i, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        if (this.yFO == null) {
            return false;
        }
        int[] iArrPA = new int[2];
        int[] iArrKZx = new int[2];
        WeakReference<View> weakReference = this.SGo;
        if (weakReference != null) {
            iArrPA = Vgu.pA(weakReference.get());
            iArrKZx = Vgu.KZx(this.SGo.get());
        }
        this.yFO.pA(view, i, new Sn.pA().ZZv(f).KZx(f2).Og(f3).pA(f4).Og(this.TV).pA(this.du).KZx(iArrPA[0]).ZZv(iArrPA[1]).ML(iArrKZx[0]).JG(iArrKZx[1]).pA(sparseArray).pA(z).pA());
        return true;
    }

    public static boolean KZx(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || pA(view.getContext()) == view.getId() || com.bytedance.sdk.openadsdk.utils.Sn.jO == view.getId() || com.bytedance.sdk.openadsdk.utils.Sn.mM == view.getId();
    }

    private static int pA(Context context) {
        if (qmB == Integer.MIN_VALUE) {
            qmB = com.bytedance.sdk.component.utils.yFO.ML(context, "btn_native_creative");
        }
        return qmB;
    }

    public String JG() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }
}
