package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a12 implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b12 f8352a;

    public a12(b12 socialAdInfo) {
        Intrinsics.checkNotNullParameter(socialAdInfo, "socialAdInfo");
        this.f8352a = socialAdInfo;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewN = uiElements.n();
        if (textViewN != null) {
            textViewN.setText(R.string.monetization_ads_internal_instream_sponsored_social);
            textViewN.setVisibility(0);
            textViewN.setOnClickListener(new z02(this.f8352a, new q82(new p82())));
        }
        ImageView imageViewM = uiElements.m();
        if (imageViewM != null) {
            imageViewM.setImageDrawable(ContextCompat.getDrawable(imageViewM.getContext(), R.drawable.monetization_ads_instream_internal_advertiser_social));
            imageViewM.setVisibility(0);
            imageViewM.setOnClickListener(new z02(this.f8352a, new q82(new p82())));
        }
    }
}
