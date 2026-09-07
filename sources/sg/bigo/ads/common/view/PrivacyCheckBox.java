package sg.bigo.ads.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes10.dex */
public class PrivacyCheckBox extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13319a;
    private int b;
    private int c;
    private float d;
    private Paint e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private PorterDuffXfermode k;
    private float l;
    private a m;
    private d n;

    class a {
        private a() {
        }

        /* synthetic */ a(PrivacyCheckBox privacyCheckBox, byte b) {
            this();
        }

        protected void a(Canvas canvas) {
            Paint paint;
            int i;
            if (PrivacyCheckBox.this.f13319a) {
                paint = PrivacyCheckBox.this.e;
                i = PrivacyCheckBox.this.g;
            } else {
                paint = PrivacyCheckBox.this.e;
                i = PrivacyCheckBox.this.h;
            }
            paint.setColor(i);
            canvas.drawCircle(0.0f, 0.0f, PrivacyCheckBox.this.d, PrivacyCheckBox.this.e);
        }

        protected void b(Canvas canvas) {
            Paint paint;
            int i;
            if (PrivacyCheckBox.this.f13319a) {
                paint = PrivacyCheckBox.this.e;
                i = PrivacyCheckBox.this.i;
            } else {
                paint = PrivacyCheckBox.this.e;
                i = PrivacyCheckBox.this.j;
            }
            paint.setColor(i);
            PrivacyCheckBox.this.e.setStyle(Paint.Style.STROKE);
            canvas.save();
            canvas.translate(-(PrivacyCheckBox.this.d / 8.0f), PrivacyCheckBox.this.d / 3.0f);
            canvas.rotate(-45.0f);
            Path path = new Path();
            path.reset();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(PrivacyCheckBox.this.f, 0.0f);
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (-PrivacyCheckBox.this.f) / 2.0f);
            canvas.drawPath(path, PrivacyCheckBox.this.e);
            canvas.restore();
        }
    }

    class b extends a {
        private b() {
            super(PrivacyCheckBox.this, (byte) 0);
        }

        /* synthetic */ b(PrivacyCheckBox privacyCheckBox, byte b) {
            this();
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        protected final void a(Canvas canvas) {
            Paint paint;
            Paint.Style style;
            if (PrivacyCheckBox.this.f13319a) {
                paint = PrivacyCheckBox.this.e;
                style = Paint.Style.FILL;
            } else {
                paint = PrivacyCheckBox.this.e;
                style = Paint.Style.STROKE;
            }
            paint.setStyle(style);
            super.a(canvas);
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        protected final void b(Canvas canvas) {
            if (PrivacyCheckBox.this.f13319a) {
                PrivacyCheckBox.this.e.setXfermode(PrivacyCheckBox.this.k);
                super.b(canvas);
                PrivacyCheckBox.this.e.setXfermode(null);
            }
        }
    }

    class c extends a {
        private c() {
            super(PrivacyCheckBox.this, (byte) 0);
        }

        /* synthetic */ c(PrivacyCheckBox privacyCheckBox, byte b) {
            this();
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        protected final void a(Canvas canvas) {
            PrivacyCheckBox.this.e.setStyle(Paint.Style.FILL);
            super.a(canvas);
        }
    }

    public interface d {
        void a(boolean z);
    }

    class e implements View.OnClickListener {
        private View.OnClickListener b;

        e(View.OnClickListener onClickListener) {
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrivacyCheckBox privacyCheckBox = PrivacyCheckBox.this;
            privacyCheckBox.f13319a = !privacyCheckBox.f13319a;
            PrivacyCheckBox.this.invalidate();
            if (PrivacyCheckBox.this.n != null) {
                PrivacyCheckBox.this.n.a(PrivacyCheckBox.this.f13319a);
            }
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public PrivacyCheckBox(Context context) {
        this(context, null);
    }

    public PrivacyCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyCheckBox(Context context, AttributeSet attributeSet, int i) {
        int i2;
        a cVar;
        super(context, attributeSet, i);
        float f = (int) ((context.getResources().getDisplayMetrics().density * 1.5f) + 0.5f);
        byte b2 = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrivacyCheckBox, i, 0);
            this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_check_circle_color, -16736769);
            this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_uncheck_circle_color, -1);
            this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_check_hook_color, ViewCompat.MEASURED_STATE_MASK);
            this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_uncheck_hook_color, -1);
            i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.PrivacyCheckBox_bigo_ad_hcb_style, 1);
            this.f13319a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PrivacyCheckBox_bigo_ad_hcb_is_check, false);
            this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.PrivacyCheckBox_bigo_ad_hcb_line_width, f);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.g = -16736769;
            this.h = -1;
            this.i = ViewCompat.MEASURED_STATE_MASK;
            this.j = -1;
            this.l = f;
            this.f13319a = false;
            i2 = 1;
        }
        if (i2 != 2) {
            cVar = i2 == 1 ? new c(this, b2) : cVar;
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(this.h);
            this.e.setStrokeWidth(this.l);
            this.e.setStrokeJoin(Paint.Join.ROUND);
            this.e.setStrokeCap(Paint.Cap.ROUND);
            setLayerType(1, null);
            this.k = new PorterDuffXfermode(PorterDuff.Mode.XOR);
            setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.view.PrivacyCheckBox.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
        }
        cVar = new b(this, b2);
        this.m = cVar;
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(this.h);
        this.e.setStrokeWidth(this.l);
        this.e.setStrokeJoin(Paint.Join.ROUND);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        setLayerType(1, null);
        this.k = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.view.PrivacyCheckBox.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
    }

    private static int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(80, size);
        }
        return 80;
    }

    public final PrivacyCheckBox a(boolean z) {
        this.f13319a = z;
        d dVar = this.n;
        if (dVar != null) {
            dVar.a(z);
        }
        invalidate();
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer((-this.b) / 2.0f, (-this.c) / 2.0f, getWidth(), getHeight(), null, 31);
        canvas.translate(this.b / 2, this.c / 2);
        this.m.a(canvas);
        this.m.b(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(a(i), a(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = i;
        this.c = i2;
        this.d = (Math.min(i, i2) / 2.0f) * 0.9f;
        this.f = (Math.min(this.b, this.c) / 2.0f) * 0.8f;
    }

    public void setOnCheckChangeListener(d dVar) {
        this.n = dVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(new e(onClickListener));
    }
}
