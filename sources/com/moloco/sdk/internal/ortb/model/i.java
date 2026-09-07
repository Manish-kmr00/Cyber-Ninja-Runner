package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes9.dex */
@Serializable
public final class i {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6127a;
    public final boolean b;
    public final int c;
    public final Integer d;
    public final l e;
    public final u f;
    public final long g;
    public final long h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6128a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6128a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CountDownTimer", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("custom_timer_desc", true);
            pluginGeneratedSerialDescriptor.addElement("is_default_timer", true);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, true);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", true);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i deserialize(Decoder decoder) {
            Object objDecodeSerializableElement;
            Object objDecodeSerializableElement2;
            Object objDecodeSerializableElement3;
            int i;
            Object objDecodeSerializableElement4;
            Object objDecodeNullableSerializableElement;
            Object objDecodeSerializableElement5;
            boolean z;
            Object objDecodeNullableSerializableElement2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 7;
            int i3 = 6;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, StringSerializer.INSTANCE, null);
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 1);
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, UIntSerializer.INSTANCE, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, IntSerializer.INSTANCE, null);
                objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, l.a.f6134a, null);
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, u.a.f6153a, null);
                h hVar = h.f6126a;
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 6, hVar, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 7, hVar, null);
                i = 255;
                z = zDecodeBooleanElement;
            } else {
                boolean z2 = true;
                boolean zDecodeBooleanElement2 = false;
                Object objDecodeSerializableElement6 = null;
                Object objDecodeSerializableElement7 = null;
                Object objDecodeNullableSerializableElement3 = null;
                Object objDecodeSerializableElement8 = null;
                Object objDecodeNullableSerializableElement4 = null;
                Object objDecodeSerializableElement9 = null;
                Object objDecodeSerializableElement10 = null;
                int i4 = 0;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 6;
                            break;
                        case 0:
                            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, StringSerializer.INSTANCE, objDecodeNullableSerializableElement3);
                            i4 |= 1;
                            i2 = 7;
                            i3 = 6;
                            break;
                        case 1:
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 1);
                            i4 |= 2;
                            i2 = 7;
                            break;
                        case 2:
                            objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, UIntSerializer.INSTANCE, objDecodeSerializableElement8);
                            i4 |= 4;
                            i2 = 7;
                            break;
                        case 3:
                            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, IntSerializer.INSTANCE, objDecodeNullableSerializableElement4);
                            i4 |= 8;
                            i2 = 7;
                            break;
                        case 4:
                            objDecodeSerializableElement9 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, l.a.f6134a, objDecodeSerializableElement9);
                            i4 |= 16;
                            break;
                        case 5:
                            objDecodeSerializableElement10 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, u.a.f6153a, objDecodeSerializableElement10);
                            i4 |= 32;
                            break;
                        case 6:
                            objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, i3, h.f6126a, objDecodeSerializableElement7);
                            i4 |= 64;
                            break;
                        case 7:
                            objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, i2, h.f6126a, objDecodeSerializableElement6);
                            i4 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                objDecodeSerializableElement = objDecodeSerializableElement6;
                objDecodeSerializableElement2 = objDecodeSerializableElement7;
                objDecodeSerializableElement3 = objDecodeSerializableElement10;
                i = i4;
                objDecodeSerializableElement4 = objDecodeSerializableElement8;
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement4;
                objDecodeSerializableElement5 = objDecodeSerializableElement9;
                Object obj = objDecodeNullableSerializableElement3;
                z = zDecodeBooleanElement2;
                objDecodeNullableSerializableElement2 = obj;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new i(i, (String) objDecodeNullableSerializableElement2, z, (UInt) objDecodeSerializableElement4, (Integer) objDecodeNullableSerializableElement, (l) objDecodeSerializableElement5, (u) objDecodeSerializableElement3, (Color) objDecodeSerializableElement2, (Color) objDecodeSerializableElement, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            h hVar = h.f6126a;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, UIntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), l.a.f6134a, u.a.f6153a, hVar, hVar};
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
        public void serialize(Encoder encoder, i value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            i.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<i> serializer() {
            return a.f6128a;
        }

        public b() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ i(int i, @SerialName("custom_timer_desc") String str, @SerialName("is_default_timer") boolean z, @SerialName("control_size") UInt uInt, @SerialName(VastAttributes.PADDING) Integer num, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, @SerialName("foreground_color") @Serializable(with = h.class) Color color, @SerialName("background_color") @Serializable(with = h.class) Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, z, uInt, num, lVar, uVar, color, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(i iVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || iVar.f6127a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, iVar.f6127a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !iVar.b) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, iVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || iVar.c != 30) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, UInt.m7995boximpl(iVar.c));
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || iVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, iVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || iVar.e != l.Right) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, l.a.f6134a, iVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || iVar.f != u.Top) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, u.a.f6153a, iVar.f);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || !Color.m1632equalsimpl0(iVar.g, ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")))) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, h.f6126a, Color.m1621boximpl(iVar.g));
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && Color.m1632equalsimpl0(iVar.h, ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")))) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 7, h.f6126a, Color.m1621boximpl(iVar.h));
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("custom_timer_desc")
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

    @SerialName("is_default_timer")
    public static /* synthetic */ void p() {
    }

    public final int c() {
        return this.c;
    }

    public final String e() {
        return this.f6127a;
    }

    public final long g() {
        return this.g;
    }

    public final l i() {
        return this.e;
    }

    public final Integer k() {
        return this.d;
    }

    public final u m() {
        return this.f;
    }

    public final boolean o() {
        return this.b;
    }

    public /* synthetic */ i(String str, boolean z, int i, Integer num, l lVar, u uVar, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, i, num, lVar, uVar, j, j2);
    }

    public i(int i, String str, boolean z, UInt uInt, Integer num, l lVar, u uVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        long jM1641unboximpl;
        long jM1641unboximpl2;
        if ((i & 1) == 0) {
            this.f6127a = null;
        } else {
            this.f6127a = str;
        }
        if ((i & 2) == 0) {
            this.b = true;
        } else {
            this.b = z;
        }
        this.c = (i & 4) == 0 ? 30 : uInt.getData();
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = num;
        }
        if ((i & 16) == 0) {
            this.e = l.Right;
        } else {
            this.e = lVar;
        }
        if ((i & 32) == 0) {
            this.f = u.Top;
        } else {
            this.f = uVar;
        }
        if ((i & 64) == 0) {
            jM1641unboximpl = ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4"));
        } else {
            jM1641unboximpl = color.m1641unboximpl();
        }
        this.g = jM1641unboximpl;
        if ((i & 128) == 0) {
            jM1641unboximpl2 = ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF"));
        } else {
            jM1641unboximpl2 = color2.m1641unboximpl();
        }
        this.h = jM1641unboximpl2;
    }

    public i(String str, boolean z, int i, Integer num, l horizontalAlignment, u verticalAlignment, long j, long j2) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6127a = str;
        this.b = z;
        this.c = i;
        this.d = num;
        this.e = horizontalAlignment;
        this.f = verticalAlignment;
        this.g = j;
        this.h = j2;
    }

    public final long a() {
        return this.h;
    }

    public /* synthetic */ i(String str, boolean z, int i, Integer num, l lVar, u uVar, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? 30 : i, (i2 & 8) == 0 ? num : null, (i2 & 16) != 0 ? l.Right : lVar, (i2 & 32) != 0 ? u.Top : uVar, (i2 & 64) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")) : j, (i2 & 128) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")) : j2, null);
    }
}
