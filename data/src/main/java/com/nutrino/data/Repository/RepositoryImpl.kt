package com.nutrino.data.Repository

import com.nutrino.data.Remote.MemeDto
import com.nutrino.data.Remote.toDomain
import com.nutrino.domain.Repository.Meme
import com.nutrino.domain.Repository.Repository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : Repository {
    override suspend fun getAllMemes(): Flow<Meme?> = flow {
            val memeDto = httpClient.get("https://meme-api.com/gimme/50").body<MemeDto>()
            emit(memeDto.toDomain()) // Convert to domain model
    }
}



