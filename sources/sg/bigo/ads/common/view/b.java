package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.RadioButton;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends RadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f13344a;
    private Path b;
    private RectF c;

    public b(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f13344a = paint;
        paint.setColor(-1);
        this.f13344a.setStyle(Paint.Style.STROKE);
        this.f13344a.setAntiAlias(true);
        this.f13344a.setStrokeJoin(Paint.Join.ROUND);
        this.f13344a.setStrokeCap(Paint.Cap.ROUND);
        this.b = new Path();
        this.c = new RectF();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        this.c.set(0.0f, 0.0f, width, height);
        float fA = e.a(getContext(), 4);
        this.b.addRoundRect(this.c, fA, fA, Path.Direction.CW);
        canvas.clipPath(this.b);
        super.onDraw(canvas);
        if (isChecked()) {
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            this.f13344a.setColor(-16736769);
            this.f13344a.setStyle(Paint.Style.FILL);
            canvas.translate(width, height * 0.581f);
            canvas.rotate(51.0f);
            canvas.drawRect(this.c, this.f13344a);
            if (canvas != null) {
                int width2 = canvas.getWidth();
                int height2 = canvas.getHeight();
                this.f13344a.setStyle(Paint.Style.STROKE);
                this.f13344a.setStrokeWidth(e.a(getContext(), 1));
                this.f13344a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                canvas.save();
                float f = height2;
                canvas.translate(width2 * 0.018f, 0.378f * f);
                Path path = new Path();
                path.reset();
                path.moveTo(0.0f, 0.0f);
                path.lineTo((-0.094f) * f, 0.0f);
                path.moveTo(0.0f, 0.0f);
                path.lineTo(0.0f, f * (-0.188f));
                canvas.drawPath(path, this.f13344a);
                canvas.restore();
                this.f13344a.setXfermode(null);
            }
            canvas.restoreToCount(iSaveLayer);
        }
    }
}
