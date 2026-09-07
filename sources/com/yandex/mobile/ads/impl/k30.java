package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.lifecycle.LifecycleOwner;
import com.yandex.div.R;
import com.yandex.div.core.Div2Context;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.view2.Div2View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k30 {
    public static Div2View a(Context context, DivConfiguration divConfiguration, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(divConfiguration, "divConfiguration");
        return new Div2View(new Div2Context(new ContextThemeWrapper(context, R.style.Div), divConfiguration, 0, lifecycleOwner, 4, null), null, 0, 6, null);
    }
}
