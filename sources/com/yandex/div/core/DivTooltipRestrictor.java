package com.yandex.div.core;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div2.DivTooltip;

/* JADX INFO: loaded from: classes7.dex */
public interface DivTooltipRestrictor {
    public static final DivTooltipRestrictor STUB = new DivTooltipRestrictor() { // from class: com.yandex.div.core.DivTooltipRestrictor$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.DivTooltipRestrictor
        public final boolean canShowTooltip(Div2View div2View, View view, DivTooltip divTooltip, boolean z) {
            return DivTooltipRestrictor.lambda$static$0(div2View, view, divTooltip, z);
        }
    };

    public interface DivTooltipShownCallback {
        void onDivTooltipDismissed(Div2View div2View, View view, DivTooltip divTooltip);

        void onDivTooltipShown(Div2View div2View, View view, DivTooltip divTooltip);
    }

    static /* synthetic */ boolean lambda$static$0(Div2View div2View, View view, DivTooltip divTooltip, boolean z) {
        return true;
    }

    boolean canShowTooltip(Div2View div2View, View view, DivTooltip divTooltip, boolean z);

    default DivTooltipShownCallback getTooltipShownCallback() {
        return null;
    }
}
