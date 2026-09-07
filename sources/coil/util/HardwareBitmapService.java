package coil.util;

import coil.size.Size;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\u0004H'\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcoil/util/HardwareBitmapService;", "", "()V", "allowHardwareMainThread", "", ContentDisposition.Parameters.Size, "Lcoil/size/Size;", "allowHardwareWorkerThread", "Lcoil/util/ImmutableHardwareBitmapService;", "Lcoil/util/LimitedFileDescriptorHardwareBitmapService;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class HardwareBitmapService {
    public /* synthetic */ HardwareBitmapService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean allowHardwareMainThread(Size size);

    public abstract boolean allowHardwareWorkerThread();

    private HardwareBitmapService() {
    }
}
