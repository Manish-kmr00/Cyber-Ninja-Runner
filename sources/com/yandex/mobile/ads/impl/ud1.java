package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ud1 implements f41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10379a;

    @Override // com.yandex.mobile.ads.impl.f41
    public final View a(View container, String assetName) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        View viewFindViewWithTag = container.findViewWithTag(assetName + "_" + this.f10379a);
        if (viewFindViewWithTag instanceof View) {
            return viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CheckBox b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("mute_button_" + this.f10379a);
        if (viewFindViewWithTag instanceof CheckBox) {
            return (CheckBox) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final CustomizableMediaView c(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("media_" + this.f10379a);
        if (viewFindViewWithTag instanceof CustomizableMediaView) {
            return (CustomizableMediaView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView d(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("price_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView e(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("call_to_action_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView f(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("warning_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView g(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("favicon_" + this.f10379a);
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView h(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("age_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final View i(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("rating_" + this.f10379a);
        if (viewFindViewWithTag instanceof View) {
            return viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView j(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("title_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ProgressBar k(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (ProgressBar) container.findViewWithTag("video_progress_" + this.f10379a);
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView l(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("feedback_" + this.f10379a);
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView m(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("sponsored_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView n(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("domain_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final ImageView o(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("icon_" + this.f10379a);
        if (viewFindViewWithTag instanceof ImageView) {
            return (ImageView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView p(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("review_count_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    public ud1(int i) {
        this.f10379a = i;
    }

    @Override // com.yandex.mobile.ads.impl.f41
    public final TextView a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("body_" + this.f10379a);
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }
}
