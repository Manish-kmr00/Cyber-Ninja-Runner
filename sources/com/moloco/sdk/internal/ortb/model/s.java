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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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

/* JADX INFO: loaded from: classes6.dex */
@Serializable
public final class s {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6148a;
    public final int b;
    public final int c;
    public final l d;
    public final u e;
    public final long f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6149a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6149a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SkipClose", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("delay_seconds", false);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("control_size", false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s deserialize(Decoder decoder) {
            Object objDecodeSerializableElement;
            int i;
            Object objDecodeNullableSerializableElement;
            Object objDecodeSerializableElement2;
            Object objDecodeSerializableElement3;
            Object objDecodeSerializableElement4;
            Object objDecodeSerializableElement5;
            Object objDecodeSerializableElement6;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 6;
            Object objDecodeSerializableElement7 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, uIntSerializer, null);
                Object objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, uIntSerializer, null);
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, uIntSerializer, null);
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, l.a.f6134a, null);
                objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, u.a.f6153a, null);
                h hVar = h.f6126a;
                objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, hVar, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, hVar, null);
                objDecodeSerializableElement = objDecodeSerializableElement8;
                i = 127;
            } else {
                boolean z = true;
                int i3 = 0;
                Object objDecodeNullableSerializableElement2 = null;
                objDecodeSerializableElement = null;
                Object objDecodeSerializableElement9 = null;
                Object objDecodeSerializableElement10 = null;
                Object objDecodeSerializableElement11 = null;
                Object objDecodeSerializableElement12 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 6;
                            break;
                        case 0:
                            objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, UIntSerializer.INSTANCE, objDecodeSerializableElement7);
                            i3 |= 1;
                            i2 = 6;
                            break;
                        case 1:
                            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, UIntSerializer.INSTANCE, objDecodeSerializableElement);
                            i3 |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            objDecodeSerializableElement9 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, UIntSerializer.INSTANCE, objDecodeSerializableElement9);
                            i3 |= 4;
                            break;
                        case 3:
                            objDecodeSerializableElement10 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, l.a.f6134a, objDecodeSerializableElement10);
                            i3 |= 8;
                            break;
                        case 4:
                            objDecodeSerializableElement11 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, u.a.f6153a, objDecodeSerializableElement11);
                            i3 |= 16;
                            break;
                        case 5:
                            objDecodeSerializableElement12 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, h.f6126a, objDecodeSerializableElement12);
                            i3 |= 32;
                            break;
                        case 6:
                            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i2, h.f6126a, objDecodeNullableSerializableElement2);
                            i3 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
                objDecodeSerializableElement2 = objDecodeSerializableElement7;
                objDecodeSerializableElement3 = objDecodeSerializableElement9;
                objDecodeSerializableElement4 = objDecodeSerializableElement10;
                objDecodeSerializableElement5 = objDecodeSerializableElement11;
                objDecodeSerializableElement6 = objDecodeSerializableElement12;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new s(i, (UInt) objDecodeSerializableElement2, (UInt) objDecodeSerializableElement, (UInt) objDecodeSerializableElement3, (l) objDecodeSerializableElement4, (u) objDecodeSerializableElement5, (Color) objDecodeSerializableElement6, (Color) objDecodeNullableSerializableElement, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            h hVar = h.f6126a;
            return new KSerializer[]{uIntSerializer, uIntSerializer, uIntSerializer, l.a.f6134a, u.a.f6153a, hVar, BuiltinSerializersKt.getNullable(hVar)};
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
        public void serialize(Encoder encoder, s value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            s.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<s> serializer() {
            return a.f6149a;
        }

        public b() {
        }
    }

    public /* synthetic */ s(int i, int i2, int i3, l lVar, u uVar, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, lVar, uVar, j, color);
    }

    @JvmStatic
    public static final /* synthetic */ void a(s sVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, uIntSerializer, UInt.m7995boximpl(sVar.f6148a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, uIntSerializer, UInt.m7995boximpl(sVar.b));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, uIntSerializer, UInt.m7995boximpl(sVar.c));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, l.a.f6134a, sVar.d);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, u.a.f6153a, sVar.e);
        h hVar = h.f6126a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 5, hVar, Color.m1621boximpl(sVar.f));
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && sVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, sVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("delay_seconds")
    public static /* synthetic */ void f() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void h() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void j() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final int c() {
        return this.c;
    }

    public final int e() {
        return this.f6148a;
    }

    public final long g() {
        return this.f;
    }

    public final l i() {
        return this.d;
    }

    public final int k() {
        return this.b;
    }

    public final u m() {
        return this.e;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ s(int i, @SerialName("delay_seconds") UInt uInt, @SerialName(VastAttributes.PADDING) UInt uInt2, @SerialName("control_size") UInt uInt3, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, @SerialName("foreground_color") @Serializable(with = h.class) Color color, @SerialName("background_color") @Serializable(with = h.class) Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, uInt2, uInt3, lVar, uVar, color, color2, serializationConstructorMarker);
    }

    public final Color a() {
        return this.g;
    }

    public s(int i, int i2, int i3, l horizontalAlignment, u verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6148a = i;
        this.b = i2;
        this.c = i3;
        this.d = horizontalAlignment;
        this.e = verticalAlignment;
        this.f = j;
        this.g = color;
    }

    public s(int i, UInt uInt, UInt uInt2, UInt uInt3, l lVar, u uVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, a.f6149a.getDescriptor());
        }
        this.f6148a = uInt.getData();
        this.b = uInt2.getData();
        this.c = uInt3.getData();
        this.d = lVar;
        this.e = uVar;
        this.f = color.m1641unboximpl();
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public /* synthetic */ s(int i, int i2, int i3, l lVar, u uVar, long j, Color color, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, lVar, uVar, j, (i4 & 64) != 0 ? null : color, null);
    }
}
