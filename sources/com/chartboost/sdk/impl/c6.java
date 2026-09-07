package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR(\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00150\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/chartboost/sdk/impl/c6;", "Lcom/chartboost/sdk/impl/b6;", "Lkotlin/Function2;", "Lcom/chartboost/sdk/impl/e6;", "Landroid/view/ViewGroup;", "Lcom/chartboost/sdk/impl/y1;", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "impressionFactory", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/y5;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/jvm/functions/Function1;", "impressionClickableFactory", "Lcom/chartboost/sdk/impl/g6;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "impressionDismissableFactory", "Lcom/chartboost/sdk/impl/z5;", "d", "impressionCompletableFactory", "Lcom/chartboost/sdk/impl/q6;", "e", "impressionViewableFactory", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class c6 implements b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function2<e6, ViewGroup, y1> impressionFactory = new d();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Function1<e6, y5> impressionClickableFactory = a.b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<e6, g6> impressionDismissableFactory = c.b;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Function1<e6, z5> impressionCompletableFactory = b.b;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function2<e6, ViewGroup, q6> impressionViewableFactory = e.b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Lcom/chartboost/sdk/impl/w5;", "a", "(Lcom/chartboost/sdk/impl/e6;)Lcom/chartboost/sdk/impl/w5;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<e6, w5> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w5 invoke(e6 impressionDependency) {
            Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
            return new w5(impressionDependency.getAdUnit(), impressionDependency.getUrlResolver(), impressionDependency.getIntentResolver(), impressionDependency.getClickRequest(), impressionDependency.getClickTracking(), impressionDependency.getMediaType(), impressionDependency.getImpressionClickCallback(), impressionDependency.getOpenMeasurementImpressionCallback(), impressionDependency.getAdUnitRendererImpressionCallback(), null, 512, null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Lcom/chartboost/sdk/impl/a6;", "a", "(Lcom/chartboost/sdk/impl/e6;)Lcom/chartboost/sdk/impl/a6;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<e6, a6> {
        public static final b b = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a6 invoke(e6 impressionDependency) {
            Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
            return new a6(impressionDependency.getAdUnit(), impressionDependency.getAdTypeTraits(), impressionDependency.getCompleteRequest(), impressionDependency.getAdUnitRendererImpressionCallback());
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Lcom/chartboost/sdk/impl/f6;", "a", "(Lcom/chartboost/sdk/impl/e6;)Lcom/chartboost/sdk/impl/f6;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<e6, f6> {
        public static final c b = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f6 invoke(e6 impressionDependency) {
            Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
            return new f6(impressionDependency.getAdUnit(), impressionDependency.getLocation(), impressionDependency.getAdTypeTraits(), impressionDependency.getAdUnitRendererImpressionCallback(), impressionDependency.getImpressionCallback(), impressionDependency.getAppRequest(), impressionDependency.getDownloader(), impressionDependency.getOpenMeasurementImpressionCallback(), impressionDependency.getEventTracker());
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/chartboost/sdk/impl/y1;", "a", "(Lcom/chartboost/sdk/impl/e6;Landroid/view/ViewGroup;)Lcom/chartboost/sdk/impl/y1;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function2<e6, ViewGroup, y1> {
        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y1 invoke(e6 impressionDependency, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
            return new y1(impressionDependency, (y5) c6.this.impressionClickableFactory.invoke(impressionDependency), (g6) c6.this.impressionDismissableFactory.invoke(impressionDependency), (z5) c6.this.impressionCompletableFactory.invoke(impressionDependency), (q6) c6.this.impressionViewableFactory.invoke(impressionDependency, viewGroup));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Landroid/view/ViewGroup;", "externalView", "Lcom/chartboost/sdk/impl/o6;", "a", "(Lcom/chartboost/sdk/impl/e6;Landroid/view/ViewGroup;)Lcom/chartboost/sdk/impl/o6;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function2<e6, ViewGroup, o6> {
        public static final e b = new e();

        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o6 invoke(e6 impressionDependency, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
            return new o6(impressionDependency.getAppRequest(), impressionDependency.getViewProtocol(), impressionDependency.getDownloader(), viewGroup, impressionDependency.getAdUnitRendererImpressionCallback(), impressionDependency.getImpressionCallback(), impressionDependency.getImpressionClickCallback());
        }
    }

    @Override // com.chartboost.sdk.impl.b6
    public Function2<e6, ViewGroup, y1> a() {
        return this.impressionFactory;
    }
}
