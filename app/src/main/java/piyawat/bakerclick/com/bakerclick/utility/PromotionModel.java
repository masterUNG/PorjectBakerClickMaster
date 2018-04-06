package piyawat.bakerclick.com.bakerclick.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class PromotionModel implements Parcelable{

    private String nameString, urlString;

    public PromotionModel() {
    }

    public PromotionModel(String nameString, String urlString) {
        this.nameString = nameString;
        this.urlString = urlString;
    }

    protected PromotionModel(Parcel in) {
        nameString = in.readString();
        urlString = in.readString();
    }

    public static final Creator<PromotionModel> CREATOR = new Creator<PromotionModel>() {
        @Override
        public PromotionModel createFromParcel(Parcel in) {
            return new PromotionModel(in);
        }

        @Override
        public PromotionModel[] newArray(int size) {
            return new PromotionModel[size];
        }
    };

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameString);
        dest.writeString(urlString);
    }
}   // Main Class
