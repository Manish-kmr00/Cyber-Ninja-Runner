package com.bytedance.sdk.openadsdk.core.omh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class WV {
    private static String Og;
    private static String pA;

    public static void pA() {
        com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().pA(new com.bytedance.sdk.component.adexpress.pA.pA.Og() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.1
            @Override // com.bytedance.sdk.component.adexpress.pA.pA.Og
            public int pA(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.Og
            public Cursor pA(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new com.bytedance.sdk.openadsdk.multipro.aidl.KZx(com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.Og
            public int pA(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.Og
            public void pA(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().pA(new com.bytedance.sdk.component.adexpress.pA.pA.KZx() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.2
            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int Bzk() {
                return 1;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int WV() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int pA() {
                if (com.bytedance.sdk.openadsdk.core.aBv.ZZv() == null) {
                    return 0;
                }
                return com.bytedance.sdk.openadsdk.core.aBv.ZZv().ZZv();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public Context Og() {
                return com.bytedance.sdk.openadsdk.core.aBv.pA();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public Handler KZx() {
                return com.bytedance.sdk.openadsdk.core.Sn.KZx();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public void ZZv() {
                int iDC = com.bytedance.sdk.openadsdk.core.aBv.ZZv().dC();
                int iIIF = com.bytedance.sdk.openadsdk.core.aBv.ZZv().IIF();
                if (iDC == 0 && iIIF == 0) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.ML.ML.pA().pA(iDC);
                com.bytedance.sdk.component.adexpress.ML.ML.pA().Og(iIIF);
                int iJG = com.bytedance.sdk.openadsdk.vZF.pA.JG();
                int iML = com.bytedance.sdk.openadsdk.vZF.pA.ML();
                if (iJG == 0 && iML == 0) {
                    return;
                }
                MessageQueue[] messageQueueArr = new MessageQueue[1];
                pA(com.bytedance.sdk.openadsdk.core.Sn.KZx().getLooper().getQueue(), iML, iJG);
            }

            /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.omh.WV$2$1, reason: invalid class name */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ int KZx;
                final /* synthetic */ int Og;
                final /* synthetic */ MessageQueue[] pA;

                AnonymousClass1(MessageQueue[] messageQueueArr, int i, int i2) {
                    this.pA = messageQueueArr;
                    this.Og = i;
                    this.KZx = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.pA[0] = Looper.myQueue();
                    pA(this.pA[0], this.Og, this.KZx);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pA(final MessageQueue messageQueue, final int i, final int i2) {
                if (messageQueue != null) {
                    final int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("ad_load_and_render_opt", "w_p_delay", 500);
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Og(messageQueue, i);
                            pA(messageQueue, i2);
                        }
                    };
                    if (iPA > 0) {
                        com.bytedance.sdk.openadsdk.core.Sn.KZx().postDelayed(runnable, iPA);
                    } else {
                        runnable.run();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pA(final MessageQueue messageQueue, final int i) {
                if (messageQueue == null || i <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.2.3
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.pA.Og(i, true, messageQueue).Og();
                        return false;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Og(final MessageQueue messageQueue, final int i) {
                if (messageQueue == null || i <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.2.4
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.pA.Og(i, false, messageQueue).Og();
                        return false;
                    }
                });
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public com.bytedance.sdk.component.adexpress.pA.KZx.pA ML() {
                return com.bytedance.sdk.openadsdk.core.aBv.KZx().pA();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public com.bytedance.sdk.component.SD.Og.pA JG() {
                com.bytedance.sdk.component.SD.Og.pA pAVarZZv = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ZZv();
                pAVarZZv.pA(8);
                pAVarZZv.pA("express_down");
                return pAVarZZv;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public com.bytedance.sdk.component.SD.Og.Og SD() {
                com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
                ogKZx.pA(8);
                ogKZx.pA("express_get");
                return ogKZx;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public String omh() {
                return com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int SGo() {
                return com.bytedance.sdk.openadsdk.core.aBv.ZZv().dC();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int BSW() {
                return com.bytedance.sdk.openadsdk.core.aBv.ZZv().IIF();
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public ExecutorService Wx() {
                if (xy.BSW()) {
                    return xy.ZZv();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public ExecutorService Sn() {
                if (xy.BSW()) {
                    return xy.Bzk();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int DX() {
                return Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA());
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public int oX() {
                return Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA());
            }

            @Override // com.bytedance.sdk.component.adexpress.pA.pA.KZx
            public boolean aBv() {
                return com.bytedance.sdk.openadsdk.vZF.pA.pA("destroy_render_script", false);
            }
        });
        com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().pA(new com.bytedance.sdk.component.adexpress.pA.pA.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.3
            @Override // com.bytedance.sdk.component.adexpress.pA.pA.ZZv
            public void pA(int i) {
                com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().Og(i).JG(com.bytedance.sdk.openadsdk.core.omh.pA(i)));
            }
        });
        com.bytedance.sdk.component.Bzk.pA.pA.pA().pA(new com.bytedance.sdk.component.Bzk.pA.Og() { // from class: com.bytedance.sdk.openadsdk.core.omh.WV.4
            @Override // com.bytedance.sdk.component.Bzk.pA.Og
            public void pA(String str, String str2, JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(com.bytedance.sdk.openadsdk.utils.Og.pA(), str, str2, jSONObject);
            }

            @Override // com.bytedance.sdk.component.Bzk.pA.Og
            public void pA(com.bytedance.sdk.component.Bzk.Og.pA pAVar, String str, String str2, JSONObject jSONObject, long j) {
                com.bytedance.sdk.openadsdk.core.model.yFO yfoKZx = com.bytedance.sdk.openadsdk.core.model.yFO.KZx();
                yfoKZx.aBv(pAVar.pA());
                yfoKZx.vZF(pAVar.Og());
                yfoKZx.XT(pAVar.KZx());
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfoKZx, str, str2, jSONObject, j);
            }
        });
    }

    public static String Og() {
        String strKZx;
        if (pA == null) {
            pA = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tt_sp", "js_render_ver", "");
        }
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarOg = com.bytedance.sdk.component.adexpress.pA.Og.omh.Og();
        if (pAVarOg != null && (strKZx = pAVarOg.KZx()) != null && !strKZx.equals(pA)) {
            pA = strKZx;
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sp", "js_render_ver", strKZx);
        }
        return pA;
    }

    public static String KZx() {
        Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA;
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar;
        String strKZx;
        if (Og == null) {
            Og = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tt_sp", "js_render_v3_ver", "");
        }
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarOg = com.bytedance.sdk.component.adexpress.pA.Og.omh.Og();
        if (pAVarOg != null && (mapPA = pAVarOg.pA()) != null && (pAVar = mapPA.get("v3")) != null && (strKZx = pAVar.KZx()) != null && !strKZx.equals(Og)) {
            Og = strKZx;
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sp", "js_render_v3_ver", strKZx);
        }
        return Og;
    }
}
