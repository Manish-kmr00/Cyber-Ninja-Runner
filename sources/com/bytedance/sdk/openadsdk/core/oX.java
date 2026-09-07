package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.utils.CIG;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class oX {
    private com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx BSW;
    private final String JG;
    private final Context KZx;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG Og;
    private com.bytedance.sdk.openadsdk.pA.Og.JG SD;
    private final com.bytedance.sdk.openadsdk.pA.Og.pA SGo;
    private com.bytedance.sdk.openadsdk.core.Og.pA Sn;
    private com.bytedance.sdk.openadsdk.core.Og.Og Wx;
    private final PAGNativeAd ZZv;
    private long omh;
    private final com.bytedance.sdk.openadsdk.core.model.yFO pA;
    private List<View> ML = new ArrayList();
    private final com.bytedance.sdk.openadsdk.ZZv.SD Bzk = new com.bytedance.sdk.openadsdk.ZZv.SD();
    private final AtomicBoolean WV = new AtomicBoolean(false);

    public com.bytedance.sdk.openadsdk.ZZv.SD pA() {
        return this.Bzk;
    }

    public oX(Context context, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, com.bytedance.sdk.openadsdk.pA.Og.pA pAVar) {
        this.ZZv = pAGNativeAd;
        this.pA = yfo;
        this.KZx = context;
        this.JG = str;
        this.SGo = pAVar;
        if (yfo.JBA() == 4) {
            this.Og = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(context, yfo, str);
        }
    }

    public void pA(View view, int i) {
        com.bytedance.sdk.openadsdk.pA.Og.JG jg = this.SD;
        if (jg != null) {
            jg.onAdClicked();
        }
    }

    public void pA(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.pA.Og.JG jg) {
        pA(viewGroup, list, list2, list3, jg);
        pA(viewGroup, view);
        pA(viewGroup, list2, list3);
    }

    private void pA(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.pA.Og.JG jg) {
        this.SD = jg;
        viewGroup.addOnLayoutChangeListener(new pA(this.Bzk, viewGroup));
        this.ML = list;
        pA(list2, (com.bytedance.sdk.openadsdk.core.Og.KZx) null);
        if (list != null) {
            for (View view : this.ML) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        pA(list3, (com.bytedance.sdk.openadsdk.core.Og.KZx) null);
    }

    private void pA(List<View> list, com.bytedance.sdk.openadsdk.core.Og.KZx kZx) {
        if (com.bytedance.sdk.component.utils.SGo.Og(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(kZx);
                    view.setOnTouchListener(kZx);
                }
            }
        }
    }

    private SD Og(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.pA.Og.JG jg) {
        this.SD = jg;
        viewGroup.addOnLayoutChangeListener(new pA(this.Bzk, viewGroup));
        this.ML = list;
        SD sdZZv = ZZv(viewGroup);
        if (sdZZv == null) {
            sdZZv = new SD(this.KZx, viewGroup);
            viewGroup.addView(sdZZv);
        }
        sdZZv.pA();
        sdZZv.setRefClickViews(list2);
        if (list != null) {
            for (View view : this.ML) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        sdZZv.setRefCreativeViews(list3);
        return sdZZv;
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx) {
        this.BSW = kZx;
        com.bytedance.sdk.openadsdk.core.Og.Og og = this.Wx;
        if (og != null) {
            og.pA(kZx);
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = this.Sn;
        if (pAVar != null) {
            pAVar.pA(kZx);
        }
    }

    private static class pA implements View.OnLayoutChangeListener {
        private final ViewGroup Og;
        private final com.bytedance.sdk.openadsdk.ZZv.SD pA;

        public pA(com.bytedance.sdk.openadsdk.ZZv.SD sd, ViewGroup viewGroup) {
            this.pA = sd;
            this.Og = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.pA.pA(System.currentTimeMillis(), lT.pA(this.Og));
        }
    }

    private void pA(ViewGroup viewGroup, View view) {
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        Context contextPA = viewGroup != null ? com.bytedance.sdk.component.utils.Og.pA(viewGroup) : null;
        if (contextPA == null) {
            contextPA = this.KZx;
        }
        if (this.pA.BF() == 2) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
            String str = this.JG;
            this.Wx = new com.bytedance.sdk.openadsdk.core.omh.Bzk(contextPA, yfo, str, gbA.pA(str));
        } else {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.pA;
            String str2 = this.JG;
            this.Wx = new com.bytedance.sdk.openadsdk.core.Og.Og(contextPA, yfo2, str2, gbA.pA(str2));
        }
        this.Wx.pA(viewGroup);
        this.Wx.pA(this.BSW);
        this.Wx.Og(view);
        this.Wx.pA(this.Og);
        this.Wx.pA(this.ZZv);
        this.Wx.pA(map);
        this.Wx.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.oX.1
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view2, int i) {
                if (oX.this.SD != null) {
                    oX.this.SD.onAdClicked();
                }
            }
        });
        if (this.pA.BF() == 2) {
            Context context = this.KZx;
            com.bytedance.sdk.openadsdk.core.model.yFO yfo3 = this.pA;
            String str3 = this.JG;
            this.Sn = new com.bytedance.sdk.openadsdk.core.omh.omh(context, yfo3, str3, gbA.pA(str3));
        } else {
            Context context2 = this.KZx;
            com.bytedance.sdk.openadsdk.core.model.yFO yfo4 = this.pA;
            String str4 = this.JG;
            this.Sn = new com.bytedance.sdk.openadsdk.core.Og.pA(context2, yfo4, str4, gbA.pA(str4));
        }
        this.Sn.pA(viewGroup);
        this.Sn.pA(this.BSW);
        this.Sn.Og(view);
        this.Sn.pA(this.Og);
        this.Sn.pA(this.ZZv);
        this.Sn.pA(map);
        this.Sn.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.oX.2
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view2, int i) {
                if (oX.this.SD != null) {
                    oX.this.SD.onAdClicked();
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(oX.this.pA, 9);
                oX.this.SGo.Wx();
            }
        });
    }

    private void pA(ViewGroup viewGroup, SD sd, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.Og.Og og = this.Wx;
        if (og == null || this.Sn == null) {
            return;
        }
        sd.pA(list, og);
        sd.pA(list2, this.Sn);
        pA(this.Wx, this.Sn);
        pA(sd, viewGroup);
    }

    private void pA(ViewGroup viewGroup, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.Og.Og og = this.Wx;
        if (og == null || this.Sn == null) {
            return;
        }
        pA(list, og);
        pA(list2, this.Sn);
        pA(this.Wx, this.Sn);
        pA(viewGroup);
    }

    private void pA(com.bytedance.sdk.openadsdk.core.Og.Og og, com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        if (this.pA.BF() == 2) {
            Og(og, pAVar);
        } else {
            pA(pAVar);
        }
    }

    private void Og(com.bytedance.sdk.openadsdk.core.Og.Og og, com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar2 = this.SGo;
        if (pAVar2 != null && pAVar2.Og() != null) {
            com.bytedance.sdk.openadsdk.core.omh.yFO yfoOg = this.SGo.Og();
            if ((og instanceof com.bytedance.sdk.openadsdk.core.omh.Bzk) && (pAVar instanceof com.bytedance.sdk.openadsdk.core.omh.omh)) {
                yfoOg.setClickListener((com.bytedance.sdk.openadsdk.core.omh.Bzk) og);
                yfoOg.setClickCreativeListener((com.bytedance.sdk.openadsdk.core.omh.omh) pAVar);
            }
            yfoOg.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.core.oX.3
                @Override // com.bytedance.sdk.openadsdk.core.widget.JG
                public void pA() {
                    if (oX.this.SD != null) {
                        oX.this.SD.onAdClicked();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar3 = this.SGo;
        if (pAVar3 != null && pAVar3.pA() != null) {
            this.SGo.pA().setOnClickListener(pAVar);
            this.SGo.pA().setOnTouchListener(pAVar);
        }
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar4 = this.SGo;
        if (pAVar4 != null) {
            pAVar4.pA(pAVar);
            this.SGo.pA(og);
        }
    }

    private void pA(com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().ZZv(String.valueOf(this.pA.Wf()))) {
            com.bytedance.sdk.openadsdk.pA.Og.pA pAVar2 = this.SGo;
            if (pAVar2 != null && pAVar2.pA() != null) {
                this.SGo.pA().setOnClickListener(pAVar);
                this.SGo.pA().setOnTouchListener(pAVar);
            }
            com.bytedance.sdk.openadsdk.pA.Og.pA pAVar3 = this.SGo;
            if (pAVar3 != null) {
                pAVar3.pA(pAVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar4 = this.SGo;
        if (pAVar4 != null && pAVar4.pA() != null) {
            PAGMediaView pAGMediaViewPA = this.SGo.pA();
            com.bytedance.sdk.openadsdk.core.Og.KZx kZx = new com.bytedance.sdk.openadsdk.core.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.core.oX.4
                @Override // com.bytedance.sdk.openadsdk.core.Og.KZx
                protected void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                    if (view instanceof PAGVideoMediaView) {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    }
                }
            };
            pAGMediaViewPA.setOnClickListener(kZx);
            pAGMediaViewPA.setOnTouchListener(kZx);
        }
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar5 = this.SGo;
        if (pAVar5 != null) {
            pAVar5.pA((com.bytedance.sdk.openadsdk.core.Og.pA) null);
        }
    }

    private void pA(SD sd, final ViewGroup viewGroup) {
        sd.setCallback(new SD.pA() { // from class: com.bytedance.sdk.openadsdk.core.oX.5
            @Override // com.bytedance.sdk.openadsdk.core.SD.pA
            public void pA(boolean z) {
                oX.this.pA(z, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.SD.pA
            public void pA() {
                oX.this.Og(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.SD.pA
            public void Og() {
                oX.this.Og();
            }

            @Override // com.bytedance.sdk.openadsdk.core.SD.pA
            @JProtect
            public void pA(View view) {
                oX.this.Og(viewGroup, view);
            }
        });
    }

    private void pA(final ViewGroup viewGroup) {
        CIG.pA(viewGroup, true, 5, new CIG.Og() { // from class: com.bytedance.sdk.openadsdk.core.oX.6
            @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
            public void pA(boolean z) {
                oX.this.pA(z, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
            public void pA() {
                oX.this.Og(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
            public void Og() {
                oX.this.Og();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
            public void pA(View view, boolean z) {
                if (!z) {
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(oX.this.pA, 8);
                } else {
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(oX.this.pA, 4);
                    oX.this.Og(viewGroup, view);
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z, ViewGroup viewGroup) {
        if (z && this.pA.Dc() && !this.pA.eUc()) {
            this.pA.SD(true);
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, this.JG, yfo.ZF());
        }
        if (!z && this.omh > 0) {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.omh);
            this.Bzk.pA(System.currentTimeMillis(), lT.pA(viewGroup));
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(strValueOf, this.pA, this.JG, this.Bzk);
            this.omh = 0L;
            return;
        }
        this.Bzk.pA(System.currentTimeMillis(), lT.pA(viewGroup));
        this.omh = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(ViewGroup viewGroup) {
        this.Bzk.pA(System.currentTimeMillis(), lT.pA(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        if (this.omh > 0) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(SystemClock.elapsedRealtime() - this.omh), this.pA, this.JG, this.Bzk);
            this.omh = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(ViewGroup viewGroup, View view) {
        if (this.WV.get()) {
            return;
        }
        this.WV.set(true);
        if (this.ZZv instanceof com.bytedance.sdk.openadsdk.pA.Og.pA.KZx) {
            com.bytedance.sdk.openadsdk.core.omh.yFO yfoOg = this.SGo.Og();
            if (yfoOg != null) {
                yfoOg.omh();
            }
            ((com.bytedance.sdk.openadsdk.pA.Og.pA.KZx) this.ZZv).pA(true);
        }
        this.Bzk.pA(System.currentTimeMillis(), lT.pA(viewGroup));
        this.omh = SystemClock.elapsedRealtime();
        KZx(viewGroup);
        com.bytedance.sdk.openadsdk.pA.Og.JG jg = this.SD;
        if (jg != null) {
            jg.pA(this.ZZv);
        }
        if (this.pA.sk()) {
            gbA.pA(this.pA, view);
        }
        if (this.pA.dGZ() != null) {
            this.pA.dGZ().pA().pA(0L);
        }
    }

    private void KZx(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ML != null) {
                JSONArray jSONArray = new JSONArray();
                for (View view : this.ML) {
                    if (view != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("width", view.getWidth());
                            jSONObject2.put("height", view.getHeight());
                            jSONObject2.put("alpha", view.getAlpha());
                        } catch (Throwable unused) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image_view", jSONArray.toString());
            }
            if (viewGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("width", viewGroup.getWidth());
                    jSONObject3.put("height", viewGroup.getHeight());
                    jSONObject3.put("alpha", viewGroup.getAlpha());
                } catch (Throwable unused2) {
                }
                jSONObject.put("root_view", jSONObject3.toString());
            }
            PAGMediaView pAGMediaViewOmh = this.SGo.omh();
            if (pAGMediaViewOmh != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", Vgu.ZZv(this.KZx, pAGMediaViewOmh.getWidth()) * 1.0f);
                    jSONObject4.put("height", Vgu.ZZv(this.KZx, pAGMediaViewOmh.getHeight()) * 1.0f);
                } catch (Throwable unused3) {
                }
                jSONObject.put("media_view", jSONObject4.toString());
            }
            com.bytedance.sdk.openadsdk.core.omh.yFO yfoOg = this.SGo.Og();
            if (yfoOg != null && (yfo = this.pA) != null) {
                jSONObject.put("dynamic_show_type", yfo.du());
                yfoOg.pA(jSONObject, this.pA);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.pA, this.JG, jSONObject);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(this.pA);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("InteractionManager", "onShowFun json error", e);
        }
    }

    private SD ZZv(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof SD) {
                return (SD) childAt;
            }
        }
        return null;
    }
}
