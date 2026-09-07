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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes13.dex */
@Serializable
public final class g {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6124a;
    public final String b;
    public final int c;
    public final l d;
    public final u e;
    public final long f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6125a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6125a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CTA", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("text", false);
            pluginGeneratedSerialDescriptor.addElement("image_url", true);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g deserialize(Decoder decoder) {
            Object objDecodeNullableSerializableElement;
            Object objDecodeNullableSerializableElement2;
            Object objDecodeSerializableElement;
            Object objDecodeSerializableElement2;
            Object objDecodeSerializableElement3;
            Object objDecodeSerializableElement4;
            String str;
            int i;
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 6;
            String strDecodeStringElement = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor, 0);
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, StringSerializer.INSTANCE, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, UIntSerializer.INSTANCE, null);
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, l.a.f6134a, null);
                objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, u.a.f6153a, null);
                h hVar = h.f6126a;
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, hVar, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, hVar, null);
                str = strDecodeStringElement2;
                i = 127;
            } else {
                boolean z2 = true;
                int i3 = 0;
                Object objDecodeNullableSerializableElement3 = null;
                Object objDecodeNullableSerializableElement4 = null;
                Object objDecodeSerializableElement5 = null;
                Object objDecodeSerializableElement6 = null;
                Object objDecodeSerializableElement7 = null;
                Object objDecodeSerializableElement8 = null;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            break;
                        case 0:
                            z = true;
                            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor, 0);
                            i3 |= 1;
                            i2 = 6;
                            break;
                        case 1:
                            z = true;
                            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, StringSerializer.INSTANCE, objDecodeNullableSerializableElement4);
                            i3 |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 2, UIntSerializer.INSTANCE, objDecodeSerializableElement5);
                            i3 |= 4;
                            break;
                        case 3:
                            objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, l.a.f6134a, objDecodeSerializableElement6);
                            i3 |= 8;
                            break;
                        case 4:
                            objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 4, u.a.f6153a, objDecodeSerializableElement7);
                            i3 |= 16;
                            break;
                        case 5:
                            objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 5, h.f6126a, objDecodeSerializableElement8);
                            i3 |= 32;
                            break;
                        case 6:
                            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i2, h.f6126a, objDecodeNullableSerializableElement3);
                            i3 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement3;
                objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement4;
                objDecodeSerializableElement = objDecodeSerializableElement5;
                objDecodeSerializableElement2 = objDecodeSerializableElement6;
                objDecodeSerializableElement3 = objDecodeSerializableElement7;
                objDecodeSerializableElement4 = objDecodeSerializableElement8;
                str = strDecodeStringElement;
                i = i3;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new g(i, str, (String) objDecodeNullableSerializableElement2, (UInt) objDecodeSerializableElement, (l) objDecodeSerializableElement2, (u) objDecodeSerializableElement3, (Color) objDecodeSerializableElement4, (Color) objDecodeNullableSerializableElement, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            h hVar = h.f6126a;
            return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), UIntSerializer.INSTANCE, l.a.f6134a, u.a.f6153a, hVar, BuiltinSerializersKt.getNullable(hVar)};
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
        public void serialize(Encoder encoder, g value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            g.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<g> serializer() {
            return a.f6125a;
        }

        public b() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ g(int i, @SerialName("text") String str, @SerialName("image_url") String str2, @SerialName(VastAttributes.PADDING) UInt uInt, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) l lVar, @SerialName("vertical_alignment") u uVar, @SerialName("foreground_color") @Serializable(with = h.class) Color color, @SerialName("background_color") @Serializable(with = h.class) Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, uInt, lVar, uVar, color, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(g gVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, gVar.f6124a);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || gVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, gVar.b);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, UInt.m7995boximpl(gVar.c));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, l.a.f6134a, gVar.d);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, u.a.f6153a, gVar.e);
        h hVar = h.f6126a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 5, hVar, Color.m1621boximpl(gVar.f));
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && gVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, gVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void d() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void f() {
    }

    @SerialName("image_url")
    public static /* synthetic */ void h() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void j() {
    }

    @SerialName("text")
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final long c() {
        return this.f;
    }

    public final l e() {
        return this.d;
    }

    public final String g() {
        return this.b;
    }

    public final int i() {
        return this.c;
    }

    public final String k() {
        return this.f6124a;
    }

    public final u m() {
        return this.e;
    }

    public /* synthetic */ g(String str, String str2, int i, l lVar, u uVar, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, lVar, uVar, j, color);
    }

    public final Color a() {
        return this.g;
    }

    public g(int i, String str, String str2, UInt uInt, l lVar, u uVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (61 != (i & 61)) {
            PluginExceptionsKt.throwMissingFieldException(i, 61, a.f6125a.getDescriptor());
        }
        this.f6124a = str;
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        this.c = uInt.getData();
        this.d = lVar;
        this.e = uVar;
        this.f = color.m1641unboximpl();
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public g(String text, String str, int i, l horizontalAlignment, u verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f6124a = text;
        this.b = str;
        this.c = i;
        this.d = horizontalAlignment;
        this.e = verticalAlignment;
        this.f = j;
        this.g = color;
    }

    public /* synthetic */ g(String str, String str2, int i, l lVar, u uVar, long j, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, i, lVar, uVar, j, (i2 & 64) != 0 ? null : color, null);
    }
}
