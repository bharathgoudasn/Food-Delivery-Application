document.addEventListener('DOMContentLoaded', function() {
           // Search functionality
           const searchInput = document.querySelector('.search-input');
           const restaurantCards = document.querySelectorAll('.restaurant-card');

           searchInput.addEventListener('input', function(e) {
               const searchTerm = e.target.value.toLowerCase().trim();
               
               restaurantCards.forEach(card => {
                   const restaurantName = card.querySelector('.restaurant-name').textContent.toLowerCase();
                   const cuisineType = card.querySelector('.cuisine-type').textContent.toLowerCase();
                   
                   if (restaurantName.includes(searchTerm) || cuisineType.includes(searchTerm)) {
                       card.style.display = 'flex';
                   } else {
                       card.style.display = 'none';
                      
                   }
               });
           });     

           // Profile dropdown functionality
           const profileButton = document.getElementById('profileButton');
           const profileDropdown = document.getElementById('profileDropdown');
           let isProfileOpen = false;

           profileButton.addEventListener('click', function(e) {
               e.preventDefault();
               e.stopPropagation();
               isProfileOpen = !isProfileOpen;
               profileDropdown.classList.toggle('active', isProfileOpen);
           });

           // Close dropdown when clicking outside
           document.addEventListener('click', function(e) {
               if (isProfileOpen && !profileDropdown.contains(e.target)) {
                   isProfileOpen = false;
                   profileDropdown.classList.remove('active');
               }
           });

           // Prevent dropdown from closing when clicking inside it
           profileDropdown.addEventListener('click', function(e) {
               e.stopPropagation();
           });
       });