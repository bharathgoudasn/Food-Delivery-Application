function validateForm() {
      var password = document.getElementById("password").value;
      var cpassword = document.getElementById("cpassword").value;
      var errorElement = document.getElementById("password-error");
      
      if (password !== cpassword) {
        errorElement.textContent = "Passwords do not match";
        return false;
      } else {
        errorElement.textContent = "";
        return true;
      }
    }/**
 * 
 */