package sg.bigo.ads.controller.a.a;

import java.util.Collection;
import java.util.List;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes8.dex */
public abstract class g {
    public static final long c = r.f13300a.a(30);

    protected static <T extends a> T a(List<T> list) {
        if (k.a((Collection) list)) {
            return null;
        }
        T t = (T) k.a((List) list);
        if (t != null) {
            t.d = false;
        }
        return t;
    }

    public abstract sg.bigo.ads.controller.a.k a(String str);

    public void a(boolean z) {
    }

    public String toString() {
        return super.toString();
    }
}
