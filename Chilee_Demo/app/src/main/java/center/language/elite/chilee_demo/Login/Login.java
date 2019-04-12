package center.language.elite.chilee_demo.Login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import center.language.elite.chilee_demo.GCMD.GCMD;
import center.language.elite.chilee_demo.Main_File.Index.Main_Index;
import center.language.elite.chilee_demo.R;

public class Login extends Activity implements View.OnClickListener {

    private GCMD mGCMD = new GCMD();

    private EditText mLogin_Account_Edit;
    private EditText mLogin_Pass_Edit;
    private Button mLogin_Button;
    private Button mLogin_Regi_Button;
    private Button mLogin_Forget_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        InitSetting();
    }

    //--------------------------------------------------------------------
    private void InitSetting() {
        Log.d(mGCMD.TAG,"InitSetting");
        mLogin_Account_Edit = (EditText)findViewById(R.id.Login_Account_Edit);
        mLogin_Pass_Edit = (EditText)findViewById(R.id.Login_Pass_Edit);
        mLogin_Button = (Button)findViewById(R.id.Login_Button);
        mLogin_Regi_Button = (Button)findViewById(R.id.Login_Regi_Button);
        mLogin_Forget_Button = (Button)findViewById(R.id.Login_Forget_Button);

        mLogin_Button.setOnClickListener(this);
        mLogin_Regi_Button.setOnClickListener(this);
        mLogin_Forget_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Login_Button:
                Click_Event(GCMD.Login_Type.login);
                Log.d(mGCMD.TAG,"Login_Button");
                break;
            case R.id.Login_Regi_Button:
                Click_Event(GCMD.Login_Type.register);
                Log.d(mGCMD.TAG,"Login_Regi_Button");
                break;
            case R.id.Login_Forget_Button:
                Click_Event(GCMD.Login_Type.forget);
                Log.d(mGCMD.TAG,"Login_Forget_Button");
                break;
            default:
                Log.d(mGCMD.TAG,"Main_Member_Default");
                break;
        }
    }

    public void Click_Event (GCMD.Login_Type Source_Type) {

        Intent intent = new Intent();

        switch (Source_Type){
            case login:
                intent.setClass(Login.this,Main_Index.class);
                break;
            case register:
                intent.setClass(Login.this,Register.class);
                break;
            case forget:
                intent.setClass(Login.this,Forget.class);
                break;
            default:
                break;
        }

        startActivity(intent);
        finish();
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
        ad.setMessage("確定要離開系統嗎?");
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
}
