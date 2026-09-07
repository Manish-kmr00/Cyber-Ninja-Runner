package com.yandex.div.core.util;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageRepresentation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/util/ImageRepresentation;", "", "Bitmap", "PictureDrawable", "Lcom/yandex/div/core/util/ImageRepresentation$Bitmap;", "Lcom/yandex/div/core/util/ImageRepresentation$PictureDrawable;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ImageRepresentation {

    /* JADX INFO: compiled from: ImageRepresentation.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/util/ImageRepresentation$Bitmap;", "Lcom/yandex/div/core/util/ImageRepresentation;", "value", "Landroid/graphics/Bitmap;", "constructor-impl", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "getValue", "()Landroid/graphics/Bitmap;", "equals", "", "other", "", "equals-impl", "(Landroid/graphics/Bitmap;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/graphics/Bitmap;)I", "toString", "", "toString-impl", "(Landroid/graphics/Bitmap;)Ljava/lang/String;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @JvmInline
    public static final class Bitmap implements ImageRepresentation {
        private final android.graphics.Bitmap value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Bitmap m6123boximpl(android.graphics.Bitmap bitmap) {
            return new Bitmap(bitmap);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static android.graphics.Bitmap m6124constructorimpl(android.graphics.Bitmap value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m6125equalsimpl(android.graphics.Bitmap bitmap, Object obj) {
            return (obj instanceof Bitmap) && Intrinsics.areEqual(bitmap, ((Bitmap) obj).m6129unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6126equalsimpl0(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
            return Intrinsics.areEqual(bitmap, bitmap2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m6127hashCodeimpl(android.graphics.Bitmap bitmap) {
            return bitmap.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m6128toStringimpl(android.graphics.Bitmap bitmap) {
            return "Bitmap(value=" + bitmap + ')';
        }

        public boolean equals(Object obj) {
            return m6125equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m6127hashCodeimpl(this.value);
        }

        public String toString() {
            return m6128toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ android.graphics.Bitmap m6129unboximpl() {
            return this.value;
        }

        private /* synthetic */ Bitmap(android.graphics.Bitmap bitmap) {
            this.value = bitmap;
        }

        public final android.graphics.Bitmap getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: ImageRepresentation.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/util/ImageRepresentation$PictureDrawable;", "Lcom/yandex/div/core/util/ImageRepresentation;", "value", "Landroid/graphics/drawable/PictureDrawable;", "constructor-impl", "(Landroid/graphics/drawable/PictureDrawable;)Landroid/graphics/drawable/PictureDrawable;", "getValue", "()Landroid/graphics/drawable/PictureDrawable;", "equals", "", "other", "", "equals-impl", "(Landroid/graphics/drawable/PictureDrawable;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/graphics/drawable/PictureDrawable;)I", "toString", "", "toString-impl", "(Landroid/graphics/drawable/PictureDrawable;)Ljava/lang/String;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @JvmInline
    public static final class PictureDrawable implements ImageRepresentation {
        private final android.graphics.drawable.PictureDrawable value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ PictureDrawable m6130boximpl(android.graphics.drawable.PictureDrawable pictureDrawable) {
            return new PictureDrawable(pictureDrawable);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static android.graphics.drawable.PictureDrawable m6131constructorimpl(android.graphics.drawable.PictureDrawable value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m6132equalsimpl(android.graphics.drawable.PictureDrawable pictureDrawable, Object obj) {
            return (obj instanceof PictureDrawable) && Intrinsics.areEqual(pictureDrawable, ((PictureDrawable) obj).m6136unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6133equalsimpl0(android.graphics.drawable.PictureDrawable pictureDrawable, android.graphics.drawable.PictureDrawable pictureDrawable2) {
            return Intrinsics.areEqual(pictureDrawable, pictureDrawable2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m6134hashCodeimpl(android.graphics.drawable.PictureDrawable pictureDrawable) {
            return pictureDrawable.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m6135toStringimpl(android.graphics.drawable.PictureDrawable pictureDrawable) {
            return "PictureDrawable(value=" + pictureDrawable + ')';
        }

        public boolean equals(Object obj) {
            return m6132equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m6134hashCodeimpl(this.value);
        }

        public String toString() {
            return m6135toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ android.graphics.drawable.PictureDrawable m6136unboximpl() {
            return this.value;
        }

        private /* synthetic */ PictureDrawable(android.graphics.drawable.PictureDrawable pictureDrawable) {
            this.value = pictureDrawable;
        }

        public final android.graphics.drawable.PictureDrawable getValue() {
            return this.value;
        }
    }
}
