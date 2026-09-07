package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m71 f9513a;
    private final kg b;
    private final List<ig<?>> c;

    /* JADX WARN: Multi-variable type inference failed */
    public lg(m71 nativeAdWeakViewProvider, kg assetAdapterCreator, List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(nativeAdWeakViewProvider, "nativeAdWeakViewProvider");
        Intrinsics.checkNotNullParameter(assetAdapterCreator, "assetAdapterCreator");
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.f9513a = nativeAdWeakViewProvider;
        this.b = assetAdapterCreator;
        this.c = assets;
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        kg kgVar = this.b;
        View viewA = this.f9513a.a("close_button");
        TextView textView = viewA instanceof TextView ? (TextView) viewA : null;
        kgVar.getClass();
        tp tpVar = textView != null ? new tp(textView) : null;
        map.put("close_button", tpVar != null ? new cz(tpVar) : null);
        kg kgVar2 = this.b;
        View viewA2 = this.f9513a.a("feedback");
        map.put("feedback", kgVar2.a(viewA2 instanceof ImageView ? (ImageView) viewA2 : null));
        kg kgVar3 = this.b;
        ImageView imageViewB = this.f9513a.b();
        View viewA3 = this.f9513a.a("media");
        map.put("media", kgVar3.a(imageViewB, viewA3 instanceof CustomizableMediaView ? (CustomizableMediaView) viewA3 : null));
        map.put("rating", this.b.a(this.f9513a.a("rating")));
        kg kgVar4 = this.b;
        View viewD = this.f9513a.d();
        kgVar4.getClass();
        ms1 ms1Var = viewD != null ? new ms1(viewD) : null;
        map.put("root_container", ms1Var != null ? new cz(ms1Var) : null);
        for (ig<?> igVar : this.c) {
            View view = this.f9513a.a(igVar.b());
            if (view != null && !map.containsKey(igVar.b())) {
                jg<?> jgVarA = this.b.a(view, igVar.c());
                if (jgVarA == null) {
                    this.b.getClass();
                    Intrinsics.checkNotNullParameter(view, "view");
                    jgVarA = new cz<>(new t00(view));
                }
                map.put(igVar.b(), jgVarA);
            }
        }
        for (Map.Entry entry : this.f9513a.a().entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null && !map.containsKey(str)) {
                this.b.getClass();
                Intrinsics.checkNotNullParameter(view2, "view");
                map.put(str, new cz(new t00(view2)));
            }
        }
        return map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public lg(m71 nativeAdWeakViewProvider, pj0 imageProvider, ex0 mediaViewAdapterCreator, j91 nativeMediaContent, p81 nativeForcePauseObserver, o8<?> adResponse, bc1 nativeVisualBlock, lp1 reporter) {
        this(nativeAdWeakViewProvider, new kg(adResponse, imageProvider, mediaViewAdapterCreator, nativeMediaContent, nativeForcePauseObserver, reporter), nativeVisualBlock.b());
        Intrinsics.checkNotNullParameter(nativeAdWeakViewProvider, "nativeAdWeakViewProvider");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(mediaViewAdapterCreator, "mediaViewAdapterCreator");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
    }
}
