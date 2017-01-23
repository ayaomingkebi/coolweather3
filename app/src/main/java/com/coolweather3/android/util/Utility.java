package com.coolweather3.android.util;

import android.text.TextUtils;

import com.coolweather3.android.db.City;
import com.coolweather3.android.db.Country;
import com.coolweather3.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/1/22 0022.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);

                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject procinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(procinceObject.getString("name"));
                    province.setProvinceCode(procinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }

            }
            return  false;
    }
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                    JSONArray allCities = new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    Country country = new Country();
                    country.setCountyName(countyObject.getString("name"));
                    country.setWeatherId(countyObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}