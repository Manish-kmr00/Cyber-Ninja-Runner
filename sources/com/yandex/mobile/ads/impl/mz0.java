package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class mz0 {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] d = {null, null, new ArrayListSerializer(c.a.f9683a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9680a;
    private final String b;
    private final List<c> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<mz0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9681a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9681a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.core.initializer.validation.adapters.MediationNetworkData", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("name", false);
            pluginGeneratedSerialDescriptor.addElement("version", false);
            pluginGeneratedSerialDescriptor.addElement("adapters", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = mz0.d;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[2]};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            String str;
            List list;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = mz0.d;
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, null);
                list = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                String str2 = null;
                List list2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, str2);
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
                strDecodeStringElement = strDecodeStringElement2;
                str = str2;
                list = list2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new mz0(i, strDecodeStringElement, str, list);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            mz0 value = (mz0) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            mz0.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Serializable
    public static final class c {
        public static final b Companion = new b(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9682a;
        private final String b;
        private final boolean c;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public static final class a implements GeneratedSerializer<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f9683a;
            private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

            static {
                a aVar = new a();
                f9683a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.core.initializer.validation.adapters.MediationNetworkData.MediationAdapterData", aVar, 3);
                pluginGeneratedSerialDescriptor.addElement("format", false);
                pluginGeneratedSerialDescriptor.addElement("version", false);
                pluginGeneratedSerialDescriptor.addElement("isIntegrated", false);
                b = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE};
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                boolean zDecodeBooleanElement;
                int i;
                String strDecodeStringElement;
                String str;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, null);
                    zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 2);
                    i = 7;
                } else {
                    boolean z = true;
                    boolean zDecodeBooleanElement2 = false;
                    String strDecodeStringElement2 = null;
                    String str2 = null;
                    int i2 = 0;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, str2);
                            i2 |= 2;
                        } else {
                            if (iDecodeElementIndex != 2) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 2);
                            i2 |= 4;
                        }
                    }
                    zDecodeBooleanElement = zDecodeBooleanElement2;
                    i = i2;
                    strDecodeStringElement = strDecodeStringElement2;
                    str = str2;
                }
                compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
                return new c(i, strDecodeStringElement, str, zDecodeBooleanElement);
            }

            private a() {
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                c value = (c) obj;
                Intrinsics.checkNotNullParameter(encoder, "encoder");
                Intrinsics.checkNotNullParameter(value, "value");
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
                c.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
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
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.f9682a, cVar.f9682a) && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c;
        }

        public final int hashCode() {
            int iHashCode = this.f9682a.hashCode() * 31;
            String str = this.b;
            return Boolean.hashCode(this.c) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final String toString() {
            return "MediationAdapterData(format=" + this.f9682a + ", version=" + this.b + ", isIntegrated=" + this.c + ")";
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ c(int i, String str, String str2, boolean z) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, a.f9683a.getDescriptor());
            }
            this.f9682a = str;
            this.b = str2;
            this.c = z;
        }

        public c(String format, String str, boolean z) {
            Intrinsics.checkNotNullParameter(format, "format");
            this.f9682a = format;
            this.b = str;
            this.c = z;
        }

        public static final class b {
            public final KSerializer<c> serializer() {
                return a.f9683a;
            }

            private b() {
            }

            public /* synthetic */ b(int i) {
                this();
            }
        }

        public final String a() {
            return this.f9682a;
        }

        public final String b() {
            return this.b;
        }

        @JvmStatic
        public static final /* synthetic */ void a(c cVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
            compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, cVar.f9682a);
            compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, cVar.b);
            compositeEncoder.encodeBooleanElement(pluginGeneratedSerialDescriptor, 2, cVar.c);
        }

        public final boolean c() {
            return this.c;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mz0)) {
            return false;
        }
        mz0 mz0Var = (mz0) obj;
        return Intrinsics.areEqual(this.f9680a, mz0Var.f9680a) && Intrinsics.areEqual(this.b, mz0Var.b) && Intrinsics.areEqual(this.c, mz0Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.f9680a.hashCode() * 31;
        String str = this.b;
        return this.c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "MediationNetworkData(name=" + this.f9680a + ", version=" + this.b + ", adapters=" + this.c + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ mz0(int i, String str, String str2, List list) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.f9681a.getDescriptor());
        }
        this.f9680a = str;
        this.b = str2;
        this.c = list;
    }

    @JvmStatic
    public static final /* synthetic */ void a(mz0 mz0Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = d;
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, mz0Var.f9680a);
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 1, StringSerializer.INSTANCE, mz0Var.b);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], mz0Var.c);
    }

    public mz0(String name, String str, ArrayList adapters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        this.f9680a = name;
        this.b = str;
        this.c = adapters;
    }

    public static final class b {
        public final KSerializer<mz0> serializer() {
            return a.f9681a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String c() {
        return this.f9680a;
    }

    public final String d() {
        return this.b;
    }

    public final List<c> b() {
        return this.c;
    }
}
