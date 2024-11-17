<template>
  <div class="registration-container">
    <!-- Left panel with image and highlights -->
    <div class="left-panel">
      <button class="highlight-button">Shop online for just about anything</button>
      <button class="highlight-button">Multiple payment options and secure checkout</button>
      <button class="highlight-button">Covered by our buyer protection programme</button>
      <div class="image-section"></div>
    </div>

    <!-- Right panel with the registration form -->
    <div class="form-panel">
      <h2 class="form-title">Join the Bob Shop community</h2>
      <form>
        <div class="form-row">
          <input type="text" class="form-input" placeholder="Name" />
          <input type="text" class="form-input" placeholder="Surname" />
        </div>
        <div class="form-row">
          <input type="email" class="form-input" placeholder="Email" />
          <input type="email" class="form-input" placeholder="Confirm email" />
        </div>
        <div class="form-row">
          <input type="tel" class="form-input full-width" placeholder="Mobile" />
        </div>
        <div class="form-row">
          <input type="password" class="form-input full-width" placeholder="Password" />
        </div>
        <div class="form-check">
          <input type="checkbox" id="notifications" class="form-check-input" />
          <label for="notifications" class="form-check-label">
            Notify me of Bob Shop specials and promotions.
          </label>
        </div>
        <div class="form-check">
          <input type="checkbox" id="agreement" class="form-check-input" />
          <label for="agreement" class="form-check-label">
            By creating an account, you confirm that you have read and agree to abide by our
            <a href="#" class="link">user agreement</a> and <a href="#" class="link">privacy policy</a>.
          </label>
        </div>
        <button type="submit" class="submit-button">Create account</button>
      </form>
      <p class="login-link">Already have an account? <a href="#" class="link">Log in</a></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RegistrationPage'
};
</script>

<style scoped>
.registration-container {
  display: flex;
  width: 100%;
  height: 100vh;
  font-family: 'Arial', sans-serif;
}

/* Left panel */
.left-panel {
  flex: 1;
  background-color: #f57028;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
}

.highlight-button {
  background-color: #4b3b9b;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 8px 15px;
  margin-bottom: 10px;
  width: 80%;
  text-align: left;
  font-size: 14px;
}

.image-section {
  background: url('../assets/Screenshot 2024-11-17 034101.png') no-repeat center center;
  background-size: cover;
  width: 100%;
  height: 250px;
  border-radius: 10px;
}

/* Right panel */
.form-panel {
  flex: 1;
  padding: 40px;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form-title {
  margin-bottom: 20px;
  font-size: 24px;
}

.form-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

.form-input {
  flex: 1;
  margin: 0 5px;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 2px;
  outline: none;
  font-size: 14px;
}

.form-input.full-width {
  width: calc(100% - 10px);
}

.form-check {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.form-check-input {
  margin-right: 10px;
}

.submit-button {
  background-color: #4b3b9b;
  color: #fff;
  border: none;
  padding: 10px;
  border-radius: 2px;
  width: 100%;
  cursor: pointer;
  font-size: 16px;
  margin-top: 15px;
}

.login-link {
  text-align: center;
  margin-top: 10px;
}

.link {
  color: #f57028;
  text-decoration: none;
}

.link:hover {
  text-decoration: underline;
}
</style>
