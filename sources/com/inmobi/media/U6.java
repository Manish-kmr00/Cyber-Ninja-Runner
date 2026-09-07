package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class U6 extends AbstractRunnableC3521q1 {
    public final /* synthetic */ C3313b7 d;
    public final /* synthetic */ C3313b7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U6(C3313b7 c3313b7, C3313b7 c3313b8) {
        super(c3313b7);
        this.d = c3313b7;
        this.e = c3313b8;
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        JSONObject jSONObjectE;
        C3313b7 c3313b7 = this.d;
        if (c3313b7.C == null) {
            L4 l4 = c3313b7.j;
            if (l4 != null) {
                String TAG = c3313b7.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "prepareFullscreenContainer");
            }
            C3625x7 c3625x7 = c3313b7.b;
            JSONArray jSONArray = c3625x7.f;
            if (jSONArray != null && !AbstractC3420j2.a(jSONArray) && (jSONObjectE = c3625x7.e()) != null) {
                C3625x7 dataModel = new C3625x7(c3313b7.f3274a, jSONObjectE, c3625x7, c3313b7.f3274a == 0, c3313b7.s, c3313b7.j);
                dataModel.q = c3625x7.q;
                Context context = (Context) c3313b7.x.get();
                if (dataModel.f() && context != null) {
                    String adImpressionId = c3313b7.getImpressionId();
                    Set set = c3313b7.d;
                    AdConfig adConfig = c3313b7.s;
                    long j = c3313b7.e;
                    boolean z = c3313b7.f;
                    String creativeId = c3313b7.getCreativeId();
                    C3297a6 c3297a6 = c3313b7.i;
                    L4 l5 = c3313b7.j;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                    Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
                    Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                    Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                    C3313b7 c3398h8 = dataModel.c().contains(ShareConstants.VIDEO_URL) ? new C3398h8(context, (byte) 0, dataModel, adImpressionId, set, adConfig, j, z, creativeId, null, c3297a6, l5) : new C3313b7(context, (byte) 0, dataModel, adImpressionId, set, adConfig, j, z, creativeId, null, c3297a6, l5);
                    c3313b7.C = c3398h8;
                    c3398h8.v = c3313b7;
                    A0 a0 = c3313b7.w;
                    if (a0 != null) {
                        c3398h8.w = a0;
                    }
                }
            }
        }
        C3313b7 container = this.d.C;
        if (container != null) {
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            int iHashCode = container.hashCode();
            InMobiAdActivity.k.put(iHashCode, container);
            Intent intent = new Intent((Context) this.d.x.get(), (Class<?>) InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", iHashCode);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 201);
            Context context2 = (Context) this.d.x.get();
            C3313b7 c3313b8 = this.d;
            if (c3313b8.D) {
                c3313b8.G = intent;
            } else if (context2 != null) {
                C3517pb.f3400a.a(context2, intent);
            }
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        A0 a0 = this.e.w;
        if (a0 != null) {
            a0.c();
        }
    }
}
