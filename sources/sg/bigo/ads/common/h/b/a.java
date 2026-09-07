package sg.bigo.ads.common.h.b;

/* JADX INFO: loaded from: classes14.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13197a;
    sg.bigo.ads.common.h.a b;
    d c;
    float d;
    int e;
    String f;

    public a(sg.bigo.ads.common.h.a aVar) {
        this.b = aVar;
        this.f13197a = aVar.f13189a;
    }

    protected final void a(long j) {
        this.b.i = j;
    }

    protected final void b(long j) {
        this.b.g = j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13197a.equals(aVar.f13197a) && this.b.d.equals(aVar.b.d) && this.b.c.equals(aVar.b.c);
    }

    public String toString() {
        return this.b.toString();
    }
}
