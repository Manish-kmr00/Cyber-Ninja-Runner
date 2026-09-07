package sg.bigo.ads.common.p;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes12.dex */
public final class e {
    public static void a(Context context, String str, boolean z, g gVar) {
        a(context, null, str, z, gVar);
    }

    public static void a(final Context context, final List<String> list, final boolean z, final g gVar) {
        if (list.size() == 0) {
            gVar.a(0, "urlList all download Failed", "");
        } else {
            a(context, list.remove(0), z, new g() { // from class: sg.bigo.ads.common.p.e.1
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i, String str, String str2) {
                    e.a(context, (List<String>) list, z, gVar);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, f fVar) {
                    g gVar2 = gVar;
                    if (gVar2 != null) {
                        gVar2.a(bitmap, fVar);
                    }
                }
            });
        }
    }

    public static void a(Context context, Executor executor, String str, boolean z, g gVar) {
        c(context, executor, str, z, gVar);
    }

    public static boolean a(Context context, String str) {
        return h.a.f13258a.d(context, str);
    }

    public static void b(Context context, Executor executor, String str, boolean z, g gVar) {
        d.a.f13255a.a(context, executor, str, z, gVar);
    }

    private static void c(Context context, Executor executor, String str, boolean z, g gVar) {
        h.a.f13258a.a(context, executor, str, z, gVar);
    }
}
