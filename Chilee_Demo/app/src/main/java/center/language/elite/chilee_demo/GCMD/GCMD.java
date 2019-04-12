package center.language.elite.chilee_demo.GCMD;

import android.app.Activity;
import android.content.Intent;

import center.language.elite.chilee_demo.Main_File.Favo.Main_Favorite;
import center.language.elite.chilee_demo.Main_File.Index.Main_Index;
import center.language.elite.chilee_demo.Main_File.List.Main_List;
import center.language.elite.chilee_demo.Main_File.Member.Main_Member;
import center.language.elite.chilee_demo.Main_File.Product.Main_Money;

public class GCMD {

    public enum Login_Type {
        login,register,forget
    }
    public enum Main_Type {
        index,favorite,money,list,memeber
    }

    public final static int login_id = 0;
    public final static int login_name = 1;
    public final static int login_sex = 2;
    public final static int login_phone = 3;
    public final static int login_length = 4;

    public final static String TAG = "fainet";
    private static String [] login_Data = new String[0];

    public GCMD () {
        Set_Array_Init();
    }

    public void Set_Array_Init () {

        if(login_Data.length<=0){
            login_Data = new String[login_length];
            for (int i =0 ;i <login_Data.length;i++){
                login_Data[i] = "";
            }
        }
    }
    public String Get_Data (int Source){
        String Target;
        if(login_Data.length>Source) {
            Target = login_Data[Source];
        } else {
            Target = "";
        }
        return Target;
    }

    public void Get_Icon_Act (Activity Source_Act,Main_Type Type){
        Intent intent = new Intent();
        switch (Type){
            case list:
                intent.setClass(Source_Act,Main_List.class);
                break;
            case index:
                intent.setClass(Source_Act,Main_Index.class);
                break;
            case memeber:
                intent.setClass(Source_Act,Main_Member.class);
                break;
            case money:
                intent.setClass(Source_Act,Main_Money.class);
                break;
            case favorite:
                intent.setClass(Source_Act,Main_Favorite.class);
                break;
            default:
                break;
        }
        Source_Act.startActivity(intent);
        Source_Act.finish();
    }
}
