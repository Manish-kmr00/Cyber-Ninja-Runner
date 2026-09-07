package sg.bigo.ads.controller.f;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.d.c;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f13464a;
    private final List<InterfaceC0885a> b = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.controller.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0885a {
        void a(boolean z);
    }

    public static synchronized void a(Context context, InterfaceC0885a interfaceC0885a) {
        if (f13464a == null) {
            f13464a = new a();
            sg.bigo.ads.common.d.a.a().a(context, f13464a);
        }
        synchronized (f13464a.b) {
            if (interfaceC0885a != null) {
                f13464a.b.add(interfaceC0885a);
            }
        }
    }

    @Override // sg.bigo.ads.common.d.b
    public final void a(Context context, Intent intent) {
        boolean zB = sg.bigo.ads.common.aa.c.b(context);
        sg.bigo.ads.common.t.a.a(0, 3, "NetworkStateReceiver", "Network state changed, available: ".concat(String.valueOf(zB)));
        synchronized (this.b) {
            for (InterfaceC0885a interfaceC0885a : this.b) {
                if (interfaceC0885a != null) {
                    interfaceC0885a.a(zB);
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "NetworkStateReceiver", "OnNetworkStateChangeListener is null object reference");
                }
            }
        }
    }
}
