package com.bytedance.sdk.openadsdk.KZx;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.du;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class KZx implements du {
    private ZZv KZx;
    private du.pA ML;
    private final Context Og;
    private boolean ZZv;
    public WV pA;

    public KZx(Context context, String str, List<FilterWord> list, String str2, String str3) {
        if (!(context instanceof Activity)) {
            com.bytedance.sdk.component.utils.WV.Og("Dislike Initialization must use activity, please pass in TTAdManager.createAdNative(activity)");
        }
        this.Og = context;
        pA(str, list, str2, str3);
    }

    private void pA(String str, List<FilterWord> list, String str2, String str3) {
        this.KZx = new ZZv(this.Og, str, list, str3);
        WV wv = new WV(this.Og, this.KZx.getDislikeManager());
        this.pA = wv;
        wv.pA(str, str2);
        this.pA.pA(str3);
        this.pA.pA(new WV.pA() { // from class: com.bytedance.sdk.openadsdk.KZx.KZx.1
            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void pA() {
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void Og() {
                KZx.this.pA();
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void KZx() {
                KZx.this.pA();
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void pA(int i, FilterWord filterWord, String str4) {
                KZx.this.KZx.onSuggestionSubmit(str4);
                KZx.this.pA();
            }
        });
        this.KZx.pA(new ZZv.pA() { // from class: com.bytedance.sdk.openadsdk.KZx.KZx.2
            @Override // com.bytedance.sdk.openadsdk.KZx.ZZv.pA
            public void pA() {
                KZx.this.pA(true);
                if (KZx.this.KZx != null && KZx.this.KZx.isShowing()) {
                    KZx.this.KZx.hide();
                }
                KZx.this.ZZv();
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.ZZv.pA
            public void pA(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && KZx.this.ML != null) {
                        KZx.this.ML.pA(i, filterWord.getName());
                    }
                    com.bytedance.sdk.component.utils.WV.pA("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + filterWord.getName());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.ZZv.pA
            public void Og() {
                com.bytedance.sdk.component.utils.WV.pA("TTAdDislikeImpl", "onDislikeDismiss: ");
                try {
                    if (KZx.this.ML != null) {
                        KZx.this.ML.pA();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.du
    public void pA() {
        Context context = this.Og;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.KZx.isShowing()) {
            return;
        }
        this.KZx.show();
    }

    @Override // com.bytedance.sdk.openadsdk.core.du
    public void pA(du.pA pAVar) {
        this.ML = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.du
    public void Og() {
        ZZv zZv = this.KZx;
        if (zZv != null) {
            zZv.destroy();
        }
    }

    public void pA(String str) {
        ZZv zZv = this.KZx;
        if (zZv != null) {
            zZv.pA(str);
        }
    }

    public boolean KZx() {
        return this.ZZv;
    }

    public void pA(boolean z) {
        this.ZZv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        Context context = this.Og;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.pA.isShowing()) {
            return;
        }
        this.pA.show();
    }
}
