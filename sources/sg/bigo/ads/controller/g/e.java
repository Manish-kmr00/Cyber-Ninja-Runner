package sg.bigo.ads.controller.g;

import java.util.Map;
import sg.bigo.ads.common.u.a;

/* JADX INFO: loaded from: classes12.dex */
public abstract class e<T extends sg.bigo.ads.common.u.a> extends a<T> {
    private final sg.bigo.ads.controller.b i;
    private final Map<String, Object> j;

    public e(Map<String, Object> map, sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, sg.bigo.ads.controller.b bVar2) {
        super(gVar, bVar);
        this.i = bVar2;
        this.j = map;
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(int i, int i2, String str) {
        this.i.a(a(), i, i2, str, null);
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(String str, Map<String, Object> map) {
        this.i.a(a(), str);
    }

    @Override // sg.bigo.ads.controller.g.a
    protected void a(a.b bVar) {
        for (String str : this.j.keySet()) {
            bVar.a(str, this.j.get(str));
        }
    }
}
