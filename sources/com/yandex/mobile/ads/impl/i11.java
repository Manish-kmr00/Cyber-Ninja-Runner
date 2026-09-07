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

/* JADX INFO: loaded from: classes8.dex */
@Serializable
public final class i11 {
    public static final b Companion = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k11 f9163a;
    private final l11 b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<i11> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9164a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9164a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.utils.logger.model.MobileAdsNetworkLog", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("request", false);
            pluginGeneratedSerialDescriptor.addElement("response", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{k11.a.f9371a, BuiltinSerializersKt.getNullable(l11.a.f9468a)};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            k11 k11Var;
            l11 l11Var;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            k11 k11Var2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                k11Var = (k11) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, k11.a.f9371a, null);
                l11Var = (l11) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, l11.a.f9468a, null);
                i = 3;
            } else {
                boolean z = true;
                int i2 = 0;
                l11 l11Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        k11Var2 = (k11) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, k11.a.f9371a, k11Var2);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        l11Var2 = (l11) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, l11.a.f9468a, l11Var2);
                        i2 |= 2;
                    }
                }
                i = i2;
                k11Var = k11Var2;
                l11Var = l11Var2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new i11(i, k11Var, l11Var);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            i11 value = (i11) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            i11.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof i11)) {
            return false;
        }
        i11 i11Var = (i11) obj;
        return Intrinsics.areEqual(this.f9163a, i11Var.f9163a) && Intrinsics.areEqual(this.b, i11Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.f9163a.hashCode() * 31;
        l11 l11Var = this.b;
        return iHashCode + (l11Var == null ? 0 : l11Var.hashCode());
    }

    public final String toString() {
        return "MobileAdsNetworkLog(request=" + this.f9163a + ", response=" + this.b + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ i11(int i, @SerialName("request") k11 k11Var, @SerialName("response") l11 l11Var) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.f9164a.getDescriptor());
        }
        this.f9163a = k11Var;
        this.b = l11Var;
    }

    @JvmStatic
    public static final /* synthetic */ void a(i11 i11Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 0, k11.a.f9371a, i11Var.f9163a);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, l11.a.f9468a, i11Var.b);
    }

    public i11(k11 request, l11 l11Var) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f9163a = request;
        this.b = l11Var;
    }

    public static final class b {
        public final KSerializer<i11> serializer() {
            return a.f9164a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }
}
