package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.KZx.SGo;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class TTDislikeDialogAbstract extends Dialog implements SGo.Og {
    protected final SGo KZx;
    private String ML;
    protected List<FilterWord> Og;
    private View ZZv;
    protected String pA;

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract View getLayoutView();

    public TTDislikeDialogAbstract(Context context) {
        super(context);
        SGo sGo = new SGo();
        this.KZx = sGo;
        sGo.pA(this);
    }

    public TTDislikeDialogAbstract(Context context, int i, String str) {
        super(context, i);
        this.ML = str;
        SGo sGo = new SGo();
        this.KZx = sGo;
        sGo.pA(this);
    }

    public SGo getDislikeManager() {
        return this.KZx;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View layoutView = getLayoutView();
        this.ZZv = layoutView;
        if (layoutView == null) {
            WV.Og("getLayoutView,layout  may be abnormal, please check");
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.ZZv;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
    }

    public void setMaterialMeta(String str, List<FilterWord> list) {
        this.pA = str;
        this.Og = list;
        this.KZx.pA(str);
        this.KZx.pA(this.Og);
    }

    public void onSuggestionSubmit(String str) {
        SGo sGo = this.KZx;
        if (sGo != null) {
            sGo.KZx(str);
        }
    }

    public void destroy() {
        SGo sGo = this.KZx;
        if (sGo != null) {
            sGo.pA();
        }
    }
}
