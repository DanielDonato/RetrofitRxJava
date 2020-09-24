package com.danieldonato.retrofitrxjava.api.model

import com.google.gson.annotations.SerializedName

class CountryModel(
    @SerializedName("name")
    var countryName: String? = null,
    var capital: String? = null,
    @SerializedName("flagPNG")
    var flag: String? = null
)