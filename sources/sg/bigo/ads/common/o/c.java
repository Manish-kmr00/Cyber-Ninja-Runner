package sg.bigo.ads.common.o;

import android.content.Context;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13231a = true;

    public static sg.bigo.ads.common.a a(Context context) {
        sg.bigo.ads.common.a aVarA;
        boolean z;
        if (!f13231a) {
            return new sg.bigo.ads.common.a("", true);
        }
        long jA = r.f13300a.a(15);
        try {
            aVarA = d.a(context, jA);
            z = true;
        } catch (b unused) {
            aVarA = null;
            z = false;
        }
        if (aVarA != null) {
            return aVarA;
        }
        try {
            aVarA = a.a(context, jA);
        } catch (b unused2) {
            if (!z) {
                f13231a = false;
            }
        }
        return aVarA != null ? aVarA : new sg.bigo.ads.common.a("", true);
    }
}
