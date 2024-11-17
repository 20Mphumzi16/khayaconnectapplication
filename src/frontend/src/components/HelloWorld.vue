<template>
  <div class="registration-page d-flex flex-wrap">
    <!-- Left panel -->
    <div class="left-panel d-flex align-items-center">
      <div class="content-container text-center">
        <button class="info-btn">Shop online for just about anything</button>
        <button class="info-btn">Multiple payment options and secure checkout</button>
        <button class="info-btn">Covered by our buyer protection programme</button>
        <div class="image-container"></div>
      </div>
    </div>

    <!-- Right panel -->
    <div class="right-panel p-5">
      <h2 class="title">Join the Bob Shop community</h2>
      <form>
        <div class="row mb-3">
          <div class="col">
            <input type="text" class="form-control" placeholder="Name" />
          </div>
          <div class="col">
            <input type="text" class="form-control" placeholder="Surname" />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col">
            <input type="email" class="form-control" placeholder="Email" />
          </div>
          <div class="col">
            <input type="email" class="form-control" placeholder="Confirm email" />
          </div>
        </div>
        <div class="mb-3">
          <input type="tel" class="form-control" placeholder="Mobile" />
        </div>
        <div class="mb-3">
          <input type="password" class="form-control" placeholder="Password" />
        </div>
        <div class="form-check mb-2">
          <input type="checkbox" class="form-check-input" id="promotions" />
          <label class="form-check-label" for="promotions">
            Notify me of Bob Shop specials and promotions.
          </label>
        </div>
        <div class="form-check mb-4">
          <input type="checkbox" class="form-check-input" id="terms" />
          <label class="form-check-label" for="terms">
            By creating an account, you confirm that you have read and agree to abide by our
            <a href="#" class="link">user agreement</a> and <a href="#" class="link">privacy policy</a>.
          </label>
        </div>
        <button type="submit" class="btn create-account-btn">Create account</button>
      </form>
      <p class="mt-4 text-center">Already have an account? <a href="#" class="link">Log in</a></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RegistrationPage'
};
</script>

<style scoped>
.registration-page {
  display: flex;
  flex-wrap: nowrap;
  height: 100vh;
}

.left-panel {
  background-color: #f57028;
  width: 45%;
  display: flex;
  justify-content: center;
  padding: 40px;
  color: #fff;
}

.content-container {
  max-width: 80%;
}

.info-btn {
  background-color: #4b3b9b;
  color: #fff;
  border: none;
  border-radius: 25px;
  width: 100%;
  margin-bottom: 20px;
  padding: 12px 20px;
  font-weight: bold;
  font-size: 1rem;
  cursor: pointer;
}

.image-container {
  background: url('../assets/Screenshot 2024-11-17 034101.png') no-repeat center center;
  background-size: cover;
  height: 200px;
  margin-top: 20px;
  border-radius: 10px;
}

.right-panel {
  background-color: #fff;
  width: 55%;
  padding: 50px;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.title {
  color: #333;
  font-weight: 700;
  margin-bottom: 30px;
}

.create-account-btn {
  background-color: #4b3b9b;
  color: #fff;
  border: none;
  border-radius: 25px;
  width: 100%;
  padding: 12px 0;
  font-size: 1rem;
  cursor: pointer;
}

.link {
  color: #f57028;
  text-decoration: none;
}

.link:hover {
  text-decoration: underline;
}

.form-control {
  border-radius: 5px;
  border: 1px solid #ccc;
  padding: 10px;
}
</style>
