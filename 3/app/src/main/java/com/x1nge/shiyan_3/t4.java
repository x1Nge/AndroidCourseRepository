package com.x1nge.shiyan_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t4 extends AppCompatActivity {

//    private TextView tv_menu;
    private String[] names = new String[]
        {"One","Two","Three","Four","Five","Six"};
    private int[] imgIds = new int[]
            {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t4);

        Button bk_t4 = findViewById(R.id.bk_t4);

        bk_t4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(t4.this,MainActivity.class);
                startActivity(i);
            }
        });

        // 创建一个List集合，元素为Map类型
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("img_4",imgIds[i]);
            listItem.put("name_4",names[i]);
            listItems.add(listItem);
        }

        // 创建simpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.t4_content,
                new String[] {"name_4","img_4"},
                new int[] {R.id.name_4,R.id.img_4});
        ListView list = findViewById(R.id.lv_4);

        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(t4.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

//        tv_menu = findViewById(R.id.tv_t4);
//        // 为文本框注册上下文菜单
//        registerForContextMenu(tv_menu);

        ListView listView = findViewById(R.id.lv_4);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
//                    case R.id.menu_delete:
//                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.t4_menu, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an <code><a href="/reference/android/view/ActionMode.html#invalidate()">invalidate()</a></code> request
                return false;
            }
        });

    }

//    //创建上下文菜单时触发该方法
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater inflater = new MenuInflater(this);
//        //装填R.Menu.menu菜单，并添加到menu中
//        inflater.inflate(R.menu.t4_menu,menu);
//        menu.setHeaderTitle("请选择背景色");
//    }
//    //上下文菜单中菜单项被单击时，触发该方法
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        //勾选菜单项
//        item.setChecked(true);
//        switch (item.getItemId()){
//            case R.id.red:
//                item.setChecked(true);
//                tv_menu.setBackgroundColor(Color.RED);
//                break;
//            case R.id.green:
//                item.setChecked(true);
//                tv_menu.setBackgroundColor(Color.GREEN);
//                break;
//            case R.id.blue:
//                item.setChecked(true);
//                tv_menu.setBackgroundColor(Color.BLUE);
//                break;
//        }
//        return true;
//    }


}
//import android.app.Activity;
//import android.app.ListActivity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.ActionMode;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AbsListView;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.ListView;
//
//import java.util.HashMap;
//import java.util.Set;
//
//public class t4 extends ListActivity {
//
//    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
//
//    private SelectionAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_t4);
//
//        mAdapter = new SelectionAdapter(this,
//                R.layout.t4_content, R.id.lv_4, data);
//        setListAdapter(mAdapter);
//        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
//
//        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//
//            private int nr = 0;
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//                // TODO Auto-generated method stub
//                mAdapter.clearSelection();
//            }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                // TODO Auto-generated method stub
//
//                nr = 0;
//                MenuInflater inflater = getMenuInflater();
//                inflater.inflate(R.menu.t4_menu, menu);
//                return true;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                // TODO Auto-generated method stub
//                switch (item.getItemId()) {
//
//                    case R.id.item_delete:
//                        nr = 0;
//                        mAdapter.clearSelection();
//                        mode.finish();
//                }
//                return false;
//            }
//
//            @Override
//            public void onItemCheckedStateChanged(ActionMode mode, int position,
//                                                  long id, boolean checked) {
//                // TODO Auto-generated method stub
//                if (checked) {
//                    nr++;
//                    mAdapter.setNewSelection(position, checked);
//                } else {
//                    nr--;
//                    mAdapter.removeSelection(position);
//                }
//                mode.setTitle(nr + " selected");
//
//            }
//        });
//
//        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//                                           int position, long arg3) {
//                // TODO Auto-generated method stub
//
//                getListView().setItemChecked(position, !mAdapter.isPositionChecked(position));
//                return false;
//            }
//        });
//    }
//
//    private class SelectionAdapter extends ArrayAdapter<String> {
//
//        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();
//
//        public SelectionAdapter(Context context, int resource,
//                                int textViewResourceId, String[] objects) {
//            super(context, resource, textViewResourceId, objects);
//        }
//
//        public void setNewSelection(int position, boolean value) {
//            mSelection.put(position, value);
//            notifyDataSetChanged();
//        }
//
//        public boolean isPositionChecked(int position) {
//            Boolean result = mSelection.get(position);
//            return result == null ? false : result;
//        }
//
//        public Set<Integer> getCurrentCheckedPosition() {
//            return mSelection.keySet();
//        }
//
//        public void removeSelection(int position) {
//            mSelection.remove(position);
//            notifyDataSetChanged();
//        }
//
//        public void clearSelection() {
//            mSelection = new HashMap<Integer, Boolean>();
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View v = super.getView(position, convertView, parent);//let the adapter handle setting up the row views
//            v.setBackgroundColor(getResources().getColor(android.R.color.background_light)); //default color
//
//            if (mSelection.get(position) != null) {
//                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));// this is a selected position so make it red
//            }
//            return v;
//        }
//    }
//}