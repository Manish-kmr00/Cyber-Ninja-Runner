package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h41 implements f41 {
    @Override // com.yandex.mobile.ads.impl.f41
    public final View a(View container, String assetName) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        View viewFindViewWithTag = container.findViewWithTag(assetName);
        if (viewFindViewWithTag instanceof View) {
            return viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CheckBox b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("mute_button");
        if (viewFindViewWithTag instanceof CheckBox) {
            return (CheckBox) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CustomizableMediaView c(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("media");
        if (viewFindViewWithTag instanceof CustomizableMediaView) {
            return (CustomizableMediaView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView d(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("price");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView e(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("call_to_action");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView f(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("warning");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView g(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("favicon");
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView h(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("age");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final View i(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("rating");
        if (viewFindViewWithTag instanceof View) {
            return viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView j(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("title");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ProgressBar k(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("video_progress");
        if (viewFindViewWithTag instanceof ProgressBar) {
            return (ProgressBar) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView l(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("feedback");
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView m(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("sponsored");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView n(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("domain");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView o(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("icon");
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView p(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("review_count");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("body");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }
}
