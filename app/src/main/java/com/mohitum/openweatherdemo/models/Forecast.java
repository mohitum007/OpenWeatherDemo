
package com.mohitum.openweatherdemo.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast implements Parcelable
{

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.mohitum.openweatherdemo.models.List> list = null;
    public final static Parcelable.Creator<Forecast> CREATOR = new Creator<Forecast>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Forecast createFromParcel(Parcel in) {
            Forecast instance = new Forecast();
            instance.city = ((City) in.readValue((City.class.getClassLoader())));
            instance.cod = ((String) in.readValue((String.class.getClassLoader())));
            instance.message = ((double) in.readValue((double.class.getClassLoader())));
            instance.cnt = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.list, (com.mohitum.openweatherdemo.models.List.class.getClassLoader()));
            return instance;
        }

        public Forecast[] newArray(int size) {
            return (new Forecast[size]);
        }

    }
    ;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.mohitum.openweatherdemo.models.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.mohitum.openweatherdemo.models.List> list) {
        this.list = list;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(city);
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
    }

    public int describeContents() {
        return  0;
    }

}
