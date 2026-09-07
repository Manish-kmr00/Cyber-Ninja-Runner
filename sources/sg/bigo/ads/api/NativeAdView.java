package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import sg.bigo.ads.core.adview.g;

/* JADX INFO: loaded from: classes13.dex */
public class NativeAdView extends a<g> {
    public NativeAdView(Context context) {
        super(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // sg.bigo.ads.api.a
    protected final /* synthetic */ sg.bigo.ads.core.adview.c a() {
        return new g(this);
    }
}
