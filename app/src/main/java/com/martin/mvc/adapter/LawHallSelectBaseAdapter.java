package com.martin.mvc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.martin.mvc.legaltalk.R;
import com.martin.mvc.data.LawHallSelectData;

import java.util.List;

/**
 * Created by 14182 on 17.8.12.
 */

public class LawHallSelectBaseAdapter extends BaseAdapter {
    private List<LawHallSelectData> datas;
    private Context mContext;
    private LayoutInflater inflater;

    public LawHallSelectBaseAdapter(Context context, List<LawHallSelectData> datas) {
        mContext = context;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_main_law_hall_select_list, null);
            viewHolder.city = convertView.findViewById(R.id.city);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.money = convertView.findViewById(R.id.money);
            viewHolder.number = convertView.findViewById(R.id.number);
            viewHolder.people_image = convertView.findViewById(R.id.people_image);

            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.city.setTag(datas.get(i).getCity());
        viewHolder.name.setText(datas.get(i).getName());
        viewHolder.money.setText(datas.get(i).getMoney());
        viewHolder.number.setText(datas.get(i).getNumber());
        viewHolder.people_image.setBackgroundResource(R.drawable.login_bg_grass);
//
//        //解决混乱，获取用户答案，并重新选择更新UI
//        if (datas.get(i).useAnswer != 0) {
//            RadioButton r = (RadioButton) viewHolder.group.getChildAt(datas.get(i).useAnswer - 1);
//            r.setChecked(true);
//        } else {
//            viewHolder.group.clearCheck();
//        }

        return convertView;
    }

    class ViewHolder {
        TextView city,name,money,number;
        FrameLayout people_image;
    }
}
