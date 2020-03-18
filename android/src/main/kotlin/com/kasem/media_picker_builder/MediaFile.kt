package com.kasem.media_picker_builder

import org.json.JSONObject

class MediaFile(
        var id: Long,
        var albumId: Long,
        var albumName: String,
        var dateAdded: Long,
        var path: String,
        var thumbnailPath: String?,
        /**
         * The orientation for the image expressed as degrees.
         * Only degrees 0, 90, 180, 270 will work.
         * */
        var orientation: Int,
        var mimeType: String?,

        /**
         * Video duration in milliseconds
         */
        var duration: Long?,
        var type: MediaType,
        var height: Int,
        var width: Int) {

    fun toJSONObject(): JSONObject {
        return JSONObject()
                .put("id", id.toString())
                .put("dateAdded", dateAdded)
                .put("path", path)
                .put("thumbnailPath", thumbnailPath)
                .put("orientation", orientation)
                .put("mimeType", mimeType)
                .put("duration", duration)
                .put("type", type.ordinal)
                .put("height", height)
                .put("width", width)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MediaFile

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


    enum class MediaType {
        IMAGE, VIDEO
    }


}