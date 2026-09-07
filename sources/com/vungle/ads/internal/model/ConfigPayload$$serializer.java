package com.vungle.ads.internal.model;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.sp;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ConfigPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/ConfigPayload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ConfigPayload$$serializer implements GeneratedSerializer<ConfigPayload> {
    public static final ConfigPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ConfigPayload$$serializer configPayload$$serializer = new ConfigPayload$$serializer();
        INSTANCE = configPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload", configPayload$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("reuse_assets", true);
        pluginGeneratedSerialDescriptor.addElement(DTBMetricsConfiguration.CONFIG_DIR, true);
        pluginGeneratedSerialDescriptor.addElement("endpoints", true);
        pluginGeneratedSerialDescriptor.addElement("log_metrics", true);
        pluginGeneratedSerialDescriptor.addElement(sp.c, true);
        pluginGeneratedSerialDescriptor.addElement(POBConstants.KEY_USER, true);
        pluginGeneratedSerialDescriptor.addElement("viewability", true);
        pluginGeneratedSerialDescriptor.addElement(Cookie.CONFIG_EXTENSION, true);
        pluginGeneratedSerialDescriptor.addElement(Cookie.COPPA_DISABLE_AD_ID, true);
        pluginGeneratedSerialDescriptor.addElement("ri_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("session_timeout", true);
        pluginGeneratedSerialDescriptor.addElement("wait_for_connectivity_for_tpat", true);
        pluginGeneratedSerialDescriptor.addElement("sdk_session_timeout", true);
        pluginGeneratedSerialDescriptor.addElement("cacheable_assets_required", true);
        pluginGeneratedSerialDescriptor.addElement("signals_disabled", true);
        pluginGeneratedSerialDescriptor.addElement("fpd_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("rta_debugging", true);
        pluginGeneratedSerialDescriptor.addElement("config_last_validated_ts", true);
        pluginGeneratedSerialDescriptor.addElement("auto_redirect", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ConfigPayload$CleverCache$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$ConfigSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$Endpoints$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$LogMetricsSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(Placement$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(ConfigPayload$UserPrivacy$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$AutoRedirect$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConfigPayload deserialize(Decoder decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object obj;
        Object obj2;
        Object objDecodeNullableSerializableElement3;
        int i;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        Object objDecodeNullableSerializableElement10;
        Object objDecodeNullableSerializableElement11;
        Object objDecodeNullableSerializableElement12;
        Object objDecodeNullableSerializableElement13;
        Object objDecodeNullableSerializableElement14;
        Object objDecodeNullableSerializableElement15;
        Object objDecodeNullableSerializableElement16;
        Object objDecodeNullableSerializableElement17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Object objDecodeNullableSerializableElement18 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement19 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement20 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new ArrayListSerializer(Placement$$serializer.INSTANCE), null);
            objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement15 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement14 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement13 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement17 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement16 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, IntSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement20;
            i = 524287;
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, LongSerializer.INSTANCE, null);
            obj = objDecodeNullableSerializableElement18;
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, ConfigPayload$AutoRedirect$$serializer.INSTANCE, null);
            obj2 = objDecodeNullableSerializableElement19;
        } else {
            boolean z = true;
            Object objDecodeNullableSerializableElement21 = null;
            Object objDecodeNullableSerializableElement22 = null;
            Object objDecodeNullableSerializableElement23 = null;
            Object objDecodeNullableSerializableElement24 = null;
            Object objDecodeNullableSerializableElement25 = null;
            Object objDecodeNullableSerializableElement26 = null;
            Object objDecodeNullableSerializableElement27 = null;
            Object objDecodeNullableSerializableElement28 = null;
            Object objDecodeNullableSerializableElement29 = null;
            Object objDecodeNullableSerializableElement30 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement31 = null;
            Object objDecodeNullableSerializableElement32 = null;
            Object objDecodeNullableSerializableElement33 = null;
            Object objDecodeNullableSerializableElement34 = null;
            Object objDecodeNullableSerializableElement35 = null;
            Object objDecodeNullableSerializableElement36 = null;
            Object objDecodeNullableSerializableElement37 = null;
            int i2 = 0;
            Object objDecodeNullableSerializableElement38 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement21 = objDecodeNullableSerializableElement21;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 0:
                        objDecodeNullableSerializableElement37 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, objDecodeNullableSerializableElement37);
                        i2 |= 1;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement21 = objDecodeNullableSerializableElement21;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 1:
                        objDecodeNullableSerializableElement38 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, objDecodeNullableSerializableElement38);
                        i2 |= 2;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement21 = objDecodeNullableSerializableElement21;
                        break;
                    case 2:
                        objDecodeNullableSerializableElement24 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, objDecodeNullableSerializableElement24);
                        i2 |= 4;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 3:
                        objDecodeNullableSerializableElement23 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, objDecodeNullableSerializableElement23);
                        i2 |= 8;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 4:
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new ArrayListSerializer(Placement$$serializer.INSTANCE), objDecodeNullableSerializableElement);
                        i2 |= 16;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 5:
                        objDecodeNullableSerializableElement21 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, objDecodeNullableSerializableElement21);
                        i2 |= 32;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 6:
                        objDecodeNullableSerializableElement30 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE, objDecodeNullableSerializableElement30);
                        i2 |= 64;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 7:
                        objDecodeNullableSerializableElement29 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, objDecodeNullableSerializableElement29);
                        i2 |= 128;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 8:
                        objDecodeNullableSerializableElement28 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement28);
                        i2 |= 256;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 9:
                        objDecodeNullableSerializableElement22 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement22);
                        i2 |= 512;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 10:
                        objDecodeNullableSerializableElement27 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, objDecodeNullableSerializableElement27);
                        i2 |= 1024;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 11:
                        objDecodeNullableSerializableElement26 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement26);
                        i2 |= 2048;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 12:
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement31 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, IntSerializer.INSTANCE, objDecodeNullableSerializableElement31);
                        i2 |= 4096;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement32 = objDecodeNullableSerializableElement32;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 13:
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement32 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement32);
                        i2 |= 8192;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement33 = objDecodeNullableSerializableElement33;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 14:
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement33 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement33);
                        i2 |= 16384;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement34 = objDecodeNullableSerializableElement34;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 15:
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement34 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement34);
                        i2 |= 32768;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement35 = objDecodeNullableSerializableElement35;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 16:
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement35 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement35);
                        i2 |= 65536;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement36 = objDecodeNullableSerializableElement36;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 17:
                        objDecodeNullableSerializableElement36 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, LongSerializer.INSTANCE, objDecodeNullableSerializableElement36);
                        i2 |= 131072;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    case 18:
                        objDecodeNullableSerializableElement25 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, ConfigPayload$AutoRedirect$$serializer.INSTANCE, objDecodeNullableSerializableElement25);
                        i2 |= 262144;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Object obj3 = objDecodeNullableSerializableElement38;
            Object obj4 = objDecodeNullableSerializableElement21;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement25;
            obj = objDecodeNullableSerializableElement37;
            obj2 = objDecodeNullableSerializableElement23;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement24;
            i = i2;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement36;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement35;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement34;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement33;
            objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement32;
            objDecodeNullableSerializableElement9 = obj3;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement31;
            objDecodeNullableSerializableElement11 = obj4;
            Object obj5 = objDecodeNullableSerializableElement27;
            objDecodeNullableSerializableElement12 = objDecodeNullableSerializableElement22;
            objDecodeNullableSerializableElement13 = objDecodeNullableSerializableElement28;
            objDecodeNullableSerializableElement14 = objDecodeNullableSerializableElement29;
            objDecodeNullableSerializableElement15 = objDecodeNullableSerializableElement30;
            objDecodeNullableSerializableElement16 = objDecodeNullableSerializableElement26;
            objDecodeNullableSerializableElement17 = obj5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ConfigPayload(i, (ConfigPayload.CleverCache) obj, (ConfigPayload.ConfigSettings) objDecodeNullableSerializableElement9, (ConfigPayload.Endpoints) objDecodeNullableSerializableElement3, (ConfigPayload.LogMetricsSettings) obj2, (List) objDecodeNullableSerializableElement, (ConfigPayload.UserPrivacy) objDecodeNullableSerializableElement11, (ConfigPayload.ViewAbilitySettings) objDecodeNullableSerializableElement15, (String) objDecodeNullableSerializableElement14, (Boolean) objDecodeNullableSerializableElement13, (Boolean) objDecodeNullableSerializableElement12, (Integer) objDecodeNullableSerializableElement17, (Boolean) objDecodeNullableSerializableElement16, (Integer) objDecodeNullableSerializableElement10, (Boolean) objDecodeNullableSerializableElement8, (Boolean) objDecodeNullableSerializableElement7, (Boolean) objDecodeNullableSerializableElement6, (Boolean) objDecodeNullableSerializableElement5, (Long) objDecodeNullableSerializableElement4, (ConfigPayload.AutoRedirect) objDecodeNullableSerializableElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConfigPayload value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ConfigPayload.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
