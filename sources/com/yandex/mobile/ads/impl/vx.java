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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Serializable
public final class vx {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] d = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10514a;
    private final boolean b;
    private final List<String> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<vx> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10515a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f10515a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.local.model.DebugPanelSdkData", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("version", false);
            pluginGeneratedSerialDescriptor.addElement("is_integrated", false);
            pluginGeneratedSerialDescriptor.addElement("integration_messages", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, vx.d[2]};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            boolean zDecodeBooleanElement;
            String strDecodeStringElement;
            List list;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = vx.d;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 1);
                list = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                String strDecodeStringElement2 = null;
                List list2 = null;
                boolean zDecodeBooleanElement2 = false;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 1);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], list2);
                        i2 |= 4;
                    }
                }
                i = i2;
                zDecodeBooleanElement = zDecodeBooleanElement2;
                strDecodeStringElement = strDecodeStringElement2;
                list = list2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new vx(i, strDecodeStringElement, zDecodeBooleanElement, list);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            vx value = (vx) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            vx.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
        if (!(obj instanceof vx)) {
            return false;
        }
        vx vxVar = (vx) obj;
        return Intrinsics.areEqual(this.f10514a, vxVar.f10514a) && this.b == vxVar.b && Intrinsics.areEqual(this.c, vxVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + a7.a(this.b, this.f10514a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "DebugPanelSdkData(version=" + this.f10514a + ", isIntegratedSuccess=" + this.b + ", integrationMessages=" + this.c + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ vx(int i, @SerialName("version") String str, @SerialName("is_integrated") boolean z, @SerialName("integration_messages") List list) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.f10515a.getDescriptor());
        }
        this.f10514a = str;
        this.b = z;
        this.c = list;
    }

    @JvmStatic
    public static final /* synthetic */ void a(vx vxVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = d;
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, vxVar.f10514a);
        compositeEncoder.encodeBooleanElement(pluginGeneratedSerialDescriptor, 1, vxVar.b);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], vxVar.c);
    }

    public vx(boolean z, List integrationMessages) {
        Intrinsics.checkNotNullParameter("7.12.1", "version");
        Intrinsics.checkNotNullParameter(integrationMessages, "integrationMessages");
        this.f10514a = "7.12.1";
        this.b = z;
        this.c = integrationMessages;
    }

    public static final class b {
        public final KSerializer<vx> serializer() {
            return a.f10515a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String c() {
        return this.f10514a;
    }

    public final boolean d() {
        return this.b;
    }

    public final List<String> b() {
        return this.c;
    }
}
