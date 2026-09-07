package com.moloco.sdk;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class MetricsRequest {

    public interface PostMetricsRequestOrBuilder extends MessageLiteOrBuilder {
        PostMetricsRequest.CountEvent getCounts(int i);

        int getCountsCount();

        List<PostMetricsRequest.CountEvent> getCountsList();

        PostMetricsRequest.TimerEvent getDurations(int i);

        int getDurationsCount();

        List<PostMetricsRequest.TimerEvent> getDurationsList();
    }

    public interface SDKInitFailureTrackingRequestOrBuilder extends MessageLiteOrBuilder {
        SDKInitFailureTrackingRequest.ClientError getClientError();

        SDKInitFailureTrackingRequest.ErrorTypeCase getErrorTypeCase();

        SDKInitFailureTrackingRequest.ServerError getServerError();

        boolean hasClientError();

        boolean hasServerError();
    }

    public interface SDKInitSuccessTrackingRequestOrBuilder extends MessageLiteOrBuilder {
    }

    public interface SDKInitTrackingRequestOrBuilder extends MessageLiteOrBuilder {
        SDKInitFailureTrackingRequest getFailure();

        SDKInitTrackingRequest.InitStatusCase getInitStatusCase();

        long getLatencyMs();

        SDKInitSuccessTrackingRequest getSuccess();

        boolean hasFailure();

        boolean hasLatencyMs();

        boolean hasSuccess();
    }

    public interface SDKInitTrackingResponseOrBuilder extends MessageLiteOrBuilder {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private MetricsRequest() {
    }

    public static final class PostMetricsRequest extends GeneratedMessageLite<PostMetricsRequest, Builder> implements PostMetricsRequestOrBuilder {
        public static final int COUNTS_FIELD_NUMBER = 1;
        private static final PostMetricsRequest DEFAULT_INSTANCE;
        public static final int DURATIONS_FIELD_NUMBER = 2;
        private static volatile Parser<PostMetricsRequest> PARSER;
        private Internal.ProtobufList<CountEvent> counts_ = emptyProtobufList();
        private Internal.ProtobufList<TimerEvent> durations_ = emptyProtobufList();

        public interface CountEventOrBuilder extends MessageLiteOrBuilder {
            int getCount();

            String getName();

            ByteString getNameBytes();

            String getTags(int i);

            ByteString getTagsBytes(int i);

            int getTagsCount();

            List<String> getTagsList();
        }

        public interface TimerEventOrBuilder extends MessageLiteOrBuilder {
            long getElapsedTimeMillis();

            String getName();

            ByteString getNameBytes();

            String getTags(int i);

            ByteString getTagsBytes(int i);

            int getTagsCount();

            List<String> getTagsList();
        }

        private PostMetricsRequest() {
        }

        public static final class CountEvent extends GeneratedMessageLite<CountEvent, Builder> implements CountEventOrBuilder {
            public static final int COUNT_FIELD_NUMBER = 2;
            private static final CountEvent DEFAULT_INSTANCE;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<CountEvent> PARSER = null;
            public static final int TAGS_FIELD_NUMBER = 3;
            private int count_;
            private String name_ = "";
            private Internal.ProtobufList<String> tags_ = GeneratedMessageLite.emptyProtobufList();

            private CountEvent() {
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public int getCount() {
                return this.count_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCount(int i) {
                this.count_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCount() {
                this.count_ = 0;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public List<String> getTagsList() {
                return this.tags_;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public int getTagsCount() {
                return this.tags_.size();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public String getTags(int i) {
                return this.tags_.get(i);
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
            public ByteString getTagsBytes(int i) {
                return ByteString.copyFromUtf8(this.tags_.get(i));
            }

            private void ensureTagsIsMutable() {
                Internal.ProtobufList<String> protobufList = this.tags_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.tags_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTags(int i, String str) {
                str.getClass();
                ensureTagsIsMutable();
                this.tags_.set(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addTags(String str) {
                str.getClass();
                ensureTagsIsMutable();
                this.tags_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllTags(Iterable<String> iterable) {
                ensureTagsIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTags() {
                this.tags_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addTagsBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                ensureTagsIsMutable();
                this.tags_.add(byteString.toStringUtf8());
            }

            public static CountEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static CountEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static CountEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static CountEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static CountEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static CountEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static CountEvent parseFrom(InputStream inputStream) throws IOException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CountEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CountEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (CountEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CountEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CountEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CountEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static CountEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CountEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(CountEvent countEvent) {
                return DEFAULT_INSTANCE.createBuilder(countEvent);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<CountEvent, Builder> implements CountEventOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(CountEvent.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public String getName() {
                    return ((CountEvent) this.instance).getName();
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public ByteString getNameBytes() {
                    return ((CountEvent) this.instance).getNameBytes();
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((CountEvent) this.instance).setName(str);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((CountEvent) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((CountEvent) this.instance).setNameBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public int getCount() {
                    return ((CountEvent) this.instance).getCount();
                }

                public Builder setCount(int i) {
                    copyOnWrite();
                    ((CountEvent) this.instance).setCount(i);
                    return this;
                }

                public Builder clearCount() {
                    copyOnWrite();
                    ((CountEvent) this.instance).clearCount();
                    return this;
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public List<String> getTagsList() {
                    return Collections.unmodifiableList(((CountEvent) this.instance).getTagsList());
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public int getTagsCount() {
                    return ((CountEvent) this.instance).getTagsCount();
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public String getTags(int i) {
                    return ((CountEvent) this.instance).getTags(i);
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.CountEventOrBuilder
                public ByteString getTagsBytes(int i) {
                    return ((CountEvent) this.instance).getTagsBytes(i);
                }

                public Builder setTags(int i, String str) {
                    copyOnWrite();
                    ((CountEvent) this.instance).setTags(i, str);
                    return this;
                }

                public Builder addTags(String str) {
                    copyOnWrite();
                    ((CountEvent) this.instance).addTags(str);
                    return this;
                }

                public Builder addAllTags(Iterable<String> iterable) {
                    copyOnWrite();
                    ((CountEvent) this.instance).addAllTags(iterable);
                    return this;
                }

                public Builder clearTags() {
                    copyOnWrite();
                    ((CountEvent) this.instance).clearTags();
                    return this;
                }

                public Builder addTagsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((CountEvent) this.instance).addTagsBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new CountEvent();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u000b\u0003Ț", new Object[]{"name_", "count_", "tags_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<CountEvent> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (CountEvent.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                CountEvent countEvent = new CountEvent();
                DEFAULT_INSTANCE = countEvent;
                GeneratedMessageLite.registerDefaultInstance(CountEvent.class, countEvent);
            }

            public static CountEvent getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<CountEvent> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class TimerEvent extends GeneratedMessageLite<TimerEvent, Builder> implements TimerEventOrBuilder {
            private static final TimerEvent DEFAULT_INSTANCE;
            public static final int ELAPSED_TIME_MILLIS_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<TimerEvent> PARSER = null;
            public static final int TAGS_FIELD_NUMBER = 3;
            private long elapsedTimeMillis_;
            private String name_ = "";
            private Internal.ProtobufList<String> tags_ = GeneratedMessageLite.emptyProtobufList();

            private TimerEvent() {
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public long getElapsedTimeMillis() {
                return this.elapsedTimeMillis_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setElapsedTimeMillis(long j) {
                this.elapsedTimeMillis_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearElapsedTimeMillis() {
                this.elapsedTimeMillis_ = 0L;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public List<String> getTagsList() {
                return this.tags_;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public int getTagsCount() {
                return this.tags_.size();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public String getTags(int i) {
                return this.tags_.get(i);
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
            public ByteString getTagsBytes(int i) {
                return ByteString.copyFromUtf8(this.tags_.get(i));
            }

            private void ensureTagsIsMutable() {
                Internal.ProtobufList<String> protobufList = this.tags_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.tags_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTags(int i, String str) {
                str.getClass();
                ensureTagsIsMutable();
                this.tags_.set(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addTags(String str) {
                str.getClass();
                ensureTagsIsMutable();
                this.tags_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllTags(Iterable<String> iterable) {
                ensureTagsIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTags() {
                this.tags_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addTagsBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                ensureTagsIsMutable();
                this.tags_.add(byteString.toStringUtf8());
            }

            public static TimerEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static TimerEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static TimerEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static TimerEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static TimerEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static TimerEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static TimerEvent parseFrom(InputStream inputStream) throws IOException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static TimerEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static TimerEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (TimerEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static TimerEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (TimerEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static TimerEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static TimerEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (TimerEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(TimerEvent timerEvent) {
                return DEFAULT_INSTANCE.createBuilder(timerEvent);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<TimerEvent, Builder> implements TimerEventOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(TimerEvent.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public String getName() {
                    return ((TimerEvent) this.instance).getName();
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public ByteString getNameBytes() {
                    return ((TimerEvent) this.instance).getNameBytes();
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).setName(str);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((TimerEvent) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).setNameBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public long getElapsedTimeMillis() {
                    return ((TimerEvent) this.instance).getElapsedTimeMillis();
                }

                public Builder setElapsedTimeMillis(long j) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).setElapsedTimeMillis(j);
                    return this;
                }

                public Builder clearElapsedTimeMillis() {
                    copyOnWrite();
                    ((TimerEvent) this.instance).clearElapsedTimeMillis();
                    return this;
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public List<String> getTagsList() {
                    return Collections.unmodifiableList(((TimerEvent) this.instance).getTagsList());
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public int getTagsCount() {
                    return ((TimerEvent) this.instance).getTagsCount();
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public String getTags(int i) {
                    return ((TimerEvent) this.instance).getTags(i);
                }

                @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequest.TimerEventOrBuilder
                public ByteString getTagsBytes(int i) {
                    return ((TimerEvent) this.instance).getTagsBytes(i);
                }

                public Builder setTags(int i, String str) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).setTags(i, str);
                    return this;
                }

                public Builder addTags(String str) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).addTags(str);
                    return this;
                }

                public Builder addAllTags(Iterable<String> iterable) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).addAllTags(iterable);
                    return this;
                }

                public Builder clearTags() {
                    copyOnWrite();
                    ((TimerEvent) this.instance).clearTags();
                    return this;
                }

                public Builder addTagsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((TimerEvent) this.instance).addTagsBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new TimerEvent();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0003\u0003Ț", new Object[]{"name_", "elapsedTimeMillis_", "tags_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<TimerEvent> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (TimerEvent.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                TimerEvent timerEvent = new TimerEvent();
                DEFAULT_INSTANCE = timerEvent;
                GeneratedMessageLite.registerDefaultInstance(TimerEvent.class, timerEvent);
            }

            public static TimerEvent getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<TimerEvent> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public List<CountEvent> getCountsList() {
            return this.counts_;
        }

        public List<? extends CountEventOrBuilder> getCountsOrBuilderList() {
            return this.counts_;
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public int getCountsCount() {
            return this.counts_.size();
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public CountEvent getCounts(int i) {
            return this.counts_.get(i);
        }

        public CountEventOrBuilder getCountsOrBuilder(int i) {
            return this.counts_.get(i);
        }

        private void ensureCountsIsMutable() {
            Internal.ProtobufList<CountEvent> protobufList = this.counts_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.counts_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCounts(int i, CountEvent countEvent) {
            countEvent.getClass();
            ensureCountsIsMutable();
            this.counts_.set(i, countEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCounts(CountEvent countEvent) {
            countEvent.getClass();
            ensureCountsIsMutable();
            this.counts_.add(countEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCounts(int i, CountEvent countEvent) {
            countEvent.getClass();
            ensureCountsIsMutable();
            this.counts_.add(i, countEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCounts(Iterable<? extends CountEvent> iterable) {
            ensureCountsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.counts_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCounts() {
            this.counts_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCounts(int i) {
            ensureCountsIsMutable();
            this.counts_.remove(i);
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public List<TimerEvent> getDurationsList() {
            return this.durations_;
        }

        public List<? extends TimerEventOrBuilder> getDurationsOrBuilderList() {
            return this.durations_;
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public int getDurationsCount() {
            return this.durations_.size();
        }

        @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
        public TimerEvent getDurations(int i) {
            return this.durations_.get(i);
        }

        public TimerEventOrBuilder getDurationsOrBuilder(int i) {
            return this.durations_.get(i);
        }

        private void ensureDurationsIsMutable() {
            Internal.ProtobufList<TimerEvent> protobufList = this.durations_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.durations_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDurations(int i, TimerEvent timerEvent) {
            timerEvent.getClass();
            ensureDurationsIsMutable();
            this.durations_.set(i, timerEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDurations(TimerEvent timerEvent) {
            timerEvent.getClass();
            ensureDurationsIsMutable();
            this.durations_.add(timerEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDurations(int i, TimerEvent timerEvent) {
            timerEvent.getClass();
            ensureDurationsIsMutable();
            this.durations_.add(i, timerEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDurations(Iterable<? extends TimerEvent> iterable) {
            ensureDurationsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.durations_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDurations() {
            this.durations_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDurations(int i) {
            ensureDurationsIsMutable();
            this.durations_.remove(i);
        }

        public static PostMetricsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PostMetricsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PostMetricsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PostMetricsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PostMetricsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PostMetricsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PostMetricsRequest parseFrom(InputStream inputStream) throws IOException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PostMetricsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PostMetricsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PostMetricsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PostMetricsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostMetricsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PostMetricsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PostMetricsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostMetricsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PostMetricsRequest postMetricsRequest) {
            return DEFAULT_INSTANCE.createBuilder(postMetricsRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PostMetricsRequest, Builder> implements PostMetricsRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PostMetricsRequest.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public List<CountEvent> getCountsList() {
                return Collections.unmodifiableList(((PostMetricsRequest) this.instance).getCountsList());
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public int getCountsCount() {
                return ((PostMetricsRequest) this.instance).getCountsCount();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public CountEvent getCounts(int i) {
                return ((PostMetricsRequest) this.instance).getCounts(i);
            }

            public Builder setCounts(int i, CountEvent countEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).setCounts(i, countEvent);
                return this;
            }

            public Builder setCounts(int i, CountEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).setCounts(i, builder.build());
                return this;
            }

            public Builder addCounts(CountEvent countEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addCounts(countEvent);
                return this;
            }

            public Builder addCounts(int i, CountEvent countEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addCounts(i, countEvent);
                return this;
            }

            public Builder addCounts(CountEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addCounts(builder.build());
                return this;
            }

            public Builder addCounts(int i, CountEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addCounts(i, builder.build());
                return this;
            }

            public Builder addAllCounts(Iterable<? extends CountEvent> iterable) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addAllCounts(iterable);
                return this;
            }

            public Builder clearCounts() {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).clearCounts();
                return this;
            }

            public Builder removeCounts(int i) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).removeCounts(i);
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public List<TimerEvent> getDurationsList() {
                return Collections.unmodifiableList(((PostMetricsRequest) this.instance).getDurationsList());
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public int getDurationsCount() {
                return ((PostMetricsRequest) this.instance).getDurationsCount();
            }

            @Override // com.moloco.sdk.MetricsRequest.PostMetricsRequestOrBuilder
            public TimerEvent getDurations(int i) {
                return ((PostMetricsRequest) this.instance).getDurations(i);
            }

            public Builder setDurations(int i, TimerEvent timerEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).setDurations(i, timerEvent);
                return this;
            }

            public Builder setDurations(int i, TimerEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).setDurations(i, builder.build());
                return this;
            }

            public Builder addDurations(TimerEvent timerEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addDurations(timerEvent);
                return this;
            }

            public Builder addDurations(int i, TimerEvent timerEvent) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addDurations(i, timerEvent);
                return this;
            }

            public Builder addDurations(TimerEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addDurations(builder.build());
                return this;
            }

            public Builder addDurations(int i, TimerEvent.Builder builder) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addDurations(i, builder.build());
                return this;
            }

            public Builder addAllDurations(Iterable<? extends TimerEvent> iterable) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).addAllDurations(iterable);
                return this;
            }

            public Builder clearDurations() {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).clearDurations();
                return this;
            }

            public Builder removeDurations(int i) {
                copyOnWrite();
                ((PostMetricsRequest) this.instance).removeDurations(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new PostMetricsRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"counts_", CountEvent.class, "durations_", TimerEvent.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PostMetricsRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (PostMetricsRequest.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PostMetricsRequest postMetricsRequest = new PostMetricsRequest();
            DEFAULT_INSTANCE = postMetricsRequest;
            GeneratedMessageLite.registerDefaultInstance(PostMetricsRequest.class, postMetricsRequest);
        }

        public static PostMetricsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PostMetricsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.MetricsRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class SDKInitTrackingRequest extends GeneratedMessageLite<SDKInitTrackingRequest, Builder> implements SDKInitTrackingRequestOrBuilder {
        private static final SDKInitTrackingRequest DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 2;
        public static final int LATENCY_MS_FIELD_NUMBER = 3;
        private static volatile Parser<SDKInitTrackingRequest> PARSER = null;
        public static final int SUCCESS_FIELD_NUMBER = 1;
        private int bitField0_;
        private int initStatusCase_ = 0;
        private Object initStatus_;
        private long latencyMs_;

        private SDKInitTrackingRequest() {
        }

        public enum InitStatusCase {
            SUCCESS(1),
            FAILURE(2),
            INITSTATUS_NOT_SET(0);

            private final int value;

            InitStatusCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static InitStatusCase valueOf(int i) {
                return forNumber(i);
            }

            public static InitStatusCase forNumber(int i) {
                if (i == 0) {
                    return INITSTATUS_NOT_SET;
                }
                if (i == 1) {
                    return SUCCESS;
                }
                if (i != 2) {
                    return null;
                }
                return FAILURE;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public InitStatusCase getInitStatusCase() {
            return InitStatusCase.forNumber(this.initStatusCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInitStatus() {
            this.initStatusCase_ = 0;
            this.initStatus_ = null;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public boolean hasSuccess() {
            return this.initStatusCase_ == 1;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public SDKInitSuccessTrackingRequest getSuccess() {
            if (this.initStatusCase_ == 1) {
                return (SDKInitSuccessTrackingRequest) this.initStatus_;
            }
            return SDKInitSuccessTrackingRequest.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest) {
            sDKInitSuccessTrackingRequest.getClass();
            this.initStatus_ = sDKInitSuccessTrackingRequest;
            this.initStatusCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSuccess(SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest) {
            sDKInitSuccessTrackingRequest.getClass();
            if (this.initStatusCase_ == 1 && this.initStatus_ != SDKInitSuccessTrackingRequest.getDefaultInstance()) {
                this.initStatus_ = SDKInitSuccessTrackingRequest.newBuilder((SDKInitSuccessTrackingRequest) this.initStatus_).mergeFrom(sDKInitSuccessTrackingRequest).buildPartial();
            } else {
                this.initStatus_ = sDKInitSuccessTrackingRequest;
            }
            this.initStatusCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            if (this.initStatusCase_ == 1) {
                this.initStatusCase_ = 0;
                this.initStatus_ = null;
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public boolean hasFailure() {
            return this.initStatusCase_ == 2;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public SDKInitFailureTrackingRequest getFailure() {
            if (this.initStatusCase_ == 2) {
                return (SDKInitFailureTrackingRequest) this.initStatus_;
            }
            return SDKInitFailureTrackingRequest.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFailure(SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest) {
            sDKInitFailureTrackingRequest.getClass();
            this.initStatus_ = sDKInitFailureTrackingRequest;
            this.initStatusCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFailure(SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest) {
            sDKInitFailureTrackingRequest.getClass();
            if (this.initStatusCase_ == 2 && this.initStatus_ != SDKInitFailureTrackingRequest.getDefaultInstance()) {
                this.initStatus_ = SDKInitFailureTrackingRequest.newBuilder((SDKInitFailureTrackingRequest) this.initStatus_).mergeFrom(sDKInitFailureTrackingRequest).buildPartial();
            } else {
                this.initStatus_ = sDKInitFailureTrackingRequest;
            }
            this.initStatusCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFailure() {
            if (this.initStatusCase_ == 2) {
                this.initStatusCase_ = 0;
                this.initStatus_ = null;
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public boolean hasLatencyMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
        public long getLatencyMs() {
            return this.latencyMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLatencyMs(long j) {
            this.bitField0_ |= 1;
            this.latencyMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLatencyMs() {
            this.bitField0_ &= -2;
            this.latencyMs_ = 0L;
        }

        public static SDKInitTrackingRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SDKInitTrackingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SDKInitTrackingRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SDKInitTrackingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SDKInitTrackingRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SDKInitTrackingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SDKInitTrackingRequest parseFrom(InputStream inputStream) throws IOException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitTrackingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitTrackingRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SDKInitTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitTrackingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitTrackingRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SDKInitTrackingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SDKInitTrackingRequest sDKInitTrackingRequest) {
            return DEFAULT_INSTANCE.createBuilder(sDKInitTrackingRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SDKInitTrackingRequest, Builder> implements SDKInitTrackingRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SDKInitTrackingRequest.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public InitStatusCase getInitStatusCase() {
                return ((SDKInitTrackingRequest) this.instance).getInitStatusCase();
            }

            public Builder clearInitStatus() {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).clearInitStatus();
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public boolean hasSuccess() {
                return ((SDKInitTrackingRequest) this.instance).hasSuccess();
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public SDKInitSuccessTrackingRequest getSuccess() {
                return ((SDKInitTrackingRequest) this.instance).getSuccess();
            }

            public Builder setSuccess(SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).setSuccess(sDKInitSuccessTrackingRequest);
                return this;
            }

            public Builder setSuccess(SDKInitSuccessTrackingRequest.Builder builder) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).setSuccess(builder.build());
                return this;
            }

            public Builder mergeSuccess(SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).mergeSuccess(sDKInitSuccessTrackingRequest);
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).clearSuccess();
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public boolean hasFailure() {
                return ((SDKInitTrackingRequest) this.instance).hasFailure();
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public SDKInitFailureTrackingRequest getFailure() {
                return ((SDKInitTrackingRequest) this.instance).getFailure();
            }

            public Builder setFailure(SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).setFailure(sDKInitFailureTrackingRequest);
                return this;
            }

            public Builder setFailure(SDKInitFailureTrackingRequest.Builder builder) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).setFailure(builder.build());
                return this;
            }

            public Builder mergeFailure(SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).mergeFailure(sDKInitFailureTrackingRequest);
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).clearFailure();
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public boolean hasLatencyMs() {
                return ((SDKInitTrackingRequest) this.instance).hasLatencyMs();
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitTrackingRequestOrBuilder
            public long getLatencyMs() {
                return ((SDKInitTrackingRequest) this.instance).getLatencyMs();
            }

            public Builder setLatencyMs(long j) {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).setLatencyMs(j);
                return this;
            }

            public Builder clearLatencyMs() {
                copyOnWrite();
                ((SDKInitTrackingRequest) this.instance).clearLatencyMs();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SDKInitTrackingRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003ဃ\u0000", new Object[]{"initStatus_", "initStatusCase_", "bitField0_", SDKInitSuccessTrackingRequest.class, SDKInitFailureTrackingRequest.class, "latencyMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SDKInitTrackingRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SDKInitTrackingRequest.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SDKInitTrackingRequest sDKInitTrackingRequest = new SDKInitTrackingRequest();
            DEFAULT_INSTANCE = sDKInitTrackingRequest;
            GeneratedMessageLite.registerDefaultInstance(SDKInitTrackingRequest.class, sDKInitTrackingRequest);
        }

        public static SDKInitTrackingRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SDKInitTrackingRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SDKInitSuccessTrackingRequest extends GeneratedMessageLite<SDKInitSuccessTrackingRequest, Builder> implements SDKInitSuccessTrackingRequestOrBuilder {
        private static final SDKInitSuccessTrackingRequest DEFAULT_INSTANCE;
        private static volatile Parser<SDKInitSuccessTrackingRequest> PARSER;

        private SDKInitSuccessTrackingRequest() {
        }

        public static SDKInitSuccessTrackingRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(InputStream inputStream) throws IOException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitSuccessTrackingRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SDKInitSuccessTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitSuccessTrackingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitSuccessTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SDKInitSuccessTrackingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitSuccessTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest) {
            return DEFAULT_INSTANCE.createBuilder(sDKInitSuccessTrackingRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SDKInitSuccessTrackingRequest, Builder> implements SDKInitSuccessTrackingRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SDKInitSuccessTrackingRequest.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SDKInitSuccessTrackingRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SDKInitSuccessTrackingRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SDKInitSuccessTrackingRequest.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SDKInitSuccessTrackingRequest sDKInitSuccessTrackingRequest = new SDKInitSuccessTrackingRequest();
            DEFAULT_INSTANCE = sDKInitSuccessTrackingRequest;
            GeneratedMessageLite.registerDefaultInstance(SDKInitSuccessTrackingRequest.class, sDKInitSuccessTrackingRequest);
        }

        public static SDKInitSuccessTrackingRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SDKInitSuccessTrackingRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SDKInitFailureTrackingRequest extends GeneratedMessageLite<SDKInitFailureTrackingRequest, Builder> implements SDKInitFailureTrackingRequestOrBuilder {
        public static final int CLIENT_ERROR_FIELD_NUMBER = 2;
        private static final SDKInitFailureTrackingRequest DEFAULT_INSTANCE;
        private static volatile Parser<SDKInitFailureTrackingRequest> PARSER = null;
        public static final int SERVER_ERROR_FIELD_NUMBER = 1;
        private int errorTypeCase_ = 0;
        private Object errorType_;

        public interface ClientErrorOrBuilder extends MessageLiteOrBuilder {
            ClientError.ClientErrorTypes getClientFailureType();

            int getClientFailureTypeValue();

            boolean hasClientFailureType();
        }

        public interface ServerErrorOrBuilder extends MessageLiteOrBuilder {
            int getServerHttpStatus();

            boolean hasServerHttpStatus();
        }

        private SDKInitFailureTrackingRequest() {
        }

        public static final class ServerError extends GeneratedMessageLite<ServerError, Builder> implements ServerErrorOrBuilder {
            private static final ServerError DEFAULT_INSTANCE;
            private static volatile Parser<ServerError> PARSER = null;
            public static final int SERVER_HTTP_STATUS_FIELD_NUMBER = 1;
            private int bitField0_;
            private int serverHttpStatus_;

            private ServerError() {
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ServerErrorOrBuilder
            public boolean hasServerHttpStatus() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ServerErrorOrBuilder
            public int getServerHttpStatus() {
                return this.serverHttpStatus_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setServerHttpStatus(int i) {
                this.bitField0_ |= 1;
                this.serverHttpStatus_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearServerHttpStatus() {
                this.bitField0_ &= -2;
                this.serverHttpStatus_ = 0;
            }

            public static ServerError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ServerError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ServerError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ServerError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ServerError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ServerError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ServerError parseFrom(InputStream inputStream) throws IOException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ServerError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ServerError parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ServerError) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ServerError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ServerError) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ServerError parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ServerError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ServerError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ServerError serverError) {
                return DEFAULT_INSTANCE.createBuilder(serverError);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ServerError, Builder> implements ServerErrorOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ServerError.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ServerErrorOrBuilder
                public boolean hasServerHttpStatus() {
                    return ((ServerError) this.instance).hasServerHttpStatus();
                }

                @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ServerErrorOrBuilder
                public int getServerHttpStatus() {
                    return ((ServerError) this.instance).getServerHttpStatus();
                }

                public Builder setServerHttpStatus(int i) {
                    copyOnWrite();
                    ((ServerError) this.instance).setServerHttpStatus(i);
                    return this;
                }

                public Builder clearServerHttpStatus() {
                    copyOnWrite();
                    ((ServerError) this.instance).clearServerHttpStatus();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ServerError();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"bitField0_", "serverHttpStatus_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ServerError> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ServerError.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                ServerError serverError = new ServerError();
                DEFAULT_INSTANCE = serverError;
                GeneratedMessageLite.registerDefaultInstance(ServerError.class, serverError);
            }

            public static ServerError getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ServerError> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class ClientError extends GeneratedMessageLite<ClientError, Builder> implements ClientErrorOrBuilder {
            public static final int CLIENT_FAILURE_TYPE_FIELD_NUMBER = 1;
            private static final ClientError DEFAULT_INSTANCE;
            private static volatile Parser<ClientError> PARSER;
            private int bitField0_;
            private int clientFailureType_;

            private ClientError() {
            }

            public enum ClientErrorTypes implements Internal.EnumLite {
                UNKNOWN(0),
                HTTP_SSL_ERROR(1),
                HTTP_UKNOWN_HOST(2),
                HTTP_REQUEST_TIMEOUT(3),
                HTTP_SOCKET(4),
                ANDROID_WORK_MANAGER_ISSUE(5),
                UNRECOGNIZED(-1);

                public static final int ANDROID_WORK_MANAGER_ISSUE_VALUE = 5;
                public static final int HTTP_REQUEST_TIMEOUT_VALUE = 3;
                public static final int HTTP_SOCKET_VALUE = 4;
                public static final int HTTP_SSL_ERROR_VALUE = 1;
                public static final int HTTP_UKNOWN_HOST_VALUE = 2;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<ClientErrorTypes> internalValueMap = new Internal.EnumLiteMap<ClientErrorTypes>() { // from class: com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public ClientErrorTypes findValueByNumber(int i) {
                        return ClientErrorTypes.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static ClientErrorTypes valueOf(int i) {
                    return forNumber(i);
                }

                public static ClientErrorTypes forNumber(int i) {
                    if (i == 0) {
                        return UNKNOWN;
                    }
                    if (i == 1) {
                        return HTTP_SSL_ERROR;
                    }
                    if (i == 2) {
                        return HTTP_UKNOWN_HOST;
                    }
                    if (i == 3) {
                        return HTTP_REQUEST_TIMEOUT;
                    }
                    if (i == 4) {
                        return HTTP_SOCKET;
                    }
                    if (i != 5) {
                        return null;
                    }
                    return ANDROID_WORK_MANAGER_ISSUE;
                }

                public static Internal.EnumLiteMap<ClientErrorTypes> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return ClientErrorTypesVerifier.INSTANCE;
                }

                private static final class ClientErrorTypesVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new ClientErrorTypesVerifier();

                    private ClientErrorTypesVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return ClientErrorTypes.forNumber(i) != null;
                    }
                }

                ClientErrorTypes(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
            public boolean hasClientFailureType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
            public int getClientFailureTypeValue() {
                return this.clientFailureType_;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
            public ClientErrorTypes getClientFailureType() {
                ClientErrorTypes clientErrorTypesForNumber = ClientErrorTypes.forNumber(this.clientFailureType_);
                return clientErrorTypesForNumber == null ? ClientErrorTypes.UNRECOGNIZED : clientErrorTypesForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClientFailureTypeValue(int i) {
                this.bitField0_ |= 1;
                this.clientFailureType_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClientFailureType(ClientErrorTypes clientErrorTypes) {
                this.clientFailureType_ = clientErrorTypes.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearClientFailureType() {
                this.bitField0_ &= -2;
                this.clientFailureType_ = 0;
            }

            public static ClientError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ClientError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ClientError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ClientError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ClientError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ClientError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ClientError parseFrom(InputStream inputStream) throws IOException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClientError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClientError parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ClientError) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClientError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientError) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClientError parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ClientError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ClientError clientError) {
                return DEFAULT_INSTANCE.createBuilder(clientError);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ClientError, Builder> implements ClientErrorOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ClientError.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
                public boolean hasClientFailureType() {
                    return ((ClientError) this.instance).hasClientFailureType();
                }

                @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
                public int getClientFailureTypeValue() {
                    return ((ClientError) this.instance).getClientFailureTypeValue();
                }

                public Builder setClientFailureTypeValue(int i) {
                    copyOnWrite();
                    ((ClientError) this.instance).setClientFailureTypeValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequest.ClientErrorOrBuilder
                public ClientErrorTypes getClientFailureType() {
                    return ((ClientError) this.instance).getClientFailureType();
                }

                public Builder setClientFailureType(ClientErrorTypes clientErrorTypes) {
                    copyOnWrite();
                    ((ClientError) this.instance).setClientFailureType(clientErrorTypes);
                    return this;
                }

                public Builder clearClientFailureType() {
                    copyOnWrite();
                    ((ClientError) this.instance).clearClientFailureType();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ClientError();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "clientFailureType_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ClientError> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ClientError.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                ClientError clientError = new ClientError();
                DEFAULT_INSTANCE = clientError;
                GeneratedMessageLite.registerDefaultInstance(ClientError.class, clientError);
            }

            public static ClientError getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ClientError> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum ErrorTypeCase {
            SERVER_ERROR(1),
            CLIENT_ERROR(2),
            ERRORTYPE_NOT_SET(0);

            private final int value;

            ErrorTypeCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ErrorTypeCase valueOf(int i) {
                return forNumber(i);
            }

            public static ErrorTypeCase forNumber(int i) {
                if (i == 0) {
                    return ERRORTYPE_NOT_SET;
                }
                if (i == 1) {
                    return SERVER_ERROR;
                }
                if (i != 2) {
                    return null;
                }
                return CLIENT_ERROR;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
        public ErrorTypeCase getErrorTypeCase() {
            return ErrorTypeCase.forNumber(this.errorTypeCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorType() {
            this.errorTypeCase_ = 0;
            this.errorType_ = null;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
        public boolean hasServerError() {
            return this.errorTypeCase_ == 1;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
        public ServerError getServerError() {
            if (this.errorTypeCase_ == 1) {
                return (ServerError) this.errorType_;
            }
            return ServerError.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerError(ServerError serverError) {
            serverError.getClass();
            this.errorType_ = serverError;
            this.errorTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeServerError(ServerError serverError) {
            serverError.getClass();
            if (this.errorTypeCase_ == 1 && this.errorType_ != ServerError.getDefaultInstance()) {
                this.errorType_ = ServerError.newBuilder((ServerError) this.errorType_).mergeFrom(serverError).buildPartial();
            } else {
                this.errorType_ = serverError;
            }
            this.errorTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerError() {
            if (this.errorTypeCase_ == 1) {
                this.errorTypeCase_ = 0;
                this.errorType_ = null;
            }
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
        public boolean hasClientError() {
            return this.errorTypeCase_ == 2;
        }

        @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
        public ClientError getClientError() {
            if (this.errorTypeCase_ == 2) {
                return (ClientError) this.errorType_;
            }
            return ClientError.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientError(ClientError clientError) {
            clientError.getClass();
            this.errorType_ = clientError;
            this.errorTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClientError(ClientError clientError) {
            clientError.getClass();
            if (this.errorTypeCase_ == 2 && this.errorType_ != ClientError.getDefaultInstance()) {
                this.errorType_ = ClientError.newBuilder((ClientError) this.errorType_).mergeFrom(clientError).buildPartial();
            } else {
                this.errorType_ = clientError;
            }
            this.errorTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientError() {
            if (this.errorTypeCase_ == 2) {
                this.errorTypeCase_ = 0;
                this.errorType_ = null;
            }
        }

        public static SDKInitFailureTrackingRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SDKInitFailureTrackingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SDKInitFailureTrackingRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SDKInitFailureTrackingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SDKInitFailureTrackingRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SDKInitFailureTrackingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SDKInitFailureTrackingRequest parseFrom(InputStream inputStream) throws IOException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitFailureTrackingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitFailureTrackingRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SDKInitFailureTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitFailureTrackingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitFailureTrackingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitFailureTrackingRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SDKInitFailureTrackingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitFailureTrackingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest) {
            return DEFAULT_INSTANCE.createBuilder(sDKInitFailureTrackingRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SDKInitFailureTrackingRequest, Builder> implements SDKInitFailureTrackingRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SDKInitFailureTrackingRequest.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
            public ErrorTypeCase getErrorTypeCase() {
                return ((SDKInitFailureTrackingRequest) this.instance).getErrorTypeCase();
            }

            public Builder clearErrorType() {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).clearErrorType();
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
            public boolean hasServerError() {
                return ((SDKInitFailureTrackingRequest) this.instance).hasServerError();
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
            public ServerError getServerError() {
                return ((SDKInitFailureTrackingRequest) this.instance).getServerError();
            }

            public Builder setServerError(ServerError serverError) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).setServerError(serverError);
                return this;
            }

            public Builder setServerError(ServerError.Builder builder) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).setServerError(builder.build());
                return this;
            }

            public Builder mergeServerError(ServerError serverError) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).mergeServerError(serverError);
                return this;
            }

            public Builder clearServerError() {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).clearServerError();
                return this;
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
            public boolean hasClientError() {
                return ((SDKInitFailureTrackingRequest) this.instance).hasClientError();
            }

            @Override // com.moloco.sdk.MetricsRequest.SDKInitFailureTrackingRequestOrBuilder
            public ClientError getClientError() {
                return ((SDKInitFailureTrackingRequest) this.instance).getClientError();
            }

            public Builder setClientError(ClientError clientError) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).setClientError(clientError);
                return this;
            }

            public Builder setClientError(ClientError.Builder builder) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).setClientError(builder.build());
                return this;
            }

            public Builder mergeClientError(ClientError clientError) {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).mergeClientError(clientError);
                return this;
            }

            public Builder clearClientError() {
                copyOnWrite();
                ((SDKInitFailureTrackingRequest) this.instance).clearClientError();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SDKInitFailureTrackingRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"errorType_", "errorTypeCase_", ServerError.class, ClientError.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SDKInitFailureTrackingRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SDKInitFailureTrackingRequest.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SDKInitFailureTrackingRequest sDKInitFailureTrackingRequest = new SDKInitFailureTrackingRequest();
            DEFAULT_INSTANCE = sDKInitFailureTrackingRequest;
            GeneratedMessageLite.registerDefaultInstance(SDKInitFailureTrackingRequest.class, sDKInitFailureTrackingRequest);
        }

        public static SDKInitFailureTrackingRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SDKInitFailureTrackingRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SDKInitTrackingResponse extends GeneratedMessageLite<SDKInitTrackingResponse, Builder> implements SDKInitTrackingResponseOrBuilder {
        private static final SDKInitTrackingResponse DEFAULT_INSTANCE;
        private static volatile Parser<SDKInitTrackingResponse> PARSER;

        private SDKInitTrackingResponse() {
        }

        public static SDKInitTrackingResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SDKInitTrackingResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SDKInitTrackingResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SDKInitTrackingResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SDKInitTrackingResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SDKInitTrackingResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SDKInitTrackingResponse parseFrom(InputStream inputStream) throws IOException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitTrackingResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitTrackingResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SDKInitTrackingResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitTrackingResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitTrackingResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SDKInitTrackingResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitTrackingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SDKInitTrackingResponse sDKInitTrackingResponse) {
            return DEFAULT_INSTANCE.createBuilder(sDKInitTrackingResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SDKInitTrackingResponse, Builder> implements SDKInitTrackingResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SDKInitTrackingResponse.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SDKInitTrackingResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SDKInitTrackingResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SDKInitTrackingResponse.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SDKInitTrackingResponse sDKInitTrackingResponse = new SDKInitTrackingResponse();
            DEFAULT_INSTANCE = sDKInitTrackingResponse;
            GeneratedMessageLite.registerDefaultInstance(SDKInitTrackingResponse.class, sDKInitTrackingResponse);
        }

        public static SDKInitTrackingResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SDKInitTrackingResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
