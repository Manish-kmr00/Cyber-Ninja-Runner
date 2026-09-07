package com.yandex.mobile.ads.impl;

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

/* JADX INFO: loaded from: classes5.dex */
@Serializable
public final class ox {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] h = {null, null, null, null, new ArrayListSerializer(rw.a.f10147a), new ArrayListSerializer(ew.a.f8836a), new ArrayListSerializer(nx.a.f9762a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9871a;
    private final String b;
    private final String c;
    private final String d;
    private final List<rw> e;
    private final List<ew> f;
    private final List<nx> g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<ox> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9872a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9872a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.remote.model.DebugPanelRemoteData", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("page_id", true);
            pluginGeneratedSerialDescriptor.addElement("latest_sdk_version", true);
            pluginGeneratedSerialDescriptor.addElement("app_ads_txt_url", true);
            pluginGeneratedSerialDescriptor.addElement("app_status", true);
            pluginGeneratedSerialDescriptor.addElement("alerts", true);
            pluginGeneratedSerialDescriptor.addElement("ad_units", true);
            pluginGeneratedSerialDescriptor.addElement("mediation_networks", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = ox.h;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5]), kSerializerArr[6]};
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
            List list2;
            List list3;
            String str4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = ox.h;
            int i2 = 3;
            String str5 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, stringSerializer, null);
                str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, stringSerializer, null);
                String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, stringSerializer, null);
                String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, stringSerializer, null);
                List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], null);
                List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], null);
                list = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 6, kSerializerArr[6], null);
                str2 = str8;
                list2 = list4;
                list3 = list5;
                str = str6;
                str4 = str7;
                i = 127;
            } else {
                boolean z = true;
                int i3 = 0;
                List list6 = null;
                List list7 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                List list8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 3;
                            break;
                        case 0:
                            str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, StringSerializer.INSTANCE, str5);
                            i3 |= 1;
                            i2 = 3;
                            break;
                        case 1:
                            str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, str9);
                            i3 |= 2;
                            i2 = 3;
                            break;
                        case 2:
                            str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, StringSerializer.INSTANCE, str10);
                            i3 |= 4;
                            i2 = 3;
                            break;
                        case 3:
                            str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, i2, StringSerializer.INSTANCE, str11);
                            i3 |= 8;
                            break;
                        case 4:
                            list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], list8);
                            i3 |= 16;
                            break;
                        case 5:
                            list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], list7);
                            i3 |= 32;
                            break;
                        case 6:
                            list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 6, kSerializerArr[6], list6);
                            i3 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                str = str5;
                str2 = str11;
                list = list6;
                str3 = str9;
                list2 = list8;
                String str12 = str10;
                list3 = list7;
                str4 = str12;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new ox(i, str, str3, str4, str2, list2, list3, list);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            ox value = (ox) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            ox.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof ox)) {
            return false;
        }
        ox oxVar = (ox) obj;
        return Intrinsics.areEqual(this.f9871a, oxVar.f9871a) && Intrinsics.areEqual(this.b, oxVar.b) && Intrinsics.areEqual(this.c, oxVar.c) && Intrinsics.areEqual(this.d, oxVar.d) && Intrinsics.areEqual(this.e, oxVar.e) && Intrinsics.areEqual(this.f, oxVar.f) && Intrinsics.areEqual(this.g, oxVar.g);
    }

    public final int hashCode() {
        String str = this.f9871a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<rw> list = this.e;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<ew> list2 = this.f;
        return this.g.hashCode() + ((iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DebugPanelRemoteData(pageId=" + this.f9871a + ", latestSdkVersion=" + this.b + ", appAdsTxtUrl=" + this.c + ", appStatus=" + this.d + ", alerts=" + this.e + ", adUnits=" + this.f + ", mediationNetworks=" + this.g + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ox(int i, @SerialName("page_id") String str, @SerialName("latest_sdk_version") String str2, @SerialName("app_ads_txt_url") String str3, @SerialName("app_status") String str4, @SerialName("alerts") List list, @SerialName("ad_units") List list2, @SerialName("mediation_networks") List list3) {
        if (64 != (i & 64)) {
            PluginExceptionsKt.throwMissingFieldException(i, 64, a.f9872a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.f9871a = null;
        } else {
            this.f9871a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = list;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = list2;
        }
        this.g = list3;
    }

    @JvmStatic
    public static final /* synthetic */ void a(ox oxVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = h;
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 0) || oxVar.f9871a != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 0, StringSerializer.INSTANCE, oxVar.f9871a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 1) || oxVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, oxVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 2) || oxVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, StringSerializer.INSTANCE, oxVar.c);
        }
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 3) || oxVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, oxVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 4) || oxVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], oxVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 5) || oxVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], oxVar.f);
        }
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 6, kSerializerArr[6], oxVar.g);
    }

    public static final class b {
        public final KSerializer<ox> serializer() {
            return a.f9872a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String g() {
        return this.f9871a;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final List<rw> c() {
        return this.e;
    }

    public final List<ew> b() {
        return this.f;
    }

    public final List<nx> f() {
        return this.g;
    }
}
