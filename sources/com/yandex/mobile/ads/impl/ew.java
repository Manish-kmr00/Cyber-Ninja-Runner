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

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class ew {
    public static final b Companion = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8835a;
    private final String b;
    private final String c;
    private final iw d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<ew> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8836a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f8836a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.remote.model.DebugPanelAdUnit", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("name", false);
            pluginGeneratedSerialDescriptor.addElement("ad_type", false);
            pluginGeneratedSerialDescriptor.addElement("ad_unit_id", false);
            pluginGeneratedSerialDescriptor.addElement("mediation", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(iw.a.f9260a);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, nullable};
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
            String str3;
            iw iwVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            String strDecodeStringElement = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                str = strDecodeStringElement2;
                iwVar = (iw) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, iw.a.f9260a, null);
                str3 = strDecodeStringElement4;
                str2 = strDecodeStringElement3;
                i = 15;
            } else {
                boolean z = true;
                int i2 = 0;
                String strDecodeStringElement5 = null;
                String strDecodeStringElement6 = null;
                iw iwVar2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        iwVar2 = (iw) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, iw.a.f9260a, iwVar2);
                        i2 |= 8;
                    }
                }
                i = i2;
                str = strDecodeStringElement;
                str2 = strDecodeStringElement5;
                str3 = strDecodeStringElement6;
                iwVar = iwVar2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new ew(i, str, str2, str3, iwVar);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            ew value = (ew) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            ew.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof ew)) {
            return false;
        }
        ew ewVar = (ew) obj;
        return Intrinsics.areEqual(this.f8835a, ewVar.f8835a) && Intrinsics.areEqual(this.b, ewVar.b) && Intrinsics.areEqual(this.c, ewVar.c) && Intrinsics.areEqual(this.d, ewVar.d);
    }

    public final int hashCode() {
        int iA = v3.a(this.c, v3.a(this.b, this.f8835a.hashCode() * 31, 31), 31);
        iw iwVar = this.d;
        return iA + (iwVar == null ? 0 : iwVar.hashCode());
    }

    public final String toString() {
        return "DebugPanelAdUnit(name=" + this.f8835a + ", format=" + this.b + ", adUnitId=" + this.c + ", mediation=" + this.d + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ew(int i, @SerialName("name") String str, @SerialName("ad_type") String str2, @SerialName("ad_unit_id") String str3, @SerialName("mediation") iw iwVar) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.f8836a.getDescriptor());
        }
        this.f8835a = str;
        this.b = str2;
        this.c = str3;
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = iwVar;
        }
    }

    public static final class b {
        public final KSerializer<ew> serializer() {
            return a.f8836a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String d() {
        return this.f8835a;
    }

    public final String b() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }

    @JvmStatic
    public static final /* synthetic */ void a(ew ewVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, ewVar.f8835a);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 1, ewVar.b);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 2, ewVar.c);
        if (!compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 3) && ewVar.d == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, iw.a.f9260a, ewVar.d);
    }

    public final iw c() {
        return this.d;
    }
}
