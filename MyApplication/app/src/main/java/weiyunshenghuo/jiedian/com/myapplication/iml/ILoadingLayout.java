package weiyunshenghuo.jiedian.com.myapplication.iml;

/**
 * Created by Administrator on 2017/12/23 0023.
 */

public interface ILoadingLayout {
    public void pullToRefresh();

    public void releaseToRefresh();

    public void refreshing();

    public void normal();
}
