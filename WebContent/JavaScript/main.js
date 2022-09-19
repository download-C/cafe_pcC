/**
 * 
 */

const toggleBtn = document.querySelector('.togglebtn');
const menu = document.querySelector('.menu_area');
const login = document.querySelector('.login_area');

toggleBtn.addEventListener('click', () => {
  menu.classList.toggle('active');
  login.classList.toggle('active');
});