package com.json;

import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JB\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/ironsource/mp;", "Lcom/ironsource/zf;", "Lcom/ironsource/zf$a;", "", "Lcom/ironsource/services/capping/PlacementName;", "placementName", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/l8;", "a", "Lcom/ironsource/n8;", "cappingType", "Lcom/ironsource/df;", "cappingConfig", "Lkotlin/Result;", "", "(Ljava/lang/String;Lcom/unity3d/mediation/LevelPlay$AdFormat;Lcom/ironsource/n8;Lcom/ironsource/df;)Ljava/lang/Object;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/j8;", "Lcom/ironsource/j8;", "cappingService", "Lcom/ironsource/pa;", "Lcom/ironsource/pa;", "deliveryHandler", "<init>", "(Lcom/ironsource/j8;Lcom/ironsource/pa;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class mp implements zf, zf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j8 cappingService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final pa deliveryHandler;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4060a;

        static {
            int[] iArr = new int[n8.values().length];
            try {
                iArr[n8.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n8.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[n8.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4060a = iArr;
        }
    }

    public mp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public mp(j8 cappingService, pa deliveryHandler) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        Intrinsics.checkNotNullParameter(deliveryHandler, "deliveryHandler");
        this.cappingService = cappingService;
        this.deliveryHandler = deliveryHandler;
    }

    public /* synthetic */ mp(j8 j8Var, pa paVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            j8Var = new j8(null, null, null, 7, null);
        }
        this(j8Var, (i & 2) != 0 ? new pa() : paVar);
    }

    @Override // com.json.zf
    public synchronized l8 a(String placementName, LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        String strA = new rp(placementName, adFormat).a();
        l8 l8VarA = this.deliveryHandler.a(strA);
        if (l8VarA.d()) {
            return l8VarA;
        }
        return this.cappingService.a(strA);
    }

    @Override // com.ironsource.zf.a
    public synchronized Object a(String placementName, LevelPlay.AdFormat adFormat, n8 cappingType, df cappingConfig) {
        Object objA;
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        String strA = new rp(placementName, adFormat).a();
        int i = a.f4060a[cappingType.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            objA = this.cappingService.a(strA, cappingType, cappingConfig);
        } else {
            objA = this.deliveryHandler.a(strA, cappingType, cappingConfig);
        }
        return objA;
    }

    @Override // com.ironsource.zf.a
    public synchronized void b(String placementName, LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        String strA = new rp(placementName, adFormat).a();
        if (!this.deliveryHandler.a(strA).d()) {
            this.cappingService.b(strA);
        }
    }
}
