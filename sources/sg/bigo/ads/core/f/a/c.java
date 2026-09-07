package sg.bigo.ads.core.f.a;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends n implements Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13586a;

    public c(String str, int i) {
        super(str);
        this.f13586a = i;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
        return this.f13586a - cVar.f13586a;
    }

    @Override // sg.bigo.ads.core.f.a.n
    public final String toString() {
        return "{\"Content\":\"" + this.b + "\",\"pro_ms\":\"" + this.f13586a + "\"}";
    }
}
