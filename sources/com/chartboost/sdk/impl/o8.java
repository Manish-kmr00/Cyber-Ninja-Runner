package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\b\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\r\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/o8;", "Lcom/chartboost/sdk/impl/n8;", "Lcom/chartboost/sdk/impl/l8;", "a", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Lcom/chartboost/sdk/impl/y9;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", "()Lcom/chartboost/sdk/impl/y9;", "tcfv2", "Lcom/chartboost/sdk/impl/i5;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/i5;", "gpp", "", "()Ljava/lang/String;", "gppSid", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "<init>", "(Lcom/chartboost/sdk/impl/w0;Lcom/chartboost/sdk/impl/ea;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o8 implements n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy privacyApi;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy tcfv2;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy gpp;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy gppSid;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/i5;", "a", "()Lcom/chartboost/sdk/impl/i5;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<i5> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i5 invoke() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b.getContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferen…androidComponent.context)");
            return new i5(defaultSharedPreferences);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/y9;", "a", "()Lcom/chartboost/sdk/impl/y9;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<y9> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y9 invoke() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b.getContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferen…androidComponent.context)");
            return new y9(defaultSharedPreferences);
        }
    }

    public o8(w0 androidComponent, ea trackerComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(trackerComponent, "trackerComponent");
        this.privacyApi = LazyKt.lazy(new c(androidComponent, trackerComponent, this));
        this.tcfv2 = LazyKt.lazy(new d(androidComponent));
        this.gpp = LazyKt.lazy(new a(androidComponent));
        this.gppSid = LazyKt.lazy(new b());
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/l8;", "a", "()Lcom/chartboost/sdk/impl/l8;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<l8> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ ea c;
        public final /* synthetic */ o8 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w0 w0Var, ea eaVar, o8 o8Var) {
            super(0);
            this.b = w0Var;
            this.c = eaVar;
            this.d = o8Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l8 invoke() {
            SharedPreferences sharedPreferencesF = this.b.f();
            m4 m4VarA = this.c.a();
            p8 p8Var = new p8(sharedPreferencesF, m4VarA);
            l8 l8Var = new l8(new s8(p8Var, m4VarA), new j5(p8Var), new w8(p8Var), new k5(), new l5(p8Var), this.d.d(), this.d.b(), this.d.c());
            l8Var.a(new o9.b());
            return l8Var;
        }
    }

    @Override // com.chartboost.sdk.impl.n8
    public l8 a() {
        return (l8) this.privacyApi.getValue();
    }

    public y9 d() {
        return (y9) this.tcfv2.getValue();
    }

    public i5 b() {
        return (i5) this.gpp.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<String> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return o8.this.b().a();
        }
    }

    public String c() {
        return (String) this.gppSid.getValue();
    }
}
