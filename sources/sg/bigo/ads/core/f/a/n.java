package sg.bigo.ads.core.f.a;

/* JADX INFO: loaded from: classes12.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13598a;
    public final String b;
    public boolean c;
    public boolean d;

    public n(String str) {
        this.d = false;
        this.f13598a = true;
        this.b = str;
    }

    public n(String str, byte b) {
        this(str);
        this.d = true;
    }

    public String toString() {
        return "{\"Content\":\"" + this.b + "\"}";
    }
}
