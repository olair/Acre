package cn.olair.view.floor.two;

import android.graphics.Matrix;
import android.graphics.RectF;

import cn.olair.view.floor.IStatus;

/**
 * 处于左侧.
 *
 * Created by ws on 2018/3/16.
 */

public class Left implements IStatus {

    @Override
    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return CheckUtils.isLeft(displayRect, contentRect) && CheckUtils.isIncludedTopBottom
                (displayRect, contentRect);
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        matrix.postTranslate(displayRect.left - contentRect.left, 0f);
    }

    @Override
    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        if (checkStatus(displayRect, contentRect)) {
            convert(displayRect, contentRect, matrix);
        }
    }

}
