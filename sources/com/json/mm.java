package com.json;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000Ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\nB\u000b\b\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020AH\u0016R\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010K\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010D\u001a\u0004\bI\u0010JR\u001b\u0010O\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010D\u001a\u0004\bM\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010D\u001a\u0004\bQ\u0010RR\u001b\u0010W\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010D\u001a\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010D\u001a\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010D\u001a\u0004\b]\u0010^R\u001b\u0010c\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010D\u001a\u0004\ba\u0010bR\u001b\u0010g\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\be\u0010fR\u001b\u0010k\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010D\u001a\u0004\bi\u0010jR\u001b\u0010o\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010D\u001a\u0004\bm\u0010nR\u001b\u0010s\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010D\u001a\u0004\bq\u0010rR\u001b\u0010w\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010D\u001a\u0004\bu\u0010vR\u001b\u0010{\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\by\u0010zR\u001b\u0010\u007f\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010D\u001a\u0004\b}\u0010~R\u001f\u0010\u0083\u0001\u001a\u00030\u0080\u00018BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b \u0010D\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0087\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b:\u0010D\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008a\u0001"}, d2 = {"Lcom/ironsource/mm;", "Lcom/ironsource/xf;", "Lcom/ironsource/wf;", "Lcom/ironsource/ai;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/ai$a;", "e", "Lcom/ironsource/nf;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/nf$a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/zh;", "j", "Lcom/ironsource/zh$a;", "i", "Lcom/ironsource/ye;", "r", "Lcom/ironsource/ye$a;", "C", "Lcom/ironsource/bg;", "B", "Lcom/ironsource/bg$a;", "m", "Lcom/ironsource/zf;", VastAttributes.VERTICAL_POSITION, "Lcom/ironsource/zf$a;", "a", "Lcom/ironsource/ff;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "Lcom/ironsource/ff$a;", "w", "Lcom/ironsource/eg;", "p", "Lcom/ironsource/eg$a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/ironsource/ch;", "z", "Lcom/ironsource/ch$a;", "n", "Lcom/ironsource/bi;", "l", "Lcom/ironsource/p0;", "F", "Lcom/ironsource/bi$a;", "g", "Lcom/ironsource/p0$a;", ExifInterface.LONGITUDE_EAST, "Lcom/ironsource/wh;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/ironsource/wh$a;", "D", "Lcom/ironsource/uf;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/bf;", "v", "Lcom/ironsource/xh;", "h", "Lcom/ironsource/xh$a;", CampaignEx.JSON_KEY_AD_Q, "Lcom/ironsource/pf;", "d", "Lcom/ironsource/pf$a;", VastAttributes.HORIZONTAL_POSITION, "Lcom/ironsource/fi;", "o", "Lcom/ironsource/fi$a;", "s", "Lcom/ironsource/rs;", "Lkotlin/Lazy;", "X", "()Lcom/ironsource/rs;", "sessionDepthManager", "Lcom/ironsource/ab;", "L", "()Lcom/ironsource/ab;", "deviceInfoService", "Lcom/ironsource/qs;", ExifInterface.LONGITUDE_WEST, "()Lcom/ironsource/qs;", "sessionCappingService", "Lcom/ironsource/s;", "H", "()Lcom/ironsource/s;", "adFormatCappingService", "Lcom/ironsource/op;", "R", "()Lcom/ironsource/op;", "placementCappingServiceLegacy", "Lcom/ironsource/j8;", "J", "()Lcom/ironsource/j8;", "adUnitCappingService", "Lcom/ironsource/mp;", "Q", "()Lcom/ironsource/mp;", "placementCappingService", "Lcom/ironsource/hq;", "T", "()Lcom/ironsource/hq;", "rewardService", "Lcom/ironsource/us;", "Y", "()Lcom/ironsource/us;", "sessionHistoryService", "Lcom/ironsource/r0;", "I", "()Lcom/ironsource/r0;", "adInternalInfoService", "Lcom/ironsource/dh;", "P", "()Lcom/ironsource/dh;", "ironSourceNetworkConfigurationsManager", "Lcom/ironsource/lr;", "U", "()Lcom/ironsource/lr;", "sdkConfigService", "Lcom/ironsource/sc;", "O", "()Lcom/ironsource/sc;", "featureAvailabilityService", "Lcom/ironsource/m4;", "K", "()Lcom/ironsource/m4;", "applicationLifecycleService", "Lcom/ironsource/cs;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lcom/ironsource/cs;", "sdkSessionInfoService", "Lcom/ironsource/pb;", "N", "()Lcom/ironsource/pb;", "epService", "Lcom/ironsource/fu;", "Z", "()Lcom/ironsource/fu;", "testSuiteLoadConfigService", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class mm implements xf, wf {

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<mm> s = LazyKt.lazy(a.f4041a);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy sessionDepthManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy deviceInfoService;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy sessionCappingService;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy adFormatCappingService;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy placementCappingServiceLegacy;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy adUnitCappingService;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy placementCappingService;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy rewardService;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy sessionHistoryService;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy adInternalInfoService;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy ironSourceNetworkConfigurationsManager;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy sdkConfigService;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy featureAvailabilityService;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy applicationLifecycleService;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy sdkSessionInfoService;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy epService;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy testSuiteLoadConfigService;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/mm;", "a", "()Lcom/ironsource/mm;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<mm> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4041a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final mm invoke() {
            return new mm(null);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.mm$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0012\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ironsource/mm$b;", "", "Lcom/ironsource/mm;", "instance$delegate", "Lkotlin/Lazy;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/mm;", m5.p, "Lcom/ironsource/xf;", "d", "()Lcom/ironsource/xf;", "getProvider$annotations", "()V", IronSourceConstants.EVENTS_PROVIDER, "Lcom/ironsource/wf;", "a", "()Lcom/ironsource/wf;", "getEditor$annotations", "editor", "<init>", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void b() {
        }

        @JvmStatic
        public static /* synthetic */ void e() {
        }

        public final wf a() {
            return c();
        }

        public final mm c() {
            return (mm) mm.s.getValue();
        }

        public final xf d() {
            return c();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/s;", "a", "()Lcom/ironsource/s;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0<com.json.s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4042a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.json.s invoke() {
            return new com.json.s();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/r0;", "a", "()Lcom/ironsource/r0;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0<r0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f4043a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r0 invoke() {
            return new r0(null, 1, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/j8;", "a", "()Lcom/ironsource/j8;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0<j8> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4044a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j8 invoke() {
            return new j8(null, null, null, 7, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/m4;", "a", "()Lcom/ironsource/m4;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0<m4> {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m4 invoke() {
            return new m4(mm.this.O());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/ab;", "a", "()Lcom/ironsource/ab;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0<ab> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f4046a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ab invoke() {
            return new ab();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/pb;", "a", "()Lcom/ironsource/pb;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0<pb> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f4047a = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pb invoke() {
            return new pb();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/sc;", "a", "()Lcom/ironsource/sc;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0<sc> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f4048a = new i();

        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sc invoke() {
            return new sc();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/dh;", "a", "()Lcom/ironsource/dh;"}, k = 3, mv = {1, 8, 0})
    static final class j extends Lambda implements Function0<dh> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f4049a = new j();

        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final dh invoke() {
            return new dh();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/mp;", "a", "()Lcom/ironsource/mp;"}, k = 3, mv = {1, 8, 0})
    static final class k extends Lambda implements Function0<mp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f4050a = new k();

        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final mp invoke() {
            return new mp(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/op;", "a", "()Lcom/ironsource/op;"}, k = 3, mv = {1, 8, 0})
    static final class l extends Lambda implements Function0<op> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f4051a = new l();

        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final op invoke() {
            return new op();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/hq;", "a", "()Lcom/ironsource/hq;"}, k = 3, mv = {1, 8, 0})
    static final class m extends Lambda implements Function0<hq> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f4052a = new m();

        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final hq invoke() {
            return new hq();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/lr;", "a", "()Lcom/ironsource/lr;"}, k = 3, mv = {1, 8, 0})
    static final class n extends Lambda implements Function0<lr> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f4053a = new n();

        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lr invoke() {
            return new lr();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/cs;", "a", "()Lcom/ironsource/cs;"}, k = 3, mv = {1, 8, 0})
    static final class o extends Lambda implements Function0<cs> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f4054a = new o();

        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final cs invoke() {
            return new cs(new es(null, 1, 0 == true ? 1 : 0), null, null, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/qs;", "a", "()Lcom/ironsource/qs;"}, k = 3, mv = {1, 8, 0})
    static final class p extends Lambda implements Function0<qs> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f4055a = new p();

        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final qs invoke() {
            return new qs();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/rs;", "a", "()Lcom/ironsource/rs;"}, k = 3, mv = {1, 8, 0})
    static final class q extends Lambda implements Function0<rs> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f4056a = new q();

        q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final rs invoke() {
            return new rs();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/us;", "a", "()Lcom/ironsource/us;"}, k = 3, mv = {1, 8, 0})
    static final class r extends Lambda implements Function0<us> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f4057a = new r();

        r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final us invoke() {
            return new us();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/fu;", "a", "()Lcom/ironsource/fu;"}, k = 3, mv = {1, 8, 0})
    static final class s extends Lambda implements Function0<fu> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f4058a = new s();

        s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final fu invoke() {
            return new fu();
        }
    }

    private mm() {
        this.sessionDepthManager = LazyKt.lazy(q.f4056a);
        this.deviceInfoService = LazyKt.lazy(g.f4046a);
        this.sessionCappingService = LazyKt.lazy(p.f4055a);
        this.adFormatCappingService = LazyKt.lazy(c.f4042a);
        this.placementCappingServiceLegacy = LazyKt.lazy(l.f4051a);
        this.adUnitCappingService = LazyKt.lazy(e.f4044a);
        this.placementCappingService = LazyKt.lazy(k.f4050a);
        this.rewardService = LazyKt.lazy(m.f4052a);
        this.sessionHistoryService = LazyKt.lazy(r.f4057a);
        this.adInternalInfoService = LazyKt.lazy(d.f4043a);
        this.ironSourceNetworkConfigurationsManager = LazyKt.lazy(j.f4049a);
        this.sdkConfigService = LazyKt.lazy(n.f4053a);
        this.featureAvailabilityService = LazyKt.lazy(i.f4048a);
        this.applicationLifecycleService = LazyKt.lazy(new f());
        this.sdkSessionInfoService = LazyKt.lazy(o.f4054a);
        this.epService = LazyKt.lazy(h.f4047a);
        this.testSuiteLoadConfigService = LazyKt.lazy(s.f4058a);
    }

    public /* synthetic */ mm(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final com.json.s H() {
        return (com.json.s) this.adFormatCappingService.getValue();
    }

    private final r0 I() {
        return (r0) this.adInternalInfoService.getValue();
    }

    private final j8 J() {
        return (j8) this.adUnitCappingService.getValue();
    }

    private final m4 K() {
        return (m4) this.applicationLifecycleService.getValue();
    }

    private final ab L() {
        return (ab) this.deviceInfoService.getValue();
    }

    public static final wf M() {
        return INSTANCE.a();
    }

    private final pb N() {
        return (pb) this.epService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sc O() {
        return (sc) this.featureAvailabilityService.getValue();
    }

    private final dh P() {
        return (dh) this.ironSourceNetworkConfigurationsManager.getValue();
    }

    private final mp Q() {
        return (mp) this.placementCappingService.getValue();
    }

    private final op R() {
        return (op) this.placementCappingServiceLegacy.getValue();
    }

    public static final xf S() {
        return INSTANCE.d();
    }

    private final hq T() {
        return (hq) this.rewardService.getValue();
    }

    private final lr U() {
        return (lr) this.sdkConfigService.getValue();
    }

    private final cs V() {
        return (cs) this.sdkSessionInfoService.getValue();
    }

    private final qs W() {
        return (qs) this.sessionCappingService.getValue();
    }

    private final rs X() {
        return (rs) this.sessionDepthManager.getValue();
    }

    private final us Y() {
        return (us) this.sessionHistoryService.getValue();
    }

    private final fu Z() {
        return (fu) this.testSuiteLoadConfigService.getValue();
    }

    @Override // com.json.wf
    public eg.a A() {
        return T();
    }

    @Override // com.json.xf
    public bg B() {
        return R();
    }

    @Override // com.json.wf
    public ye.a C() {
        return H();
    }

    @Override // com.json.wf
    public wh.a D() {
        return U();
    }

    @Override // com.json.wf
    public p0.a E() {
        return I();
    }

    @Override // com.json.xf
    public p0 F() {
        return I();
    }

    @Override // com.json.wf
    public zf.a a() {
        return Q();
    }

    @Override // com.json.wf
    public nf.a b() {
        return L();
    }

    @Override // com.json.xf
    public uf c() {
        return O();
    }

    @Override // com.json.xf
    public pf d() {
        return N();
    }

    @Override // com.json.wf
    public ai.a e() {
        return X();
    }

    @Override // com.json.xf
    public nf f() {
        return L();
    }

    @Override // com.json.wf
    public bi.a g() {
        return Y();
    }

    @Override // com.json.xf
    public xh h() {
        return V();
    }

    @Override // com.json.wf
    public zh.a i() {
        return W();
    }

    @Override // com.json.xf
    public zh j() {
        return W();
    }

    @Override // com.json.xf
    public ai k() {
        return X();
    }

    @Override // com.json.xf
    public bi l() {
        return Y();
    }

    @Override // com.json.wf
    public bg.a m() {
        return R();
    }

    @Override // com.json.wf
    public ch.a n() {
        return P();
    }

    @Override // com.json.xf
    public fi o() {
        return Z();
    }

    @Override // com.json.xf
    public eg p() {
        return T();
    }

    @Override // com.json.wf
    public xh.a q() {
        return V();
    }

    @Override // com.json.xf
    public ye r() {
        return H();
    }

    @Override // com.json.wf
    public fi.a s() {
        return Z();
    }

    @Override // com.json.xf
    public wh t() {
        return U();
    }

    @Override // com.json.xf
    public ff u() {
        return J();
    }

    @Override // com.json.xf
    public bf v() {
        return K();
    }

    @Override // com.json.wf
    public ff.a w() {
        return J();
    }

    @Override // com.json.wf
    public pf.a x() {
        return N();
    }

    @Override // com.json.xf
    public zf y() {
        return Q();
    }

    @Override // com.json.xf
    public ch z() {
        return P();
    }
}
