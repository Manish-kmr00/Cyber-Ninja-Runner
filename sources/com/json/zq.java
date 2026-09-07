package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/zq;", "Lcom/ironsource/lm;", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface zq extends lm<Integer, Integer> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/ironsource/zq$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "INSTANCE_SHOW", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "INSTANCE_SHOW_FAILED", "d", "INSTANCE_OPENED", "e", "INSTANCE_VISIBLE", InneractiveMediationDefs.GENDER_FEMALE, "INSTANCE_CLICKED", "g", "INSTANCE_CLOSED", "h", "INSTANCE_NOT_FOUND_IN_SHOW", "i", "INSTANCE_REWARDED", "j", "INSTANCE_READY_TRUE", CampaignEx.JSON_KEY_AD_K, "INSTANCE_READY_FALSE", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4660a = new a();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final int INSTANCE_SHOW = 1201;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final int INSTANCE_SHOW_FAILED = 1202;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public static final int INSTANCE_OPENED = 1005;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public static final int INSTANCE_VISIBLE = 1206;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public static final int INSTANCE_CLICKED = 1006;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public static final int INSTANCE_CLOSED = 1203;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public static final int INSTANCE_NOT_FOUND_IN_SHOW = 1507;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public static final int INSTANCE_REWARDED = 1010;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public static final int INSTANCE_READY_TRUE = 1210;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        public static final int INSTANCE_READY_FALSE = 1211;

        private a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ironsource/zq$b;", "", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4661a = new b();

        private b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/ironsource/zq$c;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "INSTANCE_LOAD", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "INSTANCE_LOAD_SUCCESS", "d", "INSTANCE_LOAD_FAILED", "e", "INSTANCE_AUCTION_FAILED", InneractiveMediationDefs.GENDER_FEMALE, "INSTANCE_NOT_FOUND_IN_LOAD", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4662a = new c();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final int INSTANCE_LOAD = 1001;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final int INSTANCE_LOAD_SUCCESS = 1002;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public static final int INSTANCE_LOAD_FAILED = 1200;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_FAILED = 1301;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public static final int INSTANCE_NOT_FOUND_IN_LOAD = 1503;

        private c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/ironsource/zq$d;", "Lcom/ironsource/zq;", "", "input", "a", "(I)Ljava/lang/Integer;", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements zq {
        public Integer a(int input) throws IllegalArgumentException {
            int i;
            if (input == 206) {
                i = 1503;
            } else if (input != 401) {
                switch (input) {
                    case 101:
                        i = 81500;
                        break;
                    case 102:
                        i = 81510;
                        break;
                    case 103:
                        i = 81301;
                        break;
                    case 104:
                        i = 81300;
                        break;
                    case 105:
                        i = 81002;
                        break;
                    default:
                        switch (input) {
                            case 109:
                                i = 88002;
                                break;
                            case 110:
                                i = 83003;
                                break;
                            case 111:
                                i = 81302;
                                break;
                            case 112:
                                i = e.INSTANCE_DESTROYED;
                                break;
                            default:
                                switch (input) {
                                    case 201:
                                        i = 1001;
                                        break;
                                    case 202:
                                        i = 1002;
                                        break;
                                    case 203:
                                        i = 1200;
                                        break;
                                    case 204:
                                        i = 1301;
                                        break;
                                    default:
                                        switch (input) {
                                            case 403:
                                                i = 1202;
                                                break;
                                            case 404:
                                                i = 1005;
                                                break;
                                            case 405:
                                                i = 1206;
                                                break;
                                            case 406:
                                                i = 1006;
                                                break;
                                            case 407:
                                                i = 1203;
                                                break;
                                            case 408:
                                                i = 1507;
                                                break;
                                            case 409:
                                                i = 1010;
                                                break;
                                            case 410:
                                                i = 1210;
                                                break;
                                            case 411:
                                                i = 1211;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Unknown event code: " + input);
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                i = 1201;
            }
            return Integer.valueOf(i);
        }

        @Override // com.json.lm
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/ironsource/zq$e;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "INSTANCE_AUCTION_REQUEST", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "INSTANCE_AUCTION_REQUEST_WATERFALL", "d", "INSTANCE_AUCTION_RESPONSE_SUCCESS", "e", "INSTANCE_AUCTION_FAILED", InneractiveMediationDefs.GENDER_FEMALE, "INSTANCE_LOAD_WITH_ADM", "g", "INSTANCE_SUCCESSFUL_RECOVERY_ERROR", "h", "INSTANCE_LOAD_FAILED_INIT_IN_PROGRESS", "i", "INSTANCE_AUCTION_RESPONSE_WATERFALL", "j", "INSTANCE_DESTROYED", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4663a = new e();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_REQUEST = 81500;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_REQUEST_WATERFALL = 81510;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_RESPONSE_SUCCESS = 81301;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_FAILED = 81300;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public static final int INSTANCE_LOAD_WITH_ADM = 81002;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public static final int INSTANCE_SUCCESSFUL_RECOVERY_ERROR = 88002;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public static final int INSTANCE_LOAD_FAILED_INIT_IN_PROGRESS = 83003;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public static final int INSTANCE_AUCTION_RESPONSE_WATERFALL = 81302;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public static final int INSTANCE_DESTROYED = 81077;

        private e() {
        }
    }
}
