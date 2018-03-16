package cn.olair.view.floor.two;

import android.graphics.Matrix;
import android.graphics.RectF;

import cn.olair.view.floor.IStatus;

/**
 * 当content区域处于display下侧.
 * <p>
 * Created by ws on 2018/3/16.
 */

public class Bottom implements IStatus {

    @Override
    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return CheckUtils.isBottom(displayRect, contentRect) && CheckUtils.isIncludedLeftRight
                (displayRect, contentRect);
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        matrix.postTranslate(0f, displayRect.bottom - contentRect.bottom);
    }

    @Override
    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        if (checkStatus(displayRect, contentRect)) {
            convert(displayRect, contentRect, matrix);
        }
    }

}
