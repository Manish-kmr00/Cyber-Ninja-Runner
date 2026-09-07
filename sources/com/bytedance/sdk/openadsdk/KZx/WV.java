package com.bytedance.sdk.openadsdk.KZx;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class WV extends Dialog {
    private String Bzk;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv JG;
    private com.bytedance.sdk.openadsdk.core.ML.Og KZx;
    private com.bytedance.sdk.openadsdk.core.ML.omh ML;
    private pA Og;
    private String SD;
    private final SGo SGo;
    private com.bytedance.sdk.openadsdk.core.ML.omh ZZv;
    private String omh;
    private com.bytedance.sdk.openadsdk.core.ML.ML pA;

    public interface pA {
        void KZx();

        void Og();

        void pA();

        void pA(int i, FilterWord filterWord, String str);
    }

    public WV(Context context, SGo sGo) {
        super(context, yFO.JG(context, "tt_quick_option_dialog"));
        setCanceledOnTouchOutside(false);
        this.SGo = sGo;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA = pA(aBv.pA());
        this.pA = mlPA;
        setContentView(mlPA);
        pA(this.pA);
        KZx();
        pA();
        ZZv();
    }

    private void pA(View view) {
        pA((EditText) this.KZx);
        SGo sGo = this.SGo;
        if (sGo != null) {
            String strSD = sGo.SD();
            if (!TextUtils.isEmpty(strSD)) {
                this.KZx.setText(strSD);
                this.ZZv.setText(String.format(Locale.getDefault(), "%d%s", Integer.valueOf(strSD.length()), "/200"));
            }
            this.ML.setEnabled(!TextUtils.isEmpty(strSD));
        }
        this.ML.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.WV.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/WV$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view2);
                safedk_WV$1_onClick_24fbdd0c6da3a29dd3b4fdc25bd24fbc(view2);
            }

            public void safedk_WV$1_onClick_24fbdd0c6da3a29dd3b4fdc25bd24fbc(View p0) {
                String string = WV.this.KZx.getText().toString();
                if (WV.this.Og != null) {
                    WV.this.Og.pA(4, SGo.pA, string);
                }
                WV.this.dismiss();
            }
        });
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.WV.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/WV$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view2);
                safedk_WV$2_onClick_7e3ea37f37f655d286c933dbf2f926ce(view2);
            }

            public void safedk_WV$2_onClick_7e3ea37f37f655d286c933dbf2f926ce(View p0) {
                if (WV.this.Og != null) {
                    WV.this.Og.Og();
                }
                WV.this.dismiss();
            }
        });
        this.KZx.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.KZx.WV.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                com.bytedance.sdk.openadsdk.core.ML.omh omhVar;
                int iRound = Math.round(charSequence.length());
                WV.this.ZZv.setText(iRound + "/200");
                boolean z = true;
                if (iRound > 0) {
                    if (WV.this.ML.isEnabled()) {
                        return;
                    } else {
                        omhVar = WV.this.ML;
                    }
                } else {
                    omhVar = WV.this.ML;
                    if (WV.this.SGo == null || TextUtils.isEmpty(WV.this.SGo.SD())) {
                        z = false;
                    }
                }
                omhVar.setEnabled(z);
            }
        });
    }

    public static void pA(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.KZx.WV.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(200)});
    }

    private void KZx() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        pA pAVar = this.Og;
        if (pAVar != null) {
            pAVar.pA();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Og();
        super.dismiss();
    }

    public void pA(pA pAVar) {
        this.Og = pAVar;
    }

    public void pA() {
        com.bytedance.sdk.openadsdk.core.ML.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.requestFocus();
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public void Og() {
        InputMethodManager inputMethodManager;
        com.bytedance.sdk.openadsdk.core.ML.Og og = this.KZx;
        if (og == null || (inputMethodManager = (InputMethodManager) og.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.pA.getWindowToken(), 0);
    }

    private void ZZv() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.KZx.WV.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (WV.this.Og != null) {
                    WV.this.Og.KZx();
                }
            }
        });
    }

    public void pA(String str, String str2) {
        this.SD = str;
        this.omh = str2;
        SGo sGo = this.SGo;
        if (sGo != null) {
            sGo.ZZv(str2);
        }
    }

    public void pA(String str) {
        this.Bzk = str;
    }

    private com.bytedance.sdk.openadsdk.core.ML.ML pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ml.setOrientation(1);
        ml.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_dislike_dialog_bg"));
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setLayoutParams(new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 48.0f)));
        this.JG = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        int iKZx = Vgu.KZx(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams.addRule(16);
        layoutParams.addRule(11);
        int iKZx2 = Vgu.KZx(context, 10.0f);
        layoutParams.topMargin = iKZx2;
        layoutParams.rightMargin = iKZx2;
        this.JG.setLayoutParams(layoutParams);
        this.JG.setClickable(true);
        this.JG.setFocusable(true);
        this.JG.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_titlebar_close_seletor"));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(16);
        layoutParams2.topMargin = Vgu.KZx(context, 12.0f);
        omhVar.setLayoutParams(layoutParams2);
        omhVar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        omhVar.setGravity(17);
        omhVar.setSingleLine(true);
        omhVar.setText(yFO.pA(context, "tt_other_reason"));
        omhVar.setTextColor(Color.parseColor("#161823"));
        omhVar.setTextSize(15.0f);
        omhVar.setTypeface(Typeface.defaultFromStyle(0));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 0.5f)));
        view.setBackgroundColor(Color.argb(51, 22, 24, 35));
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ml2.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.ML.Og og = new com.bytedance.sdk.openadsdk.core.ML.Og(context);
        this.KZx = og;
        og.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200), new InputFilter.AllCaps()});
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = Vgu.KZx(context, 16.0f);
        layoutParams3.rightMargin = Vgu.KZx(context, 16.0f);
        layoutParams3.topMargin = Vgu.KZx(context, 11.5f);
        this.KZx.setLayoutParams(layoutParams3);
        this.KZx.setLines(4);
        this.KZx.setGravity(48);
        this.KZx.setHint(yFO.pA(context, "tt_suggestion_description"));
        this.KZx.setTextSize(15.0f);
        this.KZx.setTextColor(Color.rgb(22, 24, 35));
        this.KZx.setHintTextColor(Color.parseColor("#57161823"));
        this.KZx.setBackground(null);
        this.KZx.setImeOptions(268435456);
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int iKZx3 = Vgu.KZx(context, 16.0f);
        int iKZx4 = Vgu.KZx(context, 17.0f);
        ml3.setPadding(iKZx3, iKZx4, iKZx3, iKZx4);
        ml3.setLayoutParams(layoutParams4);
        ml3.setOrientation(0);
        this.ZZv = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = GravityCompat.START;
        this.ZZv.setLayoutParams(layoutParams5);
        this.ZZv.setText(String.format("0%s", "/200"));
        this.ZZv.setGravity(GravityCompat.START);
        this.ZZv.setTextColor(Color.parseColor("#57161823"));
        this.ZZv.setTextSize(15.0f);
        this.ML = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = GravityCompat.END;
        this.ML.setLayoutParams(layoutParams6);
        this.ML.setTextSize(14.0f);
        this.ML.setTextColor(-1);
        this.ML.setVisibility(0);
        this.ML.setSingleLine(true);
        int iKZx5 = Vgu.KZx(context, 27.0f);
        int iKZx6 = Vgu.KZx(context, 5.0f);
        this.ML.setPadding(iKZx5, iKZx6, iKZx5, iKZx6);
        int iKZx7 = Vgu.KZx(context, 6.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = iKZx7;
        gradientDrawable.setCornerRadius(f);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        this.ML.setBackground(stateListDrawable);
        this.ML.setText(yFO.pA(context, "tt_done"));
        this.ML.setEnabled(false);
        ml.addView(sd);
        ml.addView(view);
        ml.addView(ml2);
        sd.addView(this.JG);
        sd.addView(omhVar);
        ml2.addView(this.KZx);
        ml2.addView(ml3);
        ml3.addView(this.ZZv);
        ml3.addView(this.ML);
        return ml;
    }
}
