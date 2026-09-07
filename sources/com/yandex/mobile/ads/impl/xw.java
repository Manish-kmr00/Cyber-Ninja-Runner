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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes6.dex */
@Serializable
public final class xw {
    public static final b Companion = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10680a;
    private final Boolean b;
    private final Boolean c;
    private final boolean d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<xw> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10681a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f10681a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.local.model.DebugPanelConsentsData", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("has_location_consent", false);
            pluginGeneratedSerialDescriptor.addElement("age_restricted_user", false);
            pluginGeneratedSerialDescriptor.addElement("has_user_consent", false);
            pluginGeneratedSerialDescriptor.addElement("has_cmp_value", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            return new KSerializer[]{booleanSerializer, BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), booleanSerializer};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            boolean z;
            boolean zDecodeBooleanElement;
            int i;
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 0);
                BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
                Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, booleanSerializer, null);
                Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, booleanSerializer, null);
                z = zDecodeBooleanElement2;
                zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 3);
                bool2 = bool4;
                bool = bool3;
                i = 15;
            } else {
                boolean z2 = true;
                boolean zDecodeBooleanElement3 = false;
                int i2 = 0;
                Boolean bool5 = null;
                Boolean bool6 = null;
                boolean zDecodeBooleanElement4 = false;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z2 = false;
                    } else if (iDecodeElementIndex == 0) {
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, BooleanSerializer.INSTANCE, bool5);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, BooleanSerializer.INSTANCE, bool6);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 3);
                        i2 |= 8;
                    }
                }
                z = zDecodeBooleanElement3;
                zDecodeBooleanElement = zDecodeBooleanElement4;
                i = i2;
                bool = bool5;
                bool2 = bool6;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new xw(i, z, bool, bool2, zDecodeBooleanElement);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            xw value = (xw) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            xw.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof xw)) {
            return false;
        }
        xw xwVar = (xw) obj;
        return this.f10680a == xwVar.f10680a && Intrinsics.areEqual(this.b, xwVar.b) && Intrinsics.areEqual(this.c, xwVar.c) && this.d == xwVar.d;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f10680a) * 31;
        Boolean bool = this.b;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.c;
        return Boolean.hashCode(this.d) + ((iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DebugPanelConsentsData(hasLocationConsent=" + this.f10680a + ", ageRestrictedUser=" + this.b + ", hasUserConsent=" + this.c + ", hasCmpValue=" + this.d + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ xw(int i, @SerialName("has_location_consent") boolean z, @SerialName("age_restricted_user") Boolean bool, @SerialName("has_user_consent") Boolean bool2, @SerialName("has_cmp_value") boolean z2) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.f10681a.getDescriptor());
        }
        this.f10680a = z;
        this.b = bool;
        this.c = bool2;
        this.d = z2;
    }

    public static final class b {
        public final KSerializer<xw> serializer() {
            return a.f10681a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public xw(boolean z, Boolean bool, Boolean bool2, boolean z2) {
        this.f10680a = z;
        this.b = bool;
        this.c = bool2;
        this.d = z2;
    }

    public final boolean c() {
        return this.f10680a;
    }

    public final Boolean a() {
        return this.b;
    }

    @JvmStatic
    public static final /* synthetic */ void a(xw xwVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        compositeEncoder.encodeBooleanElement(pluginGeneratedSerialDescriptor, 0, xwVar.f10680a);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, booleanSerializer, xwVar.b);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, booleanSerializer, xwVar.c);
        compositeEncoder.encodeBooleanElement(pluginGeneratedSerialDescriptor, 3, xwVar.d);
    }

    public final Boolean d() {
        return this.c;
    }

    public final boolean b() {
        return this.d;
    }
}
