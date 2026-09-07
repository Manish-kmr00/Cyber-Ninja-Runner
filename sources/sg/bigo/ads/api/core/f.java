package sg.bigo.ads.api.core;

import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T extends Ad> implements AdLoadListener<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdLoadListener<T> f13103a;

    public f() {
    }

    public f(AdLoadListener<T> adLoadListener) {
        this.f13103a = adLoadListener;
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public final void onAdLoaded(final T t) {
        if (this.f13103a != null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.f.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.f13103a.onAdLoaded(t);
                }
            });
        }
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public final void onError(final AdError adError) {
        if (this.f13103a != null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.f13103a.onError(adError);
                }
            });
        }
    }
}
