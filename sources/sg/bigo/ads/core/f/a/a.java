package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0894a> f13576a = new ArrayList();
    public final List<C0894a> b = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.core.f.a.a$a, reason: collision with other inner class name */
    public static final class C0894a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13577a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;

        public C0894a(String str, int i, int i2, String str2, String str3) {
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f13577a = str3;
        }

        public final boolean a() {
            return !TextUtils.isEmpty(this.b);
        }

        public final boolean b() {
            return "image/jpeg".equalsIgnoreCase(this.e) || "image/png".equalsIgnoreCase(this.e);
        }

        public final boolean c() {
            return "image/gif".equalsIgnoreCase(this.e);
        }
    }

    public static C0894a a(List<C0894a> list) {
        if (list == null) {
            return null;
        }
        for (C0894a c0894a : list) {
            if (c0894a != null) {
                return c0894a;
            }
        }
        return null;
    }

    public final C0894a a() {
        return a(this.f13576a);
    }
}
