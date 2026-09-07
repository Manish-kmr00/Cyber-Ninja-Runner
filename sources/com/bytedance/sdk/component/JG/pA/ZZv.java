package com.bytedance.sdk.component.JG.pA;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.aBv;
import com.yandex.div.core.timer.TimerController;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    public static final ZZv pA = new ZZv();

    public void pA(pA pAVar, Context context) {
        Og(pAVar, context);
        omh.SD().pA(context);
        omh.SD().pA(pAVar.SGo());
        omh.SD().Og(pAVar.SD());
        omh.SD().KZx(pAVar.omh());
        omh.SD().pA(pAVar.Og());
        omh.SD().ZZv(pAVar.Bzk());
        omh.SD().ML(pAVar.JG());
        omh.SD().pA(pAVar.pA() == null ? com.bytedance.sdk.component.JG.pA.pA.pA.ML.pA : pAVar.pA());
        omh.SD().Og(pAVar.BSW());
        omh.SD().pA(pAVar.ZZv());
        omh.SD().pA(pAVar.KZx());
        omh.SD().pA(pAVar.ML());
        com.bytedance.sdk.component.JG.pA.Og.KZx.KZx.pA(pAVar.Wx());
        com.bytedance.sdk.component.JG.pA.Og.KZx.KZx.Og(pAVar.WV());
        pA(pAVar);
    }

    private void pA(pA pAVar) {
        Executor executorML;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.JG.pA.KZx.pA.Og()) {
            com.bytedance.sdk.component.JG.pA.KZx.pA.pA();
            return;
        }
        ML mlZZv = pAVar.ZZv();
        if (mlZZv == null || !com.bytedance.sdk.component.JG.pA.KZx.pA.Og() || (executorML = mlZZv.ML()) == null) {
            return;
        }
        executorML.execute(new Runnable() { // from class: com.bytedance.sdk.component.JG.pA.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.JG.pA.KZx.pA.pA();
            }
        });
    }

    public void pA(boolean z) {
        omh.SD().pA(z);
    }

    private void Og(pA pAVar, Context context) {
        KZx.pA(context, "context == null");
        KZx.pA(pAVar, "AdLogConfig == null");
        KZx.pA(pAVar.ZZv(), "AdLogDepend ==null");
    }

    private boolean pA(Context context, ML ml) {
        if (context == null || ml == null) {
            return false;
        }
        if (ml.JG() == 2) {
            return true;
        }
        if (ml.JG() == 1) {
            return ml.Sn();
        }
        try {
            return aBv.pA(context);
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void pA() {
        final ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null) {
            return;
        }
        if (omh.SD().Og()) {
            if (pA(omh.SD().JG(), mlOX)) {
                omh.SD().Bzk();
                return;
            } else if (KZx()) {
                mlOX.ZZv().execute(new com.bytedance.sdk.component.JG.pA.ML.ML("start") { // from class: com.bytedance.sdk.component.JG.pA.ZZv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ZZv.this.pA(mlOX.JG());
                    }
                });
                return;
            } else {
                pA(mlOX.JG());
                return;
            }
        }
        omh.SD().Bzk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.JG.pA.Og.Og.pA.pA();
        } else if (i == 1) {
            com.bytedance.sdk.component.JG.pA.Og.Og.Og.pA();
        }
    }

    public void Og() {
        final ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null) {
            return;
        }
        if (omh.SD().Og()) {
            if (pA(omh.SD().JG(), mlOX)) {
                omh.SD().BSW();
                return;
            } else if (KZx()) {
                mlOX.ZZv().execute(new com.bytedance.sdk.component.JG.pA.ML.ML(TimerController.STOP_COMMAND) { // from class: com.bytedance.sdk.component.JG.pA.ZZv.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ZZv.this.Og(mlOX.JG());
                    }
                });
                return;
            } else {
                Og(mlOX.JG());
                return;
            }
        }
        omh.SD().BSW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.JG.pA.Og.Og.pA.Og();
        } else if (i == 1) {
            com.bytedance.sdk.component.JG.pA.Og.Og.Og.Og();
        }
    }

    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        Og(pAVar);
    }

    private boolean KZx() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void Og(final com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        final ML mlOX = omh.SD().oX();
        if (pAVar == null || mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null) {
            return;
        }
        if (omh.SD().Og()) {
            if (pA(omh.SD().JG(), mlOX)) {
                omh.SD().pA(pAVar);
                return;
            }
            KZx();
            if (KZx()) {
                mlOX.ZZv().execute(new com.bytedance.sdk.component.JG.pA.ML.ML("dispatchEvent") { // from class: com.bytedance.sdk.component.JG.pA.ZZv.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ZZv.this.pA(pAVar, mlOX.JG());
                    }
                });
                return;
            } else {
                pA(pAVar, mlOX.JG());
                return;
            }
        }
        omh.SD().pA(pAVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.JG.pA.Og.Og.pA.pA(pAVar);
        } else if (i == 1) {
            com.bytedance.sdk.component.JG.pA.Og.Og.Og.pA(pAVar);
        }
    }

    public void pA(final String str, final List<String> list, final boolean z, Map<String, String> map, final int i, final String str2) {
        final ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null) {
            return;
        }
        if (mlOX.omh()) {
            if (mlOX.JG() == 1) {
                if (list == null || list.isEmpty()) {
                    return;
                }
            } else if (mlOX.JG() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
                return;
            }
            if (omh.SD().Og() && !pA(omh.SD().JG(), mlOX)) {
                if (KZx()) {
                    mlOX.ZZv().execute(new com.bytedance.sdk.component.JG.pA.ML.ML("trackFailed") { // from class: com.bytedance.sdk.component.JG.pA.ZZv.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ZZv.this.pA(str, (List<String>) list, z, mlOX.JG(), i, str2);
                        }
                    });
                    return;
                } else {
                    pA(str, list, z, mlOX.JG(), i, str2);
                    return;
                }
            }
            omh.SD().pA(str, list, z, map, i, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, List<String> list, boolean z, int i, int i2, String str2) {
        if (i == 0) {
            com.bytedance.sdk.component.JG.pA.Og.Og.pA.pA(str, list, z);
        } else if (i == 1) {
            com.bytedance.sdk.component.JG.pA.Og.Og.Og.pA(str, list, z, i2, str2);
        }
    }

    public void pA(final String str, final boolean z) {
        final ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null || !mlOX.omh()) {
            return;
        }
        if (mlOX.JG() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!omh.SD().Og() || pA(omh.SD().JG(), mlOX)) {
            omh.SD().pA(str, z);
        } else if (KZx()) {
            mlOX.ZZv().execute(new com.bytedance.sdk.component.JG.pA.ML.ML("trackFailed") { // from class: com.bytedance.sdk.component.JG.pA.ZZv.6
                @Override // java.lang.Runnable
                public void run() {
                    ZZv.this.pA(str, mlOX.JG(), z);
                }
            });
        } else {
            pA(str, mlOX.JG(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, int i, boolean z) {
        if (i == 0) {
            com.bytedance.sdk.component.JG.pA.Og.Og.pA.pA(str);
        } else if (i == 1) {
            com.bytedance.sdk.component.JG.pA.Og.Og.Og.pA(str, z);
        }
    }
}
