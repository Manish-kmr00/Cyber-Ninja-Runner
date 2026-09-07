package com.moloco.sdk.internal.ortb.model;

import com.facebook.internal.AnalyticsEvents;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes13.dex */
@Serializable
public final class t {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6150a;
    public final l b;
    public final u c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6151a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6151a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.VastPrivacyIcon", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t deserialize(Decoder decoder) {
            Object objDecodeSerializableElement;
            Object objDecodeSerializableElement2;
            int i;
            Object objDecodeSerializableElement3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            Object objDecodeSerializableElement4 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, UIntSerializer.INSTANCE, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, l.a.f6134a, null);
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, u.a.f6153a, null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                Object objDecodeSerializableElement5 = null;
                Object objDecodeSerializableElement6 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, UIntSerializer.INSTANCE, objDecodeSerializableElement4);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, l.a.f6134a, objDecodeSerializableElement5);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, u.a.f6153a, objDecodeSerializableElement6);
                        i2 |= 4;
                    }
                }
                objDecodeSerializableElement = objDecodeSerializableElement5;
                objDecodeSerializableElement2 = objDecodeSerializableElement6;
                Object obj = objDecodeSerializableElement4;
                i = i2;
                objDecodeSerializableElement3 = obj;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new t(i, (UInt) objDecodeSerializableElement3, (l) objDecodeSerializableElement, (u) objDecodeSerializableElement2, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{UIntSerializer.INSTANCE, l.a.f6134a, u.a.f6153a};
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
        public void serialize(Encoder encoder, t value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            t.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<t> serializer() {
            return a.f6151a;
        }

        public b() {
        }
    }

    public /* synthetic */ t(int i, l lVar, u uVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lVar, uVar);
    }

    @JvmStatic
    public static final /* synthetic */ void a(t tVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, UInt.m7995boximpl(tVar.f6150a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, l.a.f6134a, tVar.b);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, u.a.f6153a, tVar.c);
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void b() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void d() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void f() {
    }

    public final int c() {
        return this.f6150a;
    }

    public final u e() {
        return this.c;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ t(int i, @SerialName(VastAttributes.PADDING) UInt uInt, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, lVar, uVar, serializationConstructorMarker);
    }

    public final l a() {
        return this.b;
    }

    public t(int i, l horizontalAlignment, u verticalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6150a = i;
        this.b = horizontalAlignment;
        this.c = verticalAlignment;
    }

    public t(int i, UInt uInt, l lVar, u uVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.f6151a.getDescriptor());
        }
        this.f6150a = uInt.getData();
        this.b = lVar;
        this.c = uVar;
    }
}
