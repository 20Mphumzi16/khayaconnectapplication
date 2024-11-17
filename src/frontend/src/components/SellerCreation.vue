<template>
  <div>
    <NavBar @toggleSidebar="toggleSidebar" />


    <!-- Dark overlay when sidebar is open -->
    <div v-if="isSidebarOpen" class="dark-overlay" @click="toggleSidebar"></div>

    <!-- Sidebar Component -->
    <SideBarComponent :isSidebarOpen="isSidebarOpen" />

    <div class="main-content" :class="{ 'sidebar-open': isSidebarOpen }">
      <!-- Main content goes here -->
    </div>
  </div>
  <div class="form-background">

    <div class="container mt-5 p-4 theme-container rounded shadow-lg">
      <h2 class="mb-4 text-center">Seller Approval Form</h2>
      <form @submit.prevent="submitForm">
        <div class="row mb-3">
          <div class="col-md-6">
            <label for="contactPerson" class="form-label">Seller Names</label>
            <input
                type="text"
                class="form-control themed-input"
                id="contactPerson"
                v-model="form.contactPerson"
                placeholder="Enter contact person name"
            />
          </div>
          <div class="col-md-6">
            <label for="contactNumber" class="form-label">Contact Number *</label>
            <input
                type="text"
                class="form-control themed-input"
                id="contactNumber"
                v-model="form.contactNumber"
                placeholder="Enter contact number"
                required
            />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-md-6">
            <label for="businessName" class="form-label">Business Name *</label>
            <input
                type="text"
                class="form-control themed-input"
                id="businessName"
                v-model="form.businessName"
                placeholder="Please fill business name"
                required
            />
          </div>
          <div class="col-md-6">
            <label for="businessEmail" class="form-label">Business Email *</label>
            <input
                type="email"
                class="form-control themed-input"
                id="businessEmail"
                v-model="form.businessEmail"
                placeholder="yourcompany@sellsa.co.za"
                required
            />
          </div>
          <div class="col-md-6">
            <label for="businessEmail" class="form-label">Personal Email *</label>
            <input
                type="email"
                class="form-control themed-input"
                id="businessEmail"
                v-model="form.personalEmail"
                placeholder="yourcompany@sellsa.co.za"
                required
            />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-md-12">
            <label for="businessAddress" class="form-label">Business Address *</label>
            <textarea
                class="form-control themed-input"
                id="businessAddress"
                v-model="form.businessAddress"
                rows="3"
                required
            ></textarea>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-md-12">
            <label for="businessSell" class="form-label">What does your business sell? *</label>
            <input
                type="text"
                class="form-control themed-input"
                id="businessSell"
                v-model="form.businessSell"
                placeholder="Please note Sell-SA does not allow the sale of Alcohol and X-rated products"
                required
            />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-md-12">
            <label for="hearAboutUs" class="form-label">How did you hear about us?</label>
            <input
                type="text"
                class="form-control themed-input"
                id="hearAboutUs"
                v-model="form.hearAboutUs"
                placeholder="Please specify where did you hear about Sell-SA?"
            />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-md-6">
            <label for="idDocument" class="form-label">SA Identity Document</label>
            <input
                type="file"
                class="form-control themed-input"
                id="idDocument"
                @change="handleFileUpload('idDocument', $event)"
            />
            <small class="text-muted">
              Green barcode ID, ID smart-card, or SA driver's license. To earn a
              "verified store" badge, ID is required.
            </small>
          </div>
          <div class="col-md-6">
            <label for="proofOfAddress" class="form-label">Proof of Address in Your Name</label>
            <input
                type="file"
                class="form-control themed-input"
                id="proofOfAddress"
                @change="handleFileUpload('proofOfAddress', $event)"
            />
            <small class="text-muted">
              Issued in the last 3 months: Bank statement, Utility bill, etc.
              Proof of address is required to earn a "verified store" badge.
            </small>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Save Changes</button>
      </form>
    </div>
  </div>
</template>

<script>
import SideBarComponent from "@/components/SideBarComponent.vue";
import NavBar from "@/components/NavBar.vue";


export default {
  components: { NavBar, SideBarComponent},
  data() {
    return {
      form: {
        contactPerson: "",
        contactNumber: "",
        businessName: "",
        businessEmail: "",
        personalEmail: "",
        businessAddress: "",
        businessSell: "",
        hearAboutUs: "",
        idDocument: null,
        proofOfAddress: null,
      },
      isSidebarOpen: false,
    };
  },
  methods: {
    handleFileUpload(field, event) {
      this.form[field] = event.target.files[0];
    },
    submitForm() {
      console.log("Form Submitted", this.form);
      alert("Form submitted successfully!");
    },
      toggleSidebar() {
        this.isSidebarOpen = !this.isSidebarOpen; // Toggle the sidebar visibility
      },
  },
};
</script>

<style>
@import url("https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css");

/* Background for the form */
.form-background {
  background: linear-gradient(145deg, rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.2));
  backdrop-filter: blur(10px);
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* Container */
.theme-container {
  background-color: white;
  padding: 30px;
  border-radius: 10px;
}

/* Shadow Effect */
.shadow-lg {
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
}
</style>
