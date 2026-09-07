package sg.bigo.ads.core.f.a;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends n implements Comparable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13596a;

    public l(String str, float f) {
        super(str);
        this.f13596a = f;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(l lVar) {
        return Double.compare(this.f13596a, lVar.f13596a);
    }

    @Override // sg.bigo.ads.core.f.a.n
    public final String toString() {
        return "{\"Content\":\"" + this.b + "\",\"progress\":\"" + this.f13596a + "\"}";
    }
}
