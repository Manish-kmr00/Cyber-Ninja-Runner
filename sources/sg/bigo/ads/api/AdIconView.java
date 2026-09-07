package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.p.g;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class AdIconView extends a<sg.bigo.ads.core.adview.a> {
    public AdIconView(Context context) {
        super(context);
    }

    public AdIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // sg.bigo.ads.api.a
    protected final /* synthetic */ sg.bigo.ads.core.adview.c a() {
        return new sg.bigo.ads.core.adview.a(this);
    }

    public final void a(String str, boolean z) {
        getViewImpl().a(null, str, z, null);
    }

    public final void a(Executor executor, String str, boolean z, g gVar) {
        getViewImpl().a(executor, str, z, gVar);
    }
}
