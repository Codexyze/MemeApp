import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.memeapp.Presentation.Viewmodel.MemeViewModel


@Composable
fun Screen(memeViewModel: MemeViewModel) {
    // Get the meme list and error message
    val memeList by memeViewModel.memeList
    val errorMessage by memeViewModel.errorMessage
    val context = LocalContext.current

    // Display memes if the list is not empty
    if (memeList != null && memeList!!.memes.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(memeList!!.memes) { memeItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp) // spacing between cards
                        .clickable {
                            memeViewModel.fetchAllMeme()
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = memeItem.url),
                            contentDescription = "com.example.memeapp.data.Remote.Meme Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .clickable {
                                    val message = "I love this com.example.memeapp.data.Remote.Meme! Check it out here: ${memeItem.url}"
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
                            contentScale = ContentScale.Crop // fills the frame nicely
                        )

                        Spacer(modifier = Modifier.height(12.dp))

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
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    } else if (errorMessage.isNotEmpty()) {
        // Display error message if something went wrong
        Text(text = "Error: $errorMessage", color = androidx.compose.ui.graphics.Color.Red)
    } else {
        // Show a loading indicator while data is being fetched
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
