package com.bytedance.adsdk.ugeno.ZZv;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class pA implements ZZv {
    @Override // com.bytedance.adsdk.ugeno.ZZv.ZZv
    public List<KZx> pA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KZx("slide") { // from class: com.bytedance.adsdk.ugeno.ZZv.pA.1
            @Override // com.bytedance.adsdk.ugeno.ZZv.KZx
            public com.bytedance.adsdk.ugeno.ZZv.KZx.pA pA(Context context) {
                return new com.bytedance.adsdk.ugeno.ZZv.KZx.KZx(context);
            }
        });
        arrayList.add(new KZx("tap") { // from class: com.bytedance.adsdk.ugeno.ZZv.pA.2
            @Override // com.bytedance.adsdk.ugeno.ZZv.KZx
            public com.bytedance.adsdk.ugeno.ZZv.KZx.pA pA(Context context) {
                return new com.bytedance.adsdk.ugeno.ZZv.KZx.ZZv(context);
            }
        });
        arrayList.add(new KZx("timer") { // from class: com.bytedance.adsdk.ugeno.ZZv.pA.3
            @Override // com.bytedance.adsdk.ugeno.ZZv.KZx
            public com.bytedance.adsdk.ugeno.ZZv.KZx.pA pA(Context context) {
                return new com.bytedance.adsdk.ugeno.ZZv.KZx.ML(context);
            }
        });
        return arrayList;
    }
}
