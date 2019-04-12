package center.language.elite.chilee_demo.Main_File.List;

import java.util.ArrayList;
import java.util.Map;

public class List_Struct {

    public final String List_Name_Key = "List_Name_Key";
    public final String List_Price_Key = "List_Price_Key";

    public String[] Name= new String[0];
    public String[] Price= new String[0];

    public ArrayList<Map<String, Object>> List_Data_Arr = new ArrayList<Map<String, Object>>();

    public List_Struct (){
        Set_Array_Init();
    }

    public void Set_Array_Init () {

        List_Data_Arr.clear();

        this.Name = new String[]{"可樂","雪碧","檸檬紅茶","雀巢"};
        this.Price = new String[]{"10","20","15","25"};
    }
}
