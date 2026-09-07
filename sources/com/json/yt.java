package com.json;

import android.os.Handler;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.testSuite.TestSuiteActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u0007\u0003\u0005\u0010B!\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/ironsource/yt;", "", "Lcom/ironsource/yt$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/yt$d;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/yt$b;", "a", "Lcom/ironsource/yt$c;", "isManager", "Lcom/ironsource/yt$d;", "rvManager", "Lcom/ironsource/yt$b;", "bnManager", "<init>", "(Lcom/ironsource/yt$c;Lcom/ironsource/yt$d;Lcom/ironsource/yt$b;)V", "d", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class yt {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c isManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final d rvManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final b bnManager;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0011²\u0006\f\u0010\u000e\u001a\u00020\r8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u00020\u000f8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/ironsource/yt$a;", "", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "maduEnabledAdUnits", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "activity", "Landroid/os/Handler;", "handler", "Lcom/ironsource/yt;", "a", "<init>", "()V", "Lcom/ironsource/hu;", "maduManger", "Lcom/ironsource/ou;", "nonMaduManger", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.yt$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/hu;", "a", "()Lcom/ironsource/hu;"}, k = 3, mv = {1, 8, 0})
        static final class C0414a extends Lambda implements Function0<hu> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f4634a;
            final /* synthetic */ Handler b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0414a(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f4634a = testSuiteActivity;
                this.b = handler;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final hu invoke() {
                return new hu(this.f4634a, this.b);
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/ou;", "a", "()Lcom/ironsource/ou;"}, k = 3, mv = {1, 8, 0})
        static final class b extends Lambda implements Function0<ou> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f4635a;
            final /* synthetic */ Handler b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f4635a = testSuiteActivity;
                this.b = handler;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ou invoke() {
                return new ou(this.f4635a, this.b);
            }
        }

        private static final hu a(Lazy<hu> lazy) {
            return lazy.getValue();
        }

        private static final ou b(Lazy<ou> lazy) {
            return lazy.getValue();
        }

        public final yt a(List<? extends IronSource.AD_UNIT> maduEnabledAdUnits, TestSuiteActivity activity, Handler handler) {
            Intrinsics.checkNotNullParameter(maduEnabledAdUnits, "maduEnabledAdUnits");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Lazy lazy = LazyKt.lazy(new C0414a(activity, handler));
            Lazy lazy2 = LazyKt.lazy(new b(activity, handler));
            return new yt(maduEnabledAdUnits.contains(IronSource.AD_UNIT.INTERSTITIAL) ? a(lazy) : b(lazy2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.REWARDED_VIDEO) ? a(lazy) : b(lazy2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.BANNER) ? a(lazy) : b(lazy2), null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/yt$b;", "", "Lcom/ironsource/eu;", "loadAdConfig", "", "description", "", "width", "height", "", "a", "", "marginPercentageFromTop", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface b {
        void a(double marginPercentageFromTop);

        void a(eu loadAdConfig, String description, int width, int height);

        void b();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/yt$c;", "", "Lcom/ironsource/eu;", "loadAdConfig", "", "a", "", "e", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface c {
        void a(eu loadAdConfig);

        void c();

        boolean e();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/yt$d;", "", "Lcom/ironsource/eu;", "loadAdConfig", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "d", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface d {
        boolean a();

        void b(eu loadAdConfig);

        void d();
    }

    private yt(c cVar, d dVar, b bVar) {
        this.isManager = cVar;
        this.rvManager = dVar;
        this.bnManager = bVar;
    }

    public /* synthetic */ yt(c cVar, d dVar, b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, dVar, bVar);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final b getBnManager() {
        return this.bnManager;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final c getIsManager() {
        return this.isManager;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final d getRvManager() {
        return this.rvManager;
    }
}
