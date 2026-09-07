package com.yandex.mobile.ads.impl;

import com.safedk.android.analytics.events.BrandSafetyEvent;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes.dex */
@Serializable
public final class lw {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] g = {null, null, new ArrayListSerializer(ky.a.f9460a), null, null, new ArrayListSerializer(iy.a.f9267a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9571a;
    private final String b;
    private final List<ky> c;
    private final String d;
    private final jy e;
    private final List<iy> f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<lw> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9572a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9572a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.remote.model.DebugPanelAdUnitWaterfallMediation", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("adapter", true);
            pluginGeneratedSerialDescriptor.addElement(BrandSafetyEvent.ad, false);
            pluginGeneratedSerialDescriptor.addElement("waterfall_parameters", false);
            pluginGeneratedSerialDescriptor.addElement("network_ad_unit_id_name", true);
            pluginGeneratedSerialDescriptor.addElement("currency", false);
            pluginGeneratedSerialDescriptor.addElement("cpm_floors", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = lw.g;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, kSerializerArr[2], BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(jy.a.f9362a), kSerializerArr[5]};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String str;
            String str2;
            List list;
            String str3;
            jy jyVar;
            List list2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = lw.g;
            int i2 = 3;
            String str4 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, stringSerializer, null);
                String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], null);
                String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, stringSerializer, null);
                jy jyVar2 = (jy) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, jy.a.f9362a, null);
                str3 = str6;
                str = str5;
                list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], null);
                i = 63;
                list = list3;
                jyVar = jyVar2;
                str2 = strDecodeStringElement;
            } else {
                boolean z = true;
                int i3 = 0;
                String strDecodeStringElement2 = null;
                List list4 = null;
                String str7 = null;
                jy jyVar3 = null;
                List list5 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 3;
                            break;
                        case 0:
                            str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, StringSerializer.INSTANCE, str4);
                            i3 |= 1;
                            i2 = 3;
                            break;
                        case 1:
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                            i3 |= 2;
                            break;
                        case 2:
                            list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], list4);
                            i3 |= 4;
                            break;
                        case 3:
                            str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, i2, StringSerializer.INSTANCE, str7);
                            i3 |= 8;
                            break;
                        case 4:
                            jyVar3 = (jy) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, jy.a.f9362a, jyVar3);
                            i3 |= 16;
                            break;
                        case 5:
                            list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], list5);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                str = str4;
                str2 = strDecodeStringElement2;
                list = list4;
                str3 = str7;
                jyVar = jyVar3;
                list2 = list5;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new lw(i, str, str2, list, str3, jyVar, list2);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            lw value = (lw) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            lw.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lw)) {
            return false;
        }
        lw lwVar = (lw) obj;
        return Intrinsics.areEqual(this.f9571a, lwVar.f9571a) && Intrinsics.areEqual(this.b, lwVar.b) && Intrinsics.areEqual(this.c, lwVar.c) && Intrinsics.areEqual(this.d, lwVar.d) && Intrinsics.areEqual(this.e, lwVar.e) && Intrinsics.areEqual(this.f, lwVar.f);
    }

    public final int hashCode() {
        String str = this.f9571a;
        int iA = aa.a(this.c, v3.a(this.b, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
        String str2 = this.d;
        int iHashCode = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        jy jyVar = this.e;
        return this.f.hashCode() + ((iHashCode + (jyVar != null ? jyVar.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DebugPanelAdUnitWaterfallMediation(adapter=" + this.f9571a + ", networkName=" + this.b + ", waterfallParameters=" + this.c + ", networkAdUnitIdName=" + this.d + ", currency=" + this.e + ", cpmFloors=" + this.f + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ lw(int i, @SerialName("adapter") String str, @SerialName(BrandSafetyEvent.ad) String str2, @SerialName("waterfall_parameters") List list, @SerialName("network_ad_unit_id_name") String str3, @SerialName("currency") jy jyVar, @SerialName("cpm_floors") List list2) {
        if (54 != (i & 54)) {
            PluginExceptionsKt.throwMissingFieldException(i, 54, a.f9572a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.f9571a = null;
        } else {
            this.f9571a = str;
        }
        this.b = str2;
        this.c = list;
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str3;
        }
        this.e = jyVar;
        this.f = list2;
    }

    @JvmStatic
    public static final /* synthetic */ void a(lw lwVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = g;
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 0) || lwVar.f9571a != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, StringSerializer.INSTANCE, lwVar.f9571a);
        }
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 1, lwVar.b);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], lwVar.c);
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 3) || lwVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, lwVar.d);
        }
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, jy.a.f9362a, lwVar.e);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], lwVar.f);
    }

    public static final class b {
        public final KSerializer<lw> serializer() {
            return a.f9572a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String e() {
        return this.b;
    }

    public final List<ky> f() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final jy c() {
        return this.e;
    }

    public final List<iy> b() {
        return this.f;
    }
}
