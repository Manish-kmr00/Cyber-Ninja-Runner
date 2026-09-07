package com.bytedance.sdk.openadsdk.KZx;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ZZv extends TTDislikeDialogAbstract {
    private String ML;
    private pA ZZv;

    public interface pA {
        void Og();

        void pA();

        void pA(int i, FilterWord filterWord);
    }

    public ZZv(Context context, String str, List<FilterWord> list, String str2) {
        super(context, yFO.JG(context, "tt_dislikeDialog"), str2);
        this.pA = str;
        this.Og = list;
    }

    public void pA(pA pAVar) {
        this.ZZv = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            pA();
            Og();
            setMaterialMeta(this.pA, this.Og);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    public void pA(String str) {
        this.ML = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public View getLayoutView() {
        return new Bzk(getContext(), this.KZx, this.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(Vgu.KZx(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.Og
    public void pA(int i) {
        FilterWord filterWordOg;
        if (SGo.KZx == i) {
            dismiss();
            return;
        }
        if (SGo.ML == i) {
            pA pAVar = this.ZZv;
            if (pAVar != null) {
                pAVar.pA();
                return;
            }
            return;
        }
        if (SGo.Og != i || (filterWordOg = this.KZx.Og()) == null || SGo.pA.equals(filterWordOg)) {
            return;
        }
        pA pAVar2 = this.ZZv;
        if (pAVar2 != null) {
            try {
                pAVar2.pA(0, filterWordOg);
            } catch (Throwable unused) {
            }
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    private void pA() {
        Window window = getWindow();
        if (window == null || window.getAttributes() == null) {
            return;
        }
        window.getAttributes().windowAnimations = 0;
    }

    private void Og() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.KZx.ZZv.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (ZZv.this.ZZv != null) {
                    pA unused = ZZv.this.ZZv;
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.KZx.ZZv.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ZZv.this.ZZv != null) {
                    ZZv.this.ZZv.Og();
                }
            }
        });
    }
}
