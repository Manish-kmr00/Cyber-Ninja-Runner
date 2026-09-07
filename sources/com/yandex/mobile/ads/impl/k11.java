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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class k11 {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9370a;
    private final String b;
    private final String c;
    private final Map<String, String> d;
    private final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<k11> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9371a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9371a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.utils.logger.model.MobileAdsNetworkRequestLog", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("timestamp", false);
            pluginGeneratedSerialDescriptor.addElement("method", false);
            pluginGeneratedSerialDescriptor.addElement("url", false);
            pluginGeneratedSerialDescriptor.addElement("headers", false);
            pluginGeneratedSerialDescriptor.addElement("body", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer[] kSerializerArr = k11.f;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{LongSerializer.INSTANCE, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(stringSerializer)};
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
            Map map;
            String str3;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = k11.f;
            String strDecodeStringElement = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, kSerializerArr[3], null);
                str = strDecodeStringElement2;
                str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, null);
                str2 = strDecodeStringElement3;
                i = 31;
                j = jDecodeLongElement;
            } else {
                boolean z = true;
                int i2 = 0;
                String str4 = null;
                long jDecodeLongElement2 = 0;
                String strDecodeStringElement4 = null;
                Map map2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, kSerializerArr[3], map2);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, str4);
                        i2 |= 16;
                    }
                }
                i = i2;
                str = strDecodeStringElement;
                str2 = strDecodeStringElement4;
                map = map2;
                str3 = str4;
                j = jDecodeLongElement2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new k11(i, j, str, str2, map, str3);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            k11 value = (k11) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            k11.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        f = new KSerializer[]{null, null, null, new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)), null};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k11)) {
            return false;
        }
        k11 k11Var = (k11) obj;
        return this.f9370a == k11Var.f9370a && Intrinsics.areEqual(this.b, k11Var.b) && Intrinsics.areEqual(this.c, k11Var.c) && Intrinsics.areEqual(this.d, k11Var.d) && Intrinsics.areEqual(this.e, k11Var.e);
    }

    public final int hashCode() {
        int iA = v3.a(this.c, v3.a(this.b, Long.hashCode(this.f9370a) * 31, 31), 31);
        Map<String, String> map = this.d;
        int iHashCode = (iA + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.e;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "MobileAdsNetworkRequestLog(timestamp=" + this.f9370a + ", method=" + this.b + ", url=" + this.c + ", headers=" + this.d + ", body=" + this.e + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ k11(int i, @SerialName("timestamp") long j, @SerialName("method") String str, @SerialName("url") String str2, @SerialName("headers") Map map, @SerialName("body") String str3) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.f9371a.getDescriptor());
        }
        this.f9370a = j;
        this.b = str;
        this.c = str2;
        this.d = map;
        this.e = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void a(k11 k11Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = f;
        compositeEncoder.encodeLongElement(pluginGeneratedSerialDescriptor, 0, k11Var.f9370a);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 1, k11Var.b);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 2, k11Var.c);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, kSerializerArr[3], k11Var.d);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, k11Var.e);
    }

    public k11(long j, String method, String url, Map<String, String> map, String str) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f9370a = j;
        this.b = method;
        this.c = url;
        this.d = map;
        this.e = str;
    }

    public static final class b {
        public final KSerializer<k11> serializer() {
            return a.f9371a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }
}
