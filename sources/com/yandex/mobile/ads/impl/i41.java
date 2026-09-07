package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdAssets;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cj0 f9172a;
    private final wu0 b;
    private final qg c;
    private final wg d;

    public final List<ig<? extends Object>> a(MediatedNativeAdAssets nativeAdAssets, Map<String, Bitmap> imageValues) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        return CollectionsKt.filterNotNull(CollectionsKt.listOf((Object[]) new ig[]{a(nativeAdAssets.getAge(), "age"), a(nativeAdAssets.getBody(), "body"), a(nativeAdAssets.getCallToAction(), "call_to_action"), a(nativeAdAssets.getDomain(), "domain"), a(this.f9172a.a(imageValues, nativeAdAssets.getFavicon()), "favicon"), a(this.f9172a.a(imageValues, nativeAdAssets.getIcon()), "icon"), a(this.b.a(imageValues, nativeAdAssets.getImage(), nativeAdAssets.getMedia()), "media"), a(nativeAdAssets.getPrice(), "price"), a(String.valueOf(nativeAdAssets.getRating()), "rating"), a(nativeAdAssets.getReviewCount(), "review_count"), a(nativeAdAssets.getSponsored(), "sponsored"), a(nativeAdAssets.getTitle(), "title"), a(nativeAdAssets.getWarning(), "warning"), a(this.f9172a.a(imageValues, nativeAdAssets.getFeedback()), "feedback")}));
    }

    public /* synthetic */ i41(Context context) {
        sj0 sj0Var = new sj0();
        cj0 cj0Var = new cj0(context, sj0Var);
        this(context, sj0Var, cj0Var, new wu0(cj0Var), new qg(), new wg());
    }

    public i41(Context context, sj0 imageSizeValidator, cj0 imageAssetConverter, wu0 mediaAssetConverter, qg assetCreatorProvider, wg assetValueValidatorProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageSizeValidator, "imageSizeValidator");
        Intrinsics.checkNotNullParameter(imageAssetConverter, "imageAssetConverter");
        Intrinsics.checkNotNullParameter(mediaAssetConverter, "mediaAssetConverter");
        Intrinsics.checkNotNullParameter(assetCreatorProvider, "assetCreatorProvider");
        Intrinsics.checkNotNullParameter(assetValueValidatorProvider, "assetValueValidatorProvider");
        this.f9172a = imageAssetConverter;
        this.b = mediaAssetConverter;
        this.c = assetCreatorProvider;
        this.d = assetValueValidatorProvider;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00be  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d3  */
    private final ig a(Object obj, String name) {
        vg dj0Var;
        pg u22Var;
        this.d.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        int iHashCode = name.hashCode();
        if (iHashCode != -1074675180) {
            if (iHashCode != -191501435) {
                if (iHashCode != 3226745) {
                    if (iHashCode == 103772132 && name.equals("media")) {
                        dj0Var = new zu0(new dj0(), new zw0());
                    }
                } else if (name.equals("icon")) {
                    dj0Var = new dj0();
                }
                dj0Var = new v22();
            } else if (!name.equals("feedback")) {
                dj0Var = new v22();
            } else {
                dj0Var = new dj0();
            }
        } else if (!name.equals("favicon")) {
            dj0Var = new v22();
        } else {
            dj0Var = new dj0();
        }
        if (obj == null || !dj0Var.a(obj)) {
            return null;
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        switch (name) {
            case "close_button":
                u22Var = new np();
                break;
            case "favicon":
                u22Var = new vj0();
                break;
            case "rating":
            case "review_count":
                u22Var = new sd1(new kr1());
                break;
            case "feedback":
                u22Var = new xa0();
                break;
            case "icon":
                u22Var = new vj0();
                break;
            case "media":
                u22Var = new xu0();
                break;
            default:
                u22Var = new u22();
                break;
        }
        return u22Var.a(obj, name);
    }
}
