package cn.olair.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 用于展示土地形状的View.
 * <p>
 * Created by olair on 18.1.1.
 */

public class AcreView extends View {

    public AcreView(Context context) {
        super(context, null, 0);
    }

    public AcreView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AcreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AcreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
