package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.pubmatic.sdk.common.POBCommonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.t4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3566t4 implements InterfaceC3635y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3594v4 f3432a;

    public C3566t4(C3594v4 c3594v4) {
        this.f3432a = c3594v4;
    }

    public final void a(String expandInput, EnumC3621x3 inputType, float f, boolean z, long j, Z5 z5) {
        String adType;
        String creativeId;
        String impressionId;
        C3607w3 c3607w3;
        Intrinsics.checkNotNullParameter(expandInput, "expandInput");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        C3594v4 c3594v4 = this.f3432a;
        Activity activity = (Activity) c3594v4.f3454a.get();
        if (activity == null) {
            return;
        }
        if (c3594v4.e == null) {
            C3607w3 c3607w4 = new C3607w3(activity);
            L4 l4 = c3594v4.h;
            if (l4 != null) {
                c3607w4.setLogger(l4);
            }
            c3607w4.setId(65518);
            c3607w4.setEmbeddedBrowserUpdateListener(c3594v4.i);
            c3594v4.e = c3607w4;
        }
        r rVar = c3594v4.b;
        if ((rVar instanceof Ba) && (c3607w3 = c3594v4.e) != null) {
            c3607w3.setUserLeftApplicationListener(((Ba) rVar).getListener());
        }
        C3607w3 c3607w5 = c3594v4.e;
        if (c3607w5 != null) {
            r rVar2 = c3594v4.b;
            if (rVar2 == null || (adType = rVar2.getAdType()) == null) {
                adType = "banner";
            }
            String placementType = adType;
            r rVar3 = c3594v4.b;
            String impressionId2 = (rVar3 == null || (impressionId = rVar3.getImpressionId()) == null) ? "" : impressionId;
            r rVar4 = c3594v4.b;
            String creativeId2 = (rVar4 == null || (creativeId = rVar4.getCreativeId()) == null) ? "" : creativeId;
            Intrinsics.checkNotNullParameter(expandInput, "expandInput");
            Intrinsics.checkNotNullParameter(inputType, "inputType");
            Intrinsics.checkNotNullParameter(placementType, "placementType");
            Intrinsics.checkNotNullParameter(impressionId2, "impressionId");
            Intrinsics.checkNotNullParameter(creativeId2, "creativeId");
            if (c3607w5.c == null) {
                Context context = c3607w5.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                E3 e3 = new E3(context, j, placementType, impressionId2, creativeId2, c3607w5.f);
                c3607w5.c = e3;
                e3.setId(65517);
            }
            E3 e4 = c3607w5.c;
            if (e4 != null) {
                e4.setLandingPageTelemetryControlInfo(z5);
            }
            if (c3607w5.b != expandInput.hashCode()) {
                if (inputType == EnumC3621x3.URL) {
                    E3 e5 = c3607w5.c;
                    if (e5 != null) {
                        e5.loadUrl(expandInput);
                    }
                } else {
                    E3 e6 = c3607w5.c;
                    if (e6 != null) {
                        e6.loadData(expandInput, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, 65533);
                E3 e7 = c3607w5.c;
                if (e7 != null) {
                    e7.setLayoutParams(layoutParams);
                }
                if (c3607w5.findViewById(65517) == null) {
                    c3607w5.addView(c3607w5.c, layoutParams);
                }
            }
            c3607w5.b = expandInput.hashCode();
            if (!z) {
                View viewFindViewById = c3607w5.findViewById(65533);
                if (viewFindViewById != null) {
                    c3607w5.removeView(viewFindViewById);
                }
            } else if (c3607w5.findViewById(65533) == null) {
                float f2 = AbstractC3565t3.d().c;
                LinearLayout linearLayout = new LinearLayout(c3607w5.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setId(65533);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setBackgroundResource(R.drawable.bottom_bar);
                linearLayout.setBackgroundColor(-7829368);
                c3607w5.setBackgroundColor(-7829368);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (48 * f2));
                layoutParams2.addRule(12);
                c3607w5.addView(linearLayout, layoutParams2);
                if (AbstractC3420j2.a(c3607w5.f3464a)) {
                    Ad ad = c3607w5.g;
                    if (ad != null) {
                        ad.a();
                    }
                    c3607w5.g = new Ad(c3607w5.f3464a, new C3593v3(c3607w5, layoutParams2), c3607w5.f);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams3.weight = 25.0f;
                c3607w5.b(linearLayout, layoutParams3);
                c3607w5.d(linearLayout, layoutParams3);
                c3607w5.a(linearLayout, layoutParams3);
                c3607w5.c(linearLayout, layoutParams3);
            }
        }
        float f3 = 1 - f;
        c3594v4.g = f3;
        B b = c3594v4.c;
        if (b != null) {
            b.c = f3;
            b.e();
        }
        c3594v4.c();
    }
}
