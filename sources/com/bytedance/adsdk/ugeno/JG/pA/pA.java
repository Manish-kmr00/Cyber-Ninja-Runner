package com.bytedance.adsdk.ugeno.JG.pA;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.JG.ZZv;
import com.bytedance.adsdk.ugeno.SD.omh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends LinearLayout {
    private int Bzk;
    private int JG;
    private int KZx;
    private int ML;
    private int Og;
    private int SD;
    private Context ZZv;
    private boolean omh;
    private List<View> pA;

    public pA(Context context) {
        super(context);
        this.Og = SupportMenu.CATEGORY_MASK;
        this.KZx = -16776961;
        this.ML = 5;
        this.JG = 20;
        this.SD = 20;
        this.ZZv = context;
        this.pA = new ArrayList();
        pA();
    }

    public void pA(int i, int i2) {
        Iterator<View> it = this.pA.iterator();
        while (it.hasNext()) {
            it.next().setBackground(Og(this.KZx));
        }
        if (i < 0 || i >= this.pA.size()) {
            i = 0;
        }
        if (this.pA.size() > 0) {
            this.pA.get(i).setBackground(Og(this.Og));
            this.Bzk = i2;
        }
    }

    public int getSize() {
        return this.pA.size();
    }

    public void pA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setGravity(17);
        setOrientation(0);
        layoutParams.bottomMargin = (int) omh.pA(this.ZZv, 10.0f);
        setLayoutParams(layoutParams);
    }

    public void setSelectedColor(int i) {
        this.Og = i;
    }

    public void setLoop(boolean z) {
        this.omh = z;
    }

    public void setUnSelectedColor(int i) {
        this.KZx = i;
    }

    public void pA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.JG, this.SD);
        layoutParams.leftMargin = this.ML;
        layoutParams.rightMargin = this.ML;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.JG, this.SD);
        layoutParams2.leftMargin = this.ML;
        layoutParams2.rightMargin = this.ML;
        int iPA = ZZv.pA(this.omh, this.Bzk, this.pA.size());
        int iPA2 = ZZv.pA(this.omh, i, this.pA.size());
        if (this.pA.size() == 0) {
            iPA2 = 0;
        }
        if (!this.pA.isEmpty() && ZZv.pA(iPA, this.pA) && ZZv.pA(iPA2, this.pA)) {
            this.pA.get(iPA).setBackground(Og(this.KZx));
            this.pA.get(iPA).setLayoutParams(layoutParams2);
            this.pA.get(iPA2).setBackground(Og(this.Og));
            this.pA.get(iPA2).setLayoutParams(layoutParams);
            this.Bzk = i;
        }
    }

    public void Og() {
        View view = new View(getContext());
        view.setClickable(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.JG, this.SD);
        layoutParams.leftMargin = this.ML;
        layoutParams.rightMargin = this.ML;
        addView(view, layoutParams);
        view.setBackground(Og(this.KZx));
        this.pA.add(view);
    }

    private GradientDrawable Og(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
