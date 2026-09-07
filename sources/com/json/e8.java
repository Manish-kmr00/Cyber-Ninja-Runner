package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJ \u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/ironsource/e8;", "Lcom/ironsource/df;", "Lcom/ironsource/m8;", "unit", "Lkotlin/Result;", "", "a", "(Lcom/ironsource/m8;)Ljava/lang/Object;", "Lcom/ironsource/jt;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/Object;", "Lcom/ironsource/yo;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/ma;", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "enabled", "", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "limit", "Lcom/ironsource/m8;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/m8;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/ironsource/m8;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class e8 implements df {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Boolean enabled;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Integer limit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final m8 unit;

    public e8(Boolean bool, Integer num, m8 m8Var) {
        this.enabled = bool;
        this.limit = num;
        this.unit = m8Var;
    }

    public /* synthetic */ e8(Boolean bool, Integer num, m8 m8Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : m8Var);
    }

    private final Object a(m8 unit) {
        return new f8(this.enabled, this.limit, unit).a();
    }

    @Override // com.json.df
    public Object a() {
        ma maVar;
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(new na(this.enabled).a());
        if (thM7907exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
        }
        Result.Companion companion2 = Result.INSTANCE;
        Boolean bool = this.enabled;
        if (bool != null) {
            bool.booleanValue();
            maVar = new ma(this.enabled.booleanValue());
        } else {
            maVar = null;
        }
        return Result.m7904constructorimpl(maVar);
    }

    @Override // com.json.df
    public Object b() {
        yo yoVar;
        Integer num;
        m8 m8Var = m8.Second;
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(a(m8Var));
        if (thM7907exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
        }
        if (!Intrinsics.areEqual(this.enabled, Boolean.TRUE) || (num = this.limit) == null) {
            yoVar = null;
        } else {
            num.intValue();
            yoVar = new yo(m8Var.a(this.limit), null, 2, null);
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m7904constructorimpl(yoVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    @Override // com.json.df
    public Object c() {
        jt jtVar;
        Integer num;
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(a(this.unit));
        if (thM7907exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
        }
        if (!Intrinsics.areEqual(this.enabled, Boolean.TRUE) || (num = this.limit) == null) {
            jtVar = null;
        } else {
            int iIntValue = num.intValue();
            m8 m8Var = this.unit;
            if (m8Var != null) {
                jtVar = new jt(iIntValue, m8Var);
            } else {
                jtVar = null;
            }
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m7904constructorimpl(jtVar);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final m8 getUnit() {
        return this.unit;
    }
}
