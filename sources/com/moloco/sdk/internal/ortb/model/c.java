package com.moloco.sdk.internal.ortb.model;

import com.json.m5;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes13.dex */
@Serializable
public final class c {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6118a;
    public final float b;
    public final String c;
    public final d d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6119a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6119a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Bid", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("adm", false);
            pluginGeneratedSerialDescriptor.addElement("price", false);
            pluginGeneratedSerialDescriptor.addElement(m5.y, true);
            pluginGeneratedSerialDescriptor.addElement("ext", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c deserialize(Decoder decoder) {
            float f;
            int i;
            String str;
            Object objDecodeNullableSerializableElement;
            Object objDecodeSerializableElement;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor, 0);
                float fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(descriptor, 1);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, StringSerializer.INSTANCE, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, d.a.f6121a, null);
                str = strDecodeStringElement;
                f = fDecodeFloatElement;
                i = 15;
            } else {
                float fDecodeFloatElement2 = 0.0f;
                boolean z = true;
                String strDecodeStringElement2 = null;
                Object objDecodeNullableSerializableElement2 = null;
                Object objDecodeSerializableElement2 = null;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        fDecodeFloatElement2 = compositeDecoderBeginStructure.decodeFloatElement(descriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, StringSerializer.INSTANCE, objDecodeNullableSerializableElement2);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, d.a.f6121a, objDecodeSerializableElement2);
                        i2 |= 8;
                    }
                }
                f = fDecodeFloatElement2;
                i = i2;
                str = strDecodeStringElement2;
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
                objDecodeSerializableElement = objDecodeSerializableElement2;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new c(i, str, f, (String) objDecodeNullableSerializableElement, (d) objDecodeSerializableElement, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), d.a.f6121a};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            c.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c> serializer() {
            return a.f6119a;
        }

        public b() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ c(int i, @SerialName("adm") String str, @SerialName("price") float f, @SerialName(m5.y) String str2, @SerialName("ext") d dVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, a.f6119a.getDescriptor());
        }
        this.f6118a = str;
        this.b = f;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        this.d = dVar;
    }

    @JvmStatic
    public static final /* synthetic */ void a(c cVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, cVar.f6118a);
        compositeEncoder.encodeFloatElement(serialDescriptor, 1, cVar.b);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || cVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, cVar.c);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, d.a.f6121a, cVar.d);
    }

    @SerialName("adm")
    public static /* synthetic */ void b() {
    }

    @SerialName(m5.y)
    public static /* synthetic */ void d() {
    }

    @SerialName("ext")
    public static /* synthetic */ void f() {
    }

    @SerialName("price")
    public static /* synthetic */ void h() {
    }

    public final String c() {
        return this.c;
    }

    public final d e() {
        return this.d;
    }

    public final float g() {
        return this.b;
    }

    public final String a() {
        return this.f6118a;
    }

    public c(String adm, float f, String str, d ext) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(ext, "ext");
        this.f6118a = adm;
        this.b = f;
        this.c = str;
        this.d = ext;
    }

    public /* synthetic */ c(String str, float f, String str2, d dVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, (i & 4) != 0 ? null : str2, dVar);
    }
}
