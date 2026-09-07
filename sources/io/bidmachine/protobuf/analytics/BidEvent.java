package io.bidmachine.protobuf.analytics;

import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.AdOrBuilder;
import com.explorestack.protobuf.openrtb.Response;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class BidEvent extends GeneratedMessageV3 implements BidEventOrBuilder {
    public static final int AD_FIELD_NUMBER = 6;
    public static final int AUCTION_CONTEXT_FIELD_NUMBER = 4;
    public static final int BIDID_FIELD_NUMBER = 2;
    public static final int BID_FIELD_NUMBER = 5;
    private static final BidEvent DEFAULT_INSTANCE = new BidEvent();
    private static final Parser<BidEvent> PARSER = new AbstractParser<BidEvent>() { // from class: io.bidmachine.protobuf.analytics.BidEvent.1
        @Override // com.explorestack.protobuf.Parser
        public BidEvent parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BidEvent(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SEAT_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private Ad ad_;
    private AuctionContext auctionContext_;
    private Response.Seatbid.Bid bid_;
    private volatile Object bidid_;
    private byte memoizedIsInitialized;
    private volatile Object seat_;
    private volatile Object timestamp_;

    private BidEvent(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private BidEvent() {
        this.memoizedIsInitialized = (byte) -1;
        this.timestamp_ = "";
        this.bidid_ = "";
        this.seat_ = "";
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new BidEvent();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BidEvent(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.timestamp_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.bidid_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag != 26) {
                                if (tag == 34) {
                                    AuctionContext auctionContext = this.auctionContext_;
                                    AuctionContext.Builder builder = auctionContext != null ? auctionContext.toBuilder() : null;
                                    AuctionContext auctionContext2 = (AuctionContext) codedInputStream.readMessage(AuctionContext.parser(), extensionRegistryLite);
                                    this.auctionContext_ = auctionContext2;
                                    if (builder != null) {
                                        builder.mergeFrom(auctionContext2);
                                        this.auctionContext_ = builder.buildPartial();
                                    }
                                } else if (tag == 42) {
                                    Response.Seatbid.Bid bid = this.bid_;
                                    Response.Seatbid.Bid.Builder builder2 = bid != null ? bid.toBuilder() : null;
                                    Response.Seatbid.Bid bid2 = (Response.Seatbid.Bid) codedInputStream.readMessage(Response.Seatbid.Bid.parser(), extensionRegistryLite);
                                    this.bid_ = bid2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(bid2);
                                        this.bid_ = builder2.buildPartial();
                                    }
                                } else if (tag == 50) {
                                    Ad ad = this.ad_;
                                    Ad.Builder builder3 = ad != null ? ad.toBuilder() : null;
                                    Ad ad2 = (Ad) codedInputStream.readMessage(Ad.parser(), extensionRegistryLite);
                                    this.ad_ = ad2;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(ad2);
                                        this.ad_ = builder3.buildPartial();
                                    }
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.seat_ = codedInputStream.readStringRequireUtf8();
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
        return AnalyticsProto.internal_static_bidmachine_protobuf_analytics_BidEvent_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnalyticsProto.internal_static_bidmachine_protobuf_analytics_BidEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(BidEvent.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public String getTimestamp() {
        Object obj = this.timestamp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.timestamp_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public ByteString getTimestampBytes() {
        Object obj = this.timestamp_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.timestamp_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public String getBidid() {
        Object obj = this.bidid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bidid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public ByteString getBididBytes() {
        Object obj = this.bidid_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bidid_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public String getSeat() {
        Object obj = this.seat_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.seat_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public ByteString getSeatBytes() {
        Object obj = this.seat_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.seat_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public boolean hasAuctionContext() {
        return this.auctionContext_ != null;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public AuctionContext getAuctionContext() {
        AuctionContext auctionContext = this.auctionContext_;
        return auctionContext == null ? AuctionContext.getDefaultInstance() : auctionContext;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public AuctionContextOrBuilder getAuctionContextOrBuilder() {
        return getAuctionContext();
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public boolean hasBid() {
        return this.bid_ != null;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public Response.Seatbid.Bid getBid() {
        Response.Seatbid.Bid bid = this.bid_;
        return bid == null ? Response.Seatbid.Bid.getDefaultInstance() : bid;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public Response.Seatbid.BidOrBuilder getBidOrBuilder() {
        return getBid();
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public boolean hasAd() {
        return this.ad_ != null;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public Ad getAd() {
        Ad ad = this.ad_;
        return ad == null ? Ad.getDefaultInstance() : ad;
    }

    @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
    public AdOrBuilder getAdOrBuilder() {
        return getAd();
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
        if (!getTimestampBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.timestamp_);
        }
        if (!getBididBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.bidid_);
        }
        if (!getSeatBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.seat_);
        }
        if (this.auctionContext_ != null) {
            codedOutputStream.writeMessage(4, getAuctionContext());
        }
        if (this.bid_ != null) {
            codedOutputStream.writeMessage(5, getBid());
        }
        if (this.ad_ != null) {
            codedOutputStream.writeMessage(6, getAd());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !getTimestampBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.timestamp_) : 0;
        if (!getBididBytes().isEmpty()) {
            iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.bidid_);
        }
        if (!getSeatBytes().isEmpty()) {
            iComputeStringSize += GeneratedMessageV3.computeStringSize(3, this.seat_);
        }
        if (this.auctionContext_ != null) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(4, getAuctionContext());
        }
        if (this.bid_ != null) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(5, getBid());
        }
        if (this.ad_ != null) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(6, getAd());
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
        if (!(obj instanceof BidEvent)) {
            return super.equals(obj);
        }
        BidEvent bidEvent = (BidEvent) obj;
        if (!getTimestamp().equals(bidEvent.getTimestamp()) || !getBidid().equals(bidEvent.getBidid()) || !getSeat().equals(bidEvent.getSeat()) || hasAuctionContext() != bidEvent.hasAuctionContext()) {
            return false;
        }
        if ((hasAuctionContext() && !getAuctionContext().equals(bidEvent.getAuctionContext())) || hasBid() != bidEvent.hasBid()) {
            return false;
        }
        if ((!hasBid() || getBid().equals(bidEvent.getBid())) && hasAd() == bidEvent.hasAd()) {
            return (!hasAd() || getAd().equals(bidEvent.getAd())) && this.unknownFields.equals(bidEvent.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTimestamp().hashCode()) * 37) + 2) * 53) + getBidid().hashCode()) * 37) + 3) * 53) + getSeat().hashCode();
        if (hasAuctionContext()) {
            iHashCode = (((iHashCode * 37) + 4) * 53) + getAuctionContext().hashCode();
        }
        if (hasBid()) {
            iHashCode = (((iHashCode * 37) + 5) * 53) + getBid().hashCode();
        }
        if (hasAd()) {
            iHashCode = (((iHashCode * 37) + 6) * 53) + getAd().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static BidEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static BidEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BidEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static BidEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BidEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static BidEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BidEvent parseFrom(InputStream inputStream) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BidEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BidEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BidEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BidEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BidEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BidEvent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BidEvent bidEvent) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(bidEvent);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BidEventOrBuilder {
        private SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> adBuilder_;
        private Ad ad_;
        private SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> auctionContextBuilder_;
        private AuctionContext auctionContext_;
        private SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> bidBuilder_;
        private Response.Seatbid.Bid bid_;
        private Object bidid_;
        private Object seat_;
        private Object timestamp_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AnalyticsProto.internal_static_bidmachine_protobuf_analytics_BidEvent_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnalyticsProto.internal_static_bidmachine_protobuf_analytics_BidEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(BidEvent.class, Builder.class);
        }

        private Builder() {
            this.timestamp_ = "";
            this.bidid_ = "";
            this.seat_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.timestamp_ = "";
            this.bidid_ = "";
            this.seat_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = BidEvent.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.timestamp_ = "";
            this.bidid_ = "";
            this.seat_ = "";
            if (this.auctionContextBuilder_ == null) {
                this.auctionContext_ = null;
            } else {
                this.auctionContext_ = null;
                this.auctionContextBuilder_ = null;
            }
            if (this.bidBuilder_ == null) {
                this.bid_ = null;
            } else {
                this.bid_ = null;
                this.bidBuilder_ = null;
            }
            if (this.adBuilder_ == null) {
                this.ad_ = null;
            } else {
                this.ad_ = null;
                this.adBuilder_ = null;
            }
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AnalyticsProto.internal_static_bidmachine_protobuf_analytics_BidEvent_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public BidEvent getDefaultInstanceForType() {
            return BidEvent.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public BidEvent build() {
            BidEvent bidEventBuildPartial = buildPartial();
            if (bidEventBuildPartial.isInitialized()) {
                return bidEventBuildPartial;
            }
            throw newUninitializedMessageException((Message) bidEventBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public BidEvent buildPartial() {
            BidEvent bidEvent = new BidEvent(this);
            bidEvent.timestamp_ = this.timestamp_;
            bidEvent.bidid_ = this.bidid_;
            bidEvent.seat_ = this.seat_;
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                bidEvent.auctionContext_ = this.auctionContext_;
            } else {
                bidEvent.auctionContext_ = (AuctionContext) singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV4 = this.bidBuilder_;
            if (singleFieldBuilderV4 == null) {
                bidEvent.bid_ = this.bid_;
            } else {
                bidEvent.bid_ = (Response.Seatbid.Bid) singleFieldBuilderV4.build();
            }
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV5 = this.adBuilder_;
            if (singleFieldBuilderV5 == null) {
                bidEvent.ad_ = this.ad_;
            } else {
                bidEvent.ad_ = (Ad) singleFieldBuilderV5.build();
            }
            onBuilt();
            return bidEvent;
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
            if (message instanceof BidEvent) {
                return mergeFrom((BidEvent) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(BidEvent bidEvent) {
            if (bidEvent == BidEvent.getDefaultInstance()) {
                return this;
            }
            if (!bidEvent.getTimestamp().isEmpty()) {
                this.timestamp_ = bidEvent.timestamp_;
                onChanged();
            }
            if (!bidEvent.getBidid().isEmpty()) {
                this.bidid_ = bidEvent.bidid_;
                onChanged();
            }
            if (!bidEvent.getSeat().isEmpty()) {
                this.seat_ = bidEvent.seat_;
                onChanged();
            }
            if (bidEvent.hasAuctionContext()) {
                mergeAuctionContext(bidEvent.getAuctionContext());
            }
            if (bidEvent.hasBid()) {
                mergeBid(bidEvent.getBid());
            }
            if (bidEvent.hasAd()) {
                mergeAd(bidEvent.getAd());
            }
            mergeUnknownFields(bidEvent.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            BidEvent bidEvent = null;
            try {
                try {
                    BidEvent bidEvent2 = (BidEvent) BidEvent.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (bidEvent2 != null) {
                        mergeFrom(bidEvent2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    BidEvent bidEvent3 = (BidEvent) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        bidEvent = bidEvent3;
                        if (bidEvent != null) {
                            mergeFrom(bidEvent);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bidEvent != null) {
                    mergeFrom(bidEvent);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public String getTimestamp() {
            Object obj = this.timestamp_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.timestamp_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public ByteString getTimestampBytes() {
            Object obj = this.timestamp_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timestamp_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTimestamp(String str) {
            str.getClass();
            this.timestamp_ = str;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.timestamp_ = BidEvent.getDefaultInstance().getTimestamp();
            onChanged();
            return this;
        }

        public Builder setTimestampBytes(ByteString byteString) {
            byteString.getClass();
            BidEvent.checkByteStringIsUtf8(byteString);
            this.timestamp_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public String getBidid() {
            Object obj = this.bidid_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bidid_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public ByteString getBididBytes() {
            Object obj = this.bidid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bidid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setBidid(String str) {
            str.getClass();
            this.bidid_ = str;
            onChanged();
            return this;
        }

        public Builder clearBidid() {
            this.bidid_ = BidEvent.getDefaultInstance().getBidid();
            onChanged();
            return this;
        }

        public Builder setBididBytes(ByteString byteString) {
            byteString.getClass();
            BidEvent.checkByteStringIsUtf8(byteString);
            this.bidid_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public String getSeat() {
            Object obj = this.seat_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.seat_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public ByteString getSeatBytes() {
            Object obj = this.seat_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.seat_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSeat(String str) {
            str.getClass();
            this.seat_ = str;
            onChanged();
            return this;
        }

        public Builder clearSeat() {
            this.seat_ = BidEvent.getDefaultInstance().getSeat();
            onChanged();
            return this;
        }

        public Builder setSeatBytes(ByteString byteString) {
            byteString.getClass();
            BidEvent.checkByteStringIsUtf8(byteString);
            this.seat_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public boolean hasAuctionContext() {
            return (this.auctionContextBuilder_ == null && this.auctionContext_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public AuctionContext getAuctionContext() {
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                AuctionContext auctionContext = this.auctionContext_;
                return auctionContext == null ? AuctionContext.getDefaultInstance() : auctionContext;
            }
            return (AuctionContext) singleFieldBuilderV3.getMessage();
        }

        public Builder setAuctionContext(AuctionContext auctionContext) {
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                auctionContext.getClass();
                this.auctionContext_ = auctionContext;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(auctionContext);
            }
            return this;
        }

        public Builder setAuctionContext(AuctionContext.Builder builder) {
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.auctionContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeAuctionContext(AuctionContext auctionContext) {
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                AuctionContext auctionContext2 = this.auctionContext_;
                if (auctionContext2 != null) {
                    this.auctionContext_ = AuctionContext.newBuilder(auctionContext2).mergeFrom(auctionContext).buildPartial();
                } else {
                    this.auctionContext_ = auctionContext;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(auctionContext);
            }
            return this;
        }

        public Builder clearAuctionContext() {
            if (this.auctionContextBuilder_ == null) {
                this.auctionContext_ = null;
                onChanged();
            } else {
                this.auctionContext_ = null;
                this.auctionContextBuilder_ = null;
            }
            return this;
        }

        public AuctionContext.Builder getAuctionContextBuilder() {
            onChanged();
            return (AuctionContext.Builder) getAuctionContextFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public AuctionContextOrBuilder getAuctionContextOrBuilder() {
            SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> singleFieldBuilderV3 = this.auctionContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (AuctionContextOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            AuctionContext auctionContext = this.auctionContext_;
            return auctionContext == null ? AuctionContext.getDefaultInstance() : auctionContext;
        }

        private SingleFieldBuilderV3<AuctionContext, AuctionContext.Builder, AuctionContextOrBuilder> getAuctionContextFieldBuilder() {
            if (this.auctionContextBuilder_ == null) {
                this.auctionContextBuilder_ = new SingleFieldBuilderV3<>(getAuctionContext(), getParentForChildren(), isClean());
                this.auctionContext_ = null;
            }
            return this.auctionContextBuilder_;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public boolean hasBid() {
            return (this.bidBuilder_ == null && this.bid_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public Response.Seatbid.Bid getBid() {
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV3 = this.bidBuilder_;
            if (singleFieldBuilderV3 == null) {
                Response.Seatbid.Bid bid = this.bid_;
                return bid == null ? Response.Seatbid.Bid.getDefaultInstance() : bid;
            }
            return (Response.Seatbid.Bid) singleFieldBuilderV3.getMessage();
        }

        public Builder setBid(Response.Seatbid.Bid bid) {
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV3 = this.bidBuilder_;
            if (singleFieldBuilderV3 == null) {
                bid.getClass();
                this.bid_ = bid;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(bid);
            }
            return this;
        }

        public Builder setBid(Response.Seatbid.Bid.Builder builder) {
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV3 = this.bidBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.bid_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeBid(Response.Seatbid.Bid bid) {
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV3 = this.bidBuilder_;
            if (singleFieldBuilderV3 == null) {
                Response.Seatbid.Bid bid2 = this.bid_;
                if (bid2 != null) {
                    this.bid_ = Response.Seatbid.Bid.newBuilder(bid2).mergeFrom(bid).buildPartial();
                } else {
                    this.bid_ = bid;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(bid);
            }
            return this;
        }

        public Builder clearBid() {
            if (this.bidBuilder_ == null) {
                this.bid_ = null;
                onChanged();
            } else {
                this.bid_ = null;
                this.bidBuilder_ = null;
            }
            return this;
        }

        public Response.Seatbid.Bid.Builder getBidBuilder() {
            onChanged();
            return (Response.Seatbid.Bid.Builder) getBidFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public Response.Seatbid.BidOrBuilder getBidOrBuilder() {
            SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> singleFieldBuilderV3 = this.bidBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (Response.Seatbid.BidOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Response.Seatbid.Bid bid = this.bid_;
            return bid == null ? Response.Seatbid.Bid.getDefaultInstance() : bid;
        }

        private SingleFieldBuilderV3<Response.Seatbid.Bid, Response.Seatbid.Bid.Builder, Response.Seatbid.BidOrBuilder> getBidFieldBuilder() {
            if (this.bidBuilder_ == null) {
                this.bidBuilder_ = new SingleFieldBuilderV3<>(getBid(), getParentForChildren(), isClean());
                this.bid_ = null;
            }
            return this.bidBuilder_;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public boolean hasAd() {
            return (this.adBuilder_ == null && this.ad_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public Ad getAd() {
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV3 = this.adBuilder_;
            if (singleFieldBuilderV3 == null) {
                Ad ad = this.ad_;
                return ad == null ? Ad.getDefaultInstance() : ad;
            }
            return (Ad) singleFieldBuilderV3.getMessage();
        }

        public Builder setAd(Ad ad) {
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV3 = this.adBuilder_;
            if (singleFieldBuilderV3 == null) {
                ad.getClass();
                this.ad_ = ad;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(ad);
            }
            return this;
        }

        public Builder setAd(Ad.Builder builder) {
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV3 = this.adBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.ad_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeAd(Ad ad) {
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV3 = this.adBuilder_;
            if (singleFieldBuilderV3 == null) {
                Ad ad2 = this.ad_;
                if (ad2 != null) {
                    this.ad_ = Ad.newBuilder(ad2).mergeFrom(ad).buildPartial();
                } else {
                    this.ad_ = ad;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(ad);
            }
            return this;
        }

        public Builder clearAd() {
            if (this.adBuilder_ == null) {
                this.ad_ = null;
                onChanged();
            } else {
                this.ad_ = null;
                this.adBuilder_ = null;
            }
            return this;
        }

        public Ad.Builder getAdBuilder() {
            onChanged();
            return (Ad.Builder) getAdFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.analytics.BidEventOrBuilder
        public AdOrBuilder getAdOrBuilder() {
            SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> singleFieldBuilderV3 = this.adBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (AdOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Ad ad = this.ad_;
            return ad == null ? Ad.getDefaultInstance() : ad;
        }

        private SingleFieldBuilderV3<Ad, Ad.Builder, AdOrBuilder> getAdFieldBuilder() {
            if (this.adBuilder_ == null) {
                this.adBuilder_ = new SingleFieldBuilderV3<>(getAd(), getParentForChildren(), isClean());
                this.ad_ = null;
            }
            return this.adBuilder_;
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

    public static BidEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BidEvent> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<BidEvent> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public BidEvent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
