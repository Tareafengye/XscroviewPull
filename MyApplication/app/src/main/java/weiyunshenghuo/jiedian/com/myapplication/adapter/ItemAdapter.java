package weiyunshenghuo.jiedian.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import weiyunshenghuo.jiedian.com.myapplication.R;

/**
 * Created by Administrator on 2017/12/23 0023.
 */

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> nameArray;

    public ItemAdapter(Context context, ArrayList<String> nameArray) {
        this.context = context;
        this.nameArray = nameArray;
    }

    @Override
    public int getCount() {
        if (nameArray != null && nameArray.size() > 0) {
            return nameArray.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null, false);
            holder.leftNameView = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.leftNameView.setText(nameArray.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView leftNameView;
    }
}
