package com.bytedance.sdk.component.adexpress.dynamic.pA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.KZx;
import com.bytedance.sdk.component.adexpress.Og.BSW;
import com.bytedance.sdk.component.adexpress.Og.SD;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.component.adexpress.Og.ZZv;
import com.bytedance.sdk.component.adexpress.Og.omh;
import com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements BSW, ZZv<DynamicRootView> {
    private Wx JG;
    private Context KZx;
    private omh ML;
    private com.bytedance.sdk.component.adexpress.dynamic.ML.omh Og;
    private ScheduledFuture<?> SD;
    private SD ZZv;
    private AtomicBoolean omh = new AtomicBoolean(false);
    private DynamicRootView pA;

    public pA(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.ML.omh omhVar, Wx wx, com.bytedance.sdk.component.adexpress.dynamic.JG.pA pAVar) {
        this.KZx = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, wx, pAVar);
        this.pA = dynamicRootView;
        this.Og = omhVar;
        this.JG = wx;
        dynamicRootView.setRenderListener(this);
        this.JG = wx;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(SD sd) {
        this.ZZv = sd;
        int iJG = this.JG.JG();
        if (iJG < 0) {
            this.pA.callBackRenderFail(this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? 127 : 117, "time is ".concat(String.valueOf(iJG)));
            return;
        }
        this.SD = com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(new RunnableC0203pA(2), iJG, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() == Looper.myLooper() && this.JG.Bzk() <= 0) {
            JG();
        } else {
            com.bytedance.sdk.component.utils.SD.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.pA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.this.JG();
                }
            }, this.JG.Bzk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        this.JG.ML().Og(KZx());
        JSONObject jSONObjectKZx = this.JG.KZx();
        if (!com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(jSONObjectKZx)) {
            this.pA.callBackRenderFail(this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "data null is " + (jSONObjectKZx == null));
        } else {
            this.Og.pA(new com.bytedance.sdk.component.adexpress.dynamic.JG.Og() { // from class: com.bytedance.sdk.component.adexpress.dynamic.pA.pA.2
                @Override // com.bytedance.sdk.component.adexpress.dynamic.JG.Og
                public void pA(final com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
                    pA.this.omh();
                    pA.this.JG.ML().KZx(pA.this.KZx());
                    pA.this.pA(omhVar);
                    pA.this.Og(omhVar);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        pA.this.KZx(omhVar);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.pA.pA.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                pA.this.KZx(omhVar);
                            }
                        });
                    }
                    if (pA.this.pA == null || omhVar == null) {
                        return;
                    }
                    pA.this.pA.setBgColor(omhVar.pA());
                    pA.this.pA.setBgMaterialCenterCalcColor(omhVar.Og());
                }
            });
            this.Og.pA(this.JG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW;
        if (omhVar == null || (listBSW = omhVar.BSW()) == null || listBSW.size() <= 0) {
            return;
        }
        Collections.sort(listBSW, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.pA.pA.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar3) {
                JG jgML = omhVar2.SGo().ML();
                JG jgML2 = omhVar3.SGo().ML();
                if (jgML == null || jgML2 == null) {
                    return 0;
                }
                return jgML.rtW() >= jgML2.rtW() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 : listBSW) {
            if (omhVar2 != null) {
                pA(omhVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        float fSD;
        float fJG;
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW;
        if (omhVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW2 = omhVar.BSW();
        if (listBSW2 == null || listBSW2.size() <= 0) {
            fSD = 0.0f;
        } else {
            fSD = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 : listBSW2) {
                if (omhVar2.SD() > omhVar.SD() - omhVar2.Bzk() || (listBSW = omhVar2.BSW()) == null || listBSW.size() <= 0) {
                    fJG = 0.0f;
                } else {
                    fJG = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar3 : listBSW) {
                        if (omhVar3.SGo().Og().equals("logo-union")) {
                            fJG = omhVar3.SGo().JG();
                            fSD = (((-fJG) + omhVar.SD()) - omhVar2.SD()) + omhVar2.SGo().ML().qQU();
                        }
                    }
                }
                Og(omhVar2);
                if (fJG <= -15.0f) {
                    omhVar2.JG(omhVar2.Bzk() - fJG);
                    omhVar2.ZZv(omhVar2.SD() + fJG);
                    for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar4 : omhVar2.BSW()) {
                        omhVar4.ZZv(omhVar4.SD() - fJG);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarWV = omhVar.WV();
        if (omhVarWV == null) {
            return;
        }
        float fJG2 = omhVar.JG() - omhVarWV.JG();
        float fSD2 = omhVar.SD() - omhVarWV.SD();
        omhVar.KZx(fJG2);
        omhVar.ZZv(fSD2);
        if (fSD > 0.0f) {
            omhVar.ZZv(omhVar.SD() - fSD);
            omhVar.JG(omhVar.Bzk() + fSD);
            for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar5 : omhVar.BSW()) {
                omhVar5.ZZv(omhVar5.SD() + fSD);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public DynamicRootView ML() {
        return ZZv();
    }

    public void Og() {
        pA(ML());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pA(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                pA(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof gbA) {
            ((gbA) view).Og();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public int KZx() {
        return this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        if (omhVar == null) {
            this.pA.callBackRenderFail(this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "layoutUnit is null");
            return;
        }
        this.JG.ML().ZZv(KZx());
        try {
            this.pA.render(omhVar, KZx());
        } catch (Exception e) {
            this.pA.callBackRenderFail(this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView ZZv() {
        return this.pA;
    }

    public void pA(omh omhVar) {
        this.ML = omhVar;
    }

    private boolean SD() {
        DynamicRootView dynamicRootView = this.pA;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.BSW
    public void pA(Sn sn) {
        if (this.omh.get()) {
            return;
        }
        this.omh.set(true);
        if (sn.KZx() && SD()) {
            this.pA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.ZZv.pA(ML(), sn);
            return;
        }
        this.ZZv.pA(sn.BSW(), sn.SGo());
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.BSW
    public void pA(View view, int i, KZx kZx) {
        omh omhVar = this.ML;
        if (omhVar != null) {
            omhVar.pA(view, i, kZx);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.pA.pA$pA, reason: collision with other inner class name */
    private class RunnableC0203pA implements Runnable {
        private int Og;

        public RunnableC0203pA(int i) {
            this.Og = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Og == 2) {
                pA.this.pA.callBackRenderFail(pA.this.Og instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD ? 127 : 117, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void omh() {
        try {
            ScheduledFuture<?> scheduledFuture = this.SD;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.SD.cancel(false);
            this.SD = null;
        } catch (Throwable unused) {
        }
    }
}
