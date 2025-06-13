package com.example.memeapp
import MemeViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import android.content.Intent
import android.widget.Toast
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

@Composable
fun LargeScreen(memeViewModel: MemeViewModel) {
    val memeList by memeViewModel.memeList
    val errorMessage by memeViewModel.errorMessage
    val context = LocalContext.current

    if (memeList != null && memeList!!.memes.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 columns for large screens
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(memeList!!.memes) { memeItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            memeViewModel.fetchAllMeme()
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Image(
                            painter = rememberImagePainter(data = memeItem.url),
                            contentDescription = "Meme Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .clickable {
                                    val message =
                                        "I love this Meme! Check it out here: ${memeItem.url}"
                                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_TEXT, message)
                                    }
                                    try {
                                        context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                                    } catch (e: Exception) {
                                        Toast.makeText(context, "Error Sharing", Toast.LENGTH_SHORT).show()
                                    }
                                },
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = memeItem.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Posted by: ${memeItem.author}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

    } else if (errorMessage.isNotEmpty()) {
        Text(
            text = "Error: $errorMessage",
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

