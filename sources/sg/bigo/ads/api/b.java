package sg.bigo.ads.api;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;
import java.util.UUID;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13094a;
    public final String b;
    public int c;
    public int d;
    public int e;
    public long f;
    public final a g = new a(0);

    public static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13095a;
        public final String b;
        String c;
        String d;
        String e;
        public long f;
        int g;
        String h;
        int i;
        long j;
        public long k;
        private long l;
        private long m;

        private a() {
            this.b = UUID.randomUUID().toString();
            this.f13095a = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.g = 0;
            this.i = 0;
            this.h = "";
            this.j = 0L;
            this.k = 0L;
            this.l = 0L;
            this.m = 0L;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a() {
            if (this.l == 0) {
                this.l = System.currentTimeMillis();
            }
        }

        public final void b() {
            if (this.m == 0) {
                this.m = System.currentTimeMillis();
            }
        }

        @Override // sg.bigo.ads.api.core.h
        public final String c() {
            return this.b;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String d() {
            return this.c;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String e() {
            return this.d;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String f() {
            return this.e;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String g() {
            return this.f13095a;
        }

        @Override // sg.bigo.ads.api.core.h
        public final int h() {
            return this.g;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String i() {
            return this.h;
        }

        @Override // sg.bigo.ads.api.core.h
        public final int j() {
            return this.i;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long k() {
            return this.f;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long l() {
            return this.j;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long m() {
            return this.k;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long n() {
            return this.l;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long o() {
            return this.m;
        }
    }

    public b(String str, String str2) {
        this.f13094a = str;
        this.b = str2;
    }

    public T a() {
        return null;
    }

    public final void a(String str) {
        this.g.f13095a = str;
    }

    public final void a(String str, String str2, String str3) {
        a aVar = this.g;
        aVar.c = str;
        aVar.d = str2;
        aVar.e = str3;
    }

    public boolean a(int i) {
        return i != c();
    }

    public sg.bigo.ads.api.core.d b() {
        if (q.a((CharSequence) this.f13094a)) {
            return new sg.bigo.ads.api.core.d(1019, Sdk.SDKError.Reason.AD_NO_FILL_VALUE, "Please pass slot id when constructing an ad request");
        }
        return null;
    }

    public final void b(int i) {
        a aVar = this.g;
        if (aVar.j == 0) {
            aVar.i = i;
            aVar.j = System.currentTimeMillis();
        }
    }

    public final void b(String str) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.h = str;
        }
    }

    public abstract int c();

    public final void c(int i) {
        this.g.g = i;
    }

    public Map<String, Object> d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public l h() {
        return null;
    }
}
