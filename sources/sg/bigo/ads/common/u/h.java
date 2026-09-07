package sg.bigo.ads.common.u;

/* JADX INFO: loaded from: classes11.dex */
public class h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13280a;
    private String b;
    private Exception c;

    public h(int i, String str) {
        this.f13280a = i;
        this.b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Exception exc = this.c;
        return exc != null ? exc.getMessage() : this.b;
    }
}
