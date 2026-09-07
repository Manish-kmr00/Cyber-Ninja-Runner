package com.smaato.sdk.core.remoteconfig.publisher;

import com.json.b9;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkConnectionType;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;

/* JADX INFO: loaded from: classes7.dex */
public interface Param {
    String getName();

    Object getValue();

    public static class SdkVersion implements Param {
        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "clientSdkVersion";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return String.format("ubsdkandroid_%s", SmaatoSdk.getVersion());
        }
    }

    public static class ConnectionType implements Param {
        private final NetworkConnectionType networkConnectionType;

        public ConnectionType(DataCollector dataCollector) {
            this.networkConnectionType = dataCollector.getSystemInfo().getNetworkConnectionType();
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return b9.i.t;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            NetworkConnectionType networkConnectionType = this.networkConnectionType;
            if (networkConnectionType == null) {
                return null;
            }
            return networkConnectionType.toString();
        }
    }

    public static class PublisherId implements Param {
        private final String publisherId;

        public PublisherId(String str) {
            this.publisherId = str;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "publisherId";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.publisherId;
        }
    }

    public static class Timestamp implements Param {
        private final Long timestamp;

        public Timestamp(Long l) {
            this.timestamp = l;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "originalRequestTime";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.timestamp;
        }
    }

    public static class ErrorType implements Param {
        private final String error;

        public ErrorType(String str) {
            this.error = str;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "errorType";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.error;
        }
    }

    public static class SampleRate implements Param {
        private final int sampleRate;

        public SampleRate(int i) {
            this.sampleRate = i;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "sampleRate";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return Integer.valueOf(this.sampleRate);
        }
    }

    public static class AdSpaceId implements Param {
        private final String adSpaceId;

        public AdSpaceId(String str) {
            this.adSpaceId = str;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "adSpaceId";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.adSpaceId;
        }
    }

    public static class SessionId implements Param {
        private final String sessionId;

        public SessionId(String str) {
            this.sessionId = str;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return JsonStorageKeyNames.SESSION_ID_KEY;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.sessionId;
        }
    }

    public static class Sci implements Param {
        private final String sci;

        public Sci(String str) {
            this.sci = str;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "somaSciHeader";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return this.sci;
        }
    }

    public static class FormatOfAd implements Param {
        private final AdFormat adFormat;
        private final HeaderValueUtils headerValueUtils;

        public FormatOfAd(Logger logger, AdFormat adFormat) {
            this.adFormat = adFormat;
            this.headerValueUtils = new HeaderValueUtils(logger);
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            AdFormat adFormat = this.adFormat;
            if (adFormat == null) {
                return null;
            }
            return this.headerValueUtils.adFormatToApiValue(adFormat);
        }
    }

    public static class ConfiguredTimeout implements Param {
        private final long configuredTimeoutMillis;

        public ConfiguredTimeout(long j) {
            this.configuredTimeoutMillis = j;
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public String getName() {
            return "configuredTimeout";
        }

        @Override // com.smaato.sdk.core.remoteconfig.publisher.Param
        public Object getValue() {
            return Long.valueOf(this.configuredTimeoutMillis);
        }
    }
}
