package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2744kk implements DR {
    public static String[] A01 = {"8tOzOPKLz5DDIwqC88XBXxH90bmVDotF", "YCktuRbEMhZaz9U821mncTHWO05lwCqY", "Eq7g3criU65KDBPK", "XEHycrxPk7FQv1FkL381pmPNBNbKujpl", "niYnM4G6gzmxtC7fq", "sRQOtQAi", "8G5qrnHnaOtx52JqPPi", "6arHmIfqlBfM2iqNpfy3RxuQJelIt1eI"};
    public final WeakReference<C13656e> A00;

    public C2744kk(C13656e c13656e) {
        this.A00 = new WeakReference<>(c13656e);
    }

    private void A00(C13656e c13656e) {
        C1638Hl c1638HlA07 = c13656e.A07();
        if (c1638HlA07 != null && c13656e.A04() != null) {
            c13656e.A04().bringChildToFront(c1638HlA07);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void A3u(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        C13656e c13656e = this.A00.get();
        if (c13656e != null && c13656e.A04() != null) {
            c13656e.A04().addView(view, i, layoutParams);
            A00(c13656e);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void A3v(View view, RelativeLayout.LayoutParams layoutParams) {
        C13656e c13656e = this.A00.get();
        if (c13656e != null && c13656e.A04() != null) {
            c13656e.A04().addView(view, layoutParams);
            A00(c13656e);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void A4Z(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0C(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void A4a(String str, C9I c9i) {
        if (this.A00.get() != null) {
            this.A00.get().A0E(str, c9i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void AAd(String str, C12732n c12732n) {
        if (this.A00.get() != null) {
            WeakReference<C13656e> weakReference = this.A00;
            if (A01[4].length() == 0) {
                throw new RuntimeException();
            }
            A01[2] = "IO1gKUYJJG6YtU6JnI8y";
            weakReference.get().A0D(str, c12732n);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DR
    public void ACY(int i) {
        C13656e activityApi = this.A00.get();
        if (activityApi != null) {
            activityApi.finish(i);
        }
    }
}
