# HalalLife – Restaurants' Halal Certificate Verification App
**Developer: Ng Chai Yen
Institution: Multimedia University (MMU)
Year: 2025**

## 📱 Overview 

**HalalLife** is a mobile app that allows users to verify restaurants' halal certification status in real time using QR code scanning. It also features halal restaurant search, GPS-based location services, reviews, and reporting to JAKIM.

---

## ✨ Features

- ✅ Real-time Halal certificate verification (QR code scan)
- 📍 GPS-based halal restaurant locator
- ⭐ Add to Favourites / View recent visits
- 📝 Reviews & Ratings
- 📤 Report issues to JAKIM
- 🔒 Firebase Auth, Firestore, Storage

---

📌 Tools Used:
- Android Studio Hedgehog (Version 2023.1.1 or above)
- Kotlin Programming Language
- Jetpack Compose (for UI)
- Firebase (Authentication, Firestore, Storage)
- ZXing (QR Code Scanning)
- Google Maps API
- Emulator: Android Emulator (API Level 33+) or Physical Android Device

---

📦 How to Run:

1. Clone the GitHub Repository:
   https://github.com/NCY0602/HalalLife

2. Open with Android Studio.

3. Download Dependencies:
   - Firebase SDK will auto-sync via Gradle.
   - ZXing: Already included in build.gradle.
   - Google Services plugin already configured.

4. Add Google Services JSON:
   - Add your own `google-services.json` from Firebase Console if running new project.
   - Otherwise, clone project as-is to test (demo environment).

5. Run the App:
   - Use Android Emulator (API 33+) or real device.

---

## ⚠️ Disclaimer 

This project was developed as part of my Final Year Project at Multimedia University.  
All code and designs in this repository are my own work.
All restaurant names and data shown in this app are used for informational and demonstration purposes only.  
This app is not affiliated with, endorsed by, or officially connected to any of the mentioned restaurant brands.  
Halal status information is retrieved based on publicly available data or user-contributed reports.

---

## 📄 License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.
