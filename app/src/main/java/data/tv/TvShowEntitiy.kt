package data.tv

import android.os.Parcel
import android.os.Parcelable

data class TvShowEntity(var tvShowID: String, var title: String,
                         var director: String, var poster: Int, var age: String, var genre: String,
                          var duration: String, var rating: String, var category: String, var release_date: String,
                         var synopsis: String): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString())
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tvShowID)
        parcel.writeString(title)
        parcel.writeString(director)
        parcel.writeInt(poster)
        parcel.writeString(age)
        parcel.writeString(genre)
        parcel.writeString(duration)
        parcel.writeString(rating)
        parcel.writeString(category)
        parcel.writeString(release_date)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvShowEntity> {
        override fun createFromParcel(parcel: Parcel): TvShowEntity {
            return TvShowEntity(parcel)
        }

        override fun newArray(size: Int): Array<TvShowEntity?> {
            return arrayOfNulls(size)
        }
    }

}
