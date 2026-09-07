package io.bidmachine.protobuf.rendering;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.BoolValue;
import com.explorestack.protobuf.BoolValueOrBuilder;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
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
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.StringValueOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.WireFormat;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Rendering extends GeneratedMessageV3 implements RenderingOrBuilder {
    public static final int CACHE_TYPE_FIELD_NUMBER = 2;
    public static final int CUSTOM_PARAMS_FIELD_NUMBER = 4;
    public static final int ORIENTATION_FIELD_NUMBER = 1;
    public static final int PHASES_FIELD_NUMBER = 3;
    public static final int PRODUCT_CONFIGURATION_FIELD_NUMBER = 6;
    public static final int SK_AD_NETWORK_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int cacheType_;
    private MapField<String, String> customParams_;
    private byte memoizedIsInitialized;
    private int orientation_;
    private List<Phase> phases_;
    private ProductConfiguration productConfiguration_;
    private SKStoreConfiguration skAdNetwork_;
    private static final Rendering DEFAULT_INSTANCE = new Rendering();
    private static final Parser<Rendering> PARSER = new AbstractParser<Rendering>() { // from class: io.bidmachine.protobuf.rendering.Rendering.1
        @Override // com.explorestack.protobuf.Parser
        public Rendering parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Rendering(codedInputStream, extensionRegistryLite);
        }
    };

    public interface PhaseOrBuilder extends MessageOrBuilder {
        boolean containsCustomParams(String str);

        Phase.ViewComponent getAds(int i);

        int getAdsCount();

        List<Phase.ViewComponent> getAdsList();

        Phase.ViewComponentOrBuilder getAdsOrBuilder(int i);

        List<? extends Phase.ViewComponentOrBuilder> getAdsOrBuilderList();

        String getBackgroundColor();

        ByteString getBackgroundColorBytes();

        Phase.ViewComponent getControls(int i);

        int getControlsCount();

        List<Phase.ViewComponent> getControlsList();

        Phase.ViewComponentOrBuilder getControlsOrBuilder(int i);

        List<? extends Phase.ViewComponentOrBuilder> getControlsOrBuilderList();

        @Deprecated
        Map<String, String> getCustomParams();

        int getCustomParamsCount();

        Map<String, String> getCustomParamsMap();

        String getCustomParamsOrDefault(String str, String str2);

        String getCustomParamsOrThrow(String str);

        Phase.Event getEvents(int i);

        int getEventsCount();

        List<Phase.Event> getEventsList();

        Phase.EventOrBuilder getEventsOrBuilder(int i);

        List<? extends Phase.EventOrBuilder> getEventsOrBuilderList();

        Phase.MethodComponent getMethods(int i);

        int getMethodsCount();

        List<Phase.MethodComponent> getMethodsList();

        Phase.MethodComponentOrBuilder getMethodsOrBuilder(int i);

        List<? extends Phase.MethodComponentOrBuilder> getMethodsOrBuilderList();

        int getSequence();
    }

    public interface ProductConfigurationOrBuilder extends MessageOrBuilder {
        BoolValue getAllowStorekitSubclass();

        BoolValueOrBuilder getAllowStorekitSubclassOrBuilder();

        BoolValue getShouldRemoveStoreAfterPresent();

        BoolValueOrBuilder getShouldRemoveStoreAfterPresentOrBuilder();

        boolean hasAllowStorekitSubclass();

        boolean hasShouldRemoveStoreAfterPresent();
    }

    public interface SKStoreConfigurationOrBuilder extends MessageOrBuilder {
        StringValue getAdcampaignIdentifier();

        StringValueOrBuilder getAdcampaignIdentifierOrBuilder();

        StringValue getAdnetworkIdentifier();

        StringValueOrBuilder getAdnetworkIdentifierOrBuilder();

        StringValue getAdvertisedAppstoreItemIdentifier();

        StringValueOrBuilder getAdvertisedAppstoreItemIdentifierOrBuilder();

        SKStoreConfiguration.Fidelity getFidelities(int i);

        int getFidelitiesCount();

        List<SKStoreConfiguration.Fidelity> getFidelitiesList();

        SKStoreConfiguration.FidelityOrBuilder getFidelitiesOrBuilder(int i);

        List<? extends SKStoreConfiguration.FidelityOrBuilder> getFidelitiesOrBuilderList();

        StringValue getNonce();

        StringValueOrBuilder getNonceOrBuilder();

        StringValue getProductPageId();

        StringValueOrBuilder getProductPageIdOrBuilder();

        StringValue getSignature();

        StringValueOrBuilder getSignatureOrBuilder();

        StringValue getSourceAppstoreItemIdentifier();

        StringValueOrBuilder getSourceAppstoreItemIdentifierOrBuilder();

        StringValue getSourceIdentifier();

        StringValueOrBuilder getSourceIdentifierOrBuilder();

        StringValue getTimestamp();

        StringValueOrBuilder getTimestampOrBuilder();

        StringValue getVersion();

        StringValueOrBuilder getVersionOrBuilder();

        boolean hasAdcampaignIdentifier();

        boolean hasAdnetworkIdentifier();

        boolean hasAdvertisedAppstoreItemIdentifier();

        boolean hasNonce();

        boolean hasProductPageId();

        boolean hasSignature();

        boolean hasSourceAppstoreItemIdentifier();

        boolean hasSourceIdentifier();

        boolean hasTimestamp();

        boolean hasVersion();
    }

    private Rendering(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Rendering() {
        this.memoizedIsInitialized = (byte) -1;
        this.orientation_ = 0;
        this.cacheType_ = 0;
        this.phases_ = Collections.emptyList();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Rendering();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Rendering(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.orientation_ = codedInputStream.readEnum();
                            } else if (tag == 16) {
                                this.cacheType_ = codedInputStream.readEnum();
                            } else if (tag == 26) {
                                int i2 = (i == true ? 1 : 0) & 1;
                                i = i;
                                if (i2 == 0) {
                                    this.phases_ = new ArrayList();
                                    i = (i == true ? 1 : 0) | 1;
                                }
                                this.phases_.add((Phase) codedInputStream.readMessage(Phase.parser(), extensionRegistryLite));
                            } else if (tag != 34) {
                                if (tag == 42) {
                                    SKStoreConfiguration sKStoreConfiguration = this.skAdNetwork_;
                                    SKStoreConfiguration.Builder builder = sKStoreConfiguration != null ? sKStoreConfiguration.toBuilder() : null;
                                    SKStoreConfiguration sKStoreConfiguration2 = (SKStoreConfiguration) codedInputStream.readMessage(SKStoreConfiguration.parser(), extensionRegistryLite);
                                    this.skAdNetwork_ = sKStoreConfiguration2;
                                    if (builder != null) {
                                        builder.mergeFrom(sKStoreConfiguration2);
                                        this.skAdNetwork_ = builder.buildPartial();
                                    }
                                } else if (tag == 50) {
                                    ProductConfiguration productConfiguration = this.productConfiguration_;
                                    ProductConfiguration.Builder builder2 = productConfiguration != null ? productConfiguration.toBuilder() : null;
                                    ProductConfiguration productConfiguration2 = (ProductConfiguration) codedInputStream.readMessage(ProductConfiguration.parser(), extensionRegistryLite);
                                    this.productConfiguration_ = productConfiguration2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(productConfiguration2);
                                        this.productConfiguration_ = builder2.buildPartial();
                                    }
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            } else {
                                int i3 = (i == true ? 1 : 0) & 2;
                                i = i;
                                if (i3 == 0) {
                                    this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
                                    i = (i == true ? 1 : 0) | 2;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(CustomParamsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.customParams_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
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
                if (((i == true ? 1 : 0) & 1) != 0) {
                    this.phases_ = Collections.unmodifiableList(this.phases_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (((i == true ? 1 : 0) & 1) != 0) {
            this.phases_ = Collections.unmodifiableList(this.phases_);
        }
        this.unknownFields = builderNewBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected MapField internalGetMapField(int i) {
        if (i == 4) {
            return internalGetCustomParams();
        }
        throw new RuntimeException("Invalid map field number: " + i);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_fieldAccessorTable.ensureFieldAccessorsInitialized(Rendering.class, Builder.class);
    }

    public enum Orientation implements ProtocolMessageEnum {
        ORIENTATION_INVALID(0),
        ORIENTATION_PORTRAIT(1),
        ORIENTATION_LANDSCAPE(2),
        ORIENTATION_SYSTEM(3),
        UNRECOGNIZED(-1);

        public static final int ORIENTATION_INVALID_VALUE = 0;
        public static final int ORIENTATION_LANDSCAPE_VALUE = 2;
        public static final int ORIENTATION_PORTRAIT_VALUE = 1;
        public static final int ORIENTATION_SYSTEM_VALUE = 3;
        private final int value;
        private static final Internal.EnumLiteMap<Orientation> internalValueMap = new Internal.EnumLiteMap<Orientation>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Orientation.1
            @Override // com.explorestack.protobuf.Internal.EnumLiteMap
            public Orientation findValueByNumber(int i) {
                return Orientation.forNumber(i);
            }
        };
        private static final Orientation[] VALUES = values();

        @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static Orientation valueOf(int i) {
            return forNumber(i);
        }

        public static Orientation forNumber(int i) {
            if (i == 0) {
                return ORIENTATION_INVALID;
            }
            if (i == 1) {
                return ORIENTATION_PORTRAIT;
            }
            if (i == 2) {
                return ORIENTATION_LANDSCAPE;
            }
            if (i != 3) {
                return null;
            }
            return ORIENTATION_SYSTEM;
        }

        public static Internal.EnumLiteMap<Orientation> internalGetValueMap() {
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
            return Rendering.getDescriptor().getEnumTypes().get(0);
        }

        public static Orientation valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        Orientation(int i) {
            this.value = i;
        }
    }

    public enum CacheType implements ProtocolMessageEnum {
        CACHE_TYPE_INVALID(0),
        CACHE_TYPE_FULL_LOAD(1),
        CACHE_TYPE_PARTIAL_LOAD(2),
        CACHE_TYPE_STREAM_LOAD(3),
        UNRECOGNIZED(-1);

        public static final int CACHE_TYPE_FULL_LOAD_VALUE = 1;
        public static final int CACHE_TYPE_INVALID_VALUE = 0;
        public static final int CACHE_TYPE_PARTIAL_LOAD_VALUE = 2;
        public static final int CACHE_TYPE_STREAM_LOAD_VALUE = 3;
        private final int value;
        private static final Internal.EnumLiteMap<CacheType> internalValueMap = new Internal.EnumLiteMap<CacheType>() { // from class: io.bidmachine.protobuf.rendering.Rendering.CacheType.1
            @Override // com.explorestack.protobuf.Internal.EnumLiteMap
            public CacheType findValueByNumber(int i) {
                return CacheType.forNumber(i);
            }
        };
        private static final CacheType[] VALUES = values();

        @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static CacheType valueOf(int i) {
            return forNumber(i);
        }

        public static CacheType forNumber(int i) {
            if (i == 0) {
                return CACHE_TYPE_INVALID;
            }
            if (i == 1) {
                return CACHE_TYPE_FULL_LOAD;
            }
            if (i == 2) {
                return CACHE_TYPE_PARTIAL_LOAD;
            }
            if (i != 3) {
                return null;
            }
            return CACHE_TYPE_STREAM_LOAD;
        }

        public static Internal.EnumLiteMap<CacheType> internalGetValueMap() {
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
            return Rendering.getDescriptor().getEnumTypes().get(1);
        }

        public static CacheType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        CacheType(int i) {
            this.value = i;
        }
    }

    public static final class Phase extends GeneratedMessageV3 implements PhaseOrBuilder {
        public static final int ADS_FIELD_NUMBER = 3;
        public static final int BACKGROUND_COLOR_FIELD_NUMBER = 2;
        public static final int CONTROLS_FIELD_NUMBER = 4;
        public static final int CUSTOM_PARAMS_FIELD_NUMBER = 7;
        public static final int EVENTS_FIELD_NUMBER = 6;
        public static final int METHODS_FIELD_NUMBER = 5;
        public static final int SEQUENCE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<ViewComponent> ads_;
        private volatile Object backgroundColor_;
        private List<ViewComponent> controls_;
        private MapField<String, String> customParams_;
        private List<Event> events_;
        private byte memoizedIsInitialized;
        private List<MethodComponent> methods_;
        private int sequence_;
        private static final Phase DEFAULT_INSTANCE = new Phase();
        private static final Parser<Phase> PARSER = new AbstractParser<Phase>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.1
            @Override // com.explorestack.protobuf.Parser
            public Phase parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Phase(codedInputStream, extensionRegistryLite);
            }
        };

        public interface EventOrBuilder extends MessageOrBuilder {
            Event.EventName getName();

            int getNameValue();

            String getSource();

            ByteString getSourceBytes();

            Event.Task getTasks(int i);

            int getTasksCount();

            List<Event.Task> getTasksList();

            Event.TaskOrBuilder getTasksOrBuilder(int i);

            List<? extends Event.TaskOrBuilder> getTasksOrBuilderList();
        }

        public interface MethodComponentOrBuilder extends MessageOrBuilder {
            String getName();

            ByteString getNameBytes();
        }

        public interface ViewComponentOrBuilder extends MessageOrBuilder {
            boolean containsCustomParams(String str);

            ViewComponent.Appearance getAppearance();

            ViewComponent.AppearanceOrBuilder getAppearanceOrBuilder();

            @Deprecated
            Map<String, String> getCustomParams();

            int getCustomParamsCount();

            Map<String, String> getCustomParamsMap();

            String getCustomParamsOrDefault(String str, String str2);

            String getCustomParamsOrThrow(String str);

            ViewComponent.Layout getLayout();

            ViewComponent.LayoutOrBuilder getLayoutOrBuilder();

            ViewComponent.Measurer getMeasurers(int i);

            int getMeasurersCount();

            List<ViewComponent.Measurer> getMeasurersList();

            ViewComponent.MeasurerOrBuilder getMeasurersOrBuilder(int i);

            List<? extends ViewComponent.MeasurerOrBuilder> getMeasurersOrBuilderList();

            String getName();

            ByteString getNameBytes();

            String getPlaceholder();

            ByteString getPlaceholderBytes();

            String getSource();

            ByteString getSourceBytes();

            ViewComponent.ViewComponentType getType();

            int getTypeValue();

            boolean hasAppearance();

            boolean hasLayout();
        }

        private Phase(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Phase() {
            this.memoizedIsInitialized = (byte) -1;
            this.backgroundColor_ = "";
            this.ads_ = Collections.emptyList();
            this.controls_ = Collections.emptyList();
            this.methods_ = Collections.emptyList();
            this.events_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Phase();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Phase(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.sequence_ = codedInputStream.readInt32();
                            } else if (tag == 18) {
                                this.backgroundColor_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 26) {
                                if ((i & 1) == 0) {
                                    this.ads_ = new ArrayList();
                                    i |= 1;
                                }
                                this.ads_.add((ViewComponent) codedInputStream.readMessage(ViewComponent.parser(), extensionRegistryLite));
                            } else if (tag == 34) {
                                if ((i & 2) == 0) {
                                    this.controls_ = new ArrayList();
                                    i |= 2;
                                }
                                this.controls_.add((ViewComponent) codedInputStream.readMessage(ViewComponent.parser(), extensionRegistryLite));
                            } else if (tag == 42) {
                                if ((i & 4) == 0) {
                                    this.methods_ = new ArrayList();
                                    i |= 4;
                                }
                                this.methods_.add((MethodComponent) codedInputStream.readMessage(MethodComponent.parser(), extensionRegistryLite));
                            } else if (tag == 50) {
                                if ((i & 8) == 0) {
                                    this.events_ = new ArrayList();
                                    i |= 8;
                                }
                                this.events_.add((Event) codedInputStream.readMessage(Event.parser(), extensionRegistryLite));
                            } else if (tag == 58) {
                                if ((i & 16) == 0) {
                                    this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
                                    i |= 16;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(CustomParamsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.customParams_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
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
                        this.ads_ = Collections.unmodifiableList(this.ads_);
                    }
                    if ((i & 2) != 0) {
                        this.controls_ = Collections.unmodifiableList(this.controls_);
                    }
                    if ((i & 4) != 0) {
                        this.methods_ = Collections.unmodifiableList(this.methods_);
                    }
                    if ((i & 8) != 0) {
                        this.events_ = Collections.unmodifiableList(this.events_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if ((i & 1) != 0) {
                this.ads_ = Collections.unmodifiableList(this.ads_);
            }
            if ((i & 2) != 0) {
                this.controls_ = Collections.unmodifiableList(this.controls_);
            }
            if ((i & 4) != 0) {
                this.methods_ = Collections.unmodifiableList(this.methods_);
            }
            if ((i & 8) != 0) {
                this.events_ = Collections.unmodifiableList(this.events_);
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 7) {
                return internalGetCustomParams();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_fieldAccessorTable.ensureFieldAccessorsInitialized(Phase.class, Builder.class);
        }

        public static final class ViewComponent extends GeneratedMessageV3 implements ViewComponentOrBuilder {
            public static final int APPEARANCE_FIELD_NUMBER = 7;
            public static final int CUSTOM_PARAMS_FIELD_NUMBER = 5;
            public static final int LAYOUT_FIELD_NUMBER = 6;
            public static final int MEASURERS_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int PLACEHOLDER_FIELD_NUMBER = 4;
            public static final int SOURCE_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private Appearance appearance_;
            private MapField<String, String> customParams_;
            private Layout layout_;
            private List<Measurer> measurers_;
            private byte memoizedIsInitialized;
            private volatile Object name_;
            private volatile Object placeholder_;
            private volatile Object source_;
            private int type_;
            private static final ViewComponent DEFAULT_INSTANCE = new ViewComponent();
            private static final Parser<ViewComponent> PARSER = new AbstractParser<ViewComponent>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.1
                @Override // com.explorestack.protobuf.Parser
                public ViewComponent parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new ViewComponent(codedInputStream, extensionRegistryLite);
                }
            };

            public interface AppearanceOrBuilder extends MessageOrBuilder {
                String getBackgroundColor();

                ByteString getBackgroundColorBytes();

                boolean getClickable();

                String getFontStyle();

                ByteString getFontStyleBytes();

                double getOpacity();

                boolean getOutlined();

                String getPadding();

                ByteString getPaddingBytes();

                String getShadowColor();

                ByteString getShadowColorBytes();

                String getStrokeColor();

                ByteString getStrokeColorBytes();

                double getStrokeWidth();

                boolean getVisible();
            }

            public interface LayoutOrBuilder extends MessageOrBuilder {
                Layout.Constraint getConstraints(int i);

                int getConstraintsCount();

                List<Layout.Constraint> getConstraintsList();

                Layout.ConstraintOrBuilder getConstraintsOrBuilder(int i);

                List<? extends Layout.ConstraintOrBuilder> getConstraintsOrBuilderList();
            }

            public interface MeasurerOrBuilder extends MessageOrBuilder {
                boolean containsParameters(String str);

                String getName();

                ByteString getNameBytes();

                @Deprecated
                Map<String, String> getParameters();

                int getParametersCount();

                Map<String, String> getParametersMap();

                String getParametersOrDefault(String str, String str2);

                String getParametersOrThrow(String str);
            }

            private ViewComponent(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private ViewComponent() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
                this.type_ = 0;
                this.source_ = "";
                this.placeholder_ = "";
                this.measurers_ = Collections.emptyList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new ViewComponent();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private ViewComponent(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 16) {
                                    this.type_ = codedInputStream.readEnum();
                                } else if (tag == 26) {
                                    this.source_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.placeholder_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag != 42) {
                                    if (tag == 50) {
                                        Layout layout = this.layout_;
                                        Layout.Builder builder = layout != null ? layout.toBuilder() : null;
                                        Layout layout2 = (Layout) codedInputStream.readMessage(Layout.parser(), extensionRegistryLite);
                                        this.layout_ = layout2;
                                        if (builder != null) {
                                            builder.mergeFrom(layout2);
                                            this.layout_ = builder.buildPartial();
                                        }
                                    } else if (tag == 58) {
                                        Appearance appearance = this.appearance_;
                                        Appearance.Builder builder2 = appearance != null ? appearance.toBuilder() : null;
                                        Appearance appearance2 = (Appearance) codedInputStream.readMessage(Appearance.parser(), extensionRegistryLite);
                                        this.appearance_ = appearance2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(appearance2);
                                            this.appearance_ = builder2.buildPartial();
                                        }
                                    } else if (tag == 66) {
                                        int i2 = (i == true ? 1 : 0) & 2;
                                        i = i;
                                        if (i2 == 0) {
                                            this.measurers_ = new ArrayList();
                                            i = (i == true ? 1 : 0) | 2;
                                        }
                                        this.measurers_.add((Measurer) codedInputStream.readMessage(Measurer.parser(), extensionRegistryLite));
                                    } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    int i3 = (i == true ? 1 : 0) & 1;
                                    i = i;
                                    if (i3 == 0) {
                                        this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
                                        i = (i == true ? 1 : 0) | 1;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(CustomParamsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                    this.customParams_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (((i == true ? 1 : 0) & 2) != 0) {
                            this.measurers_ = Collections.unmodifiableList(this.measurers_);
                        }
                        this.unknownFields = builderNewBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (((i == true ? 1 : 0) & 2) != 0) {
                    this.measurers_ = Collections.unmodifiableList(this.measurers_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected MapField internalGetMapField(int i) {
                if (i == 5) {
                    return internalGetCustomParams();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_fieldAccessorTable.ensureFieldAccessorsInitialized(ViewComponent.class, Builder.class);
            }

            public enum ViewComponentType implements ProtocolMessageEnum {
                VIEW_COMPONENT_TYPE_INVALID(0),
                VIEW_COMPONENT_TYPE_VIDEO(1),
                VIEW_COMPONENT_TYPE_MRAID(2),
                VIEW_COMPONENT_TYPE_IMAGE(3),
                VIEW_COMPONENT_TYPE_COUNTDOWN(4),
                VIEW_COMPONENT_TYPE_PROGRESS(5),
                VIEW_COMPONENT_TYPE_COUNTDOWN_TEXT(6),
                VIEW_COMPONENT_TYPE_MUTE(7),
                VIEW_COMPONENT_TYPE_UNMUTE(8),
                VIEW_COMPONENT_TYPE_CROSS(9),
                VIEW_COMPONENT_TYPE_SKIP(10),
                VIEW_COMPONENT_TYPE_CTA(11),
                UNRECOGNIZED(-1);

                public static final int VIEW_COMPONENT_TYPE_COUNTDOWN_TEXT_VALUE = 6;
                public static final int VIEW_COMPONENT_TYPE_COUNTDOWN_VALUE = 4;
                public static final int VIEW_COMPONENT_TYPE_CROSS_VALUE = 9;
                public static final int VIEW_COMPONENT_TYPE_CTA_VALUE = 11;
                public static final int VIEW_COMPONENT_TYPE_IMAGE_VALUE = 3;
                public static final int VIEW_COMPONENT_TYPE_INVALID_VALUE = 0;
                public static final int VIEW_COMPONENT_TYPE_MRAID_VALUE = 2;
                public static final int VIEW_COMPONENT_TYPE_MUTE_VALUE = 7;
                public static final int VIEW_COMPONENT_TYPE_PROGRESS_VALUE = 5;
                public static final int VIEW_COMPONENT_TYPE_SKIP_VALUE = 10;
                public static final int VIEW_COMPONENT_TYPE_UNMUTE_VALUE = 8;
                public static final int VIEW_COMPONENT_TYPE_VIDEO_VALUE = 1;
                private final int value;
                private static final Internal.EnumLiteMap<ViewComponentType> internalValueMap = new Internal.EnumLiteMap<ViewComponentType>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.ViewComponentType.1
                    @Override // com.explorestack.protobuf.Internal.EnumLiteMap
                    public ViewComponentType findValueByNumber(int i) {
                        return ViewComponentType.forNumber(i);
                    }
                };
                private static final ViewComponentType[] VALUES = values();

                @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static ViewComponentType valueOf(int i) {
                    return forNumber(i);
                }

                public static ViewComponentType forNumber(int i) {
                    switch (i) {
                        case 0:
                            return VIEW_COMPONENT_TYPE_INVALID;
                        case 1:
                            return VIEW_COMPONENT_TYPE_VIDEO;
                        case 2:
                            return VIEW_COMPONENT_TYPE_MRAID;
                        case 3:
                            return VIEW_COMPONENT_TYPE_IMAGE;
                        case 4:
                            return VIEW_COMPONENT_TYPE_COUNTDOWN;
                        case 5:
                            return VIEW_COMPONENT_TYPE_PROGRESS;
                        case 6:
                            return VIEW_COMPONENT_TYPE_COUNTDOWN_TEXT;
                        case 7:
                            return VIEW_COMPONENT_TYPE_MUTE;
                        case 8:
                            return VIEW_COMPONENT_TYPE_UNMUTE;
                        case 9:
                            return VIEW_COMPONENT_TYPE_CROSS;
                        case 10:
                            return VIEW_COMPONENT_TYPE_SKIP;
                        case 11:
                            return VIEW_COMPONENT_TYPE_CTA;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<ViewComponentType> internalGetValueMap() {
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
                    return ViewComponent.getDescriptor().getEnumTypes().get(0);
                }

                public static ViewComponentType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                    if (enumValueDescriptor.getType() != getDescriptor()) {
                        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                    }
                    if (enumValueDescriptor.getIndex() == -1) {
                        return UNRECOGNIZED;
                    }
                    return VALUES[enumValueDescriptor.getIndex()];
                }

                ViewComponentType(int i) {
                    this.value = i;
                }
            }

            public static final class Layout extends GeneratedMessageV3 implements LayoutOrBuilder {
                public static final int CONSTRAINTS_FIELD_NUMBER = 1;
                private static final Layout DEFAULT_INSTANCE = new Layout();
                private static final Parser<Layout> PARSER = new AbstractParser<Layout>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.1
                    @Override // com.explorestack.protobuf.Parser
                    public Layout parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Layout(codedInputStream, extensionRegistryLite);
                    }
                };
                private static final long serialVersionUID = 0;
                private List<Constraint> constraints_;
                private byte memoizedIsInitialized;

                public interface ConstraintOrBuilder extends MessageOrBuilder {
                    double getMultiplier();

                    Constraint.Anchor getSourceAnchor();

                    int getSourceAnchorValue();

                    String getTarget();

                    Constraint.Anchor getTargetAnchor();

                    int getTargetAnchorValue();

                    ByteString getTargetBytes();

                    double getValue();
                }

                private Layout(GeneratedMessageV3.Builder<?> builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                }

                private Layout() {
                    this.memoizedIsInitialized = (byte) -1;
                    this.constraints_ = Collections.emptyList();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                    return new Layout();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
                public final UnknownFieldSet getUnknownFields() {
                    return this.unknownFields;
                }

                private Layout(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                            this.constraints_ = new ArrayList();
                                            z2 = true;
                                        }
                                        this.constraints_.add((Constraint) codedInputStream.readMessage(Constraint.parser(), extensionRegistryLite));
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
                                this.constraints_ = Collections.unmodifiableList(this.constraints_);
                            }
                            this.unknownFields = builderNewBuilder.build();
                            makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2) {
                        this.constraints_ = Collections.unmodifiableList(this.constraints_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_fieldAccessorTable.ensureFieldAccessorsInitialized(Layout.class, Builder.class);
                }

                public static final class Constraint extends GeneratedMessageV3 implements ConstraintOrBuilder {
                    public static final int MULTIPLIER_FIELD_NUMBER = 5;
                    public static final int SOURCE_ANCHOR_FIELD_NUMBER = 1;
                    public static final int TARGET_ANCHOR_FIELD_NUMBER = 2;
                    public static final int TARGET_FIELD_NUMBER = 3;
                    public static final int VALUE_FIELD_NUMBER = 4;
                    private static final long serialVersionUID = 0;
                    private byte memoizedIsInitialized;
                    private double multiplier_;
                    private int sourceAnchor_;
                    private int targetAnchor_;
                    private volatile Object target_;
                    private double value_;
                    private static final Constraint DEFAULT_INSTANCE = new Constraint();
                    private static final Parser<Constraint> PARSER = new AbstractParser<Constraint>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.Constraint.1
                        @Override // com.explorestack.protobuf.Parser
                        public Constraint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return new Constraint(codedInputStream, extensionRegistryLite);
                        }
                    };

                    private Constraint(GeneratedMessageV3.Builder<?> builder) {
                        super(builder);
                        this.memoizedIsInitialized = (byte) -1;
                    }

                    private Constraint() {
                        this.memoizedIsInitialized = (byte) -1;
                        this.sourceAnchor_ = 0;
                        this.targetAnchor_ = 0;
                        this.target_ = "";
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3
                    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                        return new Constraint();
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
                    public final UnknownFieldSet getUnknownFields() {
                        return this.unknownFields;
                    }

                    private Constraint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                                this.sourceAnchor_ = codedInputStream.readEnum();
                                            } else if (tag == 16) {
                                                this.targetAnchor_ = codedInputStream.readEnum();
                                            } else if (tag == 26) {
                                                this.target_ = codedInputStream.readStringRequireUtf8();
                                            } else if (tag == 33) {
                                                this.value_ = codedInputStream.readDouble();
                                            } else if (tag == 41) {
                                                this.multiplier_ = codedInputStream.readDouble();
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
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_descriptor;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_fieldAccessorTable.ensureFieldAccessorsInitialized(Constraint.class, Builder.class);
                    }

                    public enum Anchor implements ProtocolMessageEnum {
                        ANCHOR_INVALID(0),
                        ANCHOR_LEFT(1),
                        ANCHOR_RIGHT(2),
                        ANCHOR_TOP(3),
                        ANCHOR_BOTTOM(4),
                        ANCHOR_CENTER_X(5),
                        ANCHOR_CENTER_Y(6),
                        ANCHOR_WIDTH(7),
                        ANCHOR_HEIGHT(8),
                        UNRECOGNIZED(-1);

                        public static final int ANCHOR_BOTTOM_VALUE = 4;
                        public static final int ANCHOR_CENTER_X_VALUE = 5;
                        public static final int ANCHOR_CENTER_Y_VALUE = 6;
                        public static final int ANCHOR_HEIGHT_VALUE = 8;
                        public static final int ANCHOR_INVALID_VALUE = 0;
                        public static final int ANCHOR_LEFT_VALUE = 1;
                        public static final int ANCHOR_RIGHT_VALUE = 2;
                        public static final int ANCHOR_TOP_VALUE = 3;
                        public static final int ANCHOR_WIDTH_VALUE = 7;
                        private final int value;
                        private static final Internal.EnumLiteMap<Anchor> internalValueMap = new Internal.EnumLiteMap<Anchor>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.1
                            @Override // com.explorestack.protobuf.Internal.EnumLiteMap
                            public Anchor findValueByNumber(int i) {
                                return Anchor.forNumber(i);
                            }
                        };
                        private static final Anchor[] VALUES = values();

                        @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
                        public final int getNumber() {
                            if (this == UNRECOGNIZED) {
                                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                            }
                            return this.value;
                        }

                        @Deprecated
                        public static Anchor valueOf(int i) {
                            return forNumber(i);
                        }

                        public static Anchor forNumber(int i) {
                            switch (i) {
                                case 0:
                                    return ANCHOR_INVALID;
                                case 1:
                                    return ANCHOR_LEFT;
                                case 2:
                                    return ANCHOR_RIGHT;
                                case 3:
                                    return ANCHOR_TOP;
                                case 4:
                                    return ANCHOR_BOTTOM;
                                case 5:
                                    return ANCHOR_CENTER_X;
                                case 6:
                                    return ANCHOR_CENTER_Y;
                                case 7:
                                    return ANCHOR_WIDTH;
                                case 8:
                                    return ANCHOR_HEIGHT;
                                default:
                                    return null;
                            }
                        }

                        public static Internal.EnumLiteMap<Anchor> internalGetValueMap() {
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
                            return Constraint.getDescriptor().getEnumTypes().get(0);
                        }

                        public static Anchor valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                            if (enumValueDescriptor.getType() != getDescriptor()) {
                                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                            }
                            if (enumValueDescriptor.getIndex() == -1) {
                                return UNRECOGNIZED;
                            }
                            return VALUES[enumValueDescriptor.getIndex()];
                        }

                        Anchor(int i) {
                            this.value = i;
                        }
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public int getSourceAnchorValue() {
                        return this.sourceAnchor_;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public Anchor getSourceAnchor() {
                        Anchor anchorValueOf = Anchor.valueOf(this.sourceAnchor_);
                        return anchorValueOf == null ? Anchor.UNRECOGNIZED : anchorValueOf;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public int getTargetAnchorValue() {
                        return this.targetAnchor_;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public Anchor getTargetAnchor() {
                        Anchor anchorValueOf = Anchor.valueOf(this.targetAnchor_);
                        return anchorValueOf == null ? Anchor.UNRECOGNIZED : anchorValueOf;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public String getTarget() {
                        Object obj = this.target_;
                        if (obj instanceof String) {
                            return (String) obj;
                        }
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.target_ = stringUtf8;
                        return stringUtf8;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public ByteString getTargetBytes() {
                        Object obj = this.target_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.target_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public double getValue() {
                        return this.value_;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                    public double getMultiplier() {
                        return this.multiplier_;
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
                        if (this.sourceAnchor_ != Anchor.ANCHOR_INVALID.getNumber()) {
                            codedOutputStream.writeEnum(1, this.sourceAnchor_);
                        }
                        if (this.targetAnchor_ != Anchor.ANCHOR_INVALID.getNumber()) {
                            codedOutputStream.writeEnum(2, this.targetAnchor_);
                        }
                        if (!getTargetBytes().isEmpty()) {
                            GeneratedMessageV3.writeString(codedOutputStream, 3, this.target_);
                        }
                        double d = this.value_;
                        if (d != 0.0d) {
                            codedOutputStream.writeDouble(4, d);
                        }
                        double d2 = this.multiplier_;
                        if (d2 != 0.0d) {
                            codedOutputStream.writeDouble(5, d2);
                        }
                        this.unknownFields.writeTo(codedOutputStream);
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
                    public int getSerializedSize() {
                        int i = this.memoizedSize;
                        if (i != -1) {
                            return i;
                        }
                        int iComputeEnumSize = this.sourceAnchor_ != Anchor.ANCHOR_INVALID.getNumber() ? CodedOutputStream.computeEnumSize(1, this.sourceAnchor_) : 0;
                        if (this.targetAnchor_ != Anchor.ANCHOR_INVALID.getNumber()) {
                            iComputeEnumSize += CodedOutputStream.computeEnumSize(2, this.targetAnchor_);
                        }
                        if (!getTargetBytes().isEmpty()) {
                            iComputeEnumSize += GeneratedMessageV3.computeStringSize(3, this.target_);
                        }
                        double d = this.value_;
                        if (d != 0.0d) {
                            iComputeEnumSize += CodedOutputStream.computeDoubleSize(4, d);
                        }
                        double d2 = this.multiplier_;
                        if (d2 != 0.0d) {
                            iComputeEnumSize += CodedOutputStream.computeDoubleSize(5, d2);
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
                        if (!(obj instanceof Constraint)) {
                            return super.equals(obj);
                        }
                        Constraint constraint = (Constraint) obj;
                        return this.sourceAnchor_ == constraint.sourceAnchor_ && this.targetAnchor_ == constraint.targetAnchor_ && getTarget().equals(constraint.getTarget()) && Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(constraint.getValue()) && Double.doubleToLongBits(getMultiplier()) == Double.doubleToLongBits(constraint.getMultiplier()) && this.unknownFields.equals(constraint.unknownFields);
                    }

                    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
                    public int hashCode() {
                        if (this.memoizedHashCode != 0) {
                            return this.memoizedHashCode;
                        }
                        int iHashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.sourceAnchor_) * 37) + 2) * 53) + this.targetAnchor_) * 37) + 3) * 53) + getTarget().hashCode()) * 37) + 4) * 53) + Internal.hashLong(Double.doubleToLongBits(getValue()))) * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getMultiplier()))) * 29) + this.unknownFields.hashCode();
                        this.memoizedHashCode = iHashCode;
                        return iHashCode;
                    }

                    public static Constraint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(byteBuffer);
                    }

                    public static Constraint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
                    }

                    public static Constraint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(byteString);
                    }

                    public static Constraint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(byteString, extensionRegistryLite);
                    }

                    public static Constraint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(bArr);
                    }

                    public static Constraint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return PARSER.parseFrom(bArr, extensionRegistryLite);
                    }

                    public static Constraint parseFrom(InputStream inputStream) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
                    }

                    public static Constraint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
                    }

                    public static Constraint parseDelimitedFrom(InputStream inputStream) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
                    }

                    public static Constraint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
                    }

                    public static Constraint parseFrom(CodedInputStream codedInputStream) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
                    }

                    public static Constraint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Constraint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
                    }

                    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                    public Builder newBuilderForType() {
                        return newBuilder();
                    }

                    public static Builder newBuilder() {
                        return DEFAULT_INSTANCE.toBuilder();
                    }

                    public static Builder newBuilder(Constraint constraint) {
                        return DEFAULT_INSTANCE.toBuilder().mergeFrom(constraint);
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

                    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConstraintOrBuilder {
                        private double multiplier_;
                        private int sourceAnchor_;
                        private int targetAnchor_;
                        private Object target_;
                        private double value_;

                        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                        public final boolean isInitialized() {
                            return true;
                        }

                        public static final Descriptors.Descriptor getDescriptor() {
                            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_descriptor;
                        }

                        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_fieldAccessorTable.ensureFieldAccessorsInitialized(Constraint.class, Builder.class);
                        }

                        private Builder() {
                            this.sourceAnchor_ = 0;
                            this.targetAnchor_ = 0;
                            this.target_ = "";
                            maybeForceBuilderInitialization();
                        }

                        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                            super(builderParent);
                            this.sourceAnchor_ = 0;
                            this.targetAnchor_ = 0;
                            this.target_ = "";
                            maybeForceBuilderInitialization();
                        }

                        private void maybeForceBuilderInitialization() {
                            boolean unused = Constraint.alwaysUseFieldBuilders;
                        }

                        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                        public Builder clear() {
                            super.clear();
                            this.sourceAnchor_ = 0;
                            this.targetAnchor_ = 0;
                            this.target_ = "";
                            this.value_ = 0.0d;
                            this.multiplier_ = 0.0d;
                            return this;
                        }

                        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                        public Descriptors.Descriptor getDescriptorForType() {
                            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_descriptor;
                        }

                        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                        public Constraint getDefaultInstanceForType() {
                            return Constraint.getDefaultInstance();
                        }

                        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                        public Constraint build() {
                            Constraint constraintBuildPartial = buildPartial();
                            if (constraintBuildPartial.isInitialized()) {
                                return constraintBuildPartial;
                            }
                            throw newUninitializedMessageException((Message) constraintBuildPartial);
                        }

                        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                        public Constraint buildPartial() {
                            Constraint constraint = new Constraint(this);
                            constraint.sourceAnchor_ = this.sourceAnchor_;
                            constraint.targetAnchor_ = this.targetAnchor_;
                            constraint.target_ = this.target_;
                            constraint.value_ = this.value_;
                            constraint.multiplier_ = this.multiplier_;
                            onBuilt();
                            return constraint;
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
                            if (message instanceof Constraint) {
                                return mergeFrom((Constraint) message);
                            }
                            super.mergeFrom(message);
                            return this;
                        }

                        public Builder mergeFrom(Constraint constraint) {
                            if (constraint == Constraint.getDefaultInstance()) {
                                return this;
                            }
                            if (constraint.sourceAnchor_ != 0) {
                                setSourceAnchorValue(constraint.getSourceAnchorValue());
                            }
                            if (constraint.targetAnchor_ != 0) {
                                setTargetAnchorValue(constraint.getTargetAnchorValue());
                            }
                            if (!constraint.getTarget().isEmpty()) {
                                this.target_ = constraint.target_;
                                onChanged();
                            }
                            if (constraint.getValue() != 0.0d) {
                                setValue(constraint.getValue());
                            }
                            if (constraint.getMultiplier() != 0.0d) {
                                setMultiplier(constraint.getMultiplier());
                            }
                            mergeUnknownFields(constraint.unknownFields);
                            onChanged();
                            return this;
                        }

                        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                            Constraint constraint = null;
                            try {
                                try {
                                    Constraint constraint2 = (Constraint) Constraint.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                    if (constraint2 != null) {
                                        mergeFrom(constraint2);
                                    }
                                    return this;
                                } catch (InvalidProtocolBufferException e) {
                                    Constraint constraint3 = (Constraint) e.getUnfinishedMessage();
                                    try {
                                        throw e.unwrapIOException();
                                    } catch (Throwable th) {
                                        th = th;
                                        constraint = constraint3;
                                        if (constraint != null) {
                                            mergeFrom(constraint);
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (constraint != null) {
                                    mergeFrom(constraint);
                                }
                                throw th;
                            }
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public int getSourceAnchorValue() {
                            return this.sourceAnchor_;
                        }

                        public Builder setSourceAnchorValue(int i) {
                            this.sourceAnchor_ = i;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public Anchor getSourceAnchor() {
                            Anchor anchorValueOf = Anchor.valueOf(this.sourceAnchor_);
                            return anchorValueOf == null ? Anchor.UNRECOGNIZED : anchorValueOf;
                        }

                        public Builder setSourceAnchor(Anchor anchor) {
                            anchor.getClass();
                            this.sourceAnchor_ = anchor.getNumber();
                            onChanged();
                            return this;
                        }

                        public Builder clearSourceAnchor() {
                            this.sourceAnchor_ = 0;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public int getTargetAnchorValue() {
                            return this.targetAnchor_;
                        }

                        public Builder setTargetAnchorValue(int i) {
                            this.targetAnchor_ = i;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public Anchor getTargetAnchor() {
                            Anchor anchorValueOf = Anchor.valueOf(this.targetAnchor_);
                            return anchorValueOf == null ? Anchor.UNRECOGNIZED : anchorValueOf;
                        }

                        public Builder setTargetAnchor(Anchor anchor) {
                            anchor.getClass();
                            this.targetAnchor_ = anchor.getNumber();
                            onChanged();
                            return this;
                        }

                        public Builder clearTargetAnchor() {
                            this.targetAnchor_ = 0;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public String getTarget() {
                            Object obj = this.target_;
                            if (!(obj instanceof String)) {
                                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                                this.target_ = stringUtf8;
                                return stringUtf8;
                            }
                            return (String) obj;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public ByteString getTargetBytes() {
                            Object obj = this.target_;
                            if (obj instanceof String) {
                                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                                this.target_ = byteStringCopyFromUtf8;
                                return byteStringCopyFromUtf8;
                            }
                            return (ByteString) obj;
                        }

                        public Builder setTarget(String str) {
                            str.getClass();
                            this.target_ = str;
                            onChanged();
                            return this;
                        }

                        public Builder clearTarget() {
                            this.target_ = Constraint.getDefaultInstance().getTarget();
                            onChanged();
                            return this;
                        }

                        public Builder setTargetBytes(ByteString byteString) {
                            byteString.getClass();
                            Constraint.checkByteStringIsUtf8(byteString);
                            this.target_ = byteString;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public double getValue() {
                            return this.value_;
                        }

                        public Builder setValue(double d) {
                            this.value_ = d;
                            onChanged();
                            return this;
                        }

                        public Builder clearValue() {
                            this.value_ = 0.0d;
                            onChanged();
                            return this;
                        }

                        @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Layout.ConstraintOrBuilder
                        public double getMultiplier() {
                            return this.multiplier_;
                        }

                        public Builder setMultiplier(double d) {
                            this.multiplier_ = d;
                            onChanged();
                            return this;
                        }

                        public Builder clearMultiplier() {
                            this.multiplier_ = 0.0d;
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

                    public static Constraint getDefaultInstance() {
                        return DEFAULT_INSTANCE;
                    }

                    public static Parser<Constraint> parser() {
                        return PARSER;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                    public Parser<Constraint> getParserForType() {
                        return PARSER;
                    }

                    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                    public Constraint getDefaultInstanceForType() {
                        return DEFAULT_INSTANCE;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                public List<Constraint> getConstraintsList() {
                    return this.constraints_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                public List<? extends ConstraintOrBuilder> getConstraintsOrBuilderList() {
                    return this.constraints_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                public int getConstraintsCount() {
                    return this.constraints_.size();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                public Constraint getConstraints(int i) {
                    return this.constraints_.get(i);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                public ConstraintOrBuilder getConstraintsOrBuilder(int i) {
                    return this.constraints_.get(i);
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
                    for (int i = 0; i < this.constraints_.size(); i++) {
                        codedOutputStream.writeMessage(1, this.constraints_.get(i));
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
                    for (int i2 = 0; i2 < this.constraints_.size(); i2++) {
                        iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.constraints_.get(i2));
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
                    if (!(obj instanceof Layout)) {
                        return super.equals(obj);
                    }
                    Layout layout = (Layout) obj;
                    return getConstraintsList().equals(layout.getConstraintsList()) && this.unknownFields.equals(layout.unknownFields);
                }

                @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
                public int hashCode() {
                    if (this.memoizedHashCode != 0) {
                        return this.memoizedHashCode;
                    }
                    int iHashCode = 779 + getDescriptor().hashCode();
                    if (getConstraintsCount() > 0) {
                        iHashCode = (((iHashCode * 37) + 1) * 53) + getConstraintsList().hashCode();
                    }
                    int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                    this.memoizedHashCode = iHashCode2;
                    return iHashCode2;
                }

                public static Layout parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer);
                }

                public static Layout parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
                }

                public static Layout parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString);
                }

                public static Layout parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString, extensionRegistryLite);
                }

                public static Layout parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr);
                }

                public static Layout parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr, extensionRegistryLite);
                }

                public static Layout parseFrom(InputStream inputStream) throws IOException {
                    return (Layout) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
                }

                public static Layout parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Layout) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Layout parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Layout) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
                }

                public static Layout parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Layout) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Layout parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Layout) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
                }

                public static Layout parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Layout) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
                }

                @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.toBuilder();
                }

                public static Builder newBuilder(Layout layout) {
                    return DEFAULT_INSTANCE.toBuilder().mergeFrom(layout);
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

                public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LayoutOrBuilder {
                    private int bitField0_;
                    private RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> constraintsBuilder_;
                    private List<Constraint> constraints_;

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        return true;
                    }

                    public static final Descriptors.Descriptor getDescriptor() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_descriptor;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_fieldAccessorTable.ensureFieldAccessorsInitialized(Layout.class, Builder.class);
                    }

                    private Builder() {
                        this.constraints_ = Collections.emptyList();
                        maybeForceBuilderInitialization();
                    }

                    private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                        super(builderParent);
                        this.constraints_ = Collections.emptyList();
                        maybeForceBuilderInitialization();
                    }

                    private void maybeForceBuilderInitialization() {
                        if (Layout.alwaysUseFieldBuilders) {
                            getConstraintsFieldBuilder();
                        }
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder clear() {
                        super.clear();
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            this.constraints_ = Collections.emptyList();
                            this.bitField0_ &= -2;
                        } else {
                            repeatedFieldBuilderV3.clear();
                        }
                        return this;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                    public Descriptors.Descriptor getDescriptorForType() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_descriptor;
                    }

                    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                    public Layout getDefaultInstanceForType() {
                        return Layout.getDefaultInstance();
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Layout build() {
                        Layout layoutBuildPartial = buildPartial();
                        if (layoutBuildPartial.isInitialized()) {
                            return layoutBuildPartial;
                        }
                        throw newUninitializedMessageException((Message) layoutBuildPartial);
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Layout buildPartial() {
                        Layout layout = new Layout(this);
                        int i = this.bitField0_;
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            if ((i & 1) != 0) {
                                this.constraints_ = Collections.unmodifiableList(this.constraints_);
                                this.bitField0_ &= -2;
                            }
                            layout.constraints_ = this.constraints_;
                        } else {
                            layout.constraints_ = repeatedFieldBuilderV3.build();
                        }
                        onBuilt();
                        return layout;
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
                        if (message instanceof Layout) {
                            return mergeFrom((Layout) message);
                        }
                        super.mergeFrom(message);
                        return this;
                    }

                    public Builder mergeFrom(Layout layout) {
                        if (layout == Layout.getDefaultInstance()) {
                            return this;
                        }
                        if (this.constraintsBuilder_ == null) {
                            if (!layout.constraints_.isEmpty()) {
                                if (this.constraints_.isEmpty()) {
                                    this.constraints_ = layout.constraints_;
                                    this.bitField0_ &= -2;
                                } else {
                                    ensureConstraintsIsMutable();
                                    this.constraints_.addAll(layout.constraints_);
                                }
                                onChanged();
                            }
                        } else if (!layout.constraints_.isEmpty()) {
                            if (!this.constraintsBuilder_.isEmpty()) {
                                this.constraintsBuilder_.addAllMessages(layout.constraints_);
                            } else {
                                this.constraintsBuilder_.dispose();
                                this.constraintsBuilder_ = null;
                                this.constraints_ = layout.constraints_;
                                this.bitField0_ &= -2;
                                this.constraintsBuilder_ = Layout.alwaysUseFieldBuilders ? getConstraintsFieldBuilder() : null;
                            }
                        }
                        mergeUnknownFields(layout.unknownFields);
                        onChanged();
                        return this;
                    }

                    /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                    @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                        Layout layout = null;
                        try {
                            try {
                                Layout layout2 = (Layout) Layout.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (layout2 != null) {
                                    mergeFrom(layout2);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e) {
                                Layout layout3 = (Layout) e.getUnfinishedMessage();
                                try {
                                    throw e.unwrapIOException();
                                } catch (Throwable th) {
                                    th = th;
                                    layout = layout3;
                                    if (layout != null) {
                                        mergeFrom(layout);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (layout != null) {
                                mergeFrom(layout);
                            }
                            throw th;
                        }
                    }

                    private void ensureConstraintsIsMutable() {
                        if ((this.bitField0_ & 1) == 0) {
                            this.constraints_ = new ArrayList(this.constraints_);
                            this.bitField0_ |= 1;
                        }
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                    public List<Constraint> getConstraintsList() {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            return Collections.unmodifiableList(this.constraints_);
                        }
                        return repeatedFieldBuilderV3.getMessageList();
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                    public int getConstraintsCount() {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            return this.constraints_.size();
                        }
                        return repeatedFieldBuilderV3.getCount();
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                    public Constraint getConstraints(int i) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            return this.constraints_.get(i);
                        }
                        return (Constraint) repeatedFieldBuilderV3.getMessage(i);
                    }

                    public Builder setConstraints(int i, Constraint constraint) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            constraint.getClass();
                            ensureConstraintsIsMutable();
                            this.constraints_.set(i, constraint);
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.setMessage(i, constraint);
                        }
                        return this;
                    }

                    public Builder setConstraints(int i, Constraint.Builder builder) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            ensureConstraintsIsMutable();
                            this.constraints_.set(i, builder.build());
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.setMessage(i, builder.build());
                        }
                        return this;
                    }

                    public Builder addConstraints(Constraint constraint) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            constraint.getClass();
                            ensureConstraintsIsMutable();
                            this.constraints_.add(constraint);
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.addMessage(constraint);
                        }
                        return this;
                    }

                    public Builder addConstraints(int i, Constraint constraint) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            constraint.getClass();
                            ensureConstraintsIsMutable();
                            this.constraints_.add(i, constraint);
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.addMessage(i, constraint);
                        }
                        return this;
                    }

                    public Builder addConstraints(Constraint.Builder builder) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            ensureConstraintsIsMutable();
                            this.constraints_.add(builder.build());
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.addMessage(builder.build());
                        }
                        return this;
                    }

                    public Builder addConstraints(int i, Constraint.Builder builder) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            ensureConstraintsIsMutable();
                            this.constraints_.add(i, builder.build());
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.addMessage(i, builder.build());
                        }
                        return this;
                    }

                    public Builder addAllConstraints(Iterable<? extends Constraint> iterable) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            ensureConstraintsIsMutable();
                            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.constraints_);
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.addAllMessages(iterable);
                        }
                        return this;
                    }

                    public Builder clearConstraints() {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            this.constraints_ = Collections.emptyList();
                            this.bitField0_ &= -2;
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.clear();
                        }
                        return this;
                    }

                    public Builder removeConstraints(int i) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            ensureConstraintsIsMutable();
                            this.constraints_.remove(i);
                            onChanged();
                        } else {
                            repeatedFieldBuilderV3.remove(i);
                        }
                        return this;
                    }

                    public Constraint.Builder getConstraintsBuilder(int i) {
                        return (Constraint.Builder) getConstraintsFieldBuilder().getBuilder(i);
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                    public ConstraintOrBuilder getConstraintsOrBuilder(int i) {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 == null) {
                            return this.constraints_.get(i);
                        }
                        return (ConstraintOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.LayoutOrBuilder
                    public List<? extends ConstraintOrBuilder> getConstraintsOrBuilderList() {
                        RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> repeatedFieldBuilderV3 = this.constraintsBuilder_;
                        if (repeatedFieldBuilderV3 != null) {
                            return repeatedFieldBuilderV3.getMessageOrBuilderList();
                        }
                        return Collections.unmodifiableList(this.constraints_);
                    }

                    public Constraint.Builder addConstraintsBuilder() {
                        return (Constraint.Builder) getConstraintsFieldBuilder().addBuilder(Constraint.getDefaultInstance());
                    }

                    public Constraint.Builder addConstraintsBuilder(int i) {
                        return (Constraint.Builder) getConstraintsFieldBuilder().addBuilder(i, Constraint.getDefaultInstance());
                    }

                    public List<Constraint.Builder> getConstraintsBuilderList() {
                        return getConstraintsFieldBuilder().getBuilderList();
                    }

                    private RepeatedFieldBuilderV3<Constraint, Constraint.Builder, ConstraintOrBuilder> getConstraintsFieldBuilder() {
                        if (this.constraintsBuilder_ == null) {
                            this.constraintsBuilder_ = new RepeatedFieldBuilderV3<>(this.constraints_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                            this.constraints_ = null;
                        }
                        return this.constraintsBuilder_;
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

                public static Layout getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Layout> parser() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Parser<Layout> getParserForType() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Layout getDefaultInstanceForType() {
                    return DEFAULT_INSTANCE;
                }
            }

            public static final class Appearance extends GeneratedMessageV3 implements AppearanceOrBuilder {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 8;
                public static final int CLICKABLE_FIELD_NUMBER = 9;
                public static final int FONT_STYLE_FIELD_NUMBER = 1;
                public static final int OPACITY_FIELD_NUMBER = 3;
                public static final int OUTLINED_FIELD_NUMBER = 4;
                public static final int PADDING_FIELD_NUMBER = 10;
                public static final int SHADOW_COLOR_FIELD_NUMBER = 7;
                public static final int STROKE_COLOR_FIELD_NUMBER = 6;
                public static final int STROKE_WIDTH_FIELD_NUMBER = 5;
                public static final int VISIBLE_FIELD_NUMBER = 2;
                private static final long serialVersionUID = 0;
                private volatile Object backgroundColor_;
                private boolean clickable_;
                private volatile Object fontStyle_;
                private byte memoizedIsInitialized;
                private double opacity_;
                private boolean outlined_;
                private volatile Object padding_;
                private volatile Object shadowColor_;
                private volatile Object strokeColor_;
                private double strokeWidth_;
                private boolean visible_;
                private static final Appearance DEFAULT_INSTANCE = new Appearance();
                private static final Parser<Appearance> PARSER = new AbstractParser<Appearance>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Appearance.1
                    @Override // com.explorestack.protobuf.Parser
                    public Appearance parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Appearance(codedInputStream, extensionRegistryLite);
                    }
                };

                private Appearance(GeneratedMessageV3.Builder<?> builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                }

                private Appearance() {
                    this.memoizedIsInitialized = (byte) -1;
                    this.fontStyle_ = "";
                    this.strokeColor_ = "";
                    this.shadowColor_ = "";
                    this.backgroundColor_ = "";
                    this.padding_ = "";
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                    return new Appearance();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
                public final UnknownFieldSet getUnknownFields() {
                    return this.unknownFields;
                }

                private Appearance(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    this();
                    extensionRegistryLite.getClass();
                    UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                switch (tag) {
                                    case 0:
                                        break;
                                    case 10:
                                        this.fontStyle_ = codedInputStream.readStringRequireUtf8();
                                        continue;
                                    case 16:
                                        this.visible_ = codedInputStream.readBool();
                                        continue;
                                    case 25:
                                        this.opacity_ = codedInputStream.readDouble();
                                        continue;
                                    case 32:
                                        this.outlined_ = codedInputStream.readBool();
                                        continue;
                                    case 41:
                                        this.strokeWidth_ = codedInputStream.readDouble();
                                        continue;
                                    case 50:
                                        this.strokeColor_ = codedInputStream.readStringRequireUtf8();
                                        continue;
                                    case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                        this.shadowColor_ = codedInputStream.readStringRequireUtf8();
                                        continue;
                                    case 66:
                                        this.backgroundColor_ = codedInputStream.readStringRequireUtf8();
                                        continue;
                                    case 72:
                                        this.clickable_ = codedInputStream.readBool();
                                        continue;
                                    case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                                        this.padding_ = codedInputStream.readStringRequireUtf8();
                                        continue;
                                    default:
                                        if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                            break;
                                        }
                                        break;
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
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_fieldAccessorTable.ensureFieldAccessorsInitialized(Appearance.class, Builder.class);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public String getFontStyle() {
                    Object obj = this.fontStyle_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.fontStyle_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public ByteString getFontStyleBytes() {
                    Object obj = this.fontStyle_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.fontStyle_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public boolean getVisible() {
                    return this.visible_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public double getOpacity() {
                    return this.opacity_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public boolean getOutlined() {
                    return this.outlined_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public double getStrokeWidth() {
                    return this.strokeWidth_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public String getStrokeColor() {
                    Object obj = this.strokeColor_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.strokeColor_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public ByteString getStrokeColorBytes() {
                    Object obj = this.strokeColor_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.strokeColor_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public String getShadowColor() {
                    Object obj = this.shadowColor_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.shadowColor_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public ByteString getShadowColorBytes() {
                    Object obj = this.shadowColor_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.shadowColor_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public String getBackgroundColor() {
                    Object obj = this.backgroundColor_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.backgroundColor_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public ByteString getBackgroundColorBytes() {
                    Object obj = this.backgroundColor_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.backgroundColor_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public boolean getClickable() {
                    return this.clickable_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public String getPadding() {
                    Object obj = this.padding_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.padding_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                public ByteString getPaddingBytes() {
                    Object obj = this.padding_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.padding_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
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
                    if (!getFontStyleBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 1, this.fontStyle_);
                    }
                    boolean z = this.visible_;
                    if (z) {
                        codedOutputStream.writeBool(2, z);
                    }
                    double d = this.opacity_;
                    if (d != 0.0d) {
                        codedOutputStream.writeDouble(3, d);
                    }
                    boolean z2 = this.outlined_;
                    if (z2) {
                        codedOutputStream.writeBool(4, z2);
                    }
                    double d2 = this.strokeWidth_;
                    if (d2 != 0.0d) {
                        codedOutputStream.writeDouble(5, d2);
                    }
                    if (!getStrokeColorBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 6, this.strokeColor_);
                    }
                    if (!getShadowColorBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 7, this.shadowColor_);
                    }
                    if (!getBackgroundColorBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 8, this.backgroundColor_);
                    }
                    boolean z3 = this.clickable_;
                    if (z3) {
                        codedOutputStream.writeBool(9, z3);
                    }
                    if (!getPaddingBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 10, this.padding_);
                    }
                    this.unknownFields.writeTo(codedOutputStream);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
                public int getSerializedSize() {
                    int i = this.memoizedSize;
                    if (i != -1) {
                        return i;
                    }
                    int iComputeStringSize = !getFontStyleBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.fontStyle_) : 0;
                    boolean z = this.visible_;
                    if (z) {
                        iComputeStringSize += CodedOutputStream.computeBoolSize(2, z);
                    }
                    double d = this.opacity_;
                    if (d != 0.0d) {
                        iComputeStringSize += CodedOutputStream.computeDoubleSize(3, d);
                    }
                    boolean z2 = this.outlined_;
                    if (z2) {
                        iComputeStringSize += CodedOutputStream.computeBoolSize(4, z2);
                    }
                    double d2 = this.strokeWidth_;
                    if (d2 != 0.0d) {
                        iComputeStringSize += CodedOutputStream.computeDoubleSize(5, d2);
                    }
                    if (!getStrokeColorBytes().isEmpty()) {
                        iComputeStringSize += GeneratedMessageV3.computeStringSize(6, this.strokeColor_);
                    }
                    if (!getShadowColorBytes().isEmpty()) {
                        iComputeStringSize += GeneratedMessageV3.computeStringSize(7, this.shadowColor_);
                    }
                    if (!getBackgroundColorBytes().isEmpty()) {
                        iComputeStringSize += GeneratedMessageV3.computeStringSize(8, this.backgroundColor_);
                    }
                    boolean z3 = this.clickable_;
                    if (z3) {
                        iComputeStringSize += CodedOutputStream.computeBoolSize(9, z3);
                    }
                    if (!getPaddingBytes().isEmpty()) {
                        iComputeStringSize += GeneratedMessageV3.computeStringSize(10, this.padding_);
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
                    if (!(obj instanceof Appearance)) {
                        return super.equals(obj);
                    }
                    Appearance appearance = (Appearance) obj;
                    return getFontStyle().equals(appearance.getFontStyle()) && getVisible() == appearance.getVisible() && Double.doubleToLongBits(getOpacity()) == Double.doubleToLongBits(appearance.getOpacity()) && getOutlined() == appearance.getOutlined() && Double.doubleToLongBits(getStrokeWidth()) == Double.doubleToLongBits(appearance.getStrokeWidth()) && getStrokeColor().equals(appearance.getStrokeColor()) && getShadowColor().equals(appearance.getShadowColor()) && getBackgroundColor().equals(appearance.getBackgroundColor()) && getClickable() == appearance.getClickable() && getPadding().equals(appearance.getPadding()) && this.unknownFields.equals(appearance.unknownFields);
                }

                @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
                public int hashCode() {
                    if (this.memoizedHashCode != 0) {
                        return this.memoizedHashCode;
                    }
                    int iHashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFontStyle().hashCode()) * 37) + 2) * 53) + Internal.hashBoolean(getVisible())) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getOpacity()))) * 37) + 4) * 53) + Internal.hashBoolean(getOutlined())) * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getStrokeWidth()))) * 37) + 6) * 53) + getStrokeColor().hashCode()) * 37) + 7) * 53) + getShadowColor().hashCode()) * 37) + 8) * 53) + getBackgroundColor().hashCode()) * 37) + 9) * 53) + Internal.hashBoolean(getClickable())) * 37) + 10) * 53) + getPadding().hashCode()) * 29) + this.unknownFields.hashCode();
                    this.memoizedHashCode = iHashCode;
                    return iHashCode;
                }

                public static Appearance parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer);
                }

                public static Appearance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
                }

                public static Appearance parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString);
                }

                public static Appearance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString, extensionRegistryLite);
                }

                public static Appearance parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr);
                }

                public static Appearance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr, extensionRegistryLite);
                }

                public static Appearance parseFrom(InputStream inputStream) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
                }

                public static Appearance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Appearance parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
                }

                public static Appearance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Appearance parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
                }

                public static Appearance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Appearance) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
                }

                @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.toBuilder();
                }

                public static Builder newBuilder(Appearance appearance) {
                    return DEFAULT_INSTANCE.toBuilder().mergeFrom(appearance);
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

                public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppearanceOrBuilder {
                    private Object backgroundColor_;
                    private boolean clickable_;
                    private Object fontStyle_;
                    private double opacity_;
                    private boolean outlined_;
                    private Object padding_;
                    private Object shadowColor_;
                    private Object strokeColor_;
                    private double strokeWidth_;
                    private boolean visible_;

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        return true;
                    }

                    public static final Descriptors.Descriptor getDescriptor() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_descriptor;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_fieldAccessorTable.ensureFieldAccessorsInitialized(Appearance.class, Builder.class);
                    }

                    private Builder() {
                        this.fontStyle_ = "";
                        this.strokeColor_ = "";
                        this.shadowColor_ = "";
                        this.backgroundColor_ = "";
                        this.padding_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                        super(builderParent);
                        this.fontStyle_ = "";
                        this.strokeColor_ = "";
                        this.shadowColor_ = "";
                        this.backgroundColor_ = "";
                        this.padding_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private void maybeForceBuilderInitialization() {
                        boolean unused = Appearance.alwaysUseFieldBuilders;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder clear() {
                        super.clear();
                        this.fontStyle_ = "";
                        this.visible_ = false;
                        this.opacity_ = 0.0d;
                        this.outlined_ = false;
                        this.strokeWidth_ = 0.0d;
                        this.strokeColor_ = "";
                        this.shadowColor_ = "";
                        this.backgroundColor_ = "";
                        this.clickable_ = false;
                        this.padding_ = "";
                        return this;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                    public Descriptors.Descriptor getDescriptorForType() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_descriptor;
                    }

                    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                    public Appearance getDefaultInstanceForType() {
                        return Appearance.getDefaultInstance();
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Appearance build() {
                        Appearance appearanceBuildPartial = buildPartial();
                        if (appearanceBuildPartial.isInitialized()) {
                            return appearanceBuildPartial;
                        }
                        throw newUninitializedMessageException((Message) appearanceBuildPartial);
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Appearance buildPartial() {
                        Appearance appearance = new Appearance(this);
                        appearance.fontStyle_ = this.fontStyle_;
                        appearance.visible_ = this.visible_;
                        appearance.opacity_ = this.opacity_;
                        appearance.outlined_ = this.outlined_;
                        appearance.strokeWidth_ = this.strokeWidth_;
                        appearance.strokeColor_ = this.strokeColor_;
                        appearance.shadowColor_ = this.shadowColor_;
                        appearance.backgroundColor_ = this.backgroundColor_;
                        appearance.clickable_ = this.clickable_;
                        appearance.padding_ = this.padding_;
                        onBuilt();
                        return appearance;
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
                        if (message instanceof Appearance) {
                            return mergeFrom((Appearance) message);
                        }
                        super.mergeFrom(message);
                        return this;
                    }

                    public Builder mergeFrom(Appearance appearance) {
                        if (appearance == Appearance.getDefaultInstance()) {
                            return this;
                        }
                        if (!appearance.getFontStyle().isEmpty()) {
                            this.fontStyle_ = appearance.fontStyle_;
                            onChanged();
                        }
                        if (appearance.getVisible()) {
                            setVisible(appearance.getVisible());
                        }
                        if (appearance.getOpacity() != 0.0d) {
                            setOpacity(appearance.getOpacity());
                        }
                        if (appearance.getOutlined()) {
                            setOutlined(appearance.getOutlined());
                        }
                        if (appearance.getStrokeWidth() != 0.0d) {
                            setStrokeWidth(appearance.getStrokeWidth());
                        }
                        if (!appearance.getStrokeColor().isEmpty()) {
                            this.strokeColor_ = appearance.strokeColor_;
                            onChanged();
                        }
                        if (!appearance.getShadowColor().isEmpty()) {
                            this.shadowColor_ = appearance.shadowColor_;
                            onChanged();
                        }
                        if (!appearance.getBackgroundColor().isEmpty()) {
                            this.backgroundColor_ = appearance.backgroundColor_;
                            onChanged();
                        }
                        if (appearance.getClickable()) {
                            setClickable(appearance.getClickable());
                        }
                        if (!appearance.getPadding().isEmpty()) {
                            this.padding_ = appearance.padding_;
                            onChanged();
                        }
                        mergeUnknownFields(appearance.unknownFields);
                        onChanged();
                        return this;
                    }

                    /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                    @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                        Appearance appearance = null;
                        try {
                            try {
                                Appearance appearance2 = (Appearance) Appearance.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (appearance2 != null) {
                                    mergeFrom(appearance2);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e) {
                                Appearance appearance3 = (Appearance) e.getUnfinishedMessage();
                                try {
                                    throw e.unwrapIOException();
                                } catch (Throwable th) {
                                    th = th;
                                    appearance = appearance3;
                                    if (appearance != null) {
                                        mergeFrom(appearance);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (appearance != null) {
                                mergeFrom(appearance);
                            }
                            throw th;
                        }
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public String getFontStyle() {
                        Object obj = this.fontStyle_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.fontStyle_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public ByteString getFontStyleBytes() {
                        Object obj = this.fontStyle_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.fontStyle_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setFontStyle(String str) {
                        str.getClass();
                        this.fontStyle_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearFontStyle() {
                        this.fontStyle_ = Appearance.getDefaultInstance().getFontStyle();
                        onChanged();
                        return this;
                    }

                    public Builder setFontStyleBytes(ByteString byteString) {
                        byteString.getClass();
                        Appearance.checkByteStringIsUtf8(byteString);
                        this.fontStyle_ = byteString;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public boolean getVisible() {
                        return this.visible_;
                    }

                    public Builder setVisible(boolean z) {
                        this.visible_ = z;
                        onChanged();
                        return this;
                    }

                    public Builder clearVisible() {
                        this.visible_ = false;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public double getOpacity() {
                        return this.opacity_;
                    }

                    public Builder setOpacity(double d) {
                        this.opacity_ = d;
                        onChanged();
                        return this;
                    }

                    public Builder clearOpacity() {
                        this.opacity_ = 0.0d;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public boolean getOutlined() {
                        return this.outlined_;
                    }

                    public Builder setOutlined(boolean z) {
                        this.outlined_ = z;
                        onChanged();
                        return this;
                    }

                    public Builder clearOutlined() {
                        this.outlined_ = false;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public double getStrokeWidth() {
                        return this.strokeWidth_;
                    }

                    public Builder setStrokeWidth(double d) {
                        this.strokeWidth_ = d;
                        onChanged();
                        return this;
                    }

                    public Builder clearStrokeWidth() {
                        this.strokeWidth_ = 0.0d;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public String getStrokeColor() {
                        Object obj = this.strokeColor_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.strokeColor_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public ByteString getStrokeColorBytes() {
                        Object obj = this.strokeColor_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.strokeColor_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setStrokeColor(String str) {
                        str.getClass();
                        this.strokeColor_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearStrokeColor() {
                        this.strokeColor_ = Appearance.getDefaultInstance().getStrokeColor();
                        onChanged();
                        return this;
                    }

                    public Builder setStrokeColorBytes(ByteString byteString) {
                        byteString.getClass();
                        Appearance.checkByteStringIsUtf8(byteString);
                        this.strokeColor_ = byteString;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public String getShadowColor() {
                        Object obj = this.shadowColor_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.shadowColor_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public ByteString getShadowColorBytes() {
                        Object obj = this.shadowColor_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.shadowColor_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setShadowColor(String str) {
                        str.getClass();
                        this.shadowColor_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearShadowColor() {
                        this.shadowColor_ = Appearance.getDefaultInstance().getShadowColor();
                        onChanged();
                        return this;
                    }

                    public Builder setShadowColorBytes(ByteString byteString) {
                        byteString.getClass();
                        Appearance.checkByteStringIsUtf8(byteString);
                        this.shadowColor_ = byteString;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public String getBackgroundColor() {
                        Object obj = this.backgroundColor_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.backgroundColor_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public ByteString getBackgroundColorBytes() {
                        Object obj = this.backgroundColor_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.backgroundColor_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setBackgroundColor(String str) {
                        str.getClass();
                        this.backgroundColor_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearBackgroundColor() {
                        this.backgroundColor_ = Appearance.getDefaultInstance().getBackgroundColor();
                        onChanged();
                        return this;
                    }

                    public Builder setBackgroundColorBytes(ByteString byteString) {
                        byteString.getClass();
                        Appearance.checkByteStringIsUtf8(byteString);
                        this.backgroundColor_ = byteString;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public boolean getClickable() {
                        return this.clickable_;
                    }

                    public Builder setClickable(boolean z) {
                        this.clickable_ = z;
                        onChanged();
                        return this;
                    }

                    public Builder clearClickable() {
                        this.clickable_ = false;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public String getPadding() {
                        Object obj = this.padding_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.padding_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.AppearanceOrBuilder
                    public ByteString getPaddingBytes() {
                        Object obj = this.padding_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.padding_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setPadding(String str) {
                        str.getClass();
                        this.padding_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearPadding() {
                        this.padding_ = Appearance.getDefaultInstance().getPadding();
                        onChanged();
                        return this;
                    }

                    public Builder setPaddingBytes(ByteString byteString) {
                        byteString.getClass();
                        Appearance.checkByteStringIsUtf8(byteString);
                        this.padding_ = byteString;
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

                public static Appearance getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Appearance> parser() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Parser<Appearance> getParserForType() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Appearance getDefaultInstanceForType() {
                    return DEFAULT_INSTANCE;
                }
            }

            public static final class Measurer extends GeneratedMessageV3 implements MeasurerOrBuilder {
                public static final int NAME_FIELD_NUMBER = 1;
                public static final int PARAMETERS_FIELD_NUMBER = 2;
                private static final long serialVersionUID = 0;
                private byte memoizedIsInitialized;
                private volatile Object name_;
                private MapField<String, String> parameters_;
                private static final Measurer DEFAULT_INSTANCE = new Measurer();
                private static final Parser<Measurer> PARSER = new AbstractParser<Measurer>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.Measurer.1
                    @Override // com.explorestack.protobuf.Parser
                    public Measurer parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Measurer(codedInputStream, extensionRegistryLite);
                    }
                };

                private Measurer(GeneratedMessageV3.Builder<?> builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                }

                private Measurer() {
                    this.memoizedIsInitialized = (byte) -1;
                    this.name_ = "";
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                    return new Measurer();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
                public final UnknownFieldSet getUnknownFields() {
                    return this.unknownFields;
                }

                /* JADX WARN: Multi-variable type inference failed */
                private Measurer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.name_ = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 18) {
                                        if (!z2) {
                                            this.parameters_ = MapField.newMapField(ParametersDefaultEntryHolder.defaultEntry);
                                            z2 = true;
                                        }
                                        MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ParametersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                        this.parameters_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
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
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected MapField internalGetMapField(int i) {
                    if (i == 2) {
                        return internalGetParameters();
                    }
                    throw new RuntimeException("Invalid map field number: " + i);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_fieldAccessorTable.ensureFieldAccessorsInitialized(Measurer.class, Builder.class);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public ByteString getNameBytes() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.name_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                private static final class ParametersDefaultEntryHolder {
                    static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_ParametersEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

                    private ParametersDefaultEntryHolder() {
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public MapField<String, String> internalGetParameters() {
                    MapField<String, String> mapField = this.parameters_;
                    return mapField == null ? MapField.emptyMapField(ParametersDefaultEntryHolder.defaultEntry) : mapField;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public int getParametersCount() {
                    return internalGetParameters().getMap().size();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public boolean containsParameters(String str) {
                    str.getClass();
                    return internalGetParameters().getMap().containsKey(str);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                @Deprecated
                public Map<String, String> getParameters() {
                    return getParametersMap();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public Map<String, String> getParametersMap() {
                    return internalGetParameters().getMap();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public String getParametersOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> map = internalGetParameters().getMap();
                    return map.containsKey(str) ? map.get(str) : str2;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                public String getParametersOrThrow(String str) {
                    str.getClass();
                    Map<String, String> map = internalGetParameters().getMap();
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
                    if (!getNameBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                    }
                    GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetParameters(), ParametersDefaultEntryHolder.defaultEntry, 2);
                    this.unknownFields.writeTo(codedOutputStream);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
                public int getSerializedSize() {
                    int i = this.memoizedSize;
                    if (i != -1) {
                        return i;
                    }
                    int iComputeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) : 0;
                    for (Map.Entry<String, String> entry : internalGetParameters().getMap().entrySet()) {
                        iComputeStringSize += CodedOutputStream.computeMessageSize(2, ParametersDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
                    if (!(obj instanceof Measurer)) {
                        return super.equals(obj);
                    }
                    Measurer measurer = (Measurer) obj;
                    return getName().equals(measurer.getName()) && internalGetParameters().equals(measurer.internalGetParameters()) && this.unknownFields.equals(measurer.unknownFields);
                }

                @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
                public int hashCode() {
                    if (this.memoizedHashCode != 0) {
                        return this.memoizedHashCode;
                    }
                    int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
                    if (!internalGetParameters().getMap().isEmpty()) {
                        iHashCode = (((iHashCode * 37) + 2) * 53) + internalGetParameters().hashCode();
                    }
                    int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                    this.memoizedHashCode = iHashCode2;
                    return iHashCode2;
                }

                public static Measurer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer);
                }

                public static Measurer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
                }

                public static Measurer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString);
                }

                public static Measurer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString, extensionRegistryLite);
                }

                public static Measurer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr);
                }

                public static Measurer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr, extensionRegistryLite);
                }

                public static Measurer parseFrom(InputStream inputStream) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
                }

                public static Measurer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Measurer parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
                }

                public static Measurer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Measurer parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
                }

                public static Measurer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Measurer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
                }

                @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.toBuilder();
                }

                public static Builder newBuilder(Measurer measurer) {
                    return DEFAULT_INSTANCE.toBuilder().mergeFrom(measurer);
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

                public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MeasurerOrBuilder {
                    private int bitField0_;
                    private Object name_;
                    private MapField<String, String> parameters_;

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        return true;
                    }

                    public static final Descriptors.Descriptor getDescriptor() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_descriptor;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected MapField internalGetMapField(int i) {
                        if (i == 2) {
                            return internalGetParameters();
                        }
                        throw new RuntimeException("Invalid map field number: " + i);
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected MapField internalGetMutableMapField(int i) {
                        if (i == 2) {
                            return internalGetMutableParameters();
                        }
                        throw new RuntimeException("Invalid map field number: " + i);
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_fieldAccessorTable.ensureFieldAccessorsInitialized(Measurer.class, Builder.class);
                    }

                    private Builder() {
                        this.name_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                        super(builderParent);
                        this.name_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private void maybeForceBuilderInitialization() {
                        boolean unused = Measurer.alwaysUseFieldBuilders;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder clear() {
                        super.clear();
                        this.name_ = "";
                        internalGetMutableParameters().clear();
                        return this;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                    public Descriptors.Descriptor getDescriptorForType() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_descriptor;
                    }

                    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                    public Measurer getDefaultInstanceForType() {
                        return Measurer.getDefaultInstance();
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Measurer build() {
                        Measurer measurerBuildPartial = buildPartial();
                        if (measurerBuildPartial.isInitialized()) {
                            return measurerBuildPartial;
                        }
                        throw newUninitializedMessageException((Message) measurerBuildPartial);
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Measurer buildPartial() {
                        Measurer measurer = new Measurer(this);
                        measurer.name_ = this.name_;
                        measurer.parameters_ = internalGetParameters();
                        measurer.parameters_.makeImmutable();
                        onBuilt();
                        return measurer;
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
                        if (message instanceof Measurer) {
                            return mergeFrom((Measurer) message);
                        }
                        super.mergeFrom(message);
                        return this;
                    }

                    public Builder mergeFrom(Measurer measurer) {
                        if (measurer == Measurer.getDefaultInstance()) {
                            return this;
                        }
                        if (!measurer.getName().isEmpty()) {
                            this.name_ = measurer.name_;
                            onChanged();
                        }
                        internalGetMutableParameters().mergeFrom(measurer.internalGetParameters());
                        mergeUnknownFields(measurer.unknownFields);
                        onChanged();
                        return this;
                    }

                    /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                    @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                        Measurer measurer = null;
                        try {
                            try {
                                Measurer measurer2 = (Measurer) Measurer.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (measurer2 != null) {
                                    mergeFrom(measurer2);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e) {
                                Measurer measurer3 = (Measurer) e.getUnfinishedMessage();
                                try {
                                    throw e.unwrapIOException();
                                } catch (Throwable th) {
                                    th = th;
                                    measurer = measurer3;
                                    if (measurer != null) {
                                        mergeFrom(measurer);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (measurer != null) {
                                mergeFrom(measurer);
                            }
                            throw th;
                        }
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public String getName() {
                        Object obj = this.name_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.name_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public ByteString getNameBytes() {
                        Object obj = this.name_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.name_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setName(String str) {
                        str.getClass();
                        this.name_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearName() {
                        this.name_ = Measurer.getDefaultInstance().getName();
                        onChanged();
                        return this;
                    }

                    public Builder setNameBytes(ByteString byteString) {
                        byteString.getClass();
                        Measurer.checkByteStringIsUtf8(byteString);
                        this.name_ = byteString;
                        onChanged();
                        return this;
                    }

                    private MapField<String, String> internalGetParameters() {
                        MapField<String, String> mapField = this.parameters_;
                        return mapField == null ? MapField.emptyMapField(ParametersDefaultEntryHolder.defaultEntry) : mapField;
                    }

                    private MapField<String, String> internalGetMutableParameters() {
                        onChanged();
                        if (this.parameters_ == null) {
                            this.parameters_ = MapField.newMapField(ParametersDefaultEntryHolder.defaultEntry);
                        }
                        if (!this.parameters_.isMutable()) {
                            this.parameters_ = this.parameters_.copy();
                        }
                        return this.parameters_;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public int getParametersCount() {
                        return internalGetParameters().getMap().size();
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public boolean containsParameters(String str) {
                        str.getClass();
                        return internalGetParameters().getMap().containsKey(str);
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    @Deprecated
                    public Map<String, String> getParameters() {
                        return getParametersMap();
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public Map<String, String> getParametersMap() {
                        return internalGetParameters().getMap();
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public String getParametersOrDefault(String str, String str2) {
                        str.getClass();
                        Map<String, String> map = internalGetParameters().getMap();
                        return map.containsKey(str) ? map.get(str) : str2;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponent.MeasurerOrBuilder
                    public String getParametersOrThrow(String str) {
                        str.getClass();
                        Map<String, String> map = internalGetParameters().getMap();
                        if (!map.containsKey(str)) {
                            throw new IllegalArgumentException();
                        }
                        return map.get(str);
                    }

                    public Builder clearParameters() {
                        internalGetMutableParameters().getMutableMap().clear();
                        return this;
                    }

                    public Builder removeParameters(String str) {
                        str.getClass();
                        internalGetMutableParameters().getMutableMap().remove(str);
                        return this;
                    }

                    @Deprecated
                    public Map<String, String> getMutableParameters() {
                        return internalGetMutableParameters().getMutableMap();
                    }

                    public Builder putParameters(String str, String str2) {
                        str.getClass();
                        str2.getClass();
                        internalGetMutableParameters().getMutableMap().put(str, str2);
                        return this;
                    }

                    public Builder putAllParameters(Map<String, String> map) {
                        internalGetMutableParameters().getMutableMap().putAll(map);
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

                public static Measurer getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Measurer> parser() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Parser<Measurer> getParserForType() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Measurer getDefaultInstanceForType() {
                    return DEFAULT_INSTANCE;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public ViewComponentType getType() {
                ViewComponentType viewComponentTypeValueOf = ViewComponentType.valueOf(this.type_);
                return viewComponentTypeValueOf == null ? ViewComponentType.UNRECOGNIZED : viewComponentTypeValueOf;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public String getPlaceholder() {
                Object obj = this.placeholder_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.placeholder_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public ByteString getPlaceholderBytes() {
                Object obj = this.placeholder_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.placeholder_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            private static final class CustomParamsDefaultEntryHolder {
                static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_CustomParamsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

                private CustomParamsDefaultEntryHolder() {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MapField<String, String> internalGetCustomParams() {
                MapField<String, String> mapField = this.customParams_;
                return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public int getCustomParamsCount() {
                return internalGetCustomParams().getMap().size();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public boolean containsCustomParams(String str) {
                str.getClass();
                return internalGetCustomParams().getMap().containsKey(str);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            @Deprecated
            public Map<String, String> getCustomParams() {
                return getCustomParamsMap();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public Map<String, String> getCustomParamsMap() {
                return internalGetCustomParams().getMap();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public String getCustomParamsOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> map = internalGetCustomParams().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public String getCustomParamsOrThrow(String str) {
                str.getClass();
                Map<String, String> map = internalGetCustomParams().getMap();
                if (!map.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return map.get(str);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public boolean hasLayout() {
                return this.layout_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public Layout getLayout() {
                Layout layout = this.layout_;
                return layout == null ? Layout.getDefaultInstance() : layout;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public LayoutOrBuilder getLayoutOrBuilder() {
                return getLayout();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public boolean hasAppearance() {
                return this.appearance_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public Appearance getAppearance() {
                Appearance appearance = this.appearance_;
                return appearance == null ? Appearance.getDefaultInstance() : appearance;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public AppearanceOrBuilder getAppearanceOrBuilder() {
                return getAppearance();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public List<Measurer> getMeasurersList() {
                return this.measurers_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public List<? extends MeasurerOrBuilder> getMeasurersOrBuilderList() {
                return this.measurers_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public int getMeasurersCount() {
                return this.measurers_.size();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public Measurer getMeasurers(int i) {
                return this.measurers_.get(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
            public MeasurerOrBuilder getMeasurersOrBuilder(int i) {
                return this.measurers_.get(i);
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
                if (!getNameBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                if (this.type_ != ViewComponentType.VIEW_COMPONENT_TYPE_INVALID.getNumber()) {
                    codedOutputStream.writeEnum(2, this.type_);
                }
                if (!getSourceBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 3, this.source_);
                }
                if (!getPlaceholderBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 4, this.placeholder_);
                }
                GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetCustomParams(), CustomParamsDefaultEntryHolder.defaultEntry, 5);
                if (this.layout_ != null) {
                    codedOutputStream.writeMessage(6, getLayout());
                }
                if (this.appearance_ != null) {
                    codedOutputStream.writeMessage(7, getAppearance());
                }
                for (int i = 0; i < this.measurers_.size(); i++) {
                    codedOutputStream.writeMessage(8, this.measurers_.get(i));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) : 0;
                if (this.type_ != ViewComponentType.VIEW_COMPONENT_TYPE_INVALID.getNumber()) {
                    iComputeStringSize += CodedOutputStream.computeEnumSize(2, this.type_);
                }
                if (!getSourceBytes().isEmpty()) {
                    iComputeStringSize += GeneratedMessageV3.computeStringSize(3, this.source_);
                }
                if (!getPlaceholderBytes().isEmpty()) {
                    iComputeStringSize += GeneratedMessageV3.computeStringSize(4, this.placeholder_);
                }
                for (Map.Entry<String, String> entry : internalGetCustomParams().getMap().entrySet()) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(5, CustomParamsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
                }
                if (this.layout_ != null) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(6, getLayout());
                }
                if (this.appearance_ != null) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(7, getAppearance());
                }
                for (int i2 = 0; i2 < this.measurers_.size(); i2++) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(8, this.measurers_.get(i2));
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
                if (!(obj instanceof ViewComponent)) {
                    return super.equals(obj);
                }
                ViewComponent viewComponent = (ViewComponent) obj;
                if (!getName().equals(viewComponent.getName()) || this.type_ != viewComponent.type_ || !getSource().equals(viewComponent.getSource()) || !getPlaceholder().equals(viewComponent.getPlaceholder()) || !internalGetCustomParams().equals(viewComponent.internalGetCustomParams()) || hasLayout() != viewComponent.hasLayout()) {
                    return false;
                }
                if ((!hasLayout() || getLayout().equals(viewComponent.getLayout())) && hasAppearance() == viewComponent.hasAppearance()) {
                    return (!hasAppearance() || getAppearance().equals(viewComponent.getAppearance())) && getMeasurersList().equals(viewComponent.getMeasurersList()) && this.unknownFields.equals(viewComponent.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + this.type_) * 37) + 3) * 53) + getSource().hashCode()) * 37) + 4) * 53) + getPlaceholder().hashCode();
                if (!internalGetCustomParams().getMap().isEmpty()) {
                    iHashCode = (((iHashCode * 37) + 5) * 53) + internalGetCustomParams().hashCode();
                }
                if (hasLayout()) {
                    iHashCode = (((iHashCode * 37) + 6) * 53) + getLayout().hashCode();
                }
                if (hasAppearance()) {
                    iHashCode = (((iHashCode * 37) + 7) * 53) + getAppearance().hashCode();
                }
                if (getMeasurersCount() > 0) {
                    iHashCode = (((iHashCode * 37) + 8) * 53) + getMeasurersList().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
            }

            public static ViewComponent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static ViewComponent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static ViewComponent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static ViewComponent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static ViewComponent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static ViewComponent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static ViewComponent parseFrom(InputStream inputStream) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static ViewComponent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static ViewComponent parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static ViewComponent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static ViewComponent parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static ViewComponent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ViewComponent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ViewComponent viewComponent) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(viewComponent);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ViewComponentOrBuilder {
                private SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> appearanceBuilder_;
                private Appearance appearance_;
                private int bitField0_;
                private MapField<String, String> customParams_;
                private SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> layoutBuilder_;
                private Layout layout_;
                private RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> measurersBuilder_;
                private List<Measurer> measurers_;
                private Object name_;
                private Object placeholder_;
                private Object source_;
                private int type_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected MapField internalGetMapField(int i) {
                    if (i == 5) {
                        return internalGetCustomParams();
                    }
                    throw new RuntimeException("Invalid map field number: " + i);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected MapField internalGetMutableMapField(int i) {
                    if (i == 5) {
                        return internalGetMutableCustomParams();
                    }
                    throw new RuntimeException("Invalid map field number: " + i);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_fieldAccessorTable.ensureFieldAccessorsInitialized(ViewComponent.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    this.type_ = 0;
                    this.source_ = "";
                    this.placeholder_ = "";
                    this.measurers_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    this.type_ = 0;
                    this.source_ = "";
                    this.placeholder_ = "";
                    this.measurers_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (ViewComponent.alwaysUseFieldBuilders) {
                        getMeasurersFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.name_ = "";
                    this.type_ = 0;
                    this.source_ = "";
                    this.placeholder_ = "";
                    internalGetMutableCustomParams().clear();
                    if (this.layoutBuilder_ == null) {
                        this.layout_ = null;
                    } else {
                        this.layout_ = null;
                        this.layoutBuilder_ = null;
                    }
                    if (this.appearanceBuilder_ == null) {
                        this.appearance_ = null;
                    } else {
                        this.appearance_ = null;
                        this.appearanceBuilder_ = null;
                    }
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.measurers_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                    } else {
                        repeatedFieldBuilderV3.clear();
                    }
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public ViewComponent getDefaultInstanceForType() {
                    return ViewComponent.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public ViewComponent build() {
                    ViewComponent viewComponentBuildPartial = buildPartial();
                    if (viewComponentBuildPartial.isInitialized()) {
                        return viewComponentBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) viewComponentBuildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public ViewComponent buildPartial() {
                    ViewComponent viewComponent = new ViewComponent(this);
                    viewComponent.name_ = this.name_;
                    viewComponent.type_ = this.type_;
                    viewComponent.source_ = this.source_;
                    viewComponent.placeholder_ = this.placeholder_;
                    viewComponent.customParams_ = internalGetCustomParams();
                    viewComponent.customParams_.makeImmutable();
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        viewComponent.layout_ = this.layout_;
                    } else {
                        viewComponent.layout_ = (Layout) singleFieldBuilderV3.build();
                    }
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV4 = this.appearanceBuilder_;
                    if (singleFieldBuilderV4 == null) {
                        viewComponent.appearance_ = this.appearance_;
                    } else {
                        viewComponent.appearance_ = (Appearance) singleFieldBuilderV4.build();
                    }
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        viewComponent.measurers_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 2) != 0) {
                            this.measurers_ = Collections.unmodifiableList(this.measurers_);
                            this.bitField0_ &= -3;
                        }
                        viewComponent.measurers_ = this.measurers_;
                    }
                    onBuilt();
                    return viewComponent;
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
                    if (message instanceof ViewComponent) {
                        return mergeFrom((ViewComponent) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(ViewComponent viewComponent) {
                    if (viewComponent == ViewComponent.getDefaultInstance()) {
                        return this;
                    }
                    if (!viewComponent.getName().isEmpty()) {
                        this.name_ = viewComponent.name_;
                        onChanged();
                    }
                    if (viewComponent.type_ != 0) {
                        setTypeValue(viewComponent.getTypeValue());
                    }
                    if (!viewComponent.getSource().isEmpty()) {
                        this.source_ = viewComponent.source_;
                        onChanged();
                    }
                    if (!viewComponent.getPlaceholder().isEmpty()) {
                        this.placeholder_ = viewComponent.placeholder_;
                        onChanged();
                    }
                    internalGetMutableCustomParams().mergeFrom(viewComponent.internalGetCustomParams());
                    if (viewComponent.hasLayout()) {
                        mergeLayout(viewComponent.getLayout());
                    }
                    if (viewComponent.hasAppearance()) {
                        mergeAppearance(viewComponent.getAppearance());
                    }
                    if (this.measurersBuilder_ == null) {
                        if (!viewComponent.measurers_.isEmpty()) {
                            if (this.measurers_.isEmpty()) {
                                this.measurers_ = viewComponent.measurers_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureMeasurersIsMutable();
                                this.measurers_.addAll(viewComponent.measurers_);
                            }
                            onChanged();
                        }
                    } else if (!viewComponent.measurers_.isEmpty()) {
                        if (!this.measurersBuilder_.isEmpty()) {
                            this.measurersBuilder_.addAllMessages(viewComponent.measurers_);
                        } else {
                            this.measurersBuilder_.dispose();
                            this.measurersBuilder_ = null;
                            this.measurers_ = viewComponent.measurers_;
                            this.bitField0_ &= -3;
                            this.measurersBuilder_ = ViewComponent.alwaysUseFieldBuilders ? getMeasurersFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(viewComponent.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    ViewComponent viewComponent = null;
                    try {
                        try {
                            ViewComponent viewComponent2 = (ViewComponent) ViewComponent.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (viewComponent2 != null) {
                                mergeFrom(viewComponent2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            ViewComponent viewComponent3 = (ViewComponent) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                viewComponent = viewComponent3;
                                if (viewComponent != null) {
                                    mergeFrom(viewComponent);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (viewComponent != null) {
                            mergeFrom(viewComponent);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.name_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public ByteString getNameBytes() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.name_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setName(String str) {
                    str.getClass();
                    this.name_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = ViewComponent.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    byteString.getClass();
                    ViewComponent.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public int getTypeValue() {
                    return this.type_;
                }

                public Builder setTypeValue(int i) {
                    this.type_ = i;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public ViewComponentType getType() {
                    ViewComponentType viewComponentTypeValueOf = ViewComponentType.valueOf(this.type_);
                    return viewComponentTypeValueOf == null ? ViewComponentType.UNRECOGNIZED : viewComponentTypeValueOf;
                }

                public Builder setType(ViewComponentType viewComponentType) {
                    viewComponentType.getClass();
                    this.type_ = viewComponentType.getNumber();
                    onChanged();
                    return this;
                }

                public Builder clearType() {
                    this.type_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public String getSource() {
                    Object obj = this.source_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.source_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public ByteString getSourceBytes() {
                    Object obj = this.source_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.source_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setSource(String str) {
                    str.getClass();
                    this.source_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearSource() {
                    this.source_ = ViewComponent.getDefaultInstance().getSource();
                    onChanged();
                    return this;
                }

                public Builder setSourceBytes(ByteString byteString) {
                    byteString.getClass();
                    ViewComponent.checkByteStringIsUtf8(byteString);
                    this.source_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public String getPlaceholder() {
                    Object obj = this.placeholder_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.placeholder_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public ByteString getPlaceholderBytes() {
                    Object obj = this.placeholder_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.placeholder_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setPlaceholder(String str) {
                    str.getClass();
                    this.placeholder_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearPlaceholder() {
                    this.placeholder_ = ViewComponent.getDefaultInstance().getPlaceholder();
                    onChanged();
                    return this;
                }

                public Builder setPlaceholderBytes(ByteString byteString) {
                    byteString.getClass();
                    ViewComponent.checkByteStringIsUtf8(byteString);
                    this.placeholder_ = byteString;
                    onChanged();
                    return this;
                }

                private MapField<String, String> internalGetCustomParams() {
                    MapField<String, String> mapField = this.customParams_;
                    return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
                }

                private MapField<String, String> internalGetMutableCustomParams() {
                    onChanged();
                    if (this.customParams_ == null) {
                        this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
                    }
                    if (!this.customParams_.isMutable()) {
                        this.customParams_ = this.customParams_.copy();
                    }
                    return this.customParams_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public int getCustomParamsCount() {
                    return internalGetCustomParams().getMap().size();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public boolean containsCustomParams(String str) {
                    str.getClass();
                    return internalGetCustomParams().getMap().containsKey(str);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                @Deprecated
                public Map<String, String> getCustomParams() {
                    return getCustomParamsMap();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public Map<String, String> getCustomParamsMap() {
                    return internalGetCustomParams().getMap();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public String getCustomParamsOrDefault(String str, String str2) {
                    str.getClass();
                    Map<String, String> map = internalGetCustomParams().getMap();
                    return map.containsKey(str) ? map.get(str) : str2;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public String getCustomParamsOrThrow(String str) {
                    str.getClass();
                    Map<String, String> map = internalGetCustomParams().getMap();
                    if (!map.containsKey(str)) {
                        throw new IllegalArgumentException();
                    }
                    return map.get(str);
                }

                public Builder clearCustomParams() {
                    internalGetMutableCustomParams().getMutableMap().clear();
                    return this;
                }

                public Builder removeCustomParams(String str) {
                    str.getClass();
                    internalGetMutableCustomParams().getMutableMap().remove(str);
                    return this;
                }

                @Deprecated
                public Map<String, String> getMutableCustomParams() {
                    return internalGetMutableCustomParams().getMutableMap();
                }

                public Builder putCustomParams(String str, String str2) {
                    str.getClass();
                    str2.getClass();
                    internalGetMutableCustomParams().getMutableMap().put(str, str2);
                    return this;
                }

                public Builder putAllCustomParams(Map<String, String> map) {
                    internalGetMutableCustomParams().getMutableMap().putAll(map);
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public boolean hasLayout() {
                    return (this.layoutBuilder_ == null && this.layout_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public Layout getLayout() {
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Layout layout = this.layout_;
                        return layout == null ? Layout.getDefaultInstance() : layout;
                    }
                    return (Layout) singleFieldBuilderV3.getMessage();
                }

                public Builder setLayout(Layout layout) {
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        layout.getClass();
                        this.layout_ = layout;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(layout);
                    }
                    return this;
                }

                public Builder setLayout(Layout.Builder builder) {
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.layout_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeLayout(Layout layout) {
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Layout layout2 = this.layout_;
                        if (layout2 != null) {
                            this.layout_ = Layout.newBuilder(layout2).mergeFrom(layout).buildPartial();
                        } else {
                            this.layout_ = layout;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(layout);
                    }
                    return this;
                }

                public Builder clearLayout() {
                    if (this.layoutBuilder_ == null) {
                        this.layout_ = null;
                        onChanged();
                    } else {
                        this.layout_ = null;
                        this.layoutBuilder_ = null;
                    }
                    return this;
                }

                public Layout.Builder getLayoutBuilder() {
                    onChanged();
                    return (Layout.Builder) getLayoutFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public LayoutOrBuilder getLayoutOrBuilder() {
                    SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> singleFieldBuilderV3 = this.layoutBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (LayoutOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    Layout layout = this.layout_;
                    return layout == null ? Layout.getDefaultInstance() : layout;
                }

                private SingleFieldBuilderV3<Layout, Layout.Builder, LayoutOrBuilder> getLayoutFieldBuilder() {
                    if (this.layoutBuilder_ == null) {
                        this.layoutBuilder_ = new SingleFieldBuilderV3<>(getLayout(), getParentForChildren(), isClean());
                        this.layout_ = null;
                    }
                    return this.layoutBuilder_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public boolean hasAppearance() {
                    return (this.appearanceBuilder_ == null && this.appearance_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public Appearance getAppearance() {
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV3 = this.appearanceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Appearance appearance = this.appearance_;
                        return appearance == null ? Appearance.getDefaultInstance() : appearance;
                    }
                    return (Appearance) singleFieldBuilderV3.getMessage();
                }

                public Builder setAppearance(Appearance appearance) {
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV3 = this.appearanceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        appearance.getClass();
                        this.appearance_ = appearance;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(appearance);
                    }
                    return this;
                }

                public Builder setAppearance(Appearance.Builder builder) {
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV3 = this.appearanceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.appearance_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeAppearance(Appearance appearance) {
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV3 = this.appearanceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Appearance appearance2 = this.appearance_;
                        if (appearance2 != null) {
                            this.appearance_ = Appearance.newBuilder(appearance2).mergeFrom(appearance).buildPartial();
                        } else {
                            this.appearance_ = appearance;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(appearance);
                    }
                    return this;
                }

                public Builder clearAppearance() {
                    if (this.appearanceBuilder_ == null) {
                        this.appearance_ = null;
                        onChanged();
                    } else {
                        this.appearance_ = null;
                        this.appearanceBuilder_ = null;
                    }
                    return this;
                }

                public Appearance.Builder getAppearanceBuilder() {
                    onChanged();
                    return (Appearance.Builder) getAppearanceFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public AppearanceOrBuilder getAppearanceOrBuilder() {
                    SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> singleFieldBuilderV3 = this.appearanceBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (AppearanceOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    Appearance appearance = this.appearance_;
                    return appearance == null ? Appearance.getDefaultInstance() : appearance;
                }

                private SingleFieldBuilderV3<Appearance, Appearance.Builder, AppearanceOrBuilder> getAppearanceFieldBuilder() {
                    if (this.appearanceBuilder_ == null) {
                        this.appearanceBuilder_ = new SingleFieldBuilderV3<>(getAppearance(), getParentForChildren(), isClean());
                        this.appearance_ = null;
                    }
                    return this.appearanceBuilder_;
                }

                private void ensureMeasurersIsMutable() {
                    if ((this.bitField0_ & 2) == 0) {
                        this.measurers_ = new ArrayList(this.measurers_);
                        this.bitField0_ |= 2;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public List<Measurer> getMeasurersList() {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.measurers_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public int getMeasurersCount() {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.measurers_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public Measurer getMeasurers(int i) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.measurers_.get(i);
                    }
                    return (Measurer) repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setMeasurers(int i, Measurer measurer) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        measurer.getClass();
                        ensureMeasurersIsMutable();
                        this.measurers_.set(i, measurer);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.setMessage(i, measurer);
                    }
                    return this;
                }

                public Builder setMeasurers(int i, Measurer.Builder builder) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureMeasurersIsMutable();
                        this.measurers_.set(i, builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.setMessage(i, builder.build());
                    }
                    return this;
                }

                public Builder addMeasurers(Measurer measurer) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        measurer.getClass();
                        ensureMeasurersIsMutable();
                        this.measurers_.add(measurer);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(measurer);
                    }
                    return this;
                }

                public Builder addMeasurers(int i, Measurer measurer) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        measurer.getClass();
                        ensureMeasurersIsMutable();
                        this.measurers_.add(i, measurer);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(i, measurer);
                    }
                    return this;
                }

                public Builder addMeasurers(Measurer.Builder builder) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureMeasurersIsMutable();
                        this.measurers_.add(builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(builder.build());
                    }
                    return this;
                }

                public Builder addMeasurers(int i, Measurer.Builder builder) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureMeasurersIsMutable();
                        this.measurers_.add(i, builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(i, builder.build());
                    }
                    return this;
                }

                public Builder addAllMeasurers(Iterable<? extends Measurer> iterable) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureMeasurersIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.measurers_);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addAllMessages(iterable);
                    }
                    return this;
                }

                public Builder clearMeasurers() {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.measurers_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.clear();
                    }
                    return this;
                }

                public Builder removeMeasurers(int i) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureMeasurersIsMutable();
                        this.measurers_.remove(i);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.remove(i);
                    }
                    return this;
                }

                public Measurer.Builder getMeasurersBuilder(int i) {
                    return (Measurer.Builder) getMeasurersFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public MeasurerOrBuilder getMeasurersOrBuilder(int i) {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.measurers_.get(i);
                    }
                    return (MeasurerOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.ViewComponentOrBuilder
                public List<? extends MeasurerOrBuilder> getMeasurersOrBuilderList() {
                    RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> repeatedFieldBuilderV3 = this.measurersBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.measurers_);
                }

                public Measurer.Builder addMeasurersBuilder() {
                    return (Measurer.Builder) getMeasurersFieldBuilder().addBuilder(Measurer.getDefaultInstance());
                }

                public Measurer.Builder addMeasurersBuilder(int i) {
                    return (Measurer.Builder) getMeasurersFieldBuilder().addBuilder(i, Measurer.getDefaultInstance());
                }

                public List<Measurer.Builder> getMeasurersBuilderList() {
                    return getMeasurersFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<Measurer, Measurer.Builder, MeasurerOrBuilder> getMeasurersFieldBuilder() {
                    if (this.measurersBuilder_ == null) {
                        this.measurersBuilder_ = new RepeatedFieldBuilderV3<>(this.measurers_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                        this.measurers_ = null;
                    }
                    return this.measurersBuilder_;
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

            public static ViewComponent getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ViewComponent> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<ViewComponent> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public ViewComponent getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class MethodComponent extends GeneratedMessageV3 implements MethodComponentOrBuilder {
            public static final int NAME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private volatile Object name_;
            private static final MethodComponent DEFAULT_INSTANCE = new MethodComponent();
            private static final Parser<MethodComponent> PARSER = new AbstractParser<MethodComponent>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.MethodComponent.1
                @Override // com.explorestack.protobuf.Parser
                public MethodComponent parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new MethodComponent(codedInputStream, extensionRegistryLite);
                }
            };

            private MethodComponent(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private MethodComponent() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new MethodComponent();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private MethodComponent(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
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
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_fieldAccessorTable.ensureFieldAccessorsInitialized(MethodComponent.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.MethodComponentOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.MethodComponentOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
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
                if (!getNameBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = (!getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) : 0) + this.unknownFields.getSerializedSize();
                this.memoizedSize = iComputeStringSize;
                return iComputeStringSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MethodComponent)) {
                    return super.equals(obj);
                }
                MethodComponent methodComponent = (MethodComponent) obj;
                return getName().equals(methodComponent.getName()) && this.unknownFields.equals(methodComponent.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode;
                return iHashCode;
            }

            public static MethodComponent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static MethodComponent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static MethodComponent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static MethodComponent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static MethodComponent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static MethodComponent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static MethodComponent parseFrom(InputStream inputStream) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static MethodComponent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static MethodComponent parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static MethodComponent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static MethodComponent parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static MethodComponent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MethodComponent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(MethodComponent methodComponent) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(methodComponent);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MethodComponentOrBuilder {
                private Object name_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_fieldAccessorTable.ensureFieldAccessorsInitialized(MethodComponent.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = MethodComponent.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.name_ = "";
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public MethodComponent getDefaultInstanceForType() {
                    return MethodComponent.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public MethodComponent build() {
                    MethodComponent methodComponentBuildPartial = buildPartial();
                    if (methodComponentBuildPartial.isInitialized()) {
                        return methodComponentBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) methodComponentBuildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public MethodComponent buildPartial() {
                    MethodComponent methodComponent = new MethodComponent(this);
                    methodComponent.name_ = this.name_;
                    onBuilt();
                    return methodComponent;
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
                    if (message instanceof MethodComponent) {
                        return mergeFrom((MethodComponent) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(MethodComponent methodComponent) {
                    if (methodComponent == MethodComponent.getDefaultInstance()) {
                        return this;
                    }
                    if (!methodComponent.getName().isEmpty()) {
                        this.name_ = methodComponent.name_;
                        onChanged();
                    }
                    mergeUnknownFields(methodComponent.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    MethodComponent methodComponent = null;
                    try {
                        try {
                            MethodComponent methodComponent2 = (MethodComponent) MethodComponent.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (methodComponent2 != null) {
                                mergeFrom(methodComponent2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            MethodComponent methodComponent3 = (MethodComponent) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                methodComponent = methodComponent3;
                                if (methodComponent != null) {
                                    mergeFrom(methodComponent);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (methodComponent != null) {
                            mergeFrom(methodComponent);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.MethodComponentOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.name_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.MethodComponentOrBuilder
                public ByteString getNameBytes() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.name_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setName(String str) {
                    str.getClass();
                    this.name_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = MethodComponent.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    byteString.getClass();
                    MethodComponent.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
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

            public static MethodComponent getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<MethodComponent> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<MethodComponent> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public MethodComponent getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class Event extends GeneratedMessageV3 implements EventOrBuilder {
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int SOURCE_FIELD_NUMBER = 2;
            public static final int TASKS_FIELD_NUMBER = 3;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private int name_;
            private volatile Object source_;
            private List<Task> tasks_;
            private static final Event DEFAULT_INSTANCE = new Event();
            private static final Parser<Event> PARSER = new AbstractParser<Event>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.Event.1
                @Override // com.explorestack.protobuf.Parser
                public Event parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Event(codedInputStream, extensionRegistryLite);
                }
            };

            public interface TaskOrBuilder extends MessageOrBuilder {
                Task.TaskName getName();

                int getNameValue();

                String getTarget();

                ByteString getTargetBytes();

                String getValue();

                ByteString getValueBytes();
            }

            private Event(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private Event() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = 0;
                this.source_ = "";
                this.tasks_ = Collections.emptyList();
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
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 8) {
                                        this.name_ = codedInputStream.readEnum();
                                    } else if (tag == 18) {
                                        this.source_ = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 26) {
                                        if (!z2) {
                                            this.tasks_ = new ArrayList();
                                            z2 = true;
                                        }
                                        this.tasks_.add((Task) codedInputStream.readMessage(Task.parser(), extensionRegistryLite));
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
                        if (z2) {
                            this.tasks_ = Collections.unmodifiableList(this.tasks_);
                        }
                        this.unknownFields = builderNewBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (z2) {
                    this.tasks_ = Collections.unmodifiableList(this.tasks_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
            }

            public enum EventName implements ProtocolMessageEnum {
                EVENT_NAME_INVALID(0),
                EVENT_NAME_ON_IMPRESSION(1),
                EVENT_NAME_ON_CLICK(2),
                EVENT_NAME_ON_PROGRESS(3),
                EVENT_NAME_ON_NAVIGATE(4),
                EVENT_NAME_ON_MUTE(5),
                EVENT_NAME_ON_UNMUTE(6),
                EVENT_NAME_ON_PAUSE(7),
                EVENT_NAME_ON_RESUME(8),
                EVENT_NAME_ON_SKIP(9),
                EVENT_NAME_ON_CLOSE(10),
                EVENT_NAME_ON_START(11),
                EVENT_NAME_ON_FIRST_QUARTILE(12),
                EVENT_NAME_ON_MIDPOINT(13),
                EVENT_NAME_ON_THIRD_QUARTILE(14),
                EVENT_NAME_ON_COMPLETE(15),
                EVENT_NAME_ON_USE_CUSTOM_CLOSE(16),
                EVENT_NAME_ON_SCHEDULED(17),
                UNRECOGNIZED(-1);

                public static final int EVENT_NAME_INVALID_VALUE = 0;
                public static final int EVENT_NAME_ON_CLICK_VALUE = 2;
                public static final int EVENT_NAME_ON_CLOSE_VALUE = 10;
                public static final int EVENT_NAME_ON_COMPLETE_VALUE = 15;
                public static final int EVENT_NAME_ON_FIRST_QUARTILE_VALUE = 12;
                public static final int EVENT_NAME_ON_IMPRESSION_VALUE = 1;
                public static final int EVENT_NAME_ON_MIDPOINT_VALUE = 13;
                public static final int EVENT_NAME_ON_MUTE_VALUE = 5;
                public static final int EVENT_NAME_ON_NAVIGATE_VALUE = 4;
                public static final int EVENT_NAME_ON_PAUSE_VALUE = 7;
                public static final int EVENT_NAME_ON_PROGRESS_VALUE = 3;
                public static final int EVENT_NAME_ON_RESUME_VALUE = 8;
                public static final int EVENT_NAME_ON_SCHEDULED_VALUE = 17;
                public static final int EVENT_NAME_ON_SKIP_VALUE = 9;
                public static final int EVENT_NAME_ON_START_VALUE = 11;
                public static final int EVENT_NAME_ON_THIRD_QUARTILE_VALUE = 14;
                public static final int EVENT_NAME_ON_UNMUTE_VALUE = 6;
                public static final int EVENT_NAME_ON_USE_CUSTOM_CLOSE_VALUE = 16;
                private final int value;
                private static final Internal.EnumLiteMap<EventName> internalValueMap = new Internal.EnumLiteMap<EventName>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.Event.EventName.1
                    @Override // com.explorestack.protobuf.Internal.EnumLiteMap
                    public EventName findValueByNumber(int i) {
                        return EventName.forNumber(i);
                    }
                };
                private static final EventName[] VALUES = values();

                @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static EventName valueOf(int i) {
                    return forNumber(i);
                }

                public static EventName forNumber(int i) {
                    switch (i) {
                        case 0:
                            return EVENT_NAME_INVALID;
                        case 1:
                            return EVENT_NAME_ON_IMPRESSION;
                        case 2:
                            return EVENT_NAME_ON_CLICK;
                        case 3:
                            return EVENT_NAME_ON_PROGRESS;
                        case 4:
                            return EVENT_NAME_ON_NAVIGATE;
                        case 5:
                            return EVENT_NAME_ON_MUTE;
                        case 6:
                            return EVENT_NAME_ON_UNMUTE;
                        case 7:
                            return EVENT_NAME_ON_PAUSE;
                        case 8:
                            return EVENT_NAME_ON_RESUME;
                        case 9:
                            return EVENT_NAME_ON_SKIP;
                        case 10:
                            return EVENT_NAME_ON_CLOSE;
                        case 11:
                            return EVENT_NAME_ON_START;
                        case 12:
                            return EVENT_NAME_ON_FIRST_QUARTILE;
                        case 13:
                            return EVENT_NAME_ON_MIDPOINT;
                        case 14:
                            return EVENT_NAME_ON_THIRD_QUARTILE;
                        case 15:
                            return EVENT_NAME_ON_COMPLETE;
                        case 16:
                            return EVENT_NAME_ON_USE_CUSTOM_CLOSE;
                        case 17:
                            return EVENT_NAME_ON_SCHEDULED;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<EventName> internalGetValueMap() {
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
                    return Event.getDescriptor().getEnumTypes().get(0);
                }

                public static EventName valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                    if (enumValueDescriptor.getType() != getDescriptor()) {
                        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                    }
                    if (enumValueDescriptor.getIndex() == -1) {
                        return UNRECOGNIZED;
                    }
                    return VALUES[enumValueDescriptor.getIndex()];
                }

                EventName(int i) {
                    this.value = i;
                }
            }

            public static final class Task extends GeneratedMessageV3 implements TaskOrBuilder {
                public static final int NAME_FIELD_NUMBER = 1;
                public static final int TARGET_FIELD_NUMBER = 2;
                public static final int VALUE_FIELD_NUMBER = 3;
                private static final long serialVersionUID = 0;
                private byte memoizedIsInitialized;
                private int name_;
                private volatile Object target_;
                private volatile Object value_;
                private static final Task DEFAULT_INSTANCE = new Task();
                private static final Parser<Task> PARSER = new AbstractParser<Task>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.Event.Task.1
                    @Override // com.explorestack.protobuf.Parser
                    public Task parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Task(codedInputStream, extensionRegistryLite);
                    }
                };

                private Task(GeneratedMessageV3.Builder<?> builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                }

                private Task() {
                    this.memoizedIsInitialized = (byte) -1;
                    this.name_ = 0;
                    this.target_ = "";
                    this.value_ = "";
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                    return new Task();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
                public final UnknownFieldSet getUnknownFields() {
                    return this.unknownFields;
                }

                private Task(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.name_ = codedInputStream.readEnum();
                                    } else if (tag == 18) {
                                        this.target_ = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 26) {
                                        this.value_ = codedInputStream.readStringRequireUtf8();
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
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_fieldAccessorTable.ensureFieldAccessorsInitialized(Task.class, Builder.class);
                }

                public enum TaskName implements ProtocolMessageEnum {
                    TASK_NAME_INVALID(0),
                    TASK_NAME_START(1),
                    TASK_NAME_MUTE(2),
                    TASK_NAME_UNMUTE(3),
                    TASK_NAME_TRACK(4),
                    TASK_NAME_CLOSE(5),
                    TASK_NAME_SKIP(6),
                    TASK_NAME_OPEN(7),
                    TASK_NAME_SHOW(8),
                    TASK_NAME_HIDE(9),
                    TASK_NAME_PROGRESS(10),
                    TASK_NAME_SCHEDULE(11),
                    TASK_NAME_LOCK_VISIBILITY(12),
                    TASK_NAME_UNLOCK_VISIBILITY(13),
                    TASK_NAME_SHOW_OVERLAY(14),
                    TASK_NAME_HIDE_OVERLAY(15),
                    TASK_NAME_NOTIFY_OPEN(16),
                    TASK_NAME_SIMULATE_CLICK(17),
                    TASK_NAME_PRIVACY_SHEET(18),
                    TASK_NAME_REPEAT(19),
                    UNRECOGNIZED(-1);

                    public static final int TASK_NAME_CLOSE_VALUE = 5;
                    public static final int TASK_NAME_HIDE_OVERLAY_VALUE = 15;
                    public static final int TASK_NAME_HIDE_VALUE = 9;
                    public static final int TASK_NAME_INVALID_VALUE = 0;
                    public static final int TASK_NAME_LOCK_VISIBILITY_VALUE = 12;
                    public static final int TASK_NAME_MUTE_VALUE = 2;
                    public static final int TASK_NAME_NOTIFY_OPEN_VALUE = 16;
                    public static final int TASK_NAME_OPEN_VALUE = 7;
                    public static final int TASK_NAME_PRIVACY_SHEET_VALUE = 18;
                    public static final int TASK_NAME_PROGRESS_VALUE = 10;
                    public static final int TASK_NAME_REPEAT_VALUE = 19;
                    public static final int TASK_NAME_SCHEDULE_VALUE = 11;
                    public static final int TASK_NAME_SHOW_OVERLAY_VALUE = 14;
                    public static final int TASK_NAME_SHOW_VALUE = 8;
                    public static final int TASK_NAME_SIMULATE_CLICK_VALUE = 17;
                    public static final int TASK_NAME_SKIP_VALUE = 6;
                    public static final int TASK_NAME_START_VALUE = 1;
                    public static final int TASK_NAME_TRACK_VALUE = 4;
                    public static final int TASK_NAME_UNLOCK_VISIBILITY_VALUE = 13;
                    public static final int TASK_NAME_UNMUTE_VALUE = 3;
                    private final int value;
                    private static final Internal.EnumLiteMap<TaskName> internalValueMap = new Internal.EnumLiteMap<TaskName>() { // from class: io.bidmachine.protobuf.rendering.Rendering.Phase.Event.Task.TaskName.1
                        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
                        public TaskName findValueByNumber(int i) {
                            return TaskName.forNumber(i);
                        }
                    };
                    private static final TaskName[] VALUES = values();

                    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        if (this == UNRECOGNIZED) {
                            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                        }
                        return this.value;
                    }

                    @Deprecated
                    public static TaskName valueOf(int i) {
                        return forNumber(i);
                    }

                    public static TaskName forNumber(int i) {
                        switch (i) {
                            case 0:
                                return TASK_NAME_INVALID;
                            case 1:
                                return TASK_NAME_START;
                            case 2:
                                return TASK_NAME_MUTE;
                            case 3:
                                return TASK_NAME_UNMUTE;
                            case 4:
                                return TASK_NAME_TRACK;
                            case 5:
                                return TASK_NAME_CLOSE;
                            case 6:
                                return TASK_NAME_SKIP;
                            case 7:
                                return TASK_NAME_OPEN;
                            case 8:
                                return TASK_NAME_SHOW;
                            case 9:
                                return TASK_NAME_HIDE;
                            case 10:
                                return TASK_NAME_PROGRESS;
                            case 11:
                                return TASK_NAME_SCHEDULE;
                            case 12:
                                return TASK_NAME_LOCK_VISIBILITY;
                            case 13:
                                return TASK_NAME_UNLOCK_VISIBILITY;
                            case 14:
                                return TASK_NAME_SHOW_OVERLAY;
                            case 15:
                                return TASK_NAME_HIDE_OVERLAY;
                            case 16:
                                return TASK_NAME_NOTIFY_OPEN;
                            case 17:
                                return TASK_NAME_SIMULATE_CLICK;
                            case 18:
                                return TASK_NAME_PRIVACY_SHEET;
                            case 19:
                                return TASK_NAME_REPEAT;
                            default:
                                return null;
                        }
                    }

                    public static Internal.EnumLiteMap<TaskName> internalGetValueMap() {
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
                        return Task.getDescriptor().getEnumTypes().get(0);
                    }

                    public static TaskName valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                        if (enumValueDescriptor.getType() != getDescriptor()) {
                            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                        }
                        if (enumValueDescriptor.getIndex() == -1) {
                            return UNRECOGNIZED;
                        }
                        return VALUES[enumValueDescriptor.getIndex()];
                    }

                    TaskName(int i) {
                        this.value = i;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public int getNameValue() {
                    return this.name_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public TaskName getName() {
                    TaskName taskNameValueOf = TaskName.valueOf(this.name_);
                    return taskNameValueOf == null ? TaskName.UNRECOGNIZED : taskNameValueOf;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public String getTarget() {
                    Object obj = this.target_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.target_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public ByteString getTargetBytes() {
                    Object obj = this.target_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.target_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public String getValue() {
                    Object obj = this.value_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.value_ = stringUtf8;
                    return stringUtf8;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                public ByteString getValueBytes() {
                    Object obj = this.value_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.value_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
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
                    if (this.name_ != TaskName.TASK_NAME_INVALID.getNumber()) {
                        codedOutputStream.writeEnum(1, this.name_);
                    }
                    if (!getTargetBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 2, this.target_);
                    }
                    if (!getValueBytes().isEmpty()) {
                        GeneratedMessageV3.writeString(codedOutputStream, 3, this.value_);
                    }
                    this.unknownFields.writeTo(codedOutputStream);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
                public int getSerializedSize() {
                    int i = this.memoizedSize;
                    if (i != -1) {
                        return i;
                    }
                    int iComputeEnumSize = this.name_ != TaskName.TASK_NAME_INVALID.getNumber() ? CodedOutputStream.computeEnumSize(1, this.name_) : 0;
                    if (!getTargetBytes().isEmpty()) {
                        iComputeEnumSize += GeneratedMessageV3.computeStringSize(2, this.target_);
                    }
                    if (!getValueBytes().isEmpty()) {
                        iComputeEnumSize += GeneratedMessageV3.computeStringSize(3, this.value_);
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
                    if (!(obj instanceof Task)) {
                        return super.equals(obj);
                    }
                    Task task = (Task) obj;
                    return this.name_ == task.name_ && getTarget().equals(task.getTarget()) && getValue().equals(task.getValue()) && this.unknownFields.equals(task.unknownFields);
                }

                @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
                public int hashCode() {
                    if (this.memoizedHashCode != 0) {
                        return this.memoizedHashCode;
                    }
                    int iHashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.name_) * 37) + 2) * 53) + getTarget().hashCode()) * 37) + 3) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
                    this.memoizedHashCode = iHashCode;
                    return iHashCode;
                }

                public static Task parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer);
                }

                public static Task parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
                }

                public static Task parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString);
                }

                public static Task parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString, extensionRegistryLite);
                }

                public static Task parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr);
                }

                public static Task parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr, extensionRegistryLite);
                }

                public static Task parseFrom(InputStream inputStream) throws IOException {
                    return (Task) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
                }

                public static Task parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Task) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Task parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Task) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
                }

                public static Task parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Task) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
                }

                public static Task parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Task) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
                }

                public static Task parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Task) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
                }

                @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.toBuilder();
                }

                public static Builder newBuilder(Task task) {
                    return DEFAULT_INSTANCE.toBuilder().mergeFrom(task);
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

                public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TaskOrBuilder {
                    private int name_;
                    private Object target_;
                    private Object value_;

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        return true;
                    }

                    public static final Descriptors.Descriptor getDescriptor() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_descriptor;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_fieldAccessorTable.ensureFieldAccessorsInitialized(Task.class, Builder.class);
                    }

                    private Builder() {
                        this.name_ = 0;
                        this.target_ = "";
                        this.value_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                        super(builderParent);
                        this.name_ = 0;
                        this.target_ = "";
                        this.value_ = "";
                        maybeForceBuilderInitialization();
                    }

                    private void maybeForceBuilderInitialization() {
                        boolean unused = Task.alwaysUseFieldBuilders;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder clear() {
                        super.clear();
                        this.name_ = 0;
                        this.target_ = "";
                        this.value_ = "";
                        return this;
                    }

                    @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                    public Descriptors.Descriptor getDescriptorForType() {
                        return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_descriptor;
                    }

                    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                    public Task getDefaultInstanceForType() {
                        return Task.getDefaultInstance();
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Task build() {
                        Task taskBuildPartial = buildPartial();
                        if (taskBuildPartial.isInitialized()) {
                            return taskBuildPartial;
                        }
                        throw newUninitializedMessageException((Message) taskBuildPartial);
                    }

                    @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Task buildPartial() {
                        Task task = new Task(this);
                        task.name_ = this.name_;
                        task.target_ = this.target_;
                        task.value_ = this.value_;
                        onBuilt();
                        return task;
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
                        if (message instanceof Task) {
                            return mergeFrom((Task) message);
                        }
                        super.mergeFrom(message);
                        return this;
                    }

                    public Builder mergeFrom(Task task) {
                        if (task == Task.getDefaultInstance()) {
                            return this;
                        }
                        if (task.name_ != 0) {
                            setNameValue(task.getNameValue());
                        }
                        if (!task.getTarget().isEmpty()) {
                            this.target_ = task.target_;
                            onChanged();
                        }
                        if (!task.getValue().isEmpty()) {
                            this.value_ = task.value_;
                            onChanged();
                        }
                        mergeUnknownFields(task.unknownFields);
                        onChanged();
                        return this;
                    }

                    /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                    @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                        Task task = null;
                        try {
                            try {
                                Task task2 = (Task) Task.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (task2 != null) {
                                    mergeFrom(task2);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e) {
                                Task task3 = (Task) e.getUnfinishedMessage();
                                try {
                                    throw e.unwrapIOException();
                                } catch (Throwable th) {
                                    th = th;
                                    task = task3;
                                    if (task != null) {
                                        mergeFrom(task);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (task != null) {
                                mergeFrom(task);
                            }
                            throw th;
                        }
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public int getNameValue() {
                        return this.name_;
                    }

                    public Builder setNameValue(int i) {
                        this.name_ = i;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public TaskName getName() {
                        TaskName taskNameValueOf = TaskName.valueOf(this.name_);
                        return taskNameValueOf == null ? TaskName.UNRECOGNIZED : taskNameValueOf;
                    }

                    public Builder setName(TaskName taskName) {
                        taskName.getClass();
                        this.name_ = taskName.getNumber();
                        onChanged();
                        return this;
                    }

                    public Builder clearName() {
                        this.name_ = 0;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public String getTarget() {
                        Object obj = this.target_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.target_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public ByteString getTargetBytes() {
                        Object obj = this.target_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.target_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setTarget(String str) {
                        str.getClass();
                        this.target_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearTarget() {
                        this.target_ = Task.getDefaultInstance().getTarget();
                        onChanged();
                        return this;
                    }

                    public Builder setTargetBytes(ByteString byteString) {
                        byteString.getClass();
                        Task.checkByteStringIsUtf8(byteString);
                        this.target_ = byteString;
                        onChanged();
                        return this;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public String getValue() {
                        Object obj = this.value_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.value_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }

                    @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.Event.TaskOrBuilder
                    public ByteString getValueBytes() {
                        Object obj = this.value_;
                        if (obj instanceof String) {
                            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.value_ = byteStringCopyFromUtf8;
                            return byteStringCopyFromUtf8;
                        }
                        return (ByteString) obj;
                    }

                    public Builder setValue(String str) {
                        str.getClass();
                        this.value_ = str;
                        onChanged();
                        return this;
                    }

                    public Builder clearValue() {
                        this.value_ = Task.getDefaultInstance().getValue();
                        onChanged();
                        return this;
                    }

                    public Builder setValueBytes(ByteString byteString) {
                        byteString.getClass();
                        Task.checkByteStringIsUtf8(byteString);
                        this.value_ = byteString;
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

                public static Task getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Task> parser() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
                public Parser<Task> getParserForType() {
                    return PARSER;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Task getDefaultInstanceForType() {
                    return DEFAULT_INSTANCE;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public int getNameValue() {
                return this.name_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public EventName getName() {
                EventName eventNameValueOf = EventName.valueOf(this.name_);
                return eventNameValueOf == null ? EventName.UNRECOGNIZED : eventNameValueOf;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public List<Task> getTasksList() {
                return this.tasks_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public List<? extends TaskOrBuilder> getTasksOrBuilderList() {
                return this.tasks_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public int getTasksCount() {
                return this.tasks_.size();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public Task getTasks(int i) {
                return this.tasks_.get(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
            public TaskOrBuilder getTasksOrBuilder(int i) {
                return this.tasks_.get(i);
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
                if (this.name_ != EventName.EVENT_NAME_INVALID.getNumber()) {
                    codedOutputStream.writeEnum(1, this.name_);
                }
                if (!getSourceBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 2, this.source_);
                }
                for (int i = 0; i < this.tasks_.size(); i++) {
                    codedOutputStream.writeMessage(3, this.tasks_.get(i));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeEnumSize = this.name_ != EventName.EVENT_NAME_INVALID.getNumber() ? CodedOutputStream.computeEnumSize(1, this.name_) : 0;
                if (!getSourceBytes().isEmpty()) {
                    iComputeEnumSize += GeneratedMessageV3.computeStringSize(2, this.source_);
                }
                for (int i2 = 0; i2 < this.tasks_.size(); i2++) {
                    iComputeEnumSize += CodedOutputStream.computeMessageSize(3, this.tasks_.get(i2));
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
                if (!(obj instanceof Event)) {
                    return super.equals(obj);
                }
                Event event = (Event) obj;
                return this.name_ == event.name_ && getSource().equals(event.getSource()) && getTasksList().equals(event.getTasksList()) && this.unknownFields.equals(event.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.name_) * 37) + 2) * 53) + getSource().hashCode();
                if (getTasksCount() > 0) {
                    iHashCode = (((iHashCode * 37) + 3) * 53) + getTasksList().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
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
                private int bitField0_;
                private int name_;
                private Object source_;
                private RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> tasksBuilder_;
                private List<Task> tasks_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
                }

                private Builder() {
                    this.name_ = 0;
                    this.source_ = "";
                    this.tasks_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = 0;
                    this.source_ = "";
                    this.tasks_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (Event.alwaysUseFieldBuilders) {
                        getTasksFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.name_ = 0;
                    this.source_ = "";
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.tasks_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                    } else {
                        repeatedFieldBuilderV3.clear();
                    }
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_Event_descriptor;
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
                    event.name_ = this.name_;
                    event.source_ = this.source_;
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        event.tasks_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 1) != 0) {
                            this.tasks_ = Collections.unmodifiableList(this.tasks_);
                            this.bitField0_ &= -2;
                        }
                        event.tasks_ = this.tasks_;
                    }
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
                    if (event.name_ != 0) {
                        setNameValue(event.getNameValue());
                    }
                    if (!event.getSource().isEmpty()) {
                        this.source_ = event.source_;
                        onChanged();
                    }
                    if (this.tasksBuilder_ == null) {
                        if (!event.tasks_.isEmpty()) {
                            if (this.tasks_.isEmpty()) {
                                this.tasks_ = event.tasks_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureTasksIsMutable();
                                this.tasks_.addAll(event.tasks_);
                            }
                            onChanged();
                        }
                    } else if (!event.tasks_.isEmpty()) {
                        if (!this.tasksBuilder_.isEmpty()) {
                            this.tasksBuilder_.addAllMessages(event.tasks_);
                        } else {
                            this.tasksBuilder_.dispose();
                            this.tasksBuilder_ = null;
                            this.tasks_ = event.tasks_;
                            this.bitField0_ &= -2;
                            this.tasksBuilder_ = Event.alwaysUseFieldBuilders ? getTasksFieldBuilder() : null;
                        }
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

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public int getNameValue() {
                    return this.name_;
                }

                public Builder setNameValue(int i) {
                    this.name_ = i;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public EventName getName() {
                    EventName eventNameValueOf = EventName.valueOf(this.name_);
                    return eventNameValueOf == null ? EventName.UNRECOGNIZED : eventNameValueOf;
                }

                public Builder setName(EventName eventName) {
                    eventName.getClass();
                    this.name_ = eventName.getNumber();
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public String getSource() {
                    Object obj = this.source_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.source_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public ByteString getSourceBytes() {
                    Object obj = this.source_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.source_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setSource(String str) {
                    str.getClass();
                    this.source_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearSource() {
                    this.source_ = Event.getDefaultInstance().getSource();
                    onChanged();
                    return this;
                }

                public Builder setSourceBytes(ByteString byteString) {
                    byteString.getClass();
                    Event.checkByteStringIsUtf8(byteString);
                    this.source_ = byteString;
                    onChanged();
                    return this;
                }

                private void ensureTasksIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.tasks_ = new ArrayList(this.tasks_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public List<Task> getTasksList() {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.tasks_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public int getTasksCount() {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.tasks_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public Task getTasks(int i) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.tasks_.get(i);
                    }
                    return (Task) repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setTasks(int i, Task task) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        task.getClass();
                        ensureTasksIsMutable();
                        this.tasks_.set(i, task);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.setMessage(i, task);
                    }
                    return this;
                }

                public Builder setTasks(int i, Task.Builder builder) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureTasksIsMutable();
                        this.tasks_.set(i, builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.setMessage(i, builder.build());
                    }
                    return this;
                }

                public Builder addTasks(Task task) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        task.getClass();
                        ensureTasksIsMutable();
                        this.tasks_.add(task);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(task);
                    }
                    return this;
                }

                public Builder addTasks(int i, Task task) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        task.getClass();
                        ensureTasksIsMutable();
                        this.tasks_.add(i, task);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(i, task);
                    }
                    return this;
                }

                public Builder addTasks(Task.Builder builder) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureTasksIsMutable();
                        this.tasks_.add(builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(builder.build());
                    }
                    return this;
                }

                public Builder addTasks(int i, Task.Builder builder) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureTasksIsMutable();
                        this.tasks_.add(i, builder.build());
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addMessage(i, builder.build());
                    }
                    return this;
                }

                public Builder addAllTasks(Iterable<? extends Task> iterable) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureTasksIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.tasks_);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.addAllMessages(iterable);
                    }
                    return this;
                }

                public Builder clearTasks() {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.tasks_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.clear();
                    }
                    return this;
                }

                public Builder removeTasks(int i) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureTasksIsMutable();
                        this.tasks_.remove(i);
                        onChanged();
                    } else {
                        repeatedFieldBuilderV3.remove(i);
                    }
                    return this;
                }

                public Task.Builder getTasksBuilder(int i) {
                    return (Task.Builder) getTasksFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public TaskOrBuilder getTasksOrBuilder(int i) {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.tasks_.get(i);
                    }
                    return (TaskOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.Phase.EventOrBuilder
                public List<? extends TaskOrBuilder> getTasksOrBuilderList() {
                    RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> repeatedFieldBuilderV3 = this.tasksBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.tasks_);
                }

                public Task.Builder addTasksBuilder() {
                    return (Task.Builder) getTasksFieldBuilder().addBuilder(Task.getDefaultInstance());
                }

                public Task.Builder addTasksBuilder(int i) {
                    return (Task.Builder) getTasksFieldBuilder().addBuilder(i, Task.getDefaultInstance());
                }

                public List<Task.Builder> getTasksBuilderList() {
                    return getTasksFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<Task, Task.Builder, TaskOrBuilder> getTasksFieldBuilder() {
                    if (this.tasksBuilder_ == null) {
                        this.tasksBuilder_ = new RepeatedFieldBuilderV3<>(this.tasks_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.tasks_ = null;
                    }
                    return this.tasksBuilder_;
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

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getSequence() {
            return this.sequence_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public String getBackgroundColor() {
            Object obj = this.backgroundColor_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.backgroundColor_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public ByteString getBackgroundColorBytes() {
            Object obj = this.backgroundColor_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.backgroundColor_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<ViewComponent> getAdsList() {
            return this.ads_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<? extends ViewComponentOrBuilder> getAdsOrBuilderList() {
            return this.ads_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getAdsCount() {
            return this.ads_.size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public ViewComponent getAds(int i) {
            return this.ads_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public ViewComponentOrBuilder getAdsOrBuilder(int i) {
            return this.ads_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<ViewComponent> getControlsList() {
            return this.controls_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<? extends ViewComponentOrBuilder> getControlsOrBuilderList() {
            return this.controls_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getControlsCount() {
            return this.controls_.size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public ViewComponent getControls(int i) {
            return this.controls_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public ViewComponentOrBuilder getControlsOrBuilder(int i) {
            return this.controls_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<MethodComponent> getMethodsList() {
            return this.methods_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<? extends MethodComponentOrBuilder> getMethodsOrBuilderList() {
            return this.methods_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getMethodsCount() {
            return this.methods_.size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public MethodComponent getMethods(int i) {
            return this.methods_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public MethodComponentOrBuilder getMethodsOrBuilder(int i) {
            return this.methods_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<Event> getEventsList() {
            return this.events_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public List<? extends EventOrBuilder> getEventsOrBuilderList() {
            return this.events_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getEventsCount() {
            return this.events_.size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public Event getEvents(int i) {
            return this.events_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public EventOrBuilder getEventsOrBuilder(int i) {
            return this.events_.get(i);
        }

        private static final class CustomParamsDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_CustomParamsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private CustomParamsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetCustomParams() {
            MapField<String, String> mapField = this.customParams_;
            return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public int getCustomParamsCount() {
            return internalGetCustomParams().getMap().size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public boolean containsCustomParams(String str) {
            str.getClass();
            return internalGetCustomParams().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        @Deprecated
        public Map<String, String> getCustomParams() {
            return getCustomParamsMap();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public Map<String, String> getCustomParamsMap() {
            return internalGetCustomParams().getMap();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public String getCustomParamsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> map = internalGetCustomParams().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
        public String getCustomParamsOrThrow(String str) {
            str.getClass();
            Map<String, String> map = internalGetCustomParams().getMap();
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
            int i = this.sequence_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (!getBackgroundColorBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.backgroundColor_);
            }
            for (int i2 = 0; i2 < this.ads_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.ads_.get(i2));
            }
            for (int i3 = 0; i3 < this.controls_.size(); i3++) {
                codedOutputStream.writeMessage(4, this.controls_.get(i3));
            }
            for (int i4 = 0; i4 < this.methods_.size(); i4++) {
                codedOutputStream.writeMessage(5, this.methods_.get(i4));
            }
            for (int i5 = 0; i5 < this.events_.size(); i5++) {
                codedOutputStream.writeMessage(6, this.events_.get(i5));
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetCustomParams(), CustomParamsDefaultEntryHolder.defaultEntry, 7);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.sequence_;
            int iComputeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
            if (!getBackgroundColorBytes().isEmpty()) {
                iComputeInt32Size += GeneratedMessageV3.computeStringSize(2, this.backgroundColor_);
            }
            for (int i3 = 0; i3 < this.ads_.size(); i3++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.ads_.get(i3));
            }
            for (int i4 = 0; i4 < this.controls_.size(); i4++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.controls_.get(i4));
            }
            for (int i5 = 0; i5 < this.methods_.size(); i5++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.methods_.get(i5));
            }
            for (int i6 = 0; i6 < this.events_.size(); i6++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.events_.get(i6));
            }
            for (Map.Entry<String, String> entry : internalGetCustomParams().getMap().entrySet()) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(7, CustomParamsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof Phase)) {
                return super.equals(obj);
            }
            Phase phase = (Phase) obj;
            return getSequence() == phase.getSequence() && getBackgroundColor().equals(phase.getBackgroundColor()) && getAdsList().equals(phase.getAdsList()) && getControlsList().equals(phase.getControlsList()) && getMethodsList().equals(phase.getMethodsList()) && getEventsList().equals(phase.getEventsList()) && internalGetCustomParams().equals(phase.internalGetCustomParams()) && this.unknownFields.equals(phase.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSequence()) * 37) + 2) * 53) + getBackgroundColor().hashCode();
            if (getAdsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getAdsList().hashCode();
            }
            if (getControlsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getControlsList().hashCode();
            }
            if (getMethodsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 5) * 53) + getMethodsList().hashCode();
            }
            if (getEventsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 6) * 53) + getEventsList().hashCode();
            }
            if (!internalGetCustomParams().getMap().isEmpty()) {
                iHashCode = (((iHashCode * 37) + 7) * 53) + internalGetCustomParams().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static Phase parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Phase parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Phase parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Phase parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Phase parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Phase parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Phase parseFrom(InputStream inputStream) throws IOException {
            return (Phase) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Phase parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Phase) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Phase parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Phase) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Phase parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Phase) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Phase parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Phase) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Phase parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Phase) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Phase phase) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(phase);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PhaseOrBuilder {
            private RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> adsBuilder_;
            private List<ViewComponent> ads_;
            private Object backgroundColor_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> controlsBuilder_;
            private List<ViewComponent> controls_;
            private MapField<String, String> customParams_;
            private RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> eventsBuilder_;
            private List<Event> events_;
            private RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> methodsBuilder_;
            private List<MethodComponent> methods_;
            private int sequence_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 7) {
                    return internalGetCustomParams();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 7) {
                    return internalGetMutableCustomParams();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_fieldAccessorTable.ensureFieldAccessorsInitialized(Phase.class, Builder.class);
            }

            private Builder() {
                this.backgroundColor_ = "";
                this.ads_ = Collections.emptyList();
                this.controls_ = Collections.emptyList();
                this.methods_ = Collections.emptyList();
                this.events_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.backgroundColor_ = "";
                this.ads_ = Collections.emptyList();
                this.controls_ = Collections.emptyList();
                this.methods_ = Collections.emptyList();
                this.events_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Phase.alwaysUseFieldBuilders) {
                    getAdsFieldBuilder();
                    getControlsFieldBuilder();
                    getMethodsFieldBuilder();
                    getEventsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sequence_ = 0;
                this.backgroundColor_ = "";
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.ads_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV4 = this.controlsBuilder_;
                if (repeatedFieldBuilderV4 == null) {
                    this.controls_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV4.clear();
                }
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV5 = this.methodsBuilder_;
                if (repeatedFieldBuilderV5 == null) {
                    this.methods_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV5.clear();
                }
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV6 = this.eventsBuilder_;
                if (repeatedFieldBuilderV6 == null) {
                    this.events_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    repeatedFieldBuilderV6.clear();
                }
                internalGetMutableCustomParams().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_Phase_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Phase getDefaultInstanceForType() {
                return Phase.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Phase build() {
                Phase phaseBuildPartial = buildPartial();
                if (phaseBuildPartial.isInitialized()) {
                    return phaseBuildPartial;
                }
                throw newUninitializedMessageException((Message) phaseBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Phase buildPartial() {
                Phase phase = new Phase(this);
                phase.sequence_ = this.sequence_;
                phase.backgroundColor_ = this.backgroundColor_;
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    phase.ads_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.ads_ = Collections.unmodifiableList(this.ads_);
                        this.bitField0_ &= -2;
                    }
                    phase.ads_ = this.ads_;
                }
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV4 = this.controlsBuilder_;
                if (repeatedFieldBuilderV4 != null) {
                    phase.controls_ = repeatedFieldBuilderV4.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.controls_ = Collections.unmodifiableList(this.controls_);
                        this.bitField0_ &= -3;
                    }
                    phase.controls_ = this.controls_;
                }
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV5 = this.methodsBuilder_;
                if (repeatedFieldBuilderV5 != null) {
                    phase.methods_ = repeatedFieldBuilderV5.build();
                } else {
                    if ((this.bitField0_ & 4) != 0) {
                        this.methods_ = Collections.unmodifiableList(this.methods_);
                        this.bitField0_ &= -5;
                    }
                    phase.methods_ = this.methods_;
                }
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV6 = this.eventsBuilder_;
                if (repeatedFieldBuilderV6 != null) {
                    phase.events_ = repeatedFieldBuilderV6.build();
                } else {
                    if ((this.bitField0_ & 8) != 0) {
                        this.events_ = Collections.unmodifiableList(this.events_);
                        this.bitField0_ &= -9;
                    }
                    phase.events_ = this.events_;
                }
                phase.customParams_ = internalGetCustomParams();
                phase.customParams_.makeImmutable();
                onBuilt();
                return phase;
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
                if (message instanceof Phase) {
                    return mergeFrom((Phase) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Phase phase) {
                if (phase == Phase.getDefaultInstance()) {
                    return this;
                }
                if (phase.getSequence() != 0) {
                    setSequence(phase.getSequence());
                }
                if (!phase.getBackgroundColor().isEmpty()) {
                    this.backgroundColor_ = phase.backgroundColor_;
                    onChanged();
                }
                if (this.adsBuilder_ == null) {
                    if (!phase.ads_.isEmpty()) {
                        if (this.ads_.isEmpty()) {
                            this.ads_ = phase.ads_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAdsIsMutable();
                            this.ads_.addAll(phase.ads_);
                        }
                        onChanged();
                    }
                } else if (!phase.ads_.isEmpty()) {
                    if (!this.adsBuilder_.isEmpty()) {
                        this.adsBuilder_.addAllMessages(phase.ads_);
                    } else {
                        this.adsBuilder_.dispose();
                        this.adsBuilder_ = null;
                        this.ads_ = phase.ads_;
                        this.bitField0_ &= -2;
                        this.adsBuilder_ = Phase.alwaysUseFieldBuilders ? getAdsFieldBuilder() : null;
                    }
                }
                if (this.controlsBuilder_ == null) {
                    if (!phase.controls_.isEmpty()) {
                        if (this.controls_.isEmpty()) {
                            this.controls_ = phase.controls_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureControlsIsMutable();
                            this.controls_.addAll(phase.controls_);
                        }
                        onChanged();
                    }
                } else if (!phase.controls_.isEmpty()) {
                    if (!this.controlsBuilder_.isEmpty()) {
                        this.controlsBuilder_.addAllMessages(phase.controls_);
                    } else {
                        this.controlsBuilder_.dispose();
                        this.controlsBuilder_ = null;
                        this.controls_ = phase.controls_;
                        this.bitField0_ &= -3;
                        this.controlsBuilder_ = Phase.alwaysUseFieldBuilders ? getControlsFieldBuilder() : null;
                    }
                }
                if (this.methodsBuilder_ == null) {
                    if (!phase.methods_.isEmpty()) {
                        if (this.methods_.isEmpty()) {
                            this.methods_ = phase.methods_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureMethodsIsMutable();
                            this.methods_.addAll(phase.methods_);
                        }
                        onChanged();
                    }
                } else if (!phase.methods_.isEmpty()) {
                    if (!this.methodsBuilder_.isEmpty()) {
                        this.methodsBuilder_.addAllMessages(phase.methods_);
                    } else {
                        this.methodsBuilder_.dispose();
                        this.methodsBuilder_ = null;
                        this.methods_ = phase.methods_;
                        this.bitField0_ &= -5;
                        this.methodsBuilder_ = Phase.alwaysUseFieldBuilders ? getMethodsFieldBuilder() : null;
                    }
                }
                if (this.eventsBuilder_ == null) {
                    if (!phase.events_.isEmpty()) {
                        if (this.events_.isEmpty()) {
                            this.events_ = phase.events_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureEventsIsMutable();
                            this.events_.addAll(phase.events_);
                        }
                        onChanged();
                    }
                } else if (!phase.events_.isEmpty()) {
                    if (!this.eventsBuilder_.isEmpty()) {
                        this.eventsBuilder_.addAllMessages(phase.events_);
                    } else {
                        this.eventsBuilder_.dispose();
                        this.eventsBuilder_ = null;
                        this.events_ = phase.events_;
                        this.bitField0_ &= -9;
                        this.eventsBuilder_ = Phase.alwaysUseFieldBuilders ? getEventsFieldBuilder() : null;
                    }
                }
                internalGetMutableCustomParams().mergeFrom(phase.internalGetCustomParams());
                mergeUnknownFields(phase.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                Phase phase = null;
                try {
                    try {
                        Phase phase2 = (Phase) Phase.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (phase2 != null) {
                            mergeFrom(phase2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Phase phase3 = (Phase) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            phase = phase3;
                            if (phase != null) {
                                mergeFrom(phase);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (phase != null) {
                        mergeFrom(phase);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getSequence() {
                return this.sequence_;
            }

            public Builder setSequence(int i) {
                this.sequence_ = i;
                onChanged();
                return this;
            }

            public Builder clearSequence() {
                this.sequence_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public String getBackgroundColor() {
                Object obj = this.backgroundColor_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.backgroundColor_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public ByteString getBackgroundColorBytes() {
                Object obj = this.backgroundColor_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.backgroundColor_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setBackgroundColor(String str) {
                str.getClass();
                this.backgroundColor_ = str;
                onChanged();
                return this;
            }

            public Builder clearBackgroundColor() {
                this.backgroundColor_ = Phase.getDefaultInstance().getBackgroundColor();
                onChanged();
                return this;
            }

            public Builder setBackgroundColorBytes(ByteString byteString) {
                byteString.getClass();
                Phase.checkByteStringIsUtf8(byteString);
                this.backgroundColor_ = byteString;
                onChanged();
                return this;
            }

            private void ensureAdsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.ads_ = new ArrayList(this.ads_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<ViewComponent> getAdsList() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.ads_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getAdsCount() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.ads_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public ViewComponent getAds(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.ads_.get(i);
                }
                return (ViewComponent) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setAds(int i, ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureAdsIsMutable();
                    this.ads_.set(i, viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, viewComponent);
                }
                return this;
            }

            public Builder setAds(int i, ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdsIsMutable();
                    this.ads_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAds(ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureAdsIsMutable();
                    this.ads_.add(viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(viewComponent);
                }
                return this;
            }

            public Builder addAds(int i, ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureAdsIsMutable();
                    this.ads_.add(i, viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, viewComponent);
                }
                return this;
            }

            public Builder addAds(ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdsIsMutable();
                    this.ads_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addAds(int i, ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdsIsMutable();
                    this.ads_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllAds(Iterable<? extends ViewComponent> iterable) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.ads_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearAds() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.ads_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeAds(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdsIsMutable();
                    this.ads_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public ViewComponent.Builder getAdsBuilder(int i) {
                return (ViewComponent.Builder) getAdsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public ViewComponentOrBuilder getAdsOrBuilder(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.ads_.get(i);
                }
                return (ViewComponentOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<? extends ViewComponentOrBuilder> getAdsOrBuilderList() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.adsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.ads_);
            }

            public ViewComponent.Builder addAdsBuilder() {
                return (ViewComponent.Builder) getAdsFieldBuilder().addBuilder(ViewComponent.getDefaultInstance());
            }

            public ViewComponent.Builder addAdsBuilder(int i) {
                return (ViewComponent.Builder) getAdsFieldBuilder().addBuilder(i, ViewComponent.getDefaultInstance());
            }

            public List<ViewComponent.Builder> getAdsBuilderList() {
                return getAdsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> getAdsFieldBuilder() {
                if (this.adsBuilder_ == null) {
                    this.adsBuilder_ = new RepeatedFieldBuilderV3<>(this.ads_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.ads_ = null;
                }
                return this.adsBuilder_;
            }

            private void ensureControlsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.controls_ = new ArrayList(this.controls_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<ViewComponent> getControlsList() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.controls_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getControlsCount() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.controls_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public ViewComponent getControls(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.controls_.get(i);
                }
                return (ViewComponent) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setControls(int i, ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureControlsIsMutable();
                    this.controls_.set(i, viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, viewComponent);
                }
                return this;
            }

            public Builder setControls(int i, ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureControlsIsMutable();
                    this.controls_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addControls(ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureControlsIsMutable();
                    this.controls_.add(viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(viewComponent);
                }
                return this;
            }

            public Builder addControls(int i, ViewComponent viewComponent) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    viewComponent.getClass();
                    ensureControlsIsMutable();
                    this.controls_.add(i, viewComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, viewComponent);
                }
                return this;
            }

            public Builder addControls(ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureControlsIsMutable();
                    this.controls_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addControls(int i, ViewComponent.Builder builder) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureControlsIsMutable();
                    this.controls_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllControls(Iterable<? extends ViewComponent> iterable) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureControlsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.controls_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearControls() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.controls_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeControls(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureControlsIsMutable();
                    this.controls_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public ViewComponent.Builder getControlsBuilder(int i) {
                return (ViewComponent.Builder) getControlsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public ViewComponentOrBuilder getControlsOrBuilder(int i) {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.controls_.get(i);
                }
                return (ViewComponentOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<? extends ViewComponentOrBuilder> getControlsOrBuilderList() {
                RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> repeatedFieldBuilderV3 = this.controlsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.controls_);
            }

            public ViewComponent.Builder addControlsBuilder() {
                return (ViewComponent.Builder) getControlsFieldBuilder().addBuilder(ViewComponent.getDefaultInstance());
            }

            public ViewComponent.Builder addControlsBuilder(int i) {
                return (ViewComponent.Builder) getControlsFieldBuilder().addBuilder(i, ViewComponent.getDefaultInstance());
            }

            public List<ViewComponent.Builder> getControlsBuilderList() {
                return getControlsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ViewComponent, ViewComponent.Builder, ViewComponentOrBuilder> getControlsFieldBuilder() {
                if (this.controlsBuilder_ == null) {
                    this.controlsBuilder_ = new RepeatedFieldBuilderV3<>(this.controls_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.controls_ = null;
                }
                return this.controlsBuilder_;
            }

            private void ensureMethodsIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.methods_ = new ArrayList(this.methods_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<MethodComponent> getMethodsList() {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.methods_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getMethodsCount() {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.methods_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public MethodComponent getMethods(int i) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.methods_.get(i);
                }
                return (MethodComponent) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setMethods(int i, MethodComponent methodComponent) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    methodComponent.getClass();
                    ensureMethodsIsMutable();
                    this.methods_.set(i, methodComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, methodComponent);
                }
                return this;
            }

            public Builder setMethods(int i, MethodComponent.Builder builder) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMethodsIsMutable();
                    this.methods_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addMethods(MethodComponent methodComponent) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    methodComponent.getClass();
                    ensureMethodsIsMutable();
                    this.methods_.add(methodComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(methodComponent);
                }
                return this;
            }

            public Builder addMethods(int i, MethodComponent methodComponent) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    methodComponent.getClass();
                    ensureMethodsIsMutable();
                    this.methods_.add(i, methodComponent);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, methodComponent);
                }
                return this;
            }

            public Builder addMethods(MethodComponent.Builder builder) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMethodsIsMutable();
                    this.methods_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addMethods(int i, MethodComponent.Builder builder) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMethodsIsMutable();
                    this.methods_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllMethods(Iterable<? extends MethodComponent> iterable) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMethodsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.methods_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearMethods() {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.methods_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeMethods(int i) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMethodsIsMutable();
                    this.methods_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public MethodComponent.Builder getMethodsBuilder(int i) {
                return (MethodComponent.Builder) getMethodsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public MethodComponentOrBuilder getMethodsOrBuilder(int i) {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.methods_.get(i);
                }
                return (MethodComponentOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<? extends MethodComponentOrBuilder> getMethodsOrBuilderList() {
                RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.methods_);
            }

            public MethodComponent.Builder addMethodsBuilder() {
                return (MethodComponent.Builder) getMethodsFieldBuilder().addBuilder(MethodComponent.getDefaultInstance());
            }

            public MethodComponent.Builder addMethodsBuilder(int i) {
                return (MethodComponent.Builder) getMethodsFieldBuilder().addBuilder(i, MethodComponent.getDefaultInstance());
            }

            public List<MethodComponent.Builder> getMethodsBuilderList() {
                return getMethodsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MethodComponent, MethodComponent.Builder, MethodComponentOrBuilder> getMethodsFieldBuilder() {
                if (this.methodsBuilder_ == null) {
                    this.methodsBuilder_ = new RepeatedFieldBuilderV3<>(this.methods_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.methods_ = null;
                }
                return this.methodsBuilder_;
            }

            private void ensureEventsIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.events_ = new ArrayList(this.events_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<Event> getEventsList() {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.events_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getEventsCount() {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.events_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public Event getEvents(int i) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.events_.get(i);
                }
                return (Event) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setEvents(int i, Event event) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    event.getClass();
                    ensureEventsIsMutable();
                    this.events_.set(i, event);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, event);
                }
                return this;
            }

            public Builder setEvents(int i, Event.Builder builder) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEventsIsMutable();
                    this.events_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addEvents(Event event) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    event.getClass();
                    ensureEventsIsMutable();
                    this.events_.add(event);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(event);
                }
                return this;
            }

            public Builder addEvents(int i, Event event) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    event.getClass();
                    ensureEventsIsMutable();
                    this.events_.add(i, event);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, event);
                }
                return this;
            }

            public Builder addEvents(Event.Builder builder) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEventsIsMutable();
                    this.events_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addEvents(int i, Event.Builder builder) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEventsIsMutable();
                    this.events_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllEvents(Iterable<? extends Event> iterable) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEventsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.events_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearEvents() {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.events_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeEvents(int i) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEventsIsMutable();
                    this.events_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Event.Builder getEventsBuilder(int i) {
                return (Event.Builder) getEventsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public EventOrBuilder getEventsOrBuilder(int i) {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.events_.get(i);
                }
                return (EventOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public List<? extends EventOrBuilder> getEventsOrBuilderList() {
                RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> repeatedFieldBuilderV3 = this.eventsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.events_);
            }

            public Event.Builder addEventsBuilder() {
                return (Event.Builder) getEventsFieldBuilder().addBuilder(Event.getDefaultInstance());
            }

            public Event.Builder addEventsBuilder(int i) {
                return (Event.Builder) getEventsFieldBuilder().addBuilder(i, Event.getDefaultInstance());
            }

            public List<Event.Builder> getEventsBuilderList() {
                return getEventsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Event, Event.Builder, EventOrBuilder> getEventsFieldBuilder() {
                if (this.eventsBuilder_ == null) {
                    this.eventsBuilder_ = new RepeatedFieldBuilderV3<>(this.events_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.events_ = null;
                }
                return this.eventsBuilder_;
            }

            private MapField<String, String> internalGetCustomParams() {
                MapField<String, String> mapField = this.customParams_;
                return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<String, String> internalGetMutableCustomParams() {
                onChanged();
                if (this.customParams_ == null) {
                    this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
                }
                if (!this.customParams_.isMutable()) {
                    this.customParams_ = this.customParams_.copy();
                }
                return this.customParams_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public int getCustomParamsCount() {
                return internalGetCustomParams().getMap().size();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public boolean containsCustomParams(String str) {
                str.getClass();
                return internalGetCustomParams().getMap().containsKey(str);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            @Deprecated
            public Map<String, String> getCustomParams() {
                return getCustomParamsMap();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public Map<String, String> getCustomParamsMap() {
                return internalGetCustomParams().getMap();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public String getCustomParamsOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> map = internalGetCustomParams().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.PhaseOrBuilder
            public String getCustomParamsOrThrow(String str) {
                str.getClass();
                Map<String, String> map = internalGetCustomParams().getMap();
                if (!map.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return map.get(str);
            }

            public Builder clearCustomParams() {
                internalGetMutableCustomParams().getMutableMap().clear();
                return this;
            }

            public Builder removeCustomParams(String str) {
                str.getClass();
                internalGetMutableCustomParams().getMutableMap().remove(str);
                return this;
            }

            @Deprecated
            public Map<String, String> getMutableCustomParams() {
                return internalGetMutableCustomParams().getMutableMap();
            }

            public Builder putCustomParams(String str, String str2) {
                str.getClass();
                str2.getClass();
                internalGetMutableCustomParams().getMutableMap().put(str, str2);
                return this;
            }

            public Builder putAllCustomParams(Map<String, String> map) {
                internalGetMutableCustomParams().getMutableMap().putAll(map);
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

        public static Phase getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Phase> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Phase> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Phase getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class SKStoreConfiguration extends GeneratedMessageV3 implements SKStoreConfigurationOrBuilder {
        public static final int ADCAMPAIGN_IDENTIFIER_FIELD_NUMBER = 4;
        public static final int ADNETWORK_IDENTIFIER_FIELD_NUMBER = 2;
        public static final int ADVERTISED_APPSTORE_ITEM_IDENTIFIER_FIELD_NUMBER = 5;
        public static final int FIDELITIES_FIELD_NUMBER = 7;
        public static final int NONCE_FIELD_NUMBER = 8;
        public static final int PRODUCT_PAGE_ID_FIELD_NUMBER = 6;
        public static final int SIGNATURE_FIELD_NUMBER = 11;
        public static final int SOURCE_APPSTORE_ITEM_IDENTIFIER_FIELD_NUMBER = 9;
        public static final int SOURCE_IDENTIFIER_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 10;
        public static final int VERSION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private StringValue adcampaignIdentifier_;
        private StringValue adnetworkIdentifier_;
        private StringValue advertisedAppstoreItemIdentifier_;
        private List<Fidelity> fidelities_;
        private byte memoizedIsInitialized;
        private StringValue nonce_;
        private StringValue productPageId_;
        private StringValue signature_;
        private StringValue sourceAppstoreItemIdentifier_;
        private StringValue sourceIdentifier_;
        private StringValue timestamp_;
        private StringValue version_;
        private static final SKStoreConfiguration DEFAULT_INSTANCE = new SKStoreConfiguration();
        private static final Parser<SKStoreConfiguration> PARSER = new AbstractParser<SKStoreConfiguration>() { // from class: io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.1
            @Override // com.explorestack.protobuf.Parser
            public SKStoreConfiguration parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SKStoreConfiguration(codedInputStream, extensionRegistryLite);
            }
        };

        public interface FidelityOrBuilder extends MessageOrBuilder {
            StringValue getFidelity();

            StringValueOrBuilder getFidelityOrBuilder();

            StringValue getNonce();

            StringValueOrBuilder getNonceOrBuilder();

            StringValue getSignature();

            StringValueOrBuilder getSignatureOrBuilder();

            StringValue getTimestamp();

            StringValueOrBuilder getTimestampOrBuilder();

            boolean hasFidelity();

            boolean hasNonce();

            boolean hasSignature();

            boolean hasTimestamp();
        }

        private SKStoreConfiguration(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SKStoreConfiguration() {
            this.memoizedIsInitialized = (byte) -1;
            this.fidelities_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new SKStoreConfiguration();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SKStoreConfiguration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            StringValue.Builder builder;
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 10:
                                    StringValue stringValue = this.version_;
                                    builder = stringValue != null ? stringValue.toBuilder() : null;
                                    StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.version_ = stringValue2;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue2);
                                        this.version_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 18:
                                    StringValue stringValue3 = this.adnetworkIdentifier_;
                                    builder = stringValue3 != null ? stringValue3.toBuilder() : null;
                                    StringValue stringValue4 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.adnetworkIdentifier_ = stringValue4;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue4);
                                        this.adnetworkIdentifier_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 26:
                                    StringValue stringValue5 = this.sourceIdentifier_;
                                    builder = stringValue5 != null ? stringValue5.toBuilder() : null;
                                    StringValue stringValue6 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.sourceIdentifier_ = stringValue6;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue6);
                                        this.sourceIdentifier_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 34:
                                    StringValue stringValue7 = this.adcampaignIdentifier_;
                                    builder = stringValue7 != null ? stringValue7.toBuilder() : null;
                                    StringValue stringValue8 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.adcampaignIdentifier_ = stringValue8;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue8);
                                        this.adcampaignIdentifier_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 42:
                                    StringValue stringValue9 = this.advertisedAppstoreItemIdentifier_;
                                    builder = stringValue9 != null ? stringValue9.toBuilder() : null;
                                    StringValue stringValue10 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.advertisedAppstoreItemIdentifier_ = stringValue10;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue10);
                                        this.advertisedAppstoreItemIdentifier_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 50:
                                    StringValue stringValue11 = this.productPageId_;
                                    builder = stringValue11 != null ? stringValue11.toBuilder() : null;
                                    StringValue stringValue12 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.productPageId_ = stringValue12;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue12);
                                        this.productPageId_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                    if (!z2) {
                                        this.fidelities_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.fidelities_.add((Fidelity) codedInputStream.readMessage(Fidelity.parser(), extensionRegistryLite));
                                    continue;
                                case 66:
                                    StringValue stringValue13 = this.nonce_;
                                    builder = stringValue13 != null ? stringValue13.toBuilder() : null;
                                    StringValue stringValue14 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.nonce_ = stringValue14;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue14);
                                        this.nonce_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 74:
                                    StringValue stringValue15 = this.sourceAppstoreItemIdentifier_;
                                    builder = stringValue15 != null ? stringValue15.toBuilder() : null;
                                    StringValue stringValue16 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.sourceAppstoreItemIdentifier_ = stringValue16;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue16);
                                        this.sourceAppstoreItemIdentifier_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                                    StringValue stringValue17 = this.timestamp_;
                                    builder = stringValue17 != null ? stringValue17.toBuilder() : null;
                                    StringValue stringValue18 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.timestamp_ = stringValue18;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue18);
                                        this.timestamp_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 90:
                                    StringValue stringValue19 = this.signature_;
                                    builder = stringValue19 != null ? stringValue19.toBuilder() : null;
                                    StringValue stringValue20 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.signature_ = stringValue20;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue20);
                                        this.signature_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                        break;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2) {
                        this.fidelities_ = Collections.unmodifiableList(this.fidelities_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.fidelities_ = Collections.unmodifiableList(this.fidelities_);
            }
            this.unknownFields = builderNewBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(SKStoreConfiguration.class, Builder.class);
        }

        public static final class Fidelity extends GeneratedMessageV3 implements FidelityOrBuilder {
            public static final int FIDELITY_FIELD_NUMBER = 1;
            public static final int NONCE_FIELD_NUMBER = 3;
            public static final int SIGNATURE_FIELD_NUMBER = 2;
            public static final int TIMESTAMP_FIELD_NUMBER = 4;
            private static final long serialVersionUID = 0;
            private StringValue fidelity_;
            private byte memoizedIsInitialized;
            private StringValue nonce_;
            private StringValue signature_;
            private StringValue timestamp_;
            private static final Fidelity DEFAULT_INSTANCE = new Fidelity();
            private static final Parser<Fidelity> PARSER = new AbstractParser<Fidelity>() { // from class: io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.Fidelity.1
                @Override // com.explorestack.protobuf.Parser
                public Fidelity parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Fidelity(codedInputStream, extensionRegistryLite);
                }
            };

            private Fidelity(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private Fidelity() {
                this.memoizedIsInitialized = (byte) -1;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Fidelity();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private Fidelity(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                StringValue.Builder builder;
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
                                        StringValue stringValue = this.fidelity_;
                                        builder = stringValue != null ? stringValue.toBuilder() : null;
                                        StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                        this.fidelity_ = stringValue2;
                                        if (builder != null) {
                                            builder.mergeFrom(stringValue2);
                                            this.fidelity_ = builder.buildPartial();
                                        }
                                    } else if (tag == 18) {
                                        StringValue stringValue3 = this.signature_;
                                        builder = stringValue3 != null ? stringValue3.toBuilder() : null;
                                        StringValue stringValue4 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                        this.signature_ = stringValue4;
                                        if (builder != null) {
                                            builder.mergeFrom(stringValue4);
                                            this.signature_ = builder.buildPartial();
                                        }
                                    } else if (tag == 26) {
                                        StringValue stringValue5 = this.nonce_;
                                        builder = stringValue5 != null ? stringValue5.toBuilder() : null;
                                        StringValue stringValue6 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                        this.nonce_ = stringValue6;
                                        if (builder != null) {
                                            builder.mergeFrom(stringValue6);
                                            this.nonce_ = builder.buildPartial();
                                        }
                                    } else if (tag == 34) {
                                        StringValue stringValue7 = this.timestamp_;
                                        builder = stringValue7 != null ? stringValue7.toBuilder() : null;
                                        StringValue stringValue8 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                        this.timestamp_ = stringValue8;
                                        if (builder != null) {
                                            builder.mergeFrom(stringValue8);
                                            this.timestamp_ = builder.buildPartial();
                                        }
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
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_fieldAccessorTable.ensureFieldAccessorsInitialized(Fidelity.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public boolean hasFidelity() {
                return this.fidelity_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValue getFidelity() {
                StringValue stringValue = this.fidelity_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValueOrBuilder getFidelityOrBuilder() {
                return getFidelity();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public boolean hasSignature() {
                return this.signature_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValue getSignature() {
                StringValue stringValue = this.signature_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValueOrBuilder getSignatureOrBuilder() {
                return getSignature();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public boolean hasNonce() {
                return this.nonce_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValue getNonce() {
                StringValue stringValue = this.nonce_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValueOrBuilder getNonceOrBuilder() {
                return getNonce();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public boolean hasTimestamp() {
                return this.timestamp_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValue getTimestamp() {
                StringValue stringValue = this.timestamp_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
            public StringValueOrBuilder getTimestampOrBuilder() {
                return getTimestamp();
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
                if (this.fidelity_ != null) {
                    codedOutputStream.writeMessage(1, getFidelity());
                }
                if (this.signature_ != null) {
                    codedOutputStream.writeMessage(2, getSignature());
                }
                if (this.nonce_ != null) {
                    codedOutputStream.writeMessage(3, getNonce());
                }
                if (this.timestamp_ != null) {
                    codedOutputStream.writeMessage(4, getTimestamp());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeMessageSize = this.fidelity_ != null ? CodedOutputStream.computeMessageSize(1, getFidelity()) : 0;
                if (this.signature_ != null) {
                    iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getSignature());
                }
                if (this.nonce_ != null) {
                    iComputeMessageSize += CodedOutputStream.computeMessageSize(3, getNonce());
                }
                if (this.timestamp_ != null) {
                    iComputeMessageSize += CodedOutputStream.computeMessageSize(4, getTimestamp());
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
                if (!(obj instanceof Fidelity)) {
                    return super.equals(obj);
                }
                Fidelity fidelity = (Fidelity) obj;
                if (hasFidelity() != fidelity.hasFidelity()) {
                    return false;
                }
                if ((hasFidelity() && !getFidelity().equals(fidelity.getFidelity())) || hasSignature() != fidelity.hasSignature()) {
                    return false;
                }
                if ((hasSignature() && !getSignature().equals(fidelity.getSignature())) || hasNonce() != fidelity.hasNonce()) {
                    return false;
                }
                if ((!hasNonce() || getNonce().equals(fidelity.getNonce())) && hasTimestamp() == fidelity.hasTimestamp()) {
                    return (!hasTimestamp() || getTimestamp().equals(fidelity.getTimestamp())) && this.unknownFields.equals(fidelity.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = 779 + getDescriptor().hashCode();
                if (hasFidelity()) {
                    iHashCode = (((iHashCode * 37) + 1) * 53) + getFidelity().hashCode();
                }
                if (hasSignature()) {
                    iHashCode = (((iHashCode * 37) + 2) * 53) + getSignature().hashCode();
                }
                if (hasNonce()) {
                    iHashCode = (((iHashCode * 37) + 3) * 53) + getNonce().hashCode();
                }
                if (hasTimestamp()) {
                    iHashCode = (((iHashCode * 37) + 4) * 53) + getTimestamp().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
            }

            public static Fidelity parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Fidelity parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Fidelity parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Fidelity parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Fidelity parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Fidelity parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Fidelity parseFrom(InputStream inputStream) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Fidelity parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Fidelity parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Fidelity parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Fidelity parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Fidelity parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Fidelity) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Fidelity fidelity) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(fidelity);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FidelityOrBuilder {
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> fidelityBuilder_;
                private StringValue fidelity_;
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> nonceBuilder_;
                private StringValue nonce_;
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> signatureBuilder_;
                private StringValue signature_;
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> timestampBuilder_;
                private StringValue timestamp_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_fieldAccessorTable.ensureFieldAccessorsInitialized(Fidelity.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = Fidelity.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    if (this.fidelityBuilder_ == null) {
                        this.fidelity_ = null;
                    } else {
                        this.fidelity_ = null;
                        this.fidelityBuilder_ = null;
                    }
                    if (this.signatureBuilder_ == null) {
                        this.signature_ = null;
                    } else {
                        this.signature_ = null;
                        this.signatureBuilder_ = null;
                    }
                    if (this.nonceBuilder_ == null) {
                        this.nonce_ = null;
                    } else {
                        this.nonce_ = null;
                        this.nonceBuilder_ = null;
                    }
                    if (this.timestampBuilder_ == null) {
                        this.timestamp_ = null;
                    } else {
                        this.timestamp_ = null;
                        this.timestampBuilder_ = null;
                    }
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Fidelity getDefaultInstanceForType() {
                    return Fidelity.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Fidelity build() {
                    Fidelity fidelityBuildPartial = buildPartial();
                    if (fidelityBuildPartial.isInitialized()) {
                        return fidelityBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) fidelityBuildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Fidelity buildPartial() {
                    Fidelity fidelity = new Fidelity(this);
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        fidelity.fidelity_ = this.fidelity_;
                    } else {
                        fidelity.fidelity_ = (StringValue) singleFieldBuilderV3.build();
                    }
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV4 = this.signatureBuilder_;
                    if (singleFieldBuilderV4 == null) {
                        fidelity.signature_ = this.signature_;
                    } else {
                        fidelity.signature_ = (StringValue) singleFieldBuilderV4.build();
                    }
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV5 = this.nonceBuilder_;
                    if (singleFieldBuilderV5 == null) {
                        fidelity.nonce_ = this.nonce_;
                    } else {
                        fidelity.nonce_ = (StringValue) singleFieldBuilderV5.build();
                    }
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV6 = this.timestampBuilder_;
                    if (singleFieldBuilderV6 == null) {
                        fidelity.timestamp_ = this.timestamp_;
                    } else {
                        fidelity.timestamp_ = (StringValue) singleFieldBuilderV6.build();
                    }
                    onBuilt();
                    return fidelity;
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
                    if (message instanceof Fidelity) {
                        return mergeFrom((Fidelity) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Fidelity fidelity) {
                    if (fidelity == Fidelity.getDefaultInstance()) {
                        return this;
                    }
                    if (fidelity.hasFidelity()) {
                        mergeFidelity(fidelity.getFidelity());
                    }
                    if (fidelity.hasSignature()) {
                        mergeSignature(fidelity.getSignature());
                    }
                    if (fidelity.hasNonce()) {
                        mergeNonce(fidelity.getNonce());
                    }
                    if (fidelity.hasTimestamp()) {
                        mergeTimestamp(fidelity.getTimestamp());
                    }
                    mergeUnknownFields(fidelity.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:16:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    Fidelity fidelity = null;
                    try {
                        try {
                            Fidelity fidelity2 = (Fidelity) Fidelity.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (fidelity2 != null) {
                                mergeFrom(fidelity2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Fidelity fidelity3 = (Fidelity) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                fidelity = fidelity3;
                                if (fidelity != null) {
                                    mergeFrom(fidelity);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fidelity != null) {
                            mergeFrom(fidelity);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public boolean hasFidelity() {
                    return (this.fidelityBuilder_ == null && this.fidelity_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValue getFidelity() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.fidelity_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return (StringValue) singleFieldBuilderV3.getMessage();
                }

                public Builder setFidelity(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.fidelity_ = stringValue;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(stringValue);
                    }
                    return this;
                }

                public Builder setFidelity(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.fidelity_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeFidelity(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.fidelity_;
                        if (stringValue2 != null) {
                            this.fidelity_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.fidelity_ = stringValue;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(stringValue);
                    }
                    return this;
                }

                public Builder clearFidelity() {
                    if (this.fidelityBuilder_ == null) {
                        this.fidelity_ = null;
                        onChanged();
                    } else {
                        this.fidelity_ = null;
                        this.fidelityBuilder_ = null;
                    }
                    return this;
                }

                public StringValue.Builder getFidelityBuilder() {
                    onChanged();
                    return (StringValue.Builder) getFidelityFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValueOrBuilder getFidelityOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.fidelityBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.fidelity_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getFidelityFieldBuilder() {
                    if (this.fidelityBuilder_ == null) {
                        this.fidelityBuilder_ = new SingleFieldBuilderV3<>(getFidelity(), getParentForChildren(), isClean());
                        this.fidelity_ = null;
                    }
                    return this.fidelityBuilder_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public boolean hasSignature() {
                    return (this.signatureBuilder_ == null && this.signature_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValue getSignature() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.signature_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return (StringValue) singleFieldBuilderV3.getMessage();
                }

                public Builder setSignature(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.signature_ = stringValue;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(stringValue);
                    }
                    return this;
                }

                public Builder setSignature(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.signature_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeSignature(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.signature_;
                        if (stringValue2 != null) {
                            this.signature_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.signature_ = stringValue;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(stringValue);
                    }
                    return this;
                }

                public Builder clearSignature() {
                    if (this.signatureBuilder_ == null) {
                        this.signature_ = null;
                        onChanged();
                    } else {
                        this.signature_ = null;
                        this.signatureBuilder_ = null;
                    }
                    return this;
                }

                public StringValue.Builder getSignatureBuilder() {
                    onChanged();
                    return (StringValue.Builder) getSignatureFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValueOrBuilder getSignatureOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.signature_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getSignatureFieldBuilder() {
                    if (this.signatureBuilder_ == null) {
                        this.signatureBuilder_ = new SingleFieldBuilderV3<>(getSignature(), getParentForChildren(), isClean());
                        this.signature_ = null;
                    }
                    return this.signatureBuilder_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public boolean hasNonce() {
                    return (this.nonceBuilder_ == null && this.nonce_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValue getNonce() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.nonce_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return (StringValue) singleFieldBuilderV3.getMessage();
                }

                public Builder setNonce(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.nonce_ = stringValue;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(stringValue);
                    }
                    return this;
                }

                public Builder setNonce(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.nonce_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeNonce(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.nonce_;
                        if (stringValue2 != null) {
                            this.nonce_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.nonce_ = stringValue;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(stringValue);
                    }
                    return this;
                }

                public Builder clearNonce() {
                    if (this.nonceBuilder_ == null) {
                        this.nonce_ = null;
                        onChanged();
                    } else {
                        this.nonce_ = null;
                        this.nonceBuilder_ = null;
                    }
                    return this;
                }

                public StringValue.Builder getNonceBuilder() {
                    onChanged();
                    return (StringValue.Builder) getNonceFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValueOrBuilder getNonceOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.nonce_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getNonceFieldBuilder() {
                    if (this.nonceBuilder_ == null) {
                        this.nonceBuilder_ = new SingleFieldBuilderV3<>(getNonce(), getParentForChildren(), isClean());
                        this.nonce_ = null;
                    }
                    return this.nonceBuilder_;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public boolean hasTimestamp() {
                    return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValue getTimestamp() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.timestamp_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return (StringValue) singleFieldBuilderV3.getMessage();
                }

                public Builder setTimestamp(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.timestamp_ = stringValue;
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(stringValue);
                    }
                    return this;
                }

                public Builder setTimestamp(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.timestamp_ = builder.build();
                        onChanged();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    return this;
                }

                public Builder mergeTimestamp(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.timestamp_;
                        if (stringValue2 != null) {
                            this.timestamp_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.timestamp_ = stringValue;
                        }
                        onChanged();
                    } else {
                        singleFieldBuilderV3.mergeFrom(stringValue);
                    }
                    return this;
                }

                public Builder clearTimestamp() {
                    if (this.timestampBuilder_ == null) {
                        this.timestamp_ = null;
                        onChanged();
                    } else {
                        this.timestamp_ = null;
                        this.timestampBuilder_ = null;
                    }
                    return this;
                }

                public StringValue.Builder getTimestampBuilder() {
                    onChanged();
                    return (StringValue.Builder) getTimestampFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfiguration.FidelityOrBuilder
                public StringValueOrBuilder getTimestampOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.timestamp_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getTimestampFieldBuilder() {
                    if (this.timestampBuilder_ == null) {
                        this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                        this.timestamp_ = null;
                    }
                    return this.timestampBuilder_;
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

            public static Fidelity getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Fidelity> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<Fidelity> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Fidelity getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasVersion() {
            return this.version_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getVersion() {
            StringValue stringValue = this.version_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getVersionOrBuilder() {
            return getVersion();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasAdnetworkIdentifier() {
            return this.adnetworkIdentifier_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getAdnetworkIdentifier() {
            StringValue stringValue = this.adnetworkIdentifier_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getAdnetworkIdentifierOrBuilder() {
            return getAdnetworkIdentifier();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasSourceIdentifier() {
            return this.sourceIdentifier_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getSourceIdentifier() {
            StringValue stringValue = this.sourceIdentifier_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getSourceIdentifierOrBuilder() {
            return getSourceIdentifier();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasAdcampaignIdentifier() {
            return this.adcampaignIdentifier_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getAdcampaignIdentifier() {
            StringValue stringValue = this.adcampaignIdentifier_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getAdcampaignIdentifierOrBuilder() {
            return getAdcampaignIdentifier();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasAdvertisedAppstoreItemIdentifier() {
            return this.advertisedAppstoreItemIdentifier_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getAdvertisedAppstoreItemIdentifier() {
            StringValue stringValue = this.advertisedAppstoreItemIdentifier_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getAdvertisedAppstoreItemIdentifierOrBuilder() {
            return getAdvertisedAppstoreItemIdentifier();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasProductPageId() {
            return this.productPageId_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getProductPageId() {
            StringValue stringValue = this.productPageId_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getProductPageIdOrBuilder() {
            return getProductPageId();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public List<Fidelity> getFidelitiesList() {
            return this.fidelities_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public List<? extends FidelityOrBuilder> getFidelitiesOrBuilderList() {
            return this.fidelities_;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public int getFidelitiesCount() {
            return this.fidelities_.size();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public Fidelity getFidelities(int i) {
            return this.fidelities_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public FidelityOrBuilder getFidelitiesOrBuilder(int i) {
            return this.fidelities_.get(i);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasNonce() {
            return this.nonce_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getNonce() {
            StringValue stringValue = this.nonce_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getNonceOrBuilder() {
            return getNonce();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasSourceAppstoreItemIdentifier() {
            return this.sourceAppstoreItemIdentifier_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getSourceAppstoreItemIdentifier() {
            StringValue stringValue = this.sourceAppstoreItemIdentifier_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getSourceAppstoreItemIdentifierOrBuilder() {
            return getSourceAppstoreItemIdentifier();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getTimestamp() {
            StringValue stringValue = this.timestamp_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public boolean hasSignature() {
            return this.signature_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValue getSignature() {
            StringValue stringValue = this.signature_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
        public StringValueOrBuilder getSignatureOrBuilder() {
            return getSignature();
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
            if (this.version_ != null) {
                codedOutputStream.writeMessage(1, getVersion());
            }
            if (this.adnetworkIdentifier_ != null) {
                codedOutputStream.writeMessage(2, getAdnetworkIdentifier());
            }
            if (this.sourceIdentifier_ != null) {
                codedOutputStream.writeMessage(3, getSourceIdentifier());
            }
            if (this.adcampaignIdentifier_ != null) {
                codedOutputStream.writeMessage(4, getAdcampaignIdentifier());
            }
            if (this.advertisedAppstoreItemIdentifier_ != null) {
                codedOutputStream.writeMessage(5, getAdvertisedAppstoreItemIdentifier());
            }
            if (this.productPageId_ != null) {
                codedOutputStream.writeMessage(6, getProductPageId());
            }
            for (int i = 0; i < this.fidelities_.size(); i++) {
                codedOutputStream.writeMessage(7, this.fidelities_.get(i));
            }
            if (this.nonce_ != null) {
                codedOutputStream.writeMessage(8, getNonce());
            }
            if (this.sourceAppstoreItemIdentifier_ != null) {
                codedOutputStream.writeMessage(9, getSourceAppstoreItemIdentifier());
            }
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(10, getTimestamp());
            }
            if (this.signature_ != null) {
                codedOutputStream.writeMessage(11, getSignature());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = this.version_ != null ? CodedOutputStream.computeMessageSize(1, getVersion()) : 0;
            if (this.adnetworkIdentifier_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getAdnetworkIdentifier());
            }
            if (this.sourceIdentifier_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, getSourceIdentifier());
            }
            if (this.adcampaignIdentifier_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, getAdcampaignIdentifier());
            }
            if (this.advertisedAppstoreItemIdentifier_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(5, getAdvertisedAppstoreItemIdentifier());
            }
            if (this.productPageId_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(6, getProductPageId());
            }
            for (int i2 = 0; i2 < this.fidelities_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(7, this.fidelities_.get(i2));
            }
            if (this.nonce_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(8, getNonce());
            }
            if (this.sourceAppstoreItemIdentifier_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(9, getSourceAppstoreItemIdentifier());
            }
            if (this.timestamp_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(10, getTimestamp());
            }
            if (this.signature_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(11, getSignature());
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
            if (!(obj instanceof SKStoreConfiguration)) {
                return super.equals(obj);
            }
            SKStoreConfiguration sKStoreConfiguration = (SKStoreConfiguration) obj;
            if (hasVersion() != sKStoreConfiguration.hasVersion()) {
                return false;
            }
            if ((hasVersion() && !getVersion().equals(sKStoreConfiguration.getVersion())) || hasAdnetworkIdentifier() != sKStoreConfiguration.hasAdnetworkIdentifier()) {
                return false;
            }
            if ((hasAdnetworkIdentifier() && !getAdnetworkIdentifier().equals(sKStoreConfiguration.getAdnetworkIdentifier())) || hasSourceIdentifier() != sKStoreConfiguration.hasSourceIdentifier()) {
                return false;
            }
            if ((hasSourceIdentifier() && !getSourceIdentifier().equals(sKStoreConfiguration.getSourceIdentifier())) || hasAdcampaignIdentifier() != sKStoreConfiguration.hasAdcampaignIdentifier()) {
                return false;
            }
            if ((hasAdcampaignIdentifier() && !getAdcampaignIdentifier().equals(sKStoreConfiguration.getAdcampaignIdentifier())) || hasAdvertisedAppstoreItemIdentifier() != sKStoreConfiguration.hasAdvertisedAppstoreItemIdentifier()) {
                return false;
            }
            if ((hasAdvertisedAppstoreItemIdentifier() && !getAdvertisedAppstoreItemIdentifier().equals(sKStoreConfiguration.getAdvertisedAppstoreItemIdentifier())) || hasProductPageId() != sKStoreConfiguration.hasProductPageId()) {
                return false;
            }
            if ((hasProductPageId() && !getProductPageId().equals(sKStoreConfiguration.getProductPageId())) || !getFidelitiesList().equals(sKStoreConfiguration.getFidelitiesList()) || hasNonce() != sKStoreConfiguration.hasNonce()) {
                return false;
            }
            if ((hasNonce() && !getNonce().equals(sKStoreConfiguration.getNonce())) || hasSourceAppstoreItemIdentifier() != sKStoreConfiguration.hasSourceAppstoreItemIdentifier()) {
                return false;
            }
            if ((hasSourceAppstoreItemIdentifier() && !getSourceAppstoreItemIdentifier().equals(sKStoreConfiguration.getSourceAppstoreItemIdentifier())) || hasTimestamp() != sKStoreConfiguration.hasTimestamp()) {
                return false;
            }
            if ((!hasTimestamp() || getTimestamp().equals(sKStoreConfiguration.getTimestamp())) && hasSignature() == sKStoreConfiguration.hasSignature()) {
                return (!hasSignature() || getSignature().equals(sKStoreConfiguration.getSignature())) && this.unknownFields.equals(sKStoreConfiguration.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasVersion()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getVersion().hashCode();
            }
            if (hasAdnetworkIdentifier()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getAdnetworkIdentifier().hashCode();
            }
            if (hasSourceIdentifier()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getSourceIdentifier().hashCode();
            }
            if (hasAdcampaignIdentifier()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getAdcampaignIdentifier().hashCode();
            }
            if (hasAdvertisedAppstoreItemIdentifier()) {
                iHashCode = (((iHashCode * 37) + 5) * 53) + getAdvertisedAppstoreItemIdentifier().hashCode();
            }
            if (hasProductPageId()) {
                iHashCode = (((iHashCode * 37) + 6) * 53) + getProductPageId().hashCode();
            }
            if (getFidelitiesCount() > 0) {
                iHashCode = (((iHashCode * 37) + 7) * 53) + getFidelitiesList().hashCode();
            }
            if (hasNonce()) {
                iHashCode = (((iHashCode * 37) + 8) * 53) + getNonce().hashCode();
            }
            if (hasSourceAppstoreItemIdentifier()) {
                iHashCode = (((iHashCode * 37) + 9) * 53) + getSourceAppstoreItemIdentifier().hashCode();
            }
            if (hasTimestamp()) {
                iHashCode = (((iHashCode * 37) + 10) * 53) + getTimestamp().hashCode();
            }
            if (hasSignature()) {
                iHashCode = (((iHashCode * 37) + 11) * 53) + getSignature().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static SKStoreConfiguration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SKStoreConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SKStoreConfiguration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SKStoreConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SKStoreConfiguration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SKStoreConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SKStoreConfiguration parseFrom(InputStream inputStream) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SKStoreConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SKStoreConfiguration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SKStoreConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SKStoreConfiguration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SKStoreConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SKStoreConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SKStoreConfiguration sKStoreConfiguration) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sKStoreConfiguration);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SKStoreConfigurationOrBuilder {
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> adcampaignIdentifierBuilder_;
            private StringValue adcampaignIdentifier_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> adnetworkIdentifierBuilder_;
            private StringValue adnetworkIdentifier_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> advertisedAppstoreItemIdentifierBuilder_;
            private StringValue advertisedAppstoreItemIdentifier_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> fidelitiesBuilder_;
            private List<Fidelity> fidelities_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> nonceBuilder_;
            private StringValue nonce_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> productPageIdBuilder_;
            private StringValue productPageId_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> signatureBuilder_;
            private StringValue signature_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> sourceAppstoreItemIdentifierBuilder_;
            private StringValue sourceAppstoreItemIdentifier_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> sourceIdentifierBuilder_;
            private StringValue sourceIdentifier_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> timestampBuilder_;
            private StringValue timestamp_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> versionBuilder_;
            private StringValue version_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(SKStoreConfiguration.class, Builder.class);
            }

            private Builder() {
                this.fidelities_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.fidelities_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SKStoreConfiguration.alwaysUseFieldBuilders) {
                    getFidelitiesFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.versionBuilder_ == null) {
                    this.version_ = null;
                } else {
                    this.version_ = null;
                    this.versionBuilder_ = null;
                }
                if (this.adnetworkIdentifierBuilder_ == null) {
                    this.adnetworkIdentifier_ = null;
                } else {
                    this.adnetworkIdentifier_ = null;
                    this.adnetworkIdentifierBuilder_ = null;
                }
                if (this.sourceIdentifierBuilder_ == null) {
                    this.sourceIdentifier_ = null;
                } else {
                    this.sourceIdentifier_ = null;
                    this.sourceIdentifierBuilder_ = null;
                }
                if (this.adcampaignIdentifierBuilder_ == null) {
                    this.adcampaignIdentifier_ = null;
                } else {
                    this.adcampaignIdentifier_ = null;
                    this.adcampaignIdentifierBuilder_ = null;
                }
                if (this.advertisedAppstoreItemIdentifierBuilder_ == null) {
                    this.advertisedAppstoreItemIdentifier_ = null;
                } else {
                    this.advertisedAppstoreItemIdentifier_ = null;
                    this.advertisedAppstoreItemIdentifierBuilder_ = null;
                }
                if (this.productPageIdBuilder_ == null) {
                    this.productPageId_ = null;
                } else {
                    this.productPageId_ = null;
                    this.productPageIdBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.fidelities_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                if (this.nonceBuilder_ == null) {
                    this.nonce_ = null;
                } else {
                    this.nonce_ = null;
                    this.nonceBuilder_ = null;
                }
                if (this.sourceAppstoreItemIdentifierBuilder_ == null) {
                    this.sourceAppstoreItemIdentifier_ = null;
                } else {
                    this.sourceAppstoreItemIdentifier_ = null;
                    this.sourceAppstoreItemIdentifierBuilder_ = null;
                }
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                if (this.signatureBuilder_ == null) {
                    this.signature_ = null;
                } else {
                    this.signature_ = null;
                    this.signatureBuilder_ = null;
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public SKStoreConfiguration getDefaultInstanceForType() {
                return SKStoreConfiguration.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SKStoreConfiguration build() {
                SKStoreConfiguration sKStoreConfigurationBuildPartial = buildPartial();
                if (sKStoreConfigurationBuildPartial.isInitialized()) {
                    return sKStoreConfigurationBuildPartial;
                }
                throw newUninitializedMessageException((Message) sKStoreConfigurationBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SKStoreConfiguration buildPartial() {
                SKStoreConfiguration sKStoreConfiguration = new SKStoreConfiguration(this);
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sKStoreConfiguration.version_ = this.version_;
                } else {
                    sKStoreConfiguration.version_ = (StringValue) singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV4 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV4 == null) {
                    sKStoreConfiguration.adnetworkIdentifier_ = this.adnetworkIdentifier_;
                } else {
                    sKStoreConfiguration.adnetworkIdentifier_ = (StringValue) singleFieldBuilderV4.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV5 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV5 == null) {
                    sKStoreConfiguration.sourceIdentifier_ = this.sourceIdentifier_;
                } else {
                    sKStoreConfiguration.sourceIdentifier_ = (StringValue) singleFieldBuilderV5.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV6 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV6 == null) {
                    sKStoreConfiguration.adcampaignIdentifier_ = this.adcampaignIdentifier_;
                } else {
                    sKStoreConfiguration.adcampaignIdentifier_ = (StringValue) singleFieldBuilderV6.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV7 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV7 == null) {
                    sKStoreConfiguration.advertisedAppstoreItemIdentifier_ = this.advertisedAppstoreItemIdentifier_;
                } else {
                    sKStoreConfiguration.advertisedAppstoreItemIdentifier_ = (StringValue) singleFieldBuilderV7.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV8 = this.productPageIdBuilder_;
                if (singleFieldBuilderV8 == null) {
                    sKStoreConfiguration.productPageId_ = this.productPageId_;
                } else {
                    sKStoreConfiguration.productPageId_ = (StringValue) singleFieldBuilderV8.build();
                }
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    sKStoreConfiguration.fidelities_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.fidelities_ = Collections.unmodifiableList(this.fidelities_);
                        this.bitField0_ &= -2;
                    }
                    sKStoreConfiguration.fidelities_ = this.fidelities_;
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV9 = this.nonceBuilder_;
                if (singleFieldBuilderV9 == null) {
                    sKStoreConfiguration.nonce_ = this.nonce_;
                } else {
                    sKStoreConfiguration.nonce_ = (StringValue) singleFieldBuilderV9.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV10 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV10 == null) {
                    sKStoreConfiguration.sourceAppstoreItemIdentifier_ = this.sourceAppstoreItemIdentifier_;
                } else {
                    sKStoreConfiguration.sourceAppstoreItemIdentifier_ = (StringValue) singleFieldBuilderV10.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV11 = this.timestampBuilder_;
                if (singleFieldBuilderV11 == null) {
                    sKStoreConfiguration.timestamp_ = this.timestamp_;
                } else {
                    sKStoreConfiguration.timestamp_ = (StringValue) singleFieldBuilderV11.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV12 = this.signatureBuilder_;
                if (singleFieldBuilderV12 == null) {
                    sKStoreConfiguration.signature_ = this.signature_;
                } else {
                    sKStoreConfiguration.signature_ = (StringValue) singleFieldBuilderV12.build();
                }
                onBuilt();
                return sKStoreConfiguration;
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
                if (message instanceof SKStoreConfiguration) {
                    return mergeFrom((SKStoreConfiguration) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SKStoreConfiguration sKStoreConfiguration) {
                if (sKStoreConfiguration == SKStoreConfiguration.getDefaultInstance()) {
                    return this;
                }
                if (sKStoreConfiguration.hasVersion()) {
                    mergeVersion(sKStoreConfiguration.getVersion());
                }
                if (sKStoreConfiguration.hasAdnetworkIdentifier()) {
                    mergeAdnetworkIdentifier(sKStoreConfiguration.getAdnetworkIdentifier());
                }
                if (sKStoreConfiguration.hasSourceIdentifier()) {
                    mergeSourceIdentifier(sKStoreConfiguration.getSourceIdentifier());
                }
                if (sKStoreConfiguration.hasAdcampaignIdentifier()) {
                    mergeAdcampaignIdentifier(sKStoreConfiguration.getAdcampaignIdentifier());
                }
                if (sKStoreConfiguration.hasAdvertisedAppstoreItemIdentifier()) {
                    mergeAdvertisedAppstoreItemIdentifier(sKStoreConfiguration.getAdvertisedAppstoreItemIdentifier());
                }
                if (sKStoreConfiguration.hasProductPageId()) {
                    mergeProductPageId(sKStoreConfiguration.getProductPageId());
                }
                if (this.fidelitiesBuilder_ == null) {
                    if (!sKStoreConfiguration.fidelities_.isEmpty()) {
                        if (this.fidelities_.isEmpty()) {
                            this.fidelities_ = sKStoreConfiguration.fidelities_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFidelitiesIsMutable();
                            this.fidelities_.addAll(sKStoreConfiguration.fidelities_);
                        }
                        onChanged();
                    }
                } else if (!sKStoreConfiguration.fidelities_.isEmpty()) {
                    if (!this.fidelitiesBuilder_.isEmpty()) {
                        this.fidelitiesBuilder_.addAllMessages(sKStoreConfiguration.fidelities_);
                    } else {
                        this.fidelitiesBuilder_.dispose();
                        this.fidelitiesBuilder_ = null;
                        this.fidelities_ = sKStoreConfiguration.fidelities_;
                        this.bitField0_ &= -2;
                        this.fidelitiesBuilder_ = SKStoreConfiguration.alwaysUseFieldBuilders ? getFidelitiesFieldBuilder() : null;
                    }
                }
                if (sKStoreConfiguration.hasNonce()) {
                    mergeNonce(sKStoreConfiguration.getNonce());
                }
                if (sKStoreConfiguration.hasSourceAppstoreItemIdentifier()) {
                    mergeSourceAppstoreItemIdentifier(sKStoreConfiguration.getSourceAppstoreItemIdentifier());
                }
                if (sKStoreConfiguration.hasTimestamp()) {
                    mergeTimestamp(sKStoreConfiguration.getTimestamp());
                }
                if (sKStoreConfiguration.hasSignature()) {
                    mergeSignature(sKStoreConfiguration.getSignature());
                }
                mergeUnknownFields(sKStoreConfiguration.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                SKStoreConfiguration sKStoreConfiguration = null;
                try {
                    try {
                        SKStoreConfiguration sKStoreConfiguration2 = (SKStoreConfiguration) SKStoreConfiguration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (sKStoreConfiguration2 != null) {
                            mergeFrom(sKStoreConfiguration2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        SKStoreConfiguration sKStoreConfiguration3 = (SKStoreConfiguration) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            sKStoreConfiguration = sKStoreConfiguration3;
                            if (sKStoreConfiguration != null) {
                                mergeFrom(sKStoreConfiguration);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sKStoreConfiguration != null) {
                        mergeFrom(sKStoreConfiguration);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasVersion() {
                return (this.versionBuilder_ == null && this.version_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getVersion() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.version_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setVersion(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.version_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setVersion(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.version_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeVersion(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.version_;
                    if (stringValue2 != null) {
                        this.version_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.version_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearVersion() {
                if (this.versionBuilder_ == null) {
                    this.version_ = null;
                    onChanged();
                } else {
                    this.version_ = null;
                    this.versionBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getVersionBuilder() {
                onChanged();
                return (StringValue.Builder) getVersionFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getVersionOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.version_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getVersionFieldBuilder() {
                if (this.versionBuilder_ == null) {
                    this.versionBuilder_ = new SingleFieldBuilderV3<>(getVersion(), getParentForChildren(), isClean());
                    this.version_ = null;
                }
                return this.versionBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasAdnetworkIdentifier() {
                return (this.adnetworkIdentifierBuilder_ == null && this.adnetworkIdentifier_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getAdnetworkIdentifier() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.adnetworkIdentifier_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setAdnetworkIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.adnetworkIdentifier_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setAdnetworkIdentifier(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.adnetworkIdentifier_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAdnetworkIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.adnetworkIdentifier_;
                    if (stringValue2 != null) {
                        this.adnetworkIdentifier_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.adnetworkIdentifier_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearAdnetworkIdentifier() {
                if (this.adnetworkIdentifierBuilder_ == null) {
                    this.adnetworkIdentifier_ = null;
                    onChanged();
                } else {
                    this.adnetworkIdentifier_ = null;
                    this.adnetworkIdentifierBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getAdnetworkIdentifierBuilder() {
                onChanged();
                return (StringValue.Builder) getAdnetworkIdentifierFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getAdnetworkIdentifierOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adnetworkIdentifierBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.adnetworkIdentifier_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getAdnetworkIdentifierFieldBuilder() {
                if (this.adnetworkIdentifierBuilder_ == null) {
                    this.adnetworkIdentifierBuilder_ = new SingleFieldBuilderV3<>(getAdnetworkIdentifier(), getParentForChildren(), isClean());
                    this.adnetworkIdentifier_ = null;
                }
                return this.adnetworkIdentifierBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasSourceIdentifier() {
                return (this.sourceIdentifierBuilder_ == null && this.sourceIdentifier_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getSourceIdentifier() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.sourceIdentifier_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setSourceIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.sourceIdentifier_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setSourceIdentifier(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sourceIdentifier_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSourceIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.sourceIdentifier_;
                    if (stringValue2 != null) {
                        this.sourceIdentifier_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.sourceIdentifier_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearSourceIdentifier() {
                if (this.sourceIdentifierBuilder_ == null) {
                    this.sourceIdentifier_ = null;
                    onChanged();
                } else {
                    this.sourceIdentifier_ = null;
                    this.sourceIdentifierBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getSourceIdentifierBuilder() {
                onChanged();
                return (StringValue.Builder) getSourceIdentifierFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getSourceIdentifierOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceIdentifierBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.sourceIdentifier_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getSourceIdentifierFieldBuilder() {
                if (this.sourceIdentifierBuilder_ == null) {
                    this.sourceIdentifierBuilder_ = new SingleFieldBuilderV3<>(getSourceIdentifier(), getParentForChildren(), isClean());
                    this.sourceIdentifier_ = null;
                }
                return this.sourceIdentifierBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasAdcampaignIdentifier() {
                return (this.adcampaignIdentifierBuilder_ == null && this.adcampaignIdentifier_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getAdcampaignIdentifier() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.adcampaignIdentifier_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setAdcampaignIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.adcampaignIdentifier_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setAdcampaignIdentifier(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.adcampaignIdentifier_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAdcampaignIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.adcampaignIdentifier_;
                    if (stringValue2 != null) {
                        this.adcampaignIdentifier_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.adcampaignIdentifier_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearAdcampaignIdentifier() {
                if (this.adcampaignIdentifierBuilder_ == null) {
                    this.adcampaignIdentifier_ = null;
                    onChanged();
                } else {
                    this.adcampaignIdentifier_ = null;
                    this.adcampaignIdentifierBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getAdcampaignIdentifierBuilder() {
                onChanged();
                return (StringValue.Builder) getAdcampaignIdentifierFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getAdcampaignIdentifierOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.adcampaignIdentifierBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.adcampaignIdentifier_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getAdcampaignIdentifierFieldBuilder() {
                if (this.adcampaignIdentifierBuilder_ == null) {
                    this.adcampaignIdentifierBuilder_ = new SingleFieldBuilderV3<>(getAdcampaignIdentifier(), getParentForChildren(), isClean());
                    this.adcampaignIdentifier_ = null;
                }
                return this.adcampaignIdentifierBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasAdvertisedAppstoreItemIdentifier() {
                return (this.advertisedAppstoreItemIdentifierBuilder_ == null && this.advertisedAppstoreItemIdentifier_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getAdvertisedAppstoreItemIdentifier() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.advertisedAppstoreItemIdentifier_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setAdvertisedAppstoreItemIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.advertisedAppstoreItemIdentifier_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setAdvertisedAppstoreItemIdentifier(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.advertisedAppstoreItemIdentifier_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAdvertisedAppstoreItemIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.advertisedAppstoreItemIdentifier_;
                    if (stringValue2 != null) {
                        this.advertisedAppstoreItemIdentifier_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.advertisedAppstoreItemIdentifier_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearAdvertisedAppstoreItemIdentifier() {
                if (this.advertisedAppstoreItemIdentifierBuilder_ == null) {
                    this.advertisedAppstoreItemIdentifier_ = null;
                    onChanged();
                } else {
                    this.advertisedAppstoreItemIdentifier_ = null;
                    this.advertisedAppstoreItemIdentifierBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getAdvertisedAppstoreItemIdentifierBuilder() {
                onChanged();
                return (StringValue.Builder) getAdvertisedAppstoreItemIdentifierFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getAdvertisedAppstoreItemIdentifierOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.advertisedAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.advertisedAppstoreItemIdentifier_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getAdvertisedAppstoreItemIdentifierFieldBuilder() {
                if (this.advertisedAppstoreItemIdentifierBuilder_ == null) {
                    this.advertisedAppstoreItemIdentifierBuilder_ = new SingleFieldBuilderV3<>(getAdvertisedAppstoreItemIdentifier(), getParentForChildren(), isClean());
                    this.advertisedAppstoreItemIdentifier_ = null;
                }
                return this.advertisedAppstoreItemIdentifierBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasProductPageId() {
                return (this.productPageIdBuilder_ == null && this.productPageId_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getProductPageId() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.productPageIdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.productPageId_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setProductPageId(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.productPageIdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.productPageId_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setProductPageId(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.productPageIdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.productPageId_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeProductPageId(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.productPageIdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.productPageId_;
                    if (stringValue2 != null) {
                        this.productPageId_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.productPageId_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearProductPageId() {
                if (this.productPageIdBuilder_ == null) {
                    this.productPageId_ = null;
                    onChanged();
                } else {
                    this.productPageId_ = null;
                    this.productPageIdBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getProductPageIdBuilder() {
                onChanged();
                return (StringValue.Builder) getProductPageIdFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getProductPageIdOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.productPageIdBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.productPageId_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getProductPageIdFieldBuilder() {
                if (this.productPageIdBuilder_ == null) {
                    this.productPageIdBuilder_ = new SingleFieldBuilderV3<>(getProductPageId(), getParentForChildren(), isClean());
                    this.productPageId_ = null;
                }
                return this.productPageIdBuilder_;
            }

            private void ensureFidelitiesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fidelities_ = new ArrayList(this.fidelities_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public List<Fidelity> getFidelitiesList() {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.fidelities_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public int getFidelitiesCount() {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.fidelities_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public Fidelity getFidelities(int i) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.fidelities_.get(i);
                }
                return (Fidelity) repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setFidelities(int i, Fidelity fidelity) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fidelity.getClass();
                    ensureFidelitiesIsMutable();
                    this.fidelities_.set(i, fidelity);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, fidelity);
                }
                return this;
            }

            public Builder setFidelities(int i, Fidelity.Builder builder) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFidelitiesIsMutable();
                    this.fidelities_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addFidelities(Fidelity fidelity) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fidelity.getClass();
                    ensureFidelitiesIsMutable();
                    this.fidelities_.add(fidelity);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(fidelity);
                }
                return this;
            }

            public Builder addFidelities(int i, Fidelity fidelity) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fidelity.getClass();
                    ensureFidelitiesIsMutable();
                    this.fidelities_.add(i, fidelity);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, fidelity);
                }
                return this;
            }

            public Builder addFidelities(Fidelity.Builder builder) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFidelitiesIsMutable();
                    this.fidelities_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addFidelities(int i, Fidelity.Builder builder) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFidelitiesIsMutable();
                    this.fidelities_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllFidelities(Iterable<? extends Fidelity> iterable) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFidelitiesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fidelities_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearFidelities() {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.fidelities_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeFidelities(int i) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFidelitiesIsMutable();
                    this.fidelities_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Fidelity.Builder getFidelitiesBuilder(int i) {
                return (Fidelity.Builder) getFidelitiesFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public FidelityOrBuilder getFidelitiesOrBuilder(int i) {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.fidelities_.get(i);
                }
                return (FidelityOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public List<? extends FidelityOrBuilder> getFidelitiesOrBuilderList() {
                RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> repeatedFieldBuilderV3 = this.fidelitiesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fidelities_);
            }

            public Fidelity.Builder addFidelitiesBuilder() {
                return (Fidelity.Builder) getFidelitiesFieldBuilder().addBuilder(Fidelity.getDefaultInstance());
            }

            public Fidelity.Builder addFidelitiesBuilder(int i) {
                return (Fidelity.Builder) getFidelitiesFieldBuilder().addBuilder(i, Fidelity.getDefaultInstance());
            }

            public List<Fidelity.Builder> getFidelitiesBuilderList() {
                return getFidelitiesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Fidelity, Fidelity.Builder, FidelityOrBuilder> getFidelitiesFieldBuilder() {
                if (this.fidelitiesBuilder_ == null) {
                    this.fidelitiesBuilder_ = new RepeatedFieldBuilderV3<>(this.fidelities_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.fidelities_ = null;
                }
                return this.fidelitiesBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasNonce() {
                return (this.nonceBuilder_ == null && this.nonce_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getNonce() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.nonce_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setNonce(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.nonce_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setNonce(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.nonce_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeNonce(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.nonce_;
                    if (stringValue2 != null) {
                        this.nonce_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.nonce_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearNonce() {
                if (this.nonceBuilder_ == null) {
                    this.nonce_ = null;
                    onChanged();
                } else {
                    this.nonce_ = null;
                    this.nonceBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getNonceBuilder() {
                onChanged();
                return (StringValue.Builder) getNonceFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getNonceOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nonceBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.nonce_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getNonceFieldBuilder() {
                if (this.nonceBuilder_ == null) {
                    this.nonceBuilder_ = new SingleFieldBuilderV3<>(getNonce(), getParentForChildren(), isClean());
                    this.nonce_ = null;
                }
                return this.nonceBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasSourceAppstoreItemIdentifier() {
                return (this.sourceAppstoreItemIdentifierBuilder_ == null && this.sourceAppstoreItemIdentifier_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getSourceAppstoreItemIdentifier() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.sourceAppstoreItemIdentifier_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setSourceAppstoreItemIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.sourceAppstoreItemIdentifier_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setSourceAppstoreItemIdentifier(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sourceAppstoreItemIdentifier_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSourceAppstoreItemIdentifier(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.sourceAppstoreItemIdentifier_;
                    if (stringValue2 != null) {
                        this.sourceAppstoreItemIdentifier_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.sourceAppstoreItemIdentifier_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearSourceAppstoreItemIdentifier() {
                if (this.sourceAppstoreItemIdentifierBuilder_ == null) {
                    this.sourceAppstoreItemIdentifier_ = null;
                    onChanged();
                } else {
                    this.sourceAppstoreItemIdentifier_ = null;
                    this.sourceAppstoreItemIdentifierBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getSourceAppstoreItemIdentifierBuilder() {
                onChanged();
                return (StringValue.Builder) getSourceAppstoreItemIdentifierFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getSourceAppstoreItemIdentifierOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.sourceAppstoreItemIdentifierBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.sourceAppstoreItemIdentifier_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getSourceAppstoreItemIdentifierFieldBuilder() {
                if (this.sourceAppstoreItemIdentifierBuilder_ == null) {
                    this.sourceAppstoreItemIdentifierBuilder_ = new SingleFieldBuilderV3<>(getSourceAppstoreItemIdentifier(), getParentForChildren(), isClean());
                    this.sourceAppstoreItemIdentifier_ = null;
                }
                return this.sourceAppstoreItemIdentifierBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getTimestamp() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.timestamp_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setTimestamp(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.timestamp_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setTimestamp(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.timestamp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeTimestamp(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.timestamp_;
                    if (stringValue2 != null) {
                        this.timestamp_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.timestamp_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearTimestamp() {
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                    onChanged();
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getTimestampBuilder() {
                onChanged();
                return (StringValue.Builder) getTimestampFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getTimestampOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.timestamp_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getTimestampFieldBuilder() {
                if (this.timestampBuilder_ == null) {
                    this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                    this.timestamp_ = null;
                }
                return this.timestampBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public boolean hasSignature() {
                return (this.signatureBuilder_ == null && this.signature_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValue getSignature() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.signature_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return (StringValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setSignature(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.signature_ = stringValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(stringValue);
                }
                return this;
            }

            public Builder setSignature(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.signature_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSignature(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.signature_;
                    if (stringValue2 != null) {
                        this.signature_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.signature_ = stringValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stringValue);
                }
                return this;
            }

            public Builder clearSignature() {
                if (this.signatureBuilder_ == null) {
                    this.signature_ = null;
                    onChanged();
                } else {
                    this.signature_ = null;
                    this.signatureBuilder_ = null;
                }
                return this;
            }

            public StringValue.Builder getSignatureBuilder() {
                onChanged();
                return (StringValue.Builder) getSignatureFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.SKStoreConfigurationOrBuilder
            public StringValueOrBuilder getSignatureOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.signatureBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (StringValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.signature_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getSignatureFieldBuilder() {
                if (this.signatureBuilder_ == null) {
                    this.signatureBuilder_ = new SingleFieldBuilderV3<>(getSignature(), getParentForChildren(), isClean());
                    this.signature_ = null;
                }
                return this.signatureBuilder_;
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

        public static SKStoreConfiguration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SKStoreConfiguration> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<SKStoreConfiguration> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public SKStoreConfiguration getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class ProductConfiguration extends GeneratedMessageV3 implements ProductConfigurationOrBuilder {
        public static final int ALLOW_STOREKIT_SUBCLASS_FIELD_NUMBER = 1;
        private static final ProductConfiguration DEFAULT_INSTANCE = new ProductConfiguration();
        private static final Parser<ProductConfiguration> PARSER = new AbstractParser<ProductConfiguration>() { // from class: io.bidmachine.protobuf.rendering.Rendering.ProductConfiguration.1
            @Override // com.explorestack.protobuf.Parser
            public ProductConfiguration parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ProductConfiguration(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SHOULD_REMOVE_STORE_AFTER_PRESENT_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private BoolValue allowStorekitSubclass_;
        private byte memoizedIsInitialized;
        private BoolValue shouldRemoveStoreAfterPresent_;

        private ProductConfiguration(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ProductConfiguration() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ProductConfiguration();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ProductConfiguration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            BoolValue.Builder builder;
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
                                BoolValue boolValue = this.allowStorekitSubclass_;
                                builder = boolValue != null ? boolValue.toBuilder() : null;
                                BoolValue boolValue2 = (BoolValue) codedInputStream.readMessage(BoolValue.parser(), extensionRegistryLite);
                                this.allowStorekitSubclass_ = boolValue2;
                                if (builder != null) {
                                    builder.mergeFrom(boolValue2);
                                    this.allowStorekitSubclass_ = builder.buildPartial();
                                }
                            } else if (tag == 18) {
                                BoolValue boolValue3 = this.shouldRemoveStoreAfterPresent_;
                                builder = boolValue3 != null ? boolValue3.toBuilder() : null;
                                BoolValue boolValue4 = (BoolValue) codedInputStream.readMessage(BoolValue.parser(), extensionRegistryLite);
                                this.shouldRemoveStoreAfterPresent_ = boolValue4;
                                if (builder != null) {
                                    builder.mergeFrom(boolValue4);
                                    this.shouldRemoveStoreAfterPresent_ = builder.buildPartial();
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
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(ProductConfiguration.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public boolean hasAllowStorekitSubclass() {
            return this.allowStorekitSubclass_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public BoolValue getAllowStorekitSubclass() {
            BoolValue boolValue = this.allowStorekitSubclass_;
            return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public BoolValueOrBuilder getAllowStorekitSubclassOrBuilder() {
            return getAllowStorekitSubclass();
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public boolean hasShouldRemoveStoreAfterPresent() {
            return this.shouldRemoveStoreAfterPresent_ != null;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public BoolValue getShouldRemoveStoreAfterPresent() {
            BoolValue boolValue = this.shouldRemoveStoreAfterPresent_;
            return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
        }

        @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
        public BoolValueOrBuilder getShouldRemoveStoreAfterPresentOrBuilder() {
            return getShouldRemoveStoreAfterPresent();
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
            if (this.allowStorekitSubclass_ != null) {
                codedOutputStream.writeMessage(1, getAllowStorekitSubclass());
            }
            if (this.shouldRemoveStoreAfterPresent_ != null) {
                codedOutputStream.writeMessage(2, getShouldRemoveStoreAfterPresent());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = this.allowStorekitSubclass_ != null ? CodedOutputStream.computeMessageSize(1, getAllowStorekitSubclass()) : 0;
            if (this.shouldRemoveStoreAfterPresent_ != null) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getShouldRemoveStoreAfterPresent());
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
            if (!(obj instanceof ProductConfiguration)) {
                return super.equals(obj);
            }
            ProductConfiguration productConfiguration = (ProductConfiguration) obj;
            if (hasAllowStorekitSubclass() != productConfiguration.hasAllowStorekitSubclass()) {
                return false;
            }
            if ((!hasAllowStorekitSubclass() || getAllowStorekitSubclass().equals(productConfiguration.getAllowStorekitSubclass())) && hasShouldRemoveStoreAfterPresent() == productConfiguration.hasShouldRemoveStoreAfterPresent()) {
                return (!hasShouldRemoveStoreAfterPresent() || getShouldRemoveStoreAfterPresent().equals(productConfiguration.getShouldRemoveStoreAfterPresent())) && this.unknownFields.equals(productConfiguration.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasAllowStorekitSubclass()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getAllowStorekitSubclass().hashCode();
            }
            if (hasShouldRemoveStoreAfterPresent()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getShouldRemoveStoreAfterPresent().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static ProductConfiguration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ProductConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ProductConfiguration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ProductConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ProductConfiguration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ProductConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ProductConfiguration parseFrom(InputStream inputStream) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ProductConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ProductConfiguration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ProductConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ProductConfiguration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ProductConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProductConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProductConfiguration productConfiguration) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(productConfiguration);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProductConfigurationOrBuilder {
            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> allowStorekitSubclassBuilder_;
            private BoolValue allowStorekitSubclass_;
            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> shouldRemoveStoreAfterPresentBuilder_;
            private BoolValue shouldRemoveStoreAfterPresent_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(ProductConfiguration.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ProductConfiguration.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.allowStorekitSubclassBuilder_ == null) {
                    this.allowStorekitSubclass_ = null;
                } else {
                    this.allowStorekitSubclass_ = null;
                    this.allowStorekitSubclassBuilder_ = null;
                }
                if (this.shouldRemoveStoreAfterPresentBuilder_ == null) {
                    this.shouldRemoveStoreAfterPresent_ = null;
                } else {
                    this.shouldRemoveStoreAfterPresent_ = null;
                    this.shouldRemoveStoreAfterPresentBuilder_ = null;
                }
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RenderingProto.internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public ProductConfiguration getDefaultInstanceForType() {
                return ProductConfiguration.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ProductConfiguration build() {
                ProductConfiguration productConfigurationBuildPartial = buildPartial();
                if (productConfigurationBuildPartial.isInitialized()) {
                    return productConfigurationBuildPartial;
                }
                throw newUninitializedMessageException((Message) productConfigurationBuildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ProductConfiguration buildPartial() {
                ProductConfiguration productConfiguration = new ProductConfiguration(this);
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 == null) {
                    productConfiguration.allowStorekitSubclass_ = this.allowStorekitSubclass_;
                } else {
                    productConfiguration.allowStorekitSubclass_ = (BoolValue) singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV4 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV4 == null) {
                    productConfiguration.shouldRemoveStoreAfterPresent_ = this.shouldRemoveStoreAfterPresent_;
                } else {
                    productConfiguration.shouldRemoveStoreAfterPresent_ = (BoolValue) singleFieldBuilderV4.build();
                }
                onBuilt();
                return productConfiguration;
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
                if (message instanceof ProductConfiguration) {
                    return mergeFrom((ProductConfiguration) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ProductConfiguration productConfiguration) {
                if (productConfiguration == ProductConfiguration.getDefaultInstance()) {
                    return this;
                }
                if (productConfiguration.hasAllowStorekitSubclass()) {
                    mergeAllowStorekitSubclass(productConfiguration.getAllowStorekitSubclass());
                }
                if (productConfiguration.hasShouldRemoveStoreAfterPresent()) {
                    mergeShouldRemoveStoreAfterPresent(productConfiguration.getShouldRemoveStoreAfterPresent());
                }
                mergeUnknownFields(productConfiguration.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                ProductConfiguration productConfiguration = null;
                try {
                    try {
                        ProductConfiguration productConfiguration2 = (ProductConfiguration) ProductConfiguration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (productConfiguration2 != null) {
                            mergeFrom(productConfiguration2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        ProductConfiguration productConfiguration3 = (ProductConfiguration) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            productConfiguration = productConfiguration3;
                            if (productConfiguration != null) {
                                mergeFrom(productConfiguration);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (productConfiguration != null) {
                        mergeFrom(productConfiguration);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public boolean hasAllowStorekitSubclass() {
                return (this.allowStorekitSubclassBuilder_ == null && this.allowStorekitSubclass_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public BoolValue getAllowStorekitSubclass() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue = this.allowStorekitSubclass_;
                    return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
                }
                return (BoolValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setAllowStorekitSubclass(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 == null) {
                    boolValue.getClass();
                    this.allowStorekitSubclass_ = boolValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(boolValue);
                }
                return this;
            }

            public Builder setAllowStorekitSubclass(BoolValue.Builder builder) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.allowStorekitSubclass_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAllowStorekitSubclass(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue2 = this.allowStorekitSubclass_;
                    if (boolValue2 != null) {
                        this.allowStorekitSubclass_ = BoolValue.newBuilder(boolValue2).mergeFrom(boolValue).buildPartial();
                    } else {
                        this.allowStorekitSubclass_ = boolValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(boolValue);
                }
                return this;
            }

            public Builder clearAllowStorekitSubclass() {
                if (this.allowStorekitSubclassBuilder_ == null) {
                    this.allowStorekitSubclass_ = null;
                    onChanged();
                } else {
                    this.allowStorekitSubclass_ = null;
                    this.allowStorekitSubclassBuilder_ = null;
                }
                return this;
            }

            public BoolValue.Builder getAllowStorekitSubclassBuilder() {
                onChanged();
                return (BoolValue.Builder) getAllowStorekitSubclassFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public BoolValueOrBuilder getAllowStorekitSubclassOrBuilder() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.allowStorekitSubclassBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (BoolValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                BoolValue boolValue = this.allowStorekitSubclass_;
                return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
            }

            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> getAllowStorekitSubclassFieldBuilder() {
                if (this.allowStorekitSubclassBuilder_ == null) {
                    this.allowStorekitSubclassBuilder_ = new SingleFieldBuilderV3<>(getAllowStorekitSubclass(), getParentForChildren(), isClean());
                    this.allowStorekitSubclass_ = null;
                }
                return this.allowStorekitSubclassBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public boolean hasShouldRemoveStoreAfterPresent() {
                return (this.shouldRemoveStoreAfterPresentBuilder_ == null && this.shouldRemoveStoreAfterPresent_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public BoolValue getShouldRemoveStoreAfterPresent() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue = this.shouldRemoveStoreAfterPresent_;
                    return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
                }
                return (BoolValue) singleFieldBuilderV3.getMessage();
            }

            public Builder setShouldRemoveStoreAfterPresent(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV3 == null) {
                    boolValue.getClass();
                    this.shouldRemoveStoreAfterPresent_ = boolValue;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(boolValue);
                }
                return this;
            }

            public Builder setShouldRemoveStoreAfterPresent(BoolValue.Builder builder) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.shouldRemoveStoreAfterPresent_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeShouldRemoveStoreAfterPresent(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue2 = this.shouldRemoveStoreAfterPresent_;
                    if (boolValue2 != null) {
                        this.shouldRemoveStoreAfterPresent_ = BoolValue.newBuilder(boolValue2).mergeFrom(boolValue).buildPartial();
                    } else {
                        this.shouldRemoveStoreAfterPresent_ = boolValue;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(boolValue);
                }
                return this;
            }

            public Builder clearShouldRemoveStoreAfterPresent() {
                if (this.shouldRemoveStoreAfterPresentBuilder_ == null) {
                    this.shouldRemoveStoreAfterPresent_ = null;
                    onChanged();
                } else {
                    this.shouldRemoveStoreAfterPresent_ = null;
                    this.shouldRemoveStoreAfterPresentBuilder_ = null;
                }
                return this;
            }

            public BoolValue.Builder getShouldRemoveStoreAfterPresentBuilder() {
                onChanged();
                return (BoolValue.Builder) getShouldRemoveStoreAfterPresentFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.Rendering.ProductConfigurationOrBuilder
            public BoolValueOrBuilder getShouldRemoveStoreAfterPresentOrBuilder() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.shouldRemoveStoreAfterPresentBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (BoolValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                BoolValue boolValue = this.shouldRemoveStoreAfterPresent_;
                return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
            }

            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> getShouldRemoveStoreAfterPresentFieldBuilder() {
                if (this.shouldRemoveStoreAfterPresentBuilder_ == null) {
                    this.shouldRemoveStoreAfterPresentBuilder_ = new SingleFieldBuilderV3<>(getShouldRemoveStoreAfterPresent(), getParentForChildren(), isClean());
                    this.shouldRemoveStoreAfterPresent_ = null;
                }
                return this.shouldRemoveStoreAfterPresentBuilder_;
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

        public static ProductConfiguration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProductConfiguration> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<ProductConfiguration> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public ProductConfiguration getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public int getOrientationValue() {
        return this.orientation_;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public Orientation getOrientation() {
        Orientation orientationValueOf = Orientation.valueOf(this.orientation_);
        return orientationValueOf == null ? Orientation.UNRECOGNIZED : orientationValueOf;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public int getCacheTypeValue() {
        return this.cacheType_;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public CacheType getCacheType() {
        CacheType cacheTypeValueOf = CacheType.valueOf(this.cacheType_);
        return cacheTypeValueOf == null ? CacheType.UNRECOGNIZED : cacheTypeValueOf;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public List<Phase> getPhasesList() {
        return this.phases_;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public List<? extends PhaseOrBuilder> getPhasesOrBuilderList() {
        return this.phases_;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public int getPhasesCount() {
        return this.phases_.size();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public Phase getPhases(int i) {
        return this.phases_.get(i);
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public PhaseOrBuilder getPhasesOrBuilder(int i) {
        return this.phases_.get(i);
    }

    private static final class CustomParamsDefaultEntryHolder {
        static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(RenderingProto.internal_static_bidmachine_protobuf_Rendering_CustomParamsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private CustomParamsDefaultEntryHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, String> internalGetCustomParams() {
        MapField<String, String> mapField = this.customParams_;
        return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public int getCustomParamsCount() {
        return internalGetCustomParams().getMap().size();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public boolean containsCustomParams(String str) {
        str.getClass();
        return internalGetCustomParams().getMap().containsKey(str);
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    @Deprecated
    public Map<String, String> getCustomParams() {
        return getCustomParamsMap();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public Map<String, String> getCustomParamsMap() {
        return internalGetCustomParams().getMap();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public String getCustomParamsOrDefault(String str, String str2) {
        str.getClass();
        Map<String, String> map = internalGetCustomParams().getMap();
        return map.containsKey(str) ? map.get(str) : str2;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public String getCustomParamsOrThrow(String str) {
        str.getClass();
        Map<String, String> map = internalGetCustomParams().getMap();
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return map.get(str);
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public boolean hasSkAdNetwork() {
        return this.skAdNetwork_ != null;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public SKStoreConfiguration getSkAdNetwork() {
        SKStoreConfiguration sKStoreConfiguration = this.skAdNetwork_;
        return sKStoreConfiguration == null ? SKStoreConfiguration.getDefaultInstance() : sKStoreConfiguration;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public SKStoreConfigurationOrBuilder getSkAdNetworkOrBuilder() {
        return getSkAdNetwork();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public boolean hasProductConfiguration() {
        return this.productConfiguration_ != null;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public ProductConfiguration getProductConfiguration() {
        ProductConfiguration productConfiguration = this.productConfiguration_;
        return productConfiguration == null ? ProductConfiguration.getDefaultInstance() : productConfiguration;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
    public ProductConfigurationOrBuilder getProductConfigurationOrBuilder() {
        return getProductConfiguration();
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
        if (this.orientation_ != Orientation.ORIENTATION_INVALID.getNumber()) {
            codedOutputStream.writeEnum(1, this.orientation_);
        }
        if (this.cacheType_ != CacheType.CACHE_TYPE_INVALID.getNumber()) {
            codedOutputStream.writeEnum(2, this.cacheType_);
        }
        for (int i = 0; i < this.phases_.size(); i++) {
            codedOutputStream.writeMessage(3, this.phases_.get(i));
        }
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetCustomParams(), CustomParamsDefaultEntryHolder.defaultEntry, 4);
        if (this.skAdNetwork_ != null) {
            codedOutputStream.writeMessage(5, getSkAdNetwork());
        }
        if (this.productConfiguration_ != null) {
            codedOutputStream.writeMessage(6, getProductConfiguration());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = this.orientation_ != Orientation.ORIENTATION_INVALID.getNumber() ? CodedOutputStream.computeEnumSize(1, this.orientation_) : 0;
        if (this.cacheType_ != CacheType.CACHE_TYPE_INVALID.getNumber()) {
            iComputeEnumSize += CodedOutputStream.computeEnumSize(2, this.cacheType_);
        }
        for (int i2 = 0; i2 < this.phases_.size(); i2++) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(3, this.phases_.get(i2));
        }
        for (Map.Entry<String, String> entry : internalGetCustomParams().getMap().entrySet()) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(4, CustomParamsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        if (this.skAdNetwork_ != null) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(5, getSkAdNetwork());
        }
        if (this.productConfiguration_ != null) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(6, getProductConfiguration());
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
        if (!(obj instanceof Rendering)) {
            return super.equals(obj);
        }
        Rendering rendering = (Rendering) obj;
        if (this.orientation_ != rendering.orientation_ || this.cacheType_ != rendering.cacheType_ || !getPhasesList().equals(rendering.getPhasesList()) || !internalGetCustomParams().equals(rendering.internalGetCustomParams()) || hasSkAdNetwork() != rendering.hasSkAdNetwork()) {
            return false;
        }
        if ((!hasSkAdNetwork() || getSkAdNetwork().equals(rendering.getSkAdNetwork())) && hasProductConfiguration() == rendering.hasProductConfiguration()) {
            return (!hasProductConfiguration() || getProductConfiguration().equals(rendering.getProductConfiguration())) && this.unknownFields.equals(rendering.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.orientation_) * 37) + 2) * 53) + this.cacheType_;
        if (getPhasesCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getPhasesList().hashCode();
        }
        if (!internalGetCustomParams().getMap().isEmpty()) {
            iHashCode = (((iHashCode * 37) + 4) * 53) + internalGetCustomParams().hashCode();
        }
        if (hasSkAdNetwork()) {
            iHashCode = (((iHashCode * 37) + 5) * 53) + getSkAdNetwork().hashCode();
        }
        if (hasProductConfiguration()) {
            iHashCode = (((iHashCode * 37) + 6) * 53) + getProductConfiguration().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static Rendering parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Rendering parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Rendering parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Rendering parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Rendering parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Rendering parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Rendering parseFrom(InputStream inputStream) throws IOException {
        return (Rendering) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Rendering parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Rendering) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Rendering parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Rendering) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Rendering parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Rendering) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Rendering parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Rendering) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Rendering parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Rendering) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Rendering rendering) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(rendering);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RenderingOrBuilder {
        private int bitField0_;
        private int cacheType_;
        private MapField<String, String> customParams_;
        private int orientation_;
        private RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> phasesBuilder_;
        private List<Phase> phases_;
        private SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> productConfigurationBuilder_;
        private ProductConfiguration productConfiguration_;
        private SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> skAdNetworkBuilder_;
        private SKStoreConfiguration skAdNetwork_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMapField(int i) {
            if (i == 4) {
                return internalGetCustomParams();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMutableMapField(int i) {
            if (i == 4) {
                return internalGetMutableCustomParams();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_fieldAccessorTable.ensureFieldAccessorsInitialized(Rendering.class, Builder.class);
        }

        private Builder() {
            this.orientation_ = 0;
            this.cacheType_ = 0;
            this.phases_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.orientation_ = 0;
            this.cacheType_ = 0;
            this.phases_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Rendering.alwaysUseFieldBuilders) {
                getPhasesFieldBuilder();
            }
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.orientation_ = 0;
            this.cacheType_ = 0;
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.phases_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            internalGetMutableCustomParams().clear();
            if (this.skAdNetworkBuilder_ == null) {
                this.skAdNetwork_ = null;
            } else {
                this.skAdNetwork_ = null;
                this.skAdNetworkBuilder_ = null;
            }
            if (this.productConfigurationBuilder_ == null) {
                this.productConfiguration_ = null;
            } else {
                this.productConfiguration_ = null;
                this.productConfigurationBuilder_ = null;
            }
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return RenderingProto.internal_static_bidmachine_protobuf_Rendering_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Rendering getDefaultInstanceForType() {
            return Rendering.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Rendering build() {
            Rendering renderingBuildPartial = buildPartial();
            if (renderingBuildPartial.isInitialized()) {
                return renderingBuildPartial;
            }
            throw newUninitializedMessageException((Message) renderingBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Rendering buildPartial() {
            Rendering rendering = new Rendering(this);
            rendering.orientation_ = this.orientation_;
            rendering.cacheType_ = this.cacheType_;
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                rendering.phases_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.phases_ = Collections.unmodifiableList(this.phases_);
                    this.bitField0_ &= -2;
                }
                rendering.phases_ = this.phases_;
            }
            rendering.customParams_ = internalGetCustomParams();
            rendering.customParams_.makeImmutable();
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 == null) {
                rendering.skAdNetwork_ = this.skAdNetwork_;
            } else {
                rendering.skAdNetwork_ = (SKStoreConfiguration) singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV4 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV4 == null) {
                rendering.productConfiguration_ = this.productConfiguration_;
            } else {
                rendering.productConfiguration_ = (ProductConfiguration) singleFieldBuilderV4.build();
            }
            onBuilt();
            return rendering;
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
            if (message instanceof Rendering) {
                return mergeFrom((Rendering) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Rendering rendering) {
            if (rendering == Rendering.getDefaultInstance()) {
                return this;
            }
            if (rendering.orientation_ != 0) {
                setOrientationValue(rendering.getOrientationValue());
            }
            if (rendering.cacheType_ != 0) {
                setCacheTypeValue(rendering.getCacheTypeValue());
            }
            if (this.phasesBuilder_ == null) {
                if (!rendering.phases_.isEmpty()) {
                    if (this.phases_.isEmpty()) {
                        this.phases_ = rendering.phases_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePhasesIsMutable();
                        this.phases_.addAll(rendering.phases_);
                    }
                    onChanged();
                }
            } else if (!rendering.phases_.isEmpty()) {
                if (!this.phasesBuilder_.isEmpty()) {
                    this.phasesBuilder_.addAllMessages(rendering.phases_);
                } else {
                    this.phasesBuilder_.dispose();
                    this.phasesBuilder_ = null;
                    this.phases_ = rendering.phases_;
                    this.bitField0_ &= -2;
                    this.phasesBuilder_ = Rendering.alwaysUseFieldBuilders ? getPhasesFieldBuilder() : null;
                }
            }
            internalGetMutableCustomParams().mergeFrom(rendering.internalGetCustomParams());
            if (rendering.hasSkAdNetwork()) {
                mergeSkAdNetwork(rendering.getSkAdNetwork());
            }
            if (rendering.hasProductConfiguration()) {
                mergeProductConfiguration(rendering.getProductConfiguration());
            }
            mergeUnknownFields(rendering.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            Rendering rendering = null;
            try {
                try {
                    Rendering rendering2 = (Rendering) Rendering.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (rendering2 != null) {
                        mergeFrom(rendering2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Rendering rendering3 = (Rendering) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        rendering = rendering3;
                        if (rendering != null) {
                            mergeFrom(rendering);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rendering != null) {
                    mergeFrom(rendering);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public int getOrientationValue() {
            return this.orientation_;
        }

        public Builder setOrientationValue(int i) {
            this.orientation_ = i;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public Orientation getOrientation() {
            Orientation orientationValueOf = Orientation.valueOf(this.orientation_);
            return orientationValueOf == null ? Orientation.UNRECOGNIZED : orientationValueOf;
        }

        public Builder setOrientation(Orientation orientation) {
            orientation.getClass();
            this.orientation_ = orientation.getNumber();
            onChanged();
            return this;
        }

        public Builder clearOrientation() {
            this.orientation_ = 0;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public int getCacheTypeValue() {
            return this.cacheType_;
        }

        public Builder setCacheTypeValue(int i) {
            this.cacheType_ = i;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public CacheType getCacheType() {
            CacheType cacheTypeValueOf = CacheType.valueOf(this.cacheType_);
            return cacheTypeValueOf == null ? CacheType.UNRECOGNIZED : cacheTypeValueOf;
        }

        public Builder setCacheType(CacheType cacheType) {
            cacheType.getClass();
            this.cacheType_ = cacheType.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCacheType() {
            this.cacheType_ = 0;
            onChanged();
            return this;
        }

        private void ensurePhasesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.phases_ = new ArrayList(this.phases_);
                this.bitField0_ |= 1;
            }
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public List<Phase> getPhasesList() {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.phases_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public int getPhasesCount() {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.phases_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public Phase getPhases(int i) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.phases_.get(i);
            }
            return (Phase) repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder setPhases(int i, Phase phase) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                phase.getClass();
                ensurePhasesIsMutable();
                this.phases_.set(i, phase);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, phase);
            }
            return this;
        }

        public Builder setPhases(int i, Phase.Builder builder) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePhasesIsMutable();
                this.phases_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder addPhases(Phase phase) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                phase.getClass();
                ensurePhasesIsMutable();
                this.phases_.add(phase);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(phase);
            }
            return this;
        }

        public Builder addPhases(int i, Phase phase) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                phase.getClass();
                ensurePhasesIsMutable();
                this.phases_.add(i, phase);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, phase);
            }
            return this;
        }

        public Builder addPhases(Phase.Builder builder) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePhasesIsMutable();
                this.phases_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addPhases(int i, Phase.Builder builder) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePhasesIsMutable();
                this.phases_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        public Builder addAllPhases(Iterable<? extends Phase> iterable) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePhasesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.phases_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearPhases() {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.phases_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder removePhases(int i) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePhasesIsMutable();
                this.phases_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public Phase.Builder getPhasesBuilder(int i) {
            return (Phase.Builder) getPhasesFieldBuilder().getBuilder(i);
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public PhaseOrBuilder getPhasesOrBuilder(int i) {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.phases_.get(i);
            }
            return (PhaseOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public List<? extends PhaseOrBuilder> getPhasesOrBuilderList() {
            RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> repeatedFieldBuilderV3 = this.phasesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.phases_);
        }

        public Phase.Builder addPhasesBuilder() {
            return (Phase.Builder) getPhasesFieldBuilder().addBuilder(Phase.getDefaultInstance());
        }

        public Phase.Builder addPhasesBuilder(int i) {
            return (Phase.Builder) getPhasesFieldBuilder().addBuilder(i, Phase.getDefaultInstance());
        }

        public List<Phase.Builder> getPhasesBuilderList() {
            return getPhasesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Phase, Phase.Builder, PhaseOrBuilder> getPhasesFieldBuilder() {
            if (this.phasesBuilder_ == null) {
                this.phasesBuilder_ = new RepeatedFieldBuilderV3<>(this.phases_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.phases_ = null;
            }
            return this.phasesBuilder_;
        }

        private MapField<String, String> internalGetCustomParams() {
            MapField<String, String> mapField = this.customParams_;
            return mapField == null ? MapField.emptyMapField(CustomParamsDefaultEntryHolder.defaultEntry) : mapField;
        }

        private MapField<String, String> internalGetMutableCustomParams() {
            onChanged();
            if (this.customParams_ == null) {
                this.customParams_ = MapField.newMapField(CustomParamsDefaultEntryHolder.defaultEntry);
            }
            if (!this.customParams_.isMutable()) {
                this.customParams_ = this.customParams_.copy();
            }
            return this.customParams_;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public int getCustomParamsCount() {
            return internalGetCustomParams().getMap().size();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public boolean containsCustomParams(String str) {
            str.getClass();
            return internalGetCustomParams().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        @Deprecated
        public Map<String, String> getCustomParams() {
            return getCustomParamsMap();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public Map<String, String> getCustomParamsMap() {
            return internalGetCustomParams().getMap();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public String getCustomParamsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> map = internalGetCustomParams().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public String getCustomParamsOrThrow(String str) {
            str.getClass();
            Map<String, String> map = internalGetCustomParams().getMap();
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return map.get(str);
        }

        public Builder clearCustomParams() {
            internalGetMutableCustomParams().getMutableMap().clear();
            return this;
        }

        public Builder removeCustomParams(String str) {
            str.getClass();
            internalGetMutableCustomParams().getMutableMap().remove(str);
            return this;
        }

        @Deprecated
        public Map<String, String> getMutableCustomParams() {
            return internalGetMutableCustomParams().getMutableMap();
        }

        public Builder putCustomParams(String str, String str2) {
            str.getClass();
            str2.getClass();
            internalGetMutableCustomParams().getMutableMap().put(str, str2);
            return this;
        }

        public Builder putAllCustomParams(Map<String, String> map) {
            internalGetMutableCustomParams().getMutableMap().putAll(map);
            return this;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public boolean hasSkAdNetwork() {
            return (this.skAdNetworkBuilder_ == null && this.skAdNetwork_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public SKStoreConfiguration getSkAdNetwork() {
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 == null) {
                SKStoreConfiguration sKStoreConfiguration = this.skAdNetwork_;
                return sKStoreConfiguration == null ? SKStoreConfiguration.getDefaultInstance() : sKStoreConfiguration;
            }
            return (SKStoreConfiguration) singleFieldBuilderV3.getMessage();
        }

        public Builder setSkAdNetwork(SKStoreConfiguration sKStoreConfiguration) {
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 == null) {
                sKStoreConfiguration.getClass();
                this.skAdNetwork_ = sKStoreConfiguration;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(sKStoreConfiguration);
            }
            return this;
        }

        public Builder setSkAdNetwork(SKStoreConfiguration.Builder builder) {
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.skAdNetwork_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeSkAdNetwork(SKStoreConfiguration sKStoreConfiguration) {
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 == null) {
                SKStoreConfiguration sKStoreConfiguration2 = this.skAdNetwork_;
                if (sKStoreConfiguration2 != null) {
                    this.skAdNetwork_ = SKStoreConfiguration.newBuilder(sKStoreConfiguration2).mergeFrom(sKStoreConfiguration).buildPartial();
                } else {
                    this.skAdNetwork_ = sKStoreConfiguration;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(sKStoreConfiguration);
            }
            return this;
        }

        public Builder clearSkAdNetwork() {
            if (this.skAdNetworkBuilder_ == null) {
                this.skAdNetwork_ = null;
                onChanged();
            } else {
                this.skAdNetwork_ = null;
                this.skAdNetworkBuilder_ = null;
            }
            return this;
        }

        public SKStoreConfiguration.Builder getSkAdNetworkBuilder() {
            onChanged();
            return (SKStoreConfiguration.Builder) getSkAdNetworkFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public SKStoreConfigurationOrBuilder getSkAdNetworkOrBuilder() {
            SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> singleFieldBuilderV3 = this.skAdNetworkBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (SKStoreConfigurationOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            SKStoreConfiguration sKStoreConfiguration = this.skAdNetwork_;
            return sKStoreConfiguration == null ? SKStoreConfiguration.getDefaultInstance() : sKStoreConfiguration;
        }

        private SingleFieldBuilderV3<SKStoreConfiguration, SKStoreConfiguration.Builder, SKStoreConfigurationOrBuilder> getSkAdNetworkFieldBuilder() {
            if (this.skAdNetworkBuilder_ == null) {
                this.skAdNetworkBuilder_ = new SingleFieldBuilderV3<>(getSkAdNetwork(), getParentForChildren(), isClean());
                this.skAdNetwork_ = null;
            }
            return this.skAdNetworkBuilder_;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public boolean hasProductConfiguration() {
            return (this.productConfigurationBuilder_ == null && this.productConfiguration_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public ProductConfiguration getProductConfiguration() {
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV3 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV3 == null) {
                ProductConfiguration productConfiguration = this.productConfiguration_;
                return productConfiguration == null ? ProductConfiguration.getDefaultInstance() : productConfiguration;
            }
            return (ProductConfiguration) singleFieldBuilderV3.getMessage();
        }

        public Builder setProductConfiguration(ProductConfiguration productConfiguration) {
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV3 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV3 == null) {
                productConfiguration.getClass();
                this.productConfiguration_ = productConfiguration;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(productConfiguration);
            }
            return this;
        }

        public Builder setProductConfiguration(ProductConfiguration.Builder builder) {
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV3 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.productConfiguration_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeProductConfiguration(ProductConfiguration productConfiguration) {
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV3 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV3 == null) {
                ProductConfiguration productConfiguration2 = this.productConfiguration_;
                if (productConfiguration2 != null) {
                    this.productConfiguration_ = ProductConfiguration.newBuilder(productConfiguration2).mergeFrom(productConfiguration).buildPartial();
                } else {
                    this.productConfiguration_ = productConfiguration;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(productConfiguration);
            }
            return this;
        }

        public Builder clearProductConfiguration() {
            if (this.productConfigurationBuilder_ == null) {
                this.productConfiguration_ = null;
                onChanged();
            } else {
                this.productConfiguration_ = null;
                this.productConfigurationBuilder_ = null;
            }
            return this;
        }

        public ProductConfiguration.Builder getProductConfigurationBuilder() {
            onChanged();
            return (ProductConfiguration.Builder) getProductConfigurationFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingOrBuilder
        public ProductConfigurationOrBuilder getProductConfigurationOrBuilder() {
            SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> singleFieldBuilderV3 = this.productConfigurationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (ProductConfigurationOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            ProductConfiguration productConfiguration = this.productConfiguration_;
            return productConfiguration == null ? ProductConfiguration.getDefaultInstance() : productConfiguration;
        }

        private SingleFieldBuilderV3<ProductConfiguration, ProductConfiguration.Builder, ProductConfigurationOrBuilder> getProductConfigurationFieldBuilder() {
            if (this.productConfigurationBuilder_ == null) {
                this.productConfigurationBuilder_ = new SingleFieldBuilderV3<>(getProductConfiguration(), getParentForChildren(), isClean());
                this.productConfiguration_ = null;
            }
            return this.productConfigurationBuilder_;
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

    public static Rendering getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Rendering> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Rendering> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Rendering getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
