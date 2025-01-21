# Meme App  
A simple Android app built with **Kotlin**, **Jetpack Compose**, and **Retrofit**, designed to fetch and display 50 memes from an API. It uses the **Coil** library to load images efficiently.  

---

## 📱 Screenshot  
<img src="https://github.com/user-attachments/assets/03f28e27-83bb-475b-9dd0-0cd6a2d16ce5" alt="Meme App Screenshot" width="300" />

---

## 🚀 Features  
- **API Integration**: Fetches 50 memes from the Meme API.  
- **Smooth Image Loading**: Leverages the Coil library for seamless and efficient image handling.  
- **Jetpack Compose UI**: A modern and reactive UI for better user experience.  

---

## 🛠️ Tech Stack  
- **Language**: Kotlin  
- **UI Framework**: Jetpack Compose  
- **Networking**: Retrofit  
- **Image Loading**: Coil  

---

## 🖼️ Adjusting Image Display  
To prevent oversized images, make use of Jetpack Compose's `ContentScale` options. Here's an example used in the app:  

```kotlin
AsyncImage(
    model = memeImageUrl,
    contentDescription = "Meme Image",
    modifier = Modifier
        .fillMaxWidth() // Adjust width to fit the screen
        .padding(8.dp),
    contentScale = ContentScale.Fit // Ensures the image fits within the bounds without cropping
)

