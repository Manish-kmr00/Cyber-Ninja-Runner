package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes8.dex */
public final class r {
    public static int a(NativeAd nativeAd, int i) {
        Integer numA = a(nativeAd);
        return numA != null ? numA.intValue() : i;
    }

    public static int a(NativeAd nativeAd, int i, boolean[] zArr) {
        int iIntValue;
        boolean z = true;
        if (i == 2) {
            iIntValue = -14972829;
        } else if (i == 3) {
            Integer numA = a(nativeAd);
            if (numA != null) {
                iIntValue = numA.intValue();
            } else {
                z = false;
                iIntValue = -16736769;
            }
        } else {
            iIntValue = -16736769;
        }
        a(zArr, z);
        return iIntValue;
    }

    public static int a(sg.bigo.ads.common.p pVar, int i) {
        sg.bigo.ads.common.t.a.a(0, 3, "interNo6", "layoutStyle:" + i + "...materialSize:" + pVar);
        if ((31 != i && 32 != i) || !pVar.a()) {
            return R.layout.bigo_ad_activity_interstitial_native_center;
        }
        if (pVar.getWidth() / pVar.getHeight() > 0) {
            return R.layout.bigo_ad_activity_interstitial_rich_video_land_material_31_32;
        }
        return 31 == i ? R.layout.bigo_ad_activity_interstitial_rich_video_left_material_31 : R.layout.bigo_ad_activity_interstitial_rich_video_right_material_32;
    }

    public static Bitmap a(Context context, sg.bigo.ads.ad.b.c cVar, f fVar, g gVar) {
        return a(context, cVar, fVar, gVar, false);
    }

    public static Bitmap a(Context context, sg.bigo.ads.ad.b.c cVar, f fVar, g gVar, boolean z) {
        if (context == null || gVar == null) {
            return null;
        }
        String creativeId = fVar != null ? fVar.c : "";
        if (cVar != null && sg.bigo.ads.common.utils.q.a((CharSequence) creativeId)) {
            creativeId = cVar.getCreativeId();
        }
        return sg.bigo.ads.common.utils.d.a(context, (sg.bigo.ads.ad.b.f.a(creativeId, 4) * 0.5f) + 3.5f, gVar.f, gVar.d, gVar.e, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Integer a(NativeAd nativeAd) {
        Integer numF;
        if (!(nativeAd instanceof sg.bigo.ads.ad.b.e) || (numF = ((sg.bigo.ads.ad.b.e) nativeAd).F()) == null) {
            return null;
        }
        return numF;
    }

    public static sg.bigo.ads.common.p a(sg.bigo.ads.ad.b.c cVar) {
        if (cVar == null) {
            return new sg.bigo.ads.common.p(-1, -1);
        }
        sg.bigo.ads.api.core.n nVarAU = ((sg.bigo.ads.core.a.a) cVar.f()).aU();
        if (nVarAU != null) {
            sg.bigo.ads.common.p pVar = new sg.bigo.ads.common.p(nVarAU.f13112a, nVarAU.b);
            if (pVar.a()) {
                return pVar;
            }
        }
        if (cVar instanceof sg.bigo.ads.ad.b.d) {
            sg.bigo.ads.core.f.a.p pVar2 = ((sg.bigo.ads.ad.b.d) cVar).I;
            if (pVar2 != null) {
                sg.bigo.ads.common.p pVar3 = new sg.bigo.ads.common.p(pVar2.x, pVar2.w);
                if (pVar3.a()) {
                    return pVar3;
                }
            }
            sg.bigo.ads.api.core.o.c cVarAx = ((sg.bigo.ads.core.a.a) cVar.f()).ax();
            if (cVarAx != null) {
                sg.bigo.ads.common.p pVar4 = new sg.bigo.ads.common.p(cVarAx.a(), cVarAx.b());
                if (pVar4.a()) {
                    return pVar4;
                }
            }
        } else {
            sg.bigo.ads.api.core.o.a[] aVarArrAw = ((sg.bigo.ads.core.a.a) cVar.f()).aw();
            if (!sg.bigo.ads.common.utils.k.a(aVarArrAw)) {
                for (int i = 0; i < aVarArrAw.length && aVarArrAw[i] != null; i++) {
                    sg.bigo.ads.common.p pVar5 = new sg.bigo.ads.common.p(aVarArrAw[i].a(), aVarArrAw[i].b());
                    if (pVar5.a()) {
                        return pVar5;
                    }
                }
            }
        }
        return new sg.bigo.ads.common.p(-1, -1);
    }

    private static void a(boolean[] zArr, boolean z) {
        if (sg.bigo.ads.common.utils.k.a(zArr)) {
            return;
        }
        zArr[0] = z;
    }
}
