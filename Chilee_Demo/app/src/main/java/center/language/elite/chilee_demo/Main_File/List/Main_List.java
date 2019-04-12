package center.language.elite.chilee_demo.Main_File.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import center.language.elite.chilee_demo.GCMD.GCMD;
import center.language.elite.chilee_demo.R;

public class Main_List extends Activity implements View.OnClickListener {

    private GCMD mGCMD = new GCMD();
    private LinearLayout mMain_Index_Lin;
    private LinearLayout mMain_Money_Lin;
    private LinearLayout mMain_Favorite_Lin;
    private LinearLayout mMain_List_Lin;
    private LinearLayout mMain_Member_Lin;

    private ListView mMain_List_View;
    private SimpleAdapter mMain_List_Adapter;

    public List_Struct mList_Struct = new List_Struct();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        InitSetting();
    }

    //--------------------------------------------------------------------
    private void InitSetting() {
        Log.d(mGCMD.TAG,"InitSetting");
        mMain_Index_Lin = (LinearLayout)findViewById(R.id.Main_Index_Lin);
        mMain_Money_Lin = (LinearLayout)findViewById(R.id.Main_Money_Lin);
        mMain_Favorite_Lin = (LinearLayout)findViewById(R.id.Main_Favorite_Lin);
        mMain_List_Lin = (LinearLayout)findViewById(R.id.Main_List_Lin);
        mMain_Member_Lin = (LinearLayout)findViewById(R.id.Main_Member_Lin);
        mMain_List_View = (ListView)findViewById(R.id.Main_List_View);

        mMain_Index_Lin.setOnClickListener(this);
        mMain_Money_Lin.setOnClickListener(this);
        mMain_Favorite_Lin.setOnClickListener(this);
        mMain_List_Lin.setOnClickListener(this);
        mMain_Member_Lin.setOnClickListener(this);

        Set_Adapter_List_Data();
    }


    ///SetAdapter_Init
    private void Set_Adapter_List_Data () {

        Log.d(mGCMD.TAG,"Set_Adapter_List_Data");

        mList_Struct.List_Data_Arr.clear();

        for (int i =0;i<mList_Struct.Name.length;i++){
            Map<String, Object> map = new HashMap<>();

            map.put(mList_Struct.List_Name_Key,mList_Struct.Name[i].trim());
            map.put(mList_Struct.List_Price_Key,mList_Struct.Price[i].trim());
            mList_Struct.List_Data_Arr.add(map);
        }

        if(mMain_List_Adapter != null){
            mMain_List_Adapter.notifyDataSetChanged();
        } else {

            mMain_List_Adapter = new List_Adapter_Class(
                    this, mList_Struct.List_Data_Arr,
                    R.layout.main_list_detail,
                    new String[]{mList_Struct.List_Name_Key,mList_Struct.List_Price_Key},
                    new int[]{R.id.detail_product_name, R.id.detail_product_price},mList_Struct);
            mMain_List_View.setAdapter(mMain_List_Adapter);
        }
    }

    ///Onkeydown
    //--------------------------------------------------------------------
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        Log.d(mGCMD.TAG,"onKeyDown");
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            ConfirmExit(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void ConfirmExit (final Activity Source_Act){
        final AlertDialog.Builder ad=new AlertDialog.Builder(Source_Act);
        ad.setTitle("離開");
        ad.setMessage("確定要離開?");
        ad.setCancelable(false);
        ad.setPositiveButton("是", new DialogInterface.OnClickListener() {//退出按鈕
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int i) {
                // TODO Auto-generated method stub
                Source_Act.finishAffinity();
                System.exit(0);
            }
        });
        ad.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        ad.show();//示對話框
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Main_Index_Lin:
                mGCMD.Get_Icon_Act(this,GCMD.Main_Type.index);
                Log.d(mGCMD.TAG,"Main_Index_Lin_Click");
                break;
            case R.id.Main_Money_Lin:
                mGCMD.Get_Icon_Act(this,GCMD.Main_Type.money);
                Log.d(mGCMD.TAG,"Main_Money_Lin");
                break;
            case R.id.Main_Favorite_Lin:
                mGCMD.Get_Icon_Act(this,GCMD.Main_Type.favorite);
                Log.d(mGCMD.TAG,"Main_Favorite_Lin");
                break;
            case R.id.Main_List_Lin:
                mGCMD.Get_Icon_Act(this,GCMD.Main_Type.list);
                Log.d(mGCMD.TAG,"Main_List_Lin");
                break;
            case R.id.Main_Member_Lin:
                mGCMD.Get_Icon_Act(this,GCMD.Main_Type.memeber);
                Log.d(mGCMD.TAG,"Main_Member_Lin");
                break;
            default:
                Log.d(mGCMD.TAG,"Main_Member_Default");
                break;
        }
    }
    public class List_Adapter_Class extends SimpleAdapter {
        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public List_Struct mList_Struct;
        public List_Adapter_Class(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to,List_Struct Source_Struct) {
            super(context, data, resource, from, to);
            mList_Struct = Source_Struct;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View v = super.getView(position, convertView, parent);
            final Context context = parent.getContext();

            return v;
        }
    }
}
