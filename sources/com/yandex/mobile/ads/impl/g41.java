package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g41 implements f41 {
    @Override // com.yandex.mobile.ads.impl.f41
    public final View a(View container, String assetName) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CheckBox b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CustomizableMediaView c(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (CustomizableMediaView) container.findViewById(R.id.media);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView d(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.price);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView e(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.call_to_action);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView f(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.warning);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView g(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (ImageView) container.findViewById(R.id.favicon);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView h(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.age);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final View i(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.findViewById(R.id.rating);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView j(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.title);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ProgressBar k(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView l(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (ImageView) container.findViewById(R.id.feedback);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView m(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.sponsored);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView n(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.domain);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView o(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (ImageView) container.findViewById(R.id.icon);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView p(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.review_count);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (TextView) container.findViewById(R.id.body);
    }
}
