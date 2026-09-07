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
import com.explorestack.protobuf.LazyStringArrayList;
import com.explorestack.protobuf.LazyStringList;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.ProtocolStringList;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Device extends GeneratedMessageV3 implements DeviceOrBuilder {
    public static final int ACCESS_FIELD_NUMBER = 19;
    public static final int AIRPLANE_FIELD_NUMBER = 12;
    public static final int APILEVEL_FIELD_NUMBER = 31;
    public static final int ATTS_FIELD_NUMBER = 22;
    public static final int AUDIOCONTEXT_FIELD_NUMBER = 24;
    public static final int BATTERYLEVEL_FIELD_NUMBER = 9;
    public static final int BATTERYSAVER_FIELD_NUMBER = 10;
    public static final int BM_IFV_FIELD_NUMBER = 2;
    public static final int CHARGING_FIELD_NUMBER = 7;
    public static final int CONNECTION_FIELD_NUMBER = 23;
    public static final int CPUNAME_FIELD_NUMBER = 25;
    public static final int CPUVENDOR_FIELD_NUMBER = 26;
    public static final int DARKMODE_FIELD_NUMBER = 11;
    public static final int DEVICENAME_FIELD_NUMBER = 14;
    public static final int DISKSPACE_FIELD_NUMBER = 4;
    public static final int DND_FIELD_NUMBER = 13;
    public static final int FREEMEM_FIELD_NUMBER = 30;
    public static final int GPUNAME_FIELD_NUMBER = 27;
    public static final int GPUVENDOR_FIELD_NUMBER = 28;
    public static final int HEADSETNAME_FIELD_NUMBER = 20;
    public static final int HEADSET_FIELD_NUMBER = 8;
    public static final int IFV_FIELD_NUMBER = 1;
    public static final int INPUTLANGUAGE_FIELD_NUMBER = 3;
    public static final int JAILBREAK_FIELD_NUMBER = 17;
    public static final int LASTBOOTUP_FIELD_NUMBER = 18;
    public static final int RINGMUTE_FIELD_NUMBER = 6;
    public static final int SCREENBRIGHT_FIELD_NUMBER = 16;
    public static final int TIMEZONE_FIELD_NUMBER = 29;
    public static final int TIME_FIELD_NUMBER = 15;
    public static final int TOTALDISK_FIELD_NUMBER = 5;
    public static final int TOTALMEM_FIELD_NUMBER = 21;
    private static final long serialVersionUID = 0;
    private volatile Object access_;
    private boolean airplane_;
    private int apilevel_;
    private int atts_;
    private com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext_;
    private float batterylevel_;
    private boolean batterysaver_;
    private volatile Object bmIfv_;
    private boolean charging_;
    private com.explorestack.protobuf.adcom.Context.Device.Connection connection_;
    private volatile Object cpuname_;
    private volatile Object cpuvendor_;
    private boolean darkmode_;
    private volatile Object devicename_;
    private long diskspace_;
    private boolean dnd_;
    private long freemem_;
    private volatile Object gpuname_;
    private volatile Object gpuvendor_;
    private boolean headset_;
    private volatile Object headsetname_;
    private volatile Object ifv_;
    private LazyStringList inputlanguage_;
    private boolean jailbreak_;
    private long lastbootup_;
    private byte memoizedIsInitialized;
    private boolean ringmute_;
    private float screenbright_;
    private long time_;
    private volatile Object timezone_;
    private long totaldisk_;
    private long totalmem_;
    private static final Device DEFAULT_INSTANCE = new Device();
    private static final Parser<Device> PARSER = new AbstractParser<Device>() { // from class: io.bidmachine.protobuf.sdk.Device.1
        @Override // com.explorestack.protobuf.Parser
        public Device parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Device(codedInputStream, extensionRegistryLite);
        }
    };

    private Device(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Device() {
        this.memoizedIsInitialized = (byte) -1;
        this.ifv_ = "";
        this.bmIfv_ = "";
        this.inputlanguage_ = LazyStringArrayList.EMPTY;
        this.devicename_ = "";
        this.access_ = "";
        this.headsetname_ = "";
        this.cpuname_ = "";
        this.cpuvendor_ = "";
        this.gpuname_ = "";
        this.gpuvendor_ = "";
        this.timezone_ = "";
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Device();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Device(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.ifv_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 18:
                                this.bmIfv_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 26:
                                String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                z2 = z2;
                                if (!z2) {
                                    this.inputlanguage_ = new LazyStringArrayList();
                                    z2 = true;
                                }
                                this.inputlanguage_.add(stringRequireUtf8);
                                continue;
                            case 32:
                                this.diskspace_ = codedInputStream.readUInt64();
                                continue;
                            case 40:
                                this.totaldisk_ = codedInputStream.readUInt64();
                                continue;
                            case 48:
                                this.ringmute_ = codedInputStream.readBool();
                                continue;
                            case 56:
                                this.charging_ = codedInputStream.readBool();
                                continue;
                            case 64:
                                this.headset_ = codedInputStream.readBool();
                                continue;
                            case 77:
                                this.batterylevel_ = codedInputStream.readFloat();
                                continue;
                            case 80:
                                this.batterysaver_ = codedInputStream.readBool();
                                continue;
                            case 88:
                                this.darkmode_ = codedInputStream.readBool();
                                continue;
                            case 96:
                                this.airplane_ = codedInputStream.readBool();
                                continue;
                            case 104:
                                this.dnd_ = codedInputStream.readBool();
                                continue;
                            case 114:
                                this.devicename_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 120:
                                this.time_ = codedInputStream.readUInt64();
                                continue;
                            case OMSDK_JS_WRITE_FAILED_VALUE:
                                this.screenbright_ = codedInputStream.readFloat();
                                continue;
                            case 136:
                                this.jailbreak_ = codedInputStream.readBool();
                                continue;
                            case 144:
                                this.lastbootup_ = codedInputStream.readUInt64();
                                continue;
                            case 154:
                                this.access_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 162:
                                this.headsetname_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 168:
                                this.totalmem_ = codedInputStream.readUInt64();
                                continue;
                            case 176:
                                this.atts_ = codedInputStream.readUInt32();
                                continue;
                            case 186:
                                com.explorestack.protobuf.adcom.Context.Device.Connection connection = this.connection_;
                                com.explorestack.protobuf.adcom.Context.Device.Connection.Builder builder = connection != null ? connection.toBuilder() : null;
                                com.explorestack.protobuf.adcom.Context.Device.Connection connection2 = (com.explorestack.protobuf.adcom.Context.Device.Connection) codedInputStream.readMessage(com.explorestack.protobuf.adcom.Context.Device.Connection.parser(), extensionRegistryLite);
                                this.connection_ = connection2;
                                if (builder != null) {
                                    builder.mergeFrom(connection2);
                                    this.connection_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                                break;
                            case 194:
                                com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext = this.audioContext_;
                                com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder builder2 = audioContext != null ? audioContext.toBuilder() : null;
                                com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext2 = (com.explorestack.protobuf.adcom.Context.Device.AudioContext) codedInputStream.readMessage(com.explorestack.protobuf.adcom.Context.Device.AudioContext.parser(), extensionRegistryLite);
                                this.audioContext_ = audioContext2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(audioContext2);
                                    this.audioContext_ = builder2.buildPartial();
                                } else {
                                    continue;
                                }
                                break;
                            case 202:
                                this.cpuname_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 210:
                                this.cpuvendor_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case MRAID_JS_DOES_NOT_EXIST_VALUE:
                                this.gpuname_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 226:
                                this.gpuvendor_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 234:
                                this.timezone_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 240:
                                this.freemem_ = codedInputStream.readUInt64();
                                continue;
                            case 248:
                                this.apilevel_ = codedInputStream.readUInt32();
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
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z2) {
                    this.inputlanguage_ = this.inputlanguage_.getUnmodifiableView();
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2) {
            this.inputlanguage_ = this.inputlanguage_.getUnmodifiableView();
        }
        this.unknownFields = builderNewBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_Device_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_Device_fieldAccessorTable.ensureFieldAccessorsInitialized(Device.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getIfv() {
        Object obj = this.ifv_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.ifv_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getIfvBytes() {
        Object obj = this.ifv_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ifv_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getBmIfv() {
        Object obj = this.bmIfv_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bmIfv_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getBmIfvBytes() {
        Object obj = this.bmIfv_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bmIfv_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ProtocolStringList getInputlanguageList() {
        return this.inputlanguage_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public int getInputlanguageCount() {
        return this.inputlanguage_.size();
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getInputlanguage(int i) {
        return (String) this.inputlanguage_.get(i);
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getInputlanguageBytes(int i) {
        return this.inputlanguage_.getByteString(i);
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getDiskspace() {
        return this.diskspace_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getTotaldisk() {
        return this.totaldisk_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getRingmute() {
        return this.ringmute_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getCharging() {
        return this.charging_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getHeadset() {
        return this.headset_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public float getBatterylevel() {
        return this.batterylevel_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getBatterysaver() {
        return this.batterysaver_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getDarkmode() {
        return this.darkmode_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getAirplane() {
        return this.airplane_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getDnd() {
        return this.dnd_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getDevicename() {
        Object obj = this.devicename_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.devicename_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getDevicenameBytes() {
        Object obj = this.devicename_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.devicename_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getTime() {
        return this.time_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public float getScreenbright() {
        return this.screenbright_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean getJailbreak() {
        return this.jailbreak_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getLastbootup() {
        return this.lastbootup_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getAccess() {
        Object obj = this.access_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.access_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getAccessBytes() {
        Object obj = this.access_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.access_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getHeadsetname() {
        Object obj = this.headsetname_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.headsetname_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getHeadsetnameBytes() {
        Object obj = this.headsetname_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.headsetname_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getTotalmem() {
        return this.totalmem_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public int getAtts() {
        return this.atts_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getCpuname() {
        Object obj = this.cpuname_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.cpuname_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getCpunameBytes() {
        Object obj = this.cpuname_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cpuname_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getCpuvendor() {
        Object obj = this.cpuvendor_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.cpuvendor_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getCpuvendorBytes() {
        Object obj = this.cpuvendor_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cpuvendor_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getGpuname() {
        Object obj = this.gpuname_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.gpuname_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getGpunameBytes() {
        Object obj = this.gpuname_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.gpuname_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getGpuvendor() {
        Object obj = this.gpuvendor_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.gpuvendor_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getGpuvendorBytes() {
        Object obj = this.gpuvendor_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.gpuvendor_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public String getTimezone() {
        Object obj = this.timezone_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.timezone_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public ByteString getTimezoneBytes() {
        Object obj = this.timezone_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.timezone_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public long getFreemem() {
        return this.freemem_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public int getApilevel() {
        return this.apilevel_;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean hasConnection() {
        return this.connection_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public com.explorestack.protobuf.adcom.Context.Device.Connection getConnection() {
        com.explorestack.protobuf.adcom.Context.Device.Connection connection = this.connection_;
        return connection == null ? com.explorestack.protobuf.adcom.Context.Device.Connection.getDefaultInstance() : connection;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder getConnectionOrBuilder() {
        return getConnection();
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public boolean hasAudioContext() {
        return this.audioContext_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public com.explorestack.protobuf.adcom.Context.Device.AudioContext getAudioContext() {
        com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext = this.audioContext_;
        return audioContext == null ? com.explorestack.protobuf.adcom.Context.Device.AudioContext.getDefaultInstance() : audioContext;
    }

    @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
    public com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder getAudioContextOrBuilder() {
        return getAudioContext();
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
        if (!getIfvBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.ifv_);
        }
        if (!getBmIfvBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.bmIfv_);
        }
        for (int i = 0; i < this.inputlanguage_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.inputlanguage_.getRaw(i));
        }
        long j = this.diskspace_;
        if (j != 0) {
            codedOutputStream.writeUInt64(4, j);
        }
        long j2 = this.totaldisk_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(5, j2);
        }
        boolean z = this.ringmute_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        boolean z2 = this.charging_;
        if (z2) {
            codedOutputStream.writeBool(7, z2);
        }
        boolean z3 = this.headset_;
        if (z3) {
            codedOutputStream.writeBool(8, z3);
        }
        float f = this.batterylevel_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(9, f);
        }
        boolean z4 = this.batterysaver_;
        if (z4) {
            codedOutputStream.writeBool(10, z4);
        }
        boolean z5 = this.darkmode_;
        if (z5) {
            codedOutputStream.writeBool(11, z5);
        }
        boolean z6 = this.airplane_;
        if (z6) {
            codedOutputStream.writeBool(12, z6);
        }
        boolean z7 = this.dnd_;
        if (z7) {
            codedOutputStream.writeBool(13, z7);
        }
        if (!getDevicenameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.devicename_);
        }
        long j3 = this.time_;
        if (j3 != 0) {
            codedOutputStream.writeUInt64(15, j3);
        }
        float f2 = this.screenbright_;
        if (f2 != 0.0f) {
            codedOutputStream.writeFloat(16, f2);
        }
        boolean z8 = this.jailbreak_;
        if (z8) {
            codedOutputStream.writeBool(17, z8);
        }
        long j4 = this.lastbootup_;
        if (j4 != 0) {
            codedOutputStream.writeUInt64(18, j4);
        }
        if (!getAccessBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 19, this.access_);
        }
        if (!getHeadsetnameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 20, this.headsetname_);
        }
        long j5 = this.totalmem_;
        if (j5 != 0) {
            codedOutputStream.writeUInt64(21, j5);
        }
        int i2 = this.atts_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(22, i2);
        }
        if (this.connection_ != null) {
            codedOutputStream.writeMessage(23, getConnection());
        }
        if (this.audioContext_ != null) {
            codedOutputStream.writeMessage(24, getAudioContext());
        }
        if (!getCpunameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 25, this.cpuname_);
        }
        if (!getCpuvendorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 26, this.cpuvendor_);
        }
        if (!getGpunameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 27, this.gpuname_);
        }
        if (!getGpuvendorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 28, this.gpuvendor_);
        }
        if (!getTimezoneBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 29, this.timezone_);
        }
        long j6 = this.freemem_;
        if (j6 != 0) {
            codedOutputStream.writeUInt64(30, j6);
        }
        int i3 = this.apilevel_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(31, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !getIfvBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.ifv_) : 0;
        if (!getBmIfvBytes().isEmpty()) {
            iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.bmIfv_);
        }
        int iComputeStringSizeNoTag = 0;
        for (int i2 = 0; i2 < this.inputlanguage_.size(); i2++) {
            iComputeStringSizeNoTag += computeStringSizeNoTag(this.inputlanguage_.getRaw(i2));
        }
        int size = iComputeStringSize + iComputeStringSizeNoTag + getInputlanguageList().size();
        long j = this.diskspace_;
        if (j != 0) {
            size += CodedOutputStream.computeUInt64Size(4, j);
        }
        long j2 = this.totaldisk_;
        if (j2 != 0) {
            size += CodedOutputStream.computeUInt64Size(5, j2);
        }
        boolean z = this.ringmute_;
        if (z) {
            size += CodedOutputStream.computeBoolSize(6, z);
        }
        boolean z2 = this.charging_;
        if (z2) {
            size += CodedOutputStream.computeBoolSize(7, z2);
        }
        boolean z3 = this.headset_;
        if (z3) {
            size += CodedOutputStream.computeBoolSize(8, z3);
        }
        float f = this.batterylevel_;
        if (f != 0.0f) {
            size += CodedOutputStream.computeFloatSize(9, f);
        }
        boolean z4 = this.batterysaver_;
        if (z4) {
            size += CodedOutputStream.computeBoolSize(10, z4);
        }
        boolean z5 = this.darkmode_;
        if (z5) {
            size += CodedOutputStream.computeBoolSize(11, z5);
        }
        boolean z6 = this.airplane_;
        if (z6) {
            size += CodedOutputStream.computeBoolSize(12, z6);
        }
        boolean z7 = this.dnd_;
        if (z7) {
            size += CodedOutputStream.computeBoolSize(13, z7);
        }
        if (!getDevicenameBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(14, this.devicename_);
        }
        long j3 = this.time_;
        if (j3 != 0) {
            size += CodedOutputStream.computeUInt64Size(15, j3);
        }
        float f2 = this.screenbright_;
        if (f2 != 0.0f) {
            size += CodedOutputStream.computeFloatSize(16, f2);
        }
        boolean z8 = this.jailbreak_;
        if (z8) {
            size += CodedOutputStream.computeBoolSize(17, z8);
        }
        long j4 = this.lastbootup_;
        if (j4 != 0) {
            size += CodedOutputStream.computeUInt64Size(18, j4);
        }
        if (!getAccessBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(19, this.access_);
        }
        if (!getHeadsetnameBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(20, this.headsetname_);
        }
        long j5 = this.totalmem_;
        if (j5 != 0) {
            size += CodedOutputStream.computeUInt64Size(21, j5);
        }
        int i3 = this.atts_;
        if (i3 != 0) {
            size += CodedOutputStream.computeUInt32Size(22, i3);
        }
        if (this.connection_ != null) {
            size += CodedOutputStream.computeMessageSize(23, getConnection());
        }
        if (this.audioContext_ != null) {
            size += CodedOutputStream.computeMessageSize(24, getAudioContext());
        }
        if (!getCpunameBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(25, this.cpuname_);
        }
        if (!getCpuvendorBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(26, this.cpuvendor_);
        }
        if (!getGpunameBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(27, this.gpuname_);
        }
        if (!getGpuvendorBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(28, this.gpuvendor_);
        }
        if (!getTimezoneBytes().isEmpty()) {
            size += GeneratedMessageV3.computeStringSize(29, this.timezone_);
        }
        long j6 = this.freemem_;
        if (j6 != 0) {
            size += CodedOutputStream.computeUInt64Size(30, j6);
        }
        int i4 = this.apilevel_;
        if (i4 != 0) {
            size += CodedOutputStream.computeUInt32Size(31, i4);
        }
        int serializedSize = size + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return super.equals(obj);
        }
        Device device = (Device) obj;
        if (!getIfv().equals(device.getIfv()) || !getBmIfv().equals(device.getBmIfv()) || !getInputlanguageList().equals(device.getInputlanguageList()) || getDiskspace() != device.getDiskspace() || getTotaldisk() != device.getTotaldisk() || getRingmute() != device.getRingmute() || getCharging() != device.getCharging() || getHeadset() != device.getHeadset() || Float.floatToIntBits(getBatterylevel()) != Float.floatToIntBits(device.getBatterylevel()) || getBatterysaver() != device.getBatterysaver() || getDarkmode() != device.getDarkmode() || getAirplane() != device.getAirplane() || getDnd() != device.getDnd() || !getDevicename().equals(device.getDevicename()) || getTime() != device.getTime() || Float.floatToIntBits(getScreenbright()) != Float.floatToIntBits(device.getScreenbright()) || getJailbreak() != device.getJailbreak() || getLastbootup() != device.getLastbootup() || !getAccess().equals(device.getAccess()) || !getHeadsetname().equals(device.getHeadsetname()) || getTotalmem() != device.getTotalmem() || getAtts() != device.getAtts() || !getCpuname().equals(device.getCpuname()) || !getCpuvendor().equals(device.getCpuvendor()) || !getGpuname().equals(device.getGpuname()) || !getGpuvendor().equals(device.getGpuvendor()) || !getTimezone().equals(device.getTimezone()) || getFreemem() != device.getFreemem() || getApilevel() != device.getApilevel() || hasConnection() != device.hasConnection()) {
            return false;
        }
        if ((!hasConnection() || getConnection().equals(device.getConnection())) && hasAudioContext() == device.hasAudioContext()) {
            return (!hasAudioContext() || getAudioContext().equals(device.getAudioContext())) && this.unknownFields.equals(device.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getIfv().hashCode()) * 37) + 2) * 53) + getBmIfv().hashCode();
        if (getInputlanguageCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getInputlanguageList().hashCode();
        }
        int iHashLong = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((iHashCode * 37) + 4) * 53) + Internal.hashLong(getDiskspace())) * 37) + 5) * 53) + Internal.hashLong(getTotaldisk())) * 37) + 6) * 53) + Internal.hashBoolean(getRingmute())) * 37) + 7) * 53) + Internal.hashBoolean(getCharging())) * 37) + 8) * 53) + Internal.hashBoolean(getHeadset())) * 37) + 9) * 53) + Float.floatToIntBits(getBatterylevel())) * 37) + 10) * 53) + Internal.hashBoolean(getBatterysaver())) * 37) + 11) * 53) + Internal.hashBoolean(getDarkmode())) * 37) + 12) * 53) + Internal.hashBoolean(getAirplane())) * 37) + 13) * 53) + Internal.hashBoolean(getDnd())) * 37) + 14) * 53) + getDevicename().hashCode()) * 37) + 15) * 53) + Internal.hashLong(getTime())) * 37) + 16) * 53) + Float.floatToIntBits(getScreenbright())) * 37) + 17) * 53) + Internal.hashBoolean(getJailbreak())) * 37) + 18) * 53) + Internal.hashLong(getLastbootup())) * 37) + 19) * 53) + getAccess().hashCode()) * 37) + 20) * 53) + getHeadsetname().hashCode()) * 37) + 21) * 53) + Internal.hashLong(getTotalmem())) * 37) + 22) * 53) + getAtts()) * 37) + 25) * 53) + getCpuname().hashCode()) * 37) + 26) * 53) + getCpuvendor().hashCode()) * 37) + 27) * 53) + getGpuname().hashCode()) * 37) + 28) * 53) + getGpuvendor().hashCode()) * 37) + 29) * 53) + getTimezone().hashCode()) * 37) + 30) * 53) + Internal.hashLong(getFreemem())) * 37) + 31) * 53) + getApilevel();
        if (hasConnection()) {
            iHashLong = (((iHashLong * 37) + 23) * 53) + getConnection().hashCode();
        }
        if (hasAudioContext()) {
            iHashLong = (((iHashLong * 37) + 24) * 53) + getAudioContext().hashCode();
        }
        int iHashCode2 = (iHashLong * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static Device parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Device parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Device parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Device parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Device parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Device parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Device parseFrom(InputStream inputStream) throws IOException {
        return (Device) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Device parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Device) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Device parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Device) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Device parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Device) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Device parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Device) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Device parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Device) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Device device) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(device);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DeviceOrBuilder {
        private Object access_;
        private boolean airplane_;
        private int apilevel_;
        private int atts_;
        private SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> audioContextBuilder_;
        private com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext_;
        private float batterylevel_;
        private boolean batterysaver_;
        private int bitField0_;
        private Object bmIfv_;
        private boolean charging_;
        private SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> connectionBuilder_;
        private com.explorestack.protobuf.adcom.Context.Device.Connection connection_;
        private Object cpuname_;
        private Object cpuvendor_;
        private boolean darkmode_;
        private Object devicename_;
        private long diskspace_;
        private boolean dnd_;
        private long freemem_;
        private Object gpuname_;
        private Object gpuvendor_;
        private boolean headset_;
        private Object headsetname_;
        private Object ifv_;
        private LazyStringList inputlanguage_;
        private boolean jailbreak_;
        private long lastbootup_;
        private boolean ringmute_;
        private float screenbright_;
        private long time_;
        private Object timezone_;
        private long totaldisk_;
        private long totalmem_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_Device_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_Device_fieldAccessorTable.ensureFieldAccessorsInitialized(Device.class, Builder.class);
        }

        private Builder() {
            this.ifv_ = "";
            this.bmIfv_ = "";
            this.inputlanguage_ = LazyStringArrayList.EMPTY;
            this.devicename_ = "";
            this.access_ = "";
            this.headsetname_ = "";
            this.cpuname_ = "";
            this.cpuvendor_ = "";
            this.gpuname_ = "";
            this.gpuvendor_ = "";
            this.timezone_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.ifv_ = "";
            this.bmIfv_ = "";
            this.inputlanguage_ = LazyStringArrayList.EMPTY;
            this.devicename_ = "";
            this.access_ = "";
            this.headsetname_ = "";
            this.cpuname_ = "";
            this.cpuvendor_ = "";
            this.gpuname_ = "";
            this.gpuvendor_ = "";
            this.timezone_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Device.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.ifv_ = "";
            this.bmIfv_ = "";
            this.inputlanguage_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.diskspace_ = 0L;
            this.totaldisk_ = 0L;
            this.ringmute_ = false;
            this.charging_ = false;
            this.headset_ = false;
            this.batterylevel_ = 0.0f;
            this.batterysaver_ = false;
            this.darkmode_ = false;
            this.airplane_ = false;
            this.dnd_ = false;
            this.devicename_ = "";
            this.time_ = 0L;
            this.screenbright_ = 0.0f;
            this.jailbreak_ = false;
            this.lastbootup_ = 0L;
            this.access_ = "";
            this.headsetname_ = "";
            this.totalmem_ = 0L;
            this.atts_ = 0;
            this.cpuname_ = "";
            this.cpuvendor_ = "";
            this.gpuname_ = "";
            this.gpuvendor_ = "";
            this.timezone_ = "";
            this.freemem_ = 0L;
            this.apilevel_ = 0;
            if (this.connectionBuilder_ == null) {
                this.connection_ = null;
            } else {
                this.connection_ = null;
                this.connectionBuilder_ = null;
            }
            if (this.audioContextBuilder_ == null) {
                this.audioContext_ = null;
            } else {
                this.audioContext_ = null;
                this.audioContextBuilder_ = null;
            }
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_Device_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Device getDefaultInstanceForType() {
            return Device.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Device build() {
            Device deviceBuildPartial = buildPartial();
            if (deviceBuildPartial.isInitialized()) {
                return deviceBuildPartial;
            }
            throw newUninitializedMessageException((Message) deviceBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Device buildPartial() {
            Device device = new Device(this);
            device.ifv_ = this.ifv_;
            device.bmIfv_ = this.bmIfv_;
            if ((this.bitField0_ & 1) != 0) {
                this.inputlanguage_ = this.inputlanguage_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            device.inputlanguage_ = this.inputlanguage_;
            device.diskspace_ = this.diskspace_;
            device.totaldisk_ = this.totaldisk_;
            device.ringmute_ = this.ringmute_;
            device.charging_ = this.charging_;
            device.headset_ = this.headset_;
            device.batterylevel_ = this.batterylevel_;
            device.batterysaver_ = this.batterysaver_;
            device.darkmode_ = this.darkmode_;
            device.airplane_ = this.airplane_;
            device.dnd_ = this.dnd_;
            device.devicename_ = this.devicename_;
            device.time_ = this.time_;
            device.screenbright_ = this.screenbright_;
            device.jailbreak_ = this.jailbreak_;
            device.lastbootup_ = this.lastbootup_;
            device.access_ = this.access_;
            device.headsetname_ = this.headsetname_;
            device.totalmem_ = this.totalmem_;
            device.atts_ = this.atts_;
            device.cpuname_ = this.cpuname_;
            device.cpuvendor_ = this.cpuvendor_;
            device.gpuname_ = this.gpuname_;
            device.gpuvendor_ = this.gpuvendor_;
            device.timezone_ = this.timezone_;
            device.freemem_ = this.freemem_;
            device.apilevel_ = this.apilevel_;
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 == null) {
                device.connection_ = this.connection_;
            } else {
                device.connection_ = (com.explorestack.protobuf.adcom.Context.Device.Connection) singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV4 = this.audioContextBuilder_;
            if (singleFieldBuilderV4 == null) {
                device.audioContext_ = this.audioContext_;
            } else {
                device.audioContext_ = (com.explorestack.protobuf.adcom.Context.Device.AudioContext) singleFieldBuilderV4.build();
            }
            onBuilt();
            return device;
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
            if (message instanceof Device) {
                return mergeFrom((Device) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Device device) {
            if (device == Device.getDefaultInstance()) {
                return this;
            }
            if (!device.getIfv().isEmpty()) {
                this.ifv_ = device.ifv_;
                onChanged();
            }
            if (!device.getBmIfv().isEmpty()) {
                this.bmIfv_ = device.bmIfv_;
                onChanged();
            }
            if (!device.inputlanguage_.isEmpty()) {
                if (this.inputlanguage_.isEmpty()) {
                    this.inputlanguage_ = device.inputlanguage_;
                    this.bitField0_ &= -2;
                } else {
                    ensureInputlanguageIsMutable();
                    this.inputlanguage_.addAll(device.inputlanguage_);
                }
                onChanged();
            }
            if (device.getDiskspace() != 0) {
                setDiskspace(device.getDiskspace());
            }
            if (device.getTotaldisk() != 0) {
                setTotaldisk(device.getTotaldisk());
            }
            if (device.getRingmute()) {
                setRingmute(device.getRingmute());
            }
            if (device.getCharging()) {
                setCharging(device.getCharging());
            }
            if (device.getHeadset()) {
                setHeadset(device.getHeadset());
            }
            if (device.getBatterylevel() != 0.0f) {
                setBatterylevel(device.getBatterylevel());
            }
            if (device.getBatterysaver()) {
                setBatterysaver(device.getBatterysaver());
            }
            if (device.getDarkmode()) {
                setDarkmode(device.getDarkmode());
            }
            if (device.getAirplane()) {
                setAirplane(device.getAirplane());
            }
            if (device.getDnd()) {
                setDnd(device.getDnd());
            }
            if (!device.getDevicename().isEmpty()) {
                this.devicename_ = device.devicename_;
                onChanged();
            }
            if (device.getTime() != 0) {
                setTime(device.getTime());
            }
            if (device.getScreenbright() != 0.0f) {
                setScreenbright(device.getScreenbright());
            }
            if (device.getJailbreak()) {
                setJailbreak(device.getJailbreak());
            }
            if (device.getLastbootup() != 0) {
                setLastbootup(device.getLastbootup());
            }
            if (!device.getAccess().isEmpty()) {
                this.access_ = device.access_;
                onChanged();
            }
            if (!device.getHeadsetname().isEmpty()) {
                this.headsetname_ = device.headsetname_;
                onChanged();
            }
            if (device.getTotalmem() != 0) {
                setTotalmem(device.getTotalmem());
            }
            if (device.getAtts() != 0) {
                setAtts(device.getAtts());
            }
            if (!device.getCpuname().isEmpty()) {
                this.cpuname_ = device.cpuname_;
                onChanged();
            }
            if (!device.getCpuvendor().isEmpty()) {
                this.cpuvendor_ = device.cpuvendor_;
                onChanged();
            }
            if (!device.getGpuname().isEmpty()) {
                this.gpuname_ = device.gpuname_;
                onChanged();
            }
            if (!device.getGpuvendor().isEmpty()) {
                this.gpuvendor_ = device.gpuvendor_;
                onChanged();
            }
            if (!device.getTimezone().isEmpty()) {
                this.timezone_ = device.timezone_;
                onChanged();
            }
            if (device.getFreemem() != 0) {
                setFreemem(device.getFreemem());
            }
            if (device.getApilevel() != 0) {
                setApilevel(device.getApilevel());
            }
            if (device.hasConnection()) {
                mergeConnection(device.getConnection());
            }
            if (device.hasAudioContext()) {
                mergeAudioContext(device.getAudioContext());
            }
            mergeUnknownFields(device.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            Device device = null;
            try {
                try {
                    Device device2 = (Device) Device.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (device2 != null) {
                        mergeFrom(device2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Device device3 = (Device) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        device = device3;
                        if (device != null) {
                            mergeFrom(device);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (device != null) {
                    mergeFrom(device);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getIfv() {
            Object obj = this.ifv_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ifv_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getIfvBytes() {
            Object obj = this.ifv_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ifv_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setIfv(String str) {
            str.getClass();
            this.ifv_ = str;
            onChanged();
            return this;
        }

        public Builder clearIfv() {
            this.ifv_ = Device.getDefaultInstance().getIfv();
            onChanged();
            return this;
        }

        public Builder setIfvBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.ifv_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getBmIfv() {
            Object obj = this.bmIfv_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bmIfv_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getBmIfvBytes() {
            Object obj = this.bmIfv_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bmIfv_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setBmIfv(String str) {
            str.getClass();
            this.bmIfv_ = str;
            onChanged();
            return this;
        }

        public Builder clearBmIfv() {
            this.bmIfv_ = Device.getDefaultInstance().getBmIfv();
            onChanged();
            return this;
        }

        public Builder setBmIfvBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.bmIfv_ = byteString;
            onChanged();
            return this;
        }

        private void ensureInputlanguageIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.inputlanguage_ = new LazyStringArrayList(this.inputlanguage_);
                this.bitField0_ |= 1;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ProtocolStringList getInputlanguageList() {
            return this.inputlanguage_.getUnmodifiableView();
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public int getInputlanguageCount() {
            return this.inputlanguage_.size();
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getInputlanguage(int i) {
            return (String) this.inputlanguage_.get(i);
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getInputlanguageBytes(int i) {
            return this.inputlanguage_.getByteString(i);
        }

        public Builder setInputlanguage(int i, String str) {
            str.getClass();
            ensureInputlanguageIsMutable();
            this.inputlanguage_.set(i, str);
            onChanged();
            return this;
        }

        public Builder addInputlanguage(String str) {
            str.getClass();
            ensureInputlanguageIsMutable();
            this.inputlanguage_.add(str);
            onChanged();
            return this;
        }

        public Builder addAllInputlanguage(Iterable<String> iterable) {
            ensureInputlanguageIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.inputlanguage_);
            onChanged();
            return this;
        }

        public Builder clearInputlanguage() {
            this.inputlanguage_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder addInputlanguageBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            ensureInputlanguageIsMutable();
            this.inputlanguage_.add(byteString);
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getDiskspace() {
            return this.diskspace_;
        }

        public Builder setDiskspace(long j) {
            this.diskspace_ = j;
            onChanged();
            return this;
        }

        public Builder clearDiskspace() {
            this.diskspace_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getTotaldisk() {
            return this.totaldisk_;
        }

        public Builder setTotaldisk(long j) {
            this.totaldisk_ = j;
            onChanged();
            return this;
        }

        public Builder clearTotaldisk() {
            this.totaldisk_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getRingmute() {
            return this.ringmute_;
        }

        public Builder setRingmute(boolean z) {
            this.ringmute_ = z;
            onChanged();
            return this;
        }

        public Builder clearRingmute() {
            this.ringmute_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getCharging() {
            return this.charging_;
        }

        public Builder setCharging(boolean z) {
            this.charging_ = z;
            onChanged();
            return this;
        }

        public Builder clearCharging() {
            this.charging_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getHeadset() {
            return this.headset_;
        }

        public Builder setHeadset(boolean z) {
            this.headset_ = z;
            onChanged();
            return this;
        }

        public Builder clearHeadset() {
            this.headset_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public float getBatterylevel() {
            return this.batterylevel_;
        }

        public Builder setBatterylevel(float f) {
            this.batterylevel_ = f;
            onChanged();
            return this;
        }

        public Builder clearBatterylevel() {
            this.batterylevel_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getBatterysaver() {
            return this.batterysaver_;
        }

        public Builder setBatterysaver(boolean z) {
            this.batterysaver_ = z;
            onChanged();
            return this;
        }

        public Builder clearBatterysaver() {
            this.batterysaver_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getDarkmode() {
            return this.darkmode_;
        }

        public Builder setDarkmode(boolean z) {
            this.darkmode_ = z;
            onChanged();
            return this;
        }

        public Builder clearDarkmode() {
            this.darkmode_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getAirplane() {
            return this.airplane_;
        }

        public Builder setAirplane(boolean z) {
            this.airplane_ = z;
            onChanged();
            return this;
        }

        public Builder clearAirplane() {
            this.airplane_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getDnd() {
            return this.dnd_;
        }

        public Builder setDnd(boolean z) {
            this.dnd_ = z;
            onChanged();
            return this;
        }

        public Builder clearDnd() {
            this.dnd_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getDevicename() {
            Object obj = this.devicename_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.devicename_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getDevicenameBytes() {
            Object obj = this.devicename_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.devicename_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setDevicename(String str) {
            str.getClass();
            this.devicename_ = str;
            onChanged();
            return this;
        }

        public Builder clearDevicename() {
            this.devicename_ = Device.getDefaultInstance().getDevicename();
            onChanged();
            return this;
        }

        public Builder setDevicenameBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.devicename_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getTime() {
            return this.time_;
        }

        public Builder setTime(long j) {
            this.time_ = j;
            onChanged();
            return this;
        }

        public Builder clearTime() {
            this.time_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public float getScreenbright() {
            return this.screenbright_;
        }

        public Builder setScreenbright(float f) {
            this.screenbright_ = f;
            onChanged();
            return this;
        }

        public Builder clearScreenbright() {
            this.screenbright_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean getJailbreak() {
            return this.jailbreak_;
        }

        public Builder setJailbreak(boolean z) {
            this.jailbreak_ = z;
            onChanged();
            return this;
        }

        public Builder clearJailbreak() {
            this.jailbreak_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getLastbootup() {
            return this.lastbootup_;
        }

        public Builder setLastbootup(long j) {
            this.lastbootup_ = j;
            onChanged();
            return this;
        }

        public Builder clearLastbootup() {
            this.lastbootup_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getAccess() {
            Object obj = this.access_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.access_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getAccessBytes() {
            Object obj = this.access_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.access_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setAccess(String str) {
            str.getClass();
            this.access_ = str;
            onChanged();
            return this;
        }

        public Builder clearAccess() {
            this.access_ = Device.getDefaultInstance().getAccess();
            onChanged();
            return this;
        }

        public Builder setAccessBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.access_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getHeadsetname() {
            Object obj = this.headsetname_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.headsetname_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getHeadsetnameBytes() {
            Object obj = this.headsetname_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.headsetname_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setHeadsetname(String str) {
            str.getClass();
            this.headsetname_ = str;
            onChanged();
            return this;
        }

        public Builder clearHeadsetname() {
            this.headsetname_ = Device.getDefaultInstance().getHeadsetname();
            onChanged();
            return this;
        }

        public Builder setHeadsetnameBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.headsetname_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getTotalmem() {
            return this.totalmem_;
        }

        public Builder setTotalmem(long j) {
            this.totalmem_ = j;
            onChanged();
            return this;
        }

        public Builder clearTotalmem() {
            this.totalmem_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public int getAtts() {
            return this.atts_;
        }

        public Builder setAtts(int i) {
            this.atts_ = i;
            onChanged();
            return this;
        }

        public Builder clearAtts() {
            this.atts_ = 0;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getCpuname() {
            Object obj = this.cpuname_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cpuname_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getCpunameBytes() {
            Object obj = this.cpuname_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cpuname_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCpuname(String str) {
            str.getClass();
            this.cpuname_ = str;
            onChanged();
            return this;
        }

        public Builder clearCpuname() {
            this.cpuname_ = Device.getDefaultInstance().getCpuname();
            onChanged();
            return this;
        }

        public Builder setCpunameBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.cpuname_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getCpuvendor() {
            Object obj = this.cpuvendor_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cpuvendor_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getCpuvendorBytes() {
            Object obj = this.cpuvendor_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cpuvendor_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCpuvendor(String str) {
            str.getClass();
            this.cpuvendor_ = str;
            onChanged();
            return this;
        }

        public Builder clearCpuvendor() {
            this.cpuvendor_ = Device.getDefaultInstance().getCpuvendor();
            onChanged();
            return this;
        }

        public Builder setCpuvendorBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.cpuvendor_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getGpuname() {
            Object obj = this.gpuname_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.gpuname_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getGpunameBytes() {
            Object obj = this.gpuname_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gpuname_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setGpuname(String str) {
            str.getClass();
            this.gpuname_ = str;
            onChanged();
            return this;
        }

        public Builder clearGpuname() {
            this.gpuname_ = Device.getDefaultInstance().getGpuname();
            onChanged();
            return this;
        }

        public Builder setGpunameBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.gpuname_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getGpuvendor() {
            Object obj = this.gpuvendor_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.gpuvendor_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getGpuvendorBytes() {
            Object obj = this.gpuvendor_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gpuvendor_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setGpuvendor(String str) {
            str.getClass();
            this.gpuvendor_ = str;
            onChanged();
            return this;
        }

        public Builder clearGpuvendor() {
            this.gpuvendor_ = Device.getDefaultInstance().getGpuvendor();
            onChanged();
            return this;
        }

        public Builder setGpuvendorBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.gpuvendor_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public String getTimezone() {
            Object obj = this.timezone_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.timezone_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public ByteString getTimezoneBytes() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timezone_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTimezone(String str) {
            str.getClass();
            this.timezone_ = str;
            onChanged();
            return this;
        }

        public Builder clearTimezone() {
            this.timezone_ = Device.getDefaultInstance().getTimezone();
            onChanged();
            return this;
        }

        public Builder setTimezoneBytes(ByteString byteString) {
            byteString.getClass();
            Device.checkByteStringIsUtf8(byteString);
            this.timezone_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public long getFreemem() {
            return this.freemem_;
        }

        public Builder setFreemem(long j) {
            this.freemem_ = j;
            onChanged();
            return this;
        }

        public Builder clearFreemem() {
            this.freemem_ = 0L;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public int getApilevel() {
            return this.apilevel_;
        }

        public Builder setApilevel(int i) {
            this.apilevel_ = i;
            onChanged();
            return this;
        }

        public Builder clearApilevel() {
            this.apilevel_ = 0;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean hasConnection() {
            return (this.connectionBuilder_ == null && this.connection_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public com.explorestack.protobuf.adcom.Context.Device.Connection getConnection() {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.explorestack.protobuf.adcom.Context.Device.Connection connection = this.connection_;
                return connection == null ? com.explorestack.protobuf.adcom.Context.Device.Connection.getDefaultInstance() : connection;
            }
            return (com.explorestack.protobuf.adcom.Context.Device.Connection) singleFieldBuilderV3.getMessage();
        }

        public Builder setConnection(com.explorestack.protobuf.adcom.Context.Device.Connection connection) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 == null) {
                connection.getClass();
                this.connection_ = connection;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(connection);
            }
            return this;
        }

        public Builder setConnection(com.explorestack.protobuf.adcom.Context.Device.Connection.Builder builder) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.connection_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeConnection(com.explorestack.protobuf.adcom.Context.Device.Connection connection) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.explorestack.protobuf.adcom.Context.Device.Connection connection2 = this.connection_;
                if (connection2 != null) {
                    this.connection_ = com.explorestack.protobuf.adcom.Context.Device.Connection.newBuilder(connection2).mergeFrom(connection).buildPartial();
                } else {
                    this.connection_ = connection;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(connection);
            }
            return this;
        }

        public Builder clearConnection() {
            if (this.connectionBuilder_ == null) {
                this.connection_ = null;
                onChanged();
            } else {
                this.connection_ = null;
                this.connectionBuilder_ = null;
            }
            return this;
        }

        public com.explorestack.protobuf.adcom.Context.Device.Connection.Builder getConnectionBuilder() {
            onChanged();
            return (com.explorestack.protobuf.adcom.Context.Device.Connection.Builder) getConnectionFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder getConnectionOrBuilder() {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> singleFieldBuilderV3 = this.connectionBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            com.explorestack.protobuf.adcom.Context.Device.Connection connection = this.connection_;
            return connection == null ? com.explorestack.protobuf.adcom.Context.Device.Connection.getDefaultInstance() : connection;
        }

        private SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.Connection, com.explorestack.protobuf.adcom.Context.Device.Connection.Builder, com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder> getConnectionFieldBuilder() {
            if (this.connectionBuilder_ == null) {
                this.connectionBuilder_ = new SingleFieldBuilderV3<>(getConnection(), getParentForChildren(), isClean());
                this.connection_ = null;
            }
            return this.connectionBuilder_;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public boolean hasAudioContext() {
            return (this.audioContextBuilder_ == null && this.audioContext_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public com.explorestack.protobuf.adcom.Context.Device.AudioContext getAudioContext() {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV3 = this.audioContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext = this.audioContext_;
                return audioContext == null ? com.explorestack.protobuf.adcom.Context.Device.AudioContext.getDefaultInstance() : audioContext;
            }
            return (com.explorestack.protobuf.adcom.Context.Device.AudioContext) singleFieldBuilderV3.getMessage();
        }

        public Builder setAudioContext(com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV3 = this.audioContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                audioContext.getClass();
                this.audioContext_ = audioContext;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(audioContext);
            }
            return this;
        }

        public Builder setAudioContext(com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder builder) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV3 = this.audioContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.audioContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeAudioContext(com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext) {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV3 = this.audioContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext2 = this.audioContext_;
                if (audioContext2 != null) {
                    this.audioContext_ = com.explorestack.protobuf.adcom.Context.Device.AudioContext.newBuilder(audioContext2).mergeFrom(audioContext).buildPartial();
                } else {
                    this.audioContext_ = audioContext;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(audioContext);
            }
            return this;
        }

        public Builder clearAudioContext() {
            if (this.audioContextBuilder_ == null) {
                this.audioContext_ = null;
                onChanged();
            } else {
                this.audioContext_ = null;
                this.audioContextBuilder_ = null;
            }
            return this;
        }

        public com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder getAudioContextBuilder() {
            onChanged();
            return (com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder) getAudioContextFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.DeviceOrBuilder
        public com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder getAudioContextOrBuilder() {
            SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> singleFieldBuilderV3 = this.audioContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            com.explorestack.protobuf.adcom.Context.Device.AudioContext audioContext = this.audioContext_;
            return audioContext == null ? com.explorestack.protobuf.adcom.Context.Device.AudioContext.getDefaultInstance() : audioContext;
        }

        private SingleFieldBuilderV3<com.explorestack.protobuf.adcom.Context.Device.AudioContext, com.explorestack.protobuf.adcom.Context.Device.AudioContext.Builder, com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder> getAudioContextFieldBuilder() {
            if (this.audioContextBuilder_ == null) {
                this.audioContextBuilder_ = new SingleFieldBuilderV3<>(getAudioContext(), getParentForChildren(), isClean());
                this.audioContext_ = null;
            }
            return this.audioContextBuilder_;
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

    public static Device getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Device> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Device> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Device getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
