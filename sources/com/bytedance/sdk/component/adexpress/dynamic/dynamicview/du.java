package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public class du extends JG {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public du(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.omh += 6;
        if (this.WV.CIG()) {
            this.DX = new com.bytedance.sdk.component.adexpress.JG.pA(context, this.WV.SD(), this.WV.ML(), 1, this.WV.omh());
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setMaxLines(1);
        } else {
            this.DX = new TextView(context);
            ((TextView) this.DX).setIncludeFontPadding(false);
        }
        this.DX.setTag(Integer.valueOf(getClickArea()));
        addView(this.DX, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        int i;
        double d;
        super.Bzk();
        if (TextUtils.isEmpty(getText())) {
            this.DX.setVisibility(4);
            return true;
        }
        if (this.WV.CIG()) {
            BSW();
            return true;
        }
        ((TextView) this.DX).setText(this.WV.JG());
        ((TextView) this.DX).setTextDirection(5);
        this.DX.setTextAlignment(this.WV.omh());
        ((TextView) this.DX).setTextColor(this.WV.SD());
        ((TextView) this.DX).setTextSize(this.WV.ML());
        if (!this.WV.TX()) {
            ((TextView) this.DX).setMaxLines(1);
            ((TextView) this.DX).setGravity(17);
            ((TextView) this.DX).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iBF = this.WV.BF();
            if (iBF > 0) {
                ((TextView) this.DX).setLines(iBF);
                ((TextView) this.DX).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.Wx != null && this.Wx.SGo() != null) {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og() && pA() && (TextUtils.equals(this.Wx.SGo().Og(), "text_star") || TextUtils.equals(this.Wx.SGo().Og(), "score-count") || TextUtils.equals(this.Wx.SGo().Og(), "score-count-type-1") || TextUtils.equals(this.Wx.SGo().Og(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.Wx.SGo().Og(), "score-count") || TextUtils.equals(this.Wx.SGo().Og(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                        setVisibility(8);
                        return true;
                    }
                    this.DX.setVisibility(0);
                }
                if (TextUtils.equals(this.Wx.SGo().Og(), "score-count-type-2")) {
                    ((TextView) this.DX).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.DX).setGravity(17);
                    return true;
                }
                pA((TextView) this.DX, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.Wx.SGo().Og(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                        setVisibility(8);
                        return true;
                    }
                    this.DX.setVisibility(0);
                }
                ((TextView) this.DX).setIncludeFontPadding(false);
                ((TextView) this.DX).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.Wx.SGo().Og())) {
                ((TextView) this.DX).setText("Permission list | Privacy policy");
            } else if (TextUtils.equals(this.Wx.SGo().Og(), "development-name")) {
                ((TextView) this.DX).setText(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.Wx.SGo().Og(), "app-version")) {
                ((TextView) this.DX).setText(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.DX).setText(getText());
            }
            this.DX.setTextAlignment(this.WV.omh());
            ((TextView) this.DX).setGravity(this.WV.Bzk());
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                SGo();
            }
        }
        return true;
    }

    private boolean pA() {
        return (this.Sn == null || this.Sn.getRenderRequest() == null || this.Sn.getRenderRequest().SGo() == 4) ? false : true;
    }

    private void SGo() {
        int iPA;
        if (TextUtils.equals(this.Wx.SGo().Og(), "source") || TextUtils.equals(this.Wx.SGo().Og(), "title") || TextUtils.equals(this.Wx.SGo().Og(), "text_star")) {
            int[] iArrOg = com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og(this.WV.JG(), this.WV.ML(), true);
            int iPA2 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.WV.Og());
            int iPA3 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.WV.KZx());
            int iPA4 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.WV.ZZv());
            int iPA5 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.WV.pA());
            int iMin = Math.min(iPA2, iPA5);
            if (TextUtils.equals(this.Wx.SGo().Og(), "source") && (iPA = ((this.omh - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.WV.ML()))) - iPA2) - iPA5) > 1 && iPA <= iMin * 2) {
                int i = iPA / 2;
                this.DX.setPadding(iPA3, iPA2 - i, iPA4, iPA5 - (iPA - i));
                return;
            }
            int i2 = (((iArrOg[1] + iPA2) + iPA5) - this.omh) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.DX.setPadding(iPA3, iPA2 - i3, iPA4, iPA5 - (i2 - i3));
            } else if (i2 > iPA2 + iPA5) {
                final int i4 = (i2 - iPA2) - iPA5;
                this.DX.setPadding(iPA3, 0, iPA4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 1.0f)) + 1) {
                    ((TextView) this.DX).setTextSize(this.WV.ML() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.DX).setTextSize(this.WV.ML() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.du.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = du.this.DX.getLayoutParams();
                                layoutParams.height = du.this.omh + i4;
                                du.this.DX.setLayoutParams(layoutParams);
                                du.this.DX.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) du.this.DX.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) du.this.DX.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iPA2 > iPA5) {
                this.DX.setPadding(iPA3, iPA2 - (i2 - iMin), iPA4, iPA5 - iMin);
            } else {
                this.DX.setPadding(iPA3, iPA2 - iMin, iPA4, iPA5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.Wx.SGo().Og(), "fillButton")) {
            this.DX.setTextAlignment(2);
            ((TextView) this.DX).setGravity(17);
        }
    }

    public String getText() {
        String strJG = this.WV.JG();
        if (TextUtils.isEmpty(strJG)) {
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og() && TextUtils.equals(this.Wx.SGo().Og(), "text_star")) {
                strJG = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og() && TextUtils.equals(this.Wx.SGo().Og(), "score-count")) {
                strJG = "6870";
            }
        }
        return (TextUtils.equals(this.Wx.SGo().Og(), "title") || TextUtils.equals(this.Wx.SGo().Og(), "subtitle")) ? strJG.replace("\n", "") : strJG;
    }

    public void pA(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(com.bytedance.sdk.component.utils.yFO.pA(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void BSW() {
        if (this.DX instanceof com.bytedance.sdk.component.adexpress.JG.pA) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setMaxLines(1);
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setTextColor(this.WV.SD());
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setTextSize(this.WV.ML());
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setAnimationText(arrayList);
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setAnimationType(this.WV.FQ());
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).setAnimationDuration(this.WV.SzT() * 1000);
            ((com.bytedance.sdk.component.adexpress.JG.pA) this.DX).pA();
        }
    }
}
