Berikut adalah file README untuk kode aplikasi **PengaduanMasyarakatApp** Anda:  

---

 **Aplikasi Pengaduan Masyarakat**

Aplikasi desktop berbasis **Java Swing** untuk mengelola pengaduan masyarakat. Aplikasi ini memungkinkan pengguna untuk:
- Menambahkan pengaduan dengan nama, deskripsi, dan gambar (opsional).
- Melihat daftar pengaduan dalam tabel.
- Menghapus pengaduan dari daftar.

---

 **Fitur**
1. **Tambah Pengaduan**  
   Pengguna dapat menambahkan pengaduan dengan detail berikut:
   - Nama Pengadu.
   - Deskripsi Pengaduan.
   - Gambar (opsional).  
   Jika nama atau deskripsi kosong, pengguna akan mendapatkan notifikasi error.

2. **Unggah Gambar**  
   Pengguna dapat mengunggah gambar menggunakan file chooser, dengan pratinjau gambar ditampilkan di aplikasi.

3. **Lihat Pengaduan**  
   Daftar pengaduan yang sudah ditambahkan akan ditampilkan dalam tabel.  

4. **Hapus Pengaduan**  
   Pengguna dapat memilih pengaduan dari tabel dan menghapusnya.

---

 **Teknologi yang Digunakan**
- **Java**: Versi 8 atau yang lebih baru.
- **Java Swing**: Untuk membuat antarmuka pengguna.
- **JTable**: Untuk menampilkan daftar pengaduan dalam tabel.
- **ArrayList**: Untuk menyimpan data pengaduan.

---

 **Struktur Proyek**
```plaintext
PengaduanMasyarakatApp
├── src
│   └── PengaduanMasyarakatApp.java  // File utama aplikasi
```

---

 **Cara Menjalankan Aplikasi**

1. **Prasyarat**  
   - Pastikan Anda memiliki **Java JDK 8+** terinstal di sistem Anda.  
   - Gunakan IDE seperti **IntelliJ IDEA** atau **Eclipse** untuk menjalankan aplikasi.

2. **Langkah-langkah:**
   - Clone atau unduh file sumber aplikasi.
   - Buka file `PengaduanMasyarakatApp.java` di IDE Anda.
   - Jalankan file dengan menekan tombol **Run** atau menggunakan perintah:
     ```bash
     javac PengaduanMasyarakatApp.java
     java PengaduanMasyarakatApp
     ```

3. **Penggunaan:**
   - **Tambah Pengaduan:** Isi nama, deskripsi, dan unggah gambar (opsional), lalu klik **Tambah Pengaduan**.
   - **Lihat Pengaduan:** Klik tombol **Lihat Pengaduan** untuk membuka tabel daftar pengaduan.
   - **Hapus Pengaduan:** Pilih pengaduan di tabel, lalu klik tombol **Hapus Pengaduan**.

---

 **Screenshot (Opsional)**

### **1. Halaman Tambah Pengaduan**
_Tampilan utama aplikasi saat pengguna menambahkan pengaduan._

### **2. Halaman Lihat Pengaduan**
_Tampilan tabel daftar pengaduan._

--- **Pengujian**

Aplikasi telah diuji menggunakan skenario berikut:
1. Menambahkan pengaduan dengan input lengkap (Nama, Deskripsi, Gambar).
2. Menambahkan pengaduan tanpa gambar.
3. Menampilkan semua pengaduan dalam tabel.
4. Menghapus pengaduan tertentu dari daftar.

---

 **Kontributor**
- **Nama Anda**  
  Developer aplikasi ini.

---

 **Lisensi**
Aplikasi ini dilisensikan di bawah **MIT License**. Anda bebas menggunakan dan memodifikasi aplikasi ini.  

--- 

Silakan tambahkan screenshot antarmuka jika diperlukan! 😊
 
 
