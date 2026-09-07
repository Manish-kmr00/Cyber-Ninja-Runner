package sg.bigo.ads.controller;

import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements e<sg.bigo.ads.controller.g.a, String, Object> {
    @Override // sg.bigo.ads.controller.e
    public final /* bridge */ /* synthetic */ void a(int i, sg.bigo.ads.controller.g.a aVar, String[] strArr) {
        a(i, strArr);
    }

    public abstract void a(int i, String str);

    public final void a(int i, String... strArr) {
        a(i, (String) k.b(strArr));
    }
}
