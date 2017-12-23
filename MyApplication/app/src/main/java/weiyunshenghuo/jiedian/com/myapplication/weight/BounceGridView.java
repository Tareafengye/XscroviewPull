package weiyunshenghuo.jiedian.com.myapplication.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2017/12/23 0023.
 */

public class BounceGridView extends GridView {

    public BounceGridView(Context context) {
        super(context);

    }

    public BounceGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public BounceGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
