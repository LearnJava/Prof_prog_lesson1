package ru.konstantin.prof_prog_lesson1.data.model

import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @field:SerializedName("text") val text: String?
)