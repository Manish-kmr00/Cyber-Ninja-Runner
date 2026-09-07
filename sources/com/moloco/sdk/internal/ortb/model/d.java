package com.moloco.sdk.internal.ortb.model;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes12.dex */
@Serializable
public final class d {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6120a;
    public final String b;
    public final q c;
    public final m d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6121a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6121a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BidExt", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("player", true);
            pluginGeneratedSerialDescriptor.addElement("mtid", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_events", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_click_metadata", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d deserialize(Decoder decoder) {
            Object objDecodeNullableSerializableElement;
            Object objDecodeNullableSerializableElement2;
            Object objDecodeNullableSerializableElement3;
            int i;
            Object objDecodeNullableSerializableElement4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            Object objDecodeNullableSerializableElement5 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, o.a.f6141a, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, StringSerializer.INSTANCE, null);
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, q.a.f6145a, null);
                objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, m.a.f6137a, null);
                i = 15;
            } else {
                boolean z = true;
                int i2 = 0;
                Object objDecodeNullableSerializableElement6 = null;
                Object objDecodeNullableSerializableElement7 = null;
                Object objDecodeNullableSerializableElement8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, o.a.f6141a, objDecodeNullableSerializableElement5);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, StringSerializer.INSTANCE, objDecodeNullableSerializableElement6);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, q.a.f6145a, objDecodeNullableSerializableElement7);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, m.a.f6137a, objDecodeNullableSerializableElement8);
                        i2 |= 8;
                    }
                }
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement6;
                objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement7;
                objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement8;
                Object obj = objDecodeNullableSerializableElement5;
                i = i2;
                objDecodeNullableSerializableElement4 = obj;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new d(i, (o) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement, (q) objDecodeNullableSerializableElement2, (m) objDecodeNullableSerializableElement3, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(o.a.f6141a), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(q.a.f6145a), BuiltinSerializersKt.getNullable(m.a.f6137a)};
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
        public void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            d.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<d> serializer() {
            return a.f6121a;
        }

        public b() {
        }
    }

    public d() {
        this((o) null, (String) null, (q) null, (m) null, 15, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(d dVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || dVar.f6120a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, o.a.f6141a, dVar.f6120a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || dVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, dVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || dVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, q.a.f6145a, dVar.c);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && dVar.d == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, m.a.f6137a, dVar.d);
    }

    @SerialName("moloco_sdk_click_metadata")
    public static /* synthetic */ void b() {
    }

    @SerialName("mtid")
    public static /* synthetic */ void d() {
    }

    @SerialName("player")
    public static /* synthetic */ void f() {
    }

    @SerialName("moloco_sdk_events")
    public static /* synthetic */ void h() {
    }

    public final String c() {
        return this.b;
    }

    public final o e() {
        return this.f6120a;
    }

    public final q g() {
        return this.c;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ d(int i, @SerialName("player") o oVar, @SerialName("mtid") String str, @SerialName("moloco_sdk_events") q qVar, @SerialName("moloco_sdk_click_metadata") m mVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f6120a = null;
        } else {
            this.f6120a = oVar;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = qVar;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = mVar;
        }
    }

    public final m a() {
        return this.d;
    }

    public d(o oVar, String str, q qVar, m mVar) {
        this.f6120a = oVar;
        this.b = str;
        this.c = qVar;
        this.d = mVar;
    }

    public /* synthetic */ d(o oVar, String str, q qVar, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : oVar, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : qVar, (i & 8) != 0 ? null : mVar);
    }
}
