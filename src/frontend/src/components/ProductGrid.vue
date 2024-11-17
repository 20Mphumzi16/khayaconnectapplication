<template>
  <div class="product-grid">
    <h2>{{ title }}</h2>
    <div class="grid">
      <ItemCard
          v-for="item in items"
          :key="item.id"
          :item="item"
          :wishlist="wishlist"
          @item-selected="handleItemSelected"
          @add-to-cart="handleAddToCart"  @toggle-wishlist="handleToggleWishlist"/>
    </div>
  </div>
</template>

<script>
import ItemCard from "@/components/ItemCard.vue";

export default {
  name: 'ProductGrid',
  components: {
   ItemCard
  },
  props: {
    title: String,
    items: Array,
    wishlist:Array
  },
  methods: {
    handleItemSelected(id) {
      this.$router.push({ name: 'view-item', params: { id } });
    },
    handleAddToCart(id) {
      this.$emit('add-to-cart', id); // Emit the SKU to the parent component
    },
    handleToggleWishlist(id) {
      this.$emit('toggle-wishlist', id);
    }
  }
};
</script>
<style scoped>
.product-grid {
  margin: 20px;
}
.grid {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 10px;
}
</style>