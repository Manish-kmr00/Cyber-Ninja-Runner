package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3576u0 extends AbstractRunnableC3521q1 {
    public final /* synthetic */ C0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3576u0(C0 c0) {
        super(c0);
        this.d = c0;
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        HashMap mapA;
        C0 c0 = (C0) this.b.get();
        if (c0 != null) {
            try {
                byte bJ = c0.J();
                JSONObject pubContent = new JSONObject(c0.L());
                AdConfig adConfig = c0.j();
                Intrinsics.checkNotNull(adConfig);
                if (c0.y() == null) {
                    mapA = null;
                } else {
                    boolean z = W8.f3228a;
                    C3418j0 c3418j0Y = c0.y();
                    mapA = W8.a(c3418j0Y != null ? c3418j0Y.h() : null);
                }
                L4 l4 = this.d.j;
                Intrinsics.checkNotNullParameter(pubContent, "pubContent");
                Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                final C3625x7 c3625x7 = new C3625x7(bJ, pubContent, null, false, adConfig, mapA, null, l4);
                Handler handlerD = this.d.D();
                if (handlerD != null) {
                    final C0 c1 = this.d;
                    handlerD.post(new Runnable() { // from class: com.inmobi.media.u0$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3576u0.a(c3625x7, c1);
                        }
                    });
                }
            } catch (Exception e) {
                L4 l5 = this.d.j;
                if (l5 != null) {
                    String strE = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                    ((M4) l5).a(strE, "Exception for handleInterActive ", e);
                }
                c0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 76);
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        C0 c0 = (C0) this.b.get();
        if (c0 != null) {
            c0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), true, (short) 40);
        }
    }

    public static final void a(C3625x7 dataModel, C0 this$0) {
        Intrinsics.checkNotNullParameter(dataModel, "$dataModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            M8 m8 = dataModel.r;
            C3389h c3389hM = this$0.m();
            if (m8 == null || this$0.t() == null || c3389hM == null) {
                return;
            }
            Context contextT = this$0.t();
            Intrinsics.checkNotNull(contextT);
            this$0.n = new Ba(contextT, this$0.J(), this$0.d(0), this$0.n(), false, null, 0L, null, null, 240);
            Ba baX = this$0.x();
            if (baX != null) {
                baX.setAdType(this$0.I().b());
            }
            Ba baX2 = this$0.x();
            if (baX2 != null) {
                Da da = this$0.K;
                AdConfig adConfigJ = this$0.j();
                Intrinsics.checkNotNull(adConfigJ);
                baX2.a(da, adConfigJ);
            }
            Ba baX3 = this$0.x();
            if (baX3 != null) {
                L4 l4 = baX3.i;
                if (l4 != null) {
                    String TAG = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "disableUrlsToOpenInExternalApp " + baX3);
                }
                baX3.v = true;
            }
            Ba baX4 = this$0.x();
            if (baX4 != null) {
                baX4.setBlobProvider(this$0);
            }
            Ba baX5 = this$0.x();
            if (baX5 != null) {
                baX5.setPreloadView(true);
            }
            Ba baX6 = this$0.x();
            if (baX6 != null) {
                baX6.setPlacementId(this$0.I().l());
            }
            Ba baX7 = this$0.x();
            if (baX7 != null) {
                baX7.setCreativeId(c3389hM.o());
            }
            Ba baX8 = this$0.x();
            if (baX8 != null) {
                baX8.setAllowAutoRedirection(this$0.b(0));
            }
            C0.a(this$0, c3389hM, this$0.x());
            if (this$0.T() == 0) {
                this$0.a(true, this$0.x());
            }
            if (Intrinsics.areEqual("URL", m8.y)) {
                Ba baX9 = this$0.x();
                if (baX9 != null) {
                    Object obj = m8.e;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    baX9.d((String) obj);
                    return;
                }
                return;
            }
            Ba baX10 = this$0.x();
            if (baX10 != null) {
                Object obj2 = m8.e;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                baX10.c((String) obj2);
            }
        } catch (Exception e) {
            L4 l5 = this$0.j;
            if (l5 != null) {
                String strE = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                ((M4) l5).a(strE, "Exception for handleInterActive ", e);
            }
            this$0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 76);
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
