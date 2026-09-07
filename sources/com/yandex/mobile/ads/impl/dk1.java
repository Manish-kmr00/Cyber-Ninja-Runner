package com.yandex.mobile.ads.impl;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes8.dex */
@Serializable
public final class dk1 {
    public static final b Companion = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8704a;
    private final hk1 b;
    private final qk1 c;
    private final ok1 d;
    private final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<dk1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8705a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f8705a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.base.model.mediation.prefetch.PrefetchedMediationInfo", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("adapter", false);
            pluginGeneratedSerialDescriptor.addElement("network_winner", false);
            pluginGeneratedSerialDescriptor.addElement("revenue", false);
            pluginGeneratedSerialDescriptor.addElement("result", false);
            pluginGeneratedSerialDescriptor.addElement("network_ad_info", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(hk1.a.f9107a), BuiltinSerializersKt.getNullable(qk1.a.f10029a), ok1.a.f9827a, BuiltinSerializersKt.getNullable(stringSerializer)};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String str;
            hk1 hk1Var;
            qk1 qk1Var;
            ok1 ok1Var;
            String str2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            String strDecodeStringElement = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                hk1 hk1Var2 = (hk1) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, hk1.a.f9107a, null);
                qk1 qk1Var2 = (qk1) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, qk1.a.f10029a, null);
                str = strDecodeStringElement2;
                ok1Var = (ok1) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 3, ok1.a.f9827a, null);
                str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, null);
                qk1Var = qk1Var2;
                hk1Var = hk1Var2;
                i = 31;
            } else {
                boolean z = true;
                int i2 = 0;
                hk1 hk1Var3 = null;
                qk1 qk1Var3 = null;
                ok1 ok1Var2 = null;
                String str3 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        hk1Var3 = (hk1) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, hk1.a.f9107a, hk1Var3);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        qk1Var3 = (qk1) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, qk1.a.f10029a, qk1Var3);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        ok1Var2 = (ok1) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 3, ok1.a.f9827a, ok1Var2);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, str3);
                        i2 |= 16;
                    }
                }
                i = i2;
                str = strDecodeStringElement;
                hk1Var = hk1Var3;
                qk1Var = qk1Var3;
                ok1Var = ok1Var2;
                str2 = str3;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new dk1(i, str, hk1Var, qk1Var, ok1Var, str2);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            dk1 value = (dk1) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            dk1.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof dk1)) {
            return false;
        }
        dk1 dk1Var = (dk1) obj;
        return Intrinsics.areEqual(this.f8704a, dk1Var.f8704a) && Intrinsics.areEqual(this.b, dk1Var.b) && Intrinsics.areEqual(this.c, dk1Var.c) && Intrinsics.areEqual(this.d, dk1Var.d) && Intrinsics.areEqual(this.e, dk1Var.e);
    }

    public final int hashCode() {
        int iHashCode = this.f8704a.hashCode() * 31;
        hk1 hk1Var = this.b;
        int iHashCode2 = (iHashCode + (hk1Var == null ? 0 : hk1Var.hashCode())) * 31;
        qk1 qk1Var = this.c;
        int iHashCode3 = (this.d.hashCode() + ((iHashCode2 + (qk1Var == null ? 0 : qk1Var.hashCode())) * 31)) * 31;
        String str = this.e;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "PrefetchedMediationInfo(adapter=" + this.f8704a + ", networkWinner=" + this.b + ", revenue=" + this.c + ", result=" + this.d + ", networkAdInfo=" + this.e + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ dk1(int i, @SerialName("adapter") String str, @SerialName("network_winner") hk1 hk1Var, @SerialName("revenue") qk1 qk1Var, @SerialName("result") ok1 ok1Var, @SerialName("network_ad_info") String str2) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.f8705a.getDescriptor());
        }
        this.f8704a = str;
        this.b = hk1Var;
        this.c = qk1Var;
        this.d = ok1Var;
        this.e = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void a(dk1 dk1Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, dk1Var.f8704a);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, hk1.a.f9107a, dk1Var.b);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, qk1.a.f10029a, dk1Var.c);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 3, ok1.a.f9827a, dk1Var.d);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, dk1Var.e);
    }

    public dk1(String adapter, hk1 hk1Var, qk1 qk1Var, ok1 result, String str) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(result, "result");
        this.f8704a = adapter;
        this.b = hk1Var;
        this.c = qk1Var;
        this.d = result;
        this.e = str;
    }

    public static final class b {
        public final KSerializer<dk1> serializer() {
            return a.f8705a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }
}
