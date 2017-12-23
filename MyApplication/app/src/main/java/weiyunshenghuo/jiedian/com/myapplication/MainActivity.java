package weiyunshenghuo.jiedian.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import weiyunshenghuo.jiedian.com.myapplication.adapter.ItemAdapter;
import weiyunshenghuo.jiedian.com.myapplication.weight.BounceListView;
import weiyunshenghuo.jiedian.com.myapplication.weight.XScrollView;

public class MainActivity extends AppCompatActivity {
    private XScrollView scrollView = null;
    private ArrayList<String> nameArray = new ArrayList<>();
    private ItemAdapter itemAdapter = null;
    private Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        scrollView = (XScrollView) findViewById(R.id.scroll);
        scrollView.setXScrollViewListener(new XScrollView.IXScrollViewListener() {
            @Override
            public void onRefresh() {
                handler.sendMessageDelayed(handler.obtainMessage(1), 1000);
            }

            @Override
            public void onLoadMore() {
                handler.sendMessageDelayed(handler.obtainMessage(2), 1000);
            }
        });

        scrollView.setPullLoadEnable(false); // 取消上拉加载
        BounceListView itemListView = (BounceListView) findViewById(R.id.item_list);
        itemAdapter = new ItemAdapter(this,nameArray);
        itemListView.setAdapter(itemAdapter);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                nameArray.clear();
                for (int i = 0; i < 20; i++) {
                    nameArray.add("name" + random.nextInt());
                }
                itemAdapter.notifyDataSetChanged();
                scrollView.stopRefresh();  // 停止刷新
                scrollView.smoothScrollTo(0, 0); // 滚动的时候平滑的效果
            } else if (msg.what == 2) {
                for (int i = 0; i < 20; i++) {
                    nameArray.add("name" + random.nextInt());
                }
                itemAdapter.notifyDataSetChanged();
                scrollView.stopLoadMore();  // 停止加载
            }
        }
    };
}
