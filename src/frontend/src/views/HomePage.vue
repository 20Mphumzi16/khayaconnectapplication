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

    <!-- Corrected Conditional rendering -->
    <ProductGrid
        title="New Arrivals"
        :items="newArrivals"
    :wishlist="wishlistItems"
    @add-to-cart="addToCart"
    @toggle-wishlist="toggleWishlist"
    />
    <ProductGrid
        title="Hot Picks"
        :items="hotPicks"
    :wishlist="wishlistItems"
    @add-to-cart="addToCart"
    @toggle-wishlist="toggleWishlist"
    />
  </div>
</template>


<script>
import BannerComponent from "@/components/BannerComponent.vue";
import SideBarComponent from "@/components/SideBarComponent.vue";
import NavBar from "@/components/NavBar.vue";
import ProductGrid from "@/components/ProductGrid.vue";
import {getAllItems} from "@/service/ProductService";

export default {
  name: "HomePage",
  components: {
    NavBar,
    BannerComponent,
    SideBarComponent,
    ProductGrid,
  },
  created() {
    this.fetchItems();
  },
  data() {
    return {

      isSidebarOpen: false, // Controls the visibility of the sidebar
      newArrivals: [],
      hotPicks: [],
      allItems: [],

    }

  },


  methods: {
    toggleSidebar() {

      this.isSidebarOpen = !this.isSidebarOpen; // Toggle the sidebar visibility


    },
    async fetchItems() {
      try {
        const response = await getAllItems();
        const allItems= response.data;
        console.log('Items', allItems);

        this.newArrivals = allItems.slice(0, 4);
        this.hotPicks = allItems.slice(4, 8);


    } catch (error) {
      this.error = 'Failed to load comic books.';
      this.loading = false;
    }
    }
  },


};
</script>

<style scoped>

.dark-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 10;
}


.main-content.sidebar-open {
  margin-left: 250px;
}
</style>
