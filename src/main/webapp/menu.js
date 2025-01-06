document.addEventListener('DOMContentLoaded', function() {
          const profileButton = document.getElementById('profileButton');
          const profileDropdown = document.getElementById('profileDropdown');
          let isProfileOpen = false;

          profileButton.addEventListener('click', function(e) {
              e.preventDefault();
              e.stopPropagation();
              isProfileOpen = !isProfileOpen;
              profileDropdown.classList.toggle('active', isProfileOpen);
          });

          document.addEventListener('click', function(e) {
              if (isProfileOpen && !profileDropdown.contains(e.target)) {
                  isProfileOpen = false;
                  profileDropdown.classList.remove('active');
              }
          });

          profileDropdown.addEventListener('click', function(e) {
              e.stopPropagation();
          });
      });
