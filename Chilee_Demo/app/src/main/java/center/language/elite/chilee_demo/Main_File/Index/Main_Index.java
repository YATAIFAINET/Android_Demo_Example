package center.language.elite.chilee_demo.Main_File.Index;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import center.language.elite.chilee_demo.GCMD.GCMD;
import center.language.elite.chilee_demo.R;

public class Main_Index extends Activity implements View.OnClickListener {

    private GCMD mGCMD = new GCMD();
    private LinearLayout mMain_Index_Lin;
    private LinearLayout mMain_Money_Lin;
    private LinearLayout mMain_Favorite_Lin;
    private LinearLayout mMain_List_Lin;
    private LinearLayout mMain_Member_Lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_index);
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

        mMain_Index_Lin.setOnClickListener(this);
        mMain_Money_Lin.setOnClickListener(this);
        mMain_Favorite_Lin.setOnClickListener(this);
        mMain_List_Lin.setOnClickListener(this);
        mMain_Member_Lin.setOnClickListener(this);

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
}
