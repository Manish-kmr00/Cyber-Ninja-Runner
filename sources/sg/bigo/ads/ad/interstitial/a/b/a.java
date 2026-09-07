package sg.bigo.ads.ad.interstitial.a.b;

import android.content.Context;
import android.view.View;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public interface a {

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.b.a$a, reason: collision with other inner class name */
    public static final class C0827a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Set<Integer> f12646a = new HashSet();

        public final void a(sg.bigo.ads.api.core.c cVar, int i, long j) {
            if (this.f12646a.contains(Integer.valueOf(i))) {
                return;
            }
            this.f12646a.add(Integer.valueOf(i));
            sg.bigo.ads.core.d.b.a(cVar, i, j, (String) null, -1, (String) null, (String) null);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, int i, long j, String str, int i2, String str2, String str3) {
            if (this.f12646a.contains(Integer.valueOf(i))) {
                return;
            }
            this.f12646a.add(Integer.valueOf(i));
            sg.bigo.ads.core.d.b.a(cVar, i, j, str, i2, str2, str3);
        }
    }

    View a();

    void a(int i);

    void a(int i, int i2);

    boolean a(Context context);

    boolean b();

    void c();

    void d();

    void e();

    void f();
}
