package cn.olair.view.floor.one;

import android.graphics.Matrix;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cn.olair.view.floor.IStatus;
import cn.olair.view.floor.two.Bottom;
import cn.olair.view.floor.two.BottomLeft;
import cn.olair.view.floor.two.Left;
import cn.olair.view.floor.two.LeftTop;
import cn.olair.view.floor.two.Right;
import cn.olair.view.floor.two.RightBottom;
import cn.olair.view.floor.two.Top;
import cn.olair.view.floor.two.TopRight;

/**
 * 当content区域小于display区域时.
 *
 * Created by ws on 2018/3/16.
 */

public class Small implements IStatus {

    private List<IStatus> nextStep = new ArrayList<>();

    public Small() {
        nextStep.add(new Bottom());
        nextStep.add(new BottomLeft());
        nextStep.add(new Left());
        nextStep.add(new LeftTop());
        nextStep.add(new Right());
        nextStep.add(new RightBottom());
        nextStep.add(new Top());
        nextStep.add(new TopRight());
    }

    public boolean checkStatus(RectF displayRect, RectF contentRect) {
        return displayRect.width() >= contentRect.width() && displayRect.height() >= contentRect
                .height();
    }

    @Override
    public void convert(RectF displayRect, RectF contentRect, Matrix matrix) {
        for (IStatus status : nextStep) {
            if (status.checkStatus(displayRect, contentRect)) {
                status.convert(displayRect, contentRect, matrix);
            }
        }
    }


    public void calculate(RectF displayRect, RectF contentRect, Matrix matrix) {
        for (IStatus status : nextStep) {
            status.calculate(displayRect, contentRect, matrix);
        }
    }

}
