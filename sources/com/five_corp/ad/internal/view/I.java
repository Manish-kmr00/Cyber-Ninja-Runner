package com.five_corp.ad.internal.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.five_corp.ad.AdReportDialogActivity;

/* JADX INFO: loaded from: classes10.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdReportDialogActivity f1567a;

    public I(AdReportDialogActivity adReportDialogActivity) {
        this.f1567a = adReportDialogActivity;
    }

    public final void a() {
        this.f1567a.finish();
        if (Build.VERSION.SDK_INT < 34) {
            this.f1567a.overridePendingTransition(0, 0);
        }
    }

    public final /* synthetic */ void a(View view) {
        a();
    }

    public final void a(C3045c c3045c) {
        H h = new H(this.f1567a, c3045c);
        h.setOnClickListener(null);
        ViewGroup viewGroup = (ViewGroup) this.f1567a.findViewById(R.id.content);
        viewGroup.setBackgroundColor(0);
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.five_corp.ad.internal.view.I$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        viewGroup.addView(h);
    }
}
