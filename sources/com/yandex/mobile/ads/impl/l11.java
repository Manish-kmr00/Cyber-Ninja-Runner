package com.yandex.mobile.ads.impl;

import java.util.Map;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes7.dex */
@Serializable
public final class l11 {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9467a;
    private final Integer b;
    private final Map<String, String> c;
    private final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<l11> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9468a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9468a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.utils.logger.model.MobileAdsNetworkResponseLog", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("timestamp", false);
            pluginGeneratedSerialDescriptor.addElement("code", false);
            pluginGeneratedSerialDescriptor.addElement("headers", false);
            pluginGeneratedSerialDescriptor.addElement("body", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(l11.e[2]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            Integer num;
            Map map;
            String str;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = l11.e;
            Integer num2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, IntSerializer.INSTANCE, null);
                map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], null);
                num = num3;
                str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, null);
                i = 15;
                j = jDecodeLongElement;
            } else {
                boolean z = true;
                int i2 = 0;
                long jDecodeLongElement2 = 0;
                Map map2 = null;
                String str2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, IntSerializer.INSTANCE, num2);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], map2);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, str2);
                        i2 |= 8;
                    }
                }
                i = i2;
                num = num2;
                map = map2;
                str = str2;
                j = jDecodeLongElement2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new l11(i, j, num, map, str);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            l11 value = (l11) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            l11.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        e = new KSerializer[]{null, null, new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)), null};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l11)) {
            return false;
        }
        l11 l11Var = (l11) obj;
        return this.f9467a == l11Var.f9467a && Intrinsics.areEqual(this.b, l11Var.b) && Intrinsics.areEqual(this.c, l11Var.c) && Intrinsics.areEqual(this.d, l11Var.d);
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f9467a) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Map<String, String> map = this.c;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.d;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "MobileAdsNetworkResponseLog(timestamp=" + this.f9467a + ", statusCode=" + this.b + ", headers=" + this.c + ", body=" + this.d + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ l11(int i, @SerialName("timestamp") long j, @SerialName("code") Integer num, @SerialName("headers") Map map, @SerialName("body") String str) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.f9468a.getDescriptor());
        }
        this.f9467a = j;
        this.b = num;
        this.c = map;
        this.d = str;
    }

    @JvmStatic
    public static final /* synthetic */ void a(l11 l11Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = e;
        compositeEncoder.encodeLongElement(pluginGeneratedSerialDescriptor, 0, l11Var.f9467a);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, IntSerializer.INSTANCE, l11Var.b);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], l11Var.c);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, l11Var.d);
    }

    public static final class b {
        public final KSerializer<l11> serializer() {
            return a.f9468a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public l11(long j, Integer num, Map<String, String> map, String str) {
        this.f9467a = j;
        this.b = num;
        this.c = map;
        this.d = str;
    }
}
