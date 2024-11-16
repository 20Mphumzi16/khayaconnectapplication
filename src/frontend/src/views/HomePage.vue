<template>
  <div>
    <NavBar @toggleSidebar="toggleSidebar" />
    <BannerComponent />

    <!-- Dark overlay when sidebar is open -->
    <div v-if="isSidebarOpen" class="dark-overlay" @click="toggleSidebar"></div>

    <!-- Sidebar Component -->
    <SideBarComponent :isSidebarOpen="isSidebarOpen" />

    <div class="main-content" :class="{ 'sidebar-open': isSidebarOpen }">
      <!-- Main content goes here -->
    </div>
  </div>
</template>

<script>
import BannerComponent from "@/components/BannerComponent.vue";
import SideBarComponent from "@/components/SideBarComponent.vue";
import NavBar from "@/components/NavBar.vue";

export default {
  name: "HomePage",
  components: {
    NavBar,
    BannerComponent,
    SideBarComponent,
  },
  data() {
    return {
      isSidebarOpen: false, // Controls the visibility of the sidebar
    };
  },
  methods: {
    toggleSidebar() {
      this.isSidebarOpen = !this.isSidebarOpen; // Toggle the sidebar visibility
    },
  },
};
</script>

<style scoped>
/* Dark overlay when sidebar is open */
.dark-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* Darken the background */
  z-index: 10;
}

/* Optional: Main content might shift to the right when sidebar is open */
.main-content.sidebar-open {
  margin-left: 250px; /* Adjust based on sidebar width */
}
</style>
