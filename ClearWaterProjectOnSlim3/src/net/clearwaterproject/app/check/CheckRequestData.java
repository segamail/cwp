package net.clearwaterproject.app.check;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import net.clearwaterproject.controller.out.JsonResultStatus;

public class CheckRequestData {

    public static String PRM_WATER_INFO_NO = "water_info_no";
    public static String PRM_CWP_USER_NO = "cwp_user_no";
    
    /**
     * jsonから変換したマップの中身に変数sの値次第でNGデータを返す
     */
    public static boolean chkJsonMap(HashMap map, String s,HttpServletResponse res) throws JSONException, IOException{
        if (map == null){
            /*登録すべきデータがないため、エラーを返す*/
            inputResultStatus(res,"ng",0,0,"登録すべきデータがありません。");
            return false;
        }
        if (s.equals(PRM_WATER_INFO_NO) && map.get(s)== null){
            inputResultStatus(res, "ng",0,0,"投稿された水辺情報の認識が出来ません。");
            return false;
        }
        if (s.equals(PRM_CWP_USER_NO) && map.get(s)== null){
            inputResultStatus(res, "ng",0,0,"投稿されたユーザーの認識が出来ません。");
            return false;
        }
        return true;
    }
    
    
    /**
     * jsonから変換したマップの中身にwater_info_id,cwp_user_idが入っているかをチェック
     * @param map
     * @param res
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public static boolean chkWaterInfoNoInJsonMap(HashMap map, HttpServletResponse res) throws JSONException, IOException{
        if (map == null){
            /*登録すべきデータがないため、エラーを返す*/
            inputResultStatus(res,"ng",0,0,"登録すべきデータがありません。");
            return false;
        }
        if (map.get(PRM_WATER_INFO_NO)== null){
            inputResultStatus(res, "ng",0,0,"投稿された水辺情報の認識が出来ません。");
            return false;
        }
        if (map.get(PRM_CWP_USER_NO)== null){
            inputResultStatus(res, "ng",0,0,"投稿されたユーザーの認識が出来ません。");
            return false;
        }
        return true;
    }
    
    private static void inputResultStatus(HttpServletResponse res, String result, int e_code, int e_type, String e_text) throws JSONException, IOException{
        JsonResultStatus jsrs = new JsonResultStatus(result,e_code,e_type,e_text);
        JSON.encode(jsrs, res.getOutputStream());
    }
    
    
}
