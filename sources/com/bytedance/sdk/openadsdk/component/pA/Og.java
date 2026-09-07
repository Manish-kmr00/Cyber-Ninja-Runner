package com.bytedance.sdk.openadsdk.component.pA;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.XT.pA.pA.SD;
import com.bytedance.sdk.openadsdk.core.Og.KZx;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.Bzk;
import com.bytedance.sdk.openadsdk.core.omh.omh;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class Og {
    public static pA pA(yFO yfo, Activity activity, com.bytedance.sdk.openadsdk.component.omh.pA pAVar) {
        pA pAVar2 = new pA(activity.getApplicationContext(), yfo, "open_ad", 4, pAVar);
        pAVar2.pA(activity.findViewById(R.id.content));
        pAVar2.Og(activity.findViewById(520093713));
        pA(activity.getApplicationContext(), yfo, pAVar2);
        pA(pAVar2, yfo);
        return pAVar2;
    }

    public static Bzk pA(yFO yfo, Activity activity, final com.bytedance.sdk.openadsdk.component.omh.pA pAVar, com.bytedance.sdk.openadsdk.component.Bzk.Og og) {
        Bzk bzk = new Bzk(activity, yfo, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.pA.Og.1
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(pAVar.Og()));
                pA(map);
                super.pA(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        bzk.pA(og);
        pA(activity.getApplicationContext(), yfo, bzk);
        pA(bzk, yfo);
        return bzk;
    }

    public static omh Og(yFO yfo, Activity activity, final com.bytedance.sdk.openadsdk.component.omh.pA pAVar, com.bytedance.sdk.openadsdk.component.Bzk.Og og) {
        omh omhVar = new omh(activity.getApplicationContext(), yfo, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.pA.Og.2
            @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(pAVar.Og()));
                pA(map);
                super.pA(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        omhVar.pA((View) og);
        pA(activity.getApplicationContext(), yfo, omhVar);
        pA(omhVar, yfo);
        return omhVar;
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.Og.Og og, yFO yfo) {
        HashMap map = new HashMap();
        map.put("click_area", Integer.valueOf(yfo.Wx()));
        map.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
        map.put("click_scence", Integer.valueOf(WQf.KZx(yfo) ? 3 : 1));
        og.pA(map);
    }

    private static void pA(Context context, yFO yfo, com.bytedance.sdk.openadsdk.core.Og.Og og) {
        if (yfo == null || yfo.JBA() != 4) {
            return;
        }
        og.pA(SD.pA(context, yfo, "open_ad"));
    }
}
