import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


@Composable
fun Screen(memeViewModel: MemeViewModel) {
    // Get the meme list and error message
    val memeList by memeViewModel.memeList
    val errorMessage by memeViewModel.errorMessage

    // Display memes if the list is not empty
    if (memeList != null && memeList!!.memes.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(memeList!!.memes) { memeItem ->
                Column {
                    Image(
                        painter = rememberImagePainter(data = memeItem.url),
                        contentDescription = "Meme Image",
                        modifier = Modifier
                            .fillMaxWidth() // Makes the image fill the width of the screen
                            .height(300.dp) // Adjust height as needed, or use dynamic values
                            .padding(8.dp), // Optional: Padding around the image
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Title: ${memeItem.title}")
                    Text(text = "Author: ${memeItem.author}")
                    Spacer(modifier = Modifier.height(16.dp))
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
