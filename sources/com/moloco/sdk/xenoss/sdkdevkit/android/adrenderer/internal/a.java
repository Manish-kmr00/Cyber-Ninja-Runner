package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.ogury.ad.OguryBidTokenErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View hideSystemUI$lambda$0 = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 30) {
            b(activity);
        } else {
            Intrinsics.checkNotNullExpressionValue(hideSystemUI$lambda$0, "hideSystemUI$lambda$0");
            a(hideSystemUI$lambda$0);
        }
    }

    public static final void b(Activity activity) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(activity.getWindow(), activity.getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }

    public static final void a(View view) {
        view.setSystemUiVisibility(OguryBidTokenErrorCode.AD_DISABLED_CONSENT_DENIED);
    }
}
