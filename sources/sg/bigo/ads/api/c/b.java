package sg.bigo.ads.api.c;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static int h = 0;
    public static int i = 3;
    private static boolean j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13096a = 1;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public long f = -1;
    public boolean g = false;

    public static void a() {
        i = 1;
    }

    public static void a(int i2) {
        h = i2;
    }

    public static void a(boolean z) {
        j = z;
    }

    public static int b() {
        return h;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static b b(int i2) {
        b bVar = new b();
        if (j) {
            bVar.g = true;
            bVar.c = true;
            bVar.b = true;
            bVar.f = 2000L;
        } else if (i2 == 2) {
            bVar.g = true;
            bVar.c = true;
            bVar.b = true;
            bVar.f = 2000L;
            bVar.f13096a = 4;
        } else {
            if (i2 == 3) {
                bVar.g = true;
                bVar.c = true;
            } else if (i2 != 4) {
                if (i2 == 12) {
                    bVar.g = true;
                    bVar.c = true;
                    bVar.b = true;
                    bVar.f = 2000L;
                } else if (i2 == 20) {
                    bVar.c = true;
                }
                bVar.f13096a = 4;
            } else {
                bVar.g = true;
                bVar.c = true;
                bVar.b = true;
            }
            bVar.f = 2000L;
            bVar.f13096a = i;
        }
        i = 3;
        return bVar;
    }
}
