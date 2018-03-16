package cn.olair.view.floor.two;

import android.graphics.Matrix;
import android.graphics.RectF;

import cn.olair.view.floor.IStatus;

/**
 * 当content区域处于display右上侧.
 *
 * Created by ws on 2018/3/16.
 */

public class TopRight implements IStatus {

    @Override
    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return CheckUtils.isTop(displayRect, contentRect) && CheckUtils.isRight(displayRect,
                contentRect);
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        matrix.postTranslate(displayRect.right - contentRect.right, displayRect.top - contentRect
                .top);
    }

    @Override
    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        if (checkStatus(displayRect, contentRect)) {
            convert(displayRect, contentRect, matrix);
        }
    }

}
