<template>
  <div class="banner">
    <div
        v-for="(image, index) in images"
        :key="index"
        class="slide"
        :class="{ active: index === currentIndex }"
    >
      <img :src="image" alt="Product Banner" />
    </div>
    <!-- Navigation Buttons -->
    <button class="prev" @click="prevSlide"> <font-awesome-icon :icon="['fas', 'chevron-left']" /></button>
    <button class="next" @click="nextSlide"><font-awesome-icon :icon="['fas', 'chevron-right']" /></button>
  </div>
</template>

<script>
export default {
  name: "BannerComponent",
  data() {
    return {
      images: [
        "https://via.placeholder.com/1200x400?text=Product+1",
        "https://via.placeholder.com/1200x400?text=Product+2",
        "https://via.placeholder.com/1200x400?text=Product+3",
      ],
      currentIndex: 0,
    };
  },
  methods: {
    nextSlide() {
      this.currentIndex = (this.currentIndex + 1) % this.images.length;
    },
    prevSlide() {
      this.currentIndex =
          (this.currentIndex - 1 + this.images.length) % this.images.length;
    },
  },
  mounted() {
    // Auto slide every 5 seconds
    setInterval(this.nextSlide, 5000);
  },
};
</script>

<style scoped>
.banner {
  position: relative;
  width: 100%;
  height: 400px;
  overflow: hidden;
}

.slide {
  display: none;
  width: 100%;
  height: 100%;
}

.slide img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.slide.active {
  display: block;
  animation: fadeIn 1s ease-in-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

button {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(0, 0, 0, 0.5);
  border: none;
  color: #fff;
  font-size: 24px;
  padding: 10px;
  cursor: pointer;
  z-index: 10;
}

button.prev {
  left: 10px;
}

button.next {
  right: 10px;
}

button:hover {
  background-color: rgba(0, 0, 0, 0.7);
}
</style>
