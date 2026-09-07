package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.JG.eG;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class yFO implements SD<eG> {
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo JG;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML KZx;
    private String ML;
    private Context Og;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD ZZv;
    private eG pA;

    public yFO(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, String str, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo) {
        this.Og = context;
        this.KZx = ml;
        this.ZZv = sd;
        this.ML = str;
        this.JG = sGo;
        ML();
    }

    private void ML() {
        int iAgB = this.ZZv.agB();
        final com.bytedance.sdk.component.adexpress.dynamic.JG.pA dynamicClickListener = this.KZx.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 2);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.ML)) {
            Context context = this.Og;
            eG eGVar = new eG(context, com.bytedance.sdk.component.adexpress.KZx.pA.Bzk(context), this.JG);
            this.pA = eGVar;
            if (eGVar.getWriggleLayout() != null) {
                this.pA.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.pA.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.ZZv.bU())) {
                    this.pA.getTopTextView().setText(com.bytedance.sdk.component.utils.yFO.Og(this.Og, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.pA.getTopTextView().setText(this.ZZv.bU());
                }
            }
        } else {
            Context context2 = this.Og;
            this.pA = new eG(context2, com.bytedance.sdk.component.adexpress.KZx.pA.Bzk(context2), this.JG);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.pA.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, iAgB)));
        this.pA.setLayoutParams(layoutParams);
        this.pA.setShakeText(this.ZZv.YkC());
        this.pA.setClipChildren(false);
        final View wriggleProgressIv = this.pA.getWriggleProgressIv();
        this.pA.setOnShakeViewListener(new eG.pA() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.yFO.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        this.pA.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public eG KZx() {
        return this.pA;
    }
}
