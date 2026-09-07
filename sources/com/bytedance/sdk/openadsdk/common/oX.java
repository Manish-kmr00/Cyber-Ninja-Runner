package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class oX {
    private ImageView JG;
    private final yFO KZx;
    private final Context ML;
    private final com.bytedance.sdk.component.Bzk.ZZv Og;
    private ImageView SD;
    private final String ZZv;
    private com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA omh;
    private final LinearLayout pA;

    public oX(Context context, LinearLayout linearLayout, com.bytedance.sdk.component.Bzk.ZZv zZv, yFO yfo, String str) {
        this.ML = context;
        this.pA = linearLayout;
        this.Og = zZv;
        this.KZx = yfo;
        this.ZZv = str;
        KZx();
    }

    private void KZx() {
        this.JG = (ImageView) this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.RS);
        this.SD = (ImageView) this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.QI);
        ImageView imageView = (ImageView) this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Gag);
        ImageView imageView2 = (ImageView) this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Qj);
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.oX.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/oX$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_oX$1_onClick_793c053e0cf5965394e236c0a9fa158b(view);
            }

            public void safedk_oX$1_onClick_793c053e0cf5965394e236c0a9fa158b(View p0) {
                View p1 = oX.this.Og;
                if (p1 == null || !oX.this.Og.ML()) {
                    return;
                }
                if (oX.this.omh != null) {
                    oX.this.omh.pA();
                }
                oX.this.pA(ToolBar.BACKWARD);
                oX.this.Og.JG();
            }
        });
        this.SD.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.oX.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/oX$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_oX$2_onClick_32c9d2ffcab88daf64ca0d1e34ac6b89(view);
            }

            public void safedk_oX$2_onClick_32c9d2ffcab88daf64ca0d1e34ac6b89(View p0) {
                View p1 = oX.this.Og;
                if (p1 == null || !oX.this.Og.SD()) {
                    return;
                }
                oX.this.pA(ToolBar.FORWARD);
                oX.this.Og.omh();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.oX.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/oX$3;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_oX$3_onClick_c025d59de393bccc4d2004c2c4dd1ce3(view);
            }

            public void safedk_oX$3_onClick_c025d59de393bccc4d2004c2c4dd1ce3(View p0) {
                View p1 = oX.this.Og;
                if (p1 != null) {
                    oX.this.Og(ToolBar.REFRESH);
                    oX.this.Og.ZZv();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.oX.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/oX$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_oX$4_onClick_2cd4c7b776df62620dc7a5743712f576(view);
            }

            public void safedk_oX$4_onClick_2cd4c7b776df62620dc7a5743712f576(View p0) {
                View p1 = oX.this.Og;
                if (p1 != null) {
                    oX.this.Og("external_btn_click");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String url = oX.this.Og.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return;
                    }
                    intent.setData(Uri.parse(url));
                    com.bytedance.sdk.component.utils.Og.pA(oX.this.ML, intent, null);
                }
            }
        });
        this.pA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.oX.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/oX$5;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_oX$5_onClick_658b76c95ab9aad879bd79705fcb835e(view);
            }

            public void safedk_oX$5_onClick_658b76c95ab9aad879bd79705fcb835e(View p0) {
            }
        });
        this.JG.setClickable(false);
        this.SD.setClickable(false);
        this.JG.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
        this.SD.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
    }

    public void pA(WebView webView, com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA pAVar) {
        this.omh = pAVar;
        try {
            if (this.JG != null) {
                if (webView.canGoBack()) {
                    this.JG.setClickable(true);
                    this.JG.clearColorFilter();
                } else {
                    this.JG.setClickable(false);
                    this.JG.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.SD != null) {
                if (webView.canGoForward()) {
                    this.SD.setClickable(true);
                    this.SD.clearColorFilter();
                } else {
                    this.SD.setClickable(false);
                    this.SD.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void pA() {
        if (this.pA.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.pA, "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    public void Og() {
        if (this.pA.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.pA, "alpha", 1.0f, 0.0f).setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Og.getWebView() != null && (webBackForwardListCopyBackForwardList = this.Og.getWebView().copyBackForwardList()) != null) {
                int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.Og.getUrl();
                }
                String url2 = "";
                if (str.equals(ToolBar.BACKWARD)) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl();
                }
                int i = 1;
                if (str.equals(ToolBar.FORWARD)) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", url2);
                if (webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                    i = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.KZx, this.ZZv, str, jSONObject, (com.bytedance.sdk.openadsdk.ZZv.SD) null, (com.bytedance.sdk.openadsdk.ZZv.Og.pA) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Og.getWebView() != null && (webBackForwardListCopyBackForwardList = this.Og.getWebView().copyBackForwardList()) != null) {
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.Og.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(webBackForwardListCopyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.KZx, this.ZZv, str, jSONObject, (com.bytedance.sdk.openadsdk.ZZv.SD) null, (com.bytedance.sdk.openadsdk.ZZv.Og.pA) null);
    }
}
