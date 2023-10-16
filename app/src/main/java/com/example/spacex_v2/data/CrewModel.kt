package com.example.spacex_v2.data


import com.google.gson.annotations.SerializedName

class CrewModel : ArrayList<CrewModel.CrewModelItem>(){
    data class CrewModelItem(
        @SerializedName("agency")
        val agency: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("launches")
        val launches: List<String>,
        @SerializedName("name")
        val name: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("wikipedia")
        val wikipedia: String
    )
}