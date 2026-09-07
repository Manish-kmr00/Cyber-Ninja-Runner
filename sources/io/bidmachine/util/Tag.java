package io.bidmachine.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tag.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/bidmachine/util/Tag;", "", "name", "", "(Ljava/lang/String;)V", "tag", "getTag", "()Ljava/lang/String;", "tag$delegate", "Lkotlin/Lazy;", "toString", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tag {
    private final String name;

    /* JADX INFO: renamed from: tag$delegate, reason: from kotlin metadata */
    private final Lazy tag;

    public Tag(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.tag = LazyKt.lazy(new Function0<String>() { // from class: io.bidmachine.util.Tag$tag$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.name + " @" + UtilsKt.createHexHashCode(this.this$0);
            }
        });
    }

    private final String getTag() {
        return (String) this.tag.getValue();
    }

    public String toString() {
        return getTag();
    }
}
