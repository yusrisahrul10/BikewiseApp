package id.osg3_20.bikewiseapp.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "incidents")
public class IncidentDetail implements Parcelable {

    public IncidentDetail(int mId, String title, String description, String address, String occurred_at, String updated_at, String image_url, String image_url_thumb, String type) {
        this.mId=mId;
        this.title=title;
        this.description=description;
        this.address=address;
        this.occurred_at=occurred_at;
        this.updated_at=updated_at;
        this.image_url=image_url;
        this.image_url_thumb=image_url_thumb;
        this.type=type;
    }

    @PrimaryKey(autoGenerate = true)
    public int mId;
    
    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "occurred_at")
    public String occurred_at;

    @ColumnInfo(name = "updated_at")
    public String updated_at;

    @ColumnInfo(name = "image_url")
    public String image_url;

    @ColumnInfo(name = "image_url_thumb")
    public String image_url_thumb;

    @ColumnInfo(name = "type")
    public String type;

    public int getmId() {
        return mId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getOccurred_at() { return occurred_at; }

    public String getUpdated_at() { return updated_at; }

    public String getImage_url() {
        return image_url;
    }

    public String getImage_url_thumb() {
        return image_url_thumb;
    }

    public String getType() {
        return type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.address);
        dest.writeString(this.occurred_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.image_url);
        dest.writeString(this.image_url_thumb);
        dest.writeString(this.type);
    }

    protected IncidentDetail(Parcel in) {
        this.mId = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.address = in.readString();
        this.occurred_at = in.readString();
        this.updated_at = in.readString();
        this.image_url = in.readString();
        this.image_url_thumb = in.readString();
        this.type = in.readString();
    }

    public static final Creator<IncidentDetail> CREATOR = new Creator<IncidentDetail>() {
        @Override
        public IncidentDetail createFromParcel(Parcel source) {
            return new IncidentDetail(source);
        }

        @Override
        public IncidentDetail[] newArray(int size) {
            return new IncidentDetail[size];
        }
    };
}
