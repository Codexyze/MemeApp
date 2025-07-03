# 🧠 MemeApp

A clean and modern Android app built using **Kotlin**, **Jetpack Compose**, **Ktor**, and **Coil**, designed to fetch and display a fresh batch of memes using a **multi-module architecture**.

---

## 🛤️ Project Evolution

- ✅ Started as my **first Jetpack Compose project**
- 🔄 Initially built without any architecture — just pure Compose!
- 🧠 Later migrated to **MVVM** for better state handling and logic separation
- 🧱 Finally refactored to **multi-module architecture** for scalability and clean code
- 📱 Fully **optimized for tablets, split-screen, and large screens**

> Currently in **closed testing** phase — soon launching on the **Google Play Store**! 🎉

---

## 📱 UI Preview & User Flow


> 📷 Updated Screenshot with Features ↓

<img src="https://github.com/user-attachments/assets/245d6b69-e99c-4011-a624-548c335f0a27" alt="Meme App Features" width="100%"/>



### 🧭 Highlights:
- 🔁 **Click Reload** to fetch a fresh set of 50 memes
- 📤 **Click Share** to instantly send memes to friends via WhatsApp, Telegram, etc.
- 🌐 **Internet-enabled content feed** with modern Jetpack Compose layout

---

## 🚀 Features

- 🔗 **API Integration**: Fetches 50 memes using [Ktor](https://ktor.io/) from the [Meme API](https://meme-api.com/)
- ⚡ **Efficient Image Loading**: Powered by [Coil](https://coil-kt.github.io/coil/)
- 📤 **Meme Sharing**: Share memes through native Android share sheet
- 🔁 **Reload Button**: Tap to refresh the entire list of memes
- 🧠 **MVVM Architecture**: All business logic managed in ViewModel
- 🧱 **Multi-Module Codebase**: Clean separation of concerns for scalability
- 🖥️ **Responsive Layout**: Optimized for phones, tablets, foldables & split-screen

---

## 🛠️ Tech Stack

| Layer | Tech |
|-------|------|
| 🧠 Language | Kotlin |
| 🎨 UI | Jetpack Compose |
| 🌐 Networking | Ktor HTTP Client |
| 🖼️ Image Loading | Coil |
| 🧱 Architecture | MVVM + Multi-Module |
| 🔄 State | `mutableStateOf`, `viewModelScope`, Coroutines |

---

## 🧩 Module Structure

- `:app` – Jetpack Compose UI and screen logic
- `:data` – Handles all network communication using Ktor
- `:domain` – Use cases and data models

---

## License

This project is licensed under the [MIT LICENSE](LICENSE) .

## 📦 Getting Started

```bash
git clone https://github.com/Codexyze/MemeApp.git
cd MemeApp


