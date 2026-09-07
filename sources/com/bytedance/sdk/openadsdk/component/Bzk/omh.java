package com.bytedance.sdk.openadsdk.component.Bzk;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class omh {
    private static Drawable Og;
    private static boolean pA;
    private aBv KZx;
    private TextView ZZv;

    public void pA(KZx kZx, yFO yfo, float f, float f2, boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (kZx != null) {
            this.KZx = kZx.getHostAppIcon();
            this.ZZv = kZx.getHostAppName();
            View userInfo = kZx.getUserInfo();
            if (kZx instanceof ZZv) {
                aBv abv = this.KZx;
                if (abv != null && (layoutParams2 = abv.getLayoutParams()) != null) {
                    if (yfo.rtW() == 1) {
                        int iKZx = Vgu.KZx(this.KZx.getContext(), 40.0f);
                        layoutParams2.width = iKZx;
                        layoutParams2.height = iKZx;
                    } else {
                        int iKZx2 = Vgu.KZx(this.KZx.getContext(), 30.0f);
                        layoutParams2.width = iKZx2;
                        layoutParams2.height = iKZx2;
                    }
                    this.KZx.setLayoutParams(layoutParams2);
                }
                if (this.ZZv != null) {
                    if (yfo.rtW() == 1) {
                        this.ZZv.setTextSize(30.0f);
                    } else {
                        this.ZZv.setTextSize(24.0f);
                    }
                }
                if (userInfo != null && (layoutParams = userInfo.getLayoutParams()) != null) {
                    if (yfo.rtW() == 1) {
                        layoutParams.height = Vgu.KZx(userInfo.getContext(), 107.0f);
                    } else {
                        layoutParams.height = Vgu.KZx(userInfo.getContext(), 60.0f);
                    }
                    userInfo.setLayoutParams(layoutParams);
                }
            }
            if (userInfo != null) {
                userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.Bzk.omh.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/Bzk/omh$1;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view);
                        safedk_omh$1_onClick_f06dc0a2d03d9c4b4a2ef44d716323dc(view);
                    }

                    public void safedk_omh$1_onClick_f06dc0a2d03d9c4b4a2ef44d716323dc(View p0) {
                    }
                });
            }
        }
    }

    public void pA() {
        String strJG = Bzk.Og().JG();
        if (TextUtils.isEmpty(strJG)) {
            this.ZZv.setVisibility(8);
        } else {
            this.ZZv.setText(strJG);
        }
        Og();
        try {
            Drawable drawable = Og;
            if (drawable == null) {
                this.KZx.setVisibility(8);
                return;
            }
            this.KZx.setImageDrawable(drawable);
            if (this.ZZv.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.KZx.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.KZx.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.KZx.setVisibility(8);
        }
    }

    public void Og() {
        if (pA) {
            return;
        }
        try {
            int iSD = Bzk.Og().SD();
            if (iSD != 0) {
                Og = com.bytedance.sdk.openadsdk.core.aBv.pA().getResources().getDrawable(iSD);
            }
            pA = true;
        } catch (Throwable unused) {
            pA = true;
        }
    }

    public static Drawable KZx() {
        return Og;
    }
}
