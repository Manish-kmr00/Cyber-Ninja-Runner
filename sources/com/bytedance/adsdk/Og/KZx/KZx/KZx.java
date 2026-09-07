package com.bytedance.adsdk.Og.KZx.KZx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.Og.vZF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class KZx extends ZZv {
    private final List<TextView> BSW;
    private final LinearLayout.LayoutParams Bzk;
    private final List<String> SGo;
    private String WV;
    private LinearLayout omh;

    public KZx(com.bytedance.adsdk.Og.Bzk bzk, ML ml, Context context) {
        List<com.bytedance.adsdk.Og.SGo.pA> listKZx;
        super(bzk, ml);
        this.Bzk = new LinearLayout.LayoutParams(-2, -2);
        this.SGo = new ArrayList();
        this.BSW = new ArrayList();
        if (this.SD == null || (listKZx = this.SD.KZx()) == null || listKZx.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.omh = linearLayout;
        int i = 0;
        linearLayout.setOrientation(0);
        Og(listKZx.get(0).SD);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.omh.addView(linearLayout2);
        List<String> listWV = WV();
        while (i < listKZx.size()) {
            com.bytedance.adsdk.Og.SGo.pA pAVar = listKZx.get(i);
            TextView textView = new TextView(context);
            pA(textView, pAVar, (listWV == null || i >= listWV.size()) ? "" : listWV.get(i));
            if (pAVar.JG != 0) {
                this.Bzk.bottomMargin = (int) (pAVar.JG * com.bytedance.adsdk.Og.JG.JG.pA());
                linearLayout2.addView(textView, this.Bzk);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
        pA(this.omh, (int) (this.SD.pA() * fPA), (int) (this.SD.Og() * fPA));
    }

    private void Og(String str) {
        if (TextUtils.isEmpty(str)) {
            this.omh.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.omh.setGravity(3);
        } else if (str.equals("right")) {
            this.omh.setGravity(5);
        } else {
            this.omh.setGravity(17);
        }
    }

    private void pA(TextView textView, com.bytedance.adsdk.Og.SGo.pA pAVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        if (!TextUtils.isEmpty(pAVar.KZx)) {
            textView.setTextColor(Color.parseColor(pAVar.KZx));
        }
        if (!TextUtils.isEmpty(pAVar.ZZv)) {
            textView.setBackgroundColor(Color.parseColor(pAVar.ZZv));
        }
        textView.setGravity(17);
        textView.setTextSize(pAVar.ML);
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.ZZv, com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        if (this.omh != null) {
            canvas.save();
            canvas.concat(matrix);
            pA(i);
            KZx(JG());
            this.omh.draw(canvas);
            canvas.restore();
            return;
        }
        super.Og(canvas, matrix, i);
    }

    private void KZx(float f) {
        List<com.bytedance.adsdk.Og.SGo.pA> listKZx;
        if (this.SD == null || (listKZx = this.SD.KZx()) == null || listKZx.size() <= 0) {
            return;
        }
        this.omh.setOrientation(0);
        this.omh.setGravity(17);
        if (this.omh.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.omh.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.omh.removeAllViews();
        if (linearLayout.getChildCount() != listKZx.size()) {
            return;
        }
        List<String> listWV = WV();
        this.BSW.clear();
        int i = 0;
        while (i < listKZx.size()) {
            com.bytedance.adsdk.Og.SGo.pA pAVar = listKZx.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.BSW.add(textView);
            pA(textView, pAVar, (listWV == null || i >= listWV.size()) ? "" : listWV.get(i));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listKZx.size(); i2++) {
            com.bytedance.adsdk.Og.SGo.pA pAVar2 = listKZx.get(i2);
            TextView textView2 = this.BSW.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (pAVar2.JG != 0) {
                this.Bzk.bottomMargin = (int) (pAVar2.JG * com.bytedance.adsdk.Og.JG.JG.pA());
                linearLayout.addView(textView2, this.Bzk);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.omh.setAlpha(f);
        this.omh.addView(linearLayout);
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
        pA(this.omh, (int) (this.SD.pA() * fPA), (int) (this.SD.Og() * fPA));
    }

    private List<String> WV() {
        vZF vzfWQf;
        List<com.bytedance.adsdk.Og.SGo.pA> listKZx;
        if (this.SD == null || this.Og == null || (vzfWQf = this.Og.WQf()) == null) {
            return null;
        }
        String strZZv = this.SD.ZZv();
        if ((!TextUtils.isEmpty(strZZv) || !TextUtils.isEmpty(this.WV)) && (listKZx = this.SD.KZx()) != null) {
            String strPA = this.WV;
            if (TextUtils.isEmpty(strPA)) {
                strPA = vzfWQf.pA(strZZv);
            }
            if (!TextUtils.isEmpty(strPA)) {
                int length = strPA.length();
                this.SGo.clear();
                for (int i = 0; i < listKZx.size(); i++) {
                    com.bytedance.adsdk.Og.SGo.pA pAVar = listKZx.get(i);
                    int iMax = pAVar.pA;
                    int iMax2 = pAVar.Og;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.SGo.add("");
                    } else {
                        if (listKZx.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.SGo.add(strPA.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.SGo;
            }
        }
        return null;
    }

    private static void pA(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void pA(String str) {
        this.WV = str;
    }
}
