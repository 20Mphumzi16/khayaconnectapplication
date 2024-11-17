<template>
  <div class="side-panel">
    <div class="profile-header">
      <h3>Profile</h3>
      <div class="user-info">
        <h4>Mlungisi Mbuyazi</h4>
        <p>dredger08_wipers@icloud.com</p>
      </div>
    </div>
    <ul class="menu-list">
      <li v-for="item in menuItems" :key="item.text" class="menu-item">
        <i :class="item.icon"></i>
        <span>{{ item.text }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      menuItems: [
        { icon: 'fas fa-user-circle', text: 'Account' },
        { icon: 'fas fa-history', text: 'Order history' },
        { icon: 'fas fa-tag', text: 'Messages' },
        { icon: 'fas fa-credit-card', text: 'Card payments' },
        { icon: 'fas fa-wallet', text: 'Credit Wallet' },
        { icon: 'fas fa-question-circle', text: 'Help' },
        { icon: 'fas fa-info-circle', text: 'Terms & Conditions' },
        { icon: 'fas fa-cog', text: 'Sign-Out' }
      ]
    };
  }
};
</script>

<style scoped>
.side-panel {
  background-color: #1e1e1e;
  color: #ffffff;
  width: 300px;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
}

.profile-header {
  border-bottom: 1px solid #3a3a3a;
  padding-bottom: 10px;
  margin-bottom: 20px;
}

.user-info h4 {
  margin: 5px 0;
  font-weight: bold;
}

.menu-list {
  list-style-type: none;
  padding: 0;
}

.menu-item {
  display: flex;
  align-items: center;
  padding: 10px;
  margin: 5px 0;
  border-radius: 8px;
  transition: background 0.3s;
  cursor: pointer;
}

.menu-item:hover {
  background-color: #333;
}

.menu-item i {
  font-size: 1.2em;
  margin-right: 15px;
  color: #82c0ff;
}
</style>
