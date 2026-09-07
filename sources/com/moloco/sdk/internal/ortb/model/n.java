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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes11.dex */
@Serializable
public final class n {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6138a;
    public final int b;
    public final l c;
    public final u d;
    public final long e;
    public final UInt f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6139a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6139a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Mute", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("mute", false);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n deserialize(Decoder decoder) {
            int i;
            Object objDecodeNullableSerializableElement;
            Object objDecodeSerializableElement;
            Object objDecodeSerializableElement2;
            Object objDecodeSerializableElement3;
            Object objDecodeSerializableElement4;
            Object objDecodeNullableSerializableElement2;
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 6;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 0);
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, uIntSerializer, null);
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, l.a.f6134a, null);
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, u.a.f6153a, null);
                h hVar = h.f6126a;
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, hVar, null);
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 5, uIntSerializer, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, hVar, null);
                z = zDecodeBooleanElement;
                i = 127;
            } else {
                boolean z3 = true;
                boolean zDecodeBooleanElement2 = false;
                Object objDecodeSerializableElement5 = null;
                Object objDecodeSerializableElement6 = null;
                Object objDecodeSerializableElement7 = null;
                Object objDecodeSerializableElement8 = null;
                Object objDecodeNullableSerializableElement3 = null;
                Object objDecodeNullableSerializableElement4 = null;
                i = 0;
                while (z3) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z3 = false;
                            break;
                        case 0:
                            z2 = true;
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 0);
                            i |= 1;
                            i2 = 6;
                            break;
                        case 1:
                            z2 = true;
                            objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, UIntSerializer.INSTANCE, objDecodeSerializableElement5);
                            i |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, l.a.f6134a, objDecodeSerializableElement6);
                            i |= 4;
                            break;
                        case 3:
                            objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, u.a.f6153a, objDecodeSerializableElement7);
                            i |= 8;
                            break;
                        case 4:
                            objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, h.f6126a, objDecodeSerializableElement8);
                            i |= 16;
                            break;
                        case 5:
                            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 5, UIntSerializer.INSTANCE, objDecodeNullableSerializableElement3);
                            i |= 32;
                            break;
                        case 6:
                            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i2, h.f6126a, objDecodeNullableSerializableElement4);
                            i |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement4;
                objDecodeSerializableElement = objDecodeSerializableElement5;
                objDecodeSerializableElement2 = objDecodeSerializableElement6;
                objDecodeSerializableElement3 = objDecodeSerializableElement7;
                objDecodeSerializableElement4 = objDecodeSerializableElement8;
                objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement3;
                z = zDecodeBooleanElement2;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new n(i, z, (UInt) objDecodeSerializableElement, (l) objDecodeSerializableElement2, (u) objDecodeSerializableElement3, (Color) objDecodeSerializableElement4, (UInt) objDecodeNullableSerializableElement2, (Color) objDecodeNullableSerializableElement, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            h hVar = h.f6126a;
            return new KSerializer[]{BooleanSerializer.INSTANCE, uIntSerializer, l.a.f6134a, u.a.f6153a, hVar, BuiltinSerializersKt.getNullable(uIntSerializer), BuiltinSerializersKt.getNullable(hVar)};
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
        public void serialize(Encoder encoder, n value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            n.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<n> serializer() {
            return a.f6139a;
        }

        public b() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ n(int i, @SerialName("mute") boolean z, @SerialName(VastAttributes.PADDING) UInt uInt, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, @SerialName("foreground_color") @Serializable(with = h.class) Color color, @SerialName("control_size") UInt uInt2, @SerialName("background_color") @Serializable(with = h.class) Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, uInt, lVar, uVar, color, uInt2, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(n nVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeBooleanElement(serialDescriptor, 0, nVar.f6138a);
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, uIntSerializer, UInt.m7995boximpl(nVar.b));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, l.a.f6134a, nVar.c);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, u.a.f6153a, nVar.d);
        h hVar = h.f6126a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, hVar, Color.m1621boximpl(nVar.e));
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || nVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, uIntSerializer, nVar.f);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && nVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, nVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void f() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void h() {
    }

    @SerialName("mute")
    public static /* synthetic */ void j() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final UInt c() {
        return this.f;
    }

    public final long e() {
        return this.e;
    }

    public final l g() {
        return this.c;
    }

    public final boolean i() {
        return this.f6138a;
    }

    public final int k() {
        return this.b;
    }

    public final u m() {
        return this.d;
    }

    public /* synthetic */ n(boolean z, int i, l lVar, u uVar, long j, UInt uInt, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, lVar, uVar, j, uInt, color);
    }

    public final Color a() {
        return this.g;
    }

    public n(int i, boolean z, UInt uInt, l lVar, u uVar, Color color, UInt uInt2, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.f6139a.getDescriptor());
        }
        this.f6138a = z;
        this.b = uInt.getData();
        this.c = lVar;
        this.d = uVar;
        this.e = color.m1641unboximpl();
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = uInt2;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public n(boolean z, int i, l horizontalAlignment, u verticalAlignment, long j, UInt uInt, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6138a = z;
        this.b = i;
        this.c = horizontalAlignment;
        this.d = verticalAlignment;
        this.e = j;
        this.f = uInt;
        this.g = color;
    }

    public /* synthetic */ n(boolean z, int i, l lVar, u uVar, long j, UInt uInt, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, lVar, uVar, j, (i2 & 32) != 0 ? null : uInt, (i2 & 64) != 0 ? null : color, null);
    }
}
