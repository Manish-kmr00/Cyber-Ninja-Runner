package sg.bigo.ads.common;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13212a;

        public a(String str) {
            this.f13212a = str;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String a() {
            return this.f13212a;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String b() {
            return this.f13212a;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String c() {
            return "";
        }

        @Override // sg.bigo.ads.common.k.b
        public final boolean d() {
            return false;
        }
    }

    public interface b {
        String a();

        String b();

        String c();

        boolean d();
    }

    b a(String str);
}
