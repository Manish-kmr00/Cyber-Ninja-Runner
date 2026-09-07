package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
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
public final class p {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6142a;
    public final l b;
    public final u c;
    public final long d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6143a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6143a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.ProgressBar", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p deserialize(Decoder decoder) {
            Object objDecodeSerializableElement;
            Object objDecodeSerializableElement2;
            Object objDecodeSerializableElement3;
            int i;
            Object objDecodeSerializableElement4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            Object objDecodeSerializableElement5 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, UIntSerializer.INSTANCE, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, l.a.f6134a, null);
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, u.a.f6153a, null);
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, h.f6126a, null);
                i = 15;
            } else {
                boolean z = true;
                int i2 = 0;
                Object objDecodeSerializableElement6 = null;
                Object objDecodeSerializableElement7 = null;
                Object objDecodeSerializableElement8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, UIntSerializer.INSTANCE, objDecodeSerializableElement5);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, l.a.f6134a, objDecodeSerializableElement6);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, u.a.f6153a, objDecodeSerializableElement7);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, h.f6126a, objDecodeSerializableElement8);
                        i2 |= 8;
                    }
                }
                objDecodeSerializableElement = objDecodeSerializableElement6;
                objDecodeSerializableElement2 = objDecodeSerializableElement7;
                objDecodeSerializableElement3 = objDecodeSerializableElement8;
                Object obj = objDecodeSerializableElement5;
                i = i2;
                objDecodeSerializableElement4 = obj;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new p(i, (UInt) objDecodeSerializableElement4, (l) objDecodeSerializableElement, (u) objDecodeSerializableElement2, (Color) objDecodeSerializableElement3, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{UIntSerializer.INSTANCE, l.a.f6134a, u.a.f6153a, h.f6126a};
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
        public void serialize(Encoder encoder, p value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            p.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<p> serializer() {
            return a.f6143a;
        }

        public b() {
        }
    }

    public /* synthetic */ p(int i, l lVar, u uVar, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lVar, uVar, j);
    }

    @JvmStatic
    public static final /* synthetic */ void a(p pVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, UInt.m7995boximpl(pVar.f6142a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, l.a.f6134a, pVar.b);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, u.a.f6153a, pVar.c);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, h.f6126a, Color.m1621boximpl(pVar.d));
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void d() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void f() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void h() {
    }

    public final l c() {
        return this.b;
    }

    public final int e() {
        return this.f6142a;
    }

    public final u g() {
        return this.c;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ p(int i, @SerialName(VastAttributes.PADDING) UInt uInt, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, @SerialName("foreground_color") @Serializable(with = h.class) Color color, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, lVar, uVar, color, serializationConstructorMarker);
    }

    public final long a() {
        return this.d;
    }

    public p(int i, l horizontalAlignment, u verticalAlignment, long j) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6142a = i;
        this.b = horizontalAlignment;
        this.c = verticalAlignment;
        this.d = j;
    }

    public p(int i, UInt uInt, l lVar, u uVar, Color color, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.f6143a.getDescriptor());
        }
        this.f6142a = uInt.getData();
        this.b = lVar;
        this.c = uVar;
        this.d = color.m1641unboximpl();
    }
}
