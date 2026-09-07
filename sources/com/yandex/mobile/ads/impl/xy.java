package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xy implements gc {
    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewN = uiElements.n();
        if (textViewN != null) {
            textViewN.setText(R.string.monetization_ads_internal_instream_sponsored_default);
            textViewN.setVisibility(0);
        }
        ImageView imageViewM = uiElements.m();
        if (imageViewM != null) {
            imageViewM.setImageDrawable(ContextCompat.getDrawable(imageViewM.getContext(), R.drawable.monetization_ads_instream_internal_advertiser));
            imageViewM.setVisibility(0);
        }
    }
}
