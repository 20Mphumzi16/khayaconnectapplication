<template>
  <header>
    <!-- Top Section -->
    <div class="top-section">
      <div class="links">
        <a href="#"><font-awesome-icon :icon="['fas', 'blog']" /> Blog</a>
        <a href="#"><font-awesome-icon :icon="['fas', 'gift']" /> Gift </a>
        <a href="#"><font-awesome-icon :icon="['fas', 'user']" /> Vendors</a>
        <a href="#"><font-awesome-icon :icon="['fas', 'envelope']" /> Contact Us</a>
      </div>
    </div>

    <!-- Middle Section -->
    <div class="middle-section">
      <!-- Hamburger Icon -->
      <div class="hamburger-icon" @click="toggleSidebar">
        <div class="hamburger-lines"></div>
        <div class="hamburger-lines"></div>
        <div class="hamburger-lines"></div>
      </div>

      <!-- Logo -->
      <div class="logo">
        <i class="fas fa-shopping-cart"></i> DotDot
      </div>

      <!-- Search Bar -->
      <div class="search-bar">
        <input type="text" placeholder="Search products" />
        <font-awesome-icon :icon="['fas', 'search']" class="search-icon" />
      </div>

      <!-- Icons Section -->
      <div class="icons">
        <a href="#"><font-awesome-icon :icon="['fas', 'heart']" class="large-icon" /></a>
        <a href="#"><font-awesome-icon :icon="['fas', 'shopping-cart']" class="large-icon" /></a>
        <a href="#"><font-awesome-icon :icon="['fas', 'user']" class="large-icon" /></a>
      </div>
    </div>
  </header>
</template>

<script>
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

export default {
  name: "NavBar",
  components: { FontAwesomeIcon },


  methods: {
    toggleSidebar() {
      this.$emit("toggleSidebar"); // Emit the toggleSidebar event to the parent
    },
  }
};
</script>

<style scoped>
/* General Header Styling */
header {
  display: flex;
  flex-direction: column;
  background-color: #fff;
  border-bottom: 2px solid #ddd;
  font-family: Arial, sans-serif;
}

/* Top Section */
.top-section {
  background-color: #0818A8;
  color:#0818A8;
  padding: 10px 20px;
  display: flex;
  justify-content: flex-end;
}

.top-section .links a {
  color: #fff;
  text-decoration: none;
  margin-left: 15px;
  font-size: 14px;
}

.top-section .links a:hover {
  text-decoration: underline;
}

/* Middle Section */
.middle-section {
  display: flex;
  justify-content: space-between; /* Spread elements across the header */
  align-items: center;
  padding: 15px 20px;
  border-bottom: 1px solid #ddd;
  position: relative;
  width: 100%;
}

/* Hamburger Icon */
.hamburger-icon {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  height: 20px;
  cursor: pointer;
  position: absolute;
  left: 20px;
}

.hamburger-lines {
  width: 25px;
  height: 10px;
  background-color: black;
  margin: 3px 0;
}

/* Logo */
.middle-section .logo {
  font-size: 24px;
  font-weight: bold;
  color: #FFD700;
  margin-left: 50px; /* Provides space between the hamburger menu and the logo */
  margin-right: auto; /* Ensures the logo moves towards the right side */
}

/* Search Bar */
.middle-section .search-bar {
  display: flex;
  align-items: center;
  position: relative;
  width: 100%; /* Makes the search bar wider */
  max-width: 800px;
}

.middle-section .search-bar input {
  width: 100%;
  padding: 10px 35px 10px 15px; /* Right padding added for icon */
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
}

.middle-section .search-bar .search-icon {
  position: absolute;
  right: 10px;
  font-size: 16px;
  color: #aaa;
}

/* Icons Section */
.middle-section .icons {
  display: flex;
  align-items: center;
  margin-left: auto; /* Pushes the icons to the right */
  padding-right: 20px;
  margin-right: 50px/* Adds space to the right of the last icon */
}

.middle-section .icons a {
  margin-left: 20px;
  font-size: 24px; /* Increased size for the icons */
  color: #444;
  text-decoration: none;
}

.middle-section .icons a:hover {
  color: #FFD700;
}

/* Bottom Section */
.bottom-section {
  background-color: #FFD700;
  padding: 10px 20px;
}

.bottom-section nav {
  display: flex;
  justify-content: space-around;
}

.bottom-section nav a {
  color: #000;
  text-decoration: none;
  font-weight: bold;
  font-size: 14px;
}

.bottom-section nav a:hover {
  text-decoration: underline;
}
</style>
