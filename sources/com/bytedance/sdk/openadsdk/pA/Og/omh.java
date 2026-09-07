package com.bytedance.sdk.openadsdk.pA.Og;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.oX;
import com.bytedance.sdk.openadsdk.utils.Mc;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class omh extends PAGNativeAd {
    private boolean Bzk;
    protected int JG;
    protected final Context KZx;
    protected int ML;
    protected final yFO Og;
    protected String SD;
    protected pA ZZv;
    private boolean omh;
    protected oX pA;

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
    }

    public omh(Context context, yFO yfo, int i, boolean z) {
        if (yfo == null) {
            WV.Og("materialMeta can't been null");
        }
        this.Og = yfo;
        this.KZx = context;
        this.ML = i;
        this.JG = yfo.Wf();
        this.SD = gbA.KZx(i);
        if (z) {
            this.ZZv = new pA(context, yfo, this.SD);
            this.pA = new oX(context, this, yfo, pA(i), this.ZZv);
        }
    }

    private List<View> pA(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        yFO yfo = this.Og;
        if (yfo != null) {
            return yfo.tZW();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        yFO yfo = this.Og;
        if (yfo == null || yfo.tZW() == null) {
            return null;
        }
        try {
            return this.Og.tZW().get(str);
        } catch (Throwable th) {
            WV.pA("TTNativeAdImpl", th.getMessage());
            return null;
        }
    }

    private String pA(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i != 2) {
            return "embeded_ad";
        }
        return "interaction";
    }

    protected boolean SD() {
        yFO yfo = this.Og;
        return (yfo == null || yfo.JBA() == 5 || aBv.ZZv().KZx(this.JG) != 1) ? false : true;
    }

    protected void pA(String str) {
        this.SD = str;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.omh) {
            return;
        }
        Mc.pA(this.Og, d);
        this.omh = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.Bzk) {
            return;
        }
        Mc.pA(this.Og, d, str, str2);
        this.Bzk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null) {
            WV.Og("container can't been null");
            return;
        }
        if (list == null) {
            WV.Og("clickView can't been null");
        } else if (list.size() <= 0) {
            WV.Og("clickViews size must been more than 1");
        } else {
            pA(viewGroup, null, list, list2, view, new SD(pAGNativeAdInteractionListener));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    public void pA(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final JG jg) {
        if (viewGroup == null) {
            WV.Og("container can't been null");
            return;
        }
        if (list2 == null) {
            WV.Og("clickView can't been null");
            return;
        }
        if (list2.size() <= 0) {
            WV.Og("clickViews size must been more than 1");
            return;
        }
        if (SD()) {
            list3 = pA(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && jg != null && jg.Og()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.pA.Og.omh.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/pA/Og/omh$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_omh$1_onClick_5db47af2a6685fee3a7f23b194599aad(view2);
                }

                public void safedk_omh$1_onClick_5db47af2a6685fee3a7f23b194599aad(View p0) {
                    final String strPA = WQf.pA();
                    TTDelegateActivity.pA(omh.this.Og, strPA, new com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA() { // from class: com.bytedance.sdk.openadsdk.pA.Og.omh.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA
                        public void pA() {
                            jg.pA();
                            Bzk.Og().JG(strPA);
                            PAGMediaView pAGMediaViewPA = omh.this.omh().pA();
                            if (pAGMediaViewPA != null) {
                                pAGMediaViewPA.close();
                            }
                        }
                    });
                }
            });
        }
        this.pA.pA(viewGroup, list, list2, list4, view, jg);
        yFO yfo = this.Og;
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(viewGroup, this.Og, (yfo == null || yfo.BF() != 2) ? null : new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.Og.du()));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new ZZv(omh());
    }

    public pA omh() {
        return this.ZZv;
    }
}
