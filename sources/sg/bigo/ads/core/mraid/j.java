package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes12.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Rect f13664a = new Rect();
    final Rect b = new Rect();
    final Rect c = new Rect();
    final Rect d = new Rect();
    final Rect e = new Rect();
    final Rect f = new Rect();
    final Rect g = new Rect();
    final Rect h = new Rect();
    private final Context i;
    private final float j;

    j(Context context, float f) {
        this.i = context.getApplicationContext();
        this.j = f;
    }

    final void a(Rect rect, Rect rect2) {
        rect2.set(sg.bigo.ads.common.utils.e.a(this.i, rect.left), sg.bigo.ads.common.utils.e.a(this.i, rect.top), sg.bigo.ads.common.utils.e.a(this.i, rect.right), sg.bigo.ads.common.utils.e.a(this.i, rect.bottom));
    }
}
