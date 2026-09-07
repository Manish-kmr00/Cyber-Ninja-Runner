package com.ogury.ad.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.ogury.ad.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j4 f7278a;
    public final ViewGroup b;
    public final x5 c;
    public final String d;
    public final ImageButton e;
    public final Handler f;

    public d1(j4 adController, ViewGroup root, x5 oguryApi, String closeButtonCallUrl) {
        Intrinsics.checkNotNullParameter(adController, "adController");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(oguryApi, "oguryApi");
        Intrinsics.checkNotNullParameter(closeButtonCallUrl, "closeButtonCallUrl");
        this.f7278a = adController;
        this.b = root;
        this.c = oguryApi;
        this.d = closeButtonCallUrl;
        this.e = new ImageButton(root.getContext());
        this.f = new Handler(Looper.getMainLooper());
        a();
    }

    public static final void a(d1 d1Var, View view) {
        d1Var.f7278a.b(false);
        if (d1Var.d.length() > 0) {
            d1Var.c.a(d1Var.d);
        }
    }

    public final void a() {
        this.e.setBackground(null);
        this.e.setImageResource(R.drawable.btn_ogury_mraid_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        this.e.setLayoutParams(layoutParams);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.ogury.ad.internal.d1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d1.a(this.f$0, view);
            }
        });
        this.e.setVisibility(8);
        this.b.addView(this.e, layoutParams);
    }

    public final void a(long j) {
        this.f.postDelayed(new Runnable() { // from class: com.ogury.ad.internal.d1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                d1.a(this.f$0);
            }
        }, j);
    }

    public static final void a(d1 d1Var) {
        d1Var.e.setVisibility(0);
    }
}
