package sg.bigo.ads.controller.a;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13395a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final String e;

    public h(String str, boolean z) {
        this(str, true, z, 0, "success");
    }

    public h(String str, boolean z, boolean z2, int i, String str2) {
        this.f13395a = str;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = str2;
    }

    public static h a(String str, boolean z, int i, String str2) {
        return new h(str, false, z, i, str2);
    }

    public final String toString() {
        return super.toString();
    }
}
