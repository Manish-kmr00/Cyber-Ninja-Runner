package io.bidmachine.protobuf.sessionmetrics;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistry;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.MapEntry;
import com.explorestack.protobuf.MapField;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.ProtocolMessageEnum;
import com.explorestack.protobuf.RepeatedFieldBuilderV3;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.WireFormat;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SessionDepth {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'bidmachine/protobuf/session_depth.proto\u0012\u000esessionmetrics\"Õ\u0002\n\tUserState\u0012 \n\u0018last_processed_timestamp\u0018\u0001 \u0001(\u0003\u0012?\n\u000bimpressions\u0018\u0002 \u0003(\u000b2*.sessionmetrics.UserState.ImpressionsEntry\u0012>\n\u000bad_requests\u0018\u0003 \u0003(\u000b2).sessionmetrics.UserState.AdRequestsEntry\u001aV\n\u0010ImpressionsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0005\u00121\n\u0005value\u0018\u0002 \u0001(\u000b2\".sessionmetrics.AdDomainTimestamps:\u00028\u0001\u001aM\n\u000fAdRequestsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0005\u0012)\n\u0005value\u0018\u0002 \u0001(\u000b2\u001a.sessionmetrics.Timestamps:\u00028\u0001\"\u009f\u0001\n\nTimestamps\u0012\u0016\n\u000elast_timestamp\u0018\u0001 \u0001(\u0003\u0012\u000e\n\u0006deltas\u0018\u0002 \u0003(\r\u00129\n\u000bday_buckets\u0018\u0003 \u0003(\u000b2$.sessionmetrics.Timestamps.DayBucket\u001a.\n\tDayBucket\u0012\u0012\n\nstart_time\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005count\u0018\u0002 \u0001(\u0005\"©\u0001\n\u0012AdDomainTimestamps\u0012E\n\nad_domains\u0018\u0001 \u0003(\u000b21.sessionmetrics.AdDomainTimestamps.AdDomainsEntry\u001aL\n\u000eAdDomainsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012)\n\u0005value\u0018\u0002 \u0001(\u000b2\u001a.sessionmetrics.Timestamps:\u00028\u0001\"B\n\rWindowMetrics\u0012\u000f\n\u0007last_1h\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007last_1d\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007last_7d\u0018\u0003 \u0001(\u0005\"Ö\u0001\n\u0011ImpressionMetrics\u0012'\n\u0007ad_type\u0018\u0001 \u0001(\u000e2\u0016.sessionmetrics.AdType\u0012@\n\u0007domains\u0018\u0002 \u0003(\u000b2/.sessionmetrics.ImpressionMetrics.DomainMetrics\u001aV\n\rDomainMetrics\u0012\u000e\n\u0006domain\u0018\u0001 \u0001(\t\u00125\n\u000ewindow_metrics\u0018\u0002 \u0001(\u000b2\u001d.sessionmetrics.WindowMetrics\"r\n\u0010AdRequestMetrics\u0012'\n\u0007ad_type\u0018\u0001 \u0001(\u000e2\u0016.sessionmetrics.AdType\u00125\n\u000ewindow_metrics\u0018\u0002 \u0001(\u000b2\u001d.sessionmetrics.WindowMetrics\"\u007f\n\u000eSessionMetrics\u00126\n\u000bimpressions\u0018\u0001 \u0003(\u000b2!.sessionmetrics.ImpressionMetrics\u00125\n\u000bad_requests\u0018\u0002 \u0003(\u000b2 .sessionmetrics.AdRequestMetrics\"1\n\u000bUserIdQuery\u0012\u000f\n\u0007user_id\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\"X\n\tAdRequest\u0012\u000f\n\u0007user_id\u0018\u0001 \u0001(\t\u0012'\n\u0007ad_type\u0018\u0002 \u0001(\u000e2\u0016.sessionmetrics.AdType\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003*5\n\u0006AdType\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0010\n\fINTERSTITIAL\u0010\u0001\u0012\f\n\bREWARDED\u0010\u00022²\u0001\n\u000eSessionService\u0012P\n\u0011GetSessionMetrics\u0012\u001b.sessionmetrics.UserIdQuery\u001a\u001e.sessionmetrics.SessionMetrics\u0012N\n\u0011RegisterAdRequest\u0012\u0019.sessionmetrics.AdRequest\u001a\u001e.sessionmetrics.SessionMetricsB'\n%io.bidmachine.protobuf.sessionmetricsb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdRequestMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_ImpressionMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_SessionMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_Timestamps_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_Timestamps_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserIdQuery_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_AdRequestsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_ImpressionsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_WindowMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable;

    public interface AdDomainTimestampsOrBuilder extends MessageOrBuilder {
        boolean containsAdDomains(String str);

        @Deprecated
        Map<String, Timestamps> getAdDomains();

        int getAdDomainsCount();

        Map<String, Timestamps> getAdDomainsMap();

        Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps);

        Timestamps getAdDomainsOrThrow(String str);
    }

    public interface AdRequestMetricsOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        WindowMetrics getWindowMetrics();

        WindowMetricsOrBuilder getWindowMetricsOrBuilder();

        boolean hasWindowMetrics();
    }

    public interface AdRequestOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        long getTimestamp();

        String getUserId();

        ByteString getUserIdBytes();
    }

    public interface ImpressionMetricsOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        ImpressionMetrics.DomainMetrics getDomains(int i);

        int getDomainsCount();

        List<ImpressionMetrics.DomainMetrics> getDomainsList();

        ImpressionMetrics.DomainMetricsOrBuilder getDomainsOrBuilder(int i);

        List<? extends ImpressionMetrics.DomainMetricsOrBuilder> getDomainsOrBuilderList();
    }

    public interface SessionMetricsOrBuilder extends MessageOrBuilder {
        AdRequestMetrics getAdRequests(int i);

        int getAdRequestsCount();

        List<AdRequestMetrics> getAdRequestsList();

        AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i);

        List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList();

        ImpressionMetrics getImpressions(int i);

        int getImpressionsCount();

        List<ImpressionMetrics> getImpressionsList();

        ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i);

        List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList();
    }

    public interface TimestampsOrBuilder extends MessageOrBuilder {
        Timestamps.DayBucket getDayBuckets(int i);

        int getDayBucketsCount();

        List<Timestamps.DayBucket> getDayBucketsList();

        Timestamps.DayBucketOrBuilder getDayBucketsOrBuilder(int i);

        List<? extends Timestamps.DayBucketOrBuilder> getDayBucketsOrBuilderList();

        int getDeltas(int i);

        int getDeltasCount();

        List<Integer> getDeltasList();

        long getLastTimestamp();
    }

    public interface UserIdQueryOrBuilder extends MessageOrBuilder {
        long getTimestamp();

        String getUserId();

        ByteString getUserIdBytes();
    }

    public interface UserStateOrBuilder extends MessageOrBuilder {
        boolean containsAdRequests(int i);

        boolean containsImpressions(int i);

        @Deprecated
        Map<Integer, Timestamps> getAdRequests();

        int getAdRequestsCount();

        Map<Integer, Timestamps> getAdRequestsMap();

        Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps);

        Timestamps getAdRequestsOrThrow(int i);

        @Deprecated
        Map<Integer, AdDomainTimestamps> getImpressions();

        int getImpressionsCount();

        Map<Integer, AdDomainTimestamps> getImpressionsMap();

        AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps);

        AdDomainTimestamps getImpressionsOrThrow(int i);

        long getLastProcessedTimestamp();
    }

    public interface WindowMetricsOrBuilder extends MessageOrBuilder {
        int getLast1D();

        int getLast1H();

        int getLast7D();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private SessionDepth() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public enum AdType implements ProtocolMessageEnum {
        UNKNOWN(0),
        INTERSTITIAL(1),
        REWARDED(2),
        UNRECOGNIZED(-1);

        public static final int INTERSTITIAL_VALUE = 1;
        public static final int REWARDED_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<AdType> internalValueMap = new Internal.EnumLiteMap<AdType>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdType.1
            @Override // com.explorestack.protobuf.Internal.EnumLiteMap
            public AdType findValueByNumber(int i) {
                return AdType.forNumber(i);
            }
        };
        private static final AdType[] VALUES = values();

        @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static AdType valueOf(int i) {
            return forNumber(i);
        }

        public static AdType forNumber(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return INTERSTITIAL;
            }
            if (i != 2) {
                return null;
            }
            return REWARDED;
        }

        public static Internal.EnumLiteMap<AdType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.explorestack.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) {
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.explorestack.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SessionDepth.getDescriptor().getEnumTypes().get(0);
        }

        public static AdType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        AdType(int i) {
            this.value = i;
        }
    }

    public static final class UserState extends GeneratedMessageV3 implements UserStateOrBuilder {
        public static final int AD_REQUESTS_FIELD_NUMBER = 3;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        public static final int LAST_PROCESSED_TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private MapField<Integer, Timestamps> adRequests_;
        private MapField<Integer, AdDomainTimestamps> impressions_;
        private long lastProcessedTimestamp_;
        private byte memoizedIsInitialized;
        private static final UserState DEFAULT_INSTANCE = new UserState();
        private static final Parser<UserState> PARSER = new AbstractParser<UserState>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserState.1
            @Override // com.explorestack.protobuf.Parser
            public UserState parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserState(codedInputStream, extensionRegistryLite);
            }
        };

        private UserState(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserState() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserState();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private UserState(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.lastProcessedTimestamp_ = codedInputStream.readInt64();
                            } else if (tag == 18) {
                                if ((i & 1) == 0) {
                                    this.impressions_ = MapField.newMapField(ImpressionsDefaultEntryHolder.defaultEntry);
                                    i |= 1;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ImpressionsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.impressions_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                            } else if (tag == 26) {
                                if ((i & 2) == 0) {
                                    this.adRequests_ = MapField.newMapField(AdRequestsDefaultEntryHolder.defaultEntry);
                                    i |= 2;
                                }
                                MapEntry mapEntry2 = (MapEntry) codedInputStream.readMessage(AdRequestsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.adRequests_.getMutableMap().put(mapEntry2.getKey(), mapEntry2.getValue());
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_UserState_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 2) {
                return internalGetImpressions();
            }
            if (i == 3) {
                return internalGetAdRequests();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_UserState_fieldAccessorTable.ensureFieldAccessorsInitialized(UserState.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public long getLastProcessedTimestamp() {
            return this.lastProcessedTimestamp_;
        }

        private static final class ImpressionsDefaultEntryHolder {
            static final MapEntry<Integer, AdDomainTimestamps> defaultEntry = MapEntry.newDefaultInstance(SessionDepth.internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor, WireFormat.FieldType.INT32, 0, WireFormat.FieldType.MESSAGE, AdDomainTimestamps.getDefaultInstance());

            private ImpressionsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<Integer, AdDomainTimestamps> internalGetImpressions() {
            MapField<Integer, AdDomainTimestamps> mapField = this.impressions_;
            return mapField == null ? MapField.emptyMapField(ImpressionsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public int getImpressionsCount() {
            return internalGetImpressions().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public boolean containsImpressions(int i) {
            return internalGetImpressions().getMap().containsKey(Integer.valueOf(i));
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        @Deprecated
        public Map<Integer, AdDomainTimestamps> getImpressions() {
            return getImpressionsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public Map<Integer, AdDomainTimestamps> getImpressionsMap() {
            return internalGetImpressions().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps) {
            Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
            return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : adDomainTimestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public AdDomainTimestamps getImpressionsOrThrow(int i) {
            Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
            if (!map.containsKey(Integer.valueOf(i))) {
                throw new IllegalArgumentException();
            }
            return map.get(Integer.valueOf(i));
        }

        private static final class AdRequestsDefaultEntryHolder {
            static final MapEntry<Integer, Timestamps> defaultEntry = MapEntry.newDefaultInstance(SessionDepth.internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor, WireFormat.FieldType.INT32, 0, WireFormat.FieldType.MESSAGE, Timestamps.getDefaultInstance());

            private AdRequestsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<Integer, Timestamps> internalGetAdRequests() {
            MapField<Integer, Timestamps> mapField = this.adRequests_;
            return mapField == null ? MapField.emptyMapField(AdRequestsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public int getAdRequestsCount() {
            return internalGetAdRequests().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public boolean containsAdRequests(int i) {
            return internalGetAdRequests().getMap().containsKey(Integer.valueOf(i));
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        @Deprecated
        public Map<Integer, Timestamps> getAdRequests() {
            return getAdRequestsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public Map<Integer, Timestamps> getAdRequestsMap() {
            return internalGetAdRequests().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps) {
            Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
            return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : timestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
        public Timestamps getAdRequestsOrThrow(int i) {
            Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
            if (!map.containsKey(Integer.valueOf(i))) {
                throw new IllegalArgumentException();
            }
            return map.get(Integer.valueOf(i));
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.lastProcessedTimestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            GeneratedMessageV3.serializeIntegerMapTo(codedOutputStream, internalGetImpressions(), ImpressionsDefaultEntryHolder.defaultEntry, 2);
            GeneratedMessageV3.serializeIntegerMapTo(codedOutputStream, internalGetAdRequests(), AdRequestsDefaultEntryHolder.defaultEntry, 3);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.lastProcessedTimestamp_;
            int iComputeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            for (Map.Entry<Integer, AdDomainTimestamps> entry : internalGetImpressions().getMap().entrySet()) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, ImpressionsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Timestamps> entry2 : internalGetAdRequests().getMap().entrySet()) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, AdRequestsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            int serializedSize = iComputeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserState)) {
                return super.equals(obj);
            }
            UserState userState = (UserState) obj;
            return getLastProcessedTimestamp() == userState.getLastProcessedTimestamp() && internalGetImpressions().equals(userState.internalGetImpressions()) && internalGetAdRequests().equals(userState.internalGetAdRequests()) && this.unknownFields.equals(userState.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLastProcessedTimestamp());
            if (!internalGetImpressions().getMap().isEmpty()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + internalGetImpressions().hashCode();
            }
            if (!internalGetAdRequests().getMap().isEmpty()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + internalGetAdRequests().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static UserState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserState parseFrom(InputStream inputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserState userState) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userState);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserStateOrBuilder {
            private MapField<Integer, Timestamps> adRequests_;
            private int bitField0_;
            private MapField<Integer, AdDomainTimestamps> impressions_;
            private long lastProcessedTimestamp_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_UserState_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 2) {
                    return internalGetImpressions();
                }
                if (i == 3) {
                    return internalGetAdRequests();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 2) {
                    return internalGetMutableImpressions();
                }
                if (i == 3) {
                    return internalGetMutableAdRequests();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_UserState_fieldAccessorTable.ensureFieldAccessorsInitialized(UserState.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserState.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lastProcessedTimestamp_ = 0L;
                internalGetMutableImpressions().clear();
                internalGetMutableAdRequests().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_UserState_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public UserState getDefaultInstanceForType() {
                return UserState.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserState build() {
                UserState userStateBuildPartial = buildPartial();
                if (userStateBuildPartial.isInitialized()) {
                    return userStateBuildPartial;
                }
                throw newUninitializedMessageException((Message) userStateBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserState buildPartial() {
                UserState userState = new UserState(this);
                userState.lastProcessedTimestamp_ = this.lastProcessedTimestamp_;
                userState.impressions_ = internalGetImpressions();
                userState.impressions_.makeImmutable();
                userState.adRequests_ = internalGetAdRequests();
                userState.adRequests_.makeImmutable();
                onBuilt();
                return userState;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof UserState) {
                    return mergeFrom((UserState) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserState userState) {
                if (userState == UserState.getDefaultInstance()) {
                    return this;
                }
                if (userState.getLastProcessedTimestamp() != 0) {
                    setLastProcessedTimestamp(userState.getLastProcessedTimestamp());
                }
                internalGetMutableImpressions().mergeFrom(userState.internalGetImpressions());
                internalGetMutableAdRequests().mergeFrom(userState.internalGetAdRequests());
                mergeUnknownFields(userState.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                UserState userState = null;
                try {
                    try {
                        UserState userState2 = (UserState) UserState.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (userState2 != null) {
                            mergeFrom(userState2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        UserState userState3 = (UserState) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            userState = userState3;
                            if (userState != null) {
                                mergeFrom(userState);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (userState != null) {
                        mergeFrom(userState);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public long getLastProcessedTimestamp() {
                return this.lastProcessedTimestamp_;
            }

            public Builder setLastProcessedTimestamp(long j) {
                this.lastProcessedTimestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearLastProcessedTimestamp() {
                this.lastProcessedTimestamp_ = 0L;
                onChanged();
                return this;
            }

            private MapField<Integer, AdDomainTimestamps> internalGetImpressions() {
                MapField<Integer, AdDomainTimestamps> mapField = this.impressions_;
                return mapField == null ? MapField.emptyMapField(ImpressionsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<Integer, AdDomainTimestamps> internalGetMutableImpressions() {
                onChanged();
                if (this.impressions_ == null) {
                    this.impressions_ = MapField.newMapField(ImpressionsDefaultEntryHolder.defaultEntry);
                }
                if (!this.impressions_.isMutable()) {
                    this.impressions_ = this.impressions_.copy();
                }
                return this.impressions_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public int getImpressionsCount() {
                return internalGetImpressions().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public boolean containsImpressions(int i) {
                return internalGetImpressions().getMap().containsKey(Integer.valueOf(i));
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            @Deprecated
            public Map<Integer, AdDomainTimestamps> getImpressions() {
                return getImpressionsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public Map<Integer, AdDomainTimestamps> getImpressionsMap() {
                return internalGetImpressions().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps) {
                Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
                return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : adDomainTimestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public AdDomainTimestamps getImpressionsOrThrow(int i) {
                Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
                if (!map.containsKey(Integer.valueOf(i))) {
                    throw new IllegalArgumentException();
                }
                return map.get(Integer.valueOf(i));
            }

            public Builder clearImpressions() {
                internalGetMutableImpressions().getMutableMap().clear();
                return this;
            }

            public Builder removeImpressions(int i) {
                internalGetMutableImpressions().getMutableMap().remove(Integer.valueOf(i));
                return this;
            }

            @Deprecated
            public Map<Integer, AdDomainTimestamps> getMutableImpressions() {
                return internalGetMutableImpressions().getMutableMap();
            }

            public Builder putImpressions(int i, AdDomainTimestamps adDomainTimestamps) {
                adDomainTimestamps.getClass();
                internalGetMutableImpressions().getMutableMap().put(Integer.valueOf(i), adDomainTimestamps);
                return this;
            }

            public Builder putAllImpressions(Map<Integer, AdDomainTimestamps> map) {
                internalGetMutableImpressions().getMutableMap().putAll(map);
                return this;
            }

            private MapField<Integer, Timestamps> internalGetAdRequests() {
                MapField<Integer, Timestamps> mapField = this.adRequests_;
                return mapField == null ? MapField.emptyMapField(AdRequestsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<Integer, Timestamps> internalGetMutableAdRequests() {
                onChanged();
                if (this.adRequests_ == null) {
                    this.adRequests_ = MapField.newMapField(AdRequestsDefaultEntryHolder.defaultEntry);
                }
                if (!this.adRequests_.isMutable()) {
                    this.adRequests_ = this.adRequests_.copy();
                }
                return this.adRequests_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public int getAdRequestsCount() {
                return internalGetAdRequests().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public boolean containsAdRequests(int i) {
                return internalGetAdRequests().getMap().containsKey(Integer.valueOf(i));
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            @Deprecated
            public Map<Integer, Timestamps> getAdRequests() {
                return getAdRequestsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public Map<Integer, Timestamps> getAdRequestsMap() {
                return internalGetAdRequests().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps) {
                Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
                return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : timestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserStateOrBuilder
            public Timestamps getAdRequestsOrThrow(int i) {
                Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
                if (!map.containsKey(Integer.valueOf(i))) {
                    throw new IllegalArgumentException();
                }
                return map.get(Integer.valueOf(i));
            }

            public Builder clearAdRequests() {
                internalGetMutableAdRequests().getMutableMap().clear();
                return this;
            }

            public Builder removeAdRequests(int i) {
                internalGetMutableAdRequests().getMutableMap().remove(Integer.valueOf(i));
                return this;
            }

            @Deprecated
            public Map<Integer, Timestamps> getMutableAdRequests() {
                return internalGetMutableAdRequests().getMutableMap();
            }

            public Builder putAdRequests(int i, Timestamps timestamps) {
                timestamps.getClass();
                internalGetMutableAdRequests().getMutableMap().put(Integer.valueOf(i), timestamps);
                return this;
            }

            public Builder putAllAdRequests(Map<Integer, Timestamps> map) {
                internalGetMutableAdRequests().getMutableMap().putAll(map);
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static UserState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserState> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<UserState> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public UserState getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Timestamps extends GeneratedMessageV3 implements TimestampsOrBuilder {
        public static final int DAY_BUCKETS_FIELD_NUMBER = 3;
        public static final int DELTAS_FIELD_NUMBER = 2;
        public static final int LAST_TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<DayBucket> dayBuckets_;
        private int deltasMemoizedSerializedSize;
        private Internal.IntList deltas_;
        private long lastTimestamp_;
        private byte memoizedIsInitialized;
        private static final Timestamps DEFAULT_INSTANCE = new Timestamps();
        private static final Parser<Timestamps> PARSER = new AbstractParser<Timestamps>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.1
            @Override // com.explorestack.protobuf.Parser
            public Timestamps parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Timestamps(codedInputStream, extensionRegistryLite);
            }
        };

        public interface DayBucketOrBuilder extends MessageOrBuilder {
            int getCount();

            long getStartTime();
        }

        private Timestamps(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.deltasMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Timestamps() {
            this.deltasMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.deltas_ = emptyIntList();
            this.dayBuckets_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Timestamps();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Timestamps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.lastTimestamp_ = codedInputStream.readInt64();
                            } else if (tag == 16) {
                                if ((i & 1) == 0) {
                                    this.deltas_ = newIntList();
                                    i |= 1;
                                }
                                this.deltas_.addInt(codedInputStream.readUInt32());
                            } else if (tag == 18) {
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 1) == 0 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.deltas_ = newIntList();
                                    i |= 1;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.deltas_.addInt(codedInputStream.readUInt32());
                                }
                                codedInputStream.popLimit(iPushLimit);
                            } else if (tag == 26) {
                                if ((i & 2) == 0) {
                                    this.dayBuckets_ = new ArrayList();
                                    i |= 2;
                                }
                                this.dayBuckets_.add((DayBucket) codedInputStream.readMessage(DayBucket.parser(), extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i & 1) != 0) {
                        this.deltas_.makeImmutable();
                    }
                    if ((i & 2) != 0) {
                        this.dayBuckets_ = Collections.unmodifiableList(this.dayBuckets_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if ((i & 1) != 0) {
                this.deltas_.makeImmutable();
            }
            if ((i & 2) != 0) {
                this.dayBuckets_ = Collections.unmodifiableList(this.dayBuckets_);
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_Timestamps_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_Timestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamps.class, Builder.class);
        }

        public static final class DayBucket extends GeneratedMessageV3 implements DayBucketOrBuilder {
            public static final int COUNT_FIELD_NUMBER = 2;
            private static final DayBucket DEFAULT_INSTANCE = new DayBucket();
            private static final Parser<DayBucket> PARSER = new AbstractParser<DayBucket>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.DayBucket.1
                @Override // com.explorestack.protobuf.Parser
                public DayBucket parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new DayBucket(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int START_TIME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int count_;
            private byte memoizedIsInitialized;
            private long startTime_;

            private DayBucket(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private DayBucket() {
                this.memoizedIsInitialized = (byte) -1;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new DayBucket();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DayBucket(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 8) {
                                        this.startTime_ = codedInputStream.readInt64();
                                    } else if (tag == 16) {
                                        this.count_ = codedInputStream.readInt32();
                                    } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw e.setUnfinishedMessage(this);
                            }
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        this.unknownFields = builderNewBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable.ensureFieldAccessorsInitialized(DayBucket.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.DayBucketOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.DayBucketOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                long j = this.startTime_;
                if (j != 0) {
                    codedOutputStream.writeInt64(1, j);
                }
                int i = this.count_;
                if (i != 0) {
                    codedOutputStream.writeInt32(2, i);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                long j = this.startTime_;
                int iComputeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
                int i2 = this.count_;
                if (i2 != 0) {
                    iComputeInt64Size += CodedOutputStream.computeInt32Size(2, i2);
                }
                int serializedSize = iComputeInt64Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DayBucket)) {
                    return super.equals(obj);
                }
                DayBucket dayBucket = (DayBucket) obj;
                return getStartTime() == dayBucket.getStartTime() && getCount() == dayBucket.getCount() && this.unknownFields.equals(dayBucket.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getStartTime())) * 37) + 2) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode;
                return iHashCode;
            }

            public static DayBucket parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static DayBucket parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static DayBucket parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static DayBucket parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static DayBucket parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static DayBucket parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static DayBucket parseFrom(InputStream inputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static DayBucket parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DayBucket parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static DayBucket parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DayBucket parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static DayBucket parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DayBucket dayBucket) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(dayBucket);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.explorestack.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent);
            }

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DayBucketOrBuilder {
                private int count_;
                private long startTime_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionDepth.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionDepth.internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable.ensureFieldAccessorsInitialized(DayBucket.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = DayBucket.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.startTime_ = 0L;
                    this.count_ = 0;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionDepth.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public DayBucket getDefaultInstanceForType() {
                    return DayBucket.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DayBucket build() {
                    DayBucket dayBucketBuildPartial = buildPartial();
                    if (dayBucketBuildPartial.isInitialized()) {
                        return dayBucketBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) dayBucketBuildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DayBucket buildPartial() {
                    DayBucket dayBucket = new DayBucket(this);
                    dayBucket.startTime_ = this.startTime_;
                    dayBucket.count_ = this.count_;
                    onBuilt();
                    return dayBucket;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public Builder mo4742clone() {
                    return (Builder) super.mo4742clone();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.setField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                    return (Builder) super.clearOneof(oneofDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                    return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof DayBucket) {
                        return mergeFrom((DayBucket) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(DayBucket dayBucket) {
                    if (dayBucket == DayBucket.getDefaultInstance()) {
                        return this;
                    }
                    if (dayBucket.getStartTime() != 0) {
                        setStartTime(dayBucket.getStartTime());
                    }
                    if (dayBucket.getCount() != 0) {
                        setCount(dayBucket.getCount());
                    }
                    mergeUnknownFields(dayBucket.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    DayBucket dayBucket = null;
                    try {
                        try {
                            DayBucket dayBucket2 = (DayBucket) DayBucket.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (dayBucket2 != null) {
                                mergeFrom(dayBucket2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            DayBucket dayBucket3 = (DayBucket) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                dayBucket = dayBucket3;
                                if (dayBucket != null) {
                                    mergeFrom(dayBucket);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (dayBucket != null) {
                            mergeFrom(dayBucket);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.DayBucketOrBuilder
                public long getStartTime() {
                    return this.startTime_;
                }

                public Builder setStartTime(long j) {
                    this.startTime_ = j;
                    onChanged();
                    return this;
                }

                public Builder clearStartTime() {
                    this.startTime_ = 0L;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.Timestamps.DayBucketOrBuilder
                public int getCount() {
                    return this.count_;
                }

                public Builder setCount(int i) {
                    this.count_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearCount() {
                    this.count_ = 0;
                    onChanged();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.setUnknownFields(unknownFieldSet);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.mergeUnknownFields(unknownFieldSet);
                }
            }

            public static DayBucket getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DayBucket> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<DayBucket> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public DayBucket getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public long getLastTimestamp() {
            return this.lastTimestamp_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public List<Integer> getDeltasList() {
            return this.deltas_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public int getDeltasCount() {
            return this.deltas_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public int getDeltas(int i) {
            return this.deltas_.getInt(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public List<DayBucket> getDayBucketsList() {
            return this.dayBuckets_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public List<? extends DayBucketOrBuilder> getDayBucketsOrBuilderList() {
            return this.dayBuckets_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public int getDayBucketsCount() {
            return this.dayBuckets_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public DayBucket getDayBuckets(int i) {
            return this.dayBuckets_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
        public DayBucketOrBuilder getDayBucketsOrBuilder(int i) {
            return this.dayBuckets_.get(i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            long j = this.lastTimestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (getDeltasList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.deltasMemoizedSerializedSize);
            }
            for (int i = 0; i < this.deltas_.size(); i++) {
                codedOutputStream.writeUInt32NoTag(this.deltas_.getInt(i));
            }
            for (int i2 = 0; i2 < this.dayBuckets_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.dayBuckets_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.lastTimestamp_;
            int iComputeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            int iComputeUInt32SizeNoTag = 0;
            for (int i2 = 0; i2 < this.deltas_.size(); i2++) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(this.deltas_.getInt(i2));
            }
            int iComputeMessageSize = iComputeInt64Size + iComputeUInt32SizeNoTag;
            if (!getDeltasList().isEmpty()) {
                iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeUInt32SizeNoTag);
            }
            this.deltasMemoizedSerializedSize = iComputeUInt32SizeNoTag;
            for (int i3 = 0; i3 < this.dayBuckets_.size(); i3++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.dayBuckets_.get(i3));
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Timestamps)) {
                return super.equals(obj);
            }
            Timestamps timestamps = (Timestamps) obj;
            return getLastTimestamp() == timestamps.getLastTimestamp() && getDeltasList().equals(timestamps.getDeltasList()) && getDayBucketsList().equals(timestamps.getDayBucketsList()) && this.unknownFields.equals(timestamps.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLastTimestamp());
            if (getDeltasCount() > 0) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getDeltasList().hashCode();
            }
            if (getDayBucketsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getDayBucketsList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static Timestamps parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Timestamps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Timestamps parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Timestamps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Timestamps parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Timestamps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Timestamps parseFrom(InputStream inputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Timestamps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Timestamps parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Timestamps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Timestamps parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Timestamps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Timestamps timestamps) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(timestamps);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimestampsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> dayBucketsBuilder_;
            private List<DayBucket> dayBuckets_;
            private Internal.IntList deltas_;
            private long lastTimestamp_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_Timestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_Timestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamps.class, Builder.class);
            }

            private Builder() {
                this.deltas_ = Timestamps.emptyIntList();
                this.dayBuckets_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.deltas_ = Timestamps.emptyIntList();
                this.dayBuckets_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Timestamps.alwaysUseFieldBuilders) {
                    getDayBucketsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lastTimestamp_ = 0L;
                this.deltas_ = Timestamps.emptyIntList();
                this.bitField0_ &= -2;
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dayBuckets_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_Timestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Timestamps getDefaultInstanceForType() {
                return Timestamps.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Timestamps build() {
                Timestamps timestampsBuildPartial = buildPartial();
                if (timestampsBuildPartial.isInitialized()) {
                    return timestampsBuildPartial;
                }
                throw newUninitializedMessageException((Message) timestampsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Timestamps buildPartial() {
                Timestamps timestamps = new Timestamps(this);
                timestamps.lastTimestamp_ = this.lastTimestamp_;
                if ((this.bitField0_ & 1) != 0) {
                    this.deltas_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                timestamps.deltas_ = this.deltas_;
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    timestamps.dayBuckets_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dayBuckets_ = Collections.unmodifiableList(this.dayBuckets_);
                        this.bitField0_ &= -3;
                    }
                    timestamps.dayBuckets_ = this.dayBuckets_;
                }
                onBuilt();
                return timestamps;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Timestamps) {
                    return mergeFrom((Timestamps) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Timestamps timestamps) {
                if (timestamps == Timestamps.getDefaultInstance()) {
                    return this;
                }
                if (timestamps.getLastTimestamp() != 0) {
                    setLastTimestamp(timestamps.getLastTimestamp());
                }
                if (!timestamps.deltas_.isEmpty()) {
                    if (this.deltas_.isEmpty()) {
                        this.deltas_ = timestamps.deltas_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDeltasIsMutable();
                        this.deltas_.addAll(timestamps.deltas_);
                    }
                    onChanged();
                }
                if (this.dayBucketsBuilder_ == null) {
                    if (!timestamps.dayBuckets_.isEmpty()) {
                        if (this.dayBuckets_.isEmpty()) {
                            this.dayBuckets_ = timestamps.dayBuckets_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDayBucketsIsMutable();
                            this.dayBuckets_.addAll(timestamps.dayBuckets_);
                        }
                        onChanged();
                    }
                } else if (!timestamps.dayBuckets_.isEmpty()) {
                    if (!this.dayBucketsBuilder_.isEmpty()) {
                        this.dayBucketsBuilder_.addAllMessages(timestamps.dayBuckets_);
                    } else {
                        this.dayBucketsBuilder_.dispose();
                        this.dayBucketsBuilder_ = null;
                        this.dayBuckets_ = timestamps.dayBuckets_;
                        this.bitField0_ &= -3;
                        this.dayBucketsBuilder_ = Timestamps.alwaysUseFieldBuilders ? getDayBucketsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(timestamps.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                Timestamps timestamps = null;
                try {
                    try {
                        Timestamps timestamps2 = (Timestamps) Timestamps.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (timestamps2 != null) {
                            mergeFrom(timestamps2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Timestamps timestamps3 = (Timestamps) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            timestamps = timestamps3;
                            if (timestamps != null) {
                                mergeFrom(timestamps);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (timestamps != null) {
                        mergeFrom(timestamps);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public long getLastTimestamp() {
                return this.lastTimestamp_;
            }

            public Builder setLastTimestamp(long j) {
                this.lastTimestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearLastTimestamp() {
                this.lastTimestamp_ = 0L;
                onChanged();
                return this;
            }

            private void ensureDeltasIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.deltas_ = Timestamps.mutableCopy(this.deltas_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public List<Integer> getDeltasList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.deltas_) : this.deltas_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public int getDeltasCount() {
                return this.deltas_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public int getDeltas(int i) {
                return this.deltas_.getInt(i);
            }

            public Builder setDeltas(int i, int i2) {
                ensureDeltasIsMutable();
                this.deltas_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addDeltas(int i) {
                ensureDeltasIsMutable();
                this.deltas_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllDeltas(Iterable<? extends Integer> iterable) {
                ensureDeltasIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.deltas_);
                onChanged();
                return this;
            }

            public Builder clearDeltas() {
                this.deltas_ = Timestamps.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureDayBucketsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dayBuckets_ = new ArrayList(this.dayBuckets_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public List<DayBucket> getDayBucketsList() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.dayBuckets_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public int getDayBucketsCount() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public DayBucket getDayBuckets(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.get(i);
                }
                return (DayBucket) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setDayBuckets(int i, DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.set(i, dayBucket);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, dayBucket);
                }
                return this;
            }

            public Builder setDayBuckets(int i, DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addDayBuckets(DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(dayBucket);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(dayBucket);
                }
                return this;
            }

            public Builder addDayBuckets(int i, DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(i, dayBucket);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, dayBucket);
                }
                return this;
            }

            public Builder addDayBuckets(DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addDayBuckets(int i, DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllDayBuckets(Iterable<? extends DayBucket> iterable) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.dayBuckets_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearDayBuckets() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dayBuckets_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeDayBuckets(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public DayBucket.Builder getDayBucketsBuilder(int i) {
                return (DayBucket.Builder) getDayBucketsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public DayBucketOrBuilder getDayBucketsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.get(i);
                }
                return (DayBucketOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.TimestampsOrBuilder
            public List<? extends DayBucketOrBuilder> getDayBucketsOrBuilderList() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dayBuckets_);
            }

            public DayBucket.Builder addDayBucketsBuilder() {
                return (DayBucket.Builder) getDayBucketsFieldBuilder().addBuilder(DayBucket.getDefaultInstance());
            }

            public DayBucket.Builder addDayBucketsBuilder(int i) {
                return (DayBucket.Builder) getDayBucketsFieldBuilder().addBuilder(i, DayBucket.getDefaultInstance());
            }

            public List<DayBucket.Builder> getDayBucketsBuilderList() {
                return getDayBucketsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> getDayBucketsFieldBuilder() {
                if (this.dayBucketsBuilder_ == null) {
                    this.dayBucketsBuilder_ = new RepeatedFieldBuilderV3<>(this.dayBuckets_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dayBuckets_ = null;
                }
                return this.dayBucketsBuilder_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static Timestamps getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Timestamps> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Timestamps> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Timestamps getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdDomainTimestamps extends GeneratedMessageV3 implements AdDomainTimestampsOrBuilder {
        public static final int AD_DOMAINS_FIELD_NUMBER = 1;
        private static final AdDomainTimestamps DEFAULT_INSTANCE = new AdDomainTimestamps();
        private static final Parser<AdDomainTimestamps> PARSER = new AbstractParser<AdDomainTimestamps>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestamps.1
            @Override // com.explorestack.protobuf.Parser
            public AdDomainTimestamps parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdDomainTimestamps(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private MapField<String, Timestamps> adDomains_;
        private byte memoizedIsInitialized;

        private AdDomainTimestamps(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdDomainTimestamps() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdDomainTimestamps();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private AdDomainTimestamps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!z2) {
                                    this.adDomains_ = MapField.newMapField(AdDomainsDefaultEntryHolder.defaultEntry);
                                    z2 = true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(AdDomainsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.adDomains_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 1) {
                return internalGetAdDomains();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(AdDomainTimestamps.class, Builder.class);
        }

        private static final class AdDomainsDefaultEntryHolder {
            static final MapEntry<String, Timestamps> defaultEntry = MapEntry.newDefaultInstance(SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Timestamps.getDefaultInstance());

            private AdDomainsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, Timestamps> internalGetAdDomains() {
            MapField<String, Timestamps> mapField = this.adDomains_;
            return mapField == null ? MapField.emptyMapField(AdDomainsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        public int getAdDomainsCount() {
            return internalGetAdDomains().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        public boolean containsAdDomains(String str) {
            str.getClass();
            return internalGetAdDomains().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        @Deprecated
        public Map<String, Timestamps> getAdDomains() {
            return getAdDomainsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        public Map<String, Timestamps> getAdDomainsMap() {
            return internalGetAdDomains().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        public Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps) {
            str.getClass();
            Map<String, Timestamps> map = internalGetAdDomains().getMap();
            return map.containsKey(str) ? map.get(str) : timestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
        public Timestamps getAdDomainsOrThrow(String str) {
            str.getClass();
            Map<String, Timestamps> map = internalGetAdDomains().getMap();
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return map.get(str);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetAdDomains(), AdDomainsDefaultEntryHolder.defaultEntry, 1);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (Map.Entry<String, Timestamps> entry : internalGetAdDomains().getMap().entrySet()) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, AdDomainsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdDomainTimestamps)) {
                return super.equals(obj);
            }
            AdDomainTimestamps adDomainTimestamps = (AdDomainTimestamps) obj;
            return internalGetAdDomains().equals(adDomainTimestamps.internalGetAdDomains()) && this.unknownFields.equals(adDomainTimestamps.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (!internalGetAdDomains().getMap().isEmpty()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + internalGetAdDomains().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static AdDomainTimestamps parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdDomainTimestamps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdDomainTimestamps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdDomainTimestamps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(InputStream inputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdDomainTimestamps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdDomainTimestamps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdDomainTimestamps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdDomainTimestamps adDomainTimestamps) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adDomainTimestamps);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdDomainTimestampsOrBuilder {
            private MapField<String, Timestamps> adDomains_;
            private int bitField0_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 1) {
                    return internalGetAdDomains();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 1) {
                    return internalGetMutableAdDomains();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(AdDomainTimestamps.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdDomainTimestamps.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                internalGetMutableAdDomains().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdDomainTimestamps getDefaultInstanceForType() {
                return AdDomainTimestamps.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdDomainTimestamps build() {
                AdDomainTimestamps adDomainTimestampsBuildPartial = buildPartial();
                if (adDomainTimestampsBuildPartial.isInitialized()) {
                    return adDomainTimestampsBuildPartial;
                }
                throw newUninitializedMessageException((Message) adDomainTimestampsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdDomainTimestamps buildPartial() {
                AdDomainTimestamps adDomainTimestamps = new AdDomainTimestamps(this);
                adDomainTimestamps.adDomains_ = internalGetAdDomains();
                adDomainTimestamps.adDomains_.makeImmutable();
                onBuilt();
                return adDomainTimestamps;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AdDomainTimestamps) {
                    return mergeFrom((AdDomainTimestamps) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdDomainTimestamps adDomainTimestamps) {
                if (adDomainTimestamps == AdDomainTimestamps.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableAdDomains().mergeFrom(adDomainTimestamps.internalGetAdDomains());
                mergeUnknownFields(adDomainTimestamps.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                AdDomainTimestamps adDomainTimestamps = null;
                try {
                    try {
                        AdDomainTimestamps adDomainTimestamps2 = (AdDomainTimestamps) AdDomainTimestamps.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adDomainTimestamps2 != null) {
                            mergeFrom(adDomainTimestamps2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdDomainTimestamps adDomainTimestamps3 = (AdDomainTimestamps) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adDomainTimestamps = adDomainTimestamps3;
                            if (adDomainTimestamps != null) {
                                mergeFrom(adDomainTimestamps);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adDomainTimestamps != null) {
                        mergeFrom(adDomainTimestamps);
                    }
                    throw th;
                }
            }

            private MapField<String, Timestamps> internalGetAdDomains() {
                MapField<String, Timestamps> mapField = this.adDomains_;
                return mapField == null ? MapField.emptyMapField(AdDomainsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<String, Timestamps> internalGetMutableAdDomains() {
                onChanged();
                if (this.adDomains_ == null) {
                    this.adDomains_ = MapField.newMapField(AdDomainsDefaultEntryHolder.defaultEntry);
                }
                if (!this.adDomains_.isMutable()) {
                    this.adDomains_ = this.adDomains_.copy();
                }
                return this.adDomains_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            public int getAdDomainsCount() {
                return internalGetAdDomains().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            public boolean containsAdDomains(String str) {
                str.getClass();
                return internalGetAdDomains().getMap().containsKey(str);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            @Deprecated
            public Map<String, Timestamps> getAdDomains() {
                return getAdDomainsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            public Map<String, Timestamps> getAdDomainsMap() {
                return internalGetAdDomains().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            public Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps) {
                str.getClass();
                Map<String, Timestamps> map = internalGetAdDomains().getMap();
                return map.containsKey(str) ? map.get(str) : timestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdDomainTimestampsOrBuilder
            public Timestamps getAdDomainsOrThrow(String str) {
                str.getClass();
                Map<String, Timestamps> map = internalGetAdDomains().getMap();
                if (!map.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return map.get(str);
            }

            public Builder clearAdDomains() {
                internalGetMutableAdDomains().getMutableMap().clear();
                return this;
            }

            public Builder removeAdDomains(String str) {
                str.getClass();
                internalGetMutableAdDomains().getMutableMap().remove(str);
                return this;
            }

            @Deprecated
            public Map<String, Timestamps> getMutableAdDomains() {
                return internalGetMutableAdDomains().getMutableMap();
            }

            public Builder putAdDomains(String str, Timestamps timestamps) {
                str.getClass();
                timestamps.getClass();
                internalGetMutableAdDomains().getMutableMap().put(str, timestamps);
                return this;
            }

            public Builder putAllAdDomains(Map<String, Timestamps> map) {
                internalGetMutableAdDomains().getMutableMap().putAll(map);
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AdDomainTimestamps getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdDomainTimestamps> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdDomainTimestamps> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdDomainTimestamps getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class WindowMetrics extends GeneratedMessageV3 implements WindowMetricsOrBuilder {
        public static final int LAST_1D_FIELD_NUMBER = 2;
        public static final int LAST_1H_FIELD_NUMBER = 1;
        public static final int LAST_7D_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int last1D_;
        private int last1H_;
        private int last7D_;
        private byte memoizedIsInitialized;
        private static final WindowMetrics DEFAULT_INSTANCE = new WindowMetrics();
        private static final Parser<WindowMetrics> PARSER = new AbstractParser<WindowMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public WindowMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WindowMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        private WindowMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WindowMetrics() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WindowMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WindowMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.last1H_ = codedInputStream.readInt32();
                            } else if (tag == 16) {
                                this.last1D_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                this.last7D_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_WindowMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(WindowMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
        public int getLast1H() {
            return this.last1H_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
        public int getLast1D() {
            return this.last1D_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
        public int getLast7D() {
            return this.last7D_;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.last1H_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.last1D_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.last7D_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.last1H_;
            int iComputeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.last1D_;
            if (i3 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.last7D_;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WindowMetrics)) {
                return super.equals(obj);
            }
            WindowMetrics windowMetrics = (WindowMetrics) obj;
            return getLast1H() == windowMetrics.getLast1H() && getLast1D() == windowMetrics.getLast1D() && getLast7D() == windowMetrics.getLast7D() && this.unknownFields.equals(windowMetrics.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLast1H()) * 37) + 2) * 53) + getLast1D()) * 37) + 3) * 53) + getLast7D()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static WindowMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WindowMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WindowMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WindowMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(InputStream inputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WindowMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WindowMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WindowMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WindowMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WindowMetrics windowMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(windowMetrics);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WindowMetricsOrBuilder {
            private int last1D_;
            private int last1H_;
            private int last7D_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_WindowMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(WindowMetrics.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WindowMetrics.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.last1H_ = 0;
                this.last1D_ = 0;
                this.last7D_ = 0;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_WindowMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public WindowMetrics getDefaultInstanceForType() {
                return WindowMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public WindowMetrics build() {
                WindowMetrics windowMetricsBuildPartial = buildPartial();
                if (windowMetricsBuildPartial.isInitialized()) {
                    return windowMetricsBuildPartial;
                }
                throw newUninitializedMessageException((Message) windowMetricsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public WindowMetrics buildPartial() {
                WindowMetrics windowMetrics = new WindowMetrics(this);
                windowMetrics.last1H_ = this.last1H_;
                windowMetrics.last1D_ = this.last1D_;
                windowMetrics.last7D_ = this.last7D_;
                onBuilt();
                return windowMetrics;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof WindowMetrics) {
                    return mergeFrom((WindowMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WindowMetrics windowMetrics) {
                if (windowMetrics == WindowMetrics.getDefaultInstance()) {
                    return this;
                }
                if (windowMetrics.getLast1H() != 0) {
                    setLast1H(windowMetrics.getLast1H());
                }
                if (windowMetrics.getLast1D() != 0) {
                    setLast1D(windowMetrics.getLast1D());
                }
                if (windowMetrics.getLast7D() != 0) {
                    setLast7D(windowMetrics.getLast7D());
                }
                mergeUnknownFields(windowMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                WindowMetrics windowMetrics = null;
                try {
                    try {
                        WindowMetrics windowMetrics2 = (WindowMetrics) WindowMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (windowMetrics2 != null) {
                            mergeFrom(windowMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        WindowMetrics windowMetrics3 = (WindowMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            windowMetrics = windowMetrics3;
                            if (windowMetrics != null) {
                                mergeFrom(windowMetrics);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (windowMetrics != null) {
                        mergeFrom(windowMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
            public int getLast1H() {
                return this.last1H_;
            }

            public Builder setLast1H(int i) {
                this.last1H_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast1H() {
                this.last1H_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
            public int getLast1D() {
                return this.last1D_;
            }

            public Builder setLast1D(int i) {
                this.last1D_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast1D() {
                this.last1D_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.WindowMetricsOrBuilder
            public int getLast7D() {
                return this.last7D_;
            }

            public Builder setLast7D(int i) {
                this.last7D_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast7D() {
                this.last7D_ = 0;
                onChanged();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static WindowMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WindowMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<WindowMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public WindowMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class ImpressionMetrics extends GeneratedMessageV3 implements ImpressionMetricsOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 1;
        public static final int DOMAINS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int adType_;
        private List<DomainMetrics> domains_;
        private byte memoizedIsInitialized;
        private static final ImpressionMetrics DEFAULT_INSTANCE = new ImpressionMetrics();
        private static final Parser<ImpressionMetrics> PARSER = new AbstractParser<ImpressionMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public ImpressionMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ImpressionMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        public interface DomainMetricsOrBuilder extends MessageOrBuilder {
            String getDomain();

            ByteString getDomainBytes();

            WindowMetrics getWindowMetrics();

            WindowMetricsOrBuilder getWindowMetricsOrBuilder();

            boolean hasWindowMetrics();
        }

        private ImpressionMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ImpressionMetrics() {
            this.memoizedIsInitialized = (byte) -1;
            this.adType_ = 0;
            this.domains_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ImpressionMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ImpressionMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.adType_ = codedInputStream.readEnum();
                            } else if (tag == 18) {
                                if (!z2) {
                                    this.domains_ = new ArrayList();
                                    z2 = true;
                                }
                                this.domains_.add((DomainMetrics) codedInputStream.readMessage(DomainMetrics.parser(), extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2) {
                        this.domains_ = Collections.unmodifiableList(this.domains_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.domains_ = Collections.unmodifiableList(this.domains_);
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(ImpressionMetrics.class, Builder.class);
        }

        public static final class DomainMetrics extends GeneratedMessageV3 implements DomainMetricsOrBuilder {
            public static final int DOMAIN_FIELD_NUMBER = 1;
            public static final int WINDOW_METRICS_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private volatile Object domain_;
            private byte memoizedIsInitialized;
            private WindowMetrics windowMetrics_;
            private static final DomainMetrics DEFAULT_INSTANCE = new DomainMetrics();
            private static final Parser<DomainMetrics> PARSER = new AbstractParser<DomainMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetrics.1
                @Override // com.explorestack.protobuf.Parser
                public DomainMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new DomainMetrics(codedInputStream, extensionRegistryLite);
                }
            };

            private DomainMetrics(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private DomainMetrics() {
                this.memoizedIsInitialized = (byte) -1;
                this.domain_ = "";
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new DomainMetrics();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DomainMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.domain_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    WindowMetrics windowMetrics = this.windowMetrics_;
                                    WindowMetrics.Builder builder = windowMetrics != null ? windowMetrics.toBuilder() : null;
                                    WindowMetrics windowMetrics2 = (WindowMetrics) codedInputStream.readMessage(WindowMetrics.parser(), extensionRegistryLite);
                                    this.windowMetrics_ = windowMetrics2;
                                    if (builder != null) {
                                        builder.mergeFrom(windowMetrics2);
                                        this.windowMetrics_ = builder.buildPartial();
                                    }
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        this.unknownFields = builderNewBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(DomainMetrics.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
            public String getDomain() {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.domain_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
            public ByteString getDomainBytes() {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.domain_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
            public boolean hasWindowMetrics() {
                return this.windowMetrics_ != null;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
            public WindowMetrics getWindowMetrics() {
                WindowMetrics windowMetrics = this.windowMetrics_;
                return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
            public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                return getWindowMetrics();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if (!getDomainBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.domain_);
                }
                if (this.windowMetrics_ != null) {
                    codedOutputStream.writeMessage(2, getWindowMetrics());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = !getDomainBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.domain_) : 0;
                if (this.windowMetrics_ != null) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(2, getWindowMetrics());
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DomainMetrics)) {
                    return super.equals(obj);
                }
                DomainMetrics domainMetrics = (DomainMetrics) obj;
                if (getDomain().equals(domainMetrics.getDomain()) && hasWindowMetrics() == domainMetrics.hasWindowMetrics()) {
                    return (!hasWindowMetrics() || getWindowMetrics().equals(domainMetrics.getWindowMetrics())) && this.unknownFields.equals(domainMetrics.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDomain().hashCode();
                if (hasWindowMetrics()) {
                    iHashCode = (((iHashCode * 37) + 2) * 53) + getWindowMetrics().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
            }

            public static DomainMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static DomainMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static DomainMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static DomainMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(InputStream inputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static DomainMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DomainMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static DomainMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static DomainMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DomainMetrics domainMetrics) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(domainMetrics);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.explorestack.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent);
            }

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DomainMetricsOrBuilder {
                private Object domain_;
                private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> windowMetricsBuilder_;
                private WindowMetrics windowMetrics_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(DomainMetrics.class, Builder.class);
                }

                private Builder() {
                    this.domain_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.domain_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = DomainMetrics.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.domain_ = "";
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetrics_ = null;
                    } else {
                        this.windowMetrics_ = null;
                        this.windowMetricsBuilder_ = null;
                    }
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public DomainMetrics getDefaultInstanceForType() {
                    return DomainMetrics.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DomainMetrics build() {
                    DomainMetrics domainMetricsBuildPartial = buildPartial();
                    if (domainMetricsBuildPartial.isInitialized()) {
                        return domainMetricsBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) domainMetricsBuildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DomainMetrics buildPartial() {
                    DomainMetrics domainMetrics = new DomainMetrics(this);
                    domainMetrics.domain_ = this.domain_;
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        domainMetrics.windowMetrics_ = this.windowMetrics_;
                    } else {
                        domainMetrics.windowMetrics_ = (WindowMetrics) singleFieldBuilderV3.build();
                    }
                    onBuilt();
                    return domainMetrics;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public Builder mo4742clone() {
                    return (Builder) super.mo4742clone();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.setField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                    return (Builder) super.clearOneof(oneofDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                    return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof DomainMetrics) {
                        return mergeFrom((DomainMetrics) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(DomainMetrics domainMetrics) {
                    if (domainMetrics == DomainMetrics.getDefaultInstance()) {
                        return this;
                    }
                    if (!domainMetrics.getDomain().isEmpty()) {
                        this.domain_ = domainMetrics.domain_;
                        onChanged();
                    }
                    if (domainMetrics.hasWindowMetrics()) {
                        mergeWindowMetrics(domainMetrics.getWindowMetrics());
                    }
                    mergeUnknownFields(domainMetrics.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    DomainMetrics domainMetrics = null;
                    try {
                        try {
                            DomainMetrics domainMetrics2 = (DomainMetrics) DomainMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (domainMetrics2 != null) {
                                mergeFrom(domainMetrics2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            DomainMetrics domainMetrics3 = (DomainMetrics) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                domainMetrics = domainMetrics3;
                                if (domainMetrics != null) {
                                    mergeFrom(domainMetrics);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (domainMetrics != null) {
                            mergeFrom(domainMetrics);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
                public String getDomain() {
                    Object obj = this.domain_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.domain_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
                public ByteString getDomainBytes() {
                    Object obj = this.domain_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.domain_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setDomain(String str) {
                    str.getClass();
                    this.domain_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearDomain() {
                    this.domain_ = DomainMetrics.getDefaultInstance().getDomain();
                    onChanged();
                    return this;
                }

                public Builder setDomainBytes(ByteString byteString) {
                    byteString.getClass();
                    DomainMetrics.checkByteStringIsUtf8(byteString);
                    this.domain_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
                public boolean hasWindowMetrics() {
                    return (this.windowMetricsBuilder_ == null && this.windowMetrics_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
                public WindowMetrics getWindowMetrics() {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        WindowMetrics windowMetrics = this.windowMetrics_;
                        return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                    }
                    return (WindowMetrics) singleFieldBuilderV3.getMessage();
                }

                public Builder setWindowMetrics(WindowMetrics windowMetrics) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        windowMetrics.getClass();
                        this.windowMetrics_ = windowMetrics;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(windowMetrics);
                    }
                    return this;
                }

                public Builder setWindowMetrics(WindowMetrics.Builder builder) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.windowMetrics_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeWindowMetrics(WindowMetrics windowMetrics) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        WindowMetrics windowMetrics2 = this.windowMetrics_;
                        if (windowMetrics2 != null) {
                            this.windowMetrics_ = WindowMetrics.newBuilder(windowMetrics2).mergeFrom(windowMetrics).buildPartial();
                        } else {
                            this.windowMetrics_ = windowMetrics;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(windowMetrics);
                    }
                    return this;
                }

                public Builder clearWindowMetrics() {
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetrics_ = null;
                        onChanged();
                    } else {
                        this.windowMetrics_ = null;
                        this.windowMetricsBuilder_ = null;
                    }
                    return this;
                }

                public WindowMetrics.Builder getWindowMetricsBuilder() {
                    onChanged();
                    return (WindowMetrics.Builder) getWindowMetricsFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetrics.DomainMetricsOrBuilder
                public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (WindowMetricsOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    WindowMetrics windowMetrics = this.windowMetrics_;
                    return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                }

                private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> getWindowMetricsFieldBuilder() {
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetricsBuilder_ = new SingleFieldBuilderV3<>(getWindowMetrics(), getParentForChildren(), isClean());
                        this.windowMetrics_ = null;
                    }
                    return this.windowMetricsBuilder_;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.setUnknownFields(unknownFieldSet);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.mergeUnknownFields(unknownFieldSet);
                }
            }

            public static DomainMetrics getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DomainMetrics> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<DomainMetrics> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public DomainMetrics getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public AdType getAdType() {
            AdType adTypeValueOf = AdType.valueOf(this.adType_);
            return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public List<DomainMetrics> getDomainsList() {
            return this.domains_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public List<? extends DomainMetricsOrBuilder> getDomainsOrBuilderList() {
            return this.domains_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public int getDomainsCount() {
            return this.domains_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public DomainMetrics getDomains(int i) {
            return this.domains_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
        public DomainMetricsOrBuilder getDomainsOrBuilder(int i) {
            return this.domains_.get(i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.adType_);
            }
            for (int i = 0; i < this.domains_.size(); i++) {
                codedOutputStream.writeMessage(2, this.domains_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = this.adType_ != AdType.UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.adType_) : 0;
            for (int i2 = 0; i2 < this.domains_.size(); i2++) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.domains_.get(i2));
            }
            int serializedSize = iComputeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImpressionMetrics)) {
                return super.equals(obj);
            }
            ImpressionMetrics impressionMetrics = (ImpressionMetrics) obj;
            return this.adType_ == impressionMetrics.adType_ && getDomainsList().equals(impressionMetrics.getDomainsList()) && this.unknownFields.equals(impressionMetrics.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.adType_;
            if (getDomainsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getDomainsList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static ImpressionMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ImpressionMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ImpressionMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ImpressionMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(InputStream inputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ImpressionMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImpressionMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImpressionMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ImpressionMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ImpressionMetrics impressionMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(impressionMetrics);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ImpressionMetricsOrBuilder {
            private int adType_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> domainsBuilder_;
            private List<DomainMetrics> domains_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(ImpressionMetrics.class, Builder.class);
            }

            private Builder() {
                this.adType_ = 0;
                this.domains_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.adType_ = 0;
                this.domains_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ImpressionMetrics.alwaysUseFieldBuilders) {
                    getDomainsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.adType_ = 0;
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.domains_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public ImpressionMetrics getDefaultInstanceForType() {
                return ImpressionMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ImpressionMetrics build() {
                ImpressionMetrics impressionMetricsBuildPartial = buildPartial();
                if (impressionMetricsBuildPartial.isInitialized()) {
                    return impressionMetricsBuildPartial;
                }
                throw newUninitializedMessageException((Message) impressionMetricsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ImpressionMetrics buildPartial() {
                ImpressionMetrics impressionMetrics = new ImpressionMetrics(this);
                impressionMetrics.adType_ = this.adType_;
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    impressionMetrics.domains_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.domains_ = Collections.unmodifiableList(this.domains_);
                        this.bitField0_ &= -2;
                    }
                    impressionMetrics.domains_ = this.domains_;
                }
                onBuilt();
                return impressionMetrics;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ImpressionMetrics) {
                    return mergeFrom((ImpressionMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ImpressionMetrics impressionMetrics) {
                if (impressionMetrics == ImpressionMetrics.getDefaultInstance()) {
                    return this;
                }
                if (impressionMetrics.adType_ != 0) {
                    setAdTypeValue(impressionMetrics.getAdTypeValue());
                }
                if (this.domainsBuilder_ == null) {
                    if (!impressionMetrics.domains_.isEmpty()) {
                        if (this.domains_.isEmpty()) {
                            this.domains_ = impressionMetrics.domains_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDomainsIsMutable();
                            this.domains_.addAll(impressionMetrics.domains_);
                        }
                        onChanged();
                    }
                } else if (!impressionMetrics.domains_.isEmpty()) {
                    if (!this.domainsBuilder_.isEmpty()) {
                        this.domainsBuilder_.addAllMessages(impressionMetrics.domains_);
                    } else {
                        this.domainsBuilder_.dispose();
                        this.domainsBuilder_ = null;
                        this.domains_ = impressionMetrics.domains_;
                        this.bitField0_ &= -2;
                        this.domainsBuilder_ = ImpressionMetrics.alwaysUseFieldBuilders ? getDomainsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(impressionMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                ImpressionMetrics impressionMetrics = null;
                try {
                    try {
                        ImpressionMetrics impressionMetrics2 = (ImpressionMetrics) ImpressionMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (impressionMetrics2 != null) {
                            mergeFrom(impressionMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        ImpressionMetrics impressionMetrics3 = (ImpressionMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            impressionMetrics = impressionMetrics3;
                            if (impressionMetrics != null) {
                                mergeFrom(impressionMetrics);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (impressionMetrics != null) {
                        mergeFrom(impressionMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public AdType getAdType() {
                AdType adTypeValueOf = AdType.valueOf(this.adType_);
                return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            private void ensureDomainsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.domains_ = new ArrayList(this.domains_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public List<DomainMetrics> getDomainsList() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.domains_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public int getDomainsCount() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public DomainMetrics getDomains(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.get(i);
                }
                return (DomainMetrics) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setDomains(int i, DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.set(i, domainMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, domainMetrics);
                }
                return this;
            }

            public Builder setDomains(int i, DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addDomains(DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.add(domainMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(domainMetrics);
                }
                return this;
            }

            public Builder addDomains(int i, DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.add(i, domainMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, domainMetrics);
                }
                return this;
            }

            public Builder addDomains(DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addDomains(int i, DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllDomains(Iterable<? extends DomainMetrics> iterable) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.domains_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearDomains() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.domains_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeDomains(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public DomainMetrics.Builder getDomainsBuilder(int i) {
                return (DomainMetrics.Builder) getDomainsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public DomainMetricsOrBuilder getDomainsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.get(i);
                }
                return (DomainMetricsOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.ImpressionMetricsOrBuilder
            public List<? extends DomainMetricsOrBuilder> getDomainsOrBuilderList() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.domains_);
            }

            public DomainMetrics.Builder addDomainsBuilder() {
                return (DomainMetrics.Builder) getDomainsFieldBuilder().addBuilder(DomainMetrics.getDefaultInstance());
            }

            public DomainMetrics.Builder addDomainsBuilder(int i) {
                return (DomainMetrics.Builder) getDomainsFieldBuilder().addBuilder(i, DomainMetrics.getDefaultInstance());
            }

            public List<DomainMetrics.Builder> getDomainsBuilderList() {
                return getDomainsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> getDomainsFieldBuilder() {
                if (this.domainsBuilder_ == null) {
                    this.domainsBuilder_ = new RepeatedFieldBuilderV3<>(this.domains_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.domains_ = null;
                }
                return this.domainsBuilder_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static ImpressionMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImpressionMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<ImpressionMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public ImpressionMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdRequestMetrics extends GeneratedMessageV3 implements AdRequestMetricsOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 1;
        private static final AdRequestMetrics DEFAULT_INSTANCE = new AdRequestMetrics();
        private static final Parser<AdRequestMetrics> PARSER = new AbstractParser<AdRequestMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public AdRequestMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdRequestMetrics(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int WINDOW_METRICS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int adType_;
        private byte memoizedIsInitialized;
        private WindowMetrics windowMetrics_;

        private AdRequestMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdRequestMetrics() {
            this.memoizedIsInitialized = (byte) -1;
            this.adType_ = 0;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdRequestMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AdRequestMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.adType_ = codedInputStream.readEnum();
                            } else if (tag == 18) {
                                WindowMetrics windowMetrics = this.windowMetrics_;
                                WindowMetrics.Builder builder = windowMetrics != null ? windowMetrics.toBuilder() : null;
                                WindowMetrics windowMetrics2 = (WindowMetrics) codedInputStream.readMessage(WindowMetrics.parser(), extensionRegistryLite);
                                this.windowMetrics_ = windowMetrics2;
                                if (builder != null) {
                                    builder.mergeFrom(windowMetrics2);
                                    this.windowMetrics_ = builder.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequestMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
        public AdType getAdType() {
            AdType adTypeValueOf = AdType.valueOf(this.adType_);
            return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
        public boolean hasWindowMetrics() {
            return this.windowMetrics_ != null;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
        public WindowMetrics getWindowMetrics() {
            WindowMetrics windowMetrics = this.windowMetrics_;
            return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
        public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
            return getWindowMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.adType_);
            }
            if (this.windowMetrics_ != null) {
                codedOutputStream.writeMessage(2, getWindowMetrics());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = this.adType_ != AdType.UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.adType_) : 0;
            if (this.windowMetrics_ != null) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(2, getWindowMetrics());
            }
            int serializedSize = iComputeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdRequestMetrics)) {
                return super.equals(obj);
            }
            AdRequestMetrics adRequestMetrics = (AdRequestMetrics) obj;
            if (this.adType_ == adRequestMetrics.adType_ && hasWindowMetrics() == adRequestMetrics.hasWindowMetrics()) {
                return (!hasWindowMetrics() || getWindowMetrics().equals(adRequestMetrics.getWindowMetrics())) && this.unknownFields.equals(adRequestMetrics.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.adType_;
            if (hasWindowMetrics()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getWindowMetrics().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static AdRequestMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdRequestMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdRequestMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdRequestMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(InputStream inputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdRequestMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequestMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdRequestMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdRequestMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdRequestMetrics adRequestMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adRequestMetrics);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdRequestMetricsOrBuilder {
            private int adType_;
            private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> windowMetricsBuilder_;
            private WindowMetrics windowMetrics_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequestMetrics.class, Builder.class);
            }

            private Builder() {
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdRequestMetrics.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.adType_ = 0;
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetrics_ = null;
                } else {
                    this.windowMetrics_ = null;
                    this.windowMetricsBuilder_ = null;
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdRequestMetrics getDefaultInstanceForType() {
                return AdRequestMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequestMetrics build() {
                AdRequestMetrics adRequestMetricsBuildPartial = buildPartial();
                if (adRequestMetricsBuildPartial.isInitialized()) {
                    return adRequestMetricsBuildPartial;
                }
                throw newUninitializedMessageException((Message) adRequestMetricsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequestMetrics buildPartial() {
                AdRequestMetrics adRequestMetrics = new AdRequestMetrics(this);
                adRequestMetrics.adType_ = this.adType_;
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    adRequestMetrics.windowMetrics_ = this.windowMetrics_;
                } else {
                    adRequestMetrics.windowMetrics_ = (WindowMetrics) singleFieldBuilderV3.build();
                }
                onBuilt();
                return adRequestMetrics;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AdRequestMetrics) {
                    return mergeFrom((AdRequestMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdRequestMetrics adRequestMetrics) {
                if (adRequestMetrics == AdRequestMetrics.getDefaultInstance()) {
                    return this;
                }
                if (adRequestMetrics.adType_ != 0) {
                    setAdTypeValue(adRequestMetrics.getAdTypeValue());
                }
                if (adRequestMetrics.hasWindowMetrics()) {
                    mergeWindowMetrics(adRequestMetrics.getWindowMetrics());
                }
                mergeUnknownFields(adRequestMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                AdRequestMetrics adRequestMetrics = null;
                try {
                    try {
                        AdRequestMetrics adRequestMetrics2 = (AdRequestMetrics) AdRequestMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adRequestMetrics2 != null) {
                            mergeFrom(adRequestMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdRequestMetrics adRequestMetrics3 = (AdRequestMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adRequestMetrics = adRequestMetrics3;
                            if (adRequestMetrics != null) {
                                mergeFrom(adRequestMetrics);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adRequestMetrics != null) {
                        mergeFrom(adRequestMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
            public AdType getAdType() {
                AdType adTypeValueOf = AdType.valueOf(this.adType_);
                return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
            public boolean hasWindowMetrics() {
                return (this.windowMetricsBuilder_ == null && this.windowMetrics_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
            public WindowMetrics getWindowMetrics() {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    WindowMetrics windowMetrics = this.windowMetrics_;
                    return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                }
                return (WindowMetrics) singleFieldBuilderV3.getMessage();
            }

            public Builder setWindowMetrics(WindowMetrics windowMetrics) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    windowMetrics.getClass();
                    this.windowMetrics_ = windowMetrics;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(windowMetrics);
                }
                return this;
            }

            public Builder setWindowMetrics(WindowMetrics.Builder builder) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.windowMetrics_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeWindowMetrics(WindowMetrics windowMetrics) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    WindowMetrics windowMetrics2 = this.windowMetrics_;
                    if (windowMetrics2 != null) {
                        this.windowMetrics_ = WindowMetrics.newBuilder(windowMetrics2).mergeFrom(windowMetrics).buildPartial();
                    } else {
                        this.windowMetrics_ = windowMetrics;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(windowMetrics);
                }
                return this;
            }

            public Builder clearWindowMetrics() {
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetrics_ = null;
                    onChanged();
                } else {
                    this.windowMetrics_ = null;
                    this.windowMetricsBuilder_ = null;
                }
                return this;
            }

            public WindowMetrics.Builder getWindowMetricsBuilder() {
                onChanged();
                return (WindowMetrics.Builder) getWindowMetricsFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestMetricsOrBuilder
            public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (WindowMetricsOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                WindowMetrics windowMetrics = this.windowMetrics_;
                return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
            }

            private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> getWindowMetricsFieldBuilder() {
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetricsBuilder_ = new SingleFieldBuilderV3<>(getWindowMetrics(), getParentForChildren(), isClean());
                    this.windowMetrics_ = null;
                }
                return this.windowMetricsBuilder_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AdRequestMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdRequestMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdRequestMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdRequestMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class SessionMetrics extends GeneratedMessageV3 implements SessionMetricsOrBuilder {
        public static final int AD_REQUESTS_FIELD_NUMBER = 2;
        public static final int IMPRESSIONS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<AdRequestMetrics> adRequests_;
        private List<ImpressionMetrics> impressions_;
        private byte memoizedIsInitialized;
        private static final SessionMetrics DEFAULT_INSTANCE = new SessionMetrics();
        private static final Parser<SessionMetrics> PARSER = new AbstractParser<SessionMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public SessionMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SessionMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        private SessionMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SessionMetrics() {
            this.memoizedIsInitialized = (byte) -1;
            this.impressions_ = Collections.emptyList();
            this.adRequests_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new SessionMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SessionMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if ((i & 1) == 0) {
                                    this.impressions_ = new ArrayList();
                                    i |= 1;
                                }
                                this.impressions_.add((ImpressionMetrics) codedInputStream.readMessage(ImpressionMetrics.parser(), extensionRegistryLite));
                            } else if (tag == 18) {
                                if ((i & 2) == 0) {
                                    this.adRequests_ = new ArrayList();
                                    i |= 2;
                                }
                                this.adRequests_.add((AdRequestMetrics) codedInputStream.readMessage(AdRequestMetrics.parser(), extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i & 1) != 0) {
                        this.impressions_ = Collections.unmodifiableList(this.impressions_);
                    }
                    if ((i & 2) != 0) {
                        this.adRequests_ = Collections.unmodifiableList(this.adRequests_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if ((i & 1) != 0) {
                this.impressions_ = Collections.unmodifiableList(this.impressions_);
            }
            if ((i & 2) != 0) {
                this.adRequests_ = Collections.unmodifiableList(this.adRequests_);
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_SessionMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public List<ImpressionMetrics> getImpressionsList() {
            return this.impressions_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList() {
            return this.impressions_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public int getImpressionsCount() {
            return this.impressions_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public ImpressionMetrics getImpressions(int i) {
            return this.impressions_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i) {
            return this.impressions_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public List<AdRequestMetrics> getAdRequestsList() {
            return this.adRequests_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList() {
            return this.adRequests_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public int getAdRequestsCount() {
            return this.adRequests_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public AdRequestMetrics getAdRequests(int i) {
            return this.adRequests_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
        public AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i) {
            return this.adRequests_.get(i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.impressions_.size(); i++) {
                codedOutputStream.writeMessage(1, this.impressions_.get(i));
            }
            for (int i2 = 0; i2 < this.adRequests_.size(); i2++) {
                codedOutputStream.writeMessage(2, this.adRequests_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.impressions_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.impressions_.get(i2));
            }
            for (int i3 = 0; i3 < this.adRequests_.size(); i3++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.adRequests_.get(i3));
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SessionMetrics)) {
                return super.equals(obj);
            }
            SessionMetrics sessionMetrics = (SessionMetrics) obj;
            return getImpressionsList().equals(sessionMetrics.getImpressionsList()) && getAdRequestsList().equals(sessionMetrics.getAdRequestsList()) && this.unknownFields.equals(sessionMetrics.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (getImpressionsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getImpressionsList().hashCode();
            }
            if (getAdRequestsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getAdRequestsList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static SessionMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SessionMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SessionMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SessionMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(InputStream inputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SessionMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SessionMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SessionMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SessionMetrics sessionMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sessionMetrics);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionMetricsOrBuilder {
            private RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> adRequestsBuilder_;
            private List<AdRequestMetrics> adRequests_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> impressionsBuilder_;
            private List<ImpressionMetrics> impressions_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_SessionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionMetrics.class, Builder.class);
            }

            private Builder() {
                this.impressions_ = Collections.emptyList();
                this.adRequests_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.impressions_ = Collections.emptyList();
                this.adRequests_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SessionMetrics.alwaysUseFieldBuilders) {
                    getImpressionsFieldBuilder();
                    getAdRequestsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.impressions_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV4 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV4 == null) {
                    this.adRequests_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV4.clear();
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_SessionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public SessionMetrics getDefaultInstanceForType() {
                return SessionMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionMetrics build() {
                SessionMetrics sessionMetricsBuildPartial = buildPartial();
                if (sessionMetricsBuildPartial.isInitialized()) {
                    return sessionMetricsBuildPartial;
                }
                throw newUninitializedMessageException((Message) sessionMetricsBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionMetrics buildPartial() {
                SessionMetrics sessionMetrics = new SessionMetrics(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.impressions_ = Collections.unmodifiableList(this.impressions_);
                        this.bitField0_ &= -2;
                    }
                    sessionMetrics.impressions_ = this.impressions_;
                } else {
                    sessionMetrics.impressions_ = repeatedFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV4 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV4 != null) {
                    sessionMetrics.adRequests_ = repeatedFieldBuilderV4.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.adRequests_ = Collections.unmodifiableList(this.adRequests_);
                        this.bitField0_ &= -3;
                    }
                    sessionMetrics.adRequests_ = this.adRequests_;
                }
                onBuilt();
                return sessionMetrics;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SessionMetrics) {
                    return mergeFrom((SessionMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SessionMetrics sessionMetrics) {
                if (sessionMetrics == SessionMetrics.getDefaultInstance()) {
                    return this;
                }
                if (this.impressionsBuilder_ == null) {
                    if (!sessionMetrics.impressions_.isEmpty()) {
                        if (this.impressions_.isEmpty()) {
                            this.impressions_ = sessionMetrics.impressions_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureImpressionsIsMutable();
                            this.impressions_.addAll(sessionMetrics.impressions_);
                        }
                        onChanged();
                    }
                } else if (!sessionMetrics.impressions_.isEmpty()) {
                    if (!this.impressionsBuilder_.isEmpty()) {
                        this.impressionsBuilder_.addAllMessages(sessionMetrics.impressions_);
                    } else {
                        this.impressionsBuilder_.dispose();
                        this.impressionsBuilder_ = null;
                        this.impressions_ = sessionMetrics.impressions_;
                        this.bitField0_ &= -2;
                        this.impressionsBuilder_ = SessionMetrics.alwaysUseFieldBuilders ? getImpressionsFieldBuilder() : null;
                    }
                }
                if (this.adRequestsBuilder_ == null) {
                    if (!sessionMetrics.adRequests_.isEmpty()) {
                        if (this.adRequests_.isEmpty()) {
                            this.adRequests_ = sessionMetrics.adRequests_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAdRequestsIsMutable();
                            this.adRequests_.addAll(sessionMetrics.adRequests_);
                        }
                        onChanged();
                    }
                } else if (!sessionMetrics.adRequests_.isEmpty()) {
                    if (!this.adRequestsBuilder_.isEmpty()) {
                        this.adRequestsBuilder_.addAllMessages(sessionMetrics.adRequests_);
                    } else {
                        this.adRequestsBuilder_.dispose();
                        this.adRequestsBuilder_ = null;
                        this.adRequests_ = sessionMetrics.adRequests_;
                        this.bitField0_ &= -3;
                        this.adRequestsBuilder_ = SessionMetrics.alwaysUseFieldBuilders ? getAdRequestsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(sessionMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                SessionMetrics sessionMetrics = null;
                try {
                    try {
                        SessionMetrics sessionMetrics2 = (SessionMetrics) SessionMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (sessionMetrics2 != null) {
                            mergeFrom(sessionMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        SessionMetrics sessionMetrics3 = (SessionMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            sessionMetrics = sessionMetrics3;
                            if (sessionMetrics != null) {
                                mergeFrom(sessionMetrics);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sessionMetrics != null) {
                        mergeFrom(sessionMetrics);
                    }
                    throw th;
                }
            }

            private void ensureImpressionsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.impressions_ = new ArrayList(this.impressions_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public List<ImpressionMetrics> getImpressionsList() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.impressions_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public int getImpressionsCount() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public ImpressionMetrics getImpressions(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.get(i);
                }
                return (ImpressionMetrics) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setImpressions(int i, ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.set(i, impressionMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, impressionMetrics);
                }
                return this;
            }

            public Builder setImpressions(int i, ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addImpressions(ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.add(impressionMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(impressionMetrics);
                }
                return this;
            }

            public Builder addImpressions(int i, ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.add(i, impressionMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, impressionMetrics);
                }
                return this;
            }

            public Builder addImpressions(ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addImpressions(int i, ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllImpressions(Iterable<? extends ImpressionMetrics> iterable) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.impressions_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearImpressions() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.impressions_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeImpressions(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public ImpressionMetrics.Builder getImpressionsBuilder(int i) {
                return (ImpressionMetrics.Builder) getImpressionsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.get(i);
                }
                return (ImpressionMetricsOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.impressions_);
            }

            public ImpressionMetrics.Builder addImpressionsBuilder() {
                return (ImpressionMetrics.Builder) getImpressionsFieldBuilder().addBuilder(ImpressionMetrics.getDefaultInstance());
            }

            public ImpressionMetrics.Builder addImpressionsBuilder(int i) {
                return (ImpressionMetrics.Builder) getImpressionsFieldBuilder().addBuilder(i, ImpressionMetrics.getDefaultInstance());
            }

            public List<ImpressionMetrics.Builder> getImpressionsBuilderList() {
                return getImpressionsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> getImpressionsFieldBuilder() {
                if (this.impressionsBuilder_ == null) {
                    this.impressionsBuilder_ = new RepeatedFieldBuilderV3<>(this.impressions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.impressions_ = null;
                }
                return this.impressionsBuilder_;
            }

            private void ensureAdRequestsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.adRequests_ = new ArrayList(this.adRequests_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public List<AdRequestMetrics> getAdRequestsList() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.adRequests_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public int getAdRequestsCount() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public AdRequestMetrics getAdRequests(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.get(i);
                }
                return (AdRequestMetrics) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setAdRequests(int i, AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.set(i, adRequestMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, adRequestMetrics);
                }
                return this;
            }

            public Builder setAdRequests(int i, AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAdRequests(AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(adRequestMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(adRequestMetrics);
                }
                return this;
            }

            public Builder addAdRequests(int i, AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(i, adRequestMetrics);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, adRequestMetrics);
                }
                return this;
            }

            public Builder addAdRequests(AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addAdRequests(int i, AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllAdRequests(Iterable<? extends AdRequestMetrics> iterable) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.adRequests_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearAdRequests() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.adRequests_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeAdRequests(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public AdRequestMetrics.Builder getAdRequestsBuilder(int i) {
                return (AdRequestMetrics.Builder) getAdRequestsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.get(i);
                }
                return (AdRequestMetricsOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.SessionMetricsOrBuilder
            public List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.adRequests_);
            }

            public AdRequestMetrics.Builder addAdRequestsBuilder() {
                return (AdRequestMetrics.Builder) getAdRequestsFieldBuilder().addBuilder(AdRequestMetrics.getDefaultInstance());
            }

            public AdRequestMetrics.Builder addAdRequestsBuilder(int i) {
                return (AdRequestMetrics.Builder) getAdRequestsFieldBuilder().addBuilder(i, AdRequestMetrics.getDefaultInstance());
            }

            public List<AdRequestMetrics.Builder> getAdRequestsBuilderList() {
                return getAdRequestsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> getAdRequestsFieldBuilder() {
                if (this.adRequestsBuilder_ == null) {
                    this.adRequestsBuilder_ = new RepeatedFieldBuilderV3<>(this.adRequests_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.adRequests_ = null;
                }
                return this.adRequestsBuilder_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static SessionMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SessionMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<SessionMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public SessionMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserIdQuery extends GeneratedMessageV3 implements UserIdQueryOrBuilder {
        private static final UserIdQuery DEFAULT_INSTANCE = new UserIdQuery();
        private static final Parser<UserIdQuery> PARSER = new AbstractParser<UserIdQuery>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQuery.1
            @Override // com.explorestack.protobuf.Parser
            public UserIdQuery parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserIdQuery(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private volatile Object userId_;

        private UserIdQuery(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserIdQuery() {
            this.memoizedIsInitialized = (byte) -1;
            this.userId_ = "";
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserIdQuery();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UserIdQuery(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.userId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 16) {
                                    this.timestamp_ = codedInputStream.readInt64();
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_UserIdQuery_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable.ensureFieldAccessorsInitialized(UserIdQuery.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
        public String getUserId() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
        public ByteString getUserIdBytes() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userId_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUserIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.userId_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !getUserIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.userId_) : 0;
            long j = this.timestamp_;
            if (j != 0) {
                iComputeStringSize += CodedOutputStream.computeInt64Size(2, j);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserIdQuery)) {
                return super.equals(obj);
            }
            UserIdQuery userIdQuery = (UserIdQuery) obj;
            return getUserId().equals(userIdQuery.getUserId()) && getTimestamp() == userIdQuery.getTimestamp() && this.unknownFields.equals(userIdQuery.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUserId().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static UserIdQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserIdQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserIdQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserIdQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(InputStream inputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserIdQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserIdQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserIdQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserIdQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserIdQuery userIdQuery) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userIdQuery);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserIdQueryOrBuilder {
            private long timestamp_;
            private Object userId_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_UserIdQuery_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable.ensureFieldAccessorsInitialized(UserIdQuery.class, Builder.class);
            }

            private Builder() {
                this.userId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.userId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserIdQuery.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.userId_ = "";
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_UserIdQuery_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public UserIdQuery getDefaultInstanceForType() {
                return UserIdQuery.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserIdQuery build() {
                UserIdQuery userIdQueryBuildPartial = buildPartial();
                if (userIdQueryBuildPartial.isInitialized()) {
                    return userIdQueryBuildPartial;
                }
                throw newUninitializedMessageException((Message) userIdQueryBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserIdQuery buildPartial() {
                UserIdQuery userIdQuery = new UserIdQuery(this);
                userIdQuery.userId_ = this.userId_;
                userIdQuery.timestamp_ = this.timestamp_;
                onBuilt();
                return userIdQuery;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof UserIdQuery) {
                    return mergeFrom((UserIdQuery) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserIdQuery userIdQuery) {
                if (userIdQuery == UserIdQuery.getDefaultInstance()) {
                    return this;
                }
                if (!userIdQuery.getUserId().isEmpty()) {
                    this.userId_ = userIdQuery.userId_;
                    onChanged();
                }
                if (userIdQuery.getTimestamp() != 0) {
                    setTimestamp(userIdQuery.getTimestamp());
                }
                mergeUnknownFields(userIdQuery.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                UserIdQuery userIdQuery = null;
                try {
                    try {
                        UserIdQuery userIdQuery2 = (UserIdQuery) UserIdQuery.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (userIdQuery2 != null) {
                            mergeFrom(userIdQuery2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        UserIdQuery userIdQuery3 = (UserIdQuery) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            userIdQuery = userIdQuery3;
                            if (userIdQuery != null) {
                                mergeFrom(userIdQuery);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (userIdQuery != null) {
                        mergeFrom(userIdQuery);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
            public String getUserId() {
                Object obj = this.userId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
            public ByteString getUserIdBytes() {
                Object obj = this.userId_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userId_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setUserId(String str) {
                str.getClass();
                this.userId_ = str;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = UserIdQuery.getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                byteString.getClass();
                UserIdQuery.checkByteStringIsUtf8(byteString);
                this.userId_ = byteString;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.UserIdQueryOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static UserIdQuery getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserIdQuery> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<UserIdQuery> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public UserIdQuery getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdRequest extends GeneratedMessageV3 implements AdRequestOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 2;
        private static final AdRequest DEFAULT_INSTANCE = new AdRequest();
        private static final Parser<AdRequest> PARSER = new AbstractParser<AdRequest>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequest.1
            @Override // com.explorestack.protobuf.Parser
            public AdRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdRequest(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int adType_;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private volatile Object userId_;

        private AdRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.userId_ = "";
            this.adType_ = 0;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdRequest();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AdRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.userId_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 16) {
                                this.adType_ = codedInputStream.readEnum();
                            } else if (tag == 24) {
                                this.timestamp_ = codedInputStream.readInt64();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionDepth.internal_static_sessionmetrics_AdRequest_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionDepth.internal_static_sessionmetrics_AdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequest.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
        public String getUserId() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
        public ByteString getUserIdBytes() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userId_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
        public AdType getAdType() {
            AdType adTypeValueOf = AdType.valueOf(this.adType_);
            return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUserIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.userId_);
            }
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.adType_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !getUserIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.userId_) : 0;
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                iComputeStringSize += CodedOutputStream.computeEnumSize(2, this.adType_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                iComputeStringSize += CodedOutputStream.computeInt64Size(3, j);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdRequest)) {
                return super.equals(obj);
            }
            AdRequest adRequest = (AdRequest) obj;
            return getUserId().equals(adRequest.getUserId()) && this.adType_ == adRequest.adType_ && getTimestamp() == adRequest.getTimestamp() && this.unknownFields.equals(adRequest.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUserId().hashCode()) * 37) + 2) * 53) + this.adType_) * 37) + 3) * 53) + Internal.hashLong(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static AdRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdRequest parseFrom(InputStream inputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdRequest adRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adRequest);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdRequestOrBuilder {
            private int adType_;
            private long timestamp_;
            private Object userId_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionDepth.internal_static_sessionmetrics_AdRequest_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionDepth.internal_static_sessionmetrics_AdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequest.class, Builder.class);
            }

            private Builder() {
                this.userId_ = "";
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.userId_ = "";
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdRequest.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.userId_ = "";
                this.adType_ = 0;
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionDepth.internal_static_sessionmetrics_AdRequest_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdRequest getDefaultInstanceForType() {
                return AdRequest.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequest build() {
                AdRequest adRequestBuildPartial = buildPartial();
                if (adRequestBuildPartial.isInitialized()) {
                    return adRequestBuildPartial;
                }
                throw newUninitializedMessageException((Message) adRequestBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequest buildPartial() {
                AdRequest adRequest = new AdRequest(this);
                adRequest.userId_ = this.userId_;
                adRequest.adType_ = this.adType_;
                adRequest.timestamp_ = this.timestamp_;
                onBuilt();
                return adRequest;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public Builder mo4742clone() {
                return (Builder) super.mo4742clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AdRequest) {
                    return mergeFrom((AdRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdRequest adRequest) {
                if (adRequest == AdRequest.getDefaultInstance()) {
                    return this;
                }
                if (!adRequest.getUserId().isEmpty()) {
                    this.userId_ = adRequest.userId_;
                    onChanged();
                }
                if (adRequest.adType_ != 0) {
                    setAdTypeValue(adRequest.getAdTypeValue());
                }
                if (adRequest.getTimestamp() != 0) {
                    setTimestamp(adRequest.getTimestamp());
                }
                mergeUnknownFields(adRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                AdRequest adRequest = null;
                try {
                    try {
                        AdRequest adRequest2 = (AdRequest) AdRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adRequest2 != null) {
                            mergeFrom(adRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdRequest adRequest3 = (AdRequest) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adRequest = adRequest3;
                            if (adRequest != null) {
                                mergeFrom(adRequest);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adRequest != null) {
                        mergeFrom(adRequest);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
            public String getUserId() {
                Object obj = this.userId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
            public ByteString getUserIdBytes() {
                Object obj = this.userId_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userId_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setUserId(String str) {
                str.getClass();
                this.userId_ = str;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = AdRequest.getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                byteString.getClass();
                AdRequest.checkByteStringIsUtf8(byteString);
                this.userId_ = byteString;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
            public AdType getAdType() {
                AdType adTypeValueOf = AdType.valueOf(this.adType_);
                return adTypeValueOf == null ? AdType.UNRECOGNIZED : adTypeValueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionDepth.AdRequestOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AdRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdRequest> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_sessionmetrics_UserState_descriptor = descriptor2;
        internal_static_sessionmetrics_UserState_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"LastProcessedTimestamp", "Impressions", "AdRequests"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor = descriptor3;
        internal_static_sessionmetrics_UserState_ImpressionsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor4 = descriptor2.getNestedTypes().get(1);
        internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor = descriptor4;
        internal_static_sessionmetrics_UserState_AdRequestsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(1);
        internal_static_sessionmetrics_Timestamps_descriptor = descriptor5;
        internal_static_sessionmetrics_Timestamps_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"LastTimestamp", "Deltas", "DayBuckets"});
        Descriptors.Descriptor descriptor6 = descriptor5.getNestedTypes().get(0);
        internal_static_sessionmetrics_Timestamps_DayBucket_descriptor = descriptor6;
        internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"StartTime", "Count"});
        Descriptors.Descriptor descriptor7 = getDescriptor().getMessageTypes().get(2);
        internal_static_sessionmetrics_AdDomainTimestamps_descriptor = descriptor7;
        internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"AdDomains"});
        Descriptors.Descriptor descriptor8 = descriptor7.getNestedTypes().get(0);
        internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor = descriptor8;
        internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor9 = getDescriptor().getMessageTypes().get(3);
        internal_static_sessionmetrics_WindowMetrics_descriptor = descriptor9;
        internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"Last1H", "Last1D", "Last7D"});
        Descriptors.Descriptor descriptor10 = getDescriptor().getMessageTypes().get(4);
        internal_static_sessionmetrics_ImpressionMetrics_descriptor = descriptor10;
        internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"AdType", "Domains"});
        Descriptors.Descriptor descriptor11 = descriptor10.getNestedTypes().get(0);
        internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor = descriptor11;
        internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"Domain", "WindowMetrics"});
        Descriptors.Descriptor descriptor12 = getDescriptor().getMessageTypes().get(5);
        internal_static_sessionmetrics_AdRequestMetrics_descriptor = descriptor12;
        internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[]{"AdType", "WindowMetrics"});
        Descriptors.Descriptor descriptor13 = getDescriptor().getMessageTypes().get(6);
        internal_static_sessionmetrics_SessionMetrics_descriptor = descriptor13;
        internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor13, new String[]{"Impressions", "AdRequests"});
        Descriptors.Descriptor descriptor14 = getDescriptor().getMessageTypes().get(7);
        internal_static_sessionmetrics_UserIdQuery_descriptor = descriptor14;
        internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor14, new String[]{"UserId", RtspHeaders.TIMESTAMP});
        Descriptors.Descriptor descriptor15 = getDescriptor().getMessageTypes().get(8);
        internal_static_sessionmetrics_AdRequest_descriptor = descriptor15;
        internal_static_sessionmetrics_AdRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor15, new String[]{"UserId", "AdType", RtspHeaders.TIMESTAMP});
    }
}
