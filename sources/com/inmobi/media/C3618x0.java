package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3618x0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0 f3469a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3618x0(C0 c0) {
        super(1);
        this.f3469a = c0;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        short s;
        I3 errorCode = (I3) obj;
        Intrinsics.checkNotNullParameter(errorCode, "it");
        C0 c0 = this.f3469a;
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        int iOrdinal = errorCode.ordinal();
        if (iOrdinal == 0) {
            s = 2100;
        } else if (iOrdinal != 18) {
            switch (iOrdinal) {
                case 12:
                    s = 2101;
                    break;
                case 13:
                    s = 2102;
                    break;
                case 14:
                    s = 2103;
                    break;
                case 15:
                    s = 2104;
                    break;
                case 16:
                    s = 2105;
                    break;
                default:
                    s = 2100;
                    break;
            }
        } else {
            s = 2228;
        }
        c0.a(inMobiAdRequestStatus, true, s);
        return Unit.INSTANCE;
    }
}
