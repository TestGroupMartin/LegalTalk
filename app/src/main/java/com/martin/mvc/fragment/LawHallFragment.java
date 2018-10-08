package com.martin.mvc.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.martin.mvc.legaltalk.R;
import com.martin.mvc.legaltalk.SearchDemo;
import com.martin.mvc.util.EditText_Clear;
import com.martin.mvc.adapter.LawHallSelectBaseAdapter;
import com.martin.mvc.data.LawHallSelectData;

import java.util.ArrayList;
import java.util.List;

public class LawHallFragment extends Fragment implements View.OnClickListener {
    private EditText_Clear law_hall_search_edittext;
    private LawHallSelectBaseAdapter adapter;
    private List<LawHallSelectData> list = new ArrayList<>();
    private ListView listView;
    private Intent intent;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_law_hall_fragment,container,false);

        initView();
        initData();
        doClick();

        adapter = new LawHallSelectBaseAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        return view;
    }

    private void doClick() {
        law_hall_search_edittext.setOnClickListener(this);
    }

    private void initData() {
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));
        list.add(new LawHallSelectData("江苏·苏州","黄振律师\n家庭婚姻|借款借贷|房产纠纷","68起","1847人评价",R.drawable.login_bg_grass));

    }

    private void initView() {
        law_hall_search_edittext=view.findViewById(R.id.law_hall_search_edittext);
        listView = view.findViewById(R.id.main_select_lawyer_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.law_hall_search_edittext:
                intent = new Intent(getActivity(),SearchDemo.class);
                startActivity(intent);
                break;
        }
    }
}
