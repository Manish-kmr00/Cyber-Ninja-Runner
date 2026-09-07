package androidx.compose.ui.input.pointer.util;

import com.yandex.div.core.timer.TimerController;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/util/ImpulseCalculator;", "", "()V", "initialCondition", "", "previousT", "", "previousX", "", "work", "addPosition", "", "timeMillis", VastAttributes.HORIZONTAL_POSITION, "getVelocity", TimerController.RESET_COMMAND, "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ImpulseCalculator {
    private float work;
    private long previousT = Long.MAX_VALUE;
    private float previousX = Float.NaN;
    private boolean initialCondition = true;

    public final float getVelocity() {
        return VelocityTrackerKt.kineticEnergyToVelocity(this.work);
    }

    public final void addPosition(long timeMillis, float x) {
        if (this.previousT == Long.MAX_VALUE || Float.isNaN(this.previousX)) {
            this.previousT = timeMillis;
            this.previousX = x;
            return;
        }
        if (timeMillis != this.previousT) {
            float fKineticEnergyToVelocity = VelocityTrackerKt.kineticEnergyToVelocity(this.work);
            float f = (x - this.previousX) / ((timeMillis - this.previousT) * 0.001f);
            float fAbs = this.work + ((f - fKineticEnergyToVelocity) * Math.abs(f));
            this.work = fAbs;
            if (this.initialCondition) {
                this.work = fAbs * 0.5f;
                this.initialCondition = false;
            }
            this.previousT = timeMillis;
            this.previousX = x;
            return;
        }
        this.previousX = x;
    }

    public final void reset() {
        this.work = 0.0f;
        this.previousT = Long.MAX_VALUE;
        this.previousX = Float.NaN;
        this.initialCondition = true;
    }
}
