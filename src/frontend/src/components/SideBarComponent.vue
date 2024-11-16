<template>
  <aside :class="['sidebar', { open: isSidebarOpen }]">
    <h3>Dotti Deals</h3>
    <ul>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'car']" /> Automotive</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'baby']" /> Baby & Toddler</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'bolt']" /> Backup Power & Loadshedding</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'heart']" /> Beauty</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'book']" /> Books</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'campground']" /> Camping & Outdoors</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'tshirt']" /> Clothing, Footwear & Accessories</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'tv']" /> Electronics</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'utensils']" /> Groceries & Household</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'first-aid']" /> Health & Personal Care</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'home']" /> Home & Appliances</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'wine-bottle']" /> Liquor</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'plane']" /> Luggage & Travel</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'briefcase']" /> Office & Stationery</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'paw']" /> Pets</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'football-ball']" /> Sports & Training</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'gamepad']" /> Toys</a></li>
      <li><a href="#"><font-awesome-icon :icon="['fas', 'star']" /> South African Brands</a></li>
    </ul>
  </aside>
</template>

<script>
export default {
  props: {
    isSidebarOpen: {
      type: Boolean,
      required: true,
    }
  }
};
</script>

<style scoped>
/* Sidebar styles */
.sidebar {
  background-color: #333;
  color: #fff;
  width: 250px;
  height: 100vh;
  position: fixed;
  top: 0;
  left: -250px; /* Initially hide the sidebar off-screen to the left */
  transition: transform 0.3s ease-in-out; /* Slide-in effect */
  z-index: 100;
}

/* When sidebar is open, slide it into view */
.sidebar.open {
  transform: translateX(250px); /* Slide it into view */
}

.sidebar h3 {
  padding: 15px;
  background-color: #444;
  margin: 0;
  font-size: 20px;
}

.sidebar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.sidebar ul li {
  padding: 10px 15px;
  border-bottom: 1px solid #444;
}

.sidebar ul li a {
  color: #fff;
  text-decoration: none;
  font-size: 16px;
  display: flex;
  align-items: center;
  gap: 10px;
}
</style>
