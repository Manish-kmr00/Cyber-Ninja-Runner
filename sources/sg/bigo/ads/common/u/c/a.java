package sg.bigo.ads.common.u.c;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import sg.bigo.ads.common.utils.h;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13275a;
    public final InputStream b;
    public final h<List<String>> c;
    private final int d;
    private final Closeable e;

    public a(int i, int i2, InputStream inputStream, h<List<String>> hVar, Closeable closeable) {
        this.d = i;
        this.f13275a = i2;
        this.b = inputStream;
        this.c = hVar;
        this.e = closeable;
    }

    public final long a() {
        String strA = a("Content-Length");
        if (q.b((CharSequence) strA)) {
            try {
                return Long.parseLong(strA);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    public final String a(String str) {
        List<String> listA;
        if (!TextUtils.isEmpty(str) && (listA = this.c.a(str)) != null && !listA.isEmpty()) {
            for (String str2 : listA) {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        }
        return "";
    }
}
