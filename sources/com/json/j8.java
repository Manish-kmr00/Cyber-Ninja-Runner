package com.json;

import android.content.Context;
import com.json.environment.ContextProvider;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016J:\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\r2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/ironsource/j8;", "Lcom/ironsource/ff;", "Lcom/ironsource/ff$a;", "", "Lcom/ironsource/services/capping/Identifier;", "identifier", "Lcom/ironsource/l8;", "a", "Lcom/ironsource/n8;", "cappingType", "Lcom/ironsource/df;", "cappingConfig", "Lkotlin/Result;", "", "(Ljava/lang/String;Lcom/ironsource/n8;Lcom/ironsource/df;)Ljava/lang/Object;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/zo;", "Lcom/ironsource/zo;", "pacingHandler", "Lcom/ironsource/mt;", "Lcom/ironsource/mt;", "showCountHandler", "Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/yf;", "pacingDataRepository", "Lcom/ironsource/ei;", "showCountDataRepository", "<init>", "(Lcom/ironsource/q9;Lcom/ironsource/yf;Lcom/ironsource/ei;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class j8 implements ff, ff.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final zo pacingHandler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final mt showCountHandler;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3805a;

        static {
            int[] iArr = new int[n8.values().length];
            try {
                iArr[n8.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n8.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[n8.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3805a = iArr;
        }
    }

    public j8() {
        this(null, null, null, 7, null);
    }

    public j8(q9 currentTimeProvider, yf pacingDataRepository, ei showCountDataRepository) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(pacingDataRepository, "pacingDataRepository");
        Intrinsics.checkNotNullParameter(showCountDataRepository, "showCountDataRepository");
        this.pacingHandler = new zo(currentTimeProvider, pacingDataRepository);
        this.showCountHandler = new mt(currentTimeProvider, showCountDataRepository);
    }

    public /* synthetic */ j8(q9 q9Var, yf yfVar, ei eiVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        q9Var = (i & 1) != 0 ? new q9.a() : q9Var;
        if ((i & 2) != 0) {
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
            yfVar = new ap(new gt(applicationContext, "pacing_service", null, 4, null));
        }
        if ((i & 4) != 0) {
            Context applicationContext2 = ContextProvider.getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getInstance().applicationContext");
            eiVar = new kt(new gt(applicationContext2, "capping_service", null, 4, null));
        }
        this(q9Var, yfVar, eiVar);
    }

    @Override // com.json.ff
    public synchronized l8 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        l8 l8VarA = this.pacingHandler.a(identifier);
        if (l8VarA.d()) {
            return l8VarA;
        }
        return this.showCountHandler.a(identifier);
    }

    @Override // com.ironsource.ff.a
    public synchronized Object a(String identifier, n8 cappingType, df cappingConfig) {
        Object objA;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        int i = a.f3805a[cappingType.ordinal()];
        if (i == 1) {
            objA = this.pacingHandler.a(identifier, cappingType, cappingConfig);
        } else if (i == 2) {
            objA = this.showCountHandler.a(identifier, cappingType, cappingConfig);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Result.Companion companion = Result.INSTANCE;
            objA = Result.m7904constructorimpl(Unit.INSTANCE);
        }
        return objA;
    }

    @Override // com.ironsource.ff.a
    public synchronized void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.pacingHandler.b(identifier);
        this.showCountHandler.b(identifier);
    }
}
