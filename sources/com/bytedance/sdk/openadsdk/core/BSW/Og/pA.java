package com.bytedance.sdk.openadsdk.core.BSW.Og;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.yFO;

/* JADX INFO: loaded from: classes12.dex */
public class pA extends com.bytedance.adsdk.ugeno.Bzk.JG.Og {
    public pA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og
    public void SD(String str) {
        super.SD(str);
        if (TextUtils.isEmpty(str) || TextUtils.equals("null", str)) {
            return;
        }
        try {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setText("(" + String.format(yFO.pA(this.ML, "tt_comment_num"), Integer.valueOf(Integer.parseInt(str))) + ")");
        } catch (Exception unused) {
        }
    }
}
