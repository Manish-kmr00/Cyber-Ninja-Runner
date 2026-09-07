package com.bykv.vk.openvk.preload.geckox.model;

import com.adjust.sdk.Constants;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.bykv.vk.openvk.preload.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CheckRequestBodyModel {

    @b(a = "common")
    private Common common;

    @b(a = "custom")
    private Map<String, Map<String, Object>> custom;

    @b(a = "deployment")
    private Map<String, List<ChannelInfo>> deployment;

    @b(a = "deployments")
    private Map<String, Object> deployments;

    @b(a = "local")
    private Map<String, Map<String, LocalChannel>> local;

    public static class Channels {

        @b(a = "channels")
        public List<Channel> channels = new ArrayList();
    }

    public static class Group {

        @b(a = "group_name")
        public String groupName;

        @b(a = "target_channels")
        public List<TargetChannel> targetChannels;
    }

    public static class LocalChannel {

        @b(a = "l_v")
        public Long localVersion;
    }

    public static class ProcessorParams {

        @b(a = "domain")
        public String domain;
    }

    public void setDeployments(Map<String, Object> map) {
        this.deployments = map;
    }

    public void setLocal(Map<String, Map<String, LocalChannel>> map) {
        this.local = map;
    }

    public void setCustom(Map<String, Map<String, Object>> map) {
        this.custom = map;
    }

    public void setCommon(Common common) {
        this.common = common;
    }

    public void putChannelInfo(String str, List<ChannelInfo> list) {
        if (this.deployment == null) {
            this.deployment = new HashMap();
        }
        this.deployment.put(str, list);
    }

    public static class ChannelInfo {

        @b(a = "channel")
        private String channel;

        @b(a = "local_version")
        private long localVersion;

        public ChannelInfo(String str, long j) {
            this.channel = str;
            this.localVersion = j;
        }
    }

    public enum GroupType {
        NORMAL(Constants.NORMAL),
        HIGHPRIORITY("high_priority");

        private String value;

        GroupType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static class TargetChannel {

        @b(a = ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM)
        public String channelName;

        @b(a = "t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String str) {
            this.channelName = str;
        }

        public TargetChannel(String str, Long l) {
            this.channelName = str;
            this.targetVersion = l;
        }
    }

    public static class Channel {

        @b(a = ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM)
        String channelName;

        @b(a = "l_v")
        public String localVersion;

        public Channel(String str) {
            this.channelName = str;
        }
    }
}
