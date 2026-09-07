package sg.bigo.ads.core.adview;

import android.view.View;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sg.bigo.ads.api.a<?> f13501a;

    protected c(sg.bigo.ads.api.a<?> aVar) {
        this.f13501a = aVar;
    }

    protected final void a(int i) {
        this.f13501a.setTag(Integer.valueOf(i));
    }

    protected void a(View view) {
        u.a(view, this.f13501a, null, -1);
    }

    public boolean a(int i, int i2) {
        return u.a(this.f13501a, i, i2);
    }
}
