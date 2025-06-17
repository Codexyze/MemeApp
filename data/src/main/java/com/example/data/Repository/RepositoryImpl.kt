package com.example.data.Repository

import com.example.data.Remote.MemeDto
import com.example.data.Remote.toDomain
import com.example.domain.Repository.Meme
import com.example.domain.Repository.Repository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
//
//class RepositoryImpl @Inject constructor(private val httpClient: HttpClient) : Repository {
//    override suspend fun getAllMemes(): Flow<Meme?> = flow{
//        try {
//            val memes=httpClient.get("https://meme-api.com/gimme/50").body<Meme>()
//            Log.d("Memes", memes.toString())
//            emit(memes)
//        }catch (e:Exception){
//            Log.d("Memes", e.toString())
//            emit(null)
//        }
//
//
//    }
//
//
//
//}

class RepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : Repository {
    override suspend fun getAllMemes(): Flow<Meme?> = flow {
        try {
            val memeDto = httpClient.get("https://meme-api.com/gimme/50").body<MemeDto>()
            emit(memeDto.toDomain()) // Convert to domain model
        } catch (e: Exception) {
            emit(null)
        }
    }
}



