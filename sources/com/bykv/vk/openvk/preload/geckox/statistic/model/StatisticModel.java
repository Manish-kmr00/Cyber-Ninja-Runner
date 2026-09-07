package com.bykv.vk.openvk.preload.geckox.statistic.model;

import com.bykv.vk.openvk.preload.a.a.b;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class StatisticModel {

    @b(a = "common")
    public Common common;

    @b(a = "packages")
    public List<PackageStatisticModel> packages = new ArrayList();

    public static class PackageStatisticModel {

        @b(a = CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)
        public String ac;

        @b(a = "access_key")
        public String accessKey;

        @b(a = "active_check_duration")
        public Long activeCheckDuration;

        @b(a = "apply_duration")
        public Long applyDuration;

        @b(a = "channel")
        public String channel;

        @b(a = "clean_duration")
        public Long cleanDuration;

        @b(a = "clean_strategy")
        public Integer cleanStrategy;

        @b(a = "clean_type")
        public Integer cleanType;

        @b(a = "download_duration")
        public Long downloadDuration;

        @b(a = "download_fail_records")
        public List<DownloadFailRecords> downloadFailRecords;

        @b(a = "download_retry_times")
        public Integer downloadRetryTimes;

        @b(a = DownloadModel.DOWNLOAD_URL)
        public String downloadUrl;

        @b(a = "err_code")
        public String errCode;

        @b(a = "err_msg")
        public String errMsg;

        @b(a = "group_name")
        public String groupName;

        @b(a = "id")
        public Long id;

        @b(a = "log_id")
        public String logId;

        @b(a = "patch_id")
        public Long patchId;

        @b(a = "stats_type")
        public Integer statsType;

        public static class DownloadFailRecords {

            @b(a = "domain")
            public String domain;

            @b(a = "reason")
            public String reason;

            public DownloadFailRecords(String str, String str2) {
                this.domain = str;
                this.reason = str2;
            }
        }
    }
}
