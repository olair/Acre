package cn.olair.view.floor.two;

import android.graphics.RectF;

/**
 * 状态判断的工具方法.
 *
 * Created by ws on 2018/3/16.
 */

class CheckUtils {


    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 左侧是否被占据
     */
    static boolean isLeft(RectF displayRect, RectF contentRect) {
        return contentRect.left <= displayRect.left;
    }


    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 右侧是否被占据
     */
    static boolean isRight(RectF displayRect, RectF contentRect) {
        return contentRect.right >= displayRect.right;
    }

    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 上侧是否被占据
     */
    static boolean isTop(RectF displayRect, RectF contentRect) {
        return contentRect.top <= displayRect.top;
    }

    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 下侧是否被占据
     */
    static boolean isBottom(RectF displayRect, RectF contentRect) {
        return contentRect.bottom >= displayRect.bottom;
    }

    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 是否处于显示区域top和bottom之间
     */
    static boolean isIncludedTopBottom(RectF displayRect, RectF contentRect) {
        return contentRect.top >= displayRect.top && contentRect.bottom <= displayRect.bottom;
    }

    /**
     * @param displayRect 显示区域
     * @param contentRect 需要被显示的区域
     * @return 是否处于显示区域left和right之间
     */
    static boolean isIncludedLeftRight(RectF displayRect, RectF contentRect) {
        return contentRect.left >= displayRect.left && contentRect.right <= displayRect.right;
    }

}
