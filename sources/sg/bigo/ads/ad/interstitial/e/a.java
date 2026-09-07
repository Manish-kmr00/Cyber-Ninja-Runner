package sg.bigo.ads.ad.interstitial.e;

import android.content.Context;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RealtimeBlurLinearLayout f12793a;
    public final ViewFlow b;
    public final int c;

    private a(RealtimeBlurLinearLayout realtimeBlurLinearLayout, int i) {
        this.f12793a = realtimeBlurLinearLayout;
        this.b = (ViewFlow) realtimeBlurLinearLayout.findViewById(R.id.inter_icon_ads_view_flow);
        this.c = i;
    }

    public static a a(Context context, sg.bigo.ads.ad.interstitial.e.a.b bVar, List<NativeAd> list) {
        int i;
        d fVar;
        ViewFlow viewFlow;
        int iA = 0;
        a aVar = new a((RealtimeBlurLinearLayout) sg.bigo.ads.common.utils.a.a(context, R.layout.bigo_ad_layout_interstitial_icon_view_flow, null, false), (int) bVar.h());
        aVar.b.setViewStyle(3);
        aVar.b.setDividerWidth(0);
        switch (bVar.c()) {
            case 1:
            case 3:
                viewFlow = aVar.b;
                iA = sg.bigo.ads.common.utils.e.a(context, 20);
                viewFlow.setContentMaxWidthSpace(iA);
                break;
            case 2:
            case 4:
                viewFlow = aVar.b;
                viewFlow.setContentMaxWidthSpace(iA);
                break;
            case 5:
            case 6:
                aVar.b.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context, 47));
                ((ViewGroup.MarginLayoutParams) aVar.b.getLayoutParams()).bottomMargin = 0;
                break;
        }
        while (!k.a((Collection) list)) {
            sg.bigo.ads.ad.interstitial.e.b.a aVar2 = new sg.bigo.ads.ad.interstitial.e.b.a(context);
            if (!k.a((Collection) list)) {
                int iC = bVar.c();
                if (iC == 3 || iC == 4) {
                    i = 2;
                } else if (iC != 5) {
                    i = iC != 6 ? 4 : 6;
                } else {
                    i = 3;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (NativeAd nativeAd : list) {
                    if (arrayList.size() < i) {
                        arrayList.add(nativeAd);
                    } else {
                        arrayList2.add(nativeAd);
                    }
                }
                int iC2 = bVar.c();
                if (iC2 == 2) {
                    fVar = new f(aVar2, arrayList, bVar);
                } else if (iC2 == 3) {
                    fVar = new g(aVar2, arrayList, bVar);
                } else if (iC2 == 4) {
                    fVar = new h(aVar2, arrayList, bVar);
                } else if (iC2 != 5) {
                    fVar = iC2 != 6 ? new e(aVar2, arrayList, bVar) : new j(aVar2, arrayList, bVar);
                } else {
                    fVar = new i(aVar2, arrayList, bVar);
                }
                fVar.a(aVar);
                aVar2.f12797a = fVar;
                list = arrayList2;
            }
            ViewFlow.b bVar2 = new ViewFlow.b();
            bVar2.width = -1;
            bVar2.height = -2;
            bVar2.e = 48;
            bVar2.d = 3;
            aVar.b.addView(aVar2, bVar2);
        }
        return aVar;
    }
}
