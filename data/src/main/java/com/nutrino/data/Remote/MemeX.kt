package com.nutrino.data.Remote

import android.annotation.SuppressLint
import com.nutrino.domain.Repository.Meme
import com.nutrino.domain.Repository.MemeX
import kotlinx.serialization.Serializable

// :data module
@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class MemeDto(
    val count: Int = 0,
    val memes: List<MemeXDto>
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class MemeXDto(
    val author: String = "",
    val nsfw: Boolean = false,
    val postLink: String = "",
    val preview: List<String> = emptyList(),
    val spoiler: Boolean = false,
    val subreddit: String = "",
    val title: String = "",
    val ups: Int = 0,
    val url: String = ""
)


// :data module
fun MemeDto.toDomain(): Meme {
    return Meme(
        count = count,
        memes = memes.map { it.toDomain() }
    )
}

fun MemeXDto.toDomain(): MemeX {
    return MemeX(
        author = author,
        nsfw = nsfw,
        postLink = postLink,
        preview = preview,
        spoiler = spoiler,
        subreddit = subreddit,
        title = title,
        ups = ups,
        url = url
    )
}

