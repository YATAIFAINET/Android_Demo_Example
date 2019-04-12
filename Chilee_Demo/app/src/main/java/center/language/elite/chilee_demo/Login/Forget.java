package center.language.elite.chilee_demo.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import center.language.elite.chilee_demo.GCMD.GCMD;
import center.language.elite.chilee_demo.R;

public class Forget extends Activity implements View.OnClickListener {

    private GCMD mGCMD = new GCMD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        InitSetting();
    }

    //--------------------------------------------------------------------
    private void InitSetting() {
        Log.d(mGCMD.TAG,"InitSetting");
    }
    ///Onkeydown
    //--------------------------------------------------------------------
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        Log.d(mGCMD.TAG,"onKeyDown");
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Back_Login(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void Back_Login (final Activity Source_Act){
        Log.d(mGCMD.TAG,"Back_Login");

        Intent intent = new Intent();
        intent.setClass(Forget.this,Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                Log.d(mGCMD.TAG,"Main_Member_Default");
                break;
        }
    }
}
