package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12647a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    private static final /* synthetic */ b[] p;
    public final int f;
    public final int g;
    private final int h;
    private final sg.bigo.ads.common.ab.b i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;

    static {
        b bVar = new b("WHITE", 0, null, d.b, -10525849, 2, 1, 1);
        f12647a = bVar;
        sg.bigo.ads.common.ab.b bVarA = sg.bigo.ads.common.ab.b.a(1, 1, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i = d.f12709a;
        b bVar2 = new b("DKGRAY_TRANSLUCENT", 1, bVarA, i, i, 0, 2, 2);
        b = bVar2;
        sg.bigo.ads.common.ab.b bVarA2 = sg.bigo.ads.common.ab.b.a(1, 1, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i2 = d.f12709a;
        b bVar3 = new b("MAIN_COLOR_TRANSLUCENT", 2, bVarA2, i2, i2, 0, 2, 2);
        c = bVar3;
        sg.bigo.ads.common.ab.b bVarA3 = sg.bigo.ads.common.ab.b.a(4, 2, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i3 = d.f12709a;
        b bVar4 = new b("LTGRAY_BLUR", 3, bVarA3, i3, i3, 0, 2, 2);
        d = bVar4;
        sg.bigo.ads.common.ab.b bVarA4 = sg.bigo.ads.common.ab.b.a(4, 2, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i4 = d.f12709a;
        b bVar5 = new b("MAIN_COLOR_BLUR", 4, bVarA4, i4, i4, 0, 2, 2);
        e = bVar5;
        p = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    /* JADX WARN: Incorrect types in method signature: (Lsg/bigo/ads/common/ab/b;IIIIIII)V */
    private b(String str, int i, sg.bigo.ads.common.ab.b bVar, int i2, int i3, int i4, int i5, int i6) {
        super(str, i);
        this.i = bVar;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.j = i5;
        this.k = i6;
        this.l = -1;
        this.m = 134217728;
        this.n = 1;
        this.o = 8;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) p.clone();
    }

    public final void a(View view) {
        if (view != null) {
            sg.bigo.ads.common.e.a.a(view, sg.bigo.ads.common.utils.e.a(view.getContext(), this.j));
        }
    }

    public final void a(TextView textView, TextView textView2) {
        Context context;
        if (textView == null && textView2 == null) {
            return;
        }
        if (textView != null) {
            context = textView.getContext();
            textView.setTextColor(this.f);
        } else {
            context = null;
        }
        if (textView2 != null) {
            if (context == null) {
                context = textView2.getContext();
            }
            textView2.setTextColor(this.g);
        }
        sg.bigo.ads.common.ab.b bVar = this.i;
        if (bVar == null) {
            if (textView != null) {
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (textView2 != null) {
                textView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                return;
            }
            return;
        }
        int iA = sg.bigo.ads.common.utils.e.a(context, bVar.f13127a);
        int iA2 = sg.bigo.ads.common.utils.e.a(context, bVar.b);
        int iA3 = sg.bigo.ads.common.utils.e.a(context, bVar.c);
        if (textView != null) {
            textView.setShadowLayer(iA, iA2, iA3, bVar.d);
        }
        if (textView2 != null) {
            textView2.setShadowLayer(iA, iA2, iA3, bVar.d);
        }
    }

    public final void a(RoundedImageView roundedImageView) {
        if (roundedImageView == null) {
            return;
        }
        roundedImageView.setCornerRadius(sg.bigo.ads.common.utils.e.a(roundedImageView.getContext(), this.o));
    }

    public final void b(View view) {
        if (view != null) {
            sg.bigo.ads.common.e.a.a(view, sg.bigo.ads.common.utils.e.a(view.getContext(), this.h));
        }
    }
}
