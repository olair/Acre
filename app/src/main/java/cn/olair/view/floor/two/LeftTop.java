package cn.olair.view.floor.two;

import android.graphics.Matrix;
import android.graphics.RectF;

import cn.olair.view.floor.IStatus;

/**
 * 处于左上侧
 * <p>
 * Created by ws on 2018/3/16.
 */

public class LeftTop implements IStatus {

    @Override
    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return CheckUtils.isLeft(displayRect, contentRect) && CheckUtils.isTop(displayRect,
                contentRect);
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        matrix.postTranslate(displayRect.left - contentRect.left, displayRect.top - contentRect
                .top);
    }

    @Override
    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        if (checkStatus(displayRect, contentRect)) {
            convert(displayRect, contentRect, matrix);
        }
    }

}
