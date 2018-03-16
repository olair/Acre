package cn.olair.view.floor.one;

import android.graphics.Matrix;
import android.graphics.RectF;

import cn.olair.view.floor.IStatus;

/**
 * 当content区域大于display区域时.
 * <p>
 * Created by ws on 2018/3/16.
 */

public class Big implements IStatus {

    private Small small = new Small();

    @Override
    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return displayRect.width() <= contentRect.width() ||
                displayRect.height() <= contentRect.height();
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        float scaleX = displayRect.width() / contentRect.width();
        float scaleY = displayRect.height() / contentRect.height();
        if (scaleX < scaleY) {
            matrix.postScale(scaleX, scaleX, contentRect.left, contentRect.top);
        } else {
            matrix.postScale(scaleY, scaleY, contentRect.left, contentRect.top);
        }
    }

    @Override
    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        if (checkStatus(displayRect, contentRect)) {
            convert(displayRect, contentRect, matrix);
            float[] map = new float[]{contentRect.left, contentRect.top, contentRect.right,
                    contentRect.bottom};
            matrix.mapPoints(map);
            contentRect.set(map[0], map[1], map[2], map[3]);
            small.calculate(displayRect, contentRect, matrix);
        }
    }
}
