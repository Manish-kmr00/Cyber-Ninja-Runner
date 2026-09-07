package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Event extends GeneratedMessageV3 implements EventOrBuilder {
    public static final int EXTRAS_PRIVATE_FIELD_NUMBER = 3;
    public static final int MONITOR_FIELD_NUMBER = 1;
    public static final int READER_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private Struct extrasPrivate_;
    private byte memoizedIsInitialized;
    private int payloadCase_;
    private Object payload_;
    private static final Event DEFAULT_INSTANCE = new Event();
    private static final Parser<Event> PARSER = new AbstractParser<Event>() { // from class: io.bidmachine.protobuf.sdk.Event.1
        @Override // com.explorestack.protobuf.Parser
        public Event parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Event(codedInputStream, extensionRegistryLite);
        }
    };

    private Event(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.payloadCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private Event() {
        this.payloadCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Event();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Event(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            Monitor.Builder builder = this.payloadCase_ == 1 ? ((Monitor) this.payload_).toBuilder() : null;
                            MessageLite message = codedInputStream.readMessage(Monitor.parser(), extensionRegistryLite);
                            this.payload_ = message;
                            if (builder != null) {
                                builder.mergeFrom((Monitor) message);
                                this.payload_ = builder.buildPartial();
                            }
                            this.payloadCase_ = 1;
                        } else if (tag == 18) {
                            Reader.Builder builder2 = this.payloadCase_ == 2 ? ((Reader) this.payload_).toBuilder() : null;
                            MessageLite message2 = codedInputStream.readMessage(Reader.parser(), extensionRegistryLite);
                            this.payload_ = message2;
                            if (builder2 != null) {
                                builder2.mergeFrom((Reader) message2);
                                this.payload_ = builder2.buildPartial();
                            }
                            this.payloadCase_ = 2;
                        } else if (tag == 26) {
                            Struct struct = this.extrasPrivate_;
                            Struct.Builder builder3 = struct != null ? struct.toBuilder() : null;
                            Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            this.extrasPrivate_ = struct2;
                            if (builder3 != null) {
                                builder3.mergeFrom(struct2);
                                this.extrasPrivate_ = builder3.buildPartial();
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
        return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Event_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
    }

    public enum PayloadCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        MONITOR(1),
        READER(2),
        PAYLOAD_NOT_SET(0);

        private final int value;

        PayloadCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static PayloadCase valueOf(int i) {
            return forNumber(i);
        }

        public static PayloadCase forNumber(int i) {
            if (i == 0) {
                return PAYLOAD_NOT_SET;
            }
            if (i == 1) {
                return MONITOR;
            }
            if (i != 2) {
                return null;
            }
            return READER;
        }

        @Override // com.explorestack.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public PayloadCase getPayloadCase() {
        return PayloadCase.forNumber(this.payloadCase_);
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public boolean hasMonitor() {
        return this.payloadCase_ == 1;
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public Monitor getMonitor() {
        if (this.payloadCase_ == 1) {
            return (Monitor) this.payload_;
        }
        return Monitor.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public MonitorOrBuilder getMonitorOrBuilder() {
        if (this.payloadCase_ == 1) {
            return (Monitor) this.payload_;
        }
        return Monitor.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public boolean hasReader() {
        return this.payloadCase_ == 2;
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public Reader getReader() {
        if (this.payloadCase_ == 2) {
            return (Reader) this.payload_;
        }
        return Reader.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public ReaderOrBuilder getReaderOrBuilder() {
        if (this.payloadCase_ == 2) {
            return (Reader) this.payload_;
        }
        return Reader.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public boolean hasExtrasPrivate() {
        return this.extrasPrivate_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public Struct getExtrasPrivate() {
        Struct struct = this.extrasPrivate_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
    public StructOrBuilder getExtrasPrivateOrBuilder() {
        return getExtrasPrivate();
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
        if (this.payloadCase_ == 1) {
            codedOutputStream.writeMessage(1, (Monitor) this.payload_);
        }
        if (this.payloadCase_ == 2) {
            codedOutputStream.writeMessage(2, (Reader) this.payload_);
        }
        if (this.extrasPrivate_ != null) {
            codedOutputStream.writeMessage(3, getExtrasPrivate());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = this.payloadCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (Monitor) this.payload_) : 0;
        if (this.payloadCase_ == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, (Reader) this.payload_);
        }
        if (this.extrasPrivate_ != null) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, getExtrasPrivate());
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
        if (!(obj instanceof Event)) {
            return super.equals(obj);
        }
        Event event = (Event) obj;
        if (hasExtrasPrivate() != event.hasExtrasPrivate()) {
            return false;
        }
        if ((hasExtrasPrivate() && !getExtrasPrivate().equals(event.getExtrasPrivate())) || !getPayloadCase().equals(event.getPayloadCase())) {
            return false;
        }
        int i = this.payloadCase_;
        if (i == 1) {
            if (!getMonitor().equals(event.getMonitor())) {
                return false;
            }
        } else if (i == 2 && !getReader().equals(event.getReader())) {
            return false;
        }
        return this.unknownFields.equals(event.unknownFields);
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        int i;
        int iHashCode;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode2 = 779 + getDescriptor().hashCode();
        if (hasExtrasPrivate()) {
            iHashCode2 = (((iHashCode2 * 37) + 3) * 53) + getExtrasPrivate().hashCode();
        }
        int i2 = this.payloadCase_;
        if (i2 == 1) {
            i = ((iHashCode2 * 37) + 1) * 53;
            iHashCode = getMonitor().hashCode();
        } else {
            if (i2 == 2) {
                i = ((iHashCode2 * 37) + 2) * 53;
                iHashCode = getReader().hashCode();
            }
            int iHashCode3 = (iHashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode3;
            return iHashCode3;
        }
        iHashCode2 = i + iHashCode;
        int iHashCode4 = (iHashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode4;
        return iHashCode4;
    }

    public static Event parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Event parseFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Event) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Event event) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(event);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EventOrBuilder {
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> extrasPrivateBuilder_;
        private Struct extrasPrivate_;
        private SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> monitorBuilder_;
        private int payloadCase_;
        private Object payload_;
        private SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> readerBuilder_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Event_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
        }

        private Builder() {
            this.payloadCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.payloadCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Event.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.extrasPrivateBuilder_ == null) {
                this.extrasPrivate_ = null;
            } else {
                this.extrasPrivate_ = null;
                this.extrasPrivateBuilder_ = null;
            }
            this.payloadCase_ = 0;
            this.payload_ = null;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Event_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Event getDefaultInstanceForType() {
            return Event.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Event build() {
            Event eventBuildPartial = buildPartial();
            if (eventBuildPartial.isInitialized()) {
                return eventBuildPartial;
            }
            throw newUninitializedMessageException((Message) eventBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Event buildPartial() {
            Event event = new Event(this);
            if (this.payloadCase_ == 1) {
                SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    event.payload_ = this.payload_;
                } else {
                    event.payload_ = singleFieldBuilderV3.build();
                }
            }
            if (this.payloadCase_ == 2) {
                SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV4 = this.readerBuilder_;
                if (singleFieldBuilderV4 == null) {
                    event.payload_ = this.payload_;
                } else {
                    event.payload_ = singleFieldBuilderV4.build();
                }
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV5 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV5 == null) {
                event.extrasPrivate_ = this.extrasPrivate_;
            } else {
                event.extrasPrivate_ = (Struct) singleFieldBuilderV5.build();
            }
            event.payloadCase_ = this.payloadCase_;
            onBuilt();
            return event;
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
            if (message instanceof Event) {
                return mergeFrom((Event) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Event event) {
            if (event == Event.getDefaultInstance()) {
                return this;
            }
            if (event.hasExtrasPrivate()) {
                mergeExtrasPrivate(event.getExtrasPrivate());
            }
            int i = AnonymousClass2.$SwitchMap$io$bidmachine$protobuf$sdk$Event$PayloadCase[event.getPayloadCase().ordinal()];
            if (i == 1) {
                mergeMonitor(event.getMonitor());
            } else if (i == 2) {
                mergeReader(event.getReader());
            }
            mergeUnknownFields(event.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            Event event = null;
            try {
                try {
                    Event event2 = (Event) Event.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (event2 != null) {
                        mergeFrom(event2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Event event3 = (Event) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        event = event3;
                        if (event != null) {
                            mergeFrom(event);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (event != null) {
                    mergeFrom(event);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public PayloadCase getPayloadCase() {
            return PayloadCase.forNumber(this.payloadCase_);
        }

        public Builder clearPayload() {
            this.payloadCase_ = 0;
            this.payload_ = null;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public boolean hasMonitor() {
            return this.payloadCase_ == 1;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public Monitor getMonitor() {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 1) {
                    return (Monitor) this.payload_;
                }
                return Monitor.getDefaultInstance();
            }
            if (this.payloadCase_ == 1) {
                return (Monitor) singleFieldBuilderV3.getMessage();
            }
            return Monitor.getDefaultInstance();
        }

        public Builder setMonitor(Monitor monitor) {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
            if (singleFieldBuilderV3 == null) {
                monitor.getClass();
                this.payload_ = monitor;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(monitor);
            }
            this.payloadCase_ = 1;
            return this;
        }

        public Builder setMonitor(Monitor.Builder builder) {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.payload_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.payloadCase_ = 1;
            return this;
        }

        public Builder mergeMonitor(Monitor monitor) {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 1 && this.payload_ != Monitor.getDefaultInstance()) {
                    this.payload_ = Monitor.newBuilder((Monitor) this.payload_).mergeFrom(monitor).buildPartial();
                } else {
                    this.payload_ = monitor;
                }
                onChanged();
            } else {
                if (this.payloadCase_ == 1) {
                    singleFieldBuilderV3.mergeFrom(monitor);
                }
                this.monitorBuilder_.setMessage(monitor);
            }
            this.payloadCase_ = 1;
            return this;
        }

        public Builder clearMonitor() {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3 = this.monitorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 1) {
                    this.payloadCase_ = 0;
                    this.payload_ = null;
                    onChanged();
                }
            } else {
                if (this.payloadCase_ == 1) {
                    this.payloadCase_ = 0;
                    this.payload_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Monitor.Builder getMonitorBuilder() {
            return (Monitor.Builder) getMonitorFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public MonitorOrBuilder getMonitorOrBuilder() {
            SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> singleFieldBuilderV3;
            int i = this.payloadCase_;
            if (i == 1 && (singleFieldBuilderV3 = this.monitorBuilder_) != null) {
                return (MonitorOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i == 1) {
                return (Monitor) this.payload_;
            }
            return Monitor.getDefaultInstance();
        }

        private SingleFieldBuilderV3<Monitor, Monitor.Builder, MonitorOrBuilder> getMonitorFieldBuilder() {
            if (this.monitorBuilder_ == null) {
                if (this.payloadCase_ != 1) {
                    this.payload_ = Monitor.getDefaultInstance();
                }
                this.monitorBuilder_ = new SingleFieldBuilderV3<>((Monitor) this.payload_, getParentForChildren(), isClean());
                this.payload_ = null;
            }
            this.payloadCase_ = 1;
            onChanged();
            return this.monitorBuilder_;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public boolean hasReader() {
            return this.payloadCase_ == 2;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public Reader getReader() {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3 = this.readerBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 2) {
                    return (Reader) this.payload_;
                }
                return Reader.getDefaultInstance();
            }
            if (this.payloadCase_ == 2) {
                return (Reader) singleFieldBuilderV3.getMessage();
            }
            return Reader.getDefaultInstance();
        }

        public Builder setReader(Reader reader) {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3 = this.readerBuilder_;
            if (singleFieldBuilderV3 == null) {
                reader.getClass();
                this.payload_ = reader;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(reader);
            }
            this.payloadCase_ = 2;
            return this;
        }

        public Builder setReader(Reader.Builder builder) {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3 = this.readerBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.payload_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.payloadCase_ = 2;
            return this;
        }

        public Builder mergeReader(Reader reader) {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3 = this.readerBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 2 && this.payload_ != Reader.getDefaultInstance()) {
                    this.payload_ = Reader.newBuilder((Reader) this.payload_).mergeFrom(reader).buildPartial();
                } else {
                    this.payload_ = reader;
                }
                onChanged();
            } else {
                if (this.payloadCase_ == 2) {
                    singleFieldBuilderV3.mergeFrom(reader);
                }
                this.readerBuilder_.setMessage(reader);
            }
            this.payloadCase_ = 2;
            return this;
        }

        public Builder clearReader() {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3 = this.readerBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadCase_ == 2) {
                    this.payloadCase_ = 0;
                    this.payload_ = null;
                    onChanged();
                }
            } else {
                if (this.payloadCase_ == 2) {
                    this.payloadCase_ = 0;
                    this.payload_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Reader.Builder getReaderBuilder() {
            return (Reader.Builder) getReaderFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public ReaderOrBuilder getReaderOrBuilder() {
            SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> singleFieldBuilderV3;
            int i = this.payloadCase_;
            if (i == 2 && (singleFieldBuilderV3 = this.readerBuilder_) != null) {
                return (ReaderOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i == 2) {
                return (Reader) this.payload_;
            }
            return Reader.getDefaultInstance();
        }

        private SingleFieldBuilderV3<Reader, Reader.Builder, ReaderOrBuilder> getReaderFieldBuilder() {
            if (this.readerBuilder_ == null) {
                if (this.payloadCase_ != 2) {
                    this.payload_ = Reader.getDefaultInstance();
                }
                this.readerBuilder_ = new SingleFieldBuilderV3<>((Reader) this.payload_, getParentForChildren(), isClean());
                this.payload_ = null;
            }
            this.payloadCase_ = 2;
            onChanged();
            return this.readerBuilder_;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public boolean hasExtrasPrivate() {
            return (this.extrasPrivateBuilder_ == null && this.extrasPrivate_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public Struct getExtrasPrivate() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.extrasPrivate_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return (Struct) singleFieldBuilderV3.getMessage();
        }

        public Builder setExtrasPrivate(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.extrasPrivate_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setExtrasPrivate(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.extrasPrivate_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeExtrasPrivate(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.extrasPrivate_;
                if (struct2 != null) {
                    this.extrasPrivate_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.extrasPrivate_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder clearExtrasPrivate() {
            if (this.extrasPrivateBuilder_ == null) {
                this.extrasPrivate_ = null;
                onChanged();
            } else {
                this.extrasPrivate_ = null;
                this.extrasPrivateBuilder_ = null;
            }
            return this;
        }

        public Struct.Builder getExtrasPrivateBuilder() {
            onChanged();
            return (Struct.Builder) getExtrasPrivateFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.EventOrBuilder
        public StructOrBuilder getExtrasPrivateOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extrasPrivateBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (StructOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.extrasPrivate_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getExtrasPrivateFieldBuilder() {
            if (this.extrasPrivateBuilder_ == null) {
                this.extrasPrivateBuilder_ = new SingleFieldBuilderV3<>(getExtrasPrivate(), getParentForChildren(), isClean());
                this.extrasPrivate_ = null;
            }
            return this.extrasPrivateBuilder_;
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

    /* JADX INFO: renamed from: io.bidmachine.protobuf.sdk.Event$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$sdk$Event$PayloadCase;

        static {
            int[] iArr = new int[PayloadCase.values().length];
            $SwitchMap$io$bidmachine$protobuf$sdk$Event$PayloadCase = iArr;
            try {
                iArr[PayloadCase.MONITOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$sdk$Event$PayloadCase[PayloadCase.READER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$sdk$Event$PayloadCase[PayloadCase.PAYLOAD_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Event> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Event> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Event getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
