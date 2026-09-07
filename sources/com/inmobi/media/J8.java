package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class J8 extends AbstractC3640y8 {
    public final /* synthetic */ K8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J8(K8 k8) {
        super(k8);
        this.e = k8;
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return new Ba(applicationContext, (byte) 0, null, null, false, null, 0L, null, null, 252);
        } catch (Exception e) {
            HashMap map = K8.c;
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof Ba) {
            Ba ba = (Ba) view;
            this.e.getClass();
            try {
                M8 m8 = asset instanceof M8 ? (M8) asset : null;
                ba.a(Ba.N0, adConfig);
                L4 l4 = ba.i;
                if (l4 != null) {
                    String TAG = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "disableUrlsToOpenInExternalApp " + ba);
                }
                ba.v = true;
                Object obj = asset.e;
                String str = obj instanceof String ? (String) obj : null;
                String str2 = m8 != null ? m8.y : null;
                if (str2 != null) {
                    int iHashCode = str2.hashCode();
                    if (iHashCode == -1081286672) {
                        if (!str2.equals("REF_IFRAME")) {
                        }
                        ba.d(str);
                        return;
                    }
                    if (iHashCode == 84303) {
                        if (!str2.equals("URL")) {
                        }
                        ba.d(str);
                        return;
                    } else if (iHashCode != 2228139) {
                        if (iHashCode != 83774455 || !str2.equals("REF_HTML")) {
                        }
                        ba.c(str);
                        return;
                    } else {
                        if (!str2.equals("HTML")) {
                        }
                        ba.c(str);
                        return;
                    }
                }
                ba.d(str);
            } catch (Exception e) {
                Intrinsics.checkNotNullExpressionValue("K8", "TAG");
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof Ba) || ((Ba) view).b0) {
            return;
        }
        super.a(view);
    }
}
