package sg.bigo.ads.core.f.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f13585a;
    final int b;
    public final String c;
    public final String d;
    public final String e;
    private final int f;
    private final int g;

    public b(int i, int i2, int i3, int i4, String str, String str2, String str3) {
        this.f13585a = i;
        this.b = i2;
        this.g = i4;
        this.c = str;
        this.f = i3;
        this.d = str2;
        this.e = str3;
    }

    public final boolean a() {
        return TextUtils.equals(this.d, "application/javascript");
    }
}
