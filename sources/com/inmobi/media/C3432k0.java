package com.inmobi.media;

import android.net.Uri;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3432k0 implements InterfaceC3349e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3462m0 f3352a;

    public C3432k0(C3462m0 c3462m0) {
        this.f3352a = c3462m0;
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch, byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        C3462m0 c3462m0 = this.f3352a;
        L4 l4 = c3462m0.f;
        if (l4 != null) {
            String str = c3462m0.d;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).b(str, "onAssetsFetchFailure of batch " + assetBatch);
        }
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch) {
        String str;
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        C3462m0 c3462m0 = this.f3352a;
        L4 l4 = c3462m0.f;
        if (l4 != null) {
            String str2 = c3462m0.d;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4).a(str2, "onAssetsFetchSuccess of batch " + assetBatch);
        }
        Set set = assetBatch.h;
        for (C3417j c3417j : assetBatch.g) {
            if (!c3417j.i) {
                this.f3352a.getClass();
                Iterator it = set.iterator();
                while (true) {
                    str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    C3372fa c3372fa = (C3372fa) it.next();
                    if (Intrinsics.areEqual(c3372fa.b, c3417j.b)) {
                        byte b = c3372fa.f3316a;
                        if (b != 2) {
                            if (b != 1) {
                                if (b != 0) {
                                    break;
                                }
                                str = "video";
                                break;
                            }
                            str = "gif";
                            break;
                        }
                        str = "image";
                        break;
                    }
                }
                Pair pair = TuplesKt.to("latency", Long.valueOf(c3417j.k));
                long length = 0;
                try {
                    String path = Uri.parse(c3417j.c).getPath();
                    if (path != null) {
                        File file = new File(path);
                        if (file.exists()) {
                            length = file.length();
                        }
                    }
                } catch (Exception unused) {
                    Intrinsics.checkNotNullExpressionValue("W3", "TAG");
                }
                Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to(ContentDisposition.Parameters.Size, Float.valueOf((length * 1.0f) / 1024)), TuplesKt.to("assetType", str), TuplesKt.to("networkType", C3435k3.q()));
                String strB = this.f3352a.c.b();
                if (strB != null) {
                    mapMutableMapOf.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, strB);
                }
                this.f3352a.b.b("AssetDownloaded", mapMutableMapOf);
            }
        }
        C3462m0 c3462m1 = this.f3352a;
        L4 l5 = c3462m1.f;
        if (l5 != null) {
            String str3 = c3462m1.d;
            ((M4) l5).a(str3, O5.a(str3, "access$getTAG$p(...)", "Notifying ad unit with placement ID (").append(this.f3352a.c).append(')').toString());
        }
    }
}
