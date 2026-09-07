package sg.bigo.ads.ad.banner;

import android.os.SystemClock;
import java.util.Map;
import java.util.WeakHashMap;
import sg.bigo.ads.api.Ad;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<InterfaceC0816b, a> f12527a = new WeakHashMap();

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f12528a;

        private a() {
            this.f12528a = new long[9];
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.banner.b$b, reason: collision with other inner class name */
    public interface InterfaceC0816b {
    }

    public static <T extends Ad> long a(InterfaceC0816b interfaceC0816b, long j) {
        if (j == -1) {
            return -1L;
        }
        return j - j(interfaceC0816b).f12528a[4];
    }

    public static <T extends Ad> void a(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 0);
    }

    private static <T extends Ad> void a(InterfaceC0816b interfaceC0816b, int i) {
        j(interfaceC0816b).f12528a[i] = SystemClock.elapsedRealtime();
    }

    public static <T extends Ad> void b(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 1);
    }

    public static <T extends Ad> void c(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 2);
    }

    public static <T extends Ad> void d(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 3);
    }

    public static <T extends Ad> void e(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 4);
    }

    public static <T extends Ad> void f(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 5);
    }

    public static <T extends Ad> void g(InterfaceC0816b interfaceC0816b) {
        a(interfaceC0816b, 6);
    }

    public static <T extends Ad> void h(InterfaceC0816b interfaceC0816b) {
        f12527a.remove(interfaceC0816b);
    }

    public static <T extends Ad> long i(InterfaceC0816b interfaceC0816b) {
        a aVarJ = j(interfaceC0816b);
        return aVarJ.f12528a[6] - aVarJ.f12528a[4];
    }

    private static <T extends Ad> a j(InterfaceC0816b interfaceC0816b) {
        Map<InterfaceC0816b, a> map = f12527a;
        a aVar = map.get(interfaceC0816b);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a((byte) 0);
        map.put(interfaceC0816b, aVar2);
        return aVar2;
    }
}
