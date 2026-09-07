package sg.bigo.ads.common.x;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f13362a;
        private final C0882a b = new C0882a();

        /* JADX INFO: renamed from: sg.bigo.ads.common.x.c$a$a, reason: collision with other inner class name */
        static class C0882a {
            C0882a() {
            }

            public static void a(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private a() {
        }

        public static a a() {
            if (f13362a == null) {
                f13362a = new a();
            }
            return f13362a;
        }
    }
}
